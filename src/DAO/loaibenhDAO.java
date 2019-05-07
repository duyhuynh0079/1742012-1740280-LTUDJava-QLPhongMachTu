package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.cachdung;
import entity.loaibenh;
import util.HibernateUtil;

public class loaibenhDAO {
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
	

}
