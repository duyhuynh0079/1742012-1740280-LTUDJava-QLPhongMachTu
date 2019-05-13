package entity;

public class inhoadon {
	private	String TENTHUOC;
	private	String SOLUONG;
	private	String DONGIA;
	private	String DONVI;
	private	String CACHDUNG;
	public String getTENTHUOC() {
		return TENTHUOC;
	}
	public void setTENTHUOC(String tENTHUOC) {
		TENTHUOC = tENTHUOC;
	}
	public String getSOLUONG() {
		return SOLUONG;
	}
	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}
	public String getDONGIA() {
		return DONGIA;
	}
	public void setDONGIA(String dONGIA) {
		DONGIA = dONGIA;
	}
	public String getDONVI() {
		return DONVI;
	}
	public void setDONVI(String dONVI) {
		DONVI = dONVI;
	}
	public String getCACHDUNG() {
		return CACHDUNG;
	}
	public void setCACHDUNG(String cACHDUNG) {
		CACHDUNG = cACHDUNG;
	}
	public inhoadon(String tENTHUOC, String sOLUONG, String dONGIA, String dONVI, String cACHDUNG) {
		super();
		TENTHUOC = tENTHUOC;
		SOLUONG = sOLUONG;
		DONGIA = dONGIA;
		DONVI = dONVI;
		CACHDUNG = cACHDUNG;
	}
	public inhoadon() {
		super();
		// TODO Auto-generated constructor stub
	}
}
