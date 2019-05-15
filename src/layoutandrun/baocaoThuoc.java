package layoutandrun;

public class baocaoThuoc {
	String STT;
	String THUOC;
	String DONVITINH;
	String SOLUONG;
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
	public String getSOLUONG() {
		return SOLUONG;
	}
	public void setSOLUONG(String sOLUONG) {
		SOLUONG = sOLUONG;
	}
	public String getSOLANDUNG() {
		return SOLANDUNG;
	}
	public void setSOLANDUNG(String sOLANDUNG) {
		SOLANDUNG = sOLANDUNG;
	}
	public baocaoThuoc(String sTT, String tHUOC, String dONVITINH, String sOLUONG, String sOLANDUNG) {
		super();
		STT = sTT;
		THUOC = tHUOC;
		DONVITINH = dONVITINH;
		SOLUONG = sOLUONG;
		SOLANDUNG = sOLANDUNG;
	}
	public baocaoThuoc() {
		super();
		// TODO Auto-generated constructor stub
	}
}
