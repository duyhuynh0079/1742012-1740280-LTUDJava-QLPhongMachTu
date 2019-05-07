package show;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import entity.benhnhan;

public class showBenhNhan extends AbstractTableModel {
	private List lbn;
	public static ArrayList<benhnhan> albn = new ArrayList<benhnhan>();//vi ko cung package class main nen dung them public
	public showBenhNhan()
	{
		super();
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		String sql = "SELECT * FROM benhnhan";
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(benhnhan.class);
		lbn = query.list();

		//ham hung 1 array list rieng từ list truyen qua
		for (Iterator iterator = lbn.iterator(); iterator.hasNext();) {
			benhnhan bn = (benhnhan) iterator.next();
			albn.add(bn);
		}

		//dong session
		s.close();
		//ngat ket noi
		sf.close();
	}
	
	public showBenhNhan(String timkiem, int loai)
	{
		super();
		String sql = "";
		//tao session ket noi hibernate den du lieu
		SessionFactory sf = new Configuration().configure().buildSessionFactory();
		//mo ket noi bang session
		Session s = sf.openSession();
		//tao cau query truy van den bang sinh vien
		if(loai==1)
		{
			 sql = "SELECT * FROM benhnhan bn WHERE bn.TenBenhNhan Like '%"+timkiem+"%'";
		}
		else{
			if(loai==2) 
			{
				 sql = "SELECT * FROM benhnhan bn WHERE bn.MaBenhNhan Like '%"+timkiem+"%'";

			}
			else sql = "SELECT * FROM benhnhan";
				
		}
		SQLQuery query = s.createSQLQuery(sql);
		query.addEntity(benhnhan.class);
		lbn = query.list();

		//dong session
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
		return lbn.size();//so dong bang so dong du lieu DB
	}

	@Override
	public Object getValueAt(int row, int cow) {
		benhnhan bn = (benhnhan)lbn.get(row);//gia tri 1 Ojebt tuong ung 1 dong trong st 
		switch (cow) {//ghep thuoc tinh cho tung cot
		case 0:
			return bn.getMaBenhNhan();	
		case 1:
			return bn.getTenBenhNhan();	
		case 2:
			return bn.getGioiTinh();
		case 3:
			return bn.getNamSinh();
		case 4:
			return bn.getDiaChi();
		default:
			return null;
		}
	}
	// set ten cot
	public String getColumnName(int col) {
		String[] columnNames=new String[] {"Mã Bệnh Nhân","Họ Tên","Giới Tính","Năm Sinh","Địa Chỉ"};
		return columnNames[col];
	}
}