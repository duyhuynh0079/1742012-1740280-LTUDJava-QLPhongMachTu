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

import org.hibernate.SQLQuery;
import org.hibernate.Session;

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
	public static  nhanvien timTenDangNhapTrung(String tendn) {

	    List<nhanvien> nv = new ArrayList<nhanvien>();

	    //Session session = this.sessionFactory.getCurrentSession();
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
//		try {
//			MessageDigest md = MessageDigest.getInstance("SHA-1");
//			md.update(hashedPassword.getBytes("UTF-8"));
//			char[] raw = md.digest().toString().toCharArray();
//			return Base64.getEncoder().encodeToString(raw);
//		} catch (Exception e) {
//			throw
//    	new RuntimeException(e);
//		}
    	MessageDigest digest = MessageDigest.getInstance("SHA-1");
		digest.reset();
		byte[] hash = digest.digest(pw.getBytes("UTF-8"));
		return Base64.getDecoder().decode(hash).toString();
	} 
//    public static String unHash2(String pw)  {  
//	try {
//			MessageDigest md = MessageDigest.getInstance("SHA-1");
//			md.update(hashedPassword.getBytes("UTF-8"));
//			char[] raw = md.digest().toString().toCharArray();
//			return Base64.getEncoder().encodeToString(raw);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//			}
//    }
}
