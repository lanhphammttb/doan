package View;

import Controller.CHoaDon;
import Controller.CKhachHang;
import Controller.CNhanVien;
import Controller.CPhieuNhap;
import Controller.CSanPham;
import Controller.KiemTraDuLieu_Controller;
import static Database.ConnectDB.LayDuLieucbb;
import Main.MainClass;
import Model.HoaDon;
import Model.NhanVien;
import Model.PhieuNhap;
import Model.SanPham;
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
import java.util.Vector;
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
import javax.swing.table.TableModel;

/**
 *
 * @author PLanh
 */
public class PanelSanPham extends javax.swing.JPanel {

    DefaultTableModel tblDanhSach;
    java.util.List<SanPham> arr = new ArrayList<>();
    String MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, DonViTinh, sMaSanPhamTim;
    boolean ktThem;
    String macu;
    private final String[] colName = {"Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm","Hãng sản xuất", "Giá nhập", "Giá bán", "Đơn Vị Tính"};
    private final String[] sqlName = {"MaSanPham", "TenSanPham", "LoaiSanPham", "HangSanXuat","GiaNhap","GiaBan", "DonViTinh"};
    Vector<String> vec = new Vector<String>(100);     
    public PanelSanPham() {
        initComponents();
        //MVC
        tblDanhSach = (DefaultTableModel) tblSanPham.getModel();
//        DesginTable();
        KhoaMo(true);
        sMaSanPhamTim="";
        LayNguonSP();
    }
//MVC
    Calendar cal = Calendar.getInstance();
    int day = cal.get(Calendar.DAY_OF_MONTH);
    int month = cal.get(Calendar.MONTH) + 1;
    int year = cal.get(Calendar.YEAR);
    
    public void KhoaMo(boolean b){
        btThem.setEnabled(b);
        btSua.setEnabled(b);
        btXoa.setEnabled(b);
        
        btGhi.setEnabled(!b);
        btKhong.setEnabled(!b);
        
        txtMaSanPham_SanPham.setEditable(!b);
        txtTenSanPham_SanPham.setEditable(!b);
        cbbLoaiSanPham_SanPham.setEnabled(!b);    
        txtHangSanXuat_SanPham.setEditable(!b);
        txtGiaNhap_SanPham.setEditable(!b);
        txtGiaBan_SanPham.setEditable(!b);
        txtDonViTinh_SanPham.setEditable(!b);
        
        tblSanPham.setEnabled(b);
    }
    
    public void XoaTrang(){
        txtMaSanPham_SanPham.setText("");
        txtTenSanPham_SanPham.setText("");
        //cbbLoaiSanPham_SanPham.setSelectedIndex(0);
        txtHangSanXuat_SanPham.setText("");
        txtGiaNhap_SanPham.setText("");
        txtGiaBan_SanPham.setText("");
        txtDonViTinh_SanPham.setText("");
    }
    public void ResetPN(){
        txtMaPhieuNhap_PhieuNhap.setText("");
        cbbNhanVien_PhieuNhap.setSelectedIndex(0);
        cbbNhaCungCap_PhieuNhap.setSelectedIndex(0);
        //txtNgayLapPhieuNhap_PhieuNhap.setText(year+"-"+month+"-"+day);
        txtTongTien_PhieuNhap.setText("");       
        txtGhiChu_PhieuNhap.setText("");
    }
    public void ResetCTHD(){
        txtMaCTPN_PhieuNhap.setText("");
        txtMaPhieuNhap_CTPN.setText("");
        txtSoLuongCTPN_PhieuNhap.setText("");
        txtTongTienCTPN_PhieuNhap.setText("");
        txtGhiChuCTPN_PhieuNhap.setText("");
        cbbSanPhamCTPN_PhieuNhap.setSelectedIndex(0);
    }    
    public void  LayNguonSP(){
        arr = CSanPham.LayNguonSP(sMaSanPhamTim);
        tblDanhSach.setRowCount(0); // xóa trắng danh sách
        arr.forEach(p->{
            tblDanhSach.addRow(new Object[]{
                p.getMaSanPham(), p.getTenSanPham(),p.getLoaiSanPham(),p.getHangSanXuat(),p.getGiaNhap(),p.getGiaBan(),p.getDonViTinh()
            });
        });
    } 
	private void loadDataTableS() {
		try {
			String col = sqlName[CBTK.getSelectedIndex()];
			String key = txtTimKiem.getText();
			DefaultTableModel tableModel = new DefaultTableModel();
                	Database.ConnectDB conn = new Database.ConnectDB ();
			Vector<String> colsName = new Vector<String>(10);
			colsName.add("Mã sản phẩm");
			colsName.add("Tên sản phẩm");
                        colsName.add("Loại sản phẩm");
			colsName.add("Hãng sản xuất");
			colsName.add("Giá nhập");
                        colsName.add("Giá bán");
                        colsName.add("Đơn Vị Tính");
			
			tableModel.setColumnIdentifiers(colsName);
			
			vec = conn.selectSearch("SanPham", col, key);
			
			String[][] str = new String[vec.size()][];
			for (int i = 0; i < vec.size(); i++) {
				Vector<String> vector = new Vector<String>(100);
				str[i] = vec.get(i).split("\t");
				for (int j = 0; j < str[i].length; j++) {
					vector.add(str[i][j]);
				}
				tableModel.addRow(vector);
			}
			tblSanPham.setModel(tableModel);
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Không có kết quả tìm kiếm ", "Thông báo", 1);
		}
	}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPaneQuanLySanPham = new javax.swing.JTabbedPane();
        jPanelSanPham = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblTenSanPham_SanPham = new javax.swing.JLabel();
        lblMaSanPham_SanPham = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtTenSanPham_SanPham = new javax.swing.JTextField();
        txtMaSanPham_SanPham = new javax.swing.JTextField();
        cbbLoaiSanPham_SanPham = new javax.swing.JComboBox<>();
        jLabel9 = new javax.swing.JLabel();
        txtHangSanXuat_SanPham = new javax.swing.JTextField();
        btnMoTabXB_SanPham = new javax.swing.JButton();
        lblTonKho_SanPham = new javax.swing.JLabel();
        txtDonViTinh_SanPham = new javax.swing.JTextField();
        txtGiaBan_SanPham = new javax.swing.JTextField();
        lblGiaBan = new javax.swing.JLabel();
        lblGiaNhap_SanPham = new javax.swing.JLabel();
        txtGiaNhap_SanPham = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblSanPham = new javax.swing.JTable();
        labelHinhAnh = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtTimKiem = new javax.swing.JTextField();
        btnTimKiem = new javax.swing.JButton();
        CBTK = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jButton9 = new javax.swing.JButton();
        btThem = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btKhong = new javax.swing.JButton();
        btGhi = new javax.swing.JButton();
        jPanelLoaiSanPham = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblLoaiSanPham_LoaiSanPham = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtTenLoaiSanPham_LoaiSanPham = new javax.swing.JTextField();
        btnThem_LoaiSanPham = new javax.swing.JButton();
        btnSua_LoaiSanPham = new javax.swing.JButton();
        btnXoa_LoaiSanPham = new javax.swing.JButton();
        txtMaLoaiSanPham_LoaiSanPham = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblSanPham_LoaiSanPham = new javax.swing.JTable();
        jLabel16 = new javax.swing.JLabel();
        btnXoaSP_LoaiSanPham = new javax.swing.JButton();
        btnSaoLuu_LoaiSanPham = new javax.swing.JButton();
        btnXoaSanPham_LoaiSanPham = new javax.swing.JButton();
        jLabel74 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jPanelPhieuNhap = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        tblChiTietPhieuNhap_PhieuNhap = new javax.swing.JTable();
        jScrollPane18 = new javax.swing.JScrollPane();
        tblPhieuNhap_PhieuNhap = new javax.swing.JTable();
        jLabel42 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jPanel24 = new javax.swing.JPanel();
        lblMaPhieuNhap_PhieuNhap = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        lblNgayLap = new javax.swing.JLabel();
        cbbNhanVien_PhieuNhap = new javax.swing.JComboBox<>();
        txtMaPhieuNhap_PhieuNhap = new javax.swing.JTextField();
        jScrollPane20 = new javax.swing.JScrollPane();
        txtGhiChu_PhieuNhap = new javax.swing.JTextArea();
        btnThem_PhieuNhap = new javax.swing.JButton();
        btnXoa_PhieuNhap = new javax.swing.JButton();
        btnSua_PhieuNhap = new javax.swing.JButton();
        btnReset_PhieuNhap = new javax.swing.JButton();
        jLabel61 = new javax.swing.JLabel();
        cbbNhaCungCap_PhieuNhap = new javax.swing.JComboBox<>();
        lblTongTien_PhieuNhap = new javax.swing.JLabel();
        txtTongTien_PhieuNhap = new javax.swing.JTextField();
        cbbNgay_PhieuNhap = new javax.swing.JComboBox<>();
        cbbThang_PhieuNhap = new javax.swing.JComboBox<>();
        cbbNam_PhieuNhap = new javax.swing.JComboBox<>();
        jPanel25 = new javax.swing.JPanel();
        lblMaCTPN = new javax.swing.JLabel();
        lblSoLuong_CTPN = new javax.swing.JLabel();
        lblMaPhieuNhap = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        txtSoLuongCTPN_PhieuNhap = new javax.swing.JTextField();
        cbbSanPhamCTPN_PhieuNhap = new javax.swing.JComboBox<>();
        txtMaCTPN_PhieuNhap = new javax.swing.JTextField();
        jScrollPane21 = new javax.swing.JScrollPane();
        txtGhiChuCTPN_PhieuNhap = new javax.swing.JTextArea();
        btnThemCTPN_PhieuNhap = new javax.swing.JButton();
        btnXoaXTPN_PhieuNhap = new javax.swing.JButton();
        btnSuaCTPN_PhieuNhap = new javax.swing.JButton();
        btnResetCTPN_PhieuNhap = new javax.swing.JButton();
        jLabel70 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        txtTongTienCTPN_PhieuNhap = new javax.swing.JTextField();
        txtMaPhieuNhap_CTPN = new javax.swing.JTextField();

        jPanelSanPham.setBackground(new java.awt.Color(204, 204, 255));
        jPanelSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelSanPhamComponentShown(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(204, 204, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createCompoundBorder());

        jPanel4.setBackground(new java.awt.Color(204, 204, 255));

        lblTenSanPham_SanPham.setText("Tên Sản Phẩm");

        lblMaSanPham_SanPham.setText("Mã Sản Phẩm");

        jLabel3.setText("Loại Sản Phẩm");

        txtMaSanPham_SanPham.setEditable(false);

        cbbLoaiSanPham_SanPham.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbLoaiSanPham_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbLoaiSanPham_SanPhamActionPerformed(evt);
            }
        });

        jLabel9.setText("Hãng Sản Xuất");

        btnMoTabXB_SanPham.setText("Mở Tab Xem Bảng Sản Phẩm Ẩn");
        btnMoTabXB_SanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMoTabXB_SanPhamActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(lblMaSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTenSanPham_SanPham)
                            .addComponent(jLabel3)
                            .addComponent(jLabel9))
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbbLoaiSanPham_SanPham, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtTenSanPham_SanPham)
                            .addComponent(txtHangSanXuat_SanPham, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtMaSanPham_SanPham)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 62, Short.MAX_VALUE)
                        .addComponent(btnMoTabXB_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaSanPham_SanPham)
                    .addComponent(txtMaSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTenSanPham_SanPham)
                    .addComponent(txtTenSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cbbLoaiSanPham_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtHangSanXuat_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMoTabXB_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        lblTonKho_SanPham.setText("Đơn Vị Tính ");

        lblGiaBan.setText("Giá Bán");

        lblGiaNhap_SanPham.setText("Giá Nhập");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(lblTonKho_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                        .addComponent(txtDonViTinh_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblGiaBan)
                            .addComponent(lblGiaNhap_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtGiaBan_SanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtGiaNhap_SanPham, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(53, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGiaNhap_SanPham)
                    .addComponent(txtGiaNhap_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtGiaBan_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGiaBan))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDonViTinh_SanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblTonKho_SanPham))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 22, Short.MAX_VALUE))
        );

        tblSanPham.setModel(new javax.swing.table.DefaultTableModel(
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
                "Mã Sản Phẩm ", "Tên Sản Phẩm", "Loại Sản Phẩm", "Hãng Sản Xuất", "Giá Nhập", "Giá Bán", "Đơn Vị Tính "
            }
        ));
        tblSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblSanPhamMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblSanPham);

        jPanel5.setBackground(new java.awt.Color(204, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 102, 255), 2), "Chức năng", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14), new java.awt.Color(255, 0, 0))); // NOI18N

        jPanel7.setBackground(new java.awt.Color(204, 255, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 0, 14))); // NOI18N

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

        CBTK.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mã sản phẩm", "Tên sản phẩm", "Loại sản phẩm", "Hãng sản xuất", "Giá nhập", "Giá bán", "Đơn Vị Tính" }));
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

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel7Layout.createSequentialGroup()
                                        .addGap(32, 32, 32)
                                        .addComponent(btnTimKiem)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(20, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CBTK, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTimKiem, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnTimKiem)
                .addContainerGap())
        );

        jLabel15.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/3d-building.jpg"))); // NOI18N

        jButton9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/excel24.png"))); // NOI18N
        jButton9.setText("Thêm file");
        jButton9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

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

        btKhong.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        btKhong.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Close_Icon_Dark_icon-icons.com_69143.png"))); // NOI18N
        btKhong.setText("Không");
        btKhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKhongActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btXoa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThem, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                            .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btGhi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btSua, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btKhong, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btSua))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btXoa)
                    .addComponent(btGhi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btKhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelSanPhamLayout = new javax.swing.GroupLayout(jPanelSanPham);
        jPanelSanPham.setLayout(jPanelSanPhamLayout);
        jPanelSanPhamLayout.setHorizontalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                .addGap(293, 293, 293)
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 651, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(187, Short.MAX_VALUE))
            .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 1128, Short.MAX_VALUE)))
        );
        jPanelSanPhamLayout.setVerticalGroup(
            jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(labelHinhAnh, javax.swing.GroupLayout.PREFERRED_SIZE, 274, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanelSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanelSanPhamLayout.createSequentialGroup()
                    .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 36, Short.MAX_VALUE)))
        );

        jTabbedPaneQuanLySanPham.addTab("Sản Phẩm", jPanelSanPham);

        jPanelLoaiSanPham.setBackground(new java.awt.Color(204, 204, 255));
        jPanelLoaiSanPham.setPreferredSize(new java.awt.Dimension(1030, 600));
        jPanelLoaiSanPham.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                jPanelLoaiSanPhamComponentAdded(evt);
            }
        });
        jPanelLoaiSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelLoaiSanPhamComponentShown(evt);
            }
        });

        tblLoaiSanPham_LoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "STT", "Mã Loại Sản Phẩm ", "Tên Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLoaiSanPham_LoaiSanPham.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLoaiSanPham_LoaiSanPhamMouseClicked(evt);
            }
        });
        tblLoaiSanPham_LoaiSanPham.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tblLoaiSanPham_LoaiSanPhamComponentShown(evt);
            }
        });
        jScrollPane3.setViewportView(tblLoaiSanPham_LoaiSanPham);

        jPanel6.setBackground(new java.awt.Color(204, 204, 255));

        jLabel13.setText("Mã Loại Sản Phẩm");

        jLabel14.setText("Tên Loại Sản Phẩm");

        btnThem_LoaiSanPham.setText("Thêm");
        btnThem_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnSua_LoaiSanPham.setText("Sửa");
        btnSua_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnXoa_LoaiSanPham.setText("Reset");
        btnXoa_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_LoaiSanPhamActionPerformed(evt);
            }
        });

        txtMaLoaiSanPham_LoaiSanPham.setEditable(false);

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel13)
                            .addComponent(jLabel14))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtTenLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(txtMaLoaiSanPham_LoaiSanPham)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(btnThem_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(58, 58, 58)
                        .addComponent(btnSua_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE)
                        .addComponent(btnXoa_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(38, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtMaLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel14)
                    .addComponent(txtTenLoaiSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThem_LoaiSanPham)
                    .addComponent(btnSua_LoaiSanPham)
                    .addComponent(btnXoa_LoaiSanPham))
                .addContainerGap(105, Short.MAX_VALUE))
        );

        jPanel8.setBackground(new java.awt.Color(204, 204, 255));

        tblSanPham_LoaiSanPham.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "STT", "Mã Sản Phẩm ", "Tên Sản Phẩm", "Loại Sản Phẩm"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(tblSanPham_LoaiSanPham);

        jLabel16.setText("Lưu Ý Khi Xóa Loại Sản Phẩm Chứa Sản Phẩm Nằm Trong Hóa Đơn,Phiếu Nhập....");

        btnXoaSP_LoaiSanPham.setText("Xóa Nếu Rông");
        btnXoaSP_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSP_LoaiSanPhamActionPerformed(evt);
            }
        });

        btnSaoLuu_LoaiSanPham.setText("Ẩn các Sản Phẩm ");

        btnXoaSanPham_LoaiSanPham.setText("Thử Xóa Sản Phẩm Trước");
        btnXoaSanPham_LoaiSanPham.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaSanPham_LoaiSanPhamActionPerformed(evt);
            }
        });

        jLabel74.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel74.setForeground(new java.awt.Color(0, 51, 255));
        jLabel74.setText(" Sản Phẩm");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(95, 95, 95)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnSaoLuu_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSP_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnXoaSanPham_LoaiSanPham))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel74)
                .addGap(228, 228, 228)
                .addComponent(jLabel16)
                .addGap(74, 74, 74))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel74)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(btnXoaSP_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSaoLuu_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoaSanPham_LoaiSanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel73.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel73.setForeground(new java.awt.Color(0, 51, 255));
        jLabel73.setText("Loại Sản Phẩm");

        javax.swing.GroupLayout jPanelLoaiSanPhamLayout = new javax.swing.GroupLayout(jPanelLoaiSanPham);
        jPanelLoaiSanPham.setLayout(jPanelLoaiSanPhamLayout);
        jPanelLoaiSanPhamLayout.setHorizontalGroup(
            jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 575, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                        .addGap(364, 364, 364)
                        .addComponent(jLabel73))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(424, Short.MAX_VALUE))
        );
        jPanelLoaiSanPhamLayout.setVerticalGroup(
            jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelLoaiSanPhamLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel73)
                .addGap(18, 18, 18)
                .addGroup(jPanelLoaiSanPhamLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27))
        );

        jTabbedPaneQuanLySanPham.addTab("Loại Sản Phẩm", jPanelLoaiSanPham);

        jPanelPhieuNhap.setBackground(new java.awt.Color(204, 204, 255));
        jPanelPhieuNhap.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanelPhieuNhapComponentShown(evt);
            }
        });

        tblChiTietPhieuNhap_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "STT", "Mã CTPN", "Mã Phiếu Nhập", "Sản Phẩm", "Số Lượng", "Tổng Tiền", "Ghi Chú"
            }
        ));
        tblChiTietPhieuNhap_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblChiTietPhieuNhap_PhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane14.setViewportView(tblChiTietPhieuNhap_PhieuNhap);

        tblPhieuNhap_PhieuNhap.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
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
                "STT", "Mã Phiếu Nhập", "Tên Nhân Viên", "Tên Nhà Cung Cấp", "Tổng Tiền", "Ngày Nhập", "Ghi Chú"
            }
        ));
        tblPhieuNhap_PhieuNhap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPhieuNhap_PhieuNhapMouseClicked(evt);
            }
        });
        jScrollPane18.setViewportView(tblPhieuNhap_PhieuNhap);

        jLabel42.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel42.setForeground(new java.awt.Color(0, 51, 255));
        jLabel42.setText("Chi Tiết Phiếu Nhập");

        jLabel48.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel48.setForeground(new java.awt.Color(0, 51, 255));
        jLabel48.setText(" Phiếu Nhập");

        jPanel24.setBackground(new java.awt.Color(204, 204, 255));

        lblMaPhieuNhap_PhieuNhap.setText("Mã Phiếu Nhập");

        jLabel63.setText("Nhà Cung Cấp");

        jLabel64.setText("Nhân Viên");

        lblNgayLap.setText("Ngày Nhập");
        lblNgayLap.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblNgayLapMouseClicked(evt);
            }
        });
        lblNgayLap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                lblNgayLapKeyReleased(evt);
            }
        });

        cbbNhanVien_PhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbNhanVien_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNhanVien_PhieuNhapActionPerformed(evt);
            }
        });

        txtMaPhieuNhap_PhieuNhap.setEditable(false);

        txtGhiChu_PhieuNhap.setColumns(20);
        txtGhiChu_PhieuNhap.setRows(5);
        jScrollPane20.setViewportView(txtGhiChu_PhieuNhap);

        btnThem_PhieuNhap.setText("Thêm ");
        btnThem_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThem_PhieuNhapActionPerformed(evt);
            }
        });

        btnXoa_PhieuNhap.setText("Xóa");
        btnXoa_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoa_PhieuNhapActionPerformed(evt);
            }
        });

        btnSua_PhieuNhap.setText("Sửa");
        btnSua_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSua_PhieuNhapActionPerformed(evt);
            }
        });

        btnReset_PhieuNhap.setText("Reset");
        btnReset_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReset_PhieuNhapActionPerformed(evt);
            }
        });

        jLabel61.setText("Ghi Chú");

        cbbNhaCungCap_PhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lblTongTien_PhieuNhap.setText("Tổng Tiền");

        txtTongTien_PhieuNhap.setEditable(false);

        cbbThang_PhieuNhap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbThang_PhieuNhapItemStateChanged(evt);
            }
        });

        cbbNam_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbbNam_PhieuNhapActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel24Layout = new javax.swing.GroupLayout(jPanel24);
        jPanel24.setLayout(jPanel24Layout);
        jPanel24Layout.setHorizontalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(lblTongTien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(25, 25, 25)
                        .addComponent(txtTongTien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel61)
                            .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(10, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel24Layout.createSequentialGroup()
                                    .addComponent(btnThem_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnXoa_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnSua_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanel24Layout.createSequentialGroup()
                                                .addComponent(lblMaPhieuNhap_PhieuNhap)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE))
                                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                                .addComponent(jLabel64, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(6, 6, 6)))
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                            .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(24, 24, 24)))
                                    .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel24Layout.createSequentialGroup()
                                            .addComponent(cbbNgay_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbbThang_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(cbbNam_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(cbbNhanVien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtMaPhieuNhap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel24Layout.createSequentialGroup()
                                .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cbbNhaCungCap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnReset_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(88, Short.MAX_VALUE))))
        );
        jPanel24Layout.setVerticalGroup(
            jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel24Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaPhieuNhap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaPhieuNhap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel61))
                .addGap(11, 11, 11)
                .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addComponent(jScrollPane20, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel24Layout.createSequentialGroup()
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNhanVien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbbNhaCungCap_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel63, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgayLap, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNgay_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbThang_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbNam_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTongTien_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTongTien_PhieuNhap))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel24Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnThem_PhieuNhap)
                            .addComponent(btnXoa_PhieuNhap)
                            .addComponent(btnSua_PhieuNhap)
                            .addComponent(btnReset_PhieuNhap))
                        .addGap(16, 16, 16))))
        );

        jPanel25.setBackground(new java.awt.Color(204, 204, 255));

        lblMaCTPN.setText("Mã CTPN");

        lblSoLuong_CTPN.setText("Số Lượng");

        lblMaPhieuNhap.setText("Mã Phiếu Nhập");

        jLabel69.setText("Sản phẩm");

        txtSoLuongCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSoLuongCTPN_PhieuNhapActionPerformed(evt);
            }
        });
        txtSoLuongCTPN_PhieuNhap.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSoLuongCTPN_PhieuNhapKeyReleased(evt);
            }
        });

        cbbSanPhamCTPN_PhieuNhap.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbbSanPhamCTPN_PhieuNhap.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbbSanPhamCTPN_PhieuNhapItemStateChanged(evt);
            }
        });

        txtMaCTPN_PhieuNhap.setEditable(false);

        txtGhiChuCTPN_PhieuNhap.setColumns(20);
        txtGhiChuCTPN_PhieuNhap.setRows(5);
        jScrollPane21.setViewportView(txtGhiChuCTPN_PhieuNhap);

        btnThemCTPN_PhieuNhap.setText("Thêm ");
        btnThemCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnXoaXTPN_PhieuNhap.setText("Xóa");
        btnXoaXTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaXTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnSuaCTPN_PhieuNhap.setText("Sửa");
        btnSuaCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        btnResetCTPN_PhieuNhap.setText("Reset");
        btnResetCTPN_PhieuNhap.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetCTPN_PhieuNhapActionPerformed(evt);
            }
        });

        jLabel70.setText("Ghi Chú");

        jLabel72.setText("Tổng Tiền");

        txtTongTienCTPN_PhieuNhap.setEditable(false);

        txtMaPhieuNhap_CTPN.setEditable(false);

        javax.swing.GroupLayout jPanel25Layout = new javax.swing.GroupLayout(jPanel25);
        jPanel25.setLayout(jPanel25Layout);
        jPanel25Layout.setHorizontalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addComponent(btnThemCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(btnXoaXTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnSuaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnResetCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(23, 23, 23)
                                        .addComponent(cbbSanPhamCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 139, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblSoLuong_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel72, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(23, 23, 23)
                                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtSoLuongCTPN_PhieuNhap)
                                            .addComponent(txtTongTienCTPN_PhieuNhap))))
                                .addGap(1, 1, 1))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel25Layout.createSequentialGroup()
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(lblMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                    .addGroup(jPanel25Layout.createSequentialGroup()
                                        .addComponent(lblMaPhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(5, 5, 5)))
                                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaPhieuNhap_CTPN)
                                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE))))
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(jLabel70))
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        jPanel25Layout.setVerticalGroup(
            jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel25Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMaCTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMaCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel70, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel25Layout.createSequentialGroup()
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel25Layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(lblMaPhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtMaPhieuNhap_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel69, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbbSanPhamCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblSoLuong_CTPN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtSoLuongCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(txtTongTienCTPN_PhieuNhap, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane21, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel25Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnThemCTPN_PhieuNhap)
                    .addComponent(btnXoaXTPN_PhieuNhap)
                    .addComponent(btnSuaCTPN_PhieuNhap)
                    .addComponent(btnResetCTPN_PhieuNhap))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPhieuNhapLayout = new javax.swing.GroupLayout(jPanelPhieuNhap);
        jPanelPhieuNhap.setLayout(jPanelPhieuNhapLayout);
        jPanelPhieuNhapLayout.setHorizontalGroup(
            jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                .addGroup(jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                        .addGap(306, 306, 306)
                        .addComponent(jLabel48))
                    .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                        .addGroup(jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                                .addGap(283, 283, 283)
                                .addComponent(jLabel42))
                            .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane18, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
                            .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jScrollPane14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(250, Short.MAX_VALUE))
        );
        jPanelPhieuNhapLayout.setVerticalGroup(
            jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel48)
                .addGroup(jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(jScrollPane18, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22)
                        .addComponent(jLabel42))
                    .addGroup(jPanelPhieuNhapLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jPanel24, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPhieuNhapLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane14, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel25, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        jTabbedPaneQuanLySanPham.addTab("Phiếu Nhập Hàng", jPanelPhieuNhap);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1416, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPaneQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 601, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTabbedPaneQuanLySanPham, javax.swing.GroupLayout.PREFERRED_SIZE, 589, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblSanPhamMouseClicked
        int index = tblSanPham.getSelectedRow();
        TableModel model = tblSanPham.getModel();
        MaSanPham = model.getValueAt(index, 0).toString();
        TenSanPham= model.getValueAt(index, 1).toString();
        LoaiSanPham = model.getValueAt(index, 2).toString();
        HangSanXuat = model.getValueAt(index, 3).toString();
        GiaNhap= model.getValueAt(index, 4).toString();
        GiaBan = model.getValueAt(index, 5).toString();
        DonViTinh = model.getValueAt(index, 6).toString();
        
        txtMaSanPham_SanPham.setText(MaSanPham);
        txtTenSanPham_SanPham.setText(TenSanPham);
        cbbLoaiSanPham_SanPham.setSelectedItem(LoaiSanPham);
        txtHangSanXuat_SanPham.setText(HangSanXuat);
        txtGiaNhap_SanPham.setText(GiaNhap);
        txtGiaBan_SanPham.setText(GiaBan);        
        txtDonViTinh_SanPham.setText(DonViTinh);     
    }//GEN-LAST:event_tblSanPhamMouseClicked

    private void btnMoTabXB_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMoTabXB_SanPhamActionPerformed
//        frmSanPhamAn frmspa = new frmSanPhamAn();
//        frmspa.show();
    }//GEN-LAST:event_btnMoTabXB_SanPhamActionPerformed

    private void jPanelSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelSanPhamComponentShown
          cbbLoaiSanPham_SanPham.setModel(LayDuLieucbb("LoaiSanPham", "TenLoaiSanPham", "MaLoaiSanPham"));
//        cbbHangSanXuat_SanPham.setModel(LayDuLieucbb("HangSanXuat", "TenHangSanXuat", "MaHangSanXuat"));
//        cbbTimKiemLoaiSanPham_SanPham.setModel(LayDuLieucbb("LoaiSanPham", "TenLoaiSanPham", "MaLoaiSanPham"));
    }//GEN-LAST:event_jPanelSanPhamComponentShown

    private void tblLoaiSanPham_LoaiSanPhamMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLoaiSanPham_LoaiSanPhamMouseClicked
        int viTriDongVuaBam = tblLoaiSanPham_LoaiSanPham.getSelectedRow();
        txtMaLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham_LoaiSanPham.getValueAt(viTriDongVuaBam, 1).toString());
        txtTenLoaiSanPham_LoaiSanPham.setText(tblLoaiSanPham_LoaiSanPham.getValueAt(viTriDongVuaBam, 2).toString());
        LayDuLieuSanPhamofLoaiSanPham(txtMaLoaiSanPham_LoaiSanPham.getText());
    }//GEN-LAST:event_tblLoaiSanPham_LoaiSanPhamMouseClicked

    private void tblLoaiSanPham_LoaiSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tblLoaiSanPham_LoaiSanPhamComponentShown

    }//GEN-LAST:event_tblLoaiSanPham_LoaiSanPhamComponentShown

    private void btnThem_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_LoaiSanPhamActionPerformed
        String MaLoaiSanPham, TenLoaiSanPham;
        MaLoaiSanPham = txtMaLoaiSanPham_LoaiSanPham.getText();
        TenLoaiSanPham = txtTenLoaiSanPham_LoaiSanPham.getText();
        String cautruyvan = "insert into LoaiSanPham values("
                + " N'" + TenLoaiSanPham + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if (!txtTenLoaiSanPham_LoaiSanPham.equals("")) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm loại sản phẩm", "lỗi", 2);
        }
        layDuLieuLoaiSanPham();
    }//GEN-LAST:event_btnThem_LoaiSanPhamActionPerformed

    private void btnSua_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_LoaiSanPhamActionPerformed
        String MaLoaiSanPham, TenLoai;
        MaLoaiSanPham = txtMaLoaiSanPham_LoaiSanPham.getText();
        TenLoai = txtTenLoaiSanPham_LoaiSanPham.getText();
        String cautruyvan = "update LoaiSanPham set"
        + " TenLoaiSanPham=N'" + TenLoai + "'where MaLoaiSanPham=" + MaLoaiSanPham;
        if (!txtTenLoaiSanPham_LoaiSanPham.equals("")) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã sửa Thành Công");
        } else {
            ThongBao("Bạn chưa nhập tên loại sản phẩm", TenLoai, 2);
        }
        layDuLieuLoaiSanPham();
    }//GEN-LAST:event_btnSua_LoaiSanPhamActionPerformed

    private void btnXoa_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_LoaiSanPhamActionPerformed

    }//GEN-LAST:event_btnXoa_LoaiSanPhamActionPerformed

    private void btnXoaSP_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSP_LoaiSanPhamActionPerformed
//
//        String MaLoai = txtMaLoaiSanPham_LoaiSanPham.getText();
//        if (!MaLoai.equals("")) {
//            String cautruyvan = "delete LoaiSanPham where MaLoaiSanPham=" + MaLoai;
//            String ctvKiemThu = "select count(MaSanPham) as SoSanPham"
//            + " from SanPham,LoaiSanPham where SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham"
//            + " and  LoaiSanPham.MaLoaiSanPham=" + MaLoai;
//            ResultSet rs1 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu);
//            System.out.println(ctvKiemThu);
//            int so1 = 0;
//            try {
//                if (rs1.next()) {
//                    so1 = rs1.getInt("SoSanPham");
//                    if (rs1.getInt("SoSanPham") == 0) {
//                        Main.MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
//                        System.out.println("đã xóa");
//                        layDuLieuLoaiSanPham();
//                    } else {
//                        ThongBao("không thể xóa bởi Loại Sản Phẩm đã có " + so1 + " Sản Phẩm!", "báo lỗi", 2);
//                    }
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        } else {
//            ThongBao("bạn chưa click chuột vô bảng!", "làm ơn! hãy chứng minh bạn còn khả năng của cánh tay!!", 2);
//        }
    }//GEN-LAST:event_btnXoaSP_LoaiSanPhamActionPerformed

    private void btnXoaSanPham_LoaiSanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaSanPham_LoaiSanPhamActionPerformed
//
//        String MaSanPham = txtMaSanPham_SanPham.getText();
//        String cautruyvan = "delete SanPham ";
//        String ctvKiemThu = "select count(MaCTHD) as SoChiTietHoaDon"
//        + " from SanPham,ChiTietHoaDon where SanPham.MaSanPham=ChiTietHoaDon.MaSanPham ";
//        ResultSet rs1 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu);
//        String ctvKiemThu2 = "select count(MaCTPN) as SoChiTietPhieuNhap"
//        + " from SanPham,ChiTietPhieuNhap where SanPham.MaSanPham=ChiTietPhieuNhap.MaSanPham ";
//        ResultSet rs2 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu2);
//        int so1 = 0, so2 = 0;
//
//        try {
//            if (rs1.next()) {
//                so1 = rs1.getInt("SoChiTietHoaDon");
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//        try {
//
//            if (rs2.next()) {
//                so2 = rs2.getInt("SoChiTietPhieuNhap");
//                if (rs2.getInt("SoChiTietPhieuNhap") == 0 && so1 == 0) {
//                    Main.MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
//                    System.out.println("đã xóa");
//                    LayDuLieuSanPhamofLoaiSanPham(MaSanPham);
//
//                } else {
//                    ThongBao("không thể xóa bởi có trong " + so1 + "  Chi tiết hóa đơn hóa đơn \n và có trong "
//                        + so2 + "  chi tiết phiếu Nhập", "báo lỗi", 2);
//                }
//            }
//
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
    }//GEN-LAST:event_btnXoaSanPham_LoaiSanPhamActionPerformed

    private void jPanelLoaiSanPhamComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_jPanelLoaiSanPhamComponentAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanelLoaiSanPhamComponentAdded

    private void jPanelLoaiSanPhamComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelLoaiSanPhamComponentShown
            layDuLieuLoaiSanPham();
            System.out.println("vô sản Phẩm");
    }//GEN-LAST:event_jPanelLoaiSanPhamComponentShown
    public int tam1 = 0;
    private void cbbLoaiSanPham_SanPhamActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbLoaiSanPham_SanPhamActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbLoaiSanPham_SanPhamActionPerformed

    private void txtTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTimKiemActionPerformed
        //loadDataTableS();
    }//GEN-LAST:event_txtTimKiemActionPerformed

    private void btnTimKiemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTimKiemActionPerformed
        //loadDataTableS();
    }//GEN-LAST:event_btnTimKiemActionPerformed

    private void CBTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CBTKActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_CBTKActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        txtTimKiem.setText("");
        //loadDataTableS();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed

    }//GEN-LAST:event_jButton9ActionPerformed

    private void btThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemActionPerformed
        XoaTrang();
        KhoaMo(false);
        ktThem = true;
        txtMaSanPham_SanPham.requestFocus();
    }//GEN-LAST:event_btThemActionPerformed

    private void btSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaActionPerformed
        if(txtMaSanPham_SanPham.getText().length()<=0)
        return;
        macu = txtMaSanPham_SanPham.getText();
        ktThem = false;
        KhoaMo(false);
        txtMaSanPham_SanPham.requestFocus();
    }//GEN-LAST:event_btSuaActionPerformed

    private void btXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaActionPerformed
        if(txtMaSanPham_SanPham.getText().length()<=0)
        return;
        int kq = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa [" + txtMaSanPham_SanPham.getText() + "] không ?","Thông báo",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (kq == JOptionPane.YES_OPTION) {
            macu = txtMaSanPham_SanPham.getText();
            CSanPham.XoaBo(macu);
            LayNguonSP();
            XoaTrang();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btXoaActionPerformed

    private void btKhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKhongActionPerformed
        XoaTrang();
        KhoaMo(true);
    }//GEN-LAST:event_btKhongActionPerformed

    private void btGhiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btGhiActionPerformed
        //kiểm tra dữ liệu rỗng
        if(txtMaSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập mã sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        if(txtTenSanPham_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập tên sản phẩm","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtTenSanPham_SanPham.requestFocus();
            return;
        }
        if(txtGiaNhap_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá nhập","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtGiaNhap_SanPham.requestFocus();
            return;
        }
        if(txtGiaBan_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập giá bán","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtGiaBan_SanPham.requestFocus();
            return;
        }
        if(txtDonViTinh_SanPham.getText().length()<=0){
            JOptionPane.showMessageDialog(this, "Bạn chưa nhập đơn vị tính","Thông Báo",JOptionPane.WARNING_MESSAGE);
            txtDonViTinh_SanPham.requestFocus();
            return;
        }

        //kiểm tra tính hợp lệ của dữ liệu
        //kiểm tra trùng mã (trùng khóa chính - xây dựng hàm kiểm tra trong controlle)
        if(KiemTraDuLieu_Controller.KiemTraTrungMa("SanPham", "MaSanPham", txtMaSanPham_SanPham.getText(), ktThem, macu)==true){
            JOptionPane.showMessageDialog(this, "Bạn nhập trùng mã lớp","Thông báo",JOptionPane.ERROR_MESSAGE);
            txtMaSanPham_SanPham.requestFocus();
            return;
        }
        //thực hiện ghi

        MaSanPham   = txtMaSanPham_SanPham.getText();
        TenSanPham  = txtTenSanPham_SanPham.getText();
        LoaiSanPham = GetCbbSelected(cbbLoaiSanPham_SanPham);
        HangSanXuat = txtHangSanXuat_SanPham.getText();
        GiaNhap     = txtGiaNhap_SanPham.getText();
        GiaBan      = txtGiaBan_SanPham.getText();
        DonViTinh   = txtDonViTinh_SanPham.getText();

        SanPham nv = new SanPham(MaSanPham, TenSanPham, LoaiSanPham, HangSanXuat, GiaNhap, GiaBan, DonViTinh);
        if(ktThem==true){
            CSanPham.ThemMoi(nv);
        }
        else{
            CSanPham.CapNhat(nv, macu);
        }
        //lấy nguồn dữ liệu mới
        LayNguonSP();
        KhoaMo(true);
    }//GEN-LAST:event_btGhiActionPerformed

    private void tblChiTietPhieuNhap_PhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked
        int viTriDongVuaBam = tblChiTietPhieuNhap_PhieuNhap.getSelectedRow();
        txtMaCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 1).toString());
        txtMaPhieuNhap_CTPN.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 2).toString());
        setSelectedCombobox(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 3).toString(), cbbSanPhamCTPN_PhieuNhap);
        txtSoLuongCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 4).toString());
        txtTongTienCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 5).toString());
        txtGhiChuCTPN_PhieuNhap.setText(tblChiTietPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 6).toString());
    }//GEN-LAST:event_tblChiTietPhieuNhap_PhieuNhapMouseClicked

    private void tblPhieuNhap_PhieuNhapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPhieuNhap_PhieuNhapMouseClicked
        int viTriDongVuaBam = tblPhieuNhap_PhieuNhap.getSelectedRow();
        txtMaPhieuNhap_PhieuNhap.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 1).toString());
        txtTongTien_PhieuNhap.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 4).toString());
        txtGhiChu_PhieuNhap.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 6).toString());
        setSelectedCombobox(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 3).toString(), cbbNhaCungCap_PhieuNhap);
        setSelectedCombobox(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 2).toString(), cbbNhanVien_PhieuNhap);

        LayDuLieuChiTietPhieuNhap(txtMaPhieuNhap_PhieuNhap.getText());
        String ngaynhap = tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 5).toString();
        System.out.println("" + ngaynhap);
        String strngay, strthang, strnam;
        strngay = ngaynhap.substring(8, 10);
        strthang = ngaynhap.substring(5, 7);
        strnam = ngaynhap.substring(0, 4);
        int ngay, thang, nam;
        ngay = Integer.valueOf(strngay);
        thang = Integer.valueOf(strthang);
        nam = Integer.valueOf(strnam);
        cbbNgay_PhieuNhap.setSelectedItem(String.valueOf(ngay));
        cbbThang_PhieuNhap.setSelectedItem(String.valueOf(thang));
        cbbNam_PhieuNhap.setSelectedItem(String.valueOf(nam));
        txtMaPhieuNhap_CTPN.setText(tblPhieuNhap_PhieuNhap.getValueAt(viTriDongVuaBam, 1).toString());
    }//GEN-LAST:event_tblPhieuNhap_PhieuNhapMouseClicked

    private void lblNgayLapMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNgayLapMouseClicked
        cbbNgay_PhieuNhap.setSelectedItem(String.valueOf(day));
        cbbThang_PhieuNhap.setSelectedItem(String.valueOf(month));
        cbbNam_PhieuNhap.setSelectedItem(String.valueOf(year));
    }//GEN-LAST:event_lblNgayLapMouseClicked

    private void lblNgayLapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lblNgayLapKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_lblNgayLapKeyReleased

    private void btnThem_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThem_PhieuNhapActionPerformed
        String MaPhieuNhap, MaNhanVien, MaNCC, TongTien, NgayNhap, GhiChu;
        MaPhieuNhap = txtMaPhieuNhap_PhieuNhap.getText();
        MaNhanVien = GetCbbSelected(cbbNhanVien_PhieuNhap);
        MaNCC = GetCbbSelected(cbbNhaCungCap_PhieuNhap);
        String ngay, thang, nam;
        ngay = cbbNgay_PhieuNhap.getSelectedItem().toString();
        thang = cbbThang_PhieuNhap.getSelectedItem().toString();
        nam = cbbNam_PhieuNhap.getSelectedItem().toString();
        NgayNhap = nam + "-" + thang + "-" + ngay;
        TongTien = txtTongTien_PhieuNhap.getText();
        TongTien = "0";
        GhiChu = txtGhiChu_PhieuNhap.getText();
        PhieuNhap pn = new PhieuNhap(MaPhieuNhap, MaNhanVien, MaNCC, NgayNhap, TongTien, GhiChu);
            
        //lấy nguồn dữ liệu mới
        boolean kiemtra = KiemTraNhapPhieuNhap(0);
        if (kiemtra) {
            CPhieuNhap.ThemMoi(pn);
            System.out.println("Đã Thêm Thành Công");           
        } else {
            System.out.println("Thêm Thất Bại");
        }
        LayDuLieuPhieuNhap();
        //SetTongTien(MaPhieuNhap);
    }//GEN-LAST:event_btnThem_PhieuNhapActionPerformed

    private void btnXoa_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoa_PhieuNhapActionPerformed
        if (!txtMaPhieuNhap_PhieuNhap.getText().equals("")) {
            String MaPhieuNhap = txtMaPhieuNhap_PhieuNhap.getText();
            String cautruyvan = "delete PhieuNhap where MaPhieuNhap=" + MaPhieuNhap;
            String ctvKiemThu = "select count(MaCTPN) as SoChiTietPhieuMua"
            + " from PhieuNhap,ChiTietPhieuNhap where PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap and "
            + "PhieuNhap.MaPhieuNhap= " + MaPhieuNhap;
            ResultSet rs1 = Main.MainClass.connection.ExcuteQueryGetTable(ctvKiemThu);
            System.out.println(ctvKiemThu);
            int so1 = 0;
            try {
                if (rs1.next()) {
                    so1 = rs1.getInt("SoChiTietPhieuMua");
                    if (rs1.getInt("SoChiTietPhieuMua") == 0) {
                        Main.MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
                        System.out.println("đã xóa");
                        LayDuLieuPhieuNhap();
                    } else {
                        ThongBao("không thể xóa bởi Phiếu nhập đã có " + so1 + " chi tiết Phiếu nhập!", "báo lỗi", 2);
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(FrameMain.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            ThongBao("bạn chưa chọn Phiếu nhập để xóa", "xóa bằng niềm tin à!khi không biết xóa cái nào", 2);
        }
    }//GEN-LAST:event_btnXoa_PhieuNhapActionPerformed

    private void btnSua_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSua_PhieuNhapActionPerformed
        String MaPhieuNhap, MaNhanVien, MaNCC, TongTien, NgayNhap, GhiChu;
        MaPhieuNhap = txtMaPhieuNhap_PhieuNhap.getText();
        MaNhanVien = GetCbbSelected(cbbNhanVien_PhieuNhap);
        MaNCC = GetCbbSelected(cbbNhaCungCap_PhieuNhap);
        String ngay, thang, nam;
        ngay = cbbNgay_PhieuNhap.getSelectedItem().toString();
        thang = cbbThang_PhieuNhap.getSelectedItem().toString();
        nam = cbbNam_PhieuNhap.getSelectedItem().toString();
        NgayNhap = nam + "-" + thang + "-" + ngay;
        TongTien = txtTongTien_PhieuNhap.getText();
        GhiChu = txtGhiChu_PhieuNhap.getText();
        String cautruyvan = "update  PhieuNhap set "
        + " MaNhanVien= " + MaNhanVien + " , MaNCC=" + MaNCC + " ,TongTien=" + TongTien
        + ",NgayNhap='" + NgayNhap + "', GhiChu=N'" + GhiChu + "'where MaPhieuNhap=" + MaPhieuNhap;
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if (!txtMaPhieuNhap_PhieuNhap.equals("")) {
            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Sửa Thành Công");
        } else {
            ThongBao("Bạn chọn phiếu nhập!", "lỗi", 2);
        }
        LayDuLieuPhieuNhap();
    }//GEN-LAST:event_btnSua_PhieuNhapActionPerformed

    private void btnReset_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReset_PhieuNhapActionPerformed
        String MaPhieuNhap, TongTien, NgayLap, ChuThich;
//        txtMaKhachHang_KhachHang.setText("");
//        txtTenKhachHang_KhachHang.setText("");
        cbbNhaCungCap_PhieuNhap.setSelectedIndex(1);
        cbbNgay_PhieuNhap.setSelectedIndex(1);
        cbbThang_PhieuNhap.setSelectedIndex(1);
        cbbNam_PhieuNhap.setSelectedIndex(1);
        txtMaPhieuNhap_PhieuNhap.setText("");
        txtTongTien_PhieuNhap.setText("");
        txtGhiChu_PhieuNhap.setText("");
        cbbNhanVien_PhieuNhap.setSelectedIndex(1);

    }//GEN-LAST:event_btnReset_PhieuNhapActionPerformed

    private void cbbThang_PhieuNhapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbThang_PhieuNhapItemStateChanged

        String thang = cbbThang_PhieuNhap.getSelectedItem().toString();
        DefaultComboBoxModel cbbmodel = new DefaultComboBoxModel();
        String thanght;
        if (tam1 == 0) {
            thanght = "0";
        } else {
            thanght = cbbNgay_PhieuNhap.getSelectedItem().toString();
        }
        tam1 = 1;

        if (thang.equals("4") || thang.equals("6") || thang.equals("9") || thang.equals("11")) {
            cbbNgay_PhieuNhap.setModel(cbbmodel);
            for (int i = 1; i < 31; i++) {
                cbbNgay_PhieuNhap.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 31) {
                cbbNgay_PhieuNhap.setSelectedItem(thanght);
            }
        } else if (thang.equals("1") || thang.equals("3") || thang.equals("5")
            || thang.equals("7") || thang.equals("8") || thang.equals("12") || thang.equals("10")) {

            cbbNgay_PhieuNhap.setModel(cbbmodel);
            for (int i = 1; i < 32; i++) {
                cbbNgay_PhieuNhap.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 32) {
                cbbNgay_PhieuNhap.setSelectedItem(thanght);
            }
        } else {
            cbbNgay_PhieuNhap.setModel(cbbmodel);
            for (int i = 1; i < 29; i++) {
                cbbNgay_PhieuNhap.addItem(String.valueOf(i));
            }
            if (Integer.valueOf(thanght) < 29) {
                cbbNgay_PhieuNhap.setSelectedItem(thanght);
            }
        }
    }//GEN-LAST:event_cbbThang_PhieuNhapItemStateChanged

    private void cbbNam_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNam_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNam_PhieuNhapActionPerformed

    private void txtSoLuongCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSoLuongCTPN_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSoLuongCTPN_PhieuNhapActionPerformed

    private void txtSoLuongCTPN_PhieuNhapKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSoLuongCTPN_PhieuNhapKeyReleased
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuongCTPN_PhieuNhap.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPhamCTPN_PhieuNhap));
        Tien = (double) Gia * SoLuong;
        txtTongTienCTPN_PhieuNhap.setText(String.valueOf(Tien));
    }//GEN-LAST:event_txtSoLuongCTPN_PhieuNhapKeyReleased

    private void cbbSanPhamCTPN_PhieuNhapItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbbSanPhamCTPN_PhieuNhapItemStateChanged
        int SoLuong = 0;
        double Tien = 0;
        try {
            SoLuong = Integer.valueOf(txtSoLuongCTPN_PhieuNhap.getText());
        } catch (Exception e) {
        }
        int Gia = GetGiaSanPham(GetCbbSelected(cbbSanPhamCTPN_PhieuNhap));
        Tien = (double) Gia * SoLuong;
        txtTongTienCTPN_PhieuNhap.setText(String.valueOf(Tien));
    }//GEN-LAST:event_cbbSanPhamCTPN_PhieuNhapItemStateChanged

    private void btnThemCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemCTPN_PhieuNhapActionPerformed
        String MaCTPN,MaPhieuNhap,MaSanPham,SoLuong,TongTien,ChuThich;
        MaCTPN=txtMaCTPN_PhieuNhap.getText();
        MaPhieuNhap=txtMaPhieuNhap_PhieuNhap.getText();
        MaSanPham=GetCbbSelected(cbbSanPhamCTPN_PhieuNhap);
        SoLuong=txtSoLuongCTPN_PhieuNhap.getText();
        TongTien=txtTongTienCTPN_PhieuNhap.getText();
        ChuThich=txtGhiChuCTPN_PhieuNhap.getText();

        String tb="", cautruyvan = "insert into ChiTietPhieuNhap values("
        + " " + MaPhieuNhap + " , " + MaSanPham + " ," + SoLuong
        + "," + TongTien + ", N'" + ChuThich + "')";
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if(txtSoLuongCTPN_PhieuNhap.equals("")){
            tb+="Chưa nhập Số lượng";
            kiemtra=false;}
        try {
            int bien= Integer.valueOf(txtSoLuongCTPN_PhieuNhap.getText());

        } catch (Exception e) {
            kiemtra=false;
            tb+="Số lượng phải nhập bằng số";
        }
        if (!txtMaPhieuNhap_CTPN.equals("") && kiemtra==true) {

            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã Thêm Thành Công");
        } else {
            ThongBao("Không thể Thêm ", "lỗi", 2);
        }
        LayDuLieuChiTietPhieuNhap(txtMaPhieuNhap_CTPN.getText());
        SetTongTien(MaPhieuNhap);
    }//GEN-LAST:event_btnThemCTPN_PhieuNhapActionPerformed

    private void btnXoaXTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaXTPN_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnXoaXTPN_PhieuNhapActionPerformed

    private void btnSuaCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaCTPN_PhieuNhapActionPerformed
        String MaCTPN,MaPhieuNhap,MaSanPham,SoLuong,TongTien,ChuThich;
        MaCTPN=txtMaCTPN_PhieuNhap.getText();
        MaPhieuNhap=txtMaPhieuNhap_PhieuNhap.getText();
        MaSanPham=GetCbbSelected(cbbSanPhamCTPN_PhieuNhap);
        SoLuong=txtSoLuongCTPN_PhieuNhap.getText();
        TongTien=txtTongTienCTPN_PhieuNhap.getText();
        ChuThich=txtGhiChuCTPN_PhieuNhap.getText();

        String tb="", cautruyvan = "update  ChiTietPhieuNhap set "
        + " "  + " MaSanPham= " + MaSanPham + " ,SoLuong=" + SoLuong
        + ",TongTien=" + TongTien + ", ChuThich=N'" + ChuThich + "'where MaCTPN="+MaCTPN;
        System.out.println(cautruyvan);
        boolean kiemtra = true;
        if(txtSoLuongCTPN_PhieuNhap.equals("")){
            tb+="Chưa nhập Số lượng";
            kiemtra=false;}
        try {
            int bien= Integer.valueOf(txtSoLuongCTPN_PhieuNhap.getText());

        } catch (Exception e) {
            kiemtra=false;
            tb+="Số lượng phải nhập bằng số";
        }
        if (!txtMaPhieuNhap_CTPN.equals("") && kiemtra==true) {

            MainClass.connection.ExcuteQueryUpdateDB(cautruyvan);
            System.out.println("Đã sửa Thành Công");
        } else {
            ThongBao("Không thể Thêm ", "lỗi", 2);
        }
        LayDuLieuChiTietPhieuNhap(txtMaPhieuNhap_CTPN.getText());
    }//GEN-LAST:event_btnSuaCTPN_PhieuNhapActionPerformed

    private void btnResetCTPN_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetCTPN_PhieuNhapActionPerformed
        txtMaCTPN_PhieuNhap.setText("");
        txtMaPhieuNhap_CTPN.setText("");
        cbbSanPhamCTPN_PhieuNhap.setSelectedIndex(1);
        txtSoLuongCTPN_PhieuNhap.setText("");
        txtTongTienCTPN_PhieuNhap.setText("");
        txtGhiChuCTPN_PhieuNhap.setText("");
    }//GEN-LAST:event_btnResetCTPN_PhieuNhapActionPerformed

    private void jPanelPhieuNhapComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanelPhieuNhapComponentShown
        LayDuLieuPhieuNhap();
        cbbNhaCungCap_PhieuNhap.setModel(LayDuLieucbb("NhaCungCap", "TenNCC", "MaNCC"));
        cbbNhanVien_PhieuNhap.setModel(LayDuLieucbb("NhanVien", "TenNhanVien", "MaNhanVien"));
        cbbSanPhamCTPN_PhieuNhap.setModel(LayDuLieucbb("SanPham","TenSanPham","MaSanPham"));
        for (int i = 1; i < 32; i++) {
            cbbNgay_PhieuNhap.addItem(String.valueOf(i));
        }
        for (int i = 1; i < 13; i++) {
            cbbThang_PhieuNhap.addItem(String.valueOf(i));
        }
        for (int i = 2050; i > 1950; i--) {
            cbbNam_PhieuNhap.addItem(String.valueOf(i));
        }
        cbbNgay_PhieuNhap.setSelectedItem(String.valueOf(day));
        cbbThang_PhieuNhap.setSelectedItem(String.valueOf(month));
        cbbNam_PhieuNhap.setSelectedItem(String.valueOf(year));
//        txtNgayLapPhieuNhap_PhieuNhap.setText(year+"-"+month+"-"+day);
    }//GEN-LAST:event_jPanelPhieuNhapComponentShown

    private void cbbNhanVien_PhieuNhapActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbbNhanVien_PhieuNhapActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbbNhanVien_PhieuNhapActionPerformed
  
//
//
//    public void LayDuLieuSanPham(String TrangThai) {
//        String cautruyvan = "";
//        cautruyvan = "select MaSanPham,SanPham.TenSanPham,SanPham.LoaiSanPham,GiaNhap,GiaBan,HangsanXuat.TenHangSanXuat as THSX,TonKho,LoaiSanPham.TenLoaiSanPham"
//                + " as TenLoaiSanPham,Image,SanPham.ChuThich from SanPham,LoaiSanPham,HangSanXuat where "
//                + "SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham and SanPham.HangSanXuat=HangSanXuat.MaHangSanXuat and TrangThai=" + TrangThai;
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"STT", "Mã Sản Phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá nhập", "Giá bán", "Hãng sản Xuất", "Tồn kho", "ảnh", "Chú Thích"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblSanPham.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rs.next()) {
//                c++;
//                Object[] item = new Object[10];
//                item[0] = c;
//                item[1] = rs.getInt("MaSanPham");
//                item[2] = rs.getString("TenSanPham");
//                item[3] = rs.getString("TenLoaiSanPham");
//                item[4] = rs.getInt("GiaNhap");
//                item[5] = rs.getInt("GiaBan");
//                item[6] = rs.getString("THSX");
//                item[7] = rs.getInt("TonKho");
//                item[8] = rs.getString("Image");
//                item[9] = rs.getString("ChuThich");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }
    public int GetGiaSanPham(String MaSP) {
        int Gia = 0;
        String cautruyvan = "select * from SanPham where MaSanPham=" + MaSP;
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        try {
            if (rs.next()) {
                Gia = rs.getInt("GiaNhap");
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
        return Gia;
    }
//    public void TimKiemSanPham() {
//        String wheretk = "";
//        if (rbtnTimKiemMaSanPham_SanPham.isSelected()) {
//            wheretk = "MaSanPham= " + txtTimKiem_SanPham.getText();
//        } else if (rbtnTimKiemTenSanPham_SanPham.isSelected()) {
//            wheretk = "TenSanPham like N'%" + txtTimKiem_SanPham.getText() + "%'";;
//        } else if (rbtnTimKiemLoaiSanPham_SanPham.isSelected()) {
//            wheretk = "LoaiSanPham= " + GetCbbSelected(cbbTimKiemLoaiSanPham_SanPham);
//        }
//        String cautruyvan = "";
//        cautruyvan = "select MaSanPham,SanPham.TenSanPham,SanPham.LoaiSanPham,GiaNhap,GiaBan,HangsanXuat.TenHangSanXuat as THSX,TonKho,LoaiSanPham.TenLoaiSanPham"
//                + " as TenLoaiSanPham,Image,SanPham.ChuThich from SanPham,LoaiSanPham,HangSanXuat where "
//                + "SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham and SanPham.HangSanXuat=HangSanXuat.MaHangSanXuat and TrangThai=1 and " + wheretk;
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"STT", "Mã Sản Phẩm", "Tên sản phẩm", "Loại sản phẩm", "Giá nhập", "Giá bán", "Hãng sản Xuất", "Tồn kho", "ảnh", "Chú Thích"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblSanPham.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rs.next()) {
//                c++;
//                Object[] item = new Object[10];
//                item[0] = c;
//                item[1] = rs.getInt("MaSanPham");
//                item[2] = rs.getString("TenSanPham");
//                item[3] = rs.getString("TenLoaiSanPham");
//                item[4] = rs.getInt("GiaNhap");
//                item[5] = rs.getInt("GiaBan");
//                item[6] = rs.getString("THSX");
//                item[7] = rs.getInt("TonKho");
//                item[8] = rs.getString("Image");
//                item[9] = rs.getString("ChuThich");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }
    public void LayDuLieuSanPhamofLoaiSanPham(String MaLoaiSanPham) {
        String cautruyvan = "";
        cautruyvan = "select MaSanPham,SanPham.TenSanPham,LoaiSanPham.TenLoaiSanPham"
                + " as TenLoaiSanPham from SanPham,LoaiSanPham where"
                + " SanPham.LoaiSanPham=LoaiSanPham.MaLoaiSanPham and MaLoaiSanPham=" + MaLoaiSanPham;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Sản Phẩm", "Tên sản phẩm", "Loại sản phẩm"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblSanPham_LoaiSanPham.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[4];
                item[0] = c;
                item[1] = rs.getInt("MaSanPham");
                item[2] = rs.getString("TenSanPham");
                item[3] = rs.getString("TenLoaiSanPham");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void layDuLieuLoaiSanPham() {
        String cautruyvan = "";
        cautruyvan = "select * from LoaiSanPham ";
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Loại", "Tên Loại"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblLoaiSanPham_LoaiSanPham.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                c++;
                Object[] item = new Object[3];
                item[0] = c;
                item[1] = rs.getInt("MaLoaiSanPham");
                item[2] = rs.getString("TenLoaiSanPham");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
//
    public void LayDuLieuPhieuNhap() {
        String cautruyvan = "";
        cautruyvan = "select MaPhieuNhap,NhanVien.TenNhanVien,NhaCungCap.TenNCC,TongTien,NgayNhap,PhieuNhap.GhiChu"
                + " from PhieuNhap,NhanVien,NhaCungCap where PhieuNhap.MaNhanVien =NhanVien.MaNhanVien and PhieuNhap.MaNCC=NhaCungCap.MaNCC ";
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã Phiếu Nhập", "Tên Nhân Viên", "Tên Nhà Cung Cấp", "Thành tiền", "Ngày lập", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblPhieuNhap_PhieuNhap.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getInt("MaPhieuNhap");
                item[2] = rs.getString("TenNhanVien");
                item[3] = rs.getString("TenNCC");
                item[4] = rs.getString("TongTien");
                item[5] = rs.getString("NgayNhap");
                item[6] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
    public void LayDuLieuChiTietPhieuNhap(String MaPhieuNhap) {
        String cautruyvan = "";
        cautruyvan = "select MaCTPN,ChiTietPhieuNhap.MaPhieuNhap ,SanPham.TenSanPham,ChiTietPhieuNhap.SoLuong,"
                + "ChiTietPhieuNhap.TongTien,ChiTietPhieuNhap.GhiChu"
                + " from PhieuNhap,ChiTietPhieuNhap,SanPham where "
                + "PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap and"
                + " SanPham.MaSanPham=ChiTietPhieuNhap.MaSanPham and ChiTietPhieuNhap.MaPhieuNhap=" + MaPhieuNhap;
        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        Object[] obj = new Object[]{"STT", "Mã CTPN", "Mã Phiếu Nhập", "Sản Phẩm", "Số Lượng", "Tổng Tiền", "Ghi Chú"};
        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
        tblChiTietPhieuNhap_PhieuNhap.setModel(tableModel);
        int c = 0;
        try {
            while (rs.next()) {
                Object[] item = new Object[7];
                c++;
                item[0] = c;
                item[1] = rs.getInt("MaCTPN");
                item[2] = rs.getInt("MaPhieuNhap");
                item[3] = rs.getString("TenSanPham");
                item[4] = rs.getString("Soluong");
                item[5] = rs.getString("TongTien");
                item[6] = rs.getString("GhiChu");
                tableModel.addRow(item);
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }
    }
//    public void layDuLieuChucVu() {
//        String cautruyvan = "";
//        cautruyvan = "select * from ChucVu ";
//        ResultSet rs = MainClass.connection.ExcuteQueryGetTable(cautruyvan);
//        Object[] obj = new Object[]{"STT", "Mã ", "Tên Chức Vụ", "Ghi Chú"};
//        DefaultTableModel tableModel = new DefaultTableModel(obj, 0);
//        tblChucVu_ChucVu.setModel(tableModel);
//        int c = 0;
//        try {
//            while (rs.next()) {
//                c++;
//                Object[] item = new Object[4];
//                item[0] = c;
//                item[1] = rs.getInt("MaChucVu");
//                item[2] = rs.getString("TenChucVu");
//                item[3] = rs.getString("GhiChu");
//                tableModel.addRow(item);
//            }
//        } catch (SQLException ex) {
//            System.out.println(ex.toString());
//        }
//    }
//
//  
//          public boolean KiemTraNhanSanPham(int ts) {
//        String MaSanPham, TenSanPham, GiaNhap,GiaBan,TonKho;
//        boolean kiemtra = false;
//        MaSanPham = txtMaSanPham_SanPham.getText();
//        TenSanPham = txtTenSanPham_SanPham.getText();
//        TonKho= txtDonViTinh_SanPham.getText().trim();
//        String  ThongBao = "";
//        GiaNhap = txtGiaNhap_SanPham.getText();
//        GiaBan = txtGiaBan_SanPham.getText();
//        if (MaSanPham.equals("") && ts == 1) {
//            ThongBao += "bạn chưa chọn khách hàng để lấy  Mã Khách Hàng\n";
//            lblMaSanPham_SanPham.setForeground(Color.red);
//        }
//        if (TenSanPham.equals("")) {
//            ThongBao += "bạn chưa Nhập Tên Sản Phẩm\n";
//            lblTenSanPham_SanPham.setForeground(Color.red);
//        }
//        if (GiaNhap.equals("")) {
//            lblGiaNhap_SanPham.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Giá Bán\n";
//        }
//        if (GiaBan.equals("")) {
//            lblGiaBan.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Giá Bán \n";
//        }
//              try {
//                  int bien =Integer.valueOf(GiaNhap);
//              } catch (Exception e) {
//                  ThongBao+="Giá Nhập Phải là số !\n";
//              }
//               try {
//                  int bien =Integer.valueOf(GiaBan);
//              } catch (Exception e) {
//                  ThongBao+="Giá Bán Phải là số !\n";
//              }
//              try {
//                   if (Integer.valueOf(GiaNhap)>Integer.valueOf(GiaBan)) {
//            lblGiaBan.setForeground(Color.red);
//            ThongBao += "Nhập Giá Bán Phải Lớn Hơn Giá Nhập \n";
//        } 
//              } catch (Exception e) {
//              }
//      
//         if (TonKho.equals("")) {
//            lblTonKho_SanPham.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Tồn Kho \n";
//        }
//        if (ThongBao.equals("")) {
//            kiemtra = true;
//            lblTenSanPham_SanPham.setForeground(Color.black);
//            lblMaSanPham_SanPham.setForeground(Color.black);
//            lblGiaBan.setForeground(Color.black);
//             lblTonKho_SanPham.setForeground(Color.black);
//            lblGiaNhap_SanPham.setForeground(Color.black);
//        } else {
//            kiemtra = false;
//            ThongBao(ThongBao, "lỗi nhập liệu", 2);
//        }
//        return kiemtra;
//    }
    public void ThongBao(String noiDungThongBao, String tieuDeThongBao, int icon) {
        JOptionPane.showMessageDialog(new JFrame(), noiDungThongBao,
                tieuDeThongBao, icon);
    }
//    public void ResSanPham() {
//        txtMaSanPham_SanPham.setText("");
//        txtTenSanPham_SanPham.setText("");
//        txtGiaNhap_SanPham.setText("");
//        txtGiaBan_SanPham.setText("");
//        txtDonViTinh_SanPham.setText("");
//        txtChuThich_SanPham.setText("");
//        cbbMaLoaiSanPham_SanPham.setSelectedIndex(0);
//        cbbHangSanXuat_SanPham.setSelectedIndex(0);
//    }
    public String GetCbbSelected(JComboBox cbb) {
        Object[] obj = cbb.getSelectedObjects();
        displayvalueModel item = (displayvalueModel) obj[0];
        return item.displayvalue.toString();

    }
//
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
//    public void setLabelImage(String imagePath) {
//        if (imagePath == null) {
//            imagePath = "d:\\pictures\\laptop\\default.jpg";
//        }
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File(imagePath));
//        } catch (IOException e) {
//
//        }
//        icon = new ImageIcon(img);
//
//        labelHinhAnh.setIcon(icon);
//    }
//
//    public void setLabelImage(String imageLocation, String imageName) {
//        if (imageName == null) {
//            imageName = "default.jpg";
//        }
//        imageLocation = this.imageLocation;
//        BufferedImage img = null;
//        try {
//            img = ImageIO.read(new File(imageLocation + imageName));
//        } catch (IOException e) {
//        }
//        icon = new ImageIcon(img);
//
//        labelHinhAnh.setIcon(icon);
//    }

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
//
//
//
     public boolean KiemTraNhapPhieuNhap(int ts) {
        String MaPhieuNhap, NhanVien, NhaCungCap, NgayLap, TongTien,ThongBao="";
        boolean kiemtra = false;
        MaPhieuNhap = txtMaPhieuNhap_PhieuNhap.getText();
        NhanVien = GetCbbSelected(cbbNhanVien_PhieuNhap);
        
        NhaCungCap =  GetCbbSelected(cbbNhaCungCap_PhieuNhap);
        //NgayLap = txtNgayLapPhieuNhap_PhieuNhap.getText();
        TongTien = txtTongTien_PhieuNhap.getText();
        if (MaPhieuNhap.equals("") && ts == 1) {
            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Phiếu Nhập\n";
            lblMaPhieuNhap_PhieuNhap.setForeground(Color.red);
        }
        if (NhanVien.equals("")) {
            ThongBao += "bạn chưa Chọn Nhân Viên\n";
        }
        if (NhaCungCap.equals("")) {
            ThongBao += "bạn chưa Chọn Nhà Cung Cấp\n";
        }
//        if (NgayLap.equals("")) {
//            lblNgayLap.setForeground(Color.red);
//            ThongBao += "bạn chưa Nhập Ngày Lập\n";
//        }
          if (TongTien.equals("")) {
           txtTongTien_PhieuNhap.setText("0");
        }
        if (ThongBao.equals("")) {
            kiemtra = true;
//            lblDiaChi_KhachHang.setForeground(Color.black);
            lblNgayLap.setForeground(Color.black);
            lblTongTien_PhieuNhap.setForeground(Color.black);
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }
       public boolean KiemTraNhapChiTietPhieuNhap(int ts) {
        String MaPhieuNhap, MaChiTietPhieuNhap, SanPham, SoLuong,ThongBao="";
        boolean kiemtra = false;
        MaPhieuNhap = txtMaPhieuNhap_CTPN.getText();
        MaChiTietPhieuNhap = txtMaCTPN_PhieuNhap.getText();
        SanPham =  GetCbbSelected(cbbSanPhamCTPN_PhieuNhap);
        SoLuong = txtSoLuongCTPN_PhieuNhap.getText();
        if (MaChiTietPhieuNhap.equals("") && ts == 1) {
            ThongBao += "bạn chưa chọn Hóa Đơn để lấy  Mã Hóa Dơn\n";
            lblMaCTPN.setForeground(Color.red);
        }
        if (MaPhieuNhap.equals("")) {
            ThongBao += "bạn chưa chon trong hóa đơn nào cả\n";
            lblMaPhieuNhap.setForeground(Color.red);
        }
        if (SoLuong.equals("")) {
            ThongBao += "bạn chưa Nhập Số Lượng"
                    + "\n";
             lblSoLuong_CTPN.setForeground(Color.red);
        }
            try {
                int bien=Integer.valueOf(SoLuong);
            } catch (Exception e) {
                 ThongBao += "Số lượng phải nhập Bằng số"
                    + "\n";
                
            }
      
        if (ThongBao.equals("")) {
            kiemtra = true;
            lblSoLuong_CTPN.setForeground(Color.black);
            lblMaPhieuNhap.setForeground(Color.black);
            lblMaCTPN.setForeground(Color.black);
        } else {
            kiemtra = false;
            ThongBao(ThongBao, "lỗi nhập liệu", 2);
        }
        return kiemtra;
    }
    public void SetNgayLap(String ngay) {
        //txtNgayLapPhieuNhap_PhieuNhap.setText(ngay);
    }
    public void SetTongTien(String MaPhieuNhap) {
        String cautruyvan = "select sum(ChiTietPhieuNhap.TongTien) as TongTienHienTai,PhieuNhap.MaPhieuNhap from PhieuNhap,ChiTietPhieuNhap "
                + "where PhieuNhap.MaPhieuNhap=ChiTietPhieuNhap.MaPhieuNhap"
                + " and PhieuNhap.MaPhieuNhap=" + MaPhieuNhap + "group by PhieuNhap.MaPhieuNhap";
        ResultSet rs = Main.MainClass.connection.ExcuteQueryGetTable(cautruyvan);
        String ttht = "";

        try {
            if (rs.next()) {
                ttht = rs.getString("TongTienHienTai");
                txtTongTien_PhieuNhap.setText(ttht);
                String ctv = "update PhieuNhap set TongTien= " + ttht + "where MaPhieuNhap=" + MaPhieuNhap;
                System.out.println(ctv);
                MainClass.connection.ExcuteQueryUpdateDB(ctv);
                LayDuLieuPhieuNhap();
            }
        } catch (SQLException ex) {
            System.out.println(ex.toString());
        }

    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> CBTK;
    private javax.swing.JButton btGhi;
    private javax.swing.JButton btKhong;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btXoa;
    private javax.swing.JButton btnMoTabXB_SanPham;
    private javax.swing.JButton btnResetCTPN_PhieuNhap;
    private javax.swing.JButton btnReset_PhieuNhap;
    private javax.swing.JButton btnSaoLuu_LoaiSanPham;
    private javax.swing.JButton btnSuaCTPN_PhieuNhap;
    private javax.swing.JButton btnSua_LoaiSanPham;
    private javax.swing.JButton btnSua_PhieuNhap;
    private javax.swing.JButton btnThemCTPN_PhieuNhap;
    private javax.swing.JButton btnThem_LoaiSanPham;
    private javax.swing.JButton btnThem_PhieuNhap;
    private javax.swing.JButton btnTimKiem;
    private javax.swing.JButton btnXoaSP_LoaiSanPham;
    private javax.swing.JButton btnXoaSanPham_LoaiSanPham;
    private javax.swing.JButton btnXoaXTPN_PhieuNhap;
    private javax.swing.JButton btnXoa_LoaiSanPham;
    private javax.swing.JButton btnXoa_PhieuNhap;
    private javax.swing.JComboBox<String> cbbLoaiSanPham_SanPham;
    private javax.swing.JComboBox<String> cbbNam_PhieuNhap;
    private javax.swing.JComboBox<String> cbbNgay_PhieuNhap;
    private javax.swing.JComboBox<String> cbbNhaCungCap_PhieuNhap;
    private javax.swing.JComboBox<String> cbbNhanVien_PhieuNhap;
    private javax.swing.JComboBox<String> cbbSanPhamCTPN_PhieuNhap;
    private javax.swing.JComboBox<String> cbbThang_PhieuNhap;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanelLoaiSanPham;
    private javax.swing.JPanel jPanelPhieuNhap;
    private javax.swing.JPanel jPanelSanPham;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPaneQuanLySanPham;
    private javax.swing.JLabel labelHinhAnh;
    private javax.swing.JLabel lblGiaBan;
    private javax.swing.JLabel lblGiaNhap_SanPham;
    private javax.swing.JLabel lblMaCTPN;
    private javax.swing.JLabel lblMaPhieuNhap;
    private javax.swing.JLabel lblMaPhieuNhap_PhieuNhap;
    private javax.swing.JLabel lblMaSanPham_SanPham;
    private javax.swing.JLabel lblNgayLap;
    private javax.swing.JLabel lblSoLuong_CTPN;
    private javax.swing.JLabel lblTenSanPham_SanPham;
    private javax.swing.JLabel lblTonKho_SanPham;
    private javax.swing.JLabel lblTongTien_PhieuNhap;
    private javax.swing.JTable tblChiTietPhieuNhap_PhieuNhap;
    private javax.swing.JTable tblLoaiSanPham_LoaiSanPham;
    private javax.swing.JTable tblPhieuNhap_PhieuNhap;
    private javax.swing.JTable tblSanPham;
    private javax.swing.JTable tblSanPham_LoaiSanPham;
    private javax.swing.JTextField txtDonViTinh_SanPham;
    private javax.swing.JTextArea txtGhiChuCTPN_PhieuNhap;
    private javax.swing.JTextArea txtGhiChu_PhieuNhap;
    private javax.swing.JTextField txtGiaBan_SanPham;
    private javax.swing.JTextField txtGiaNhap_SanPham;
    private javax.swing.JTextField txtHangSanXuat_SanPham;
    private javax.swing.JTextField txtMaCTPN_PhieuNhap;
    private javax.swing.JTextField txtMaLoaiSanPham_LoaiSanPham;
    private javax.swing.JTextField txtMaPhieuNhap_CTPN;
    private javax.swing.JTextField txtMaPhieuNhap_PhieuNhap;
    private javax.swing.JTextField txtMaSanPham_SanPham;
    private javax.swing.JTextField txtSoLuongCTPN_PhieuNhap;
    private javax.swing.JTextField txtTenLoaiSanPham_LoaiSanPham;
    private javax.swing.JTextField txtTenSanPham_SanPham;
    private javax.swing.JTextField txtTimKiem;
    private javax.swing.JTextField txtTongTienCTPN_PhieuNhap;
    private javax.swing.JTextField txtTongTien_PhieuNhap;
    // End of variables declaration//GEN-END:variables
}
