package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.cachdung;
import entity.quydinh1;
import entity.quydinh2;
import entity.quydinh4;
import util.HibernateUtil;

public class quydinh4DAO {
	
	public static  quydinh4 timMaQuyDinh(String maqd) {

	    List<quydinh4> qd = new ArrayList<quydinh4>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    qd = session.createQuery("from quydinh4 where MaQuyDinh=?").setParameter(0, maqd).list();
	    session.getTransaction().commit();
	    session.close();
	    if (qd.size() > 0) {
	        return qd.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themQuyDinh(quydinh4 qd) {
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
	public static boolean suaQuyDinh(quydinh4 qd) {
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
	public static double laytienkhamTuBanQuyDinh4()
	{
		List lqd;
		double tienkham = 0;
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM quydinh4";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(quydinh4.class);
		lqd = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lqd.iterator(); iterator.hasNext();) {
			quydinh4 qd4 = (quydinh4) iterator.next();
			tienkham = qd4.getGiaTri();
		}
		s.close();
		return tienkham;
	}

}
