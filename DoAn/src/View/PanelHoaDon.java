/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import Controller.CChiTietHoaDon;
import Main.MainClass;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import Controller.CHoaDon;
import Controller.UserInfo;
import Database.CalendarAdapter;
import Database.ConnectDB;
import Model.ChiTietHoaDon;
import Model.HoaDon;
//import Database.PrintPDF;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import Controller.KiemTraDuLieu_Controller;

public class PanelHoaDon extends javax.swing.JPanel {
//    DefaultTableModel tblDanhSachHD;
//    DefaultTableModel tblDanhSachCTHD;
//    java.util.List<HoaDon> arrHD = new ArrayList<>();
//    java.util.List<ChiTietHoaDon> arrCTHD = new ArrayList<>();
//    String sMaHoaDonTim, sMaCTHDTim;
//    boolean ktThem;
    String macu;
    private final String[] colName = {"Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày lập hóa đơn", "Tổng Tiền", "Ghi Chú"};
    private final String[] sqlName = {"MaHoaDon", "MaKhachHang", "MaNhanVien", "NgayLapHoaDon", "TongTien","GhiChu"};
    Vector<String> vec = new Vector<String>(100);  
	public PanelHoaDon() {
		initComponents();
//                tblDanhSachHD = (DefaultTableModel) tblHoaDon_HoaDon.getModel();
//                tblDanhSachCTHD = (DefaultTableModel) tblCTHoaDon_ChiTietHoaDon.getModel();
//                sMaHoaDonTim=""; sMaCTHDTim="";
////                LayNguonHD();
//////              LayNguonCTHD();
	}
    Calendar cal = Calendar.getInstance();

    int day = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    public void ResetHD(){
        txtMaPhieuMua_HoaDon.setText("");
        cbbKhachHang_HoaDon.setSelectedIndex(0);
        cbbNhanVien_HoaDon.setSelectedIndex(0);
        txtNgayLapHoaDon_HoaDon.setText(year+"-"+month+"-"+day);
        txtTongTien_HoaDon.setText("");       
        txtGhiChu_HoaDon.setText("");
    }
    public void ResetCTHD(){
        txtMaCTH_ChiTietHoaDon.setText("");
        txtMaHoaDon_ChiTietHoaDon.setText("");
        txtSoLuong_ChiTietHoaDon.setText("");
        txtTongTien_ChiTietHoaDon.setText("");
        txtGhiChu_ChiTietHoaDon.setText("");
        cbbSanPham_ChiTietHoaDon.setSelectedIndex(0);
    }    
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
                	Database.ConnectDB conn = new Database.ConnectDB ();
			Vector<String> colsName = new Vector<String>(10);                      
			colsName.add("Mã hóa đơn");
			colsName.add("Mã khách hàng");
			colsName.add("Mã nhân viên");
			colsName.add("Ngày lập hóa đơn");
			colsName.add("Tổng Tiền");
			colsName.add("Ghi Chú");
			
			tableModel.setColumnIdentifiers(colsName);
			
			vec = conn.selectSearch("HoaDon", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tblHoaDon_HoaDon.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
		}
	}
//    public void  LayNguonHD(){
//        arrHD = CHoaDon.LayNguonHD(sMaHoaDonTim);
//        tblDanhSachHD.setRowCount(0); // xóa trắng danh sách
//        arrHD.forEach(p->{
//            tblDanhSachHD.addRow(new Object[]{
//                p.getMaHoaDon(), p.getMaKhachHang(),p.getMaNhanVien(),p.getNgayLapHoaDon(),p.getTongTien(),p.getGhiChu()
//            });
//        });
//    }  
//    
//    public void  LayNguonCTHD(){
//        arrCTHD = CChiTietHoaDon.LayNguonCTHD(sMaCTHDTim);
//        tblDanhSachCTHD.setRowCount(0); // xóa trắng danh sách
//        arrCTHD.forEach(p->{
//            tblDanhSachCTHD.addRow(new Object[]{
//                p.getMaCTHD(), p.getMaHoaDon(),p.getMaSanPham(),p.getSoLuong(),p.getTongTien(),p.getGhiChu()
//            });
//        });
//    }
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu1 = new javax.swing.JMenu();
        jTabbedPaneHoaDon = new javax.swing.JTabbedPane();
        jPanelHoaDon = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        tblHoaDon_HoaDon = new javax.swing.JTable();
        jScrollPane15 = new javax.swing.JScrollPane();
        tblCTHoaDon_ChiTietHoaDon = new javax.swing.JTable();
        jLabel34 = new javax.swing.JLabel();
        jPanel14 = new javax.swing.JPanel();
        jLabel33 = new javax.swing.JLabel();
        lblMaHoaDon_HoaDon = new javax.swing.JLabel();
        lblTongTien_HoaDon = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        txtTongTien_HoaDon = new javax.swing.JTextField();
        cbbKhachHang_HoaDon = new javax.swing.JComboBox<>();
        cbbNhanVien_HoaDon = new javax.swing.JComboBox<>();
        txtMaPhieuMua_HoaDon = new javax.swing.JTextField();
        jScrollPane16 = new javax.swing.JScrollPane();
        txtGhiChu_HoaDon = new javax.swing.JTextArea();
        btnThem_HoaDon = new javax.swing.JButton();
        btnXoa_HoaDon = new javax.swing.JButton();
        btnSua_HoaDon = new javax.swing.JButton();
        btnReset_HoaDon = new javax.swing.JButton();
        lblNgayLap = new javax.swing.JLabel();
        txtNgayLapHoaDon_HoaDon = new javax.swing.JTextField();
        lblTongTien_HoaDon1 = new javax.swing.JLabel();
        txtKhuyenMai_HoaDon = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel35 = new javax.swing.JLabel();
        jPanel19 = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        lblMaCTPM = new javax.swing.JLabel();
        lblSoLuong_CTPM = new javax.swing.JLabel();
        lblMaHoaDon = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        txtTongTien_ChiTietHoaDon = new javax.swing.JTextField();
        cbbSanPham_ChiTietHoaDon = new javax.swing.JComboBox<>();
        txtMaCTH_ChiTietHoaDon = new javax.swing.JTextField();
        jScrollPane17 = new javax.swing.JScrollPane();
        txtGhiChu_ChiTietHoaDon = new javax.swing.JTextArea();
        btnThem_ChiTietHoaDon = new javax.swing.JButton();
        btnXoa_ChiTietHoaDon = new javax.swing.JButton();
        btnSua_ChiTietHoaDon = new javax.swing.JButton();
        btnReset_ChiTietHoaDon = new javax.swing.JButton();
        txtMaHoaDon_ChiTietHoaDon = new javax.swing.JTextField();
        jLabel57 = new javax.swing.JLabel();
        txtSoLuong_ChiTietHoaDon = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        CBTK = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jPanel13 = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1220, 640));

        jTabbedPaneHoaDon.setPreferredSize(new java.awt.Dimension(1366, 768));

        jPanelHoaDon.setBackground(new java.awt.Color(204, 204, 255));
        jPanelHoaDon.setPreferredSize(new java.awt.Dimension(1176, 581));
        jPanelHoaDon.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelHoaDonComponentShown(evt);
            }
        });

        tblHoaDon_HoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã Hóa Đơn", "Khách Hàng", "Nhân Viên", "Ngày Lập HĐ", "Khuyến Mại", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblHoaDon_HoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblHoaDon_HoaDonMouseClicked(evt);
            }
        });
        jScrollPane10.setViewportView(tblHoaDon_HoaDon);

        tblCTHoaDon_ChiTietHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Tổng Tiền", "Ghi Chú"
            }
        ));
        tblCTHoaDon_ChiTietHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblCTHoaDon_ChiTietHoaDonMouseClicked(evt);
            }
        });
        jScrollPane15.setViewportView(tblCTHoaDon_ChiTietHoaDon);

        jLabel34.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel34.setForeground(new java.awt.Color(51, 102, 255));
        jLabel34.setText("Bảng Chi Tiết Hóa Đơn");

        jPanel14.setBackground(new java.awt.Color(204, 204, 255));
        jPanel14.setPreferredSize(new java.awt.Dimension(400, 227));

        jLabel33.setText("Ghi Chú");

        lblMaHoaDon_HoaDon.setText("Mã Hóa Đơn");

        lblTongTien_HoaDon.setText("Tổng Tiền");

        jLabel31.setText("Nhân Viên");

        jLabel30.setText("Khách Hàng");
        jLabel30.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel30MouseClicked(evt);
            }
        });

        txtTongTien_HoaDon.setEditable(false);
        txtTongTien_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTien_HoaDonActionPerformed(evt);
            }
        });

        cbbKhachHang_HoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbNhanVien_HoaDon.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhanVien_HoaDon.setActionCommand("");

        txtMaPhieuMua_HoaDon.setEditable(false);

        txtGhiChu_HoaDon.setColumns(20);
        txtGhiChu_HoaDon.setRows(5);
        jScrollPane16.setViewportView(txtGhiChu_HoaDon);

        btnThem_HoaDon.setText("Thêm ");
        btnThem_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_HoaDonActionPerformed(evt);
            }
        });

        btnXoa_HoaDon.setText("Xóa");
        btnXoa_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_HoaDonActionPerformed(evt);
            }
        });

        btnSua_HoaDon.setText("Sửa");
        btnSua_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_HoaDonActionPerformed(evt);
            }
        });

        btnReset_HoaDon.setText("Reset");
        btnReset_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_HoaDonActionPerformed(evt);
            }
        });

        lblNgayLap.setText("Ngày Lập");
        lblNgayLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNgayLapMouseClicked(evt);
            }
        });

        txtNgayLapHoaDon_HoaDon.setEditable(false);

        lblTongTien_HoaDon1.setText("Khuyến Mại");

        txtKhuyenMai_HoaDon.setEditable(false);
        txtKhuyenMai_HoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtKhuyenMai_HoaDonActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh16.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHoaDon_HoaDon)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayLap))
                        .addGap(3, 3, 3)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtMaPhieuMua_HoaDon)
                            .addComponent(cbbNhanVien_HoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(cbbKhachHang_HoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtNgayLapHoaDon_HoaDon)))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblTongTien_HoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtKhuyenMai_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton2))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtTongTien_HoaDon)))
                .addGap(18, 18, 18)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23))
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnThem_HoaDon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnXoa_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnReset_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuMua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNhanVien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhachHang_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgayLap)
                            .addComponent(txtNgayLapHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lblTongTien_HoaDon1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtKhuyenMai_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_HoaDon)
                    .addComponent(btnXoa_HoaDon)
                    .addComponent(btnSua_HoaDon)
                    .addComponent(btnReset_HoaDon))
                .addGap(79, 79, 79))
        );

        jLabel35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel35.setForeground(new java.awt.Color(51, 102, 255));
        jLabel35.setText("Bảng Hóa Đơn");

        jPanel19.setBackground(new java.awt.Color(204, 204, 255));
        jPanel19.setPreferredSize(new java.awt.Dimension(400, 230));

        jLabel36.setText("Ghi Chú");

        lblMaCTPM.setText("Mã CTPM");

        lblSoLuong_CTPM.setText("Số Lượng");

        lblMaHoaDon.setText("Mã Hóa Đơn");

        jLabel40.setText("Sản Phẩm");

        txtTongTien_ChiTietHoaDon.setEditable(false);
        txtTongTien_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTongTien_ChiTietHoaDonActionPerformed(evt);
            }
        });

        cbbSanPham_ChiTietHoaDon.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSanPham_ChiTietHoaDonItemStateChanged(evt);
            }
        });

        txtMaCTH_ChiTietHoaDon.setEditable(false);
        txtMaCTH_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaCTH_ChiTietHoaDonActionPerformed(evt);
            }
        });

        txtGhiChu_ChiTietHoaDon.setColumns(20);
        txtGhiChu_ChiTietHoaDon.setRows(5);
        jScrollPane17.setViewportView(txtGhiChu_ChiTietHoaDon);

        btnThem_ChiTietHoaDon.setText("Thêm");
        btnThem_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btnXoa_ChiTietHoaDon.setText("Xóa");
        btnXoa_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btnSua_ChiTietHoaDon.setText("Sửa");
        btnSua_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_ChiTietHoaDonActionPerformed(evt);
            }
        });

        btnReset_ChiTietHoaDon.setText("Reset");
        btnReset_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_ChiTietHoaDonActionPerformed(evt);
            }
        });

        txtMaHoaDon_ChiTietHoaDon.setEditable(false);

        jLabel57.setText("Thành Tiền");

        txtSoLuong_ChiTietHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuong_ChiTietHoaDonActionPerformed(evt);
            }
        });
        txtSoLuong_ChiTietHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuong_ChiTietHoaDonKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel19Layout = new javax.swing.GroupLayout(jPanel19);
        jPanel19.setLayout(jPanel19Layout);
        jPanel19Layout.setHorizontalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnThem_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE)
                    .addComponent(jLabel40, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(jLabel57, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                    .addComponent(lblMaCTPM, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(lblSoLuong_CTPM)
                        .addGap(0, 20, Short.MAX_VALUE))
                    .addComponent(lblMaHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtMaHoaDon_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtTongTien_ChiTietHoaDon)
                            .addComponent(txtMaCTH_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(20, 20, 20))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(btnXoa_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37))))
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMaCTH_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel36))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addComponent(jScrollPane17)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtMaHoaDon_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong_CTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel57))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem_ChiTietHoaDon)
                            .addComponent(btnXoa_ChiTietHoaDon)
                            .addComponent(btnSua_ChiTietHoaDon)
                            .addComponent(btnReset_ChiTietHoaDon))
                        .addContainerGap(21, Short.MAX_VALUE))))
        );

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setText("Chọn khóa tìm kiếm :");

        jLabel12.setText("Nhập từ khóa tìm kiếm :");

        txtTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTimKiemActionPerformed(evt);
            }
        });

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkiemnhanvien24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkiemnhanvien24.png"))); // NOI18N
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã hóa đơn", "Mã khách hàng", "Mã nhân viên", "Ngày lập hóa đơn" }));
        CBTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTKActionPerformed(evt);
            }
        });

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/refresh16.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnTimKiem)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTimKiem))
                .addGap(12, 12, 12)
                .addComponent(btnTimKiem)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/taphoaxinh(2) (1).jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel13)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(57, 57, 57)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(144, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel35)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel34)
                        .addGap(556, 556, 556))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 707, Short.MAX_VALUE)
                            .addComponent(jScrollPane10, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(166, 166, 166))
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                                .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34))
                            .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                                .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap(9, Short.MAX_VALUE))
        );

        jTabbedPaneHoaDon.addTab("Phiếu Mua Hàng", jPanelHoaDon);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1432, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 643, Short.MAX_VALUE)
        );

        jTabbedPaneHoaDon.addTab("Chi Tiết Phiếu Mua", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.DEFAULT_SIZE, 676, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDon_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon_HoaDonMouseClicked
        int viTriDongVuaBam = tblHoaDon_HoaDon.getSelectedRow();
        txtMaPhieuMua_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 0).toString());
        txtNgayLapHoaDon_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 3).toString());
        txtKhuyenMai_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtTongTien_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        txtGhiChu_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 6).toString());
        setSelectedCombobox(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 2).toString(), cbbNhanVien_HoaDon);
        setSelectedCombobox(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 1).toString(), cbbKhachHang_HoaDon);
        LayDuLieuChiTietHoaDon(txtMaPhieuMua_HoaDon.getText());
        if (tblCTHoaDon_ChiTietHoaDon.getRowCount() > 0) {
            cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
            txtMaCTH_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 0).toString());
            txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 1).toString());
            txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 3).toString());
            txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 4).toString());
            txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 5).toString());
            setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 2).toString(), cbbSanPham_ChiTietHoaDon);
        } else {
            ResetCTHD();
            txtMaHoaDon_ChiTietHoaDon.setText(txtMaPhieuMua_HoaDon.getText());
        }
    }//GEN-LAST:event_tblHoaDon_HoaDonMouseClicked

    private void tblCTHoaDon_ChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHoaDon_ChiTietHoaDonMouseClicked
        int viTriDongVuaBam = tblCTHoaDon_ChiTietHoaDon.getSelectedRow();
        txtMaCTH_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 0).toString());
        txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 3).toString());
        txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 2).toString(), cbbSanPham_ChiTietHoaDon);
        LayDuLieuChiTietHoaDon(txtMaPhieuMua_HoaDon.getText());
    }//GEN-LAST:event_tblCTHoaDon_ChiTietHoaDonMouseClicked

    private void jLabel30MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel30MouseClicked
//        frmKhachHang frmk=new frmKhachHang();
//        frmk.show();
    }//GEN-LAST:event_jLabel30MouseClicked

    private void txtTongTien_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_HoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien_HoaDonActionPerformed

    private void btnThem_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_HoaDonActionPerformed
        String MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, KhuyenMai, TongTien, GhiChu;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
        NgayLapHoaDon = txtNgayLapHoaDon_HoaDon.getText();
        KhuyenMai = txtKhuyenMai_HoaDon.getText();
        KhuyenMai = "0";
        TongTien = txtTongTien_HoaDon.getText();
        //TongTien = "0";
        
        GhiChu = txtGhiChu_HoaDon.getText();
        HoaDon hd = new HoaDon(MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, KhuyenMai, TongTien, GhiChu);           
        //lấy nguồn dữ liệu mới
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            CHoaDon.ThemMoi(hd);
            System.out.println("Đã Thêm Thành Công");           
        } else {
            System.out.println("Thêm Thất Bại");
        }
        SetKhuyenMai(MaKhachHang, MaHoaDon);
        LayDuLieuHoaDon();
        
    }//GEN-LAST:event_btnThem_HoaDonActionPerformed

    private void btnXoa_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HoaDonActionPerformed
        if (!txtMaPhieuMua_HoaDon.getText().equals("")) {
            String MaHoaDon = txtMaPhieuMua_HoaDon.getText();
//            String cautruyvan = "delete HoaDon where MaHoaDon=" + MaHoaDon;
            String ctvKiemThu = "select count(MaCTHD) as SoChiTietPhieuMua"
            + " from HoaDon,ChiTietHoaDon where HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon and HoaDon.MaHoaDon=" + MaHoaDon;
            ResultSet rs1 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoChiTietPhieuMua");
                    if (rs1.getInt("SoChiTietPhieuMua") == 0) {
                                int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaPhieuMua_HoaDon.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                                    if (kq == JOptionPane.YES_OPTION) {
                                         CHoaDon.XoaBo(MaHoaDon);
                                            System.out.println("đã xóa");
                                              LayDuLieuHoaDon();
                                              //ResetHD();
                                     }
                    } else {
                        ThongBao("không thể xóa bởi hóa đơn đã có " + so1 + " chi tiết hóa đơn!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao("bạn chưa chọn hóa đơn để xóa", "xóa bằng niềm tin à!khi không biết xóa cái nào", 2);
        }
    }//GEN-LAST:event_btnXoa_HoaDonActionPerformed

    private void btnSua_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_HoaDonActionPerformed
        String MaHoaDon , MaKhachHang, MaNhanVien, NgayLapHoaDon, KhuyenMai,TongTien, GhiChu;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
        NgayLapHoaDon = txtNgayLapHoaDon_HoaDon.getText();
        KhuyenMai = txtKhuyenMai_HoaDon.getText();
        TongTien = txtTongTien_HoaDon.getText();
        GhiChu = txtGhiChu_HoaDon.getText();
        String cautruyvan = "update HoaDon set MaKhachHang=" + MaKhachHang + ",TongTien="
        + TongTien + ",NgayLapHoaDon='" + NgayLapHoaDon + "',KhuyenMai = "+KhuyenMai +",GhiChu=N'" + GhiChu + "' where MaHoaDon=" + MaHoaDon;
        System.out.println(cautruyvan);
//        HoaDon hd = new HoaDon(MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, ChuThich);
        boolean kiemtra = KiemTraNhapHoaDon(1);
        if (kiemtra) {         
                MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
//                CHoaDon.CapNhat(hd, macu);
                System.out.println("Đã Sửa Thành Công");
            
        } else {
            System.out.println("Sửa Thất Bại");
        }
        LayDuLieuHoaDon();
    }//GEN-LAST:event_btnSua_HoaDonActionPerformed

    private void btnReset_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_HoaDonActionPerformed
        cbbKhachHang_HoaDon.setSelectedIndex(1);
        cbbNhanVien_HoaDon.setSelectedIndex(1);
        txtNgayLapHoaDon_HoaDon.setText(year+"-"+month+"-"+day);
        txtTongTien_HoaDon.setText("");
        txtGhiChu_HoaDon.setText("");

    }//GEN-LAST:event_btnReset_HoaDonActionPerformed

    private void lblNgayLapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNgayLapMouseClicked
//        frmNgay frmngaylap = new frmNgay();
//        frmngaylap.show();
    }//GEN-LAST:event_lblNgayLapMouseClicked

    private void txtTongTien_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_ChiTietHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien_ChiTietHoaDonActionPerformed

    private void cbbSanPham_ChiTietHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPham_ChiTietHoaDonItemStateChanged
        int SoLuong = 0, KM =0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
            KM = Integer.valueOf(txtKhuyenMai_HoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));       
        Tien = (double) (Gia * SoLuong -Gia * SoLuong *KM/100);
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_cbbSanPham_ChiTietHoaDonItemStateChanged

    private void btnThem_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_ChiTietHoaDonActionPerformed
        String MaHoaDon, MaSanPham, SoLuong, TongTien, ChuThich, MaKhachHang;
        
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        
        MaHoaDon = txtMaHoaDon_ChiTietHoaDon.getText();
        MaSanPham = GetCbbSelected(cbbSanPham_ChiTietHoaDon);
        SoLuong = txtSoLuong_ChiTietHoaDon.getText();
        TongTien = txtTongTien_ChiTietHoaDon.getText();
        ChuThich = txtGhiChu_ChiTietHoaDon.getText();
        String cautruyvan = "insert into ChiTietHoaDon(MaHoaDon, MaSanPham, SoLuong, TongTien, GhiChu) values(" + MaHoaDon + ",'" + MaSanPham + "'," + SoLuong + "," + TongTien + ",N'" + ChuThich + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapChiTietHoaDon(0);
        if (kiemtra) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            System.out.println("thất bại");
        }
        LayDuLieuChiTietHoaDon(MaHoaDon);
        SetTongTien(MaHoaDon);
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        SetCapBacKhachHang(MaKhachHang);
    }//GEN-LAST:event_btnThem_ChiTietHoaDonActionPerformed

    private void btnXoa_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_ChiTietHoaDonActionPerformed

        String MaHoaDon = txtMaHoaDon_ChiTietHoaDon.getText();
        String MaChiTietHoaDon = txtMaCTH_ChiTietHoaDon.getText();
        String cautruyvan = "delete ChiTietHoaDon where MaCTHD=" + MaChiTietHoaDon;
        Main.MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
        System.out.println("đã xóa");
        LayDuLieuChiTietHoaDon(MaHoaDon);
        SetTongTien(MaHoaDon);
    }//GEN-LAST:event_btnXoa_ChiTietHoaDonActionPerformed

    private void btnSua_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_ChiTietHoaDonActionPerformed
        String MaHoaDon, MaChiTietHoaDon, MaSanPham, SoLuong, TongTien, GhiChu;
        MaChiTietHoaDon = txtMaCTH_ChiTietHoaDon.getText();
        MaHoaDon = txtMaHoaDon_ChiTietHoaDon.getText();
        MaSanPham = GetCbbSelected(cbbSanPham_ChiTietHoaDon);
        SoLuong = txtSoLuong_ChiTietHoaDon.getText();
        GhiChu = txtGhiChu_ChiTietHoaDon.getText();
        TongTien = txtTongTien_ChiTietHoaDon.getText();
        String cautruyvan = "update  ChiTietHoaDon set MaSanPham=" + MaSanPham + ",SoLuong=" + SoLuong + ",TongTien="
        + TongTien + ",GhiChu=N'" + GhiChu + "' where MaCTHD=" + MaChiTietHoaDon;
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapChiTietHoaDon(1);
        if (kiemtra && !MaChiTietHoaDon.equals("")) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã sửa Thành Công");
        } else {
            System.out.println("thất bại");
        }
        LayDuLieuChiTietHoaDon(MaHoaDon);
        SetTongTien(MaHoaDon);
    }//GEN-LAST:event_btnSua_ChiTietHoaDonActionPerformed

    private void btnReset_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_ChiTietHoaDonActionPerformed
        ResetCTHD();
    }//GEN-LAST:event_btnReset_ChiTietHoaDonActionPerformed

    private void txtSoLuong_ChiTietHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    private void txtSoLuong_ChiTietHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyReleased
        int SoLuong = 0, KM =0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
            KM = Integer.valueOf(txtKhuyenMai_HoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));
        
        Tien = (double) (Gia * SoLuong - Gia * SoLuong *KM/100);
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyReleased

    private void jPanelHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelHoaDonComponentShown
        LayDuLieuHoaDon();
        cbbNhanVien_HoaDon.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
        cbbKhachHang_HoaDon.setModel(LayDuLieucbb("KhachHang", "TenKhachHang", "MaKhachHang"));
        cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
        txtNgayLapHoaDon_HoaDon.setText(year+"-"+month+"-"+day);
    }//GEN-LAST:event_jPanelHoaDonComponentShown

    private void txtMaCTH_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaCTH_ChiTietHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaCTH_ChiTietHoaDonActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        loadDataTableS();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        loadDataTableS();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void CBTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtTimKiem.setText("");
        LayDuLieuHoaDon();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtKhuyenMai_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtKhuyenMai_HoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtKhuyenMai_HoaDonActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String MaKhachHang, MaHoaDon;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);       
        SetKhuyenMai(MaKhachHang, MaHoaDon);        // TODO add your handling code here:
        LayDuLieuHoaDon();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void txtSoLuong_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonActionPerformed
    public void LayDuLieuHoaDon() {
        String cautruyvan = "";
        cautruyvan = "select MaHoaDon,KhachHang.TenKhachHang as TenKhachHang,NhanVien.TenNhanVien,KhuyenMai,TongTien,NgayLapHoaDon,HoaDon.GhiChu from HoaDon,KhachHang,NhanVien where HoaDon.MaKhachHang =KhachHang.MaKhachHang "
                + "and HoaDon.MaNhanVien=NhanVien.MaNhanVien ";
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"Mã hóa đơn", "Khách Hàng ", "Nhân viên", "Ngày lập hóa dơn", "Khuyến Mại","tổng tiền", "Chú Thích"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblHoaDon_HoaDon.setModel(tableModel);
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                item[0] = rs.getInt("MaHoaDon");
                item[1] = rs.getString("TenKhachHang");
                item[2] = rs.getString("TenNhanVien");
                item[3] = rs.getString("NgayLapHoaDon");
                item[4] = rs.getString("KhuyenMai");
                item[5] = rs.getInt("TongTien");
                item[6] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void setSelectedCombobox(String cbbselected, JComboBox cbb) {
        for (int i = 0; i < cbb.getItemCount(); i++) {
            Object obj = cbb.getItemAt(i);
            if (obj != null) {
                displayvalueModel m = (displayvalueModel) obj;
                if (cbbselected.trim().equals(m.displayMember)) {
                    cbb.setSelectedItem(m);
                }
            }
        }
    }
    public int GetGiaSanPham(String MaSP) {
        int Gia = 0;
        String cautruyvan = "select * from SanPham where MaSanPham= '" + MaSP +"'";
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        try {
            if (rs.next()) {
                Gia = rs.getInt("GiaBan");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Gia;
    }
    public void LayDuLieuChiTietHoaDon(String MaHoaDon) {
        String cautruyvan = "";
        cautruyvan = "select MaCTHD,MaHoaDon,SanPham.TenSanPham,SoLuong,TongTien,ChiTietHoaDon.GhiChu "
                + " from ChiTietHoaDon,SanPham where ChiTietHoaDon.MaSanPham=SanPham.MaSanPham and MaHoaDon=" + MaHoaDon;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "tổng tiền", "Chú Thích"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblCTHoaDon_ChiTietHoaDon.setModel(tableModel);
        try {
            while (rs.next()) {
                Object[] item = new Object[6];
                item[0] = rs.getInt("MaCTHD");
                item[1] = rs.getString("MaHoaDon");
                item[2] = rs.getString("TenSanPham");
                item[3] = rs.getString("SoLuong");
                item[4] = rs.getDouble("TongTien");
                item[5] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public DefaultComboBoxModel LayDuLieucbb(String bang, String Ten, String Ma) {
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
     public boolean KiemTraNhapHoaDon(int ts) {
        String MaHoaDon, MaNhanVien, KhachHang, NgayLap, TongTien,ThongBao="";
        boolean kiemtra = false;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
        
        KhachHang =  GetCbbSelected(cbbKhachHang_HoaDon);
        NgayLap = txtNgayLapHoaDon_HoaDon.getText();
          TongTien = txtTongTien_HoaDon.getText();
        if (MaHoaDon.equals("") && ts == 1) {
            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Hóa Dơn\n";
            lblMaHoaDon_HoaDon.setForeground(Color.red);
        }
        if (MaNhanVien.equals("")) {
            ThongBao += "bạn chưa Chọn Nhân Viên\n";
        }
        if (KhachHang.equals("")) {
            ThongBao += "bạn chưa Chọn Khách Hàng\n";
        }
        if (NgayLap.equals("")) {
            lblNgayLap.setForeground(Color.red);
            ThongBao += "bạn chưa Nhập Ngày Lập\n";
        }
          if (TongTien.equals("")) {
           txtTongTien_HoaDon.setText("0");
        }
        if (ThongBao.equals("")) {
            kiemtra = true;
//            lblDiaChi_KhachHang.setForeground(Color.black);
            lblNgayLap.setForeground(Color.black);
            lblTongTien_HoaDon.setForeground(Color.black);
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }
    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
    public String GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return item.displayvalue.toString();

    }
       public boolean KiemTraNhapChiTietHoaDon(int ts) {
        String MaHoaDon, MaChiTietHoaDon, SanPham, SoLuong,ThongBao="";
        boolean kiemtra = false;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaChiTietHoaDon = txtMaCTH_ChiTietHoaDon.getText();
        SanPham =  GetCbbSelected(cbbSanPham_ChiTietHoaDon);
          SoLuong = txtSoLuong_ChiTietHoaDon.getText();
        if (MaChiTietHoaDon.equals("") && ts == 1) {
            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Hóa Dơn\n";
            lblMaCTPM.setForeground(Color.red);
        }
        if (MaHoaDon.equals("")) {
            ThongBao += "bạn chưa chon trong hóa đơn nào cả\n";
            lblMaHoaDon.setForeground(Color.red);
        }
        if (SoLuong.equals("")) {
            ThongBao += "bạn chưa Nhập Số Lượng"
                    + "\n";
             lblSoLuong_CTPM.setForeground(Color.red);
        }
            try {
                int bien=Integer.valueOf(SoLuong);
            } catch (Exception e) {
                 ThongBao += "Số lượng phải nhập Bằng số"
                    + "\n";
                
            }
      
        if (ThongBao.equals("")) {
            kiemtra = true;
            lblSoLuong_CTPM.setForeground(Color.black);
            lblMaHoaDon.setForeground(Color.black);
            lblMaCTPM.setForeground(Color.black);
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }
    public void SetTongTien(String MaHoaDon) {
        String cautruyvan = "select sum(ChiTietHoaDon.TongTien) as TongTienHienTai,HoaDon.MaHoaDon from HoaDon,ChiTietHoaDon "
                + "where HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon"
                + " and HoaDon.MaHoaDon=" + MaHoaDon + "group by HoaDon.MaHoaDon";
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        String ttht = "";

        try {
            if (rs.next()) {
                ttht = rs.getString("TongTienHienTai");
                txtTongTien_HoaDon.setText(ttht);
                String ctv = "update HoaDon set TongTien = " + ttht + "where MaHoaDon=" + MaHoaDon;
                System.out.println(ctv);
                MainClass.connection.ExcuteQueryUpdateDB(ctv);
                LayDuLieuHoaDon();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    public void SetCapBacKhachHang(String MaKhachHang) {
        String cautruyvan = "select sum(HoaDon.TongTien) as TienDaMua, HoaDon.MaKhachHang from HoaDon where HoaDon.MaKhachHang =" + MaKhachHang + "group by HoaDon.MaKhachHang";
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        int tdm = 0;

        try {
            if (rs.next()) {
                tdm = rs.getInt("TienDaMua");
                //txtTongTien_HoaDon.setText(ttht);
                if(tdm>=5000000){
                String ctv = "update KhachHang set LoaiKhachHang = N'Vip' where MaKhachHang=" + MaKhachHang;
                System.out.println(ctv);
                MainClass.connection.ExcuteQueryUpdateDB(ctv);
                LayDuLieuHoaDon();                    
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    public void SetKhuyenMai(String MaKhachHang, String MaHoaDon) {
        String cautruyvan = "select LoaiKhachHang as lkh, MaKhachHang from KhachHang where KhachHang.MaKhachHang = " + MaKhachHang;
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        String lkm;

        try {
            if (rs.next()) {
                lkm = rs.getString("lkh");
                //txtTongTien_HoaDon.setText(ttht);
                int x = lkm.length() ;
                if(x == 3){                                      
                    txtKhuyenMai_HoaDon.setText("10");
                    String ctv = "update HoaDon set KhuyenMai = 10 where MaHoaDon=" + MaHoaDon;
                    System.out.println(ctv);
                    MainClass.connection.ExcuteQueryUpdateDB(ctv);
                    LayDuLieuHoaDon();
                } else {                                      
                }

            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btnReset_ChiTietHoaDon;
    private javax.swing.JButton btnReset_HoaDon;
    private javax.swing.JButton btnSua_ChiTietHoaDon;
    private javax.swing.JButton btnSua_HoaDon;
    private javax.swing.JButton btnThem_ChiTietHoaDon;
    private javax.swing.JButton btnThem_HoaDon;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa_ChiTietHoaDon;
    private javax.swing.JButton btnXoa_HoaDon;
    private javax.swing.JComboBox<String> cbbKhachHang_HoaDon;
    private javax.swing.JComboBox<String> cbbNhanVien_HoaDon;
    private javax.swing.JComboBox<String> cbbSanPham_ChiTietHoaDon;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanelHoaDon;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JTabbedPane jTabbedPaneHoaDon;
    private javax.swing.JLabel lblMaCTPM;
    private javax.swing.JLabel lblMaHoaDon;
    private javax.swing.JLabel lblMaHoaDon_HoaDon;
    public javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSoLuong_CTPM;
    private javax.swing.JLabel lblTongTien_HoaDon;
    private javax.swing.JLabel lblTongTien_HoaDon1;
    private javax.swing.JTable tblCTHoaDon_ChiTietHoaDon;
    private javax.swing.JTable tblHoaDon_HoaDon;
    private javax.swing.JTextArea txtGhiChu_ChiTietHoaDon;
    private javax.swing.JTextArea txtGhiChu_HoaDon;
    private javax.swing.JTextField txtKhuyenMai_HoaDon;
    private javax.swing.JTextField txtMaCTH_ChiTietHoaDon;
    private javax.swing.JTextField txtMaHoaDon_ChiTietHoaDon;
    private javax.swing.JTextField txtMaPhieuMua_HoaDon;
    public javax.swing.JTextField txtNgayLapHoaDon_HoaDon;
    private javax.swing.JTextField txtSoLuong_ChiTietHoaDon;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTien_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien_HoaDon;
    // End of variables declaration//GEN-END:variables
}
