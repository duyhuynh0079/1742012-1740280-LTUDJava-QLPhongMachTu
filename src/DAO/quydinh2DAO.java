package DAO;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
//import org.hibernate.annotations.common.util.impl.Log_.logger;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.type.IntegerType;

import entity.cachdung;
import entity.phieukhambenh;
import entity.quydinh2;
import util.HibernateUtil;

public class quydinh2DAO {
	public static  quydinh2 timMaQuyDinh(String maqd) {

	    List<quydinh2> qd = new ArrayList<quydinh2>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    qd = session.createQuery("from quydinh2 where MaQuyDinh=?").setParameter(0, maqd).list();
	    session.getTransaction().commit();
	    session.close();
	    if (qd.size() > 0) {
	        return qd.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themQuyDinh(quydinh2 qd) {
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
	public static boolean suaQuyDinh(quydinh2 qd) {
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
	public static int laySoLoaiBenh(int ID)
	{
		List lpk;
		int soloaibenh = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM quydinh2  where ID =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", ID);
		query.addEntity(quydinh2.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			quydinh2 qd2 = (quydinh2) iterator.next();
			soloaibenh = qd2.getSoLoaiBenh();
		}
        session.close();
        return soloaibenh;
	}
	public static int laySoLoaiThuoc(int ID)
	{
		List lpk;
		int soloaithuoc = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM quydinh2  where ID =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", ID);
		query.addEntity(quydinh2.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			quydinh2 qd2 = (quydinh2) iterator.next();
			soloaithuoc = qd2.getSoLoaiThuoc();
		}
        session.close();
        return soloaithuoc;
	}
	public static int laySoDonVi(int ID)
	{
		List lpk;
		int sodonvi = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM quydinh2  where ID =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", ID);
		query.addEntity(quydinh2.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			quydinh2 qd2 = (quydinh2) iterator.next();
			sodonvi = qd2.getSoDonVi();
		}
        session.close();
        return sodonvi;
	}
	public static int laySoCachDung(int ID)
	{
		List lpk;
		int socachdung = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM quydinh2  where ID =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", ID);
		query.addEntity(quydinh2.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			quydinh2 qd2 = (quydinh2) iterator.next();
			socachdung = qd2.getSoCachDung();
		}
        session.close();
        return socachdung;
	}
	public static int laySoDong()
	{
		int sodong = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String SQL_QUERY = "SELECT COUNT(*) as cnt FROM loaibenh";
		SQLQuery query = session.createSQLQuery(SQL_QUERY);
		query.addScalar("cnt", IntegerType.INSTANCE);
		List list = query.list();
		if (list != null && !list.isEmpty()) {
			int cnt = ((Integer) list.get(0)).intValue();
			sodong = cnt;
		} else {
//			logger.info("No Records found for the specified input...");
		}
		session.close();
		return sodong;
	}

}
