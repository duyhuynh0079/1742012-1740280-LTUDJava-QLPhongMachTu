package entity;

public class thuoc1 {
	private int ID;
	private String MaThuoc;
	private String TenThuoc;
	private float DonGia;
	private int TinhTrang;
	private int ID_DonVi;
	private int ID_CachDung;
	private int SoLuong;
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
	public int getID_DonVi() {
		return ID_DonVi;
	}
	public void setID_DonVi(int iD_DonVi) {
		ID_DonVi = iD_DonVi;
	}
	public int getID_CachDung() {
		return ID_CachDung;
	}
	public void setID_CachDung(int iD_CachDung) {
		ID_CachDung = iD_CachDung;
	}
	
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	
	public thuoc1(int iD, String maThuoc, String tenThuoc, float donGia, int tinhTrang, int iD_DonVi, int iD_CachDung,
			int soLuong) {
		super();
		ID = iD;
		MaThuoc = maThuoc;
		TenThuoc = tenThuoc;
		DonGia = donGia;
		TinhTrang = tinhTrang;
		ID_DonVi = iD_DonVi;
		ID_CachDung = iD_CachDung;
		SoLuong = soLuong;
	}
	public thuoc1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
