package DAO;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import entity.cachdung;
import entity.quydinh1;
import entity.quydinh2;
import util.HibernateUtil;

public class quydinh1DAO {
	public static  quydinh1 timMaQuyDinh(String maqd) {

	    List<quydinh1> qd = new ArrayList<quydinh1>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    qd = session.createQuery("from quydinh1 where MaQuyDinh=?").setParameter(0, maqd).list();
	    session.getTransaction().commit();
	    session.close();
	    if (qd.size() > 0) {
	        return qd.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themQuyDinh(quydinh1 qd) {
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
	public static boolean suaQuyDinh(quydinh1 qd) {
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
