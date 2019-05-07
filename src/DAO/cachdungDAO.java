package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.cachdung;
import entity.donvi;
import entity.phieukhambenh;
import util.HibernateUtil;

public class cachdungDAO {
  public static ArrayList<cachdung> alcd = new ArrayList<cachdung>();
	public static String[] LayDanhSachCachDung() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<String> lst = new ArrayList<>();
		session.beginTransaction();
		String sql = "SELECT TenCachDung FROM cachdung";
		SQLQuery query = session.createSQLQuery(sql);
		List employees = query.list();

		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			String employee = (String) iterator.next();
			lst.add(employee);
		}
		String[] lstDSCD = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSCD;
	}

	public static ArrayList layCachDung() {
		List lcd;
		// tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		// mo ket noi bang session
		Session s = sf.openSession();
		// tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM cachdung";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(cachdung.class);
		lcd = query.list();

		for (Iterator iterator = lcd.iterator(); iterator.hasNext();) {
			cachdung cd = (cachdung) iterator.next();
			alcd.add(cd);
		}
		return alcd;
	}

	public static cachdung timMaCachDung(String macd) {

		List<cachdung> cd = new ArrayList<cachdung>();

		// Session session = this.sessionFactory.getCurrentSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		cd = session.createQuery("from cachdung where MaCachDung=?").setParameter(0, macd).list();
		session.getTransaction().commit();
		session.close();
		if (cd.size() > 0) {
			return cd.get(0);
		} else {
			return null;
		}
	}

	public static boolean themCachDung(cachdung cd) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(cd);
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

	public static boolean suaCachDung(cachdung cd) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(cd); 
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
