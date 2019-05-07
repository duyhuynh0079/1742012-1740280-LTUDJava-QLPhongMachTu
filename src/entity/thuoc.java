package entity;

public class thuoc {
	private int ID;
	private String MaThuoc;
	private String TenThuoc;
	private float DonGia;
	private int TinhTrang;
	private donvi dv;
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
	public float getDonGia() {
		return DonGia;
	}
	public void setDonGia(float donGia) {
		DonGia = donGia;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public donvi getDv() {
		return dv;
	}
	public void setDv(donvi dv) {
		this.dv = dv;
	}
	public thuoc(int iD, String maThuoc, String tenThuoc, float donGia, int tinhTrang, donvi dv) {
		super();
		ID = iD;
		MaThuoc = maThuoc;
		TenThuoc = tenThuoc;
		DonGia = donGia;
		TinhTrang = tinhTrang;
		this.dv = dv;
	}
	public thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
}
