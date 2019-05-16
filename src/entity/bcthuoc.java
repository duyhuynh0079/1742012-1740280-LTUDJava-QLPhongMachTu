package entity;

public class bcthuoc {
	String STT;
	String THUOC;
	String DONVITINH;
	String SOLANDUNG;
	public String getSTT() {
		return STT;
	}
	public void setSTT(String sTT) {
		STT = sTT;
	}
	public String getTHUOC() {
		return THUOC;
	}
	public void setTHUOC(String tHUOC) {
		THUOC = tHUOC;
	}
	public String getDONVITINH() {
		return DONVITINH;
	}
	public void setDONVITINH(String dONVITINH) {
		DONVITINH = dONVITINH;
	}
	public String getSOLANDUNG() {
		return SOLANDUNG;
	}
	public void setSOLANDUNG(String sOLANDUNG) {
		SOLANDUNG = sOLANDUNG;
	}
	public bcthuoc(String sTT, String tHUOC, String dONVITINH, String sOLANDUNG) {
		super();
		STT = sTT;
		THUOC = tHUOC;
		DONVITINH = dONVITINH;
		SOLANDUNG = sOLANDUNG;
	}
	public bcthuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
