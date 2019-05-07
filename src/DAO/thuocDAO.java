package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.benhnhan;
import entity.thuoc;
import util.HibernateUtil;

public class thuocDAO {
	public static ArrayList<thuoc> layThuoc()
	{
		List lst;
		ArrayList<thuoc> alThuoc = new ArrayList<thuoc>();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM thuoc";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(thuoc.class);
		lst = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
			thuoc th = (thuoc) iterator.next();
			alThuoc.add(th);
		}
		return alThuoc;
	}

	public static String[] layDanhSachTenThuoc() {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		ArrayList<String> lst = new ArrayList<>();

		session.beginTransaction();
		String sql = "SELECT * FROM thuoc";
		SQLQuery query = session.createSQLQuery(sql);	
		query.addEntity(thuoc.class);

		List employees = query.list();

		// System.out.println("Loi ngay day");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			thuoc employee = (thuoc) iterator.next();
			//System.out.println(employee.getMaMonHoc());
			lst.add(employee.getTenThuoc());
		}
		String[] lstDSTh = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSTh;
	}

}
