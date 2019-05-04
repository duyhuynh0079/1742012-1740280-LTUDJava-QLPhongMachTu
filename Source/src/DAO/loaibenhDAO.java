package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.loaibenh;
import entity.thuoc;
import util.HibernateUtil;

public class loaibenhDAO {
	public static ArrayList<loaibenh> layLoaiBenh()
	{
		List lst;
		ArrayList<loaibenh> alLoaiBenh = new ArrayList<loaibenh>();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM loaibenh";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(loaibenh.class);
		lst = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
			loaibenh lb = (loaibenh) iterator.next();
			alLoaiBenh.add(lb);
		}
		return alLoaiBenh;
	}

	public static String[] layDanhSachTenLoaiBenh() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<String> lst = new ArrayList<>();
		
		session.beginTransaction();
		String sql = "SELECT * FROM loaibenh";
		SQLQuery query = session.createSQLQuery(sql);	
		query.addEntity(loaibenh.class);
		
		List employees = query.list();

		// System.out.println("Loi ngay day");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			loaibenh employee = (loaibenh) iterator.next();
			//System.out.println(employee.getMaMonHoc());
			lst.add(employee.getTenLoaiBenh());
		}
		String[] lstDSLB = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSLB;
	}
	
}
