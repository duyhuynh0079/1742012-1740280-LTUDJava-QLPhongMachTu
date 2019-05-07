package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.quidinh;
import entity.thuoc;
import util.HibernateUtil;

public class thuocDAO {
	public static  thuoc timMaThuoc(String mat) {

	    List<thuoc> t = new ArrayList<thuoc>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    t = session.createQuery("from thuoc where MaThuoc=?").setParameter(0, mat).list();
	    session.getTransaction().commit();
	    session.close();
	    if (t.size() > 0) {
	        return t.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themThuoc(thuoc t) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(t);
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
	public static boolean suaThuoc(thuoc t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(t); 
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
