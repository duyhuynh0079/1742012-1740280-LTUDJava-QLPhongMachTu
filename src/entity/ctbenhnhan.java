package entity;

public class ctbenhnhan implements java.io.Serializable{
	private int ID_BenhNhan;
	private int ID_PhieuKhamBenh;
	public int getID_BenhNhan() {
		return ID_BenhNhan;
	}
	public void setID_BenhNhan(int iD_BenhNhan) {
		ID_BenhNhan = iD_BenhNhan;
	}
	public int getID_PhieuKhamBenh() {
		return ID_PhieuKhamBenh;
	}
	public void setID_PhieuKhamBenh(int iD_PhieuKhamBenh) {
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public ctbenhnhan(int iD_BenhNhan, int iD_PhieuKhamBenh) {
		super();
		ID_BenhNhan = iD_BenhNhan;
		ID_PhieuKhamBenh = iD_PhieuKhamBenh;
	}
	public ctbenhnhan() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
