package Controller;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import static Main.MainClass.dbURL;
import Model.SanPham;

public class CSanPham{

    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;

    //1. lay nguon
    public static List<SanPham> LayNguonNV(String sMaSanPham) {
        List<SanPham> arr = new ArrayList<>();
        conn = null;
        state = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = " select * From SanPham ";
            if (sMaSanPham.equals("") == false) {
                sql = sql + " Where SanPham.MaSanPham = N'" + sMaSanPham + "'";    //phải có N k lỗi
            }
            sql = sql + " Order by MaSanPham ";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                SanPham temp = new SanPham();                
                temp.setMaSanPham(rs.getString("MaSanPham"));
                temp.setTenSanPham(rs.getString("TenSanPham"));
                temp.setLoaiSanPham(rs.getString("LoaiSanPham"));
                temp.setHangSanXuat(rs.getString("HangSanXuat"));
                temp.setGiaNhap(rs.getString("GiaNhap"));
                temp.setGiaBan(rs.getString("GiaBan"));
                temp.setDonViTinh(rs.getString("DonViTinh"));
                arr.add(temp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arr;
    }
    //2.them tai khoan

    public static void ThemMoi(SanPham tk) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into SanPham(MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, DonViTinh) values(?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSanPham());
            pstate.setString(2, tk.getTenSanPham());
            pstate.setString(3, tk.getLoaiSanPham());
            pstate.setString(4, tk.getHangSanXuat());
            pstate.setString(5, tk.getGiaNhap());
            pstate.setString(6, tk.getGiaBan());
            pstate.setString(7, tk.getDonViTinh());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //3.cap nhat tai khoan
    public static void CapNhat(SanPham tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update SanPham Set MaSanPham =?, TenSanPham =?, LoaiSanPham =?, HangSanXuat =?, GiaNhap =?, GiaBan =?, DonViTinh =? Where MaSanPham=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSanPham());
            pstate.setString(2, tk.getTenSanPham());
            pstate.setString(3, tk.getLoaiSanPham());
            pstate.setString(4, tk.getHangSanXuat());
            pstate.setString(5, tk.getGiaNhap());
            pstate.setString(6, tk.getGiaBan());
            pstate.setString(7, tk.getDonViTinh());
            pstate.setString(8, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //4.xoa tai khoan
    public static void XoaBo(String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Delete From SanPham Where MaSanPham =?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void DoiMatKhau(SanPham tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update SanPham Set MaSanPham =?, TenSanPham =?, LoaiSanPham =?, HangSanXuat =?, GiaNhap =?, GiaBan =?, DonViTinh =? Where MaSanPham=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaSanPham());
            pstate.setString(2, tk.getTenSanPham());
            pstate.setString(3, tk.getLoaiSanPham());
            pstate.setString(4, tk.getHangSanXuat());
            pstate.setString(5, tk.getGiaNhap());
            pstate.setString(6, tk.getGiaBan());
            pstate.setString(7, tk.getDonViTinh());
            pstate.setString(8, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CSanPham.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}