package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.cachdung;



public class CachDungModel extends AbstractTableModel{
	private List cd;
	public static ArrayList<cachdung> listCD = new ArrayList<cachdung>();
	public CachDungModel()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM cachdung";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(cachdung.class);
		cd = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = cd.iterator(); iterator.hasNext();) {
			cachdung dv2 = (cachdung) iterator.next();
			listCD.add(dv2);
		}
		
		//dong ket noi
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	

	@Override
	public int getColumnCount() {
		return 3;//lay 3 cot tu database
	}

	@Override
	public int getRowCount() {
		return cd.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		cachdung dv2 = (cachdung)cd.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return dv2.getID();	
		case 1:
			return dv2.getMaCachDung();
		case 2:
			return dv2.getTenCachDung();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID cach dung","Ma cach dung","Ten cach dung"};
			return columnNames[col];
		}

}
