package entity;

public class bcloaibenh {
	String STT;
	String TENLOAIBENH;
	String TRIEUCHUNG;
	String SOCABENH;
	public String getSTT() {
		return STT;
	}
	public void setSTT(String sTT) {
		STT = sTT;
	}
	public String getTENLOAIBENH() {
		return TENLOAIBENH;
	}
	public void setTENLOAIBENH(String tENLOAIBENH) {
		TENLOAIBENH = tENLOAIBENH;
	}
	public String getTRIEUCHUNG() {
		return TRIEUCHUNG;
	}
	public void setTRIEUCHUNG(String tRIEUCHUNG) {
		TRIEUCHUNG = tRIEUCHUNG;
	}
	public String getSOCABENH() {
		return SOCABENH;
	}
	public void setSOCABENH(String sOCABENH) {
		SOCABENH = sOCABENH;
	}
	public bcloaibenh(String sTT, String tENLOAIBENH, String tRIEUCHUNG, String sOCABENH) {
		super();
		STT = sTT;
		TENLOAIBENH = tENLOAIBENH;
		TRIEUCHUNG = tRIEUCHUNG;
		SOCABENH = sOCABENH;
	}
	public bcloaibenh() {
		super();
		// TODO Auto-generated constructor stub
	}
}
