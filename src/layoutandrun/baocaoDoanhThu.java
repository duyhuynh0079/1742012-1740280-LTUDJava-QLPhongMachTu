package layoutandrun;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import entity.bcdoanhthu;
import entity.thamSoReport;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;
import util.HibernateUtil;

public class baocaoDoanhThu {
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
		String sql = "SELECT h.NgayThanhToan,COUNT(h.NgayThanhToan) as 'SoBenhNhan', SUM(h.TienKham) FROM `hoadon` h "
				+ "WHERE MONTH(h.NgayThanhToan) =:a AND YEAR(h.NgayThanhToan) =:b GROUP BY h.NgayThanhToan  ";
		SQLQuery query = session.createSQLQuery(sql);
		query.setParameter("a",Thang);
		query.setParameter("b",Nam);
		List<Object[]> o = query.list();
		session.close();
		return o;
	}

	public static void thuchienInBaoCaoDoanhThu(int Thang, int Nam) {
		ArrayList<bcdoanhthu> dataBeanList = new ArrayList<bcdoanhthu>();
		List<Object[]> o = laydanhsachTheoThangNam(Thang,Nam);
		Date Ngay;
		int i = 1;
		double tongdoanhthu = 0;
		for (Object[] countResult : o) {
			tongdoanhthu = tongdoanhthu + (double)countResult[2];
		}
		for (Object[] countResult : o) {
			bcdoanhthu bc = new bcdoanhthu();
			bc.setSTT(String.valueOf(i));
			bc.setNGAY(new SimpleDateFormat("dd-MM-yyyy").format(countResult[0]));
			bc.setSOBENHNHAN(String.valueOf(countResult[1]));
			bc.setDOANHTHU(String.valueOf(countResult[2]));
			double tyle = 0;
			double tylelamtron = 0;
			tyle = ((double)countResult[2]/tongdoanhthu)*100;
			tylelamtron = Math.round(tyle*100.0)/100.0;
			bc.setTYLE(String.valueOf(tylelamtron));
			dataBeanList.add(bc);
			i++;
			System.out.println("stt--"+bc.getSTT()+" ngay--"+bc.getNGAY()+" sobenhnhan--"+bc.getSOBENHNHAN()+" doanhthu--"+bc.getDOANHTHU()+" tyle--"+bc.getTYLE());
		}
		JasperReport jasperReport;
		try {
			jasperReport = JasperCompileManager
					.compileReport("E:\\sourcetree\\src\\BCDoanhThu.jrxml");

			JRBeanCollectionDataSource beanColDataSource = new JRBeanCollectionDataSource(dataBeanList);

			Map parameters = new HashMap();
			
			parameters.put("ReportTitle", "Báo cáo doanh thu theo ngày");
			parameters.put("Thang", String.valueOf(Thang)+"-"+String.valueOf(Nam));

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
