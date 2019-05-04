package DAO;

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
}
