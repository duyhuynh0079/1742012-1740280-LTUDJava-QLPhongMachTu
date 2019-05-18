package DAO;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Date;
import java.util.Formatter;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.type.IntegerType;

import com.sun.org.apache.xalan.internal.xsltc.compiler.util.StringType;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import entity.loaibenh;
import entity.nhanvien;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
import util.HibernateUtil;

public class nhanvienDAO {
	private static final String Hex = null;
	public static  nhanvien timMaNhanVien(String manv) {

	    List<nhanvien> nv = new ArrayList<nhanvien>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    nv = session.createQuery("from nhanvien where MaNhanVien=?").setParameter(0, manv).list();
	    session.getTransaction().commit();
	    session.close();
	    if (nv.size() > 0) {
	        return nv.get(0);
	    } else {
	        return null;
	    }
	}
	public static nhanvien KiemTraTrung(nhanvien tknv){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		nhanvien tknv1 = null;
		session.beginTransaction();
		String sql = "SELECT * FROM nhanvien where TenDangNhap =:h and MatKhau =:v";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("h",tknv.getTenDangNhap());
		query.setParameter("v",tknv.getMatKhau());
		query.addEntity(nhanvien.class);
		List employees = query.list();
		
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			tknv1 = (nhanvien) iterator.next();
		}
		session.close();
		
		return tknv1;
	}
	public static String layHoTenNV(int ID)
	{
		String hoten = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT HoTenNV as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			String cnt = ((String) list.get(0)).toString();
			hoten = cnt;
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return hoten;
	}
	public static String layNgaySinhNV(int ID)
	{
		String ngaysinh = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT NgaySinh as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			Date cnt = ((Date) list.get(0));
			ngaysinh = cnt.toString();
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return ngaysinh;
	}
	public static String layDiaChiNV(int ID)
	{
		String diachi = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT DiaChi as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			String cnt = ((String) list.get(0)).toString();
			diachi = cnt;
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return diachi;
	}
	public static String laySDTNV(int ID)
	{
		String dienthoai = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT SDT as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			String cnt = ((String) list.get(0)).toString();
			dienthoai = cnt;
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return dienthoai;
	}
	public static String layTenDangNhapNV(int ID)
	{
		String tendangnhap = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT TenDangNhap as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			String cnt = ((String) list.get(0)).toString();
			tendangnhap = cnt;
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return tendangnhap;
	}
	public static String layMatKhauNV(int ID)
	{
		String MatKhau = "";
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT MatKhau as cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",ID);
//		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			String cnt = ((String) list.get(0)).toString();
			MatKhau = cnt;
		} else {
			System.out.println("Table rỗng!");
		}
		session.close();
		return MatKhau;
	}
	public static int layMaChucVu(int manv)
	{
		int macv = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT MaCV cnt FROM nhanvien WHERE TinhTrang = 1 and ID =:h";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.setParameter("h",manv);
		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			int cnt = ((Integer) list.get(0)).intValue();
			macv = cnt;
		} else {
//			logger.info("No Records found for the specified input...");
			System.out.println("Table rỗng!");
		}
		session.close();
		return macv;
	}
	public static  nhanvien timTenDangNhapTrung(String tendn) {

	    List<nhanvien> nv = new ArrayList<nhanvien>();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    nv = session.createQuery("from nhanvien where TenDangNhap=?").setParameter(0, tendn).list();
	    session.getTransaction().commit();
	    session.close();
	    if (nv.size() > 0) {
	        return nv.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themNhanVien(nhanvien nv) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(nv);
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e);
			return false;
		} finally {
			session.close();
		}
	}
	public static boolean suaNhanVien(nhanvien nv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(nv); 
			session.getTransaction().commit();
			return true;
		}catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println(e);
			return false; 
		}finally {
			session.close(); 
		}
	}
	public static String layTenChucVu(int macv) {
		String chuoi = "";
		if(macv == 1) {
			chuoi = "Bác sĩ";
		}
		else if(macv == 2){
			chuoi = "Y tá";
		}
		return chuoi;
	}
	public static String GetPasswordHashText(String pw) throws NoSuchAlgorithmException, UnsupportedEncodingException {
		MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		byte[] hash = digest.digest(pw.getBytes("UTF-8"));
		return Base64.getEncoder().encodeToString(hash);
	}
    public static String unHash(String pw)  throws NoSuchAlgorithmException, UnsupportedEncodingException {  
    	MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		byte[] hash = digest.digest(pw.getBytes("UTF-8"));
		return Base64.getDecoder().decode(hash).toString();
	} 
}
