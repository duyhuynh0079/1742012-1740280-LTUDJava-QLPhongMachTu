package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.loaibenh;
import entity.thuoc;
import util.HibernateUtil;

public class loaibenhDAO {
	public static ArrayList<loaibenh> layLoaiBenh()
	{
		List lst;
		ArrayList<loaibenh> alLoaiBenh = new ArrayList<loaibenh>();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM loaibenh";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(loaibenh.class);
		lst = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
			loaibenh lb = (loaibenh) iterator.next();
			alLoaiBenh.add(lb);
		}
		return alLoaiBenh;
	}

	public static String[] layDanhSachTenLoaiBenh() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<String> lst = new ArrayList<>();
		
		session.beginTransaction();
		String sql = "SELECT * FROM loaibenh";
		SQLQuery query = session.createSQLQuery(sql);	
		query.addEntity(loaibenh.class);
		
		List employees = query.list();

		// System.out.println("Loi ngay day");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			loaibenh employee = (loaibenh) iterator.next();
			//System.out.println(employee.getMaMonHoc());
			lst.add(employee.getTenLoaiBenh());
		}
		String[] lstDSLB = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSLB;
	}
	public static  loaibenh timMaLoaiBenh(String malb) {

	    List<loaibenh> lb = new ArrayList<loaibenh>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    lb = session.createQuery("from loaibenh where MaLoaiBenh=?").setParameter(0, malb).list();
	    session.getTransaction().commit();
	    session.close();
	    if (lb.size() > 0) {
	        return lb.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themLoaiBenh(loaibenh lb) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(lb);
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
	public static boolean suaLoaiBenh(loaibenh lb) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(lb); 
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
	public static List<Object[]>layLoaiBenhTheoMaPhieuKhamBenh(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT DISTINCT l.TenLoaiBenh,l.TrieuChung FROM phieukhambenh p inner join ctloaibenh ct on p.ID = ct.ID_PhieuKhamBenh inner join loaibenh l on ct.ID_LoaiBenh = l.ID where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
	
	public List<Object[]>layLoaiBenhTheoMPKB(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT DISTINCT l.TenLoaiBenh,l.TrieuChung FROM phieukhambenh p inner join ctloaibenh ct on p.ID = ct.ID_PhieuKhamBenh inner join loaibenh l on ct.ID_LoaiBenh = l.ID where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
	
	public static List<Object[]>layTenBenhTheoMaPhieuKhamBenh(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT l.* FROM phieukhambenh p inner join ctloaibenh ct on p.ID = ct.ID_PhieuKhamBenh inner join loaibenh l on ct.ID_LoaiBenh = l.ID where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
}
