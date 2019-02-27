package dao;
import java.sql.*;
import java.util.*;


public class BaseDao {

	protected Connection con = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	private final static String DRIVERNAME = "com.mysql.jdbc.Driver";
	private final static String USERNAEM = "root";
	private final static String DATABASE = "test";
	private final static String PASSWORD = "123456";

	/*
	 * 获取数据库连接
	 */
	protected void openconnection() {

		try {
			Class.forName(DRIVERNAME);
			String url = "jdbc:mysql://localhost:3306/" + DATABASE + "?user="
					+ USERNAEM + "&password=" + PASSWORD
					+ "&useUnicode=true&characterEncoding=UTF8";
			con = DriverManager.getConnection(url);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	/*
	 * 插入数据
	 */
	public int insert(String table, List<?> list) {

		int row = 0;
		StringBuffer sql = null;
		if (table.equals("time_series_data"))
			sql = new StringBuffer("insert into " + table + " values(");
		else {
			sql = new StringBuffer("insert into " + table + " values("
					+ list.get(0) + ",");
			list.remove(0);
		}
		for (int i = 0; i < list.size(); i++) {
			if (i + 1 == list.size()) {
				sql.append("?)");
				break;
			}
			sql.append("?,");
		}
		openconnection();
		try {
			ps = con.prepareStatement(sql.toString());
			for (int i = 0; i < list.size(); i++)
				ps.setObject(i + 1, list.get(i));
			row = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeResource();
		}
		return row;
	}

	
	/*
	 * 关闭资源
	 */
	protected boolean closeResource() {

		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}

