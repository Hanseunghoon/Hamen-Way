package application.dao;

import java.sql.Array;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import oracle.jdbc.OracleTypes;
import application.vo.MenuVO;
import application.vo.RestaurantVO;

public class RestaurantDAO {

	private Statement stmt;
	private ResultSet rs;

	public ArrayList<RestaurantVO> list(Connection conn) {
		ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();
		try {
			String query = "select * from restaurant";
			System.out.println(query);
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				int restaurantNo = rs.getInt("No");
				String restaurantLocation = rs.getString("Location");
				String restaurantCategory = rs.getString("Category");
				String restaurantName = rs.getString("Name");

				RestaurantVO data = new RestaurantVO();

				data.setRestaurantNo(restaurantNo);
				data.setRestaurantName(restaurantName);
				data.setRestaurantLocation(restaurantLocation);
				data.setRestaurantCategory(restaurantCategory);

				list.add(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	// 룰렛 결과에 따른 메뉴를 가지는 식당 top10 출력!
	public ArrayList<RestaurantVO> getRestaurantTop10(Connection conn, String category) {

		ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();

		String runSP = "{ call pack_restaurant_pkg.get_menu_top(?, ?) }";

		try {
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, category);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
					int rno = rs.getInt(1);
					String rlocation = rs.getString(2);
					String rcate = rs.getString(3);
					String rname = rs.getString(4);
					double rrating = rs.getDouble(5);
					String rmember_id = rs.getString(6);

					RestaurantVO data = new RestaurantVO();

					data.setRestaurantName(rname);
					data.setRestaurantLocation(rlocation);
					data.setRestaurantRating(rrating);

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

	// 위치에 따른 근처 식당 top10 출력!
	public ArrayList<RestaurantVO> getRestaurantLoc10(Connection conn, String location) {

		ArrayList<RestaurantVO> list = new ArrayList<RestaurantVO>();

		String runSP = "{ call pack_restaurant_pkg.get_menu_loc(?, ?) }";

		try {
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, location);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);

			try {
				callableStatement.execute();
				ResultSet rs = (ResultSet) callableStatement.getObject(2);

				while (rs.next()) {
					int rno = rs.getInt(1);
					String rlocation = rs.getString(2);
					String rcate = rs.getString(3);
					String rname = rs.getString(4);
					double rrating = rs.getDouble(5);
					String rmember_id = rs.getString(6);

					RestaurantVO data = new RestaurantVO();

					data.setRestaurantName(rname);
					data.setRestaurantLocation(rlocation);
					data.setRestaurantRating(rrating);

//						System.out.println(rname + "/" + rlocation + "/" + rrating);

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

	// 클릭한 식당에 대한 정보 보여주기
	public RestaurantVO getRestaurantInfo(Connection conn, String restaurantName) {

		RestaurantVO data = new RestaurantVO();

		String runSP = "{ call pack_restaurant_pkg.get_restaurant_info(?, ?, ? ,? ,?) }";

		try {
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.setString(1, restaurantName);
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(3, java.sql.Types.DOUBLE);
			callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);

			try {
				callableStatement.execute();

				String rname = callableStatement.getString(2);
				double rrating = callableStatement.getDouble(3);
				String rcate = callableStatement.getString(4);
				String rloc = callableStatement.getString(5);

				data.setRestaurantName(rname);
				data.setRestaurantLocation(rloc);
				data.setRestaurantRating(rrating);
				data.setRestaurantCategory(rcate);

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data;
	}
}
