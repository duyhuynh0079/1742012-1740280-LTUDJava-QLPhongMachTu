package DAO;

import org.hibernate.Session;

import entity.ctbenhnhan;
import util.HibernateUtil;

public class ctbenhnhanDAO {
	public static void themCTBenhNhan(ctbenhnhan ctbn) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.save(ctbn);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
}
