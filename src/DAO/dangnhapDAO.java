package DAO;

import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.nhanvien;
import util.HibernateUtil;

public class dangnhapDAO {
	public static nhanvien LayThongTinNhanVien(String manv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		nhanvien nv = (nhanvien) session.get(nhanvien.class, manv);
		session.close();
		return nv;
	}
	public static nhanvien KiemTraTrung(nhanvien tknv){
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		nhanvien tknv1 = null;
		session.beginTransaction();
		String sql = "SELECT * FROM nhanvien where TenDangNhap =:h and MatKhau =:v and TinhTrang=1";
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

}
