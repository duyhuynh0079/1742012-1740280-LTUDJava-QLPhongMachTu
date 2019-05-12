package entity;

public class quydinh2 {
	private int ID;
	private String MaQuyDinh;
	private int SoLoaiBenh;
	private int SoLoaiThuoc;
	private int SoDonVi;
	private int SoCachDung;
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
	public int getSoLoaiBenh() {
		return SoLoaiBenh;
	}
	public void setSoLoaiBenh(int soLoaiBenh) {
		SoLoaiBenh = soLoaiBenh;
	}
	public int getSoLoaiThuoc() {
		return SoLoaiThuoc;
	}
	public void setSoLoaiThuoc(int soLoaiThuoc) {
		SoLoaiThuoc = soLoaiThuoc;
	}
	public int getSoDonVi() {
		return SoDonVi;
	}
	public void setSoDonVi(int soDonVi) {
		SoDonVi = soDonVi;
	}
	public int getSoCachDung() {
		return SoCachDung;
	}
	public void setSoCachDung(int soCachDung) {
		SoCachDung = soCachDung;
	}
	/**
	 * @param iD
	 * @param maQuyDinh
	 * @param soLoaiBenh
	 * @param soLoaiThuoc
	 * @param soDonVi
	 * @param soCachDung
	 */
	public quydinh2(int iD, String maQuyDinh, int soLoaiBenh, int soLoaiThuoc, int soDonVi, int soCachDung) {
		super();
		ID = iD;
		MaQuyDinh = maQuyDinh;
		SoLoaiBenh = soLoaiBenh;
		SoLoaiThuoc = soLoaiThuoc;
		SoDonVi = soDonVi;
		SoCachDung = soCachDung;
	}
	/**
	 * 
	 */
	public quydinh2() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
