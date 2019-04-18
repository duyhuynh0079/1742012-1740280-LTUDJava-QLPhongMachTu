package entity;

public class donvi {
	private int ID;
	private String MaDonVi;
	private String TenDonVi;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaDonVi() {
		return MaDonVi;
	}
	public void setMaDonVi(String maDonVi) {
		MaDonVi = maDonVi;
	}
	public String getTenDonVi() {
		return TenDonVi;
	}
	public void setTenDonVi(String tenDonVi) {
		TenDonVi = tenDonVi;
	}
	public donvi(int iD, String maDonVi, String tenDonVi) {
		super();
		ID = iD;
		MaDonVi = maDonVi;
		TenDonVi = tenDonVi;
	}
	public donvi() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
