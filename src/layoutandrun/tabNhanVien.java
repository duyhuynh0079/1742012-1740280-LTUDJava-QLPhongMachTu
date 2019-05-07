package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.Properties;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import layoutandrun.subtabBenhNhan;
import show.showBenhNhan;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

public class tabNhanVien extends JFrame {
	private JTextField jtTimTenBN;
	private JTextField jtTimTenLB;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXemDanhSach;
	private JButton btnRong;
	private JButton btnTimKiem;
	private JComboBox jcbb;
	private JTable jtb;
	private JLabel lblNewLabel_2;
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		tabNhanVien tnv = new tabNhanVien();
		tnv.setLocationRelativeTo(null);
		tnv.setVisible(true);
		tnv.setResizable(false);
	}

	public tabNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getMaximumSize());

		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		addComponentToTab(jtp);// goi ham tao cac tab con
	}

	public void addComponentToTab(JTabbedPane jtp) {
		//tao tab BenhNhan
		JPanel pnlBenhNhan = new JPanel();
		subtabBenhNhan stbn = new subtabBenhNhan();
		stbn.controlBenhNhan(pnlBenhNhan);
		jtp.addTab("Bệnh Nhân", pnlBenhNhan);//ti doi jpane
		pnlBenhNhan.setLayout(null);
		

		
		//tao tab PhieuKhamBenh
		JPanel pnlPhieuKhamBenh = new JPanel();
		jtp.addTab("Phiếu Khám Bệnh", pnlPhieuKhamBenh);
		pnlPhieuKhamBenh.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHIẾU KHÁM BỆNH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(460, 11, 377, 50);
		pnlPhieuKhamBenh.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		pnlPhieuKhamBenh.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Tên Bệnh Nhân");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNewLabel_1.setBounds(34, 89, 97, 14);
		pnlPhieuKhamBenh.add(lblNewLabel_1);
		
		JLabel lblTnLoiBnh = new JLabel("Tên Loại Bệnh");
		lblTnLoiBnh.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTnLoiBnh.setBounds(253, 89, 97, 14);
		pnlPhieuKhamBenh.add(lblTnLoiBnh);
		
		JLabel lblNgyKhm = new JLabel("Ngày Khám");
		lblNgyKhm.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNgyKhm.setBounds(460, 89, 75, 14);
		pnlPhieuKhamBenh.add(lblNgyKhm);
		
		jtTimTenBN = new JTextField();
		jtTimTenBN.setToolTipText("Nhập tên bệnh nhân");
		jtTimTenBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtTimTenBN.setBounds(34, 114, 190, 37);
		pnlPhieuKhamBenh.add(jtTimTenBN);
		jtTimTenBN.setColumns(10);
		
		jtTimTenLB = new JTextField();
		jtTimTenLB.setToolTipText("Nhập tên loại bệnh\r\n");
		jtTimTenLB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtTimTenLB.setBounds(253, 114, 182, 37);
		pnlPhieuKhamBenh.add(jtTimTenLB);
		jtTimTenLB.setColumns(10);
		
//		UtilDateModel model = new UtilDateModel();
//		Properties p = new Properties();
//		p.put("text.today", "Today");
//		p.put("text.month", "Month");
//		p.put("text.year", "Year");
//		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
//		pnlPhieuKhamBenh.add(datePanel);
	
//		UtilDateModel model = new UtilDateModel();
//		JDatePanelImpl datePanel = new JDatePanelImpl(model);
//		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel);
//		pnlPhieuKhamBenh.add(datePicker);
		
		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setAlignmentY(Component.TOP_ALIGNMENT);
		btnTimKiem.setBounds(727, 76, 160, 37);
		pnlPhieuKhamBenh.add(btnTimKiem);
		
		btnXemDanhSach = new JButton("Danh Sách");
		btnXemDanhSach.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\load.png"));
		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemDanhSach.setBounds(727, 129, 160, 37);
		pnlPhieuKhamBenh.add(btnXemDanhSach);
		
		btnThem = new JButton("Thêm");
		btnThem.setSelectedIcon(null);
		btnThem.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(935, 601, 111, 38);
		pnlPhieuKhamBenh.add(btnThem);
		
		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update.png"));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(935, 650, 111, 38);
		pnlPhieuKhamBenh.add(btnSua);
		
		btnRong = new JButton("");
		btnRong.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\xoay.png"));
		btnRong.setBounds(1292, 629, 40, 38);
		pnlPhieuKhamBenh.add(btnRong);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 199, 854, 489);
		pnlPhieuKhamBenh.add(scrollPane);
		
		JButton btnHoaDon = new JButton("Thanh \r\nToán");
		btnHoaDon.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\hoadon.png"));
		btnHoaDon.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnHoaDon.setBounds(1082, 615, 174, 61);
		pnlPhieuKhamBenh.add(btnHoaDon);
		
	}
}
