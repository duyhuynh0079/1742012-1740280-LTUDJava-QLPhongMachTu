package entity;

public class thuoc {
	private int ID;
	private String MaThuoc;
	private String TenThuoc;
	private int DonGia;
	private int TinhTrang;
	private int MaDonVi;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaThuoc() {
		return MaThuoc;
	}
	public void setMaThuoc(String maThuoc) {
		MaThuoc = maThuoc;
	}
	public String getTenThuoc() {
		return TenThuoc;
	}
	public void setTenThuoc(String tenThuoc) {
		TenThuoc = tenThuoc;
	}
	public int getDonGia() {
		return DonGia;
	}
	public void setDonGia(int donGia) {
		DonGia = donGia;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public int getMaDonVi() {
		return MaDonVi;
	}
	public void setMaDonVi(int maDonVi) {
		MaDonVi = maDonVi;
	}
	public thuoc(int iD, String maThuoc, String tenThuoc, int donGia, int tinhTrang, int maDonVi) {
		super();
		ID = iD;
		MaThuoc = maThuoc;
		TenThuoc = tenThuoc;
		DonGia = donGia;
		TinhTrang = tinhTrang;
		MaDonVi = maDonVi;
	}
	public thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
}
