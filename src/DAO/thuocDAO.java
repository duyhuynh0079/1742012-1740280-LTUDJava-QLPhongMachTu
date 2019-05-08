package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.benhnhan;
import entity.quidinh;
import entity.thuoc;
import entity.thuoc1;
import util.HibernateUtil;

public class thuocDAO {

	public static ArrayList<thuoc1> layThuoc()
	{
		List lst;
		ArrayList<thuoc1> alThuoc = new ArrayList<thuoc1>();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM thuoc";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(thuoc1.class);
		lst = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lst.iterator(); iterator.hasNext();) {
			thuoc1 th = (thuoc1) iterator.next();
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
		query.addEntity(thuoc1.class);

		List employees = query.list();

		// System.out.println("Loi ngay day");
		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
			thuoc1 employee = (thuoc1) iterator.next();
			//System.out.println(employee.getMaMonHoc());
			lst.add(employee.getTenThuoc());
		}
		String[] lstDSTh = lst.toArray(new String[lst.size()]);
		session.close();
		return lstDSTh;
	}
  
  	public static  thuoc timMaThuoc(String mat) {

	    List<thuoc> t = new ArrayList<thuoc>();

	    //Session session = this.sessionFactory.getCurrentSession();
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    session.beginTransaction();
	    t = session.createQuery("from thuoc where MaThuoc=?").setParameter(0, mat).list();
	    session.getTransaction().commit();
	    session.close();
	    if (t.size() > 0) {
	        return t.get(0);
	    } else {
	        return null;
	    }
	}
	public static boolean themThuoc(thuoc t) {
		Session session = HibernateUtil.getSessionFactory().openSession();

		try {
			session.beginTransaction();
			session.save(t);
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
	public static boolean suaThuoc(thuoc t) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try{
			session.beginTransaction();
			session.update(t); 
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
	
	public static List<Object[]>laydanhsachTheoMaPhieuKhamBenh(String maphieukham)
	{
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT DISTINCT th.TenThuoc,ct.SoLuong, th.DonGia,dv.TenDonVi,cd.TenCachDung\r\n" + 
        		"FROM thuoc th inner join donvi dv on th.ID_DonVi = dv.ID\r\n" + 
        		"inner JOIN cachdung cd on th.ID_CachDung = cd.ID\r\n" + 
        		"inner join ctthuoc ct on ct.ID_Thuoc = th.ID\r\n" + 
        		"inner join phieukhambenh p on ct.ID_PhieuKhamBenh = p.ID\r\n" + 
        		"where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        List<Object[]> o = query.list();
        session.close();
        return o;
	}
}
