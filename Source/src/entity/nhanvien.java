package entity;

import java.util.Date;

public class nhanvien {
	private int ID;
	private String TenDangNhap;
	private String MatKhau;
	private String HoTenNV;
	private Date NgaySinh;
	private String DiaChi;
	private String SDT;
	private int TinhTrang;
	private int MaCV;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getTenDangNhap() {
		return TenDangNhap;
	}
	public void setTenDangNhap(String tenDangNhap) {
		TenDangNhap = tenDangNhap;
	}
	public String getMatKhau() {
		return MatKhau;
	}
	public void setMatKhau(String matKhau) {
		MatKhau = matKhau;
	}
	public String getHoTenNV() {
		return HoTenNV;
	}
	public void setHoTenNV(String hoTenNV) {
		HoTenNV = hoTenNV;
	}
	public Date getNgaySinh() {
		return NgaySinh;
	}
	public void setNgaySinh(Date ngaySinh) {
		NgaySinh = ngaySinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public String getSDT() {
		return SDT;
	}
	public void setSDT(String sDT) {
		SDT = sDT;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public int getMaCV() {
		return MaCV;
	}
	public void setMaCV(int maCV) {
		MaCV = maCV;
	}
	public nhanvien(int iD, String tenDangNhap, String matKhau, String hoTenNV, Date ngaySinh, String diaChi,
			String sDT, int tinhTrang, int maCV) {
		super();
		ID = iD;
		TenDangNhap = tenDangNhap;
		MatKhau = matKhau;
		HoTenNV = hoTenNV;
		NgaySinh = ngaySinh;
		DiaChi = diaChi;
		SDT = sDT;
		TinhTrang = tinhTrang;
		MaCV = maCV;
	}
	public nhanvien() {
		super();
		// TODO Auto-generated constructor stub
	}
}
