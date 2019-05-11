package entity;

import java.util.Date;

public class hoadon {
	int ID;
	private String MaHoaDon;
	private Date NgayThanhToan;
	private float TienKham;
	private float TongTien;
	int ID_PhieuKhamBenh;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(String maHoaDon) {
		MaHoaDon = maHoaDon;
	}
	public Date getNgayThanhToan() {
		return NgayThanhToan;
	}
	public void setNgayThanhToan(Date ngayThanhToan) {
		NgayThanhToan = ngayThanhToan;
	}
	public float getTienKham() {
		return TienKham;
	}
	public void setTienKham(float tienKham) {
		TienKham = tienKham;
	}
	public float getTongTien() {
		return TongTien;
	}
	public void setTongTien(float tongTien) {
		TongTien = tongTien;
	}
	public int getID_PhieuKhamBenh() {
		return ID_PhieuKhamBenh;
	}
	public void setID_PhieuKhamBenh(int iD_PhieuKhamBenh) {
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public hoadon(int iD, String maHoaDon, Date ngayThanhToan, float tienKham, float tongTien, int iD_PhieuKhamBenh) {
		super();
		ID = iD;
		MaHoaDon = maHoaDon;
		NgayThanhToan = ngayThanhToan;
		TienKham = tienKham;
		TongTien = tongTien;
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
}
