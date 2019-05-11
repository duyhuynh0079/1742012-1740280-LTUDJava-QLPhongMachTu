package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.loaibenh;
import entity.quidinh;

public class LoaiBenhModel extends AbstractTableModel{
	private List lb; // list kieu ob sinhvien lay tu enity.sinhvien
	public static ArrayList<loaibenh> listLB = new ArrayList<loaibenh>();
	public LoaiBenhModel()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM loaibenh";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(loaibenh.class);
		lb = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = lb.iterator(); iterator.hasNext();) {
			loaibenh lb2 = (loaibenh) iterator.next();
			listLB.add(lb2);
		}
		
		//dong ket noi
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	

	@Override
	public int getColumnCount() {
		return 4;//lay 4 cot tu database
	}

	@Override
	public int getRowCount() {
		return lb.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		loaibenh lb2 = (loaibenh)lb.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return lb2.getID();	
		case 1:
			return lb2.getMaLoaiBenh();
		case 2:
			return lb2.getTenLoaiBenh();
		case 3: 
			return lb2.getTrieuChung();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID loại bệnh","Mã loại bệnh","Tên loại bệnh","Triệu chứng"};
			return columnNames[col];
		}

}
