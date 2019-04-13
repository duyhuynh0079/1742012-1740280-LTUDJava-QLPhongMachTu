package entity;

public class benhnhan  {
	int MaBenhNhan;
	String TenBenhNhan;
	String GioiTinh;
	int NamSinh;
	String DiaChi;
	
	public int getMaBenhNhan() {
		return MaBenhNhan;
	}
	public void setMaBenhNhan(int maBenhNhan) {
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
	public benhnhan(int maBenhNhan, String tenBenhNhan, String gioiTinh, int namSinh, String diaChi) {
		super();
		MaBenhNhan = maBenhNhan;
		TenBenhNhan = tenBenhNhan;
		GioiTinh = gioiTinh;
		NamSinh = namSinh;
		DiaChi = diaChi;
	}
	public benhnhan() {
		super();
	}
}