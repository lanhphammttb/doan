package frm;
import frm.Main;
import frm.clsConnectDB;
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

    /**
     * Creates new form PanelNhaCungCap
     */
    public PanelNhaCungCap() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
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
        btnThem_DoiTac = new javax.swing.JButton();
        btnSua_DoiTac = new javax.swing.JButton();
        btnXoa_DoiTac = new javax.swing.JButton();
        btnReset_DoiTac = new javax.swing.JButton();
        jLabel80 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        txtEmail_DoiTac = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        jPanelDoiTac.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelDoiTacComponentShown(evt);
            }
        });

        tblDoiTac_DoiTac.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "STT", "Mã NPH", "Tên Nhà Phân Phối", "Địa Chỉ", "SDT", "Email", "Chú Thích"
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

        btnThem_DoiTac.setText("Thêm");
        btnThem_DoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_DoiTacActionPerformed(evt);
            }
        });

        btnSua_DoiTac.setText("Sửa");
        btnSua_DoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_DoiTacActionPerformed(evt);
            }
        });

        btnXoa_DoiTac.setText("Xóa");
        btnXoa_DoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_DoiTacActionPerformed(evt);
            }
        });

        btnReset_DoiTac.setText("Reset");
        btnReset_DoiTac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_DoiTacActionPerformed(evt);
            }
        });

        jLabel80.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel80.setForeground(new java.awt.Color(0, 51, 204));
        jLabel80.setText("Nhà Phân Phối Sản Phẩm");

        jLabel17.setText("Email");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 51, 255));
        jLabel1.setText("Nhà phân phối");

        javax.swing.GroupLayout jPanelDoiTacLayout = new javax.swing.GroupLayout(jPanelDoiTac);
        jPanelDoiTac.setLayout(jPanelDoiTacLayout);
        jPanelDoiTacLayout.setHorizontalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel80)
                            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                .addComponent(jScrollPane22, javax.swing.GroupLayout.PREFERRED_SIZE, 707, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(btnXoa_DoiTac, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(btnThem_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel76, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel78, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel75, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel77, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                    .addComponent(txtSDT_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                                                    .addComponent(txtDiaChi_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtTenNhaPhanPhoi_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addComponent(txtMaNPP_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING))
                                                .addComponent(btnSua_DoiTac, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(btnReset_DoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                            .addComponent(jLabel79, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(jScrollPane23)
                                            .addComponent(txtEmail_DoiTac)))))))
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel1)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        jPanelDoiTacLayout.setVerticalGroup(
            jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(2, 2, 2)
                .addComponent(jLabel80)
                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
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
                            .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                                .addComponent(jScrollPane23, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnThem_DoiTac)
                                    .addComponent(btnSua_DoiTac))
                                .addGap(40, 40, 40)
                                .addGroup(jPanelDoiTacLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btnXoa_DoiTac)
                                    .addComponent(btnReset_DoiTac)))
                            .addComponent(jLabel79))
                        .addContainerGap(85, Short.MAX_VALUE))
                    .addGroup(jPanelDoiTacLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane22)
                        .addContainerGap())))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1186, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelDoiTac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblDoiTac_DoiTacMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoiTac_DoiTacMouseClicked
        int viTriDongVuaBam = tblDoiTac_DoiTac.getSelectedRow();
        txtMaNPP_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 1).toString());
        txtTenNhaPhanPhoi_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 2).toString());
        txtDiaChi_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 3).toString());
        txtSDT_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 4).toString());
        txtEmail_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 5).toString());
        txtChuThich_DoiTac.setText(tblDoiTac_DoiTac.getValueAt(viTriDongVuaBam, 6).toString());

    }//GEN-LAST:event_tblDoiTac_DoiTacMouseClicked

    private void btnThem_DoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_DoiTacActionPerformed
        String MaDoiTac, TenDoiTac, DiaChi, SDT, Email, ChuThich;
        MaDoiTac = txtMaNPP_DoiTac.getText();
        TenDoiTac = txtTenNhaPhanPhoi_DoiTac.getText();
        DiaChi = txtDiaChi_DoiTac.getText();
        SDT = txtSDT_DoiTac.getText();
        Email = txtEmail_DoiTac.getText();
        ChuThich = txtGhiChu_KhachHang.getText();
        String cautruyvan = "insert into NhaPhanPhoi values("
        + " N'" + TenDoiTac + "' , N'" + DiaChi + "' ,'" + SDT
        + "','" + Email + "', N'" + ChuThich + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapDoiTac(0);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            System.out.println("Thất bại");;
        }
        layDuLieuDoiTac();
    }//GEN-LAST:event_btnThem_DoiTacActionPerformed

    private void btnSua_DoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_DoiTacActionPerformed
        String MaDoiTac, TenDoiTac, DiaChi, SDT, Email, ChuThich;
        MaDoiTac = txtMaNPP_DoiTac.getText();
        TenDoiTac = txtTenNhaPhanPhoi_DoiTac.getText();
        DiaChi = txtDiaChi_DoiTac.getText();
        SDT = txtSDT_DoiTac.getText();
        Email = txtEmail_DoiTac.getText();
        ChuThich = txtGhiChu_KhachHang.getText();
        String cautruyvan = "update  NhaPhanPhoi set "
        + " TenNhaPhanPhoi= N'" + TenDoiTac + "' ,DiaChi= N'" + DiaChi + "' ,SDT='" + SDT
        + "',Email='" + Email + "',ChuThich= N'" + ChuThich + "' Where MaNhaPhanPhoi=" + MaDoiTac;
        System.out.println(cautruyvan);
        boolean kiemtra = KiemTraNhapDoiTac(1);
        if (kiemtra) {
            Main.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm Dối Tác", "lỗi", 2);
        }
        layDuLieuDoiTac();
    }//GEN-LAST:event_btnSua_DoiTacActionPerformed

    private void btnXoa_DoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_DoiTacActionPerformed

        String MaDoiTac = txtMaNPP_DoiTac.getText();
        if (!MaDoiTac.equals("")) {
            String cautruyvan = "delete NhaPhanPhoi where MaNhaPhanPhoi=" + MaDoiTac;
            String ctvKiemThu = "select count(MaPhieuNhap) as SoPhieuNhap"
            + " from NhaPhanPhoi,PhieuNhap where NhaPhanPhoi.MaNhaPhanPhoi=PhieuNhap.MaNhaPhanPhoi"
            + " and  NhaPhanPhoi.MaNhaPhanPhoi=" + MaDoiTac;
            ResultSet rs1 = Main.connection.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoPhieuNhap");
                    if (rs1.getInt("SoPhieuNhap") == 0) {
                        Main.connection.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        layDuLieuDoiTac();
                        ResDoiTac();
                    } else {
                        ThongBao("không thể xóa bởi Đối Tác đã có " + so1 + " Phiếu Nhập!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(frmTrangChu.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao("bạn chưa nhập mã đối tác mà!", "tôi cần sự chăm chỉ của bạn!hãy click vô bảng đã!", 2);
        }
    }//GEN-LAST:event_btnXoa_DoiTacActionPerformed

    private void btnReset_DoiTacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_DoiTacActionPerformed
        ResDoiTac();
    }//GEN-LAST:event_btnReset_DoiTacActionPerformed

    private void jPanelDoiTacComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelDoiTacComponentShown
        layDuLieuDoiTac();
    }//GEN-LAST:event_jPanelDoiTacComponentShown
    public void ResDoiTac() {
        txtMaNPP_DoiTac.setText("");
        txtTenNhaPhanPhoi_DoiTac.setText("");
        txtDiaChi_DoiTac.setText("");
        txtSDT_DoiTac.setText("");
        txtEmail_DoiTac.setText("");
        txtChuThich_DoiTac.setText("");
    }
    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
    public void layDuLieuDoiTac() {
        String cautruyvan = "";
        cautruyvan = "select * from NhaPhanPhoi ";
        ResultSet rs = Main.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã", "Tên Đối Tác", "Địa chỉ", "Số DT", "Email", "Chú Thích"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblDoiTac_DoiTac.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[7];
                item[0] = c;
                item[1] = rs.getInt("MaNhaPhanPhoi");
                item[2] = rs.getString("TenNhaPhanPhoi");
                item[3] = rs.getString("DiaChi");
                item[4] = rs.getString("SDT");
                item[5] = rs.getString("Email");
                item[6] = rs.getString("ChuThich");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
       public boolean KiemTraNhapDoiTac(int ts) {
        String MaDoiTac,ThongBao="", TenDoiTac, DiaChi, SDT, Email, ChuThich;
        boolean kiemtra=true;
        MaDoiTac = txtMaNPP_DoiTac.getText();
        TenDoiTac = txtTenNhaPhanPhoi_DoiTac.getText();
        DiaChi = txtDiaChi_DoiTac.getText();
        SDT = txtSDT_DoiTac.getText();
        Email = txtEmail_DoiTac.getText();
        ChuThich = txtGhiChu_KhachHang.getText();
        if (MaDoiTac.equals("") && ts == 1) {
            ThongBao += "bạn chưa chọn khách hàng để lấy  Mã Đối Tác\n";
            lblMaKhachHang_KhachHang.setForeground(Color.red);
        }
        if (TenDoiTac.equals("")) {
            ThongBao += "bạn chưa Nhập Tên Đối Tác\n";
            lblTenKhachHang_KhachHang.setForeground(Color.red);
        }
        if (DiaChi.equals("")) {
            lblDiaChi_KhachHang.setForeground(Color.red);
            ThongBao += "bạn chưa Nhập Địa Chỉ\n";
        }
          if (!KiemTraEmail(Email)) {
            lblDiaChi_KhachHang.setForeground(Color.red);
            ThongBao += "bạn chưa Nhập Đúng Email\n";

        }
        if (SDT.equals("")) {
            lblSDT_KhachHang.setForeground(Color.red);
            ThongBao += "bạn chưa Nhập Số ĐT \n";
        }
        if (ThongBao.equals("")) {
            kiemtra = true;
            lblDiaChi_KhachHang.setForeground(Color.black);
            lblSDT_KhachHang.setForeground(Color.black);
            lblMaKhachHang_KhachHang.setForeground(Color.black);
            lblTenKhachHang_KhachHang.setForeground(Color.black);
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }
        public boolean KiemTraEmail(String email){
        boolean kq=false;
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern v = Pattern.compile(EMAIL_PATTERN);
        Matcher m= v.matcher(email);
        kq=m.matches();
        return kq;
   }
    private javax.swing.JLabel lblMaKhachHang_KhachHang;
    lblMaKhachHang_KhachHang = new javax.swing.JLabel();
    private javax.swing.JTextPane txtGhiChu_KhachHang;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnReset_DoiTac;
    private javax.swing.JButton btnSua_DoiTac;
    private javax.swing.JButton btnThem_DoiTac;
    private javax.swing.JButton btnXoa_DoiTac;
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