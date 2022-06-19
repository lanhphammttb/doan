/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import View.FrameLogin;
import View.FrameMain;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author huy
 */
public class MainClass {
    public static  View.FrameMain frmMain=new FrameMain();
    public static Database.ConnectDB connection = new  Database.ConnectDB ();
    public static String dbURL="jdbc:sqlserver://localhost:1433;databaseName=QuanLySanPhamX;username=sa;password=1704";
    public static String UN ,PW ;
    public static void main(String[] args) {
       View.FrameLogin frmLogin= new View.FrameLogin(); 
       frmLogin.show();
        frmMain.setLocationRelativeTo(null);
        frmMain.setVisible(true);
    }   
}
