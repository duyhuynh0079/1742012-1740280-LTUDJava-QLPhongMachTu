package entity;

public class benhnhan  {
	int ID;
	String MaBenhNhan;
	String TenBenhNhan;
	String GioiTinh;
	int NamSinh;
	String DiaChi;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaBenhNhan() {
		return MaBenhNhan;
	}
	public void setMaBenhNhan(String maBenhNhan) {
		MaBenhNhan = maBenhNhan;
	}
	public String getTenBenhNhan() {
		return TenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		TenBenhNhan = tenBenhNhan;
	}
	public String getGioiTinh() {
		return GioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		GioiTinh = gioiTinh;
	}
	public int getNamSinh() {
		return NamSinh;
	}
	public void setNamSinh(int namSinh) {
		NamSinh = namSinh;
	}
	public String getDiaChi() {
		return DiaChi;
	}
	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}
	public benhnhan(int iD, String maBenhNhan, String tenBenhNhan, String gioiTinh, int namSinh, String diaChi) {
		super();
		ID = iD;
		MaBenhNhan = maBenhNhan;
		TenBenhNhan = tenBenhNhan;
		GioiTinh = gioiTinh;
		NamSinh = namSinh;
		DiaChi = diaChi;
	}
	public benhnhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}