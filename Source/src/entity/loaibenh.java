package entity;

public class loaibenh {
	private int ID;
	private String MaLoaiBenh;
	private String TenLoaiBenh;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaLoaiBenh() {
		return MaLoaiBenh;
	}
	public void setMaLoaiBenh(String maLoaiBenh) {
		MaLoaiBenh = maLoaiBenh;
	}
	public String getTenLoaiBenh() {
		return TenLoaiBenh;
	}
	public void setTenLoaiBenh(String tenLoaiBenh) {
		TenLoaiBenh = tenLoaiBenh;
	}
	public loaibenh(int iD, String maLoaiBenh, String tenLoaiBenh) {
		super();
		ID = iD;
		MaLoaiBenh = maLoaiBenh;
		TenLoaiBenh = tenLoaiBenh;
	}
	public loaibenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
