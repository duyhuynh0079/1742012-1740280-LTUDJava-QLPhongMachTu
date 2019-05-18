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
import DAO.thuocDAO;
import entity.benhnhan;
import entity.cachdung;
import entity.ctbenhnhan;
import entity.ctloaibenh;
import entity.ctthuoc;
import entity.loaibenh;
import entity.phieukhambenh;
import entity.thuoc1;
import show.showBenhNhan;

import javax.swing.JButton;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.SpringLayout;
import javax.swing.JCheckBox;

public class formSuaPhieu extends JFrame implements ActionListener {
	private JPanel jp;
	private JButton btnSua;
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
	static String ngaykham = "";
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
	static float tongtien = 0;
	static float tongtien1 = 0;
	static float tongtien2 = 0;
	static float tongtien3 = 0;
	static float tongtien4 = 0;
	static float tongtien5 = 0;
	static float tongtien6 = 0;
	static float tongtien7 = 0;
	static float tongtien8 = 0;
	static float tongtien9 = 0;
	static float tongtien10 = 0;
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
		formSuaPhieu ftp = new formSuaPhieu(maphieukham, mabenhnhan, tenbenhnhan, ngaykham);
	}

	public formSuaPhieu(String MaPhieuKham, String MaBenhNhan, String TenBenhNhan, String NgayKham) {
		setSize(1000, 600);
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		this.maphieukham = MaPhieuKham;
		this.mabenhnhan = MaBenhNhan;
		this.tenbenhnhan = TenBenhNhan;
		this.ngaykham = NgayKham;
		this.setTitle("Mã Phiếu Khám " + maphieukham);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		jp = new JPanel();
		getContentPane().add(jp);
		jp.setLayout(null);

		btnSua = new JButton("Sửa");
		btnSua.setSelectedIcon(null);
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\edit1.png"));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(631, 624, 146, 62);
		jp.add(btnSua);

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

		// truyen vet ngaykham
		Date ngay = new Date();
		try {
			ngay = new SimpleDateFormat("dd-MM-yyyy").parse(ngaykham);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		UtilDateModel model = new UtilDateModel(ngay);
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

		truyenDuLieuCombobox();
		ArrayList<thuoc1> alThuoc = thuocDAO.layThuoc();

		// truyen lay vet tong tien
		// lblTongTien.setText(phieukhamDAO.laytongtientuMaPhieuKham(maphieukham));

		// truyen lay vet benh
		int j = 1;// bien co de xet co bao nhieu loai benh
		List<Object[]> oLoaiBenh = loaibenhDAO.layTenBenhTheoMaPhieuKhamBenh(maphieukham);
		for (Object[] countResult : oLoaiBenh) {
			if (j == 1) {
				String tenloaibenh1 = countResult[2].toString();
				cbbLoaiBenh1.setSelectedItem(tenloaibenh1);
				cbLoaiBenh1.setSelected(true);
			} else if (j == 2) {
				String tenloaibenh2 = countResult[2].toString();
				cbbLoaiBenh2.setSelectedItem(tenloaibenh2);
				cbLoaiBenh2.setSelected(true);
			} else {
				String tenloaibenh3 = countResult[2].toString();
				cbbLoaiBenh3.setSelectedItem(tenloaibenh3);
				cbLoaiBenh3.setSelected(true);
			}
			j++;
		}

		// truyen lay vet thuoc
		int k = 1;// bien co de xet co bao nhieu loai benh
		List<Object[]> oThuoc = thuocDAO.laydanhsachThuocTheoMaPhieuKhamBenh(maphieukham);
		for (Object[] countResult : oThuoc) {
			if (k == 1) {
				String tenthuoc1 = countResult[0].toString();
				cbbThuoc1.setSelectedItem(tenthuoc1);
				jtSoLuong1.setText(countResult[1].toString());
				lblDonGia1.setText(countResult[2].toString());
				cbThuoc1.setSelected(true);
				soluong1 = Integer.parseInt(jtSoLuong1.getText());
				tongtien1 = soluong1 * Float.parseFloat(lblDonGia1.getText());
				tongtien = tongtien1;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 2) {
				String tenthuoc2 = countResult[0].toString();
				cbbThuoc2.setSelectedItem(tenthuoc2);
				jtSoLuong2.setText(countResult[1].toString());
				lblDonGia2.setText(countResult[2].toString());
				cbThuoc2.setSelected(true);
				soluong2 = Integer.parseInt(jtSoLuong2.getText());
				tongtien2 = soluong2 * Float.parseFloat(lblDonGia2.getText());
				tongtien = tongtien1 + tongtien2;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 3) {
				String tenthuoc3 = countResult[0].toString();
				cbbThuoc3.setSelectedItem(tenthuoc3);
				jtSoLuong3.setText(countResult[1].toString());
				lblDonGia3.setText(countResult[2].toString());
				cbThuoc3.setSelected(true);
				soluong3 = Integer.parseInt(jtSoLuong3.getText());
				tongtien3 = soluong3 * Float.parseFloat(lblDonGia3.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 4) {
				String tenthuoc4 = countResult[0].toString();
				cbbThuoc4.setSelectedItem(tenthuoc4);
				jtSoLuong4.setText(countResult[1].toString());
				lblDonGia4.setText(countResult[2].toString());
				cbThuoc4.setSelected(true);
				soluong4 = Integer.parseInt(jtSoLuong4.getText());
				tongtien4 = soluong4 * Float.parseFloat(lblDonGia4.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 5) {
				String tenthuoc5 = countResult[0].toString();
				cbbThuoc5.setSelectedItem(tenthuoc5);
				jtSoLuong5.setText(countResult[1].toString());
				lblDonGia5.setText(countResult[2].toString());
				cbThuoc5.setSelected(true);
				soluong5 = Integer.parseInt(jtSoLuong5.getText());
				tongtien5 = soluong5 * Float.parseFloat(lblDonGia5.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 6) {
				String tenthuoc6 = countResult[0].toString();
				cbbThuoc6.setSelectedItem(tenthuoc6);
				jtSoLuong6.setText(countResult[1].toString());
				lblDonGia6.setText(countResult[2].toString());
				cbThuoc6.setSelected(true);
				soluong6 = Integer.parseInt(jtSoLuong6.getText());
				tongtien6 = soluong6 * Float.parseFloat(lblDonGia6.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 7) {
				String tenthuoc7 = countResult[0].toString();
				cbbThuoc7.setSelectedItem(tenthuoc7);
				jtSoLuong7.setText(countResult[1].toString());
				lblDonGia7.setText(countResult[2].toString());
				cbThuoc7.setSelected(true);
				soluong7 = Integer.parseInt(jtSoLuong7.getText());
				tongtien7 = soluong7 * Float.parseFloat(lblDonGia7.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 8) {
				String tenthuoc8 = countResult[0].toString();
				cbbThuoc8.setSelectedItem(tenthuoc8);
				jtSoLuong8.setText(countResult[1].toString());
				lblDonGia8.setText(countResult[2].toString());
				cbThuoc8.setSelected(true);
				soluong8 = Integer.parseInt(jtSoLuong8.getText());
				tongtien8 = soluong8 * Float.parseFloat(lblDonGia8.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
						+ tongtien8;
				lblTongTien.setText(Float.toString(tongtien));
			} else if (k == 9) {
				String tenthuoc9 = countResult[0].toString();
				cbbThuoc9.setSelectedItem(tenthuoc9);
				jtSoLuong9.setText(countResult[1].toString());
				lblDonGia9.setText(countResult[2].toString());
				cbThuoc9.setSelected(true);
				soluong9 = Integer.parseInt(jtSoLuong9.getText());
				tongtien9 = soluong9 * Float.parseFloat(lblDonGia9.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9;
				lblTongTien.setText(Float.toString(tongtien));
			} else {
				String tenthuoc10 = countResult[0].toString();
				cbbThuoc10.setSelectedItem(tenthuoc10);
				jtSoLuong10.setText(countResult[1].toString());
				lblDonGia10.setText(countResult[2].toString());
				cbThuoc10.setSelected(true);
				soluong10 = Integer.parseInt(jtSoLuong10.getText());
				tongtien10 = soluong10 * Float.parseFloat(lblDonGia10.getText());
				tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
						+ tongtien9 + tongtien10;
				lblTongTien.setText(Float.toString(tongtien));
			}
			k++;
		}

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

		// cac su kien thay doi cac textfield
		jtSoLuong1.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				int soluong1;
				if (!cbThuoc1.isSelected()) {
					tongtien1 = 0;
				} else {
					soluong1 = Integer.parseInt(jtSoLuong1.getText());
					tongtien1 = soluong1 * Float.parseFloat(lblDonGia1.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong1 = Integer.parseInt(jtSoLuong1.getText());
						tongtien1 = soluong1 * Float.parseFloat(lblDonGia1.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien2 = soluong2 * Float.parseFloat(lblDonGia2.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong2 = Integer.parseInt(jtSoLuong2.getText());
						tongtien2 = soluong2 * Float.parseFloat(lblDonGia2.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien3 = soluong3 * Float.parseFloat(lblDonGia3.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong3 = Integer.parseInt(jtSoLuong3.getText());
						tongtien3 = soluong3 * Float.parseFloat(lblDonGia3.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien4 = soluong4 * Float.parseFloat(lblDonGia4.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong4 = Integer.parseInt(jtSoLuong4.getText());
						tongtien4 = soluong4 * Float.parseFloat(lblDonGia4.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien5 = soluong5 * Float.parseFloat(lblDonGia5.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						tongtien = tongtien5;
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong5 = Integer.parseInt(jtSoLuong5.getText());
						tongtien5 = soluong5 * Float.parseFloat(lblDonGia5.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien6 = soluong6 * Float.parseFloat(lblDonGia6.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong6 = Integer.parseInt(jtSoLuong6.getText());
						tongtien6 = soluong6 * Float.parseFloat(lblDonGia6.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien7 = soluong7 * Float.parseFloat(lblDonGia7.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong7 = Integer.parseInt(jtSoLuong7.getText());
						tongtien7 = soluong7 * Float.parseFloat(lblDonGia7.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien8 = soluong8 * Float.parseFloat(lblDonGia8.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong8 = Integer.parseInt(jtSoLuong8.getText());
						tongtien8 = soluong8 * Float.parseFloat(lblDonGia8.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien9 = soluong9 * Float.parseFloat(lblDonGia9.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong9 = Integer.parseInt(jtSoLuong9.getText());
						tongtien9 = soluong9 * Float.parseFloat(lblDonGia9.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
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
					tongtien1 = soluong10 * Float.parseFloat(lblDonGia10.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
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
						lblTongTien.setText(Float.toString(tongtien));
					} else {
						soluong10 = Integer.parseInt(jtSoLuong10.getText());
						tongtien10 = soluong10 * Float.parseFloat(lblDonGia10.getText());
						tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
								+ tongtien8 + tongtien9 + tongtien10;
						lblTongTien.setText(Float.toString(tongtien));
					}
				}
			}

			@Override
			public void changedUpdate(DocumentEvent e) {

			}
		});

		// goi nut bat su kien
		btnSua.addActionListener(this);
		btnSua.setActionCommand("Sua");
		// hien thi don gia lan dau

		for (int i = 0; i < alThuoc.size(); i++) {
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())) {
				lblDonGia1.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())) {
				lblDonGia2.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())) {
				lblDonGia3.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())) {
				lblDonGia4.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())) {
				lblDonGia5.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())) {
				lblDonGia6.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())) {
				lblDonGia7.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())) {
				lblDonGia8.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())) {
				lblDonGia9.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())) {
				lblDonGia10.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}

		}

		// load lan dau chua click cac thuoc tong tien = 0
		if (!cbThuoc1.isSelected() && !cbThuoc2.isSelected() && !cbThuoc3.isSelected() && !cbThuoc4.isSelected()
				&& !cbThuoc5.isSelected() && !cbThuoc6.isSelected() && !cbThuoc7.isSelected() && !cbThuoc8.isSelected()
				&& !cbThuoc9.isSelected() && !cbThuoc10.isSelected()) {
			tongtien = 0;
			lblTongTien.setText(Float.toString(tongtien));
		}

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

		// su kien thay doi cbb thi dongia doi theo
		for (int i = 0; i < alThuoc.size(); i++) {
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())) {
				lblDonGia1.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())) {
				lblDonGia2.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())) {
				lblDonGia3.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())) {
				lblDonGia4.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())) {
				lblDonGia5.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())) {
				lblDonGia6.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())) {
				lblDonGia7.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())) {
				lblDonGia8.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())) {
				lblDonGia9.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
			if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())) {
				lblDonGia10.setText(Float.toString(alThuoc.get(i).getDonGia()));
			}
		}
		// tinh tong tien khi doi combobox
		if (cbThuoc1.isSelected()) {
			soluong1 = Integer.parseInt(jtSoLuong1.getText());
			tongtien1 = soluong1 * Float.parseFloat(lblDonGia1.getText());
			tongtien = tongtien1;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc2.isSelected()) {
			soluong2 = Integer.parseInt(jtSoLuong2.getText());
			tongtien2 = soluong2 * Float.parseFloat(lblDonGia2.getText());
			tongtien = tongtien1 + tongtien2;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc3.isSelected()) {
			soluong3 = Integer.parseInt(jtSoLuong3.getText());
			tongtien3 = soluong3 * Float.parseFloat(lblDonGia3.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc4.isSelected()) {
			soluong4 = Integer.parseInt(jtSoLuong4.getText());
			tongtien4 = soluong4 * Float.parseFloat(lblDonGia4.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc5.isSelected()) {
			soluong5 = Integer.parseInt(jtSoLuong5.getText());
			tongtien5 = soluong5 * Float.parseFloat(lblDonGia5.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc6.isSelected()) {
			soluong6 = Integer.parseInt(jtSoLuong6.getText());
			tongtien6 = soluong6 * Float.parseFloat(lblDonGia6.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc7.isSelected()) {
			soluong7 = Integer.parseInt(jtSoLuong7.getText());
			tongtien7 = soluong7 * Float.parseFloat(lblDonGia7.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc8.isSelected()) {
			soluong8 = Integer.parseInt(jtSoLuong8.getText());
			tongtien8 = soluong8 * Float.parseFloat(lblDonGia8.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc9.isSelected()) {
			soluong9 = Integer.parseInt(jtSoLuong9.getText());
			tongtien9 = soluong9 * Float.parseFloat(lblDonGia9.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
					+ tongtien9;
			lblTongTien.setText(Float.toString(tongtien));
		}
		if (cbThuoc10.isSelected()) {
			soluong10 = Integer.parseInt(jtSoLuong10.getText());
			tongtien10 = soluong10 * Float.parseFloat(lblDonGia10.getText());
			tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7 + tongtien8
					+ tongtien9 + tongtien10;
			lblTongTien.setText(Float.toString(tongtien));
		}
		// su kien khi click checkbox loaibenh, lay id cua checkbox
		String command = ae.getActionCommand();

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
					tongtien1 = soluong1 * Float.parseFloat(lblDonGia1.getText());
					tongtien = tongtien1;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				// bo click thi idthuoc1 la 0
				idthuoc1 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien1));// tong tien - lai tong tien 1
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
					tongtien2 = soluong2 * Float.parseFloat(lblDonGia2.getText());
					tongtien = tongtien1 + tongtien2;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc2 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien2));
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
					tongtien3 = soluong3 * Float.parseFloat(lblDonGia3.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc3 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien3));
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
					tongtien4 = soluong4 * Float.parseFloat(lblDonGia4.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien4));
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
					tongtien5 = soluong5 * Float.parseFloat(lblDonGia5.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc5 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien1));
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
					tongtien6 = soluong6 * Float.parseFloat(lblDonGia6.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc6 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien6));
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
					tongtien7 = soluong7 * Float.parseFloat(lblDonGia7.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc7 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien7));
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
					tongtien8 = soluong8 * Float.parseFloat(lblDonGia8.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc8 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien8));
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
					tongtien9 = soluong9 * Float.parseFloat(lblDonGia9.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc9 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien9));
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
					tongtien10 = soluong10 * Float.parseFloat(lblDonGia10.getText());
					tongtien = tongtien1 + tongtien2 + tongtien3 + tongtien4 + tongtien5 + tongtien6 + tongtien7
							+ tongtien8 + tongtien9 + tongtien10;
					lblTongTien.setText(Float.toString(tongtien));
				}
			} else {
				idthuoc10 = 0;
				tongtien = Float.parseFloat(lblTongTien.getText());
				lblTongTien.setText(Float.toString(tongtien - tongtien10));
			}
			break;
		}

		if (command.equals("Sua")) {
			int idbenhnhan = 0;
			int id = 0; // can truyen ID de update
			id = phieukhamDAO.layidTheoMaPhieuKhamBenh(maphieukham);
			Date ngaykham = new Date();
			// lay id benh nhan. id loaibenh va id thuoc o tren
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

			if ((!cbLoaiBenh1.isSelected() && !cbLoaiBenh2.isSelected() && !cbLoaiBenh3.isSelected())) {
				JOptionPane.showMessageDialog(null, "Thêm thất bại, Chọn ít nhất 1 loại bệnh !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
				return;
			}
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
			// sua bang phieu kham benh truoc
			phieukhambenh pkb = new phieukhambenh();
			pkb.setID(id);
			pkb.setMaPhieuKhamBenh(maphieukham);
			pkb.setNgayKham(ngaykham);
			pkb.setTinhTrang(0);
			pkb.setTongTienThuoc(Float.parseFloat(lblTongTien.getText()));
			phieukhamDAO.suaPhieuKham(pkb);

			// xoa cac bang trung gian
			// xoa ctloaibenh
			List<Object[]> oCTLoaiBenh = ctloaibenhDAO.layCTLoaiBenhTheoMaPhieuKhamBenh(maphieukham);
			for (Object[] countResult : oCTLoaiBenh) {
				ctloaibenh ctlb = new ctloaibenh();
				ctlb.setID_PhieuKhamBenh(id);
				ctlb.setID_LoaiBenh((Integer) countResult[0]);
				ctloaibenhDAO.xoaCTLoaiBenh(ctlb);
			}
			// xoa ctthuoc
			List<Object[]> oCTThuoc = ctthuocDAO.layCTThuocTheoMaPhieuKhamBenh(maphieukham);
			for (Object[] countResult : oCTThuoc) {
				ctthuoc ctt = new ctthuoc();
				ctt.setID_PhieuKhamBenh(id);
				ctt.setID_Thuoc((Integer) countResult[0]);
				ctthuocDAO.xoaCTThuoc(ctt);
			}

			// them cac bang trung gian
			// them bang ctloaibenh
			ctloaibenh ctlb = new ctloaibenh();
			if (cbLoaiBenh1.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh1.getSelectedItem().toString())) {
						idbenh1 = alLoaiBenh.get(i).getID();
						ctlb.setID_PhieuKhamBenh(id);
						ctlb.setID_LoaiBenh(idbenh1);
						ctloaibenhDAO.themCTLoaiBenh(ctlb);
					}
				}
			}
			if (cbLoaiBenh2.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh2.getSelectedItem().toString())) {
						idbenh2 = alLoaiBenh.get(i).getID();
						ctlb.setID_PhieuKhamBenh(id);
						ctlb.setID_LoaiBenh(idbenh2);
						ctloaibenhDAO.themCTLoaiBenh(ctlb);
					}
				}
			}
			if (cbLoaiBenh3.isSelected()) {
				for (int i = 0; i < alLoaiBenh.size(); i++) {
					if (alLoaiBenh.get(i).getTenLoaiBenh().equals(cbbLoaiBenh3.getSelectedItem().toString())) {
						idbenh3 = alLoaiBenh.get(i).getID();
						ctlb.setID_PhieuKhamBenh(id);
						ctlb.setID_LoaiBenh(idbenh3);
						ctloaibenhDAO.themCTLoaiBenh(ctlb);
					}
				}
			}
			// them ctthuoc
			ctthuoc ctthuoc = new ctthuoc();
			if (cbThuoc1.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc1.getSelectedItem().toString())) {
						idthuoc1 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc1);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong1.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc2.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc2.getSelectedItem().toString())) {
						idthuoc2 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc2);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong2.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc3.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc3.getSelectedItem().toString())) {
						idthuoc3 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc3);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong3.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc4.isSelected()) {
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc4.getSelectedItem().toString())) {
						idthuoc4 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc4);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong4.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc5.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc5.getSelectedItem().toString())) {
						idthuoc5 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc5);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong5.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc6.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc6.getSelectedItem().toString())) {
						idthuoc6 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc6);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong6.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc7.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc7.getSelectedItem().toString())) {
						idthuoc7 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc7);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong7.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc8.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc8.getSelectedItem().toString())) {
						idthuoc8 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc8);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong8.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc9.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc9.getSelectedItem().toString())) {
						idthuoc9 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc9);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong9.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
			}
			if (cbThuoc10.isSelected()) {
				// neu click vao id thuoc1 la id trong db
				for (int i = 0; i < alThuoc.size(); i++) {
					if (alThuoc.get(i).getTenThuoc().equals(cbbThuoc10.getSelectedItem().toString())) {
						idthuoc10 = alThuoc.get(i).getID();
						ctthuoc.setID_Thuoc(idthuoc10);
						ctthuoc.setID_PhieuKhamBenh(id);
						ctthuoc.setSoLuong(Integer.parseInt(jtSoLuong10.getText()));
						ctthuocDAO.themCTThuoc(ctthuoc);
					}
				}
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
			JOptionPane.showMessageDialog(null, "Sửa phiếu khám thành công!", "WARNING", JOptionPane.WARNING_MESSAGE);
			clientthread ct = new clientthread();
			this.dispose();
		}
	}
}
