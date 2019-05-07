package entity;

public class cachdung {
	private int ID;
	private String MaCachDung;
	private String TenCachDung;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaCachDung() {
		return MaCachDung;
	}
	public void setMaCachDung(String maCachDung) {
		MaCachDung = maCachDung;
	}
	public String getTenCachDung() {
		return TenCachDung;
	}
	public void setTenCachDung(String tenCachDung) {
		TenCachDung = tenCachDung;
	}
	public cachdung(int iD, String maCachDung, String tenCachDung) {
		super();
		ID = iD;
		MaCachDung = maCachDung;
		TenCachDung = tenCachDung;
	}
	public cachdung() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
