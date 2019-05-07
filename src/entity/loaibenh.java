package entity;

public class loaibenh {
	private int ID;
	private String MaLoaiBenh;
	private String TenLoaiBenh;
	private String TrieuChung;
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
	public String getTrieuChung() {
		return TrieuChung;
	}
	public void setTrieuChung(String trieuChung) {
		TrieuChung = trieuChung;
	}
	public loaibenh(int iD, String maLoaiBenh, String tenLoaiBenh, String trieuChung) {
		super();
		ID = iD;
		MaLoaiBenh = maLoaiBenh;
		TenLoaiBenh = tenLoaiBenh;
		TrieuChung = trieuChung;
	}
	public loaibenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
