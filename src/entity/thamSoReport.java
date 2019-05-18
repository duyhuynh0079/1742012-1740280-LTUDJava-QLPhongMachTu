package entity;

public class thamSoReport {
	private String MaPhieuKham;
	private String NgayKham;
	private String MaBenhNhan;
	private String TenBenhNhan;
	private String TienThuoc;
	private String TienKham;
	private String TongTien;
	private String STT1;
	private String STT2;
	private String STT3;
	private String TenLoaiBenh1;
	private String TenLoaiBenh2;
	private String TenLoaiBenh3;
	private String TrieuChung1;
	private String TrieuChung2;
	private String TrieuChung3;
	public String getMaPhieuKham() {
		return MaPhieuKham;
	}
	public void setMaPhieuKham(String maPhieuKham) {
		MaPhieuKham = maPhieuKham;
	}
	public String getNgayKham() {
		return NgayKham;
	}
	public void setNgayKham(String ngayKham) {
		NgayKham = ngayKham;
	}
	public String getMaBenhNhan() {
		return MaBenhNhan;
	}
	public void setMaBenhNhan(String maBenhNhan) {
		MaBenhNhan = maBenhNhan;
	}
	public String getTenBenhNhan() {
		return TenBenhNhan;
	}
	public void setTenBenhNhan(String tenBenhNhan) {
		TenBenhNhan = tenBenhNhan;
	}
	public String getTienThuoc() {
		return TienThuoc;
	}
	public void setTienThuoc(String tienThuoc) {
		TienThuoc = tienThuoc;
	}
	public String getTienKham() {
		return TienKham;
	}
	public void setTienKham(String tienKham) {
		TienKham = tienKham;
	}
	public String getTongTien() {
		return TongTien;
	}
	public void setTongTien(String tongTien) {
		TongTien = tongTien;
	}
	public String getSTT1() {
		return STT1;
	}
	public void setSTT1(String sTT1) {
		STT1 = sTT1;
	}
	public String getSTT2() {
		return STT2;
	}
	public void setSTT2(String sTT2) {
		STT2 = sTT2;
	}
	public String getSTT3() {
		return STT3;
	}
	public void setSTT3(String sTT3) {
		STT3 = sTT3;
	}
	public String getTenLoaiBenh1() {
		return TenLoaiBenh1;
	}
	public void setTenLoaiBenh1(String tenLoaiBenh1) {
		TenLoaiBenh1 = tenLoaiBenh1;
	}
	public String getTenLoaiBenh2() {
		return TenLoaiBenh2;
	}
	public void setTenLoaiBenh2(String tenLoaiBenh2) {
		TenLoaiBenh2 = tenLoaiBenh2;
	}
	public String getTenLoaiBenh3() {
		return TenLoaiBenh3;
	}
	public void setTenLoaiBenh3(String tenLoaiBenh3) {
		TenLoaiBenh3 = tenLoaiBenh3;
	}
	public String getTrieuChung1() {
		return TrieuChung1;
	}
	public void setTrieuChung1(String trieuChung1) {
		TrieuChung1 = trieuChung1;
	}
	public String getTrieuChung2() {
		return TrieuChung2;
	}
	public void setTrieuChung2(String trieuChung2) {
		TrieuChung2 = trieuChung2;
	}
	public String getTrieuChung3() {
		return TrieuChung3;
	}
	public void setTrieuChung3(String trieuChung3) {
		TrieuChung3 = trieuChung3;
	}
	public thamSoReport(String maPhieuKham, String ngayKham, String maBenhNhan, String tenBenhNhan, String tienThuoc,
			String tienKham, String tongTien, String sTT1, String sTT2, String sTT3, String tenLoaiBenh1,
			String tenLoaiBenh2, String tenLoaiBenh3, String trieuChung1, String trieuChung2, String trieuChung3) {
		super();
		MaPhieuKham = maPhieuKham;
		NgayKham = ngayKham;
		MaBenhNhan = maBenhNhan;
		TenBenhNhan = tenBenhNhan;
		TienThuoc = tienThuoc;
		TienKham = tienKham;
		TongTien = tongTien;
		STT1 = sTT1;
		STT2 = sTT2;
		STT3 = sTT3;
		TenLoaiBenh1 = tenLoaiBenh1;
		TenLoaiBenh2 = tenLoaiBenh2;
		TenLoaiBenh3 = tenLoaiBenh3;
		TrieuChung1 = trieuChung1;
		TrieuChung2 = trieuChung2;
		TrieuChung3 = trieuChung3;
	}
	public thamSoReport() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
