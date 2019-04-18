package entity;

public class ctphieukhambenh {
	private int ID_MaPhieuKhamBenh;
	private int ID_MaThuoc;
	private int ID_MaCachDung;
	private float DonGia;
	private int SoLuong;
	private float ThanhTien;
	public int getID_MaPhieuKhamBenh() {
		return ID_MaPhieuKhamBenh;
	}
	public void setID_MaPhieuKhamBenh(int iD_MaPhieuKhamBenh) {
		ID_MaPhieuKhamBenh = iD_MaPhieuKhamBenh;
	}
	public int getID_MaThuoc() {
		return ID_MaThuoc;
	}
	public void setID_MaThuoc(int iD_MaThuoc) {
		ID_MaThuoc = iD_MaThuoc;
	}
	public int getID_MaCachDung() {
		return ID_MaCachDung;
	}
	public void setID_MaCachDung(int iD_MaCachDung) {
		ID_MaCachDung = iD_MaCachDung;
	}
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public float getThanhTien() {
		return ThanhTien;
	}
	public void setThanhTien(float thanhTien) {
		ThanhTien = thanhTien;
	}
	public ctphieukhambenh(int iD_MaPhieuKhamBenh, int iD_MaThuoc, int iD_MaCachDung, float donGia, int soLuong,
			float thanhTien) {
		super();
		ID_MaPhieuKhamBenh = iD_MaPhieuKhamBenh;
		ID_MaThuoc = iD_MaThuoc;
		ID_MaCachDung = iD_MaCachDung;
		DonGia = donGia;
		SoLuong = soLuong;
		ThanhTien = thanhTien;
	}
	public ctphieukhambenh() {
		super();
		// TODO Auto-generated constructor stub
	}
}
