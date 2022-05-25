/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm;

import java.awt.*;
import java.io.File;
import java.util.Date;
import java.util.Vector;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import frm.UserInfo;
import frm.CalendarAdapter;
import frm.ConnectDB;
import frm.PrintPDF;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelKhachHang extends javax.swing.JPanel {

	/**
	 * Creates new form PanelKhachHang
	 */
	frm.ConnectDB con = new frm.ConnectDB();
	Vector<String> vec = new Vector<String>(100);
	frm.CKhachHang control;
	DefaultTableModel dtm;
	
	private final String[] colName = {"Mã khách hàng", "Họ tên khách hàng", "Ngày Sinh", "Giới tính", "Địa chỉ", "SĐT", "Loại khách hàng", "Ghi chú"};
	private final String[] sqlName = {"MaKhachHang", "TenKhachHang", "Ngaysinh", "GioiTinh", "DiaChi", "SDT", "LoaiKhachHang", "GhiChu"};
	
	public PanelKhachHang() {
		initComponents();
		control = new frm.CKhachHang("root", "dragonball");
		dtm = new DefaultTableModel(control.getTableData(), colName);
		this.tbKhachHang.setModel(dtm);
		
		tbKhachHang.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent e) {
				int selected = tbKhachHang.getSelectedRow();
				if (selected < 0) {
					tfMaKhachHang.setText("");
					tfTenKhachHang.setText("");
					tfsoCMND.setText("");
					tfSoDienThoai.setText("");
					tfDiaChi.setText("");
					rbNam.setSelected(false);
					rbNu.setSelected(false);
					tfQuocTich.setText("");
					return;
				}
				
				tfMaKhachHang.setText((String) dtm.getValueAt(selected, 0));
				tfTenKhachHang.setText((String) dtm.getValueAt(selected, 1));
				tfsoCMND.setText((String) dtm.getValueAt(selected, 2));
				if (dtm.getValueAt(selected, 3).equals("Nam") || dtm.getValueAt(selected, 3).equals("nam")) {
					rbNam.setSelected(true);
					rbNu.setSelected(false);
				} else {
					rbNam.setSelected(false);
					rbNu.setSelected(true);
				}
				tfDiaChi.setText((String) dtm.getValueAt(selected, 4));
				tfQuocTich.setText((String) dtm.getValueAt(selected, 5));
				tfSoDienThoai.setText((String) dtm.getValueAt(selected, 6));
			}
		});
	}
	
	private String getFields() {
		String fields = new String();
		
		fields += this.tfMaKhachHang.getText();
		fields += "\t";
		fields += this.tfTenKhachHang.getText();
		fields += "\t";
		fields += this.tfsoCMND.getText();
		fields += "\t";
		if (rbNam.isSelected()) {
			fields += "Nam";
		} else {
			fields += "Nữ";
		}
		fields += "\t";
		fields += this.tfDiaChi.getText();
		fields += "\t";
		fields += this.tfQuocTich.getText();
		fields += "\t";
		fields += this.tfSoDienThoai.getText();
		
		return fields;
	}
	
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
			db.connect("QuanLySanPham", frm.UserInfo.username, frm.UserInfo.password);
			Vector<String> colsName = new Vector<String>(10);
			colsName.add("Mã khách hàng");
			colsName.add("Tên khách hàng");
			colsName.add("Số CMND");
			colsName.add("Giới tính");
			colsName.add("Địa chỉ");
			colsName.add("Quốc tịch");
			colsName.add("SĐT");
			
			tableModel.setColumnIdentifiers(colsName);
			
			//vec = db.selectSearch("khachhang", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tbKhachHang.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
		}
	}
	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel(){
            public void paintComponent(Graphics g){
                ImageIcon icon = new ImageIcon("background2.jpg");
                Image image = icon.getImage();
                g.drawImage(image, 0, 0, this.getSize().width, this.getSize().height, this);

            }
        };
        jLabel2 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        CBTK = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jPanel_KhachHang = new javax.swing.JPanel();
        jScrollPane24 = new javax.swing.JScrollPane();
        tblKhachHang_KhachHang = new javax.swing.JTable();
        jLabel56 = new javax.swing.JLabel();
        lblMaKhachHang_KhachHang = new javax.swing.JLabel();
        lblTenKhachHang_KhachHang = new javax.swing.JLabel();
        txtMaKhachHang_KhachHang = new javax.swing.JTextField();
        txtTenKhachHang_KhachHang = new javax.swing.JTextField();
        rbtnNam_KhachHang = new javax.swing.JRadioButton();
        rbtnNu_KhachHang = new javax.swing.JRadioButton();
        lblNgaySinh_KhachHang = new javax.swing.JLabel();
        lblGioiTinh_KhachHang = new javax.swing.JLabel();
        lblDiaChi_KhachHang = new javax.swing.JLabel();
        txtDiaChi_KhachHang = new javax.swing.JTextField();
        lblSDT_KhachHang = new javax.swing.JLabel();
        txtSDT_KhachHang = new javax.swing.JTextField();
        cbbLoaiKhachHang_KhachHang = new javax.swing.JComboBox<>();
        lblLoaiKhachHang_KhachHang = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        txtGhiChu_KhachHang = new javax.swing.JTextPane();
        btnThem_KhachHang = new javax.swing.JButton();
        btnSua_KhachHang = new javax.swing.JButton();
        btnXoa_KhachHang = new javax.swing.JButton();
        btnReset_KhachHang = new javax.swing.JButton();
        cbbNgay = new javax.swing.JComboBox<>();
        cbbThang = new javax.swing.JComboBox<>();
        cbbNam = new javax.swing.JComboBox<>();
        lblLoiMaKhachHang_KhachHang4 = new javax.swing.JLabel();
        lblLoiMaKhachHang_KhachHang5 = new javax.swing.JLabel();

        setOpaque(false);

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel2.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(228, 44, 219));
        jLabel2.setText("QUẢN LÝ KHÁCH HÀNG");

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel6.setBackground(new java.awt.Color(204, 255, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

        jLabel11.setText("Chọn khóa tìm kiếm :");

        jLabel12.setText("Nhập từ khóa tìm kiếm :");

        btnTimKiem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/nhom2/de14/images/tkiemnhanvien24.png"))); // NOI18N
        btnTimKiem.setText("Tìm kiếm");
        btnTimKiem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTimKiemActionPerformed(evt);
            }
        });

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã khách hàng", "Tên khách hàng", "Số CMND", "Giới tính", "Địa chỉ", "Quốc tịch", "Số điện thoại" }));
        CBTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CBTKActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel12)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(74, 74, 74)
                        .addComponent(btnTimKiem)))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnTimKiem))
        );

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/taphoaxinh.jpg"))); // NOI18N

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/nhom2/de14/images/them24.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/nhom2/de14/images/sua24.png"))); // NOI18N
        jButton2.setText("Sửa");
        jButton2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/nhom2/de14/images/excel24.png"))); // NOI18N
        jButton9.setText("Thêm file");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/project1/nhom2/de14/images/xoa24.png"))); // NOI18N
        jButton10.setText("Xóa");
        jButton10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton10)
                                .addGap(18, 18, 18)
                                .addComponent(jButton9))
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton2)))
                        .addGap(32, 32, 32)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel13)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton9)
                    .addComponent(jButton10))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel_KhachHang.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel_KhachHangComponentShown(evt);
            }
        });

        tblKhachHang_KhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã Khách Hàng", "Tên Khách Hàng", "Ngày Sinh", "Giới Tính", "Dịa Chỉ", "SDT", "Loại Khách Hàng", "Ghi Chú"
            }
        ));
        tblKhachHang_KhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblKhachHang_KhachHangMouseClicked(evt);
            }
        });
        jScrollPane24.setViewportView(tblKhachHang_KhachHang);

        jLabel56.setText("Khách Hàng");

        lblMaKhachHang_KhachHang.setText("Mã KH");

        lblTenKhachHang_KhachHang.setText("Tên KH");

        txtMaKhachHang_KhachHang.setEditable(false);

        txtTenKhachHang_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTenKhachHang_KhachHangFocusLost(evt);
            }
        });
        txtTenKhachHang_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTenKhachHang_KhachHangActionPerformed(evt);
            }
        });
        txtTenKhachHang_KhachHang.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtTenKhachHang_KhachHangKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtTenKhachHang_KhachHangKeyTyped(evt);
            }
        });

        rbtnNam_KhachHang.setText("Nam");

        rbtnNu_KhachHang.setText("Nữ");

        lblNgaySinh_KhachHang.setText("Ngày Sinh");

        lblGioiTinh_KhachHang.setText("Giới Tính");

        lblDiaChi_KhachHang.setText("Địa Chỉ");

        txtDiaChi_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtDiaChi_KhachHangFocusLost(evt);
            }
        });

        lblSDT_KhachHang.setText("SDT");

        txtSDT_KhachHang.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDT_KhachHangFocusLost(evt);
            }
        });

        cbbLoaiKhachHang_KhachHang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblLoaiKhachHang_KhachHang.setText("Loại KH");

        jLabel85.setText("Ghi Chú");

        jScrollPane25.setViewportView(txtGhiChu_KhachHang);

        btnThem_KhachHang.setText("Thêm");
        btnThem_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_KhachHangActionPerformed(evt);
            }
        });

        btnSua_KhachHang.setText("Sửa");
        btnSua_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_KhachHangActionPerformed(evt);
            }
        });

        btnXoa_KhachHang.setText("Xóa");
        btnXoa_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_KhachHangActionPerformed(evt);
            }
        });

        btnReset_KhachHang.setText("Reset");
        btnReset_KhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_KhachHangActionPerformed(evt);
            }
        });

        cbbThang.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThangItemStateChanged(evt);
            }
        });
        cbbThang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbThangActionPerformed(evt);
            }
        });

        lblLoiMaKhachHang_KhachHang4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLoiMaKhachHang_KhachHang4.setForeground(new java.awt.Color(255, 0, 51));

        lblLoiMaKhachHang_KhachHang5.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        lblLoiMaKhachHang_KhachHang5.setForeground(new java.awt.Color(255, 0, 51));

        javax.swing.GroupLayout jPanel_KhachHangLayout = new javax.swing.GroupLayout(jPanel_KhachHang);
        jPanel_KhachHang.setLayout(jPanel_KhachHangLayout);
        jPanel_KhachHangLayout.setHorizontalGroup(
            jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(474, 474, 474)
                        .addComponent(jLabel56))
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addComponent(lblNgaySinh_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(lblMaKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblTenKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblGioiTinh_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                        .addComponent(rbtnNam_KhachHang)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 107, Short.MAX_VALUE)
                                        .addComponent(rbtnNu_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtMaKhachHang_KhachHang)
                                    .addComponent(txtTenKhachHang_KhachHang))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblDiaChi_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblSDT_KhachHang)
                                    .addComponent(lblLoaiKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel85))
                                .addGap(25, 25, 25)
                                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtSDT_KhachHang)
                                    .addComponent(jScrollPane25)
                                    .addComponent(cbbLoaiKhachHang_KhachHang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txtDiaChi_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lblLoiMaKhachHang_KhachHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 195, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnThem_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnXoa_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnReset_KhachHang, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 142, Short.MAX_VALUE))))
                .addContainerGap(271, Short.MAX_VALUE))
            .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 986, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(130, Short.MAX_VALUE))
            .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                    .addGap(145, 145, 145)
                    .addComponent(lblLoiMaKhachHang_KhachHang4, javax.swing.GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE)
                    .addGap(833, 833, 833)))
        );
        jPanel_KhachHangLayout.setVerticalGroup(
            jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel56)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane24, javax.swing.GroupLayout.PREFERRED_SIZE, 303, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaKhachHang_KhachHang)
                    .addComponent(txtMaKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblDiaChi_KhachHang)
                    .addComponent(txtDiaChi_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnThem_KhachHang))
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(lblLoiMaKhachHang_KhachHang5, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSDT_KhachHang)
                            .addComponent(txtSDT_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSua_KhachHang))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblLoaiKhachHang_KhachHang)
                            .addComponent(cbbLoaiKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                        .addComponent(btnXoa_KhachHang))
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTenKhachHang_KhachHang)
                            .addComponent(txtTenKhachHang_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgaySinh_KhachHang)
                            .addComponent(cbbNgay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbThang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNam, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(21, 21, 21)))
                .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(lblGioiTinh_KhachHang))
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbtnNam_KhachHang)
                            .addComponent(rbtnNu_KhachHang)))
                    .addComponent(jScrollPane25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel_KhachHangLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnReset_KhachHang))
                    .addComponent(jLabel85))
                .addContainerGap())
            .addGroup(jPanel_KhachHangLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel_KhachHangLayout.createSequentialGroup()
                    .addContainerGap(550, Short.MAX_VALUE)
                    .addComponent(lblLoiMaKhachHang_KhachHang4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(22, 22, 22)))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(1415, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(271, Short.MAX_VALUE)
                    .addComponent(jPanel_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(306, Short.MAX_VALUE)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(65, 65, 65))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(21, Short.MAX_VALUE)
                    .addComponent(jPanel_KhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(19, Short.MAX_VALUE)))
        );

        jPanel1.add(jPanel2, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        loadDataTableS();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (ConfirmAdd.main(null)) {
            String fields = getFields();
            if (control.add(fields)) {
                dtm.addRow(fields.split("\t"));
            }else{
                JOptionPane.showMessageDialog(this, "Thực hiện không thành công");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (ConfirmEdit.main(null)) {
            int selected = tbKhachHang.getSelectedRow();
            String key = (String) dtm.getValueAt(selected, 0);
            String fields = getFields();
            if (control.edit(fields, key)) {
                tbKhachHang.getSelectionModel().removeSelectionInterval(selected, 0);
                dtm.removeRow(selected);
                dtm.insertRow(selected, fields.split("\t"));
            }else{
                JOptionPane.showMessageDialog(this, "Thực hiện không thành công");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel Workbook", "xls");
        chooser.setFileFilter(filter);
        int returnVal = chooser.showOpenDialog(this);

        File file;
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            file = chooser.getSelectedFile();
            file = file.getAbsoluteFile();
            Vector<String> rows = control.addFile(file.getPath());

            for (String s : rows) {
                dtm.addRow(s.split("\t"));
            }
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if (ConfirmDelete.main(null)) {
            int selected = tbKhachHang.getSelectedRow();
            String key = (String) dtm.getValueAt(selected, 0);
            if (control.delete(key)) {
                dtm.removeRow(selected);
            }else{
                JOptionPane.showMessageDialog(this, "Thực hiện không thành công");
            }
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void tblKhachHang_KhachHangMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHang_KhachHangMouseClicked
        int viTriDongVuaBam = tblKhachHang_KhachHang.getSelectedRow();

        txtMaKhachHang_KhachHang.setText(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 1).toString());
        txtTenKhachHang_KhachHang.setText(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 2).toString());
        txtDiaChi_KhachHang.setText(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 5).toString());
        txtSDT_KhachHang.setText(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 6).toString());
        txtGhiChu_KhachHang.setText(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 8).toString());
        setSelectedCombobox(tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 7).toString(), cbbLoaiKhachHang_KhachHang);
        String gioitinh = tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 4).toString();

        if (gioitinh.equals("Nam")) {
            rbtnNam_KhachHang.setSelected(true);
            rbtnNu_KhachHang.setSelected(false);
        } else {
            rbtnNam_KhachHang.setSelected(false);
            rbtnNu_KhachHang.setSelected(true);
        }
        String ngaysinh = tblKhachHang_KhachHang.getValueAt(viTriDongVuaBam, 3).toString();
        System.out.println("" + ngaysinh);
        String strngay, strthang, strnam;
        strngay = ngaysinh.substring(8, 10);
        strthang = ngaysinh.substring(5, 7);
        strnam = ngaysinh.substring(0, 4);
        int ngay, thang, nam;
        ngay = Integer.valueOf(strngay);
        thang = Integer.valueOf(strthang);
        nam = Integer.valueOf(strnam);
        cbbNgay.setSelectedItem(String.valueOf(ngay));
        cbbThang.setSelectedItem(String.valueOf(thang));
        cbbNam.setSelectedItem(String.valueOf(nam));
        lblMaKhachHang_KhachHang.setForeground(Color.black);
        lblTenKhachHang_KhachHang.setForeground(Color.black);
        lblDiaChi_KhachHang.setForeground(Color.black);
        lblSDT_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_tblKhachHang_KhachHangMouseClicked

    private void txtTenKhachHang_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangFocusLost
        lblTenKhachHang_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtTenKhachHang_KhachHangFocusLost

    private void txtTenKhachHang_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTenKhachHang_KhachHangActionPerformed

    private void txtTenKhachHang_KhachHangKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangKeyPressed

    }//GEN-LAST:event_txtTenKhachHang_KhachHangKeyPressed

    private void txtTenKhachHang_KhachHangKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtTenKhachHang_KhachHangKeyTyped

    }//GEN-LAST:event_txtTenKhachHang_KhachHangKeyTyped

    private void txtDiaChi_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtDiaChi_KhachHangFocusLost
        lblDiaChi_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtDiaChi_KhachHangFocusLost

    private void txtSDT_KhachHangFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDT_KhachHangFocusLost
        lblSDT_KhachHang.setForeground(Color.black);
    }//GEN-LAST:event_txtSDT_KhachHangFocusLost

    private void btnThem_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_KhachHangActionPerformed
        String MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, ChuThich;
        MaKhachHang = txtMaKhachHang_KhachHang.getText();
        TenKhachHang = txtTenKhachHang_KhachHang.getText();
        String ngay, thang, nam;
        ngay = cbbNgay.getSelectedItem().toString();
        thang = cbbThang.getSelectedItem().toString();
        nam = cbbNam.getSelectedItem().toString();
        NgaySinh = nam + "-" + thang + "-" + ngay;
        if (rbtnNam_KhachHang.isSelected()) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        DiaChi = txtDiaChi_KhachHang.getText();
        SDT = txtSDT_KhachHang.getText();
        LoaiKhachHang = GetCbbSelected(cbbLoaiKhachHang_KhachHang);
        ChuThich = txtGhiChu_KhachHang.getText();
        String cautruyvan = "insert into KhachHang values("
        + " N'" + TenKhachHang + "' , '" + NgaySinh + "' ," + GioiTinh
        + ",N'" + DiaChi + "','" + SDT + "'," + LoaiKhachHang + ", N'" + ChuThich + "')";
        boolean kiemtra = KiemTraNhapKhachHang(0);
        if (kiemtra) {
            HUYPHPK00628_ASM_GD2.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
            System.out.println(cautruyvan);

        } else {
            System.out.println("Thêm Thất Bại");
        }
        layDuLieuKhachHang();
    }//GEN-LAST:event_btnThem_KhachHangActionPerformed

    private void btnSua_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_KhachHangActionPerformed
        String MaKhachHang, TenKhachHang, NgaySinh, GioiTinh, DiaChi, SDT, LoaiKhachHang, ChuThich;
        MaKhachHang = txtMaKhachHang_KhachHang.getText();
        TenKhachHang = txtTenKhachHang_KhachHang.getText();
        String ngay, thang, nam;
        ngay = cbbNgay.getSelectedItem().toString();
        thang = cbbThang.getSelectedItem().toString();
        nam = cbbNam.getSelectedItem().toString();
        NgaySinh = nam + "-" + thang + "-" + ngay;
        if (rbtnNam_KhachHang.isSelected()) {
            GioiTinh = "1";
        } else {
            GioiTinh = "0";
        }
        DiaChi = txtDiaChi_KhachHang.getText();
        SDT = txtSDT_KhachHang.getText();
        LoaiKhachHang = GetCbbSelected(cbbLoaiKhachHang_KhachHang);
        ChuThich = txtGhiChu_KhachHang.getText();
        String cautruyvan = "update  KhachHang set "
        + "TenKhachHang= N'" + TenKhachHang + "' , NgaySinh='" + NgaySinh + "' ,GioiTinh=" + GioiTinh
        + ",DiaChi=N'" + DiaChi + "',SDT='" + SDT + "',LoaiKhachHang=" + LoaiKhachHang + ",GhiChu= N'" + ChuThich + "'where MaKhachHang=" + MaKhachHang;
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapKhachHang(1);
        if (kiemtra) {
            HUYPHPK00628_ASM_GD2.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã sủa Thành Công");
        } else {
            System.out.println("Sửa thất bại");
        }
        layDuLieuKhachHang();
    }//GEN-LAST:event_btnSua_KhachHangActionPerformed

    private void btnXoa_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_KhachHangActionPerformed

        String MaKhachHang = txtMaKhachHang_KhachHang.getText();
        if (!MaKhachHang.equals("")) {
            String cautruyvan = "delete KhachHang where MaKhachHang=" + MaKhachHang;
            String ctvKiemThu = "select count(MaHoaDon) as SoPhieuMua"
            + " from KhachHang,HoaDon where KhachHang.MaKhachHang=HoaDon.MaKhachHang"
            + " and  KhachHang.MaKhachHang=" + MaKhachHang;
            ResultSet rs1 = huyphpk00628_asm_gd2.HUYPHPK00628_ASM_GD2.connection.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoPhieuMua");
                    if (rs1.getInt("SoPhieuMua") == 0) {
                        huyphpk00628_asm_gd2.HUYPHPK00628_ASM_GD2.connection.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        layDuLieuKhachHang();
                        ResKhachHang();
                    } else {
                        ThongBao("không thể xóa bởi Khách Hàng đã có " + so1 + " hóa đơn!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            ThongBao("bạn chưa nhập Mã khách hàng", "lỗi khi cố muốn xóa mà không thèm nhập mã", 2);
        }
    }//GEN-LAST:event_btnXoa_KhachHangActionPerformed

    private void btnReset_KhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_KhachHangActionPerformed
        ResKhachHang();
    }//GEN-LAST:event_btnReset_KhachHangActionPerformed

    private void cbbThangItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThangItemStateChanged

        String thang = cbbThang.getSelectedItem().toString();
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        String thanght;
        if (tam == 0) {
            thanght = "0";
        } else {
            thanght = cbbNgay.getSelectedItem().toString();
        }
        tam = 1;

        if (thang.equals("4") || thang.equals("6") || thang.equals("9") || thang.equals("11")) {
            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 31; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 31) {
                cbbNgay.setSelectedItem(thanght);
            }
        } else if (thang.equals("1") || thang.equals("3") || thang.equals("5")
            || thang.equals("7") || thang.equals("8") || thang.equals("12") || thang.equals("10")) {

            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 32; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 32) {
                cbbNgay.setSelectedItem(thanght);
            }
        } else {
            cbbNgay.setModel(cbbmodel);
            for (int i = 1; i < 29; i++) {
                cbbNgay.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 29) {
                cbbNgay.setSelectedItem(thanght);
            }
        }
    }//GEN-LAST:event_cbbThangItemStateChanged

    private void cbbThangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbThangActionPerformed

    }//GEN-LAST:event_cbbThangActionPerformed

    private void jPanel_KhachHangComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel_KhachHangComponentShown
        rbtnNam_KhachHang.setSelected(true);
        layDuLieuKhachHang();
        cbbLoaiKhachHang_KhachHang.setModel(LayDuLieucbb("LoaiKhachHang", "TenLoaiKhachHang", "MaLoaiKhachHang"));
        for (int i = 1; i < 32; i++) {
            cbbNgay.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cbbThang.addItem(String.valueOf(i));
        }
        for (int i = year; i > 1950; i--) {
            cbbNam.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 70; i++) {
            cbbTuoi_KhachHang.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 70; i++) {
            cbbTimKiemTuoi2_KhachHang.addItem(String.valueOf(i));
        }
        cbbTimKiemLoaiKhachHang_KhachHang.setModel(LayDuLieucbb("LoaiKhachHang", "TenLoaiKhachHang", "MaLoaiKhachHang"));
    }//GEN-LAST:event_jPanel_KhachHangComponentShown

    private void CBTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTKActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btnReset_KhachHang;
    private javax.swing.JButton btnSua_KhachHang;
    private javax.swing.JButton btnThem_KhachHang;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoa_KhachHang;
    private javax.swing.JComboBox<String> cbbLoaiKhachHang_KhachHang;
    private javax.swing.JComboBox<String> cbbNam;
    private javax.swing.JComboBox<String> cbbNgay;
    private javax.swing.JComboBox<String> cbbThang;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel_KhachHang;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JLabel lblDiaChi_KhachHang;
    private javax.swing.JLabel lblGioiTinh_KhachHang;
    private javax.swing.JLabel lblLoaiKhachHang_KhachHang;
    private javax.swing.JLabel lblLoiMaKhachHang_KhachHang4;
    private javax.swing.JLabel lblLoiMaKhachHang_KhachHang5;
    private javax.swing.JLabel lblMaKhachHang_KhachHang;
    private javax.swing.JLabel lblNgaySinh_KhachHang;
    private javax.swing.JLabel lblSDT_KhachHang;
    private javax.swing.JLabel lblTenKhachHang_KhachHang;
    private javax.swing.JRadioButton rbtnNam_KhachHang;
    private javax.swing.JRadioButton rbtnNu_KhachHang;
    private javax.swing.JTable tblKhachHang_KhachHang;
    private javax.swing.JTextField txtDiaChi_KhachHang;
    private javax.swing.JTextPane txtGhiChu_KhachHang;
    private javax.swing.JTextField txtMaKhachHang_KhachHang;
    private javax.swing.JTextField txtSDT_KhachHang;
    private javax.swing.JTextField txtTenKhachHang_KhachHang;
    private javax.swing.JTextField txtTimKiem;
    // End of variables declaration//GEN-END:variables
}
