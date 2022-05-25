package frm;

import java.util.Vector;
import frm.KhachHang;
import frm.*;

/**
 *
 * @author PLanh
 */
public class CKhachHang {

	private Vector<KhachHang> DS;
	private ConnectDB conn;

	public CKhachHang(String user, String pass) {
		conn = new ConnectDB();
		conn.connect("QuanLySanPham", UserInfo.username, UserInfo.password);
		String[] key = null;
		DS = new Vector<KhachHang>(100);

		Vector<String> vec = conn.select("KhachHang", key);
		for (String s : vec) {
			DS.add(new KhachHang(s));
		}
	}

	public int searchIndex(String maKH) {
		int i = 0;
		for (KhachHang p : DS) {
			if (p.getMaKH().equals(maKH)) {
				return i;
			}
			i++;
		}
		return -1;
	}

	public boolean add(String record) {
		KhachHang kh = new KhachHang(record);
		String[] values = new String[7];
		values = record.split("\t", 7);

		if (!conn.insert("KhachHang", values)) {
			return false;
		}

		DS.add(kh);
		return true;
	}

	public boolean delete(String key) {
		if (!conn.delete("KhachHang", "MaKhachHang", key)) {
			return false;
		}

		int pos = searchIndex(key);
		DS.remove(pos);
		return true;
	}

	public boolean edit(String record, String key) {
		String[] values = new String[7];
		values = record.split("\t", 7);
		values[0] = "MaKhachHang=" + "'" + values[0] + "'";
		values[1] = "TenKhachHang=" + "'" + values[1] + "'";
		values[2] = "NgaySinh=" + values[2];
		values[3] = "GioiTinh=" + "'" + values[3] + "'";
		values[4] = "DiaChi=" + "'" + values[4] + "'";
		values[5] = "SDT=" + "'" + values[5] + "'";
                values[6] = "LoaiKhachHang=" + "'" + values[6] + "'";
                values[7] = "GhiChu=" + "'" + values[7] + "'";
                
		String pkey = "MaKhachHang=" + "'" + key + "'";
		if (!conn.update("KhachHang", values, pkey)) {
			return false;
		}

		int pos = searchIndex(key);
		DS.remove(pos);
		DS.insertElementAt(new KhachHang(record), pos);
		return true;
	}

	public Vector<String> addFile(String fileName) {
		Vector<String> vec = WriteRead.read(fileName);
Vector<String> vec2 = new Vector<String>(10);

		for (String s : vec) {
			KhachHang p = new KhachHang(s);
			String[] values = p.getValues();
			if (!conn.insert("KhachHang", values)) {
				continue;
			}
			DS.add(p);
			vec2.add(s);
		}

		return vec2;
	}

	public Vector<KhachHang> getDS() {
		return DS;
	}

	public Object[][] getTableData() {
		if (DS == null) {
			return new Object[0][7];
		}
		Object[][] data = new Object[DS.size()][7];

		int i = 0;
		for (KhachHang p : DS) {
			data[i] = p.getValues();
                        System.out.println(data[i][6]);
			i++;
		}

		return data;
	}

	public String[] getIds(){
		String[] ids = new String[DS.size()];
		for(int i=0;i<DS.size();i++){
			ids[i] = DS.get(i).getMaKH();
		}
		return ids;
	}
}

