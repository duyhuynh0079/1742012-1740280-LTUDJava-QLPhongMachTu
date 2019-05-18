package entity;

import java.util.Date;

public class bcdoanhthu {
	String STT;
	String NGAY;
	String SOBENHNHAN;
	String DOANHTHU;
	String TYLE;
	public String getSTT() {
		return STT;
	}
	public void setSTT(String sTT) {
		STT = sTT;
	}
	public String getNGAY() {
		return NGAY;
	}
	public void setNGAY(String nGAY) {
		NGAY = nGAY;
	}
	public String getSOBENHNHAN() {
		return SOBENHNHAN;
	}
	public void setSOBENHNHAN(String sOBENHNHAN) {
		SOBENHNHAN = sOBENHNHAN;
	}
	public String getDOANHTHU() {
		return DOANHTHU;
	}
	public void setDOANHTHU(String dOANHTHU) {
		DOANHTHU = dOANHTHU;
	}
	public String getTYLE() {
		return TYLE;
	}
	public void setTYLE(String tYLE) {
		TYLE = tYLE;
	}
	public bcdoanhthu(String sTT, String nGAY, String sOBENHNHAN, String dOANHTHU, String tYLE) {
		super();
		STT = sTT;
		NGAY = nGAY;
		SOBENHNHAN = sOBENHNHAN;
		DOANHTHU = dOANHTHU;
		TYLE = tYLE;
	}
	public bcdoanhthu() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
