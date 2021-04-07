package application.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import application.DBConnection;
import application.Session;
import application.controller.BoardButtonMainController;
import application.controller.WriteReViewController;
import application.vo.MemberVO;

public class MemberDAO {

	private Statement stmt;
	private ResultSet rs;

	public static boolean login(MemberVO data) {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		Session session = new Session();

		String runSP = "{ call pack_login.select_member_login_proc(?, ?, ?, ?, ? ,? ,?) }";

		try {
			conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			conn.setAutoCommit(false);

			callableStatement.setString(1, data.getMemberId());
			callableStatement.setString(2, data.getMemberPw());
			callableStatement.setString(3, data.getOwner());
			callableStatement.registerOutParameter(4, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(5, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(6, java.sql.Types.VARCHAR);
			callableStatement.registerOutParameter(7, java.sql.Types.NUMERIC);

			try {
				callableStatement.executeQuery();

				Session.setSessionId(data.getMemberId());
				Session.setSessionNickName(callableStatement.getString(4));

				System.out.println(callableStatement.getString(4));

				WriteReViewController.setSessionNickname(callableStatement.getString(4));

				BoardButtonMainController.name = callableStatement.getString(5) + callableStatement.getString(6);
				BoardButtonMainController.age = callableStatement.getInt(7) + "세";
				BoardButtonMainController.nickname = callableStatement.getString(4);

				WriteReViewController.id = data.getMemberId();

				return true;

			} catch (SQLException e) {
				System.out.println("로그인 프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public String customerSignup(Connection conn, MemberVO data) {

		String nickname = null;
		String runSP = "{ call pack_signup_pkg.sign_up_customer(?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			conn.setAutoCommit(false);

			callableStatement.setString(1, data.getMemberId());
			callableStatement.setString(2, data.getMemberPw());
			callableStatement.setString(3, data.getMemberLastName());
			callableStatement.setString(4, data.getMemberFirstName());
			callableStatement.setInt(5, data.getMemberAge());
			callableStatement.setString(6, data.getMemberNickName());
			callableStatement.setString(7, data.getOwner());
			callableStatement.registerOutParameter(8, java.sql.Types.VARCHAR);

			try {
				callableStatement.executeQuery();
				nickname = callableStatement.getString(1);
			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nickname;
	}

	public static boolean masterSignup(MemberVO data, String location, String restaurantname, String restaurantcategory)
			throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		String runSP = "{ call pack_signup_pkg.insert_member_new_owner_proc(?, ?, ?, ?, ?, ?, ?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			conn.setAutoCommit(false);

			callableStatement.setString(1, data.getMemberId());
			callableStatement.setString(2, data.getMemberPw());
			callableStatement.setString(3, data.getMemberLastName());
			callableStatement.setString(4, data.getMemberFirstName());
			callableStatement.setInt(5, data.getMemberAge());
			callableStatement.setString(6, data.getMemberNickName());
			callableStatement.setString(7, data.getOwner());
			callableStatement.setString(8, location);
			callableStatement.setString(9, restaurantname);
			callableStatement.setString(10, restaurantcategory);

			try {
				callableStatement.executeQuery();
				return true;
			} catch (SQLException e) {
				System.out.println("회원가입 프로시저에서 에러 발생!");
				// System.err.format("SQL State: %s", e.getSQLState());
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}