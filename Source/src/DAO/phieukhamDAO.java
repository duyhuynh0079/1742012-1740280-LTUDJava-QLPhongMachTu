package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.phieukhambenh;
import util.HibernateUtil;

public class phieukhamDAO {
	public static ArrayList<phieukhambenh> alpk = new ArrayList<phieukhambenh>();
	public static ArrayList phieukham()
	{
		List lpk;
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM phieukhambenh";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(phieukhambenh.class);
		lpk = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			phieukhambenh pkb = (phieukhambenh) iterator.next();
			alpk.add(pkb);
		}
		return alpk;
	}
	
	public static int themPhieuKham(phieukhambenh pk) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            id = (int) session.save(pk);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
            return id;
        }
    }

}
