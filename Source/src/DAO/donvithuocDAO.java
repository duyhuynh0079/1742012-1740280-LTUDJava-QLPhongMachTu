package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

import entity.benhnhan;
import entity.donvi;
import util.HibernateUtil;

public class donvithuocDAO {
	public static String[] LayDanhSachDonVi() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<String> lst = new ArrayList<>();
		
		session.beginTransaction();
		String sql = "SELECT TenDonVi FROM donvi";
		SQLQuery query = session.createSQLQuery(sql);
		List employees = query.list();
		//System.out.println("size employees" + employees.iterator());

		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			String employee = (String) iterator.next();
			lst.add(employee);

		}
		String[] lstDSSV = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSSV;
	}
	public static donvi LayThongTinDV(String madv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		donvi dv = (donvi) session.get(donvi.class, madv);
		session.close();
		return dv;
	}
	public static  donvi timMaDonVi(String madv) {

	    List<donvi> dv = new ArrayList<donvi>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    dv = session.createQuery("from donvi where MaDonVi=?").setParameter(0, madv).list();
	    session.getTransaction().commit();
	    session.close();
	    if (dv.size() > 0) {
	        return dv.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themDonViThuoc(donvi dv) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(dv);
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

	public static boolean suaDonViThuoc(donvi dv) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(dv); 
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
