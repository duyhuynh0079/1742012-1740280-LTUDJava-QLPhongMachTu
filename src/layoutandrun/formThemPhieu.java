package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import DAO.cachdungDAO;
import DAO.ctbenhnhanDAO;
import DAO.ctloaibenhDAO;
import DAO.ctthuocDAO;
import DAO.loaibenhDAO;
import DAO.phieukhamDAO;
import DAO.quydinh1DAO;
import DAO.thuocDAO;
import entity.benhnhan;
import entity.cachdung;
import entity.ctbenhnhan;
import entity.ctloaibenh;
import entity.ctthuoc;
import entity.loaibenh;
import entity.phieukhambenh;
import entity.quydinh1;
import entity.thuoc1;
import show.showBenhNhan;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;

public class formThemPhieu extends JFrame implements ActionListener {
	private JPanel jp;
	private JButton btnThem;
	private JLabel lblThuc;
	private JLabel lblThuc_1;
	private JLabel lblThuc_2;
	private JLabel lblThuc_3;
	private JLabel lblNewLabel_1;
	static private JComboBox cbbThuoc2;
	static private JComboBox cbbThuoc3;
	static private JComboBox cbbThuoc4;
	static private JComboBox cbbThuoc5;
	static private JLabel lblThuc_4;
	static private JComboBox cbbThuoc6;
	static private JComboBox cbbThuoc7;
	private JLabel lblThuc_5;
	private JLabel lblThuc_6;
	static private JComboBox cbbThuoc8;
	static private JComboBox cbbThuoc9;
	private JLabel lblThuc_7;
	private JLabel lblThuc_8;
	static private JComboBox cbbThuoc10;
	private JLabel lblSLng;
	private JTextField jtSoLuong1;
	private JTextField jtSoLuong2;
	private JTextField jtSoLuong3;
	private JTextField jtSoLuong4;
	private JTextField jtSoLuong5;
	private JLabel lblnGi_1;
	private JTextField jtSoLuong6;
	private JTextField jtSoLuong7;
	private JTextField jtSoLuong8;
	private JTextField jtSoLuong9;
	private JTextField jtSoLuong10;
	static private JComboBox cbbThuoc1;
	private JLabel lblLoiBnh;
	static private JComboBox cbbLoaiBenh1;
	private JLabel lblLoiBnh_1;
	static private JComboBox cbbLoaiBenh2;
	private JLabel lblLoiBnh_2;
	static private JComboBox cbbLoaiBenh3;
	private JLabel lblCchDng;
	private JLabel lblMBnhNhn;
	private JLabel lblMaBenhNhan;
	static String mabenhnhan = "";
	static String tenbenhnhan = "";
	private JLabel lblNgy;
	private JLabel lblNewLabel_2;
	private JLabel lblTongTien;
	private JTextField txtdinhvi;
	private SpringLayout springLayout;
	static private JCheckBox cbLoaiBenh1;
	static private JCheckBox cbLoaiBenh2;
	static private JCheckBox cbLoaiBenh3;
	static private JCheckBox cbThuoc1;
	static private JCheckBox cbThuoc2;
	static private JCheckBox cbThuoc3;
	static private JCheckBox cbThuoc4;
	static private JCheckBox cbThuoc6;
	static private JCheckBox cbThuoc7;
	static private JCheckBox cbThuoc8;
	static private JCheckBox cbThuoc9;
	static private JCheckBox cbThuoc10;
	static private JCheckBox cbThuoc5;
	private JLabel lblnGi;
	private JLabel lblDonGia2;
	private JLabel lblDonGia3;
	private JLabel lblDonGia4;
	private JLabel lblDonGia5;
	private JLabel label_8;
	private JLabel lblDonGia1;
	private JLabel label_1;
	private JLabel lblDonGia6;
	private JLabel lblDonGia7;
	private JLabel lblDonGia8;
	private JLabel lblDonGia9;
	private JLabel lblDonGia10;
	static double tongtien = 0;
	static double tongtien1 = 0;
	static double tongtien2 = 0;
	static double tongtien3 = 0;
	static double tongtien4 = 0;
	static double tongtien5 = 0;
	static double tongtien6 = 0;
	static double tongtien7 = 0;
	static double tongtien8 = 0;
	static double tongtien9 = 0;
	static double tongtien10 = 0;
	static String maphieukham = "";
	static ArrayList<phieukhambenh> alpk = phieukhamDAO.phieukham();
	static ArrayList<benhnhan> albn = showBenhNhan.albn;
	static ArrayList<cachdung> alcd = cachdungDAO.layCachDung();
	static private JDatePickerImpl datePicker;

	// bien loai benh va thuoc toan cuc
	int idbenh1 = 0;
	int idbenh2 = 0;
	int idbenh3 = 0;
	int idthuoc1 = 0;
	int idthuoc2 = 0;
	int idthuoc3 = 0;
	int idthuoc4 = 0;
	int idthuoc5 = 0;
	int idthuoc6 = 0;
	int idthuoc7 = 0;
	int idthuoc8 = 0;
	int idthuoc9 = 0;
	int idthuoc10 = 0;
	int soluong1 = 0, soluong2 = 0, soluong3 = 0, soluong4 = 0, soluong5 = 0, soluong6 = 0, soluong7 = 0, soluong8 = 0,
			soluong9 = 0, soluong10 = 0;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		formThemPhieu ftp = new formThemPhieu(mabenhnhan, tenbenhnhan);
	}

	public formThemPhieu(String MaBenhNhan, String TenBenhNhan) {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\sourcetree\\Source\\images\\ABC77.png"));
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		this.mabenhnhan = MaBenhNhan;
		this.tenbenhnhan = TenBenhNhan;
		// neu trong db chua co phieu kham
		if (alpk.size() == 0) {
			maphieukham = "PK1";
		} else {
			// neu da co roi thi tao chuoi mahphieukham moi tu phieukham cu + 1
			maphieukham = alpk.get(alpk.size() - 1).getMaPhieuKhamBenh();
			int sothutu = Integer.parseInt(maphieukham.replace("PK", ""));
			maphieukham = "PK" + (sothutu + 1);
		}

		this.setTitle("Mã Phiếu Khám " + maphieukham);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jp = new JPanel();
		getContentPane().add(jp);
		jp.setLayout(null);

		btnThem = new JButton("Thêm");
		btnThem.setSelectedIcon(null);
		btnThem.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\add2.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(631, 624, 146, 62);
		jp.add(btnThem);

		JLabel lblNewLabel = new JLabel("Thuốc 1");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(56, 257, 64, 14);
		jp.add(lblNewLabel);

		lblThuc = new JLabel("Thuốc 2");
		lblThuc.setForeground(Color.BLUE);
		lblThuc.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc.setBounds(56, 320, 64, 14);
		jp.add(lblThuc);

		lblThuc_1 = new JLabel("Thuốc 3");
		lblThuc_1.setForeground(Color.BLUE);
		lblThuc_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_1.setBounds(56, 384, 64, 14);
		jp.add(lblThuc_1);

		lblThuc_2 = new JLabel("Thuốc 4");
		lblThuc_2.setForeground(Color.BLUE);
		lblThuc_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_2.setBounds(56, 449, 64, 14);
		jp.add(lblThuc_2);

		lblThuc_3 = new JLabel("Thuốc 5");
		lblThuc_3.setForeground(Color.BLUE);
		lblThuc_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_3.setBounds(56, 510, 64, 14);
		jp.add(lblThuc_3);

		lblNewLabel_1 = new JLabel("PHIẾU KHÁM BỆNH");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel_1.setBounds(571, 11, 244, 37);
		jp.add(lblNewLabel_1);

		cbbThuoc2 = new JComboBox();
		cbbThuoc2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc2.setBounds(130, 303, 199, 31);
		jp.add(cbbThuoc2);

		cbbThuoc3 = new JComboBox();
		cbbThuoc3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc3.setBounds(130, 367, 199, 31);
		jp.add(cbbThuoc3);

		cbbThuoc4 = new JComboBox();
		cbbThuoc4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc4.setBounds(130, 430, 199, 31);
		jp.add(cbbThuoc4);

		cbbThuoc5 = new JComboBox();
		cbbThuoc5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc5.setBounds(130, 493, 199, 31);
		jp.add(cbbThuoc5);

		lblThuc_4 = new JLabel("Thuốc 6");
		lblThuc_4.setForeground(Color.BLUE);
		lblThuc_4.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_4.setBounds(751, 257, 64, 14);
		jp.add(lblThuc_4);

		cbbThuoc6 = new JComboBox();
		cbbThuoc6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc6.setBounds(832, 240, 208, 31);
		jp.add(cbbThuoc6);

		cbbThuoc7 = new JComboBox();
		cbbThuoc7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc7.setBounds(832, 303, 208, 31);
		jp.add(cbbThuoc7);

		lblThuc_5 = new JLabel("Thuốc 7");
		lblThuc_5.setForeground(Color.BLUE);
		lblThuc_5.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_5.setBounds(751, 320, 64, 14);
		jp.add(lblThuc_5);

		lblThuc_6 = new JLabel("Thuốc 8");
		lblThuc_6.setForeground(Color.BLUE);
		lblThuc_6.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_6.setBounds(751, 384, 64, 14);
		jp.add(lblThuc_6);

		cbbThuoc8 = new JComboBox();
		cbbThuoc8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc8.setBounds(832, 366, 208, 31);
		jp.add(cbbThuoc8);

		cbbThuoc9 = new JComboBox();
		cbbThuoc9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc9.setBounds(832, 432, 208, 31);
		jp.add(cbbThuoc9);

		lblThuc_7 = new JLabel("Thuốc 9");
		lblThuc_7.setForeground(Color.BLUE);
		lblThuc_7.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_7.setBounds(751, 449, 64, 14);
		jp.add(lblThuc_7);

		lblThuc_8 = new JLabel("Thuốc 10");
		lblThuc_8.setForeground(Color.BLUE);
		lblThuc_8.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblThuc_8.setBounds(751, 510, 71, 14);
		jp.add(lblThuc_8);

		cbbThuoc10 = new JComboBox();
		cbbThuoc10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc10.setBounds(832, 493, 208, 31);
		jp.add(cbbThuoc10);

		lblSLng = new JLabel("Số lượng");
		lblSLng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblSLng.setBounds(363, 199, 64, 23);
		jp.add(lblSLng);

		jtSoLuong1 = new JTextField();
		jtSoLuong1.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong1.setToolTipText("Nhập số lượng thuốc vào");
		jtSoLuong1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong1.setBounds(353, 240, 80, 31);
		jp.add(jtSoLuong1);
		jtSoLuong1.setColumns(10);

		jtSoLuong2 = new JTextField();
		jtSoLuong2.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong2.setToolTipText("Nhập số lượng thuốc vào");
		jtSoLuong2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong2.setColumns(10);
		jtSoLuong2.setBounds(353, 303, 80, 31);
		jp.add(jtSoLuong2);

		jtSoLuong3 = new JTextField();
		jtSoLuong3.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong3.setToolTipText("Nhập số lượng thuốc vào");
		jtSoLuong3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong3.setColumns(10);
		jtSoLuong3.setBounds(353, 367, 80, 31);
		jp.add(jtSoLuong3);

		jtSoLuong4 = new JTextField();
		jtSoLuong4.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong4.setToolTipText("Nhập số lượng thuốc vào");
		jtSoLuong4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong4.setColumns(10);
		jtSoLuong4.setBounds(353, 432, 80, 31);
		jp.add(jtSoLuong4);

		jtSoLuong5 = new JTextField();
		jtSoLuong5.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong5.setToolTipText("Nhập số lượng thuốc vào");
		jtSoLuong5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong5.setColumns(10);
		jtSoLuong5.setBounds(353, 493, 80, 31);
		jp.add(jtSoLuong5);

		lblnGi_1 = new JLabel("Đơn giá");
		lblnGi_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnGi_1.setBounds(1194, 203, 64, 14);
		jp.add(lblnGi_1);

		jtSoLuong6 = new JTextField();
		jtSoLuong6.setToolTipText("Nhập số lượng thuốc vào\r\n");
		jtSoLuong6.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong6.setColumns(10);
		jtSoLuong6.setBounds(1064, 240, 80, 31);
		jp.add(jtSoLuong6);

		jtSoLuong7 = new JTextField();
		jtSoLuong7.setToolTipText("Nhập số lượng thuốc vào\r\n");
		jtSoLuong7.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong7.setColumns(10);
		jtSoLuong7.setBounds(1064, 303, 80, 31);
		jp.add(jtSoLuong7);

		jtSoLuong8 = new JTextField();
		jtSoLuong8.setToolTipText("Nhập số lượng thuốc vào\r\n");
		jtSoLuong8.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong8.setColumns(10);
		jtSoLuong8.setBounds(1064, 367, 80, 31);
		jp.add(jtSoLuong8);

		jtSoLuong9 = new JTextField();
		jtSoLuong9.setToolTipText("Nhập số lượng thuốc vào\r\n");
		jtSoLuong9.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong9.setColumns(10);
		jtSoLuong9.setBounds(1064, 432, 80, 31);
		jp.add(jtSoLuong9);

		jtSoLuong10 = new JTextField();
		jtSoLuong10.setToolTipText("Nhập số lượng thuốc vào\r\n");
		jtSoLuong10.setHorizontalAlignment(SwingConstants.CENTER);
		jtSoLuong10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtSoLuong10.setColumns(10);
		jtSoLuong10.setBounds(1064, 493, 80, 31);
		jp.add(jtSoLuong10);

		cbbThuoc1 = new JComboBox();
		cbbThuoc1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThuoc1.setBounds(130, 240, 199, 31);

		jp.add(cbbThuoc1);

		lblLoiBnh = new JLabel("Loại bệnh 1");
		lblLoiBnh.setForeground(Color.BLUE);
		lblLoiBnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiBnh.setBounds(56, 140, 86, 27);
		jp.add(lblLoiBnh);

		cbbLoaiBenh1 = new JComboBox();
		cbbLoaiBenh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbLoaiBenh1.setBounds(152, 140, 199, 31);
		jp.add(cbbLoaiBenh1);

		lblLoiBnh_1 = new JLabel("Loại bệnh 2");
		lblLoiBnh_1.setForeground(Color.BLUE);
		lblLoiBnh_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiBnh_1.setBounds(475, 140, 80, 27);
		jp.add(lblLoiBnh_1);

		cbbLoaiBenh2 = new JComboBox();
		cbbLoaiBenh2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbLoaiBenh2.setBounds(571, 138, 199, 31);
		jp.add(cbbLoaiBenh2);

		lblLoiBnh_2 = new JLabel("Loại bệnh 3");
		lblLoiBnh_2.setForeground(Color.BLUE);
		lblLoiBnh_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblLoiBnh_2.setBounds(939, 140, 80, 23);
		jp.add(lblLoiBnh_2);

		cbbLoaiBenh3 = new JComboBox();
		cbbLoaiBenh3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbLoaiBenh3.setBounds(1035, 136, 199, 31);
		jp.add(cbbLoaiBenh3);

		lblMBnhNhn = new JLabel("Mã bệnh nhân:");
		lblMBnhNhn.setForeground(Color.BLUE);
		lblMBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMBnhNhn.setBounds(56, 81, 117, 19);
		jp.add(lblMBnhNhn);

		lblMaBenhNhan = new JLabel(MaBenhNhan);
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMaBenhNhan.setBounds(173, 78, 64, 24);
		jp.add(lblMaBenhNhan);

		JLabel lblTnBnhNhn = new JLabel("Tên bệnh nhân:");
		lblTnBnhNhn.setForeground(Color.BLUE);
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnBnhNhn.setBounds(284, 80, 126, 20);
		jp.add(lblTnBnhNhn);

		JLabel lblTenBenhNhan = new JLabel(TenBenhNhan);
		lblTenBenhNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTenBenhNhan.setBounds(408, 78, 199, 24);
		jp.add(lblTenBenhNhan);

		lblNgy = new JLabel("Ngày Khám");
		lblNgy.setForeground(Color.BLUE);
		lblNgy.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgy.setBounds(717, 79, 101, 22);
		jp.add(lblNgy);

		Calendar today = Calendar.getInstance();
		UtilDateModel model = new UtilDateModel(today.getTime());
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePicker.setBounds(832, 80, 186, 24);
		jp.add(datePicker);

		lblNewLabel_2 = new JLabel("TỔNG TIỀN:");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_2.setBounds(475, 570, 101, 24);
		jp.add(lblNewLabel_2);

		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTien.setBounds(584, 571, 126, 23);
		jp.add(lblTongTien);

		cbLoaiBenh1 = new JCheckBox("");
		cbLoaiBenh1.setBounds(371, 144, 80, 23);
		jp.add(cbLoaiBenh1);

		cbLoaiBenh2 = new JCheckBox("");
		cbLoaiBenh2.setBounds(796, 144, 64, 23);
		jp.add(cbLoaiBenh2);

		cbLoaiBenh3 = new JCheckBox("");
		cbLoaiBenh3.setBounds(1254, 140, 56, 23);
		jp.add(cbLoaiBenh3);

		cbThuoc1 = new JCheckBox("");
		cbThuoc1.setBounds(571, 248, 97, 23);
		jp.add(cbThuoc1);

		cbThuoc2 = new JCheckBox("");
		cbThuoc2.setBounds(571, 311, 97, 23);
		jp.add(cbThuoc2);

		cbThuoc3 = new JCheckBox("");
		cbThuoc3.setBounds(571, 375, 97, 23);
		jp.add(cbThuoc3);

		cbThuoc4 = new JCheckBox("");
		cbThuoc4.setBounds(571, 440, 97, 23);
		jp.add(cbThuoc4);

		cbThuoc6 = new JCheckBox("");
		cbThuoc6.setBounds(1291, 248, 56, 23);
		jp.add(cbThuoc6);

		cbThuoc7 = new JCheckBox("");
		cbThuoc7.setBounds(1291, 311, 46, 23);
		jp.add(cbThuoc7);

		cbThuoc8 = new JCheckBox("");
		cbThuoc8.setBounds(1291, 375, 46, 23);
		jp.add(cbThuoc8);

		cbThuoc9 = new JCheckBox("");
		cbThuoc9.setBounds(1291, 440, 46, 23);
		jp.add(cbThuoc9);

		cbThuoc10 = new JCheckBox("");
		cbThuoc10.setBounds(1291, 501, 46, 23);
		jp.add(cbThuoc10);

		cbThuoc5 = new JCheckBox("");
		cbThuoc5.setBounds(571, 501, 97, 23);
		jp.add(cbThuoc5);

		lblnGi = new JLabel("Đơn giá");
		lblnGi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblnGi.setBounds(475, 200, 64, 21);
		jp.add(lblnGi);

		lblDonGia2 = new JLabel("");
		lblDonGia2.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia2.setBounds(456, 303, 101, 32);
		jp.add(lblDonGia2);

		lblDonGia3 = new JLabel("");
		lblDonGia3.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia3.setBounds(456, 367, 101, 32);
		jp.add(lblDonGia3);

		lblDonGia4 = new JLabel("");
		lblDonGia4.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia4.setBounds(456, 431, 101, 32);
		jp.add(lblDonGia4);

		lblDonGia5 = new JLabel("");
		lblDonGia5.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia5.setBounds(456, 492, 101, 32);
		jp.add(lblDonGia5);

		label_8 = new JLabel("");
		label_8.setBounds(484, 492, 97, 32);
		jp.add(label_8);

		lblDonGia1 = new JLabel("");
		lblDonGia1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia1.setBounds(456, 240, 101, 32);
		jp.add(lblDonGia1);

		label_1 = new JLabel("Số lượng");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(1074, 200, 64, 20);
		jp.add(label_1);

		lblDonGia6 = new JLabel("");
		lblDonGia6.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia6.setBounds(1170, 240, 101, 32);
		jp.add(lblDonGia6);

		lblDonGia7 = new JLabel("");
		lblDonGia7.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia7.setBounds(1170, 303, 103, 32);
		jp.add(lblDonGia7);

		lblDonGia8 = new JLabel("");
		lblDonGia8.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia8.setBounds(1170, 367, 103, 32);
		jp.add(lblDonGia8);

		lblDonGia9 = new JLabel("");
		lblDonGia9.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia9.setBounds(1170, 431, 103, 32);
		jp.add(lblDonGia9);

		lblDonGia10 = new JLabel("");
		lblDonGia10.setHorizontalAlignment(SwingConstants.CENTER);
		lblDonGia10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDonGia10.setBounds(1170, 492, 103, 32);
		jp.add(lblDonGia10);

		truyenDuLieuCombobox();
		ArrayList<thuoc1> alThuoc = thuocDAO.layThuoc();

		// hien thi don gia lan dau
		for (int i = 0; i < alThuoc.size(); i++) {
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())) {
				lblDonGia1.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())) {
				lblDonGia2.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())) {
				lblDonGia3.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())) {
				lblDonGia4.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())) {
				lblDonGia5.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())) {
				lblDonGia6.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())) {
				lblDonGia7.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())) {
				lblDonGia8.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())) {
				lblDonGia9.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())) {
				lblDonGia10.setText(Double.toString(alThuoc.get(i).getDonGia()));
			}
		}

		// load lan dau chua click cac thuoc tong tien = 0
		lblTongTien.setText(Double.toString(tongtien));

		// load lan dau cac o so luong
		jtSoLuong1.setText("1");
		jtSoLuong2.setText("1");
		jtSoLuong3.setText("1");
		jtSoLuong4.setText("1");
		jtSoLuong5.setText("1");
		jtSoLuong6.setText("1");
		jtSoLuong7.setText("1");
		jtSoLuong8.setText("1");
		jtSoLuong9.setText("1");
		jtSoLuong10.setText("1");

		cbbThuoc1.addActionListener(this);
		cbbThuoc2.addActionListener(this);
		cbbThuoc3.addActionListener(this);
		cbbThuoc4.addActionListener(this);
		cbbThuoc5.addActionListener(this);
		cbbThuoc6.addActionListener(this);
		cbbThuoc7.addActionListener(this);
		cbbThuoc8.addActionListener(this);
		cbbThuoc9.addActionListener(this);
		cbbThuoc10.addActionListener(this);

		cbThuoc1.addActionListener(this);
		cbThuoc2.addActionListener(this);
		cbThuoc3.addActionListener(this);
		cbThuoc4.addActionListener(this);
		cbThuoc5.addActionListener(this);
		cbThuoc6.addActionListener(this);
		cbThuoc7.addActionListener(this);
		cbThuoc8.addActionListener(this);
		cbThuoc9.addActionListener(this);
		cbThuoc10.addActionListener(this);
		cbThuoc1.setActionCommand("tick1");
		cbThuoc2.setActionCommand("tick2");
		cbThuoc3.setActionCommand("tick3");
		cbThuoc4.setActionCommand("tick4");
		cbThuoc5.setActionCommand("tick5");
		cbThuoc6.setActionCommand("tick6");
		cbThuoc7.setActionCommand("tick7");
		cbThuoc8.setActionCommand("tick8");
		cbThuoc9.setActionCommand("tick9");
		cbThuoc10.setActionCommand("tick10");

		cbLoaiBenh1.addActionListener(this);
		cbLoaiBenh2.addActionListener(this);
		cbLoaiBenh3.addActionListener(this);
		cbLoaiBenh1.setActionCommand("loaibenh1");
		cbLoaiBenh2.setActionCommand("loaibenh2");
		cbLoaiBenh3.setActionCommand("loaibenh3");

		// goi nut bat su kien
		btnThem.addActionListener(this);
		btnThem.setActionCommand("them");

		// cac su kien thay doi cac textfield
		jtSoLuong1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong1;
				if (!cbThuoc1.isSelected()) {
					tongtien1 = 0;
				} else {
					soluong1 = Integer.parseInt(jtSoLuong1.getText());
					tongtien1 = soluong1 * Double.parseDouble(lblDonGia1.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong1;
				if (!cbThuoc1.isSelected()) {
					tongtien1 = 0;
				} else {
					if (jtSoLuong1.getText().equals("")) {
						tongtien1 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong1 = Integer.parseInt(jtSoLuong1.getText());
						tongtien1 = soluong1 * Double.parseDouble(lblDonGia1.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong2.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong2;
				if (!cbThuoc2.isSelected()) {
					tongtien2 = 0;
				} else {
					soluong2 = Integer.parseInt(jtSoLuong2.getText());
					tongtien2 = soluong2 * Double.parseDouble(lblDonGia2.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong2;
				if (!cbThuoc2.isSelected()) {
					tongtien2 = 0;
				} else {
					if (jtSoLuong2.getText().equals("")) {
						tongtien2 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong2 = Integer.parseInt(jtSoLuong2.getText());
						tongtien2 = soluong2 * Double.parseDouble(lblDonGia2.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong3.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong3;
				if (!cbThuoc3.isSelected()) {
					tongtien3 = 0;
				} else {
					soluong3 = Integer.parseInt(jtSoLuong3.getText());
					tongtien3 = soluong3 * Double.parseDouble(lblDonGia3.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong3;
				if (!cbThuoc3.isSelected()) {
					tongtien3 = 0;
				} else {
					if (jtSoLuong3.getText().equals("")) {
						tongtien3 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong3 = Integer.parseInt(jtSoLuong3.getText());
						tongtien3 = soluong3 * Double.parseDouble(lblDonGia3.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong4.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong4;
				if (!cbThuoc4.isSelected()) {
					tongtien4 = 0;
				} else {
					soluong4 = Integer.parseInt(jtSoLuong4.getText());
					tongtien4 = soluong4 * Double.parseDouble(lblDonGia4.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong4;
				if (!cbThuoc4.isSelected()) {
					tongtien4 = 0;
				} else {
					if (jtSoLuong4.getText().equals("")) {
						tongtien4 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong4 = Integer.parseInt(jtSoLuong4.getText());
						tongtien4 = soluong4 * Double.parseDouble(lblDonGia4.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong5.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong5;
				if (!cbThuoc5.isSelected()) {
					tongtien5 = 0;
				} else {
					soluong5 = Integer.parseInt(jtSoLuong5.getText());
					tongtien5 = soluong5 * Double.parseDouble(lblDonGia5.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong5;
				if (!cbThuoc5.isSelected()) {
					tongtien5 = 0;
				} else {
					if (jtSoLuong5.getText().equals("")) {
						tongtien5 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong5 = Integer.parseInt(jtSoLuong5.getText());
						tongtien5 = soluong5 * Double.parseDouble(lblDonGia5.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong6.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong6;
				if (!cbThuoc6.isSelected()) {
					tongtien6 = 0;
				} else {
					soluong6 = Integer.parseInt(jtSoLuong6.getText());
					tongtien6 = soluong6 * Double.parseDouble(lblDonGia6.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong6;
				if (!cbThuoc6.isSelected()) {
					tongtien6 = 0;
				} else {
					if (jtSoLuong6.getText().equals("")) {
						tongtien6 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong6 = Integer.parseInt(jtSoLuong6.getText());
						tongtien6 = soluong6 * Double.parseDouble(lblDonGia6.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong7.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong7;
				if (!cbThuoc7.isSelected()) {
					tongtien7 = 0;
				} else {
					soluong7 = Integer.parseInt(jtSoLuong7.getText());
					tongtien7 = soluong7 * Double.parseDouble(lblDonGia7.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong7;
				if (!cbThuoc7.isSelected()) {
					tongtien7 = 0;
				} else {
					if (jtSoLuong7.getText().equals("")) {
						tongtien7 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong7 = Integer.parseInt(jtSoLuong7.getText());
						tongtien7 = soluong7 * Double.parseDouble(lblDonGia7.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong8.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong8;
				if (!cbThuoc8.isSelected()) {
					tongtien8 = 0;
				} else {
					soluong8 = Integer.parseInt(jtSoLuong8.getText());
					tongtien8 = soluong8 * Double.parseDouble(lblDonGia8.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong8;
				if (!cbThuoc8.isSelected()) {
					tongtien8 = 0;
				} else {
					if (jtSoLuong8.getText().equals("")) {
						tongtien8 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong8 = Integer.parseInt(jtSoLuong8.getText());
						tongtien8 = soluong8 * Double.parseDouble(lblDonGia8.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong9.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong9;
				if (!cbThuoc9.isSelected()) {
					tongtien9 = 0;
				} else {
					soluong9 = Integer.parseInt(jtSoLuong9.getText());
					tongtien9 = soluong9 * Double.parseDouble(lblDonGia9.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong9;
				if (!cbThuoc9.isSelected()) {
					tongtien9 = 0;
				} else {
					if (jtSoLuong9.getText().equals("")) {
						tongtien9 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong9 = Integer.parseInt(jtSoLuong9.getText());
						tongtien9 = soluong9 * Double.parseDouble(lblDonGia9.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
		jtSoLuong10.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong10;
				if (!cbThuoc10.isSelected()) {
					tongtien10 = 0;
				} else {
					soluong10 = Integer.parseInt(jtSoLuong10.getText());
					tongtien1 = soluong10 * Double.parseDouble(lblDonGia10.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				int soluong10;
				if (!cbThuoc10.isSelected()) {
					tongtien10 = 0;
				} else {
					if (jtSoLuong10.getText().equals("")) {
						tongtien10 = 0;
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					} else {
						soluong10 = Integer.parseInt(jtSoLuong10.getText());
						tongtien10 = soluong10 * Double.parseDouble(lblDonGia10.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Double.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});
	}

	static void truyenDuLieuCombobox() {
		cbbThuoc1.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc2.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc3.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc4.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc5.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc6.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc7.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc8.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc9.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbThuoc10.setModel(new showCombobox(thuocDAO.layDanhSachTenThuoc()));
		cbbLoaiBenh1.setModel(new showCombobox(loaibenhDAO.layDanhSachTenLoaiBenh()));
		cbbLoaiBenh2.setModel(new showCombobox(loaibenhDAO.layDanhSachTenLoaiBenh()));
		cbbLoaiBenh3.setModel(new showCombobox(loaibenhDAO.layDanhSachTenLoaiBenh()));
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		ArrayList<thuoc1> alThuoc = thuocDAO.layThuoc();
		ArrayList<loaibenh> alLoaiBenh = loaibenhDAO.layLoaiBenh();
		String command = ae.getActionCommand();
		// su kien thay doi cbb thi dongia doi theo
		// neu co check box thi thay doi gia tien theo luon
		for (int i = 0; i < alThuoc.size(); i++) {
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())
					&& (!cbThuoc1.isSelected())) {
				lblDonGia1.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien1 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())
					&& (cbThuoc1.isSelected())) {
				lblDonGia1.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong1 = Integer.parseInt(jtSoLuong1.getText());
				tongtien1 = soluong1 * Double.parseDouble(lblDonGia1.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())
					&& (!cbThuoc2.isSelected())) {
				lblDonGia2.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien2 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())
					&& (cbThuoc2.isSelected())) {
				lblDonGia2.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong2 = Integer.parseInt(jtSoLuong2.getText());
				tongtien2 = soluong2 * Double.parseDouble(lblDonGia2.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())
					&& (!cbThuoc3.isSelected())) {
				lblDonGia3.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien3 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())
					&& (cbThuoc3.isSelected())) {
				lblDonGia3.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong3 = Integer.parseInt(jtSoLuong3.getText());
				tongtien3 = soluong3 * Double.parseDouble(lblDonGia3.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())
					&& (!cbThuoc4.isSelected())) {
				lblDonGia4.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien4 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())
					&& (cbThuoc4.isSelected())) {
				lblDonGia4.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong4 = Integer.parseInt(jtSoLuong4.getText());
				tongtien4 = soluong4 * Double.parseDouble(lblDonGia4.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())
					&& (!cbThuoc5.isSelected())) {
				lblDonGia5.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien5 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())
					&& (cbThuoc5.isSelected())) {
				lblDonGia5.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong5 = Integer.parseInt(jtSoLuong5.getText());
				tongtien5 = soluong5 * Double.parseDouble(lblDonGia5.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())
					&& (!cbThuoc6.isSelected())) {
				lblDonGia6.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien6 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}

			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())
					&& (cbThuoc6.isSelected())) {
				lblDonGia6.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong6 = Integer.parseInt(jtSoLuong6.getText());
				tongtien6 = soluong6 * Double.parseDouble(lblDonGia6.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())
					&& (!cbThuoc7.isSelected())) {
				lblDonGia7.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien7 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())
					&& (cbThuoc7.isSelected())) {
				lblDonGia7.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong7 = Integer.parseInt(jtSoLuong7.getText());
				tongtien7 = soluong7 * Double.parseDouble(lblDonGia7.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())
					&& (!cbThuoc8.isSelected())) {
				lblDonGia8.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien8 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())
					&& (cbThuoc8.isSelected())) {
				lblDonGia8.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong8 = Integer.parseInt(jtSoLuong8.getText());
				tongtien8 = soluong8 * Double.parseDouble(lblDonGia2.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())
					&& (!cbThuoc9.isSelected())) {
				lblDonGia9.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien9 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())
					&& (cbThuoc9.isSelected())) {
				lblDonGia9.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong9 = Integer.parseInt(jtSoLuong9.getText());
				tongtien9 = soluong9 * Double.parseDouble(lblDonGia9.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())
					&& (!cbThuoc10.isSelected())) {
				lblDonGia10.setText(Double.toString(alThuoc.get(i).getDonGia()));
				tongtien10 = 0;
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())
					&& (cbThuoc10.isSelected())) {
				lblDonGia10.setText(Double.toString(alThuoc.get(i).getDonGia()));
				soluong10 = Integer.parseInt(jtSoLuong10.getText());
				tongtien10 = soluong10 * Double.parseDouble(lblDonGia10.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Double.toString(tongtien));
			}
		}

		// su kien khi click checkbox thuoc
		switch (command) {
		case "tick1":
			if (cbThuoc1.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())) {
						idthuoc1 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong1.getText().equals("")) {
					soluong1 = 0;
				} else {// neu co so luong thi * len ra tongtien1
					soluong1 = Integer.parseInt(jtSoLuong1.getText());
					tongtien1 = soluong1 * Double.parseDouble(lblDonGia1.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				// bo click thi idthuoc1 la 0
				idthuoc1 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien1));// tong tien - lai tong tien 1
			}
			break;
		case "tick2":
			if (cbThuoc2.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())) {
						idthuoc2 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong2.getText().equals("")) {
					soluong2 = 0;
				} else {
					soluong2 = Integer.parseInt(jtSoLuong2.getText());
					tongtien2 = soluong2 * Double.parseDouble(lblDonGia2.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc2 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien2));
			}
			break;
		case "tick3":
			if (cbThuoc3.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())) {
						idthuoc3 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong3.getText().equals("")) {
					soluong3 = 0;
				} else {
					soluong3 = Integer.parseInt(jtSoLuong3.getText());
					tongtien3 = soluong3 * Double.parseDouble(lblDonGia3.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc3 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien3));
			}
			break;
		case "tick4":
			if (cbThuoc4.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())) {
						idthuoc4 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong4.getText().equals("")) {
					soluong4 = 0;
				} else {
					soluong4 = Integer.parseInt(jtSoLuong1.getText());
					tongtien4 = soluong4 * Double.parseDouble(lblDonGia4.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien4));
			}
			break;
		case "tick5":
			if (cbThuoc5.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())) {
						idthuoc5 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong5.getText().equals("")) {
					soluong5 = 0;
				} else {
					soluong5 = Integer.parseInt(jtSoLuong5.getText());
					tongtien5 = soluong5 * Double.parseDouble(lblDonGia5.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc5 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien5));
			}
			break;
		case "tick6":
			if (cbThuoc6.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())) {
						idthuoc6 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong6.getText().equals("")) {
					soluong6 = 0;
				} else {
					soluong6 = Integer.parseInt(jtSoLuong6.getText());
					tongtien6 = soluong6 * Double.parseDouble(lblDonGia6.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc6 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien6));
			}
			break;
		case "tick7":
			if (cbThuoc7.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())) {
						idthuoc7 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong7.getText().equals("")) {
					soluong7 = 0;
				} else {
					soluong7 = Integer.parseInt(jtSoLuong7.getText());
					tongtien7 = soluong7 * Double.parseDouble(lblDonGia7.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc7 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien7));
			}
			break;
		case "tick8":
			if (cbThuoc8.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())) {
						idthuoc8 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong8.getText().equals("")) {
					soluong8 = 0;
				} else {
					soluong8 = Integer.parseInt(jtSoLuong8.getText());
					tongtien8 = soluong8 * Double.parseDouble(lblDonGia8.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc8 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien8));
			}
			break;
		case "tick9":
			if (cbThuoc9.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())) {
						idthuoc9 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong9.getText().equals("")) {
					soluong9 = 0;
				} else {
					soluong9 = Integer.parseInt(jtSoLuong9.getText());
					tongtien9 = soluong9 * Double.parseDouble(lblDonGia9.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc9 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien9));
			}
			break;
		case "tick10":
			if (cbThuoc10.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())) {
						idthuoc10 = alThuoc.get(i).getID();
					}
				}
				if (jtSoLuong10.getText().equals("")) {
					soluong10 = 0;
				} else {
					soluong10 = Integer.parseInt(jtSoLuong10.getText());
					tongtien10 = soluong10 * Double.parseDouble(lblDonGia10.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Double.toString(tongtien));
				}
			} else {
				idthuoc10 = 0;
				tongtien = Double.parseDouble(lblTongTien.getText());
				lblTongTien.setText(Double.toString(tongtien - tongtien10));
			}
			break;
		}
		// su kien khi click checkbox loaibenh, lay id cua checkbox

		if (command.equals("loaibenh1")) {
			// neu click vao nhan id trong db, bo click nhan 0
			if (cbLoaiBenh1.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh1.getSelectedItem().toString())) {
						idbenh1 = alLoaiBenh.get(i).getID();
					}
				}
			}
		}
		if (command.equals("loaibenh2")) {
			if (cbLoaiBenh2.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh2.getSelectedItem().toString())) {
						idbenh2 = alLoaiBenh.get(i).getID();
					}
				}
			}
		}
		if (command.equals("loaibenh3")) {
			if (cbLoaiBenh3.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh3.getSelectedItem().toString())) {
						idbenh3 = alLoaiBenh.get(i).getID();
					}
				}
			}
		}

		if (command.equals("them")) {
			ArrayList<phieukhambenh> ALPK = phieukhamDAO.phieukhamTrongNgay();// danh sach phieukham trong ngay hom nay
			System.out.println("so phieu kham trong ngay:" + ALPK.size());
			ArrayList<quydinh1> qd1 = quydinh1DAO.quydinh1();
			int sophieutoida = 0;
			// lay so phieukham toi da 1 ngay theo quy dinh
			for (int i = 0; i < qd1.size(); i++) {
				sophieutoida = qd1.get(i).getGiaTri();
			}
			int idbenhnhan = 0;
			int idcachdung = 0;
			Date ngaykham = new Date();
			// lay id benh nhan va id cach dung, id loaibenh va id thuoc o tren
			for (int i = 0; i < albn.size(); i++) {
				if (albn.get(i).getMaBenhNhan().equals(mabenhnhan)) {
					idbenhnhan = albn.get(i).getID();
				}
			}
			String ngay = datePicker.getJFormattedTextField().getText();
			try {
				ngaykham = new SimpleDateFormat("dd-MM-yyyy").parse(ngay);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// xet ko chon loai benh
			if ((!cbLoaiBenh1.isSelected() && !cbLoaiBenh2.isSelected() && !cbLoaiBenh3.isSelected())) {
				JOptionPane.showMessageDialog(null, "Thêm thất bại, Chọn ít nhất 1 loại bệnh!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// xet so phieu kham hom nay va qui dinh1
			if (ALPK.size() == sophieutoida) {
				JOptionPane.showMessageDialog(null, "Thêm thất bại, hôm nay đã đủ số người: " + sophieutoida, "WARNING",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// xet so luong thuoc phai kieu so ko
			if ((cbThuoc1.isSelected() && validate.isNumber(jtSoLuong1.getText()) == false)
					|| (cbThuoc2.isSelected() && validate.isNumber(jtSoLuong2.getText()) == false)
					|| (cbThuoc3.isSelected() && validate.isNumber(jtSoLuong3.getText()) == false)
					|| (cbThuoc4.isSelected() && validate.isNumber(jtSoLuong4.getText()) == false)
					|| (cbThuoc5.isSelected() && validate.isNumber(jtSoLuong5.getText()) == false)
					|| (cbThuoc6.isSelected() && validate.isNumber(jtSoLuong6.getText()) == false)
					|| (cbThuoc7.isSelected() && validate.isNumber(jtSoLuong7.getText()) == false)
					|| (cbThuoc8.isSelected() && validate.isNumber(jtSoLuong8.getText()) == false)
					|| (cbThuoc9.isSelected() && validate.isNumber(jtSoLuong9.getText()) == false)
					|| (cbThuoc10.isSelected() && validate.isNumber(jtSoLuong10.getText()) == false)) {
				JOptionPane.showMessageDialog(null, "Nhập số cho số lượng thuốc đã chọn!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
			// xet soluong thuoc phieu kham va soluong thuoc trong kho
			for (int t = 0; t < alThuoc.size(); t++) {
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())
						&& cbThuoc1.isSelected()) {
					System.out.println("ID--" + alThuoc.get(t).getID() + "--Ten--" + alThuoc.get(t).getTenThuoc()
							+ "---Sl---" + alThuoc.get(t).getSoLuong());
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong1.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())
						&& cbThuoc2.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong2.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())
						&& cbThuoc3.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong3.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())
						&& cbThuoc4.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong4.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())
						&& cbThuoc5.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong5.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())
						&& cbThuoc6.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong6.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())
						&& cbThuoc7.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong7.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())
						&& cbThuoc8.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong8.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())
						&& cbThuoc9.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong9.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
				if (alThuoc.get(t).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())
						&& cbThuoc10.isSelected()) {
					if (alThuoc.get(t).getSoLuong() < Integer.parseInt(jtSoLuong10.getText())) {
						JOptionPane.showMessageDialog(null, "Vượt quá thuốc" + alThuoc.get(t).getTenThuoc()
								+ " trong kho: " + alThuoc.get(t).getSoLuong(), "WARNING", JOptionPane.WARNING_MESSAGE);
						return;
					}
				}
			}
			// xét số bệnh nhân khám hôm nay vượt quy định 1 chưa
			// them bang phieu kham benh truoc
			phieukhambenh pkb = new phieukhambenh();
			pkb.setMaPhieuKhamBenh(maphieukham);
			pkb.setNgayKham(ngaykham);
			pkb.setTinhTrang(0);
			pkb.setTongTienThuoc(Double.parseDouble(lblTongTien.getText()));
			int idpk = phieukhamDAO.themPhieuKham(pkb);
			// them cac bang trung gian
			// them bang ctbenhnhan
			ctbenhnhan ctbn = new ctbenhnhan();
			ctbn.setID_BenhNhan(idbenhnhan);
			ctbn.setID_PhieuKhamBenh(idpk);
			ctbenhnhanDAO.themCTBenhNhan(ctbn);
			// them bang ctloaibenh
			ctloaibenh ctlb = new ctloaibenh();
			if (idbenh1 != 0) {
				ctlb.setID_LoaiBenh(idbenh1);
				ctlb.setID_PhieuKhamBenh(idpk);
				ctloaibenhDAO.themCTLoaiBenh(ctlb);
			}
			if (idbenh2 != 0) {
				ctlb.setID_LoaiBenh(idbenh2);
				ctlb.setID_PhieuKhamBenh(idpk);
				ctloaibenhDAO.themCTLoaiBenh(ctlb);
			}
			if (idbenh3 != 0) {
				ctlb.setID_LoaiBenh(idbenh3);
				ctlb.setID_PhieuKhamBenh(idpk);
				ctloaibenhDAO.themCTLoaiBenh(ctlb);
			}
			ctthuoc ctthuoc = new ctthuoc();
			if (idthuoc1 != 0) {
				ctthuoc.setID_Thuoc(idthuoc1);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong1);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc2 != 0) {
				ctthuoc.setID_Thuoc(idthuoc2);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong2);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc3 != 0) {
				ctthuoc.setID_Thuoc(idthuoc3);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong3);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc4 != 0) {
				ctthuoc.setID_Thuoc(idthuoc4);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong4);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc5 != 0) {
				ctthuoc.setID_Thuoc(idthuoc5);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong5);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc6 != 0) {
				ctthuoc.setID_Thuoc(idthuoc6);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong6);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc7 != 0) {
				ctthuoc.setID_Thuoc(idthuoc7);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong7);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc8 != 0) {
				ctthuoc.setID_Thuoc(idthuoc8);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong8);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc9 != 0) {
				ctthuoc.setID_Thuoc(idthuoc9);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong9);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			if (idthuoc10 != 0) {
				ctthuoc.setID_Thuoc(idthuoc10);
				ctthuoc.setID_PhieuKhamBenh(idpk);
				ctthuoc.setSoLuong(soluong10);
				ctthuocDAO.themCTThuoc(ctthuoc);
			}
			// cap nhat so luong thuoc trong kho NEU phieu kham co thuoc
			for (int i = 0; i < alThuoc.size(); i++) {
				thuoc1 th = new thuoc1();
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())
						&& cbThuoc1.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong1.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())
						&& cbThuoc2.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong2.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())
						&& cbThuoc3.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong3.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())
						&& cbThuoc4.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong4.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())
						&& cbThuoc5.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong5.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())
						&& cbThuoc6.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong6.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())
						&& cbThuoc7.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong7.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())
						&& cbThuoc8.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong8.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())
						&& cbThuoc9.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong9.getText()));
					thuocDAO.suaThuoc1(th);
				}
				if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())
						&& cbThuoc10.isSelected()) {
					th.setID(alThuoc.get(i).getID());
					th.setMaThuoc(alThuoc.get(i).getMaThuoc());
					th.setTenThuoc(alThuoc.get(i).getTenThuoc());
					th.setDonGia(alThuoc.get(i).getDonGia());
					th.setTinhTrang(alThuoc.get(i).getTinhTrang());
					th.setID_DonVi(alThuoc.get(i).getID_DonVi());
					th.setID_CachDung(alThuoc.get(i).getID_CachDung());
					th.setSoLuong(alThuoc.get(i).getSoLuong() - Integer.parseInt(jtSoLuong10.getText()));
					thuocDAO.suaThuoc1(th);
				}
			}
			JOptionPane.showMessageDialog(null, "Thêm phiếu khám thành công!", "WARNING", JOptionPane.WARNING_MESSAGE);
			ArrayList<phieukhambenh> alpk = phieukhamDAO.phieukham();// set lại array list de maphieu tang
			clientthread ct = new clientthread();
			this.dispose();
		}
	}
}
