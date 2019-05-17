package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.cachdung;
import entity.phieukhambenh;
import entity.quydinh1;
import entity.quydinh2;
import util.HibernateUtil;

public class quydinh1DAO {
	public static ArrayList<quydinh1> alqd1 = new ArrayList<quydinh1>();
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
	
	public static ArrayList<quydinh1> quydinh1()
	{
		List lqd;
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM quydinh1";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(quydinh1.class);
		lqd = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lqd.iterator(); iterator.hasNext();) {
			quydinh1 qd1 = (quydinh1) iterator.next();
			alqd1.add(qd1);
		}
		return alqd1;
	}
}
