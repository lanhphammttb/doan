package frm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import frm.UserInfo;

/**
 *
 * @author PLanh
 */
public class ConnectDB {

	private static final String className = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private Connection connection;

	// kêt nối  database
	public boolean connect(String nameDatabase, String user, String pass) {
		try {
			Class.forName(className);
			String url = "jdbc:sqlserver://localhost:1433;" + nameDatabase;

			try {
				connection = DriverManager.getConnection(url, user, pass);
				System.out.println("Connect Success !!!");
				return true;
			} catch (SQLException ex) {
				String mssg = ex.getMessage();
				if (mssg.contains("Unknown database")) {
					//createDatabase(user, pass);
					return connect(nameDatabase, user, pass);
				}
				return false;
			}
		} catch (ClassNotFoundException ex) {
			System.out.println("Class not found");
			return false;
		}
	}

	// lấy dữ liệu theo cột trong bảng
	public Vector<String> select(String table, String key[]) {
		ResultSet rs = null;
		Vector<String> vector = new Vector<String>(100);
		String sqlcommand = "select * " + " from " + table;
		PreparedStatement pst = null;
		if (key == null) {
			sqlcommand = "select * " + " from " + table;
		} else {

			for (int i = 0; i < key.length; i++) {
				sqlcommand = sqlcommand + key;
				if (i < key.length - 1) {
					sqlcommand += " AND ";
				}
			}
			sqlcommand = sqlcommand + " ;";
		}
		try {
			pst = connection.prepareStatement(sqlcommand);
			rs = pst.executeQuery();
			String str = new String();
			switch (table) {
				case "phong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
					}
				case "nhanvien":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4)
								+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
					}
				case "khachhang":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
					}
				case "hoadon":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5));
					}
				case "dichvu":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));
					}
				case "chitietdichvu":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
					}
				case "datphong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(4)) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
					}
				case "chitietdatphong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2));
					}
			}
		} catch (SQLException ex) {
			System.out.println("Select error !" + ex.toString());
		}

		return vector;
	}

	/// chon ra gia tri vector co 2 cot by LE THANH LOI 
	public Vector<String> select2colLOI(String sql) {
		ResultSet rs = null;
		Vector<String> vector = new Vector<String>(100);
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				vector.add(rs.getString(1) + "\t" + rs.getString(2));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return vector;

	}
/// chon ra gia tri co 1 cot

	public String select1colLOI(String sql) {
		ResultSet rs = null;
		String str = new String();
		PreparedStatement pst = null;
		try {
			pst = connection.prepareStatement(sql);
			rs = pst.executeQuery();
			while (rs.next()) {
				str = (rs.getString(1));
			}

		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
		}
		return str;

	}

	/// Tim kiem thong tin cac bang by LE THANH LOI
	public Vector<String> selectSearch(String table, String col, String key) {
		ResultSet rs = null;
		Vector<String> vector = new Vector<String>(100);
		String sqlcommand = "select * from ";
		PreparedStatement pst = null;

		sqlcommand = "select * from " + table + " where " + col + " like '" + key + "%'" + " ;";
		System.out.println(sqlcommand);

		try {
			pst = connection.prepareStatement(sqlcommand);
			rs = pst.executeQuery();
			String str = new String();
			switch (table) {
				case "phong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
					}
				case "nhanvien":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4)
								+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
					}
				case "khachhang":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
					}
				case "hoadon":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5));
					}
				case "dichvu":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getDouble(3) + "\t" + rs.getString(4));
					}
				case "chitietdichvu":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
					}
				case "datphong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(4)) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7));
					}
				case "chitietdatphong":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2));
					}
			}
		} catch (SQLException ex) {
			System.out.println("Select error !" + ex.toString());
		}

		return vector;
	}

	// In ra man hinh vector
	public void print(Vector<String> vector) {
		for (String s : vector) {
			System.out.println(s);
		}
	}

	//  insert values vao trong table
	public boolean insert(String table, String[] values) {

		try {

			String sqlcommand = "insert into " + table;
			PreparedStatement pst = null;
			System.out.println(sqlcommand);

			if (table.equals("phong")) {
				sqlcommand = sqlcommand + " values(" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "');";
			} else if (table.equals("nhanvien")) {
				if (values[2].equals("")) {
					values[2] = "null";
				} else {
					values[2] = "STR_TO_DATE(" + "'" + values[2] + "'," + "'%d-%m-%Y')";
				}
				sqlcommand = sqlcommand + " values(" + "'" + values[0] + "','" + values[1] + "'," + values[2] + ",'" + values[3] + "','" + values[4] + "','" + values[5] + "','" + values[6] + "','" + values[7] + "');";
			} else if (table.equals("khachhang")) {
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "','" + values[4] + "','" + values[5] + "','" + values[6] + "');";
			} else if (table.equals("hoadon")) {
				if (values[2].equals("")) {
					values[2] = "null";
				} else {
					values[2] = "STR_TO_DATE(" + "'" + values[2] + "'," + "'%d-%m-%Y')";
				}
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "'," + values[2] + "," + values[3] + "," + values[4] + ");";
			} else if (table.equals("dichvu")) {
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "');";
			} else if (table.equals("datphong")) {
				if (values[2].equals("")) {
					values[2] = "null";
				} else {
					values[2] = "STR_TO_DATE(" + "'" + values[2] + "'," + "'%d-%m-%Y')";
				}
				if (values[3].equals("")) {
					values[3] = "null";
				} else {
					values[3] = "STR_TO_DATE(" + "'" + values[3] + "'," + "'%d-%m-%Y')";
				}
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "'," + values[2] + "," + values[3] + ",'" + values[4] + "','"
						+ values[5] + "','" + values[6] + "');";
			} else if (table.equals("chitietdichvu")) {
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "','" + values[2] + "','" + values[3] + "');";
			} else if (table.equals("chitietdatphong")) {
				sqlcommand = sqlcommand + " values (" + "'" + values[0] + "','" + values[1] + "');";
			}
			System.out.println(sqlcommand);
			pst = connection.prepareStatement(sqlcommand);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}

	//xoa column co gia tri la key trong bang table
	public boolean delete(String table, String column, String key) {
		try {

			String sqlcommand = " delete from " + table + " where " + column + " ='" + key + "';";
			PreparedStatement pst = null;
			System.out.println(sqlcommand);

			pst = connection.prepareStatement(sqlcommand);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}

	public boolean delete(String table, String column1, String key1, String column2, String key2) {
		try {

			String sqlcommand = " delete from " + table + " where " + column1 + " ='" + key1 + "' AND " + column2 + " ='" + key2 + "';";
			PreparedStatement pst = null;
			System.out.println(sqlcommand);

			pst = connection.prepareStatement(sqlcommand);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}

	//Update trong bang table nhung record co column= key
	public boolean update(String table, String[] values, String key) {
		try {

			String sqlcommand = " update " + table + " set ";
			PreparedStatement pst = null;

			for (int i = 0; i < values.length; i++) {
				sqlcommand += values[i];
				if (i < values.length - 1) {
					sqlcommand += ",";
				}
			}
			sqlcommand += " where " + key + ";";
			System.out.println(sqlcommand);

			pst = connection.prepareStatement(sqlcommand);
			pst.executeUpdate();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
			return false;
		}
		return true;
	}

	public static boolean changePass(String user, String pass, String new_pass) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(className);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khachsan", user, pass);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			String q = "SET PASSWORD FOR " + "'" + user + "'" + " = " + "'" + new_pass + "';";
			stmt.executeUpdate(q);
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			return false;
		}
		return true;
	}

	public static void deleteUser(String user) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(className);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:1433/khachsan", UserInfo.username, UserInfo.password);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			String q = "DROP USER IF EXISTS " + "'" + user + "';";
			stmt.executeUpdate(q);
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void createUser(String user, String pass, boolean admin) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(className);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khachsan", UserInfo.username, UserInfo.password);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			String q = "CREATE USER " + "'" + user + "'" + " IDENTIFIED BY " + "'" + pass + "';";
			stmt.executeUpdate(q);
			if (admin) {
				grantAdmin(stmt, user, pass);
			} else {
				grantStd(stmt, user, pass);
			}
			stmt.close();
			conn.commit();
			conn.close();
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static boolean changePrivilige(String user, boolean admin) {
		Connection conn = null;
		Statement stmt = null;

		try {
			Class.forName(className);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/khachsan", UserInfo.username, UserInfo.password);
			conn.setAutoCommit(false);
			stmt = conn.createStatement();

			if (admin) {
				stmt.execute("GRANT ALL ON khachsan.nhanvien TO " + "'" + user + "'");
			} else {
				stmt.execute("REVOKE ALL ON khachsan.nhanvien FROM " + "'" + user + "'");
			}
			stmt.close();
			conn.commit();
			conn.close();
			return true;
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();
			return false;
		}
	}

	public static void grantAdmin(Statement stmt, String user, String pass) throws SQLException {
		String q = "GRANT ALL ON khachsan.* TO " + "'" + user + "'";
		stmt.execute(q);
	}

	public static void grantStd(Statement stmt, String user, String pass) throws SQLException {
		String q = "GRANT ALL ON khachsan.phong TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.khachhang TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.dichvu TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.chitietdichvu TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.hoadon TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.datphong TO " + "'" + user + "'";
		stmt.execute(q);
		q = "GRANT ALL ON khachsan.chitietdatphong TO " + "'" + user + "'";
		stmt.execute(q);
	}

	public void close() {
		try {
			connection.close();
		} catch (SQLException ex) {
			Logger.getLogger(ConnectDB.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

//        public Vector<String> TimKiem(String table, String key){
//            
//        }
	public static void main(String[] args) {
		ConnectDB con = new ConnectDB();
		con.connect("QuanLySanPham", "sa", "1704");
	}
}
