package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.donvi;



public class DonViTinhThuocModelqlt extends AbstractTableModel{
	private List dv; // list kieu ob sinhvien lay tu enity.sinhvien
	public static ArrayList<donvi> listDV = new ArrayList<donvi>();
	public DonViTinhThuocModelqlt()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang don vi
		String sql = "SELECT * FROM donvi";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(donvi.class);
		dv = query.list();
		
		//ham hung 1 array list rieng tÃ¡Â»Â« list truyen qua
		for (Iterator iterator = dv.iterator(); iterator.hasNext();) {
			donvi dv2 = (donvi) iterator.next();
			listDV.add(dv2);
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
		return dv.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		donvi dv2 = (donvi)dv.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return dv2.getID();	
		case 1:
			return dv2.getMaDonVi();
		case 2:
			return dv2.getTenDonVi();
		default:
			return null;
		}
	}
	// set ten cot
		public String getColumnName(int col) {
			String[] columnNames=new String[] {"ID Don vi","Ma don vi","Ten don vi"};
			return columnNames[col];
		}

}
