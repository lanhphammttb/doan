/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package frm;

/**
 *
 * @author PLanh
 */
public class KhachHang {
    private String MaKH;
    private String TenKH;
    private String NgaySinh;
    private String GioiTinh;
    private String DiaChiKH;
    private String SDTKH;
    private String LoaiKH;
    private String GhiChu;

    public KhachHang(String record){
        String [] values = new String[7];
        System.out.println(record);
        values = record.split("\t",7);
        MaKH = values[0];
        TenKH = values[1];
        NgaySinh = values[2];
        GioiTinh = values[3];
        DiaChiKH = values[4];
        SDTKH = values[5];
        LoaiKH = values[6];
        GhiChu = values[7];
    }
    
    public String getMaKH() {
        return MaKH;
    }

    public void setMaKH(String maKH) {
        this.MaKH = maKH;
    }

    public String getTenKH() {
        return TenKH;
    }

    public void setTenKH(String tenKH) {
        this.TenKH = TenKH;
    }

    public String getNgaySinh() {
        return NgaySinh;
    }

    public void setNgaySinh(String NgaySinh) {
        this.NgaySinh = NgaySinh;
    }

    public String getGioiTinh() {
        return GioiTinh;
    }

    public void setGioiTinh(String GioiTinh) {
        this.GioiTinh = GioiTinh;
    }

    public String getDiaChiKH() {
        return DiaChiKH;
    }

    public void setDiaChiKH(String DiaChiKH) {
        this.DiaChiKH = DiaChiKH;
    }

    public String getSDTKH() {
        return SDTKH;
    }

    public void setSDTKH(String SDTKH) {
        this.SDTKH = SDTKH;
    }

    public String getLoaiKH() {
        return LoaiKH;
    }

    public void setLoaiKH(String LoaiKH) {
        this.LoaiKH = LoaiKH;
    }
    
    public String getGhiChu() {
        return GhiChu;
    }

    public void setGhiChu(String GhiChu) {
        this.GhiChu = GhiChu;
    }
    public String[] getValues(){
        String [] values = new String[7];
        
        values[0] = MaKH;
        values[1] = TenKH;
        values[2] = NgaySinh;
        values[3] = GioiTinh;
        values[4] = DiaChiKH;
        values[5] = SDTKH;
        values[6] = LoaiKH;
        values[7] = GhiChu;
        
        return values;
    }
}
