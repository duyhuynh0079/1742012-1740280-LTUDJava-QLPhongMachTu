package layoutandrun;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.bcloaibenh;
import entity.bcthuoc;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

public class baocaoLoaiBenh {
	public static List<Object[]> laydanhsachKiemTraRong(int Thang, int Nam) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT * FROM `hoadon` h WHERE MONTH(h.NgayThanhToan) =:a AND YEAR(h.NgayThanhToan) =:b  ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("a",Thang);
		query.setParameter("b",Nam);
		List<Object[]> o = query.list();
		session.close();
		return o;
	}

	public static List<Object[]> laydanhsachTheoThangNam(int Thang, int Nam) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT l.TenLoaiBenh, l.TrieuChung, COUNT(l.TenLoaiBenh) AS 'SoCaBenh' "
				+ "FROM phieukhambenh p, ctloaibenh ct, loaibenh l "
				+ "WHERE p.ID = ct.ID_PhieuKhamBenh "
				+ "AND ct.ID_LoaiBenh = l.ID "
				+ "AND MONTH(p.NgayKham) =:a "
				+ "AND YEAR(p.NgayKham) =:b "
				+ "AND p.TinhTrang = 1 "
				+ "GROUP BY l.MaLoaiBenh ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("a", Thang);
		query.setParameter("b", Nam);
		List<Object[]> o = query.list();
		session.close();
		return o;
	}
		public static void thuchienInBaoCaoBenh(int Thang, int Nam) {
		ArrayList<bcloaibenh> dataBeanList = new ArrayList<bcloaibenh>();
		List<Object[]> o = laydanhsachTheoThangNam(Thang, Nam);
		int i = 1;
		for (Object[] countResult : o) {
			bcloaibenh bc = new bcloaibenh();
			bc.setSTT(String.valueOf(i));
			bc.setTENLOAIBENH(String.valueOf(countResult[0]));
			bc.setTRIEUCHUNG(String.valueOf(countResult[1]));
			bc.setSOCABENH(String.valueOf(countResult[2]));
			dataBeanList.add(bc);
			i++;
			System.out.println("stt--" + bc.getSTT() + " tenbenh--" + bc.getTENLOAIBENH() + " trieuchung--" + bc.getTRIEUCHUNG()
					+ " socabenh--" + bc.getSOCABENH());
		}
		JasperReport jasperReport;
		try {
			jasperReport = JasperCompileManager.compileReport("E:\\sourcetree\\src\\BCLoaiBenh.jrxml");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

			Map parameters = new HashMap();

			parameters.put("ReportTitle", "Báo cáo loại bệnh theo tháng");
			parameters.put("Thang", String.valueOf(Thang) + "-" + String.valueOf(Nam));

			JasperPrint jasperPrint = null;

			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

			// Chạy báo cáo và export ra file PDF.
			// JasperExportManager.exportReportToPdfFile(jasperPrint,
			// "E:/Java/StyledTextReport.pdf");
			JasperViewer.viewReport(jasperPrint, false);// xem báo cáo rồi save lại

			System.out.println("Done!");
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
