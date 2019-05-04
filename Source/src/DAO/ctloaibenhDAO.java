package DAO;

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
}
