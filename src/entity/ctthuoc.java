package entity;

public class ctthuoc implements java.io.Serializable{
	private int ID_Thuoc;
	private int ID_PhieuKhamBenh;
	private int SoLuong;
	public int getID_Thuoc() {
		return ID_Thuoc;
	}
	public void setID_Thuoc(int iD_Thuoc) {
		ID_Thuoc = iD_Thuoc;
	}
	public int getID_PhieuKhamBenh() {
		return ID_PhieuKhamBenh;
	}
	public void setID_PhieuKhamBenh(int iD_PhieuKhamBenh) {
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public int getSoLuong() {
		return SoLuong;
	}
	public void setSoLuong(int soLuong) {
		SoLuong = soLuong;
	}
	public ctthuoc(int iD_Thuoc, int iD_PhieuKhamBenh, int soLuong) {
		super();
		ID_Thuoc = iD_Thuoc;
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
		SoLuong = soLuong;
	}
	public ctthuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
}
