package entity;

public class quidinh {
	private int ID;
	private String MaQuiDinh;
	private String TenQuiDinh;
	private float GiaTri;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaQuiDinh() {
		return MaQuiDinh;
	}
	public void setMaQuiDinh(String maQuiDinh) {
		MaQuiDinh = maQuiDinh;
	}
	public String getTenQuiDinh() {
		return TenQuiDinh;
	}
	public void setTenQuiDinh(String tenQuiDinh) {
		TenQuiDinh = tenQuiDinh;
	}
	public float getGiaTri() {
		return GiaTri;
	}
	public void setGiaTri(float giaTri) {
		GiaTri = giaTri;
	}
	public quidinh(int iD, String maQuiDinh, String tenQuiDinh, float giaTri) {
		super();
		ID = iD;
		MaQuiDinh = maQuiDinh;
		TenQuiDinh = tenQuiDinh;
		GiaTri = giaTri;
	}
	public quidinh() {
		super();
		// TODO Auto-generated constructor stub
	}
}
