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
		JPanel pnlPhieuKhamBenh = new JPanel();
		subtabPhieuKhamBenh stpkb = new subtabPhieuKhamBenh();
		stpkb.controlPhieuKhamBenh(pnlPhieuKhamBenh);
		jtp.addTab("Phiếu Khám Bệnh", pnlPhieuKhamBenh);
		pnlPhieuKhamBenh.setLayout(null);
	
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
//		jtTimPhieu = new JTextField();
//		jtTimPhieu.setToolTipText("Nhập đối tượng tìm kiếm ");
//		jtTimPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		jtTimPhieu.setBounds(34, 102, 347, 37);
//		pnlPhieuKhamBenh.add(jtTimPhieu);
//		jtTimPhieu.setColumns(10);
//		
//		btnTimKiem = new JButton("Tìm Kiếm");
//		btnTimKiem.setIcon(new ImageIcon(
//				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
//		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnTimKiem.setAlignmentY(Component.TOP_ALIGNMENT);
//		btnTimKiem.setBounds(460, 102, 159, 37);
//		pnlPhieuKhamBenh.add(btnTimKiem);
//		
//		btnXemDanhSach = new JButton("Danh Sách");
//		btnXemDanhSach.setIcon(new ImageIcon(
//				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\load.png"));
//		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnXemDanhSach.setBounds(655, 102, 159, 37);
//		pnlPhieuKhamBenh.add(btnXemDanhSach);
//		
//		btnSuaPhieu = new JButton("Sửa Phiếu");
//		btnSuaPhieu.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\edit2.png"));
//		btnSuaPhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
//		btnSuaPhieu.setBounds(959, 627, 174, 61);
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
//		btnThanhToan.setBounds(1164, 627, 174, 61);
//		pnlPhieuKhamBenh.add(btnThanhToan);
//		
//		JLabel lblNewLabel_1 = new JLabel("*Có thể nhập tìm theo tên bệnh nhân, mã phiếu khám, ngày khám...\r\n");
//		lblNewLabel_1.setForeground(Color.RED);
//		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
//		lblNewLabel_1.setBounds(34, 153, 425, 23);
//		pnlPhieuKhamBenh.add(lblNewLabel_1);
//		
//		JLabel lblNewLabel_3 = new JLabel("Mã Bệnh Nhân");
//		lblNewLabel_3.setForeground(Color.BLUE);
//		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblNewLabel_3.setBounds(959, 266, 115, 23);
//		pnlPhieuKhamBenh.add(lblNewLabel_3);
//		
//		JLabel lblTnBnhNhn = new JLabel("Tên Bệnh Nhân");
//		lblTnBnhNhn.setForeground(Color.BLUE);
//		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblTnBnhNhn.setBounds(959, 331, 115, 23);
//		pnlPhieuKhamBenh.add(lblTnBnhNhn);
//		
//		JLabel lblMPhiuKhm = new JLabel("Mã Phiếu Khám");
//		lblMPhiuKhm.setForeground(Color.BLUE);
//		lblMPhiuKhm.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblMPhiuKhm.setBounds(959, 395, 115, 23);
//		pnlPhieuKhamBenh.add(lblMPhiuKhm);
//		
//		JLabel lblNgyKhm = new JLabel("Ngày Khám");
//		lblNgyKhm.setForeground(Color.BLUE);
//		lblNgyKhm.setFont(new Font("Tahoma", Font.BOLD, 14));
//		lblNgyKhm.setBounds(959, 459, 88, 29);
//		pnlPhieuKhamBenh.add(lblNgyKhm);
//		
//		JLabel lblMaBenhNhan = new JLabel("");
//		lblMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblMaBenhNhan.setBounds(1108, 264, 230, 27);
//		pnlPhieuKhamBenh.add(lblMaBenhNhan);
//		
//		JLabel lblTenBenhNhan = new JLabel("");
//		lblTenBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblTenBenhNhan.setBounds(1108, 328, 230, 29);
//		pnlPhieuKhamBenh.add(lblTenBenhNhan);
//		
//		JLabel lblMaPhieuKham = new JLabel("");
//		lblMaPhieuKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblMaPhieuKham.setBounds(1108, 392, 230, 29);
//		pnlPhieuKhamBenh.add(lblMaPhieuKham);
//		
//		JLabel lblNgayKham = new JLabel("");
//		lblNgayKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		lblNgayKham.setBounds(1108, 459, 230, 29);
//		pnlPhieuKhamBenh.add(lblNgayKham);
//		
//		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN PHIẾU KHÁM BỆNH");
//		lblNewLabel_4.setForeground(Color.BLACK);
//		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
//		lblNewLabel_4.setBounds(959, 199, 304, 29);
//		pnlPhieuKhamBenh.add(lblNewLabel_4);
//		
//		JButton btnChiTiet = new JButton("Chi Tiết");
//		btnChiTiet.setHorizontalAlignment(SwingConstants.LEFT);
//		btnChiTiet.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Phieukham.png"));
//		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 12));
//		btnChiTiet.setBounds(959, 539, 174, 61);
//		pnlPhieuKhamBenh.add(btnChiTiet);
		
	}
}
