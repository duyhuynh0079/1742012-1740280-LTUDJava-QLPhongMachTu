package DAO;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.ctloaibenh;
import util.HibernateUtil;

public class ctloaibenhDAO {
	public static void themCTLoaiBenh(ctloaibenh ctlb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(ctlb);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
	public static void xoaCTLoaiBenh(ctloaibenh ctlb) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.delete(ctlb);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
	public static List<Object[]>layCTLoaiBenhTheoMaPhieuKhamBenh(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT ct.ID_LoaiBenh, ct.ID_PhieuKhamBenh FROM phieukhambenh p inner join ctloaibenh ct on p.ID = ct.ID_PhieuKhamBenh where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
}
