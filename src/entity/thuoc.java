package entity;

public class thuoc {
	private int ID;
	private String MaThuoc;
	private String TenThuoc;
	private int SoLuong;
	private double DonGia;
	private int TinhTrang;
	private donvi dv;
	private cachdung cd;
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
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public double getDonGia() {
		return DonGia;
	}
	public void setDonGia(double donGia) {
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
	
	public cachdung getCd() {
		return cd;
	}
	public void setCd(cachdung cd) {
		this.cd = cd;
	}
	
	/**
	 * @param iD
	 * @param maThuoc
	 * @param tenThuoc
	 * @param soLuong
	 * @param donGia
	 * @param tinhTrang
	 * @param dv
	 * @param cd
	 */
	public thuoc(int iD, String maThuoc, String tenThuoc, int soLuong, double donGia, int tinhTrang, donvi dv,
			cachdung cd) {
		super();
		ID = iD;
		MaThuoc = maThuoc;
		TenThuoc = tenThuoc;
		SoLuong = soLuong;
		DonGia = donGia;
		TinhTrang = tinhTrang;
		this.dv = dv;
		this.cd = cd;
	}
	public thuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
}
