package entity;

import java.util.Date;

public class phieukhambenh {
	private int ID;
	private String MaPhieuKhamBenh;
	private Date NgayKham;
	private double TongTienThuoc;
	private int TinhTrang;
  
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaPhieuKhamBenh() {
		return MaPhieuKhamBenh;
	}
	public void setMaPhieuKhamBenh(String maPhieuKhamBenh) {
		MaPhieuKhamBenh = maPhieuKhamBenh;
	}
	public Date getNgayKham() {
		return NgayKham;
	}
	public void setNgayKham(Date ngayKham) {
		NgayKham = ngayKham;
	}
	public double getTongTienThuoc() {
		return TongTienThuoc;
	}
	public void setTongTienThuoc(double tongTienThuoc) {
		TongTienThuoc = tongTienThuoc;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public phieukhambenh(int iD, String maPhieuKhamBenh, Date ngayKham, double tongTienThuoc, int tinhTrang) {
		super();
		ID = iD;
		MaPhieuKhamBenh = maPhieuKhamBenh;
		NgayKham = ngayKham;
		TongTienThuoc = tongTienThuoc;
		TinhTrang = tinhTrang;
	}
	public phieukhambenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
