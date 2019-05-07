package entity;

import java.util.Date;

public class hoadon {
	private int MaHoaDon;
	private Date NgayThanhToan;
	private float TienKham;
	private float TongTien;
	private int MaPhieuKhamBenh;
	public int getMaHoaDon() {
		return MaHoaDon;
	}
	public void setMaHoaDon(int maHoaDon) {
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
	public int getMaPhieuKhamBenh() {
		return MaPhieuKhamBenh;
	}
	public void setMaPhieuKhamBenh(int maPhieuKhamBenh) {
		MaPhieuKhamBenh = maPhieuKhamBenh;
	}
	public hoadon(int maHoaDon, Date ngayThanhToan, float tienKham, float tongTien, int maPhieuKhamBenh) {
		super();
		MaHoaDon = maHoaDon;
		NgayThanhToan = ngayThanhToan;
		TienKham = tienKham;
		TongTien = tongTien;
		MaPhieuKhamBenh = maPhieuKhamBenh;
	}
	public hoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
