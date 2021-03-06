package DAO;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.RowSorter;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.cachdung;
import entity.phieukhambenh;
import util.HibernateUtil;

public class phieukhamDAO {
	public static ArrayList<phieukhambenh> alpk = new ArrayList<phieukhambenh>();
	//cau query field data vao model
	public static List<Object[]> layDanhSanhPhieuKham() {
	        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
	        session.beginTransaction();
	        String sql = "SELECT DISTINCT p.MaPhieuKhamBenh,b.MaBenhNhan, b.TenBenhNhan,p.NgayKham,p.TinhTrang FROM phieukhambenh p inner join ctbenhnhan ct on p.ID = ct.ID_PhieuKhamBenh inner join benhnhan b on ct.ID_BenhNhan = b.ID ORDER BY p.MaPhieuKhamBenh ASC";
	        SQLQuery query = session.createSQLQuery(sql);
	        List<Object[]> o = query.list();
	        session.close();
	        return o;
	}
	public static List<Object[]> layDanhSanhPhieuKham(String timkiem, int loai) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "";
    	if(loai==1)
		{
			 sql = "SELECT p.MaPhieuKhamBenh,b.MaBenhNhan, b.TenBenhNhan,p.NgayKham,p.TinhTrang FROM phieukhambenh p inner join ctbenhnhan ct on p.ID = ct.ID_PhieuKhamBenh inner join benhnhan b on ct.ID_BenhNhan = b.ID WHERE p.MaPhieuKhamBenh Like '%"+timkiem+"%' ORDER BY p.MaPhieuKhamBenh ASC ";
		}
		else{
			if(loai==2) 
			{
				 sql = "SELECT p.MaPhieuKhamBenh,b.MaBenhNhan, b.TenBenhNhan,p.NgayKham,p.TinhTrang FROM phieukhambenh p inner join ctbenhnhan ct on p.ID = ct.ID_PhieuKhamBenh inner join benhnhan b on ct.ID_BenhNhan = b.ID WHERE b.MaBenhNhan Like '%"+timkiem+"%' ORDER BY p.MaPhieuKhamBenh ASC";

			}
			else {
				if(loai==3)
				{
					sql = "SELECT p.MaPhieuKhamBenh,b.MaBenhNhan, b.TenBenhNhan,p.NgayKham,p.TinhTrang FROM phieukhambenh p inner join ctbenhnhan ct on p.ID = ct.ID_PhieuKhamBenh inner join benhnhan b on ct.ID_BenhNhan = b.ID WHERE b.TenBenhNhan Like '%"+timkiem+"%' ORDER BY p.MaPhieuKhamBenh ASC";
				}
				else sql = "SELECT DISTINCT p.MaPhieuKhamBenh,b.MaBenhNhan, b.TenBenhNhan,p.NgayKham,p.TinhTrang FROM phieukhambenh p inner join ctbenhnhan ct on p.ID = ct.ID_PhieuKhamBenh inner join benhnhan b on ct.ID_BenhNhan = b.ID ORDER BY p.MaPhieuKhamBenh ASC";
			}
				
				
		}        
    	SQLQuery query = session.createSQLQuery(sql);
        List<Object[]> o = query.list();
        session.close();
        return o;
}
	public static int layidTheoMaPhieuKhamBenh(String maphieukham)
	{
		List lpk;
		int id = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM phieukhambenh where MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
        query.addEntity(phieukhambenh.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			phieukhambenh pkb = (phieukhambenh) iterator.next();
			id = pkb.getID();
		}
        session.close();
        return id;
	}

	public static ArrayList<phieukhambenh> phieukham()
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
	public static ArrayList<phieukhambenh> phieukhamTrongNgay()
	{
		ArrayList<phieukhambenh> sophieuhomnay = new ArrayList<phieukhambenh>();
		List lpk;
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM phieukhambenh p WHERE p.NgayKham = CURDATE()";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(phieukhambenh.class);
		lpk = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			phieukhambenh pkb = (phieukhambenh) iterator.next();
			sophieuhomnay.add(pkb);
		}
		return sophieuhomnay;
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
	public static double laytongtientuMaPhieuKham(String maphieukham)
	{
		List lpk;
		double tongtien = 0;
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        String sql = "SELECT * FROM phieukhambenh p where p.MaPhieuKhamBenh =:m";
        SQLQuery query = session.createSQLQuery(sql);
        query.setParameter("m", maphieukham);
		query.addEntity(phieukhambenh.class);
		lpk = query.list();

		for (Iterator iterator = lpk.iterator(); iterator.hasNext();) {
			phieukhambenh pkb = (phieukhambenh) iterator.next();
			tongtien = pkb.getTongTienThuoc();
		}
        session.close();
        return tongtien;
	}
	
	public static void suaPhieuKham(phieukhambenh pk) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.update(pk);
            session.getTransaction().commit();
        } catch (Exception e) {
            session.getTransaction().rollback();
            System.out.println(e);
        } finally {
            session.close();
        }
    }
}
