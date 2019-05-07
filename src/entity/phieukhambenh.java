package entity;

import java.util.Date;

public class phieukhambenh {
	private int ID;
	private String MaPhieuKhamBenh;
	private int MaBenhNhan;
	private Date NgayKham;
	private String TrieuChung;
	private float TongTienThuoc;
	private int MaLoaiBenh;
	private int TinhTrang;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getMaPhieuKhamBenh() {
		return MaPhieuKhamBenh;
	}
	public void setMaPhieuKhamBenh(String maPhieuKhamBenh) {
		MaPhieuKhamBenh = maPhieuKhamBenh;
	}
	public int getMaBenhNhan() {
		return MaBenhNhan;
	}
	public void setMaBenhNhan(int maBenhNhan) {
		MaBenhNhan = maBenhNhan;
	}
	public Date getNgayKham() {
		return NgayKham;
	}
	public void setNgayKham(Date ngayKham) {
		NgayKham = ngayKham;
	}
	public String getTrieuChung() {
		return TrieuChung;
	}
	public void setTrieuChung(String trieuChung) {
		TrieuChung = trieuChung;
	}
	public float getTongTienThuoc() {
		return TongTienThuoc;
	}
	public void setTongTienThuoc(float tongTienThuoc) {
		TongTienThuoc = tongTienThuoc;
	}
	public int getMaLoaiBenh() {
		return MaLoaiBenh;
	}
	public void setMaLoaiBenh(int maLoaiBenh) {
		MaLoaiBenh = maLoaiBenh;
	}
	public int getTinhTrang() {
		return TinhTrang;
	}
	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}
	public phieukhambenh(int iD, String maPhieuKhamBenh, int maBenhNhan, Date ngayKham, String trieuChung,
			float tongTienThuoc, int maLoaiBenh, int tinhTrang) {
		super();
		ID = iD;
		MaPhieuKhamBenh = maPhieuKhamBenh;
		MaBenhNhan = maBenhNhan;
		NgayKham = ngayKham;
		TrieuChung = trieuChung;
		TongTienThuoc = tongTienThuoc;
		MaLoaiBenh = maLoaiBenh;
		TinhTrang = tinhTrang;
	}
	public phieukhambenh() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
