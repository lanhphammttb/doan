/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View;

import java.awt.BorderLayout;
import Controller.UserInfo;
import java.awt.Toolkit;

/**
 *
 * @author dell
 */
public class FrameMain extends javax.swing.JFrame {

	public FrameMain() {
		initComponents();
//		if (!UserInfo.isAdmin()) {
//			userMenu.setEnabled(false);
//			menuNhanVien.setEnabled(false);
//			menuTKNhanVien.setEnabled(false);
//			lblPQ.setText("Nhân viên");
//		} else {
//			lblPQ.setText("Admin");
////		}
//		jLabel9.setText(UserInfo.username);
	}

	@SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenu4 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 0), new java.awt.Dimension(20, 32767));
        jLabel7 = new javax.swing.JLabel();
        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 0), new java.awt.Dimension(50, 32767));
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        lblPQ = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        PanelChinh = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        userMenu = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        menuDoiMatKhau = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        menuNhanVien = new javax.swing.JMenuItem();
        menuKhachHang = new javax.swing.JMenuItem();
        menuNhaCungCap = new javax.swing.JMenuItem();
        menuSanPham = new javax.swing.JMenuItem();
        menuHoaDon = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        menuTKNhanVien = new javax.swing.JMenuItem();
        menuTKKhachHang = new javax.swing.JMenuItem();
        menuTKSanPham = new javax.swing.JMenuItem();
        menuTKDoanhThu = new javax.swing.JMenuItem();
        m = new javax.swing.JMenu();
        menuBaoCao = new javax.swing.JMenuItem();

        jMenu4.setText("jMenu4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý cửa hàng tạp hóa");
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(200, 70, 1280, 1000));
        setIconImage(Toolkit.getDefaultToolkit().getImage(FrameLogin.class.getResource("/Images/3d-building.jpg")));
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(null, java.awt.Color.white));

        jPanel4.setBackground(new java.awt.Color(3, 51, 182));
        jPanel4.setMaximumSize(new java.awt.Dimension(32767, 50));
        jPanel4.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanel4.setName(""); // NOI18N
        jPanel4.setPreferredSize(new java.awt.Dimension(1000, 50));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));
        jPanel4.add(filler2);

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Cửa hàng tạp hóa");
        jLabel7.setAlignmentX(0.5F);
        jPanel4.add(jLabel7);
        jPanel4.add(filler1);

        jPanel2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Xin chào,");

        lblPQ.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblPQ.setForeground(new java.awt.Color(255, 255, 255));
        lblPQ.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/priv.png"))); // NOI18N
        lblPQ.setText("Phân quyền");

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(". . .  . . . . . . . . . . . . . ");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblPQ)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblPQ)
                        .addComponent(jLabel9))
                    .addComponent(jLabel8))
                .addContainerGap())
        );

        jPanel4.add(jPanel2);

        PanelChinh.setBackground(new java.awt.Color(255, 255, 255));
        PanelChinh.setLayout(new java.awt.BorderLayout());

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/taphoaxinh (3).jpg"))); // NOI18N
        jLabel11.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jLabel11.setMaximumSize(new java.awt.Dimension(2000, 1000));
        jLabel11.setMinimumSize(new java.awt.Dimension(2000, 1000));
        jLabel11.setPreferredSize(new java.awt.Dimension(2000, 2000));
        PanelChinh.add(jLabel11, java.awt.BorderLayout.CENTER);
        PanelChinh.add(jSeparator1, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(PanelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(PanelChinh, javax.swing.GroupLayout.DEFAULT_SIZE, 1993, Short.MAX_VALUE))
        );

        jMenuBar1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jMenu6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/hethong32.png"))); // NOI18N
        jMenu6.setText("Hệ thống");
        jMenu6.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        userMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/username1.png"))); // NOI18N
        userMenu.setText("Quản lý người dùng");
        userMenu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userMenuActionPerformed(evt);
            }
        });

        jMenuItem1.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem1.setText("Nhập thông tin");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        userMenu.add(jMenuItem1);

        jMenuItem2.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem2.setText("Thêm tài khoản");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        userMenu.add(jMenuItem2);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem3.setText("Xóa tài khoản");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        userMenu.add(jMenuItem3);

        jMenuItem4.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem4.setText("Đổi phân quyền");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        userMenu.add(jMenuItem4);

        jMenu6.add(userMenu);

        menuDoiMatKhau.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuDoiMatKhau.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/matkhaumoi.png"))); // NOI18N
        menuDoiMatKhau.setText("Đổi mật khẩu");
        menuDoiMatKhau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDoiMatKhauActionPerformed(evt);
            }
        });
        jMenu6.add(menuDoiMatKhau);

        jMenuItem5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        jMenuItem5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/logout2.png"))); // NOI18N
        jMenuItem5.setText("Đăng xuất");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem5);

        jMenuBar1.add(jMenu6);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quanly32.png"))); // NOI18N
        jMenu5.setText("Quản lý");
        jMenu5.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        menuNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/qlnhanvien32.png"))); // NOI18N
        menuNhanVien.setText("Quản lý nhân viên");
        menuNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhanVienActionPerformed(evt);
            }
        });
        jMenu5.add(menuNhanVien);

        menuKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quanlykhachhang32.png"))); // NOI18N
        menuKhachHang.setText("Quản lý khách hàng");
        menuKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuKhachHangActionPerformed(evt);
            }
        });
        jMenu5.add(menuKhachHang);

        menuNhaCungCap.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuNhaCungCap.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quanlydichvu32.png"))); // NOI18N
        menuNhaCungCap.setText("Quản lý nhà cung cấp");
        menuNhaCungCap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuNhaCungCapActionPerformed(evt);
            }
        });
        jMenu5.add(menuNhaCungCap);

        menuSanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkphong32.png"))); // NOI18N
        menuSanPham.setText("Quản lý sản phẩm");
        menuSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSanPhamActionPerformed(evt);
            }
        });
        jMenu5.add(menuSanPham);

        menuHoaDon.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuHoaDon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/quanlyhoadon32.png"))); // NOI18N
        menuHoaDon.setText("Hóa đơn");
        menuHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuHoaDonActionPerformed(evt);
            }
        });
        jMenu5.add(menuHoaDon);

        jMenuBar1.add(jMenu5);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/thongke32.png"))); // NOI18N
        jMenu3.setText("Thống kê");
        jMenu3.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        menuTKNhanVien.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuTKNhanVien.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tknhanvien32.png"))); // NOI18N
        menuTKNhanVien.setText("Thống kê nhân viên");
        menuTKNhanVien.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTKNhanVienActionPerformed(evt);
            }
        });
        jMenu3.add(menuTKNhanVien);

        menuTKKhachHang.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuTKKhachHang.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkkhachhang32.png"))); // NOI18N
        menuTKKhachHang.setText("Thống kê khách hàng");
        menuTKKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTKKhachHangActionPerformed(evt);
            }
        });
        jMenu3.add(menuTKKhachHang);

        menuTKSanPham.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuTKSanPham.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkphong32.png"))); // NOI18N
        menuTKSanPham.setText("Thống kê sản phẩm");
        menuTKSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTKSanPhamActionPerformed(evt);
            }
        });
        jMenu3.add(menuTKSanPham);

        menuTKDoanhThu.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuTKDoanhThu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/tkdoanhthu32.png"))); // NOI18N
        menuTKDoanhThu.setText("Thống kê doanh thu");
        menuTKDoanhThu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuTKDoanhThuActionPerformed(evt);
            }
        });
        jMenu3.add(menuTKDoanhThu);

        jMenuBar1.add(jMenu3);

        m.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baocao32.png"))); // NOI18N
        m.setText("Báo cáo");
        m.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        menuBaoCao.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        menuBaoCao.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/baocao32.png"))); // NOI18N
        menuBaoCao.setText("Báo cáo");
        menuBaoCao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuBaoCaoActionPerformed(evt);
            }
        });
        m.add(menuBaoCao);

        jMenuBar1.add(m);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void menuTKNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTKNhanVienActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelTKNhanVien(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuTKNhanVienActionPerformed

    private void menuNhanVienActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhanVienActionPerformed
		PanelChinh.removeAll();
		PanelChinh.add(new PanelNhanVien(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuNhanVienActionPerformed

    private void menuKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuKhachHangActionPerformed

		PanelChinh.removeAll();
		PanelChinh.add(new PanelKhachHang(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuKhachHangActionPerformed

    private void menuNhaCungCapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuNhaCungCapActionPerformed
		PanelChinh.removeAll();
		PanelChinh.add(new PanelNhaCungCap(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuNhaCungCapActionPerformed

    private void menuSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSanPhamActionPerformed
		PanelChinh.removeAll();
		PanelChinh.add(new PanelSanPham(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuSanPhamActionPerformed

    private void menuHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuHoaDonActionPerformed
		PanelChinh.removeAll();
		PanelChinh.add(new PanelHoaDon(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuHoaDonActionPerformed

    private void menuTKKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTKKhachHangActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelTKKhachHang(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuTKKhachHangActionPerformed

    private void menuTKSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTKSanPhamActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelTKPhong(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuTKSanPhamActionPerformed

    private void menuTKDoanhThuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuTKDoanhThuActionPerformed
		PanelChinh.removeAll();
		PanelChinh.add(new PanelTKDoanhThu1(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuTKDoanhThuActionPerformed

    private void menuDoiMatKhauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDoiMatKhauActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelDoiMatKhau(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuDoiMatKhauActionPerformed

    private void menuBaoCaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuBaoCaoActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelBaoCao(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_menuBaoCaoActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
		PanelChinh.removeAll();
		//PanelChinh.add(new PanelThongTinNguoiDung(), BorderLayout.CENTER);
		PanelChinh.updateUI();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void userMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userMenuActionPerformed

    }//GEN-LAST:event_userMenuActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
		//new DeleteUserDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
		//new AddUserDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
		//new EditUserDialog(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
//		UserInfo.reset();
//		//new FrameLogin().setVisible(true);
//		dispose();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel */
		//<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
		/* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(FrameMain.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>
		//</editor-fold>

		/* Create and display the form */
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				FrameMain main = new FrameMain();
				main.setSize(1366, 768);
				main.setLocationRelativeTo(null);
				main.setResizable(false);
				main.setVisible(true);
			}
		});
	}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelChinh;
    private javax.swing.Box.Filler filler1;
    private javax.swing.Box.Filler filler2;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblPQ;
    private javax.swing.JMenu m;
    private javax.swing.JMenuItem menuBaoCao;
    private javax.swing.JMenuItem menuDoiMatKhau;
    private javax.swing.JMenuItem menuHoaDon;
    private javax.swing.JMenuItem menuKhachHang;
    private javax.swing.JMenuItem menuNhaCungCap;
    private javax.swing.JMenuItem menuNhanVien;
    private javax.swing.JMenuItem menuSanPham;
    private javax.swing.JMenuItem menuTKDoanhThu;
    private javax.swing.JMenuItem menuTKKhachHang;
    private javax.swing.JMenuItem menuTKNhanVien;
    private javax.swing.JMenuItem menuTKSanPham;
    private javax.swing.JMenu userMenu;
    // End of variables declaration//GEN-END:variables
}
