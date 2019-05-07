package DAO;

import org.hibernate.Session;

import entity.benhnhan;
import util.HibernateUtil;

public class benhnhanDAO {
	public static benhnhan layThongTinBenhNhan(int ID) {//???
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		benhnhan sv = (benhnhan) session.get(benhnhan.class, ID);

		session.close();
		return sv;
	}

	public static boolean themBenhNhan(benhnhan bn) {
		//		if (sinhvienDAO.layThongTinSinhVien(sv.getID()) != null)
		//			return false;
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(bn);
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

	public static boolean suaBenhNhan(benhnhan bn) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(bn); 
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
