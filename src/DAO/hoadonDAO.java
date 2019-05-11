package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.hoadon;
import entity.phieukhambenh;
import util.HibernateUtil;

public class hoadonDAO {
	public static ArrayList<hoadon> alhd = new ArrayList<hoadon>();
	
	public static ArrayList<hoadon> hoadon()
	{
		List lhd;
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM hoadon";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(hoadon.class);
		lhd = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lhd.iterator(); iterator.hasNext();) {
			hoadon hd = (hoadon) iterator.next();
			alhd.add(hd);
		}
		return alhd;
	}
	
	public static int themHoaDon(hoadon hd) {
        int id = 0;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            id = (int) session.save(hd);
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
