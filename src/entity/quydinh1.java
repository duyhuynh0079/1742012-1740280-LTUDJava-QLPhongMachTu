package entity;

public class quydinh1 {
	private int ID;
	private String MaQuyDinh;
	private String TenQuyDinh;
	private int GiaTri;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaQuyDinh() {
		return MaQuyDinh;
	}
	public void setMaQuyDinh(String maQuyDinh) {
		MaQuyDinh = maQuyDinh;
	}
	public String getTenQuyDinh() {
		return TenQuyDinh;
	}
	public void setTenQuyDinh(String tenQuyDinh) {
		TenQuyDinh = tenQuyDinh;
	}
	public int getGiaTri() {
		return GiaTri;
	}
	public void setGiaTri(int giaTri) {
		GiaTri = giaTri;
	}
	public quydinh1(int iD, String maQuyDinh, String tenQuyDinh, int giaTri) {
		super();
		ID = iD;
		MaQuyDinh = maQuyDinh;
		TenQuyDinh = tenQuyDinh;
		GiaTri = giaTri;
	}
	public quydinh1() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
