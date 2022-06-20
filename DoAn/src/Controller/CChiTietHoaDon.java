package Controller;

import static Controller.CNhanVien.pstate;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Model.ChiTietHoaDon;
import static Database.ConnectDB.dbURL;

public class CChiTietHoaDon {
    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;
    //1. lay nguon
//    public static List<ChiTietHoaDon> LayNguonCTHD(String sMaCTHD){
//        List<ChiTietHoaDon> arr2 = new ArrayList<>();
//         conn = null;
//         state = null;
//        
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = "select * From ChiTietHoaDon ";
//            if(sMaCTHD.equals("")==false)
//                sql = sql + " Where ChiTietHoaDon.MaCTHD = " + sMaCTHD;
//            sql = sql + " Order by MaCTHD ";
//            state =conn.createStatement();
//             rs = state.executeQuery(sql);
//            while(rs.next()){
//                ChiTietHoaDon temp = new ChiTietHoaDon();
//                temp.setMaCTHD(rs.getString("MaCTHD"));
//                temp.setMaHoaDon(rs.getString("MaHoaDon"));
//                temp.setMaSanPham(rs.getString("MaSanPham"));
//                temp.setSoLuong(rs.getString("SoLuong"));
//                temp.setTongTien(rs.getString("TongTien"));
//                temp.setGhiChu(rs.getString("GhiChu"));
//                arr2.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr2;
//    }
    //lay du lieu toan bo chi tiet hoa don
//    public static List<ChiTietHoaDon> LayDuLieuChiTietHoaDon(String sMaHoaDon){
//        List<ChiTietHoaDon> arr = new ArrayList<>();
//         conn = null;
//         state = null;
//        
//        try {
//            conn = DriverManager.getConnection(dbURL);
//            sql = "select MaCTHD,MaHoaDon,SanPham.TenSanPham,SoLuong,TongTien,ChiTietHoaDon.GhiChu from ChiTietHoaDon,SanPham where ChiTietHoaDon.MaSanPham=SanPham.MaSanPham  and MaHoaDon=" + sMaHoaDon;
//            state =conn.createStatement();
//            rs = state.executeQuery(sql);
//            while(rs.next()){
//                ChiTietHoaDon temp = new ChiTietHoaDon();
//                temp.setMaCTHD(rs.getString("MaCTHD"));
//                temp.setMaHoaDon(rs.getString("MaHoaDon"));
//                temp.setMaSanPham(rs.getString("MaSanPham"));
//                temp.setSoLuong(rs.getString("SoLuong"));
//                temp.setTongTien(rs.getString("TongTien"));
//                temp.setGhiChu(rs.getString("GhiChu"));
//                arr.add(temp);
//            }
//            state.close();
//            conn.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        finally{
//            if(state!=null){
//                try {
//                    state.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException ex) {
//                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
//                }
//            }
//        }
//        return arr;
//    }
           //2.them tai khoan
    public static void ThemMoi(ChiTietHoaDon cn){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into ChiTietHoaDon(MaHoaDon, MaSanPham, SoLuong, TongTien, GhiChu) values(?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, cn.getMaHoaDon());
            pstate.setString(2, cn.getMaSanPham());
            pstate.setString(3, cn.getSoLuong());
            pstate.setString(4, cn.getTongTien());
            pstate.setString(5, cn.getGhiChu());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
    //3.cap nhat tai khoan
    public static void CapNhat(ChiTietHoaDon cn, String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update ChiTietHoaDon Set MaHoaDon = ?, MaSanPham =?, SoLuong = ?, TongTien = ?, GhiChu =? Where MaCTHD=?";
            pstate = conn.prepareStatement(sql);
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, cn.getMaHoaDon());
            pstate.setString(2, cn.getMaSanPham());
            pstate.setString(3, cn.getSoLuong());
            pstate.setString(4, cn.getTongTien());
            pstate.setString(5, cn.getGhiChu());
            pstate.setString(6, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } 
    }
    //4.xoa tai khoan
    public static void XoaBo(String macu){
        conn = null;
        pstate = null;
        
        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Delete From ChiTietHoaDon Where MaCTHD =?";
            pstate= conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();   
        } catch (SQLException ex) {
            Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            if(pstate!=null){
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CChiTietHoaDon.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }   
    }            
}
