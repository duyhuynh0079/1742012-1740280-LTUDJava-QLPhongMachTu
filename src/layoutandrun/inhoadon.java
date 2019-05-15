package layoutandrun;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.thamSoReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

public class inhoadon {
	public static List<Object[]> laydanhsachTheoMaPhieuKhamBenh(String maphieukham) {
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		session.beginTransaction();
		String sql = "SELECT DISTINCT th.TenThuoc,ct.SoLuong, th.DonGia,dv.TenDonVi,cd.TenCachDung\r\n"
				+ "FROM thuoc th inner join donvi dv on th.ID_DonVi = dv.ID\r\n"
				+ "inner JOIN cachdung cd on th.ID_CachDung = cd.ID\r\n"
				+ "inner join ctthuoc ct on ct.ID_Thuoc = th.ID\r\n"
				+ "inner join phieukhambenh p on ct.ID_PhieuKhamBenh = p.ID\r\n" + "where p.MaPhieuKhamBenh =:m";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("m", maphieukham);
		List<Object[]> o = query.list();
		session.close();
		return o;
	}

	public static void thucHienInHoaDon(thamSoReport t) {
		ArrayList<entity.inhoadon> dataBeanList = new ArrayList<entity.inhoadon>();
		List<Object[]> o = laydanhsachTheoMaPhieuKhamBenh(t.getMaPhieuKham());
		for (Object[] countResult : o) {
			entity.inhoadon i = new entity.inhoadon();
			i.setTENTHUOC(countResult[0].toString());
			i.setSOLUONG(countResult[1].toString());
			i.setDONGIA(countResult[2].toString());
			i.setDONVI(countResult[3].toString());
			i.setCACHDUNG(countResult[4].toString());
			dataBeanList.add(i);
		}
		JasperReport jasperReport;
		try {
//			jasperReport = JasperCompileManager
//					.compileReport("C:\\Users\\Mr.F\\eclipse-workspace\\layout\\Blank_A4.jrxml");
			jasperReport = JasperCompileManager
					.compileReport("E:\\sourcetree\\src\\Bill.jrxml");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

			Map parameters = new HashMap();
			
			parameters.put("ReportTitle", "Hóa Đơn Khám Bệnh");
			parameters.put("MaPhieuKham", t.getMaPhieuKham());
			parameters.put("NgayKham", t.getNgayKham());
			parameters.put("MaBenhNhan", t.getMaBenhNhan());
			parameters.put("TenBenhNhan", t.getTenBenhNhan());
			parameters.put("TienThuoc", t.getTienThuoc());
			parameters.put("TienKham", t.getTienKham());
			parameters.put("TongTien", t.getTongTien());
			parameters.put("STT1", t.getSTT1());
			parameters.put("STT2", t.getSTT2());
			parameters.put("STT3", t.getSTT3());
			parameters.put("TenLoaiBenh1", t.getTenLoaiBenh1());
			parameters.put("TenLoaiBenh2", t.getTenLoaiBenh2());
			parameters.put("TenLoaiBenh3", t.getTenLoaiBenh3());
			parameters.put("TrieuChung1", t.getTrieuChung1());
			parameters.put("TrieuChung2", t.getTrieuChung2());
			parameters.put("TrieuChung3", t.getTrieuChung3());

			JasperPrint jasperPrint = null;

			jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanColDataSource);

			// Chạy báo cáo và export ra file PDF.
			//JasperExportManager.exportReportToPdfFile(jasperPrint, "E:/Java/StyledTextReport.pdf");
			JasperViewer.viewReport(jasperPrint,false);//xem báo cáo rồi save lại
				
			System.out.println("Done!");
		} catch (JRException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
}
