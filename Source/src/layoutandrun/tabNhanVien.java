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
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import layoutandrun.subtabBenhNhan;
import show.showBenhNhan;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class tabNhanVien extends JFrame {
//	private JLabel jlMaBenhNhan;
//	private JTextField jtTimTenBN;
//	private JTextField jtTimTenLB;
//	private JButton btnSuaPhieu;
//	private JButton btnXemDanhSach;
//	private JButton btnTimKiem;
//	private JComboBox jcbb;
//	private JTable jtb;
//	private JLabel lblNewLabel_2;
	

	
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
//		JPanel jpn = new JPanel();
		JPanel pnlBenhNhan = new JPanel();
		subtabBenhNhan stbn = new subtabBenhNhan();
		stbn.controlBenhNhan(pnlBenhNhan);
		jtp.addTab("Bệnh Nhân", pnlBenhNhan);// doi jpanel
		pnlBenhNhan.setLayout(null);
		
		
		
		
		//tao tab PhieuKhamBenh
//		JPanel pnlPhieuKhamBenh = new JPanel();
//		jtp.addTab("Phiếu Khám Bệnh", pnlPhieuKhamBenh);
//		pnlPhieuKhamBenh.setLayout(null);
//		
//		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHIẾU KHÁM BỆNH");
//		lblNewLabel.setForeground(Color.BLUE);
//		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
//		lblNewLabel.setBounds(460, 11, 377, 50);
//		pnlPhieuKhamBenh.add(lblNewLabel);
//		
//		JLabel label = new JLabel("");
//		label.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
//		label.setBounds(1026, 28, 115, 84);
//		pnlPhieuKhamBenh.add(label);
//		
//		JLabel lblNewLabel_1 = new JLabel("Tên Bệnh Nhân");
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 11));
//		lblNewLabel_1.setBounds(34, 89, 97, 14);
//		pnlPhieuKhamBenh.add(lblNewLabel_1);
//		
//		JLabel lblTnLoiBnh = new JLabel("Tên Loại Bệnh");
//		lblTnLoiBnh.setFont(new Font("Tahoma", Font.BOLD, 11));
//		lblTnLoiBnh.setBounds(263, 89, 97, 14);
//		pnlPhieuKhamBenh.add(lblTnLoiBnh);
//		
//		JLabel lblNgyKhm = new JLabel("Ngày Khám");
//		lblNgyKhm.setFont(new Font("Tahoma", Font.BOLD, 11));
//		lblNgyKhm.setBounds(486, 89, 75, 14);
//		pnlPhieuKhamBenh.add(lblNgyKhm);
//		
//		jtTimTenBN = new JTextField();
//		jtTimTenBN.setToolTipText("Nhập tên bệnh nhân");
//		jtTimTenBN.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		jtTimTenBN.setBounds(34, 114, 190, 37);
//		pnlPhieuKhamBenh.add(jtTimTenBN);
//		jtTimTenBN.setColumns(10);
//		
//		jtTimTenLB = new JTextField();
//		jtTimTenLB.setToolTipText("Nhập tên loại bệnh\r\n");
//		jtTimTenLB.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		jtTimTenLB.setBounds(263, 114, 190, 37);
//		pnlPhieuKhamBenh.add(jtTimTenLB);
//		jtTimTenLB.setColumns(10);
//		
//		btnTimKiem = new JButton("Tìm Kiếm");
//		btnTimKiem.setIcon(new ImageIcon(
//				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
//		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnTimKiem.setAlignmentY(Component.TOP_ALIGNMENT);
//		btnTimKiem.setBounds(1001, 199, 174, 61);
//		pnlPhieuKhamBenh.add(btnTimKiem);
//		
//		btnXemDanhSach = new JButton("Danh Sách");
//		btnXemDanhSach.setIcon(new ImageIcon(
//				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\load.png"));
//		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXemDanhSach.setBounds(1001, 340, 177, 61);
//		pnlPhieuKhamBenh.add(btnXemDanhSach);
//		
//		btnSuaPhieu = new JButton("Sửa Phiếu");
//		btnSuaPhieu.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\edit2.png"));
//		btnSuaPhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnSuaPhieu.setBounds(1001, 481, 174, 61);
//		pnlPhieuKhamBenh.add(btnSuaPhieu);
//		
//		
//		JScrollPane scrollPane = new JScrollPane();
//		scrollPane.setBounds(34, 199, 854, 489);
//		pnlPhieuKhamBenh.add(scrollPane);
//		
//		JButton btnThanhToan = new JButton("Thanh \r\nToán");
//		btnThanhToan.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\hoadon.png"));
//		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnThanhToan.setBounds(1001, 626, 174, 61);
//		pnlPhieuKhamBenh.add(btnThanhToan);
		
	}
}
