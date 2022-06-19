package Controller;

import Model.NhanVien;
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

public class CNhanVien{

    public static String sql;
    public static Connection conn;
    public static Statement state;
    public static ResultSet rs;
    public static PreparedStatement pstate;

    //1. lay nguon
    public static List<NhanVien> LayNguonNV(String sMaNhanVien) {
        List<NhanVien> arr = new ArrayList<>();
        conn = null;
        state = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = " select * From NhanVien ";
            if (sMaNhanVien.equals("") == false) {
                sql = sql + " Where NhanVien.MaNhanVien = N'" + sMaNhanVien + "'";    //phải có N k lỗi
            }
            sql = sql + " Order by MaNhanVien ";
            state = conn.createStatement();
            rs = state.executeQuery(sql);
            while (rs.next()) {
                NhanVien temp = new NhanVien();
                temp.setMaNhanVien(rs.getString("MaNhanVien"));
                temp.setTenNhanVien(rs.getString("TenNhanVien"));
                temp.setNgaySinh(rs.getString("NgaySinh"));
                temp.setGioiTinh(rs.getString("GioiTinh"));
                temp.setNgayVaoLam(rs.getString("NgayVaoLam"));
                temp.setChucVu (rs.getString("ChucVu"));
                temp.setDiaChi(rs.getString("DiaChi"));
                temp.setSoDT(rs.getString("SoDT"));
                temp.setGhiChu(rs.getString("GhiChu"));
                arr.add(temp);
            }
            state.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (state != null) {
                try {
                    state.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return arr;
    }
    //2.them tai khoan

    public static void ThemMoi(NhanVien tk) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Insert into NhanVien(MaNhanVien, TenNhanVien, NgaySinh, GioiTinh, NgayVaoLam, ChucVu, DiaChi, SoDT, GhiChu) values(?,?,?,?,?,?,?,?,?)";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNhanVien());
            pstate.setString(2, tk.getTenNhanVien());
            pstate.setString(3, tk.getNgaySinh());
            pstate.setString(4, tk.getGioiTinh());
            pstate.setString(5, tk.getNgayVaoLam());
            pstate.setString(6, tk.getChucVu());
            pstate.setString(7, tk.getDiaChi());
            pstate.setString(8, tk.getSoDT());
            pstate.setString(9, tk.getGhiChu());
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    //3.cap nhat tai khoan
    public static void CapNhat(NhanVien tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update NhanVien Set MaNhanVien =?, TenNhanVien =?, NgaySinh =?, GioiTinh =?, NgayVaoLam =?, ChucVu =?, DiaChi =?, SoDT =?, GhiChu =? Where MaNhanVien=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNhanVien());
            pstate.setString(2, tk.getTenNhanVien());
            pstate.setString(3, tk.getNgaySinh());
            pstate.setString(4, tk.getGioiTinh());
            pstate.setString(5, tk.getNgayVaoLam());
            pstate.setString(6, tk.getChucVu());
            pstate.setString(7, tk.getDiaChi());
            pstate.setString(8, tk.getSoDT());
            pstate.setString(9, tk.getGhiChu());
            pstate.setString(10, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
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
            sql = "Delete From NhanVien Where MaNhanVien =?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public static void DoiMatKhau(NhanVien tk, String macu) {
        conn = null;
        pstate = null;

        try {
            conn = DriverManager.getConnection(dbURL);
            sql = "Update NhanVien Set MaNhanVien =?, TenNhanVien =?, NgaySinh =?, GioiTinh =?, NgayVaoLam =?, ChucVu =?, DiaChi =?, SoDT =?, GhiChu =? Where MaNhanVien=?";
            pstate = conn.prepareStatement(sql);
            pstate.setString(1, tk.getMaNhanVien());
            pstate.setString(2, tk.getTenNhanVien());
            pstate.setString(3, tk.getNgaySinh());
            pstate.setString(4, tk.getGioiTinh());
            pstate.setString(5, tk.getNgayVaoLam());
            pstate.setString(6, tk.getChucVu());
            pstate.setString(7, tk.getDiaChi());
            pstate.setString(8, tk.getSoDT());
            pstate.setString(9, tk.getGhiChu());
            pstate.setString(10, macu);
            pstate.execute();
            pstate.close();
            conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (pstate != null) {
                try {
                    pstate.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    Logger.getLogger(CNhanVien.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}