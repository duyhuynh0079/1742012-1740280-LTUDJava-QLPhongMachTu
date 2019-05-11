package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import DAO.nhanvienDAO;
import entity.nhanvien;

public class NhanVienModel extends AbstractTableModel{
	private List nv; // list kieu ob nhanvien lay tu enity.nhanvien
	public static ArrayList<nhanvien> listNV = new ArrayList<nhanvien>();
	public NhanVienModel()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT *  FROM nhanvien WHERE TinhTrang=1";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(nhanvien.class);
		nv = query.list();
		
		//ham hung 1 array list rieng tÃƒÂ¡Ã‚Â»Ã‚Â« list truyen qua
		for (Iterator iterator = nv.iterator(); iterator.hasNext();) {
			nhanvien nv2 = (nhanvien) iterator.next();
			listNV.add(nv2);
		}
		
		//dong ket noi
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	

	@Override
	public int getColumnCount() {
		return 7;//lay 7 cot tu database
	}

	@Override
	public int getRowCount() {
		return nv.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		nhanvien nv2 = (nhanvien)nv.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return nv2.getID();	
		case 1:
			return nv2.getTenDangNhap();
		case 2:
			return nv2.getHoTenNV();
		case 3:
			return nv2.getNgaySinh();
		case 4:
			return nv2.getDiaChi();
		case 5:
			return nv2.getSDT();
//		case 7:
//			return nv2.getTinhTrang();
		case 6:
			return nhanvienDAO.layTenChucVu(nv2.getMaCV());
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			//String[] columnNames=new String[] {"ID nhÃ¢n viÃªn","TÃªn Ä‘Äƒng nháº­p","Máº­t kháº©u","Há»� tÃªn","NgÃ y sinh","Ä�á»‹a chá»‰","Sá»‘ Ä‘iá»‡n thoáº¡i","TÃ¬nh tráº¡ng","Ma chá»©c vá»¥"};
			String[] columnNames=new String[] {"ID nhân viên","Tên đăng nhập","họ tên","Ngày sinh","Địa chỉ","Số điện thoại","Chức vụ"};
			return columnNames[col];
		}

}
