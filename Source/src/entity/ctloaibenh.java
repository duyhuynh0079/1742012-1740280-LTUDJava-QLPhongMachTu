package entity;

public class ctloaibenh implements java.io.Serializable{
	private int ID_LoaiBenh;
	private int ID_PhieuKhamBenh;
	public int getID_LoaiBenh() {
		return ID_LoaiBenh;
	}
	public void setID_LoaiBenh(int iD_LoaiBenh) {
		ID_LoaiBenh = iD_LoaiBenh;
	}
	public int getID_PhieuKhamBenh() {
		return ID_PhieuKhamBenh;
	}
	public void setID_PhieuKhamBenh(int iD_PhieuKhamBenh) {
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public ctloaibenh(int iD_LoaiBenh, int iD_PhieuKhamBenh) {
		super();
		ID_LoaiBenh = iD_LoaiBenh;
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public ctloaibenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
