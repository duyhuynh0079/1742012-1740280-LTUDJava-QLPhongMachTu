package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;

public class formThemPhieu extends JFrame {
	private JPanel jp;
	private JButton btnThem;
	private JLabel lblThuc;
	private JLabel lblThuc_1;
	private JLabel lblThuc_2;
	private JLabel lblThuc_3;
	private JLabel lblNewLabel_1;
	private JComboBox cbbThuoc2;
	private JComboBox cbbThuoc3;
	private JComboBox cbbThuoc4;
	private JComboBox cbbThuoc5;
	private JLabel lblThuc_4;
	private JComboBox cbbThuoc6;
	private JComboBox cbbThuoc7;
	private JLabel lblThuc_5;
	private JLabel lblThuc_6;
	private JComboBox cbbThuoc8;
	private JComboBox cbbThuoc9;
	private JLabel lblThuc_7;
	private JLabel lblThuc_8;
	private JComboBox cbbThuoc10;
	private JLabel lblSLng;
	private JTextField jtSoLuong1;
	private JTextField jtSoLuong2;
	private JTextField jtSoLuong3;
	private JTextField jtSoLuong4;
	private JTextField jtSoLuong5;
	private JLabel label;
	private JTextField jtSoLuong6;
	private JTextField jtSoLuong7;
	private JTextField jtSoLuong8;
	private JTextField jtSoLuong9;
	private JTextField jtSoLuong10;
	private JComboBox cbbThuoc1;
	private JLabel lblLoiBnh;
	private JComboBox cbbLoaiBenh1;
	private JLabel lblLoiBnh_1;
	private JComboBox cbbLoaiBenh2;
	private JLabel lblLoiBnh_2;
	private JComboBox cbbLoaiBenh3;
	private JLabel lblCchDng;
	private JComboBox cbbCachDung;
	private JLabel lblMBnhNhn;
	private JLabel lblMaBenhNhan;
	static String mabenhnhan = "";
	static String tenbenhnhan = "";
	private JLabel lblNgy;
	private JLabel lblNewLabel_2;
	private JLabel lblTongTien;
	private JTextField txtdinhvi;
	private SpringLayout springLayout;
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		formThemPhieu ftp = new formThemPhieu(mabenhnhan,tenbenhnhan);
		ftp.setLocationRelativeTo(null);
		ftp.setVisible(true);
		ftp.setResizable(false);
		ftp.setTitle("Mã Phiếu Khám ");
	}
	public formThemPhieu(String MaBenhNhan,String TenBenhNhan) {
		this.mabenhnhan = MaBenhNhan;
		this.tenbenhnhan = TenBenhNhan;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getMaximumSize());
		jp = new JPanel();	
		getContentPane().add(jp);
		jp.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setSelectedIcon(null);
		btnThem.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add2.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(631, 647, 146, 62);
		jp.add(btnThem);

		JLabel lblNewLabel = new JLabel("Thuốc 1");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(56, 257, 64, 14);
		jp.add(lblNewLabel);

		lblThuc = new JLabel("Thuốc 2");
		lblThuc.setForeground(Color.BLUE);
		lblThuc.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc.setBounds(56, 320, 64, 14);
		jp.add(lblThuc);

		lblThuc_1 = new JLabel("Thuốc 3");
		lblThuc_1.setForeground(Color.BLUE);
		lblThuc_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_1.setBounds(56, 384, 64, 14);
		jp.add(lblThuc_1);

		lblThuc_2 = new JLabel("Thuốc 4");
		lblThuc_2.setForeground(Color.BLUE);
		lblThuc_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_2.setBounds(56, 449, 64, 14);
		jp.add(lblThuc_2);

		lblThuc_3 = new JLabel("Thuốc 5");
		lblThuc_3.setForeground(Color.BLUE);
		lblThuc_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_3.setBounds(56, 510, 64, 14);
		jp.add(lblThuc_3);

		lblNewLabel_1 = new JLabel("PHIẾU KHÁM BỆNH");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(571, 11, 244, 37);
		jp.add(lblNewLabel_1);

		cbbThuoc2 = new JComboBox();
		cbbThuoc2.setBounds(130, 303, 199, 31);
		jp.add(cbbThuoc2);

		cbbThuoc3 = new JComboBox();
		cbbThuoc3.setBounds(130, 367, 199, 31);
		jp.add(cbbThuoc3);

		cbbThuoc4 = new JComboBox();
		cbbThuoc4.setBounds(130, 430, 199, 31);
		jp.add(cbbThuoc4);

		cbbThuoc5 = new JComboBox();
		cbbThuoc5.setBounds(130, 493, 199, 31);
		jp.add(cbbThuoc5);

		lblThuc_4 = new JLabel("Thuốc 6");
		lblThuc_4.setForeground(Color.BLUE);
		lblThuc_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_4.setBounds(832, 257, 64, 14);
		jp.add(lblThuc_4);

		cbbThuoc6 = new JComboBox();
		cbbThuoc6.setBounds(922, 240, 208, 31);
		jp.add(cbbThuoc6);

		cbbThuoc7 = new JComboBox();
		cbbThuoc7.setBounds(922, 303, 208, 31);
		jp.add(cbbThuoc7);

		lblThuc_5 = new JLabel("Thuốc 7");
		lblThuc_5.setForeground(Color.BLUE);
		lblThuc_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_5.setBounds(832, 320, 64, 14);
		jp.add(lblThuc_5);

		lblThuc_6 = new JLabel("Thuốc 8");
		lblThuc_6.setForeground(Color.BLUE);
		lblThuc_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_6.setBounds(832, 384, 64, 14);
		jp.add(lblThuc_6);

		cbbThuoc8 = new JComboBox();
		cbbThuoc8.setBounds(922, 366, 208, 31);
		jp.add(cbbThuoc8);

		cbbThuoc9 = new JComboBox();
		cbbThuoc9.setBounds(922, 432, 208, 31);
		jp.add(cbbThuoc9);

		lblThuc_7 = new JLabel("Thuốc 9");
		lblThuc_7.setForeground(Color.BLUE);
		lblThuc_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_7.setBounds(832, 449, 64, 14);
		jp.add(lblThuc_7);

		lblThuc_8 = new JLabel("Thuốc 10");
		lblThuc_8.setForeground(Color.BLUE);
		lblThuc_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblThuc_8.setBounds(832, 510, 64, 14);
		jp.add(lblThuc_8);

		cbbThuoc10 = new JComboBox();
		cbbThuoc10.setBounds(922, 493, 208, 31);
		jp.add(cbbThuoc10);

		lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSLng.setBounds(381, 203, 64, 14);
		jp.add(lblSLng);

		jtSoLuong1 = new JTextField();
		jtSoLuong1.setBounds(366, 240, 101, 31);
		jp.add(jtSoLuong1);
		jtSoLuong1.setColumns(10);

		jtSoLuong2 = new JTextField();
		jtSoLuong2.setColumns(10);
		jtSoLuong2.setBounds(366, 303, 101, 31);
		jp.add(jtSoLuong2);

		jtSoLuong3 = new JTextField();
		jtSoLuong3.setColumns(10);
		jtSoLuong3.setBounds(366, 367, 101, 31);
		jp.add(jtSoLuong3);

		jtSoLuong4 = new JTextField();
		jtSoLuong4.setColumns(10);
		jtSoLuong4.setBounds(366, 430, 101, 31);
		jp.add(jtSoLuong4);

		jtSoLuong5 = new JTextField();
		jtSoLuong5.setColumns(10);
		jtSoLuong5.setBounds(366, 493, 101, 31);
		jp.add(jtSoLuong5);

		label = new JLabel("Số lượng");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(1175, 203, 64, 14);
		jp.add(label);

		jtSoLuong6 = new JTextField();
		jtSoLuong6.setColumns(10);
		jtSoLuong6.setBounds(1162, 240, 101, 31);
		jp.add(jtSoLuong6);

		jtSoLuong7 = new JTextField();
		jtSoLuong7.setColumns(10);
		jtSoLuong7.setBounds(1162, 303, 101, 31);
		jp.add(jtSoLuong7);

		jtSoLuong8 = new JTextField();
		jtSoLuong8.setColumns(10);
		jtSoLuong8.setBounds(1162, 367, 101, 31);
		jp.add(jtSoLuong8);

		jtSoLuong9 = new JTextField();
		jtSoLuong9.setColumns(10);
		jtSoLuong9.setBounds(1162, 432, 101, 31);
		jp.add(jtSoLuong9);

		jtSoLuong10 = new JTextField();
		jtSoLuong10.setColumns(10);
		jtSoLuong10.setBounds(1162, 493, 101, 31);
		jp.add(jtSoLuong10);

		cbbThuoc1 = new JComboBox();
		cbbThuoc1.setBounds(130, 240, 199, 31);
		jp.add(cbbThuoc1);

		lblLoiBnh = new JLabel("Loại bệnh 1");
		lblLoiBnh.setForeground(Color.BLUE);
		lblLoiBnh.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoiBnh.setBounds(56, 153, 80, 14);
		jp.add(lblLoiBnh);

		cbbLoaiBenh1 = new JComboBox();
		cbbLoaiBenh1.setBounds(152, 140, 199, 31);
		jp.add(cbbLoaiBenh1);

		lblLoiBnh_1 = new JLabel("Loại bệnh 2");
		lblLoiBnh_1.setForeground(Color.BLUE);
		lblLoiBnh_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoiBnh_1.setBounds(501, 153, 80, 14);
		jp.add(lblLoiBnh_1);

		cbbLoaiBenh2 = new JComboBox();
		cbbLoaiBenh2.setBounds(597, 140, 199, 31);
		jp.add(cbbLoaiBenh2);

		lblLoiBnh_2 = new JLabel("Loại bệnh 3");
		lblLoiBnh_2.setForeground(Color.BLUE);
		lblLoiBnh_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLoiBnh_2.setBounds(939, 149, 80, 14);
		jp.add(lblLoiBnh_2);

		cbbLoaiBenh3 = new JComboBox();
		cbbLoaiBenh3.setBounds(1035, 136, 199, 31);
		jp.add(cbbLoaiBenh3);

		lblCchDng = new JLabel("Cách dùng");
		lblCchDng.setForeground(Color.BLUE);
		lblCchDng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblCchDng.setBounds(56, 570, 101, 19);
		jp.add(lblCchDng);

		cbbCachDung = new JComboBox();
		cbbCachDung.setBounds(175, 557, 199, 31);
		jp.add(cbbCachDung);

		lblMBnhNhn = new JLabel("Mã bệnh nhân:");
		lblMBnhNhn.setForeground(Color.BLUE);
		lblMBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMBnhNhn.setBounds(56, 86, 101, 14);
		jp.add(lblMBnhNhn);

		lblMaBenhNhan = new JLabel(MaBenhNhan);
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaBenhNhan.setBounds(159, 80, 64, 24);
		jp.add(lblMaBenhNhan);

		JLabel lblTnBnhNhn = new JLabel("Tên bệnh nhân:");
		lblTnBnhNhn.setForeground(Color.BLUE);
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTnBnhNhn.setBounds(464, 82, 101, 14);
		jp.add(lblTnBnhNhn);

		JLabel lblTenBenhNhan = new JLabel(TenBenhNhan);
		lblTenBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenBenhNhan.setBounds(575, 76, 199, 24);
		jp.add(lblTenBenhNhan);

		lblNgy = new JLabel("Ngày Khám");
		lblNgy.setForeground(Color.BLUE);
		lblNgy.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNgy.setBounds(832, 80, 72, 14);
		jp.add(lblNgy);

		Calendar today = Calendar.getInstance();  
		UtilDateModel model = new UtilDateModel(today.getTime());
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePicker.setBounds(922, 69, 186, 24);
		jp.add(datePicker);

		lblNewLabel_2 = new JLabel("TỔNG TIỀN:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(536, 570, 111, 24);
		jp.add(lblNewLabel_2);

		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTongTien.setBounds(657, 567, 158, 24);
		jp.add(lblTongTien);
		
	}
}
