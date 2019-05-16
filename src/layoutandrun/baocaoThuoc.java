package layoutandrun;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.bcdoanhthu;
import entity.bcthuoc;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

public class baocaoThuoc {
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
		String sql = "SELECT t.TenThuoc, d.TenDonVi, SUM(ct.SoLuong) AS 'SoLanDung'\r\n"
				+ "FROM phieukhambenh p, ctthuoc ct, thuoc t, donvi d, cachdung c\r\n"
				+ "WHERE p.ID = ct.ID_PhieuKhamBenh \r\n" + "AND ct.ID_Thuoc = t.ID\r\n" + "AND t.ID_DonVi = d.ID\r\n"
				+ "AND t.ID_CachDung = c.ID\r\n" + "AND MONTH(p.NgayKham) =:a \r\n" + "AND YEAR(p.NgayKham) =:b\r\n"
				+ "AND p.TinhTrang = 1\r\n" + "GROUP BY t.MaThuoc";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("a", Thang);
		query.setParameter("b", Nam);
		List<Object[]> o = query.list();
		session.close();
		return o;
	}

	public static void thuchienInBaoCaoThuoc(int Thang, int Nam) {
		ArrayList<bcthuoc> dataBeanList = new ArrayList<bcthuoc>();
		List<Object[]> o = laydanhsachTheoThangNam(Thang, Nam);
		int i = 1;
		for (Object[] countResult : o) {
			bcthuoc bc = new bcthuoc();
			bc.setSTT(String.valueOf(i));
			bc.setTHUOC(String.valueOf(countResult[0]));
			bc.setDONVITINH(String.valueOf(countResult[1]));
			bc.setSOLANDUNG(String.valueOf(countResult[2]));
			dataBeanList.add(bc);
			i++;
			System.out.println("stt--" + bc.getSTT() + " thuoc--" + bc.getTHUOC() + " donvitinh--" + bc.getDONVITINH()
					+ " solandung--" + bc.getSOLANDUNG());
		}
		JasperReport jasperReport;
		try {
			jasperReport = JasperCompileManager.compileReport("E:\\sourcetree\\src\\BCThuoc.jrxml");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

			Map parameters = new HashMap();

			parameters.put("ReportTitle", "Báo cáo sử dụng thuốc");
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
