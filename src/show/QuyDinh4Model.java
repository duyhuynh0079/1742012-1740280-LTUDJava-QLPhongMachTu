package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.quydinh4;

public class QuyDinh4Model extends AbstractTableModel{
	private List qd; // list kieu ob sinhvien lay tu enity.sinhvien
	public static ArrayList<quydinh4> listQD = new ArrayList<quydinh4>();
	public QuyDinh4Model()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM quydinh4";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(quydinh4.class);
		qd = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = qd.iterator(); iterator.hasNext();) {
			quydinh4 qd2 = (quydinh4) iterator.next();
			listQD.add(qd2);
		}
		
		//dong ket noi
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	

	@Override
	public int getColumnCount() {
		return 4;//lay 3 cot tu database
	}

	@Override
	public int getRowCount() {
		return qd.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		quydinh4 qd2 = (quydinh4)qd.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return qd2.getID();	
		case 1:
			return qd2.getMaQuyDinh();
		case 2:
			return qd2.getTenQuyDinh();
		case 3:
			return qd2.getGiaTri();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID qui định","Mã qui định","Tên qui đinh","Giá trị"};
			return columnNames[col];
		}

}
