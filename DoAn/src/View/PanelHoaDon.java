/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

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
import Database.PrintPDF;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class PanelHoaDon extends javax.swing.JPanel {
	/**
	 * Creates new form PanelHoaDon
	 */
	public PanelHoaDon() {
		initComponents();
	}
    Calendar cal = Calendar.getInstance();

    int day = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
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
        jPanel13 = new javax.swing.JPanel();

        jMenu1.setText("jMenu1");

        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1220, 640));

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
                "STT", "Mã Hóa Đơn", "Khách Hàng", "Nhân Viên", "Ngày Lập HĐ", "Tổng Tiền", "Ghi Chú"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, true
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "Tổng Tiền", "Ghi Chú"
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

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel14Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblMaHoaDon_HoaDon)
                    .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayLap))
                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtTongTien_HoaDon)
                                    .addComponent(cbbKhachHang_HoaDon, 0, 142, Short.MAX_VALUE)
                                    .addComponent(txtNgayLapHoaDon_HoaDon)
                                    .addComponent(cbbNhanVien_HoaDon, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel14Layout.createSequentialGroup()
                                .addComponent(txtMaPhieuMua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(btnXoa_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(14, 14, 14)
                        .addComponent(btnSua_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                    .addComponent(jScrollPane16, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel14Layout.createSequentialGroup()
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNhanVien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbKhachHang_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgayLap)
                            .addComponent(txtNgayLapHoaDon_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtTongTien_HoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem_HoaDon)
                            .addComponent(btnXoa_HoaDon)
                            .addComponent(btnSua_HoaDon)
                            .addComponent(btnReset_HoaDon))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSoLuong_CTPM)
                            .addComponent(jLabel57)
                            .addComponent(lblMaCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtSoLuong_ChiTietHoaDon)
                            .addComponent(txtMaCTH_ChiTietHoaDon)
                            .addComponent(txtMaHoaDon_ChiTietHoaDon)
                            .addComponent(cbbSanPham_ChiTietHoaDon, 0, 156, Short.MAX_VALUE)
                            .addComponent(txtTongTien_ChiTietHoaDon))
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel19Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnThem_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnXoa_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnSua_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnReset_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel19Layout.setVerticalGroup(
            jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel19Layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel36, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtMaCTH_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblMaCTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel19Layout.createSequentialGroup()
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaHoaDon_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel40, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSanPham_ChiTietHoaDon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong_CTPM, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuong_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(txtTongTien_ChiTietHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane17, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel19Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_ChiTietHoaDon)
                    .addComponent(btnXoa_ChiTietHoaDon)
                    .addComponent(btnSua_ChiTietHoaDon)
                    .addComponent(btnReset_ChiTietHoaDon))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanelHoaDonLayout = new javax.swing.GroupLayout(jPanelHoaDon);
        jPanelHoaDon.setLayout(jPanelHoaDonLayout);
        jPanelHoaDonLayout.setHorizontalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(235, 235, 235)
                        .addComponent(jLabel35))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(209, 209, 209)
                        .addComponent(jLabel34)))
                .addContainerGap(810, Short.MAX_VALUE))
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
                    .addComponent(jScrollPane15))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20))
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addComponent(jPanel19, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE)
                        .addContainerGap())))
        );
        jPanelHoaDonLayout.setVerticalGroup(
            jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel35)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                    .addComponent(jScrollPane10, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addComponent(jLabel34)
                .addGap(18, 18, 18)
                .addGroup(jPanelHoaDonLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane15, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(jPanelHoaDonLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel19, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)))
                .addGap(26, 26, 26))
        );

        jTabbedPaneHoaDon.addTab("Phiếu Mua Hàng", jPanelHoaDon);

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1176, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 556, Short.MAX_VALUE)
        );

        jTabbedPaneHoaDon.addTab("Chi Tiết Phiếu Mua", jPanel13);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jTabbedPaneHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 51, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblHoaDon_HoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblHoaDon_HoaDonMouseClicked
        int viTriDongVuaBam = tblHoaDon_HoaDon.getSelectedRow();
        txtMaPhieuMua_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtNgayLapHoaDon_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtTongTien_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        txtGhiChu_HoaDon.setText(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 6).toString());
        setSelectedCombobox(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 3).toString(), cbbNhanVien_HoaDon);
        setSelectedCombobox(tblHoaDon_HoaDon.getValueAt(viTriDongVuaBam, 2).toString(), cbbKhachHang_HoaDon);
        LayDuLieuChiTietHoaDon(txtMaPhieuMua_HoaDon.getText());
        if (tblCTHoaDon_ChiTietHoaDon.getRowCount() > 0) {
            cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
            txtMaCTH_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 1).toString());
            txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 2).toString());
            txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 4).toString());
            txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 5).toString());
            txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 6).toString());
            setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(0, 3).toString(), cbbSanPham_ChiTietHoaDon);
        } else {
            reset_chitiethoadon();
            txtMaHoaDon_ChiTietHoaDon.setText(txtMaPhieuMua_HoaDon.getText());
        }
    }//GEN-LAST:event_tblHoaDon_HoaDonMouseClicked

    private void tblCTHoaDon_ChiTietHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblCTHoaDon_ChiTietHoaDonMouseClicked
        int viTriDongVuaBam = tblCTHoaDon_ChiTietHoaDon.getSelectedRow();
        txtMaCTH_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 1).toString());
        txtMaHoaDon_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 2).toString());
        txtSoLuong_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 4).toString());
        txtTongTien_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 5).toString());
        txtGhiChu_ChiTietHoaDon.setText(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 6).toString());
        setSelectedCombobox(tblCTHoaDon_ChiTietHoaDon.getValueAt(viTriDongVuaBam, 3).toString(), cbbSanPham_ChiTietHoaDon);
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
        String MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, ChuThich;
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
        NgayLapHoaDon = txtNgayLapHoaDon_HoaDon.getText();
        TongTien = txtTongTien_HoaDon.getText();
        ChuThich = txtGhiChu_HoaDon.getText();
        String cautruyvan = "insert into HoaDon(MaKhachHang,MaNhanVien,TongTien,GhiChu) values(" + MaKhachHang + "," + MaNhanVien + "," + 0 + ",N'" + ChuThich + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapHoaDon(0);
        if (kiemtra) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            System.out.println("thất bại");
        }
        LayDuLieuHoaDon();
    }//GEN-LAST:event_btnThem_HoaDonActionPerformed

    private void btnXoa_HoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_HoaDonActionPerformed
        if (!txtMaPhieuMua_HoaDon.getText().equals("")) {
            String MaHoaDon = txtMaPhieuMua_HoaDon.getText();
            String cautruyvan = "delete HoaDon where MaHoaDon=" + MaHoaDon;
            String ctvKiemThu = "select count(MaCTHD) as SoChiTietPhieuMua"
            + " from HoaDon,ChiTietHoaDon where HoaDon.MaHoaDon=ChiTietHoaDon.MaHoaDon and HoaDon.MaHoaDon=" + MaHoaDon;
            ResultSet rs1 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoChiTietPhieuMua");
                    if (rs1.getInt("SoChiTietPhieuMua") == 0) {
                        Main.MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        LayDuLieuHoaDon();
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
        String MaHoaDon, MaKhachHang, MaNhanVien, NgayLapHoaDon, TongTien, ChuThich;
        MaHoaDon = txtMaPhieuMua_HoaDon.getText();
        MaKhachHang = GetCbbSelected(cbbKhachHang_HoaDon);
        MaNhanVien = GetCbbSelected(cbbNhanVien_HoaDon);
        NgayLapHoaDon = txtNgayLapHoaDon_HoaDon.getText();
        TongTien = txtTongTien_HoaDon.getText();
        ChuThich = txtGhiChu_HoaDon.getText();
        String cautruyvan = "update HoaDon set MaKhachHang=" + MaKhachHang + ",TongTien="
        + TongTien + ",NgayLapHoaDon='" + NgayLapHoaDon + "',GhiChu=N'" + ChuThich + "' where MaHoaDon=" + MaHoaDon;
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapHoaDon(1);
        if (kiemtra) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể ", "Thêm Hóa Đơn", 2);
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
        frmNgay frmngaylap = new frmNgay();
        frmngaylap.show();
    }//GEN-LAST:event_lblNgayLapMouseClicked

    private void txtTongTien_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTongTien_ChiTietHoaDonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTongTien_ChiTietHoaDonActionPerformed

    private void cbbSanPham_ChiTietHoaDonItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPham_ChiTietHoaDonItemStateChanged
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));
        Tien = (double) Gia * SoLuong;
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_cbbSanPham_ChiTietHoaDonItemStateChanged

    private void btnThem_ChiTietHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_ChiTietHoaDonActionPerformed
        String MaHoaDon, MaSanPham, SoLuong, TongTien, ChuThich;
        MaHoaDon = txtMaHoaDon_ChiTietHoaDon.getText();
        MaSanPham = GetCbbSelected(cbbSanPham_ChiTietHoaDon);
        SoLuong = txtSoLuong_ChiTietHoaDon.getText();
        TongTien = txtTongTien_ChiTietHoaDon.getText();
        ChuThich = txtGhiChu_ChiTietHoaDon.getText();
        String cautruyvan = "insert into ChiTietHoaDon(MaHoaDon, MaSanPham, SoLuong, TongTien, GhiChu) values(" + MaHoaDon + "," + MaSanPham + "," + SoLuong + "," + TongTien + ",N'" + ChuThich + "')";
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
        reset_chitiethoadon();
    }//GEN-LAST:event_btnReset_ChiTietHoaDonActionPerformed

    private void txtSoLuong_ChiTietHoaDonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyPressed

    private void txtSoLuong_ChiTietHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuong_ChiTietHoaDonKeyReleased
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuong_ChiTietHoaDon.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPham_ChiTietHoaDon));
        Tien = (double) Gia * SoLuong;
        txtTongTien_ChiTietHoaDon.setText(String.valueOf(Tien));
    }//GEN-LAST:event_txtSoLuong_ChiTietHoaDonKeyReleased

    private void jPanelHoaDonComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelHoaDonComponentShown
        LayDuLieuHoaDon();
        cbbNhanVien_HoaDon.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
        cbbKhachHang_HoaDon.setModel(LayDuLieucbb("KhachHang", "TenKhachHang", "MaKhachHang"));
        cbbSanPham_ChiTietHoaDon.setModel(LayDuLieucbb("SanPham", "TenSanPham", "MaSanPham"));
        txtNgayLapHoaDon_HoaDon.setText(year+"-"+month+"-"+day);
    }//GEN-LAST:event_jPanelHoaDonComponentShown
    public void LayDuLieuHoaDon() {
        String cautruyvan = "";
        cautruyvan = "select MaHoaDon,KhachHang.TenKhachHang as TenKhachHang,NhanVien.TenNhanVien,TongTien,NgayLapHoaDon,HoaDon.GhiChu from HoaDon,KhachHang,NhanVien where HoaDon.MaKhachHang =KhachHang.MaKhachHang "
                + "and HoaDon.MaNhanVien=NhanVien.MaNhanVien ";
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã hóa đơn", "Khách Hàng ", "Nhân viên", "Ngày lập hóa dơn", "tổng tiền", "Chú Thích"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblHoaDon_HoaDon.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getInt("MaHoaDon");
                item[2] = rs.getString("TenKhachHang");
                item[3] = rs.getString("TenNhanVien");
                item[4] = rs.getString("NgayLapHoaDon");
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
        String cautruyvan = "select * from SanPham where MaSanPham=" + MaSP;
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        try {
            if (rs.next()) {
                Gia = rs.getInt("Giaban");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Gia;
    }
    public void LayDuLieuChiTietHoaDon(String MaHoaDon) {
        String cautruyvan = "";
        cautruyvan = "select MaCTHD,MaHoaDon,SanPham.TenSanPham,SoLuong,TongTien,ChiTietHoaDon.GhiChu "
                + " from ChiTietHoaDon,SanPham where ChiTietHoaDon.MaSanPham=SanPham.MaSanPham  and MaHoaDon=" + MaHoaDon;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã CTHD", "Mã Hóa Đơn", "Sản Phẩm", "Số Lượng", "tổng tiền", "Chú Thích"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblCTHoaDon_ChiTietHoaDon.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[7];
                item[0] = c;
                item[1] = rs.getInt("MaCTHD");
                item[2] = rs.getString("MaHoaDon");
                item[3] = rs.getString("TenSanPham");
                item[4] = rs.getString("SoLuong");
                item[5] = rs.getDouble("TongTien");
                item[6] = rs.getString("GhiChu");
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
    public void reset_chitiethoadon() {
        txtMaCTH_ChiTietHoaDon.setText("");
        txtMaHoaDon_ChiTietHoaDon.setText("");
        txtSoLuong_ChiTietHoaDon.setText("");
        txtTongTien_ChiTietHoaDon.setText("");
        txtGhiChu_ChiTietHoaDon.setText("");
        cbbSanPham_ChiTietHoaDon.setSelectedIndex(0);
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
                String ctv = "update HoaDon set TongTien= " + ttht + "where MaHoaDon=" + MaHoaDon;
                System.out.println(ctv);
                MainClass.connection.ExcuteQueryUpdateDB(ctv);
                LayDuLieuHoaDon();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset_ChiTietHoaDon;
    private javax.swing.JButton btnReset_HoaDon;
    private javax.swing.JButton btnSua_ChiTietHoaDon;
    private javax.swing.JButton btnSua_HoaDon;
    private javax.swing.JButton btnThem_ChiTietHoaDon;
    private javax.swing.JButton btnThem_HoaDon;
    private javax.swing.JButton btnXoa_ChiTietHoaDon;
    private javax.swing.JButton btnXoa_HoaDon;
    private javax.swing.JComboBox<String> cbbKhachHang_HoaDon;
    private javax.swing.JComboBox<String> cbbNhanVien_HoaDon;
    private javax.swing.JComboBox<String> cbbSanPham_ChiTietHoaDon;
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
    private javax.swing.JTable tblCTHoaDon_ChiTietHoaDon;
    private javax.swing.JTable tblHoaDon_HoaDon;
    private javax.swing.JTextArea txtGhiChu_ChiTietHoaDon;
    private javax.swing.JTextArea txtGhiChu_HoaDon;
    private javax.swing.JTextField txtMaCTH_ChiTietHoaDon;
    private javax.swing.JTextField txtMaHoaDon_ChiTietHoaDon;
    private javax.swing.JTextField txtMaPhieuMua_HoaDon;
    public javax.swing.JTextField txtNgayLapHoaDon_HoaDon;
    private javax.swing.JTextField txtSoLuong_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien_ChiTietHoaDon;
    private javax.swing.JTextField txtTongTien_HoaDon;
    // End of variables declaration//GEN-END:variables
}
