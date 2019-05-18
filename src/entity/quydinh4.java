package entity;

public class quydinh4 {
	private int ID;
	private String MaQuyDinh;
	private String TenQuyDinh;
	private double GiaTri;
	
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

	public double getGiaTri() {
		return GiaTri;
	}

	public void setGiaTri(double giaTri) {
		GiaTri = giaTri;
	}

	public quydinh4(int iD, String maQuyDinh, String tenQuyDinh, double giaTri) {
		super();
		ID = iD;
		MaQuyDinh = maQuyDinh;
		TenQuyDinh = tenQuyDinh;
		GiaTri = giaTri;
	}

	public quydinh4() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
