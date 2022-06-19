package View;
import Controller.CNhaCungCap;
import Controller.KiemTraDuLieu_Controller;
import Main.MainClass;
import Model.NhaCungCap;
//import Database.ConnectDB;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.scene.control.ComboBox;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author PLanh
 */
public class PanelNhaCungCap extends javax.swing.JPanel {
    //MVC
    DefaultTableModel tblDanhSach;
    java.util.List<NhaCungCap> arr = new ArrayList<>();
    String MaNCC, TenNCC, DiaChi, SDT, Email, GhiChu, sMaNCC;
    boolean ktThem;
    String macu;
    public PanelNhaCungCap() {
        initComponents();
                //MVC
                        tblDanhSach = (DefaultTableModel) tblDoiTac_DoiTac.getModel();
                        KhoaMo(true);
                        sMaNCC="";
                        LayNguon();
    }
    public void KhoaMo(boolean b){
        btThem.setEnabled(b);
        btSua.setEnabled(b);
        btXoa.setEnabled(b);
        
        btGhi.setEnabled(!b);
        btKhong.setEnabled(!b);
        
        txtMaNPP_DoiTac.setEditable(!b);
        txtTenNhaPhanPhoi_DoiTac.setEditable(!b);
        txtDiaChi_DoiTac.setEditable(!b);
        txtSDT_DoiTac.setEditable(!b);
        txtEmail_DoiTac.setEditable(!b);
        txtChuThich_DoiTac.setEditable(!b);
        
        tblDoiTac_DoiTac.setEnabled(b);
    }
    public void XoaTrang(){
        txtMaNPP_DoiTac.setText("");
        txtTenNhaPhanPhoi_DoiTac.setText("");
        txtDiaChi_DoiTac.setText("");
        txtSDT_DoiTac.setText(""); 
        txtEmail_DoiTac.setText("");
        txtChuThich_DoiTac.setText("");
    }
    
    public void  LayNguon(){
        arr = CNhaCungCap.LayNguon(sMaNCC);
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[]{
                p.getMaNCC(), p.getTenNCC(), p.getDiaChi(), p.getSDT(), p.getEmail(), p.getGhiChu(),
            });
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelDoiTac = new javax.swing.JPanel();
        jScrollPane22 = new javax.swing.JScrollPane();
        tblDoiTac_DoiTac = new javax.swing.JTable();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        jLabel79 = new javax.swing.JLabel();
        txtMaNPP_DoiTac = new javax.swing.JTextField();
        txtTenNhaPhanPhoi_DoiTac = new javax.swing.JTextField();
        txtDiaChi_DoiTac = new javax.swing.JTextField();
        txtSDT_DoiTac = new javax.swing.JTextField();
        jScrollPane23 = new javax.swing.JScrollPane();
        txtChuThich_DoiTac = new javax.swing.JTextArea();
        jLabel80 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmail_DoiTac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btGhi = new javax.swing.JButton();
        btKhong = new javax.swing.JButton();

        jPanelDoiTac.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDoiTacComponentShown(evt);
            }
        });

        tblDoiTac_DoiTac.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã NPH", "Tên Nhà Phân Phối", "Địa Chỉ", "SDT", "Email", "Chú Thích"
            }
        ));
        tblDoiTac_DoiTac.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblDoiTac_DoiTacMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(tblDoiTac_DoiTac);

        jLabel75.setText("Mã NPP");

        jLabel76.setText("Tên Nhà Phân Phối");

        jLabel77.setText("Địa Chỉ");

        jLabel78.setText("SDT");

        jLabel79.setText("Chú Thích");

        txtMaNPP_DoiTac.setEditable(false);

        txtChuThich_DoiTac.setColumns(20);
        txtChuThich_DoiTac.setRows(5);
        jScrollPane23.setViewportView(txtChuThich_DoiTac);

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 51, 204));
        jLabel80.setText("Nhà Phân Phối Sản Phẩm");

        jLabel17.setText("Email");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Nhà phân phối");

        btThem.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btThem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/file_blank_paper_document_page_icon_196467.png"))); // NOI18N
        btThem.setText("Thêm");
        btThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemActionPerformed(evt);
            }
        });

        btSua.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btSua.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/settings_options_configuration_setting_system_icon_196481.png"))); // NOI18N
        btSua.setText("Sửa");
        btSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaActionPerformed(evt);
            }
        });

        btXoa.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btXoa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/bin_trash_rubbish_dustbin_remove_icon_196490.png"))); // NOI18N
        btXoa.setText("Xóa");
        btXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaActionPerformed(evt);
            }
        });

        btGhi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btGhi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/seo-social-web-network-internet_273_icon-icons.com_61489.png"))); // NOI18N
        btGhi.setText("Ghi");
        btGhi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btGhiActionPerformed(evt);
            }
        });

        btKhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btKhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btKhong.setText("Không");
        btKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelDoiTacLayout = new javax.swing.GroupLayout(jPanelDoiTac);
        jPanelDoiTac.setLayout(jPanelDoiTacLayout);
        jPanelDoiTacLayout.setHorizontalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGap(418, 418, 418)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel80)
                        .addGap(33, 33, 33))
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 696, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                .addGap(13, 13, 13)
                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelDoiTacLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtSDT_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                            .addComponent(txtDiaChi_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtTenNhaPhanPhoi_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(txtMaNPP_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING)))
                                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane23)
                                            .addComponent(txtEmail_DoiTac))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                        .addComponent(btXoa, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(btGhi, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                        .addComponent(btThem)
                                        .addGap(18, 18, 18)
                                        .addComponent(btSua, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(btKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelDoiTacLayout.setVerticalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel80))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel75)
                            .addComponent(txtMaNPP_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel76)
                            .addComponent(txtTenNhaPhanPhoi_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel77)
                            .addComponent(txtDiaChi_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSDT_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel78))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(txtEmail_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel79))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btThem)
                            .addComponent(btSua))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btXoa)
                            .addComponent(btGhi))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btKhong))
                    .addComponent(jScrollPane22))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanelDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 3, Short.MAX_VALUE)
                .addComponent(jPanelDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDoiTac_DoiTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoiTac_DoiTacMouseClicked
 
    }//GEN-LAST:event_tblDoiTac_DoiTacMouseClicked

    private void jPanelDoiTacComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDoiTacComponentShown

    }//GEN-LAST:event_jPanelDoiTacComponentShown

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        if(txtMaNPP_DoiTac.getText().length()<=0)
        return;
        macu = txtMaNPP_DoiTac.getText();
        ktThem = false;
        KhoaMo(false);
        txtMaNPP_DoiTac.requestFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if(txtMaNPP_DoiTac.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaNPP_DoiTac.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaNPP_DoiTac.getText();
            CNhaCungCap.XoaBo(macu);
            LayNguon();
            XoaTrang();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed

    private void btGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhiActionPerformed
        //kiểm tra dữ liệu rỗng
        if(txtMaNPP_DoiTac.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã nhà cung cấp","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaNPP_DoiTac.requestFocus();
            return;
        }
        if(txtTenNhaPhanPhoi_DoiTac.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên nhà cung cấp","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenNhaPhanPhoi_DoiTac.requestFocus();
            return;
        }
        if(txtDiaChi_DoiTac.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập địa chỉ nhà cung cấp","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDiaChi_DoiTac.requestFocus();
            return;
        }
        if(txtSDT_DoiTac.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập SDT nhà cung cấp","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtSDT_DoiTac.requestFocus();
            return;
        }
        if(txtEmail_DoiTac.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập email nhà cung cấp","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtEmail_DoiTac.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("NhaCungCap", "MaNCC", txtMaNPP_DoiTac.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã khách hàng","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaNPP_DoiTac.requestFocus();
            return;
        }
        //thực hiện ghi
        MaNCC=txtMaNPP_DoiTac.getText();
        TenNCC=txtTenNhaPhanPhoi_DoiTac.getText();
        DiaChi = txtDiaChi_DoiTac.getText();
        SDT= txtSDT_DoiTac.getText();
        Email= txtEmail_DoiTac.getText();
        GhiChu =txtChuThich_DoiTac.getText();

        NhaCungCap nv = new NhaCungCap(MaNCC, TenNCC, DiaChi, SDT, Email, GhiChu);
        if(ktThem==true){
            CNhaCungCap.ThemMoi(nv);
        }
        else{
            CNhaCungCap.CapNhat(nv, macu);
        }
        //lấy nguồn dữ liệu mới
        LayNguon();
        KhoaMo(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btGhiActionPerformed

    private void btKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhongActionPerformed
        XoaTrang();
        KhoaMo(true);        // TODO add your handling code here:
    }//GEN-LAST:event_btKhongActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        XoaTrang();
        KhoaMo(false);
        ktThem = true;
        txtMaNPP_DoiTac.requestFocus();        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_btThemActionPerformed
 
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btGhi;
    private javax.swing.JButton btKhong;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanelDoiTac;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JTable tblDoiTac_DoiTac;
    private javax.swing.JTextArea txtChuThich_DoiTac;
    private javax.swing.JTextField txtDiaChi_DoiTac;
    private javax.swing.JTextField txtEmail_DoiTac;
    private javax.swing.JTextField txtMaNPP_DoiTac;
    private javax.swing.JTextField txtSDT_DoiTac;
    private javax.swing.JTextField txtTenNhaPhanPhoi_DoiTac;
    // End of variables declaration//GEN-END:variables
}
