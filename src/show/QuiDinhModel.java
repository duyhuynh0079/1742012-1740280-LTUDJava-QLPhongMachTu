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

public class QuiDinhModel extends AbstractTableModel{
	private List qd; // list kieu ob sinhvien lay tu enity.sinhvien
	public static ArrayList<quidinh> listQD = new ArrayList<quidinh>();
	public QuiDinhModel()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM quidinh";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(quidinh.class);
		qd = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = qd.iterator(); iterator.hasNext();) {
			quidinh qd2 = (quidinh) iterator.next();
			listQD.add(qd2);
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
		return qd.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		quidinh qd2 = (quidinh)qd.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return qd2.getID();	
		case 1:
			return qd2.getMaQuiDinh();
		case 2:
			return qd2.getTenQuiDinh();
		case 3: 
			return qd2.getGiaTri();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID quy dinh","Ma quy dinh","Ten quy dinh","Gia tri"};
			return columnNames[col];
		}

}
