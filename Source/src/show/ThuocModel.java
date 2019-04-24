package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.quidinh;
import entity.thuoc;

public class ThuocModel extends AbstractTableModel{
	private List t; // list kieu ob sinhvien lay tu enity.sinhvien
	public static ArrayList<thuoc> listT = new ArrayList<thuoc>();
	public ThuocModel()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM thuoc WHERE TinhTrang=0";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(quidinh.class);
		t = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = t.iterator(); iterator.hasNext();) {
			thuoc t2 = (thuoc) iterator.next();
			listT.add(t2);
		}
		
		//dong ket noi
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	

	@Override
	public int getColumnCount() {
		return 5;//lay 5 cot tu database
	}

	@Override
	public int getRowCount() {
		return t.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		thuoc t2 = (thuoc)t.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return t2.getID();
		case 1:
			return t2.getMaThuoc();
		case 2:
			return t2.getTenThuoc();
		case 3: 
			return t2.getDonGia();
		case 4:
			return t2.getMaDonVi();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID thuốc","Mã thuốc","Tên thuốc","Đơn giá","Đơn vị"};
			return columnNames[col];
		}

}
