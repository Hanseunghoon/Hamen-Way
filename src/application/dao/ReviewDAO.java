package application.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.Session;
import application.vo.ReviewVO;
import oracle.jdbc.OracleTypes;

public class ReviewDAO {

	private Statement stmt;
	private ResultSet rs;

	// 리뷰 쓰기
	public static void enrollReview(Connection conn, String comment, double rating, String menuName, String id)
			throws SQLException {

		String runSP = "{ call pack_review_pkg.enroll_review(?, ?, ?, ?) }";

		try {

			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, comment);
			callableStatement.setDouble(2, rating);
			callableStatement.setString(3, menuName);
			callableStatement.setString(4, id);

			callableStatement.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// 해당 식당에 대한 최신 리뷰 10개 가져오기
	public ArrayList<ReviewVO> getRestaurantTopReview(Connection conn, String restaurantName) throws SQLException {

		ArrayList<ReviewVO> list = new ArrayList<ReviewVO>();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");

		String runSP = "{ call pack_review_pkg.get_res_top_review(?, ?) }";

		try {

			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, restaurantName);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
					String nn = rs.getString(1);
					String comment = rs.getString(2);
					String writtenDate = sdf.format(rs.getDate(3).getTime());
					int rating = rs.getInt(4);
					String id = rs.getString(5);

					ReviewVO data = new ReviewVO();

					System.out.println(id + " / " + comment + " / " + rating);

					data.setMemberNickName(nn);
					data.setReviewMemberId(id);
					data.setReviewComment(comment);
					data.setReviewWriteDate(writtenDate);
					data.setReviewTasteRating(rating);

					list.add(data);
				}

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}

	// 해당 식당의 리뷰 별점 개수
	public ArrayList<Integer> getCountReviewRating(Connection conn, String restaurantName) throws SQLException {

		ArrayList<Integer> list = new ArrayList<Integer>();

		String runSP = "{ call pack_review_pkg.get_count_review_rating(?, ?) }";

		try {

			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, restaurantName);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
//					int rating = rs.getInt(1);
					int cnt = rs.getInt(2);

					list.add(cnt);
				}

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return list;
	}
}