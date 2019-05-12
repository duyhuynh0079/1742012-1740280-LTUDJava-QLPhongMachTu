package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.cachdung;
import entity.quydinh2;
import entity.quydinh4;
import entity.quydinh6;
import util.HibernateUtil;

public class quydinh6DAO {
	public static  quydinh6 timMaQuyDinh(String maqd) {

	    List<quydinh6> qd = new ArrayList<quydinh6>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    qd = session.createQuery("from quydinh6 where MaQuyDinh=?").setParameter(0, maqd).list();
	    session.getTransaction().commit();
	    session.close();
	    if (qd.size() > 0) {
	        return qd.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themQuyDinh(quydinh6 qd) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(qd);
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
	public static boolean suaQuyDinh(quydinh6 qd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(qd); 
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
