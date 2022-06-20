/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Database;

import Main.MainClass;
import View.displayvalueModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;


/**
 *
 * @author Windows 10 Version 2
 */
public class ConnectDB {
    public static String dbURL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLySanPhamCC;username=sa;password=1704;";
    Connection conn;
    public ConnectDB(){
       
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection(dbURL);
            
            if(conn != null){
                System.out.println("Kết nối CSDL SQL Server thành công!");
            }
            
        } catch (ClassNotFoundException ex) {
            System.out.println(ex.toString());
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    
    //Thực thi câu lệnh SELECT
    public ResultSet ExcuteQueryGetTable(String cauTruyVanSQL){
        try {
            Statement stmt = conn.createStatement();           
            ResultSet rs = stmt.executeQuery(cauTruyVanSQL);
            return rs;
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
            
        return null;
    }
    //Thực thi INSERT, DELETE, UPDATE
    public void ExcuteQueryUpdateDB(String cauTruyVanSQL){
       
        try {
            Statement stmt = conn.createStatement();
            stmt.executeUpdate(cauTruyVanSQL);
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
	public Vector<String> selectSearch(String table, String col, String key) {
		ResultSet rs = null;
		Vector<String> vector = new Vector<String>(100);
		String sqlcommand = "select * from ";
		PreparedStatement pst = null;

		sqlcommand = "select * from " + table + " where " + col + " like N'" + key + "%'" + " ;";
		System.out.println(sqlcommand);

		try {
			pst = conn.prepareStatement(sqlcommand);
			rs = pst.executeQuery();
			String str = new String();
			switch (table) {
				case "SanPham":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7)+ "\t" + rs.getString(8)+ "\t" + rs.getString(8));
					}
				case "NhanVien":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + CalendarAdapter.SQLDateToString(rs.getDate(3)) + "\t" + rs.getString(4)
								+ "\t" + rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7) + "\t" + rs.getString(8));
					}
				case "KhachHang":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6) + "\t" + rs.getString(7)+ "\t" + rs.getString(8));
					}
       				case "NhaCungCap":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t" 
                                                                + rs.getString(5) + "\t" + rs.getString(6));
                                        }
				case "HoaDon":
					while (rs.next()) {

						vector.add(rs.getString(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4) + "\t"
								+ rs.getString(5) + "\t" + rs.getString(6));
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
        public static DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
        String cautruyvan = "select *from " + bang;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        try {
            while (rs.next()) {
                displayvalueModel valueModel = new displayvalueModel(rs.getString(Ten), rs.getString(Ma));
                cbbmodel.addElement(valueModel);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return cbbmodel;
    }
}