package Main;

import View.FrameLogin;
import View.FrameMain;


public class MainClass {
    public static View.FrameMain frmMain=new FrameMain();
    public static Database.ConnectDB connection = new  Database.ConnectDB ();
//    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=QuanLySanPhamZ;username=sa;password=1704";
    public static String UN ,PW ;
    public static void main(String[] args) {
       FrameLogin frmLogin= new FrameLogin(); 
       frmLogin.show();
       frmLogin.setLocationRelativeTo(null);
       frmLogin.setVisible(true);
    } 
}
