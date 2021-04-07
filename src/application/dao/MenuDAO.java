package application.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;

import application.DBConnection;
import application.Session;
import application.vo.MenuVO;
import application.vo.RestaurantVO;
import oracle.jdbc.OracleTypes;

public class MenuDAO {

	private Statement stmt;
	private ResultSet rs;

	// 랜덤 메뉴 카테고리 룰렛 결과 반환
	public static String rouletteplay(Connection conn, String restaurantName) {

		String runSP = "{ call pack_roulette.select_menu_random_proc(?, ?) }";
		String res= "";

		try {
			conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			conn.setAutoCommit(false);

			System.out.println(Session.getSessionId());
			callableStatement.setString(1, Session.getSessionId());
			callableStatement.registerOutParameter(2, java.sql.Types.VARCHAR);

			try {
				callableStatement.executeQuery();

				res = callableStatement.getString(2);

			} catch (SQLException e) {
				System.out.println("프로시저에서 에러 발생!");
				System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
			}
			
		} catch (SQLException e) {
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		
		return res;
	}

	// 클릭한 식당의 모든 메뉴 보여주기
	public ArrayList<MenuVO> getMenuList(Connection conn, String restaurantName) {
		
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();

		String runSP = "{ ? = call pack_restaurant_pkg.get_menu_list(?) }";

		try {
			CallableStatement callableStatement = conn.prepareCall(runSP);

			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);
			callableStatement.setString(2, restaurantName);

			try {
				callableStatement.execute();					
				ResultSet rs = (ResultSet) callableStatement.getObject(1);
				
				while (rs.next()) {
					String mname = rs.getString(2);
					System.out.println(mname);

					MenuVO data = new MenuVO();

					data.setMenuName(mname);
	
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
	
	// 클릭한 식당의 모든 메뉴 보여주기
	public ArrayList<MenuVO> getCategoryList(Connection conn) {
		
		ArrayList<MenuVO> list = new ArrayList<MenuVO>();

		String runSP = "{ call pack_restaurant_pkg.get_category_list(?) }";

		try {
			CallableStatement callableStatement = conn.prepareCall(runSP);
			callableStatement.registerOutParameter(1, OracleTypes.CURSOR);

			try {
				callableStatement.execute();					
				ResultSet rs = (ResultSet) callableStatement.getObject(1);
				
				while (rs.next()) {
					String cate = rs.getString(1);
//					System.out.println(cate);

					MenuVO data = new MenuVO();

					data.setMenuCategory(cate);
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
	
	public static void insertMenu(MenuVO data) {

		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;

		String runSP = "{ call pack_signup_pkg.insert_menu_new_menu_proc(?, ?, ?, ?) }";

		try {
			conn = DBConnection.getConnection();
			CallableStatement callableStatement = conn.prepareCall(runSP);
			conn.setAutoCommit(false);

			callableStatement.setString(1, data.getMenuName());
			callableStatement.setInt(2, data.getMenuPrice());
			callableStatement.setString(3, data.getMenuCategory());
			callableStatement.setInt(4, 0);

			callableStatement.execute();

		} catch (SQLException e) {
			System.out.println("프로시저에서 에러 발생!");
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		}

	}
}
