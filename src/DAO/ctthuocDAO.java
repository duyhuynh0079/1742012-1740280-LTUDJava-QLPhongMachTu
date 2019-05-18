package DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.ctthuoc;
import util.HibernateUtil;

public class ctthuocDAO {
	public static void themCTThuoc(ctthuoc ctt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(ctt);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
	public static void xoaCTThuoc(ctthuoc ctt) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(ctt);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
	public static List<Object[]>layCTThuocTheoMaPhieuKhamBenh(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT ct.* FROM phieukhambenh p inner join ctthuoc ct on p.ID = ct.ID_PhieuKhamBenh where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
}
