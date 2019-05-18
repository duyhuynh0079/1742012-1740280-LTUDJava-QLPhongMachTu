package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.sun.org.apache.xerces.internal.impl.dv.xs.ListDV;

import DAO.cachdungDAO;
import DAO.donvithuocDAO;
import DAO.loaibenhDAO;
import DAO.nhanvienDAO;
import DAO.quydinh1DAO;
import DAO.quydinh2DAO;
import DAO.quydinh4DAO;
import DAO.quydinh6DAO;
import DAO.thuocDAO;
import entity.cachdung;
import entity.donvi;
import entity.loaibenh;
import entity.nhanvien;
import entity.quydinh1;
import entity.quydinh2;
import entity.quydinh4;
import entity.quydinh6;
import entity.thuoc;
import show.CachDungComboModel;
import show.CachDungModel;
import show.DonViTinhThuocComboModel;
import show.DonViTinhThuocModelqlt;
import show.LoaiBenhModel;
import show.NhanVienModel;
import show.NhanVienTimKiemModel;
import show.QuyDinh1Model;
import show.QuyDinh2Model;
import show.QuyDinh4Model;
import show.QuyDinh6Model;
import show.ThuocModel;
import show.showBenhNhan;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JPasswordField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Component;
import javax.swing.JTextArea;
import java.awt.TextArea;
import javax.swing.DefaultComboBoxModel;

public class nhanvienlayout extends JFrame {
	// pull request
	private JPanel contentPane;
	private JTextField txtHoTenNV;
	private JTextField txtNgaySinhNV;
	private JTextField txtSDTNV;
	private JTextField txtTenDangNhapNV;
	private JPasswordField jpMatKhauNV;
	private JPasswordField jpNhapLaiMatKhauNV;
	private JTable tableNV;
	private JTextField txtMaThuoc;
	private JTextField txtTenThuoc;
	private JTextField txtDonGiaThuoc;
	private JTable tableThuoc;
	private JTextField txtMaDonViThuoc;
	private JTextField txtTenDonViThuoc;
	private JTable tableDonViThuoc;
	private JTextField txtMaCachDungThuoc;
	private JTextField txtTenCachDungThuoc;
	private JTable tableCachDungThuoc;
	private JTextField txtMaQuyDinh;
	private JTextField txtTenQuyDinh;
	private JTable tableQuyDinhThuoc;
	JComboBox cmbQuyDinh;
	static int index; // bat vi tri duyet al de sua
	private JTextField txtGiaTri;
	private JTextField txtMaLoaiBenh;
	private JTextField txtTenLoaiBenh;
	private JTable tableLoaiBenh;
	static int manv = 0;
	static String tennv = "";
	private JTextField txtSoDonVi;
	private JTextField txtSoCachDung;
	private Component lblSoDonVi;
	private JLabel lblSoCachDung;
	private JTextField textField_2;
	private JTextField txtSoLuongThuoc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhanvienlayout frame = new nhanvienlayout(tennv, manv);
					frame.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public nhanvienlayout(String tennhanvien, int MANV) {
		// manv = manhanvien;
		tennv = tennhanvien;
		manv = MANV;
		setTitle(tennv);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 971, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane);
		String IDNhanVien = String.format("%d", manv);

//		txtNgaySinhNV = new JTextField();
//		txtNgaySinhNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtNgaySinhNV.setColumns(10);
//		txtNgaySinhNV.setBounds(169, 156, 170, 25);
//		pnNhanVien.add(txtNgaySinhNV);

		UtilDateModel model = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
		NhanVienModel modelNV = new NhanVienModel();

		JPanel pnTaiKhoan = new JPanel();
		tabbedPane.addTab("Tài Khoản", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\userTaiKhoan.png"),
				pnTaiKhoan, null);
		pnTaiKhoan.setLayout(null);

		JLabel lblTiKhon = new JLabel("TÀI KHOẢN");
		lblTiKhon.setForeground(Color.RED);
		lblTiKhon.setFont(new Font("Arial", Font.PLAIN, 20));
		lblTiKhon.setBounds(420, 11, 115, 35);
		pnTaiKhoan.add(lblTiKhon);

		JButton btnDoiMatKhauNV = new JButton("Đổi mật khẩu");
		btnDoiMatKhauNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doimatkhau dmk = new doimatkhau(tennv, manv);
				dmk.setVisible(true);
				dmk.setLocationRelativeTo(null);// canh giua man hinh
				System.out.println(DAO.nhanvienDAO.layMaChucVu(manv));
			}
		});
		btnDoiMatKhauNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnDoiMatKhauNV.setForeground(Color.RED);
		btnDoiMatKhauNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDoiMatKhauNV.setBounds(384, 330, 168, 41);
		pnTaiKhoan.add(btnDoiMatKhauNV);
		JButton button_3 = new JButton("");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		button_3.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		button_3.setToolTipText("Đăng xuất");
		button_3.setForeground(Color.RED);
		button_3.setFont(new Font("Arial", Font.PLAIN, 17));
		button_3.setBounds(908, 0, 42, 42);
		pnTaiKhoan.add(button_3);

		JLabel label = new JLabel("ID nhân viên");
		label.setForeground(Color.BLUE);
		label.setFont(new Font("Arial", Font.PLAIN, 17));
		label.setBounds(360, 87, 103, 27);
		pnTaiKhoan.add(label);

		JLabel IDTK = new JLabel("ID Nhanvien");
		IDTK.setText(IDNhanVien);
		IDTK.setForeground(Color.BLACK);
		IDTK.setFont(new Font("Arial", Font.PLAIN, 17));
		IDTK.setBounds(483, 87, 103, 27);
		pnTaiKhoan.add(IDTK);

		JLabel label_2 = new JLabel("Họ tên");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Arial", Font.PLAIN, 17));
		label_2.setBounds(360, 125, 103, 27);
		pnTaiKhoan.add(label_2);

		JLabel label_3 = new JLabel("Địa chỉ");
		label_3.setForeground(Color.BLUE);
		label_3.setFont(new Font("Arial", Font.PLAIN, 17));
		label_3.setBounds(360, 196, 103, 27);
		pnTaiKhoan.add(label_3);

		JLabel label_6 = new JLabel("Tên đăng nhập");
		label_6.setForeground(Color.BLUE);
		label_6.setFont(new Font("Arial", Font.PLAIN, 17));
		label_6.setBounds(360, 272, 124, 27);
		pnTaiKhoan.add(label_6);

		JLabel label_7 = new JLabel("Số điện thoại");
		label_7.setForeground(Color.BLUE);
		label_7.setFont(new Font("Arial", Font.PLAIN, 17));
		label_7.setBounds(360, 234, 103, 27);
		pnTaiKhoan.add(label_7);

		JLabel label_9 = new JLabel("Ngày sinh");
		label_9.setForeground(Color.BLUE);
		label_9.setFont(new Font("Arial", Font.PLAIN, 17));
		label_9.setBounds(360, 163, 103, 27);
		pnTaiKhoan.add(label_9);

		JLabel lblHoTenTK = new JLabel("HoTen Nhanvien");
		lblHoTenTK.setText(DAO.nhanvienDAO.layHoTenNV(manv));
		lblHoTenTK.setForeground(Color.BLACK);
		lblHoTenTK.setFont(new Font("Arial", Font.PLAIN, 17));
		lblHoTenTK.setBounds(483, 125, 103, 27);
		pnTaiKhoan.add(lblHoTenTK);

		JLabel lblNgaySinhTK = new JLabel("NgaySinh Nhanvien");
		lblNgaySinhTK.setText(DAO.nhanvienDAO.layNgaySinhNV(manv));
		lblNgaySinhTK.setForeground(Color.BLACK);
		lblNgaySinhTK.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNgaySinhTK.setBounds(483, 163, 103, 27);
		pnTaiKhoan.add(lblNgaySinhTK);

		JLabel lblDiaChiTK = new JLabel("DiaChi Nhanvien");
		lblDiaChiTK.setText(DAO.nhanvienDAO.layDiaChiNV(manv));
		lblDiaChiTK.setForeground(Color.BLACK);
		lblDiaChiTK.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDiaChiTK.setBounds(482, 196, 194, 27);
		pnTaiKhoan.add(lblDiaChiTK);

		JLabel lblSDTTK = new JLabel("SDT");
		lblSDTTK.setText(DAO.nhanvienDAO.laySDTNV(manv));
		lblSDTTK.setForeground(Color.BLACK);
		lblSDTTK.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSDTTK.setBounds(483, 234, 103, 27);
		pnTaiKhoan.add(lblSDTTK);

		JLabel lblTenDNTK = new JLabel("Ten DN");
		lblTenDNTK.setText(DAO.nhanvienDAO.layTenDangNhapNV(manv));
		lblTenDNTK.setForeground(Color.BLACK);
		lblTenDNTK.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenDNTK.setBounds(483, 272, 103, 27);
		pnTaiKhoan.add(lblTenDNTK);

		JPanel pnNhanVien = new JPanel();
		tabbedPane.addTab("Nhân viên", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Pharmacist_Male_Light.png"),
				pnNhanVien, null);
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		pnNhanVien.setLayout(null);

		JLabel lblnhanvien = new JLabel("QUẢN LÝ NHÂN VIÊN");
		lblnhanvien.setForeground(Color.RED);
		lblnhanvien.setFont(new Font("Arial", Font.PLAIN, 20));
		lblnhanvien.setBounds(351, 9, 205, 35);
		pnNhanVien.add(lblnhanvien);

		JLabel lblIDNhanVien = new JLabel("ID nhân viên");
		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDNhanVien.setForeground(Color.BLUE);
		lblIDNhanVien.setBounds(101, 80, 103, 27);
		pnNhanVien.add(lblIDNhanVien);

		JLabel lblHoTen = new JLabel("Họ tên");
		lblHoTen.setForeground(Color.BLUE);
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 17));
		lblHoTen.setBounds(101, 118, 103, 27);
		pnNhanVien.add(lblHoTen);

		JLabel lblNgaySinh = new JLabel("Ngày sinh");
		lblNgaySinh.setForeground(Color.BLUE);
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNgaySinh.setBounds(101, 156, 103, 27);
		pnNhanVien.add(lblNgaySinh);

		JLabel lblDiaChi = new JLabel("Địa chỉ");
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDiaChi.setBounds(101, 196, 103, 27);
		pnNhanVien.add(lblDiaChi);

		txtHoTenNV = new JTextField();
		txtHoTenNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtHoTenNV.setBounds(224, 118, 170, 25);
		pnNhanVien.add(txtHoTenNV);
		txtHoTenNV.setColumns(10);

		JLabel lblIDNV = new JLabel("ID Nhanvien");
		lblIDNV.setForeground(Color.BLUE);
		lblIDNV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDNV.setBounds(224, 80, 103, 27);
		pnNhanVien.add(lblIDNV);
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePicker.setBounds(224, 156, 170, 25);
		pnNhanVien.add(datePicker);

		textField_2 = new JTextField();
		textField_2.setFont(new Font("Arial", Font.PLAIN, 17));
		textField_2.setColumns(10);
		datePicker.add(textField_2);

		JLabel lblSDT = new JLabel("Số điện thoại");
		lblSDT.setForeground(Color.BLUE);
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSDT.setBounds(503, 118, 103, 27);
		pnNhanVien.add(lblSDT);

		txtSDTNV = new JTextField();
		txtSDTNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(661, 118, 170, 25);
		pnNhanVien.add(txtSDTNV);

		JLabel lblTnngNhp = new JLabel("Tên đăng nhập");
		lblTnngNhp.setForeground(Color.BLUE);
		lblTnngNhp.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTnngNhp.setBounds(503, 156, 124, 27);
		pnNhanVien.add(lblTnngNhp);

		txtTenDangNhapNV = new JTextField();
		txtTenDangNhapNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDangNhapNV.setColumns(10);
		txtTenDangNhapNV.setBounds(661, 156, 170, 25);
		pnNhanVien.add(txtTenDangNhapNV);

		JLabel lblMtKhu = new JLabel("Mật khẩu");
		lblMtKhu.setForeground(Color.BLUE);
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMtKhu.setBounds(503, 194, 124, 27);
		pnNhanVien.add(lblMtKhu);

		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setForeground(Color.BLUE);
		lblNhpLiMt.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNhpLiMt.setBounds(503, 233, 140, 27);
		pnNhanVien.add(lblNhpLiMt);

		jpMatKhauNV = new JPasswordField();
		jpMatKhauNV.setBounds(661, 194, 170, 25);
		pnNhanVien.add(jpMatKhauNV);

		jpNhapLaiMatKhauNV = new JPasswordField();
		jpNhapLaiMatKhauNV.setBounds(661, 233, 170, 25);
		pnNhanVien.add(jpNhapLaiMatKhauNV);

		JTextArea taDiaChiNV = new JTextArea();
		taDiaChiNV.setFont(new Font("Arial", Font.PLAIN, 17));
		taDiaChiNV.setBounds(224, 199, 170, 61);
		pnNhanVien.add(taDiaChiNV);

		JLabel lblChcV = new JLabel("Chức vụ");
		lblChcV.setForeground(Color.BLUE);
		lblChcV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblChcV.setBounds(503, 80, 103, 27);
		pnNhanVien.add(lblChcV);

		JComboBox cmbChucVuNV = new JComboBox();
		cmbChucVuNV.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] { "Bác sĩ", "Y tá" }));
		cmbChucVuNV.setBounds(661, 83, 170, 25);
		pnNhanVien.add(cmbChucVuNV);

		JButton btnThemNV = new JButton("Thêm");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("") || jpMatKhauNV.getText().equals("")
						|| jpNhapLaiMatKhauNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else if (validate.isNumber(txtSDTNV.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Số điện thoại chỉ nhập số!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else if (jpMatKhauNV.getText().equals(jpNhapLaiMatKhauNV.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp nhập lại mật khẩu!");
					jpMatKhauNV.setText(null);
					jpNhapLaiMatKhauNV.setText(null);
				} else if (nhanvienDAO.timTenDangNhapTrung(txtTenDangNhapNV.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại, nhập lại tên đăng nhập!");
					txtTenDangNhapNV.setText(null);

				} else {

					Date ngaysinh;
					nhanvien nv = new nhanvien();

					// format ngay sinh
					try {
						nv.setTenDangNhap(txtTenDangNhapNV.getText());
						String matkhaudahash = "";

						try {
							matkhaudahash = nhanvienDAO.GetPasswordHashText(jpNhapLaiMatKhauNV.getText());
							nv.setMatKhau(matkhaudahash);
						} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}

						nv.setHoTenNV(txtHoTenNV.getText());
						ngaysinh = new SimpleDateFormat("yyyy-MM-dd")
								.parse(datePicker.getJFormattedTextField().getText());
						nv.setNgaySinh(ngaysinh);
						nv.setDiaChi(taDiaChiNV.getText());
						nv.setSDT(txtSDTNV.getText());
						nv.setTinhTrang(1);
						// nv.setMaCV(inter);
						nv.setMaCV(cmbChucVuNV.getSelectedIndex() + 1);
						try {
							if (DAO.nhanvienDAO.themNhanVien(nv) == true) {
								JOptionPane.showMessageDialog(null, "Đã thêm nhân viên: " + txtHoTenNV.getText());
								lblIDNV.setText(null);
								txtHoTenNV.setText(null);
								datePicker.getJFormattedTextField().setText(null);
								txtSDTNV.setText(null);
								taDiaChiNV.setText(null);
								txtTenDangNhapNV.setText(null);
								jpMatKhauNV.setText(null);
								jpNhapLaiMatKhauNV.setText(null);
								cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] { "Bác sĩ", "Y tá" }));
								NhanVienModel mdNhanVien = new NhanVienModel();
								tableNV.setModel(mdNhanVien);
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

				}
			}
		});
		btnThemNV.setForeground(Color.RED);
		btnThemNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemNV.setBounds(102, 292, 115, 41);
		pnNhanVien.add(btnThemNV);

		JButton btnCapNhatNV = new JButton("Cập nhật");
		btnCapNhatNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn nhân viên cần cập nhật!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else if (validate.isNumber(txtSDTNV.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Số điện thoại chỉ được nhập số!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					Date ngaysinh;
					nhanvien nv = new nhanvien();
					ArrayList<nhanvien> alnv = NhanVienModel.listNV;
					for (int i = 0; i < alnv.size(); i++) {
						if (index == alnv.get(i).getID()) {
							nv.setID(alnv.get(i).getID());
							nv.setTenDangNhap(txtTenDangNhapNV.getText());
							nv.setMatKhau(alnv.get(i).getMatKhau());
							nv.setHoTenNV(txtHoTenNV.getText());
							try {
								ngaysinh = new SimpleDateFormat("yyyy-MM-dd")
										.parse(datePicker.getJFormattedTextField().getText());
								nv.setNgaySinh(ngaysinh);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}

							nv.setDiaChi(taDiaChiNV.getText());
							nv.setSDT(txtSDTNV.getText());
							nv.setTinhTrang(1);
							nv.setMaCV(cmbChucVuNV.getSelectedIndex() + 1);
						}
					}
					try {
						if (nhanvienDAO.suaNhanVien(nv) == true) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDNV.setText(null);
							txtHoTenNV.setText(null);
							datePicker.getJFormattedTextField().setText(null);
							txtSDTNV.setText(null);
							taDiaChiNV.setText(null);
							txtTenDangNhapNV.setText(null);
							jpMatKhauNV.setText(null);
							jpNhapLaiMatKhauNV.setText(null);
							cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] { "Bác sĩ", "Y tá" }));
							NhanVienModel mdNhanVien = new NhanVienModel();
							tableNV.setModel(mdNhanVien);
						} else {
							JOptionPane.showMessageDialog(null,
									"Cập nhật thất bại, vui lòng click bảng chọn nhân viên cần cập nhật!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatNV.setForeground(Color.RED);
		btnCapNhatNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatNV.setBounds(256, 292, 140, 41);
		pnNhanVien.add(btnCapNhatNV);

		JButton btnXoaNV = new JButton("Xóa");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn nhân viên cần xóa!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					nhanvien nv = new nhanvien();
					ArrayList<nhanvien> alnv = NhanVienModel.listNV;
					for (int i = 0; i < alnv.size(); i++) {
						if (index == alnv.get(i).getID()) {
							nv.setID(alnv.get(i).getID());
							nv.setTenDangNhap(alnv.get(i).getTenDangNhap());
							nv.setMatKhau(alnv.get(i).getMatKhau());
							nv.setHoTenNV(alnv.get(i).getHoTenNV());
							nv.setNgaySinh(alnv.get(i).getNgaySinh());
							nv.setDiaChi(alnv.get(i).getDiaChi());
							nv.setSDT(alnv.get(i).getSDT());
							nv.setTinhTrang(0);
							nv.setMaCV(alnv.get(i).getMaCV());
						}
					}
					try {
						if (nhanvienDAO.suaNhanVien(nv) == true) {
							JOptionPane.showMessageDialog(null, "Xóa thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDNV.setText(null);
							txtHoTenNV.setText(null);
							datePicker.getJFormattedTextField().setText(null);
							txtSDTNV.setText(null);
							taDiaChiNV.setText(null);
							txtTenDangNhapNV.setText(null);
							jpMatKhauNV.setText(null);
							jpNhapLaiMatKhauNV.setText(null);
							NhanVienModel mdNhanVien = new NhanVienModel();
							tableNV.setModel(mdNhanVien);
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại, click bảng chọn nhân viên cần xóa!",
									"WARNING", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

			}
		});
		btnXoaNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
		btnXoaNV.setForeground(Color.RED);
		btnXoaNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoaNV.setBounds(439, 292, 103, 41);
		pnNhanVien.add(btnXoaNV);

		JButton btnLoadNV = new JButton("Load");
		btnLoadNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDNV.setText(null);
				txtHoTenNV.setText(null);
				datePicker.getJFormattedTextField().setText(null);
				txtSDTNV.setText(null);
				taDiaChiNV.setText(null);
				txtTenDangNhapNV.setText(null);
				jpMatKhauNV.setText(null);
				jpNhapLaiMatKhauNV.setText(null);
				cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] { "Bác sĩ", "Y tá" }));
				NhanVienModel mdNhanVien = new NhanVienModel();
				tableNV.setModel(mdNhanVien);
			}
		});
		btnLoadNV.setForeground(Color.RED);
		btnLoadNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadNV.setBounds(732, 292, 109, 41);
		pnNhanVien.add(btnLoadNV);

		tableNV = new JTable();
		tableNV.setModel(modelNV);
		JScrollPane scrollPaneNV = new JScrollPane(tableNV);// dan table vao khung jsp
		scrollPaneNV.setBounds(106, 356, 735, 169);
		pnNhanVien.add(scrollPaneNV);

		tableNV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableNV.getSelectedRow() >= 0) {
					lblIDNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 0).toString());
					txtTenDangNhapNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 1).toString());
					txtHoTenNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 2).toString());
					datePicker.getJFormattedTextField()
							.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 3).toString());
					taDiaChiNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 4).toString());
					txtSDTNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 5).toString());
					cmbChucVuNV.setSelectedItem(tableNV.getValueAt(tableNV.getSelectedRow(), 6).toString());
					index = Integer.parseInt(lblIDNV.getText());
				}
			}
		});

		JButton btnTimNV = new JButton("Tìm");
		btnTimNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tên nhân viên cần tìm!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					NhanVienTimKiemModel modelNV = new NhanVienTimKiemModel(txtHoTenNV.getText());
					tableNV.setModel(modelNV);
				}
			}
		});
		btnTimNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
		btnTimNV.setForeground(Color.RED);
		btnTimNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnTimNV.setBounds(583, 292, 109, 41);
		pnNhanVien.add(btnTimNV);

		JButton btnDangXuat = new JButton("");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuat.setToolTipText("Đăng xuất");
		btnDangXuat.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuat.setForeground(Color.RED);
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuat.setBounds(908, 0, 42, 42);
		pnNhanVien.add(btnDangXuat);

		JPanel pnLoaiBenh = new JPanel();
		tabbedPane.addTab("Loại Bệnh", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\loaibenh.png"),
				pnLoaiBenh, null);
		pnLoaiBenh.setLayout(null);

		JLabel lblQunLLoi = new JLabel("QUẢN LÝ LOẠI BỆNH");
		lblQunLLoi.setForeground(Color.RED);
		lblQunLLoi.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLLoi.setBounds(384, 11, 201, 35);
		pnLoaiBenh.add(lblQunLLoi);

		JLabel lblIdMaloaibenh = new JLabel("ID loại bệnh");
		lblIdMaloaibenh.setForeground(Color.BLUE);
		lblIdMaloaibenh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdMaloaibenh.setBounds(298, 64, 103, 27);
		pnLoaiBenh.add(lblIdMaloaibenh);

		JLabel lblIDLoaiBenh = new JLabel("ID LoaiBenh");
		lblIDLoaiBenh.setForeground(Color.BLUE);
		lblIDLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDLoaiBenh.setBounds(429, 66, 103, 27);
		pnLoaiBenh.add(lblIDLoaiBenh);

		JLabel lblMLoiBnh = new JLabel("Mã loại bệnh");
		lblMLoiBnh.setForeground(Color.BLUE);
		lblMLoiBnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMLoiBnh.setBounds(298, 102, 103, 27);
		pnLoaiBenh.add(lblMLoiBnh);

		txtMaLoaiBenh = new JTextField();
		txtMaLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaLoaiBenh.setColumns(10);
		txtMaLoaiBenh.setBounds(429, 104, 217, 25);
		pnLoaiBenh.add(txtMaLoaiBenh);

		JLabel lblTnLoiBnh = new JLabel("Tên loại bệnh");
		lblTnLoiBnh.setForeground(Color.BLUE);
		lblTnLoiBnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTnLoiBnh.setBounds(298, 140, 103, 27);
		pnLoaiBenh.add(lblTnLoiBnh);

		txtTenLoaiBenh = new JTextField();
		txtTenLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenLoaiBenh.setColumns(10);
		txtTenLoaiBenh.setBounds(429, 142, 217, 25);
		pnLoaiBenh.add(txtTenLoaiBenh);

		JLabel lblTriuChng = new JLabel("Triệu chứng");
		lblTriuChng.setForeground(Color.BLUE);
		lblTriuChng.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTriuChng.setBounds(298, 178, 125, 27);
		pnLoaiBenh.add(lblTriuChng);

		JTextArea taTrieuChungLoaiBenh = new JTextArea();
		taTrieuChungLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		taTrieuChungLoaiBenh.setBounds(429, 178, 217, 74);
		pnLoaiBenh.add(taTrieuChungLoaiBenh);

		JButton btnThemLoaiBenh = new JButton("Thêm");
		btnThemLoaiBenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DAO.loaibenhDAO.laySoDongLoaiBenh() == DAO.quydinh2DAO.laySoLoaiBenh(1)) {
					JOptionPane.showMessageDialog(null,
							"Vượt quá " + DAO.quydinh2DAO.laySoLoaiBenh(1) + " loại bệnh. Không thêm được!");
				} else if (txtMaLoaiBenh.getText().equals("") || txtTenLoaiBenh.getText().equals("")
						|| taTrieuChungLoaiBenh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else if (loaibenhDAO.timMaLoaiBenh(txtMaLoaiBenh.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Mã loại bệnh đã tồn tại!");
				} else {
					loaibenh lb = new loaibenh();
					lb.setMaLoaiBenh(txtMaLoaiBenh.getText());
					lb.setTenLoaiBenh(txtTenLoaiBenh.getText());
					lb.setTrieuChung(taTrieuChungLoaiBenh.getText());
					try {
						if (DAO.loaibenhDAO.themLoaiBenh(lb) == true) {
							JOptionPane.showMessageDialog(null, "Đã thêm loại bệnh: " + txtMaLoaiBenh.getText());
							lblIDLoaiBenh.setText(null);
							txtMaLoaiBenh.setText(null);
							txtTenLoaiBenh.setText(null);
							taTrieuChungLoaiBenh.setText(null);
							LoaiBenhModel mdLoaiBenh = new LoaiBenhModel();
							tableLoaiBenh.setModel(mdLoaiBenh);
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnThemLoaiBenh.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemLoaiBenh.setForeground(Color.RED);
		btnThemLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemLoaiBenh.setBounds(252, 281, 115, 41);
		pnLoaiBenh.add(btnThemLoaiBenh);

		JButton btnCapNhatLoaiBenh = new JButton("Cập nhật");
		btnCapNhatLoaiBenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaLoaiBenh.getText().equals("") || txtTenLoaiBenh.getText().equals("")
						|| taTrieuChungLoaiBenh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn loại bệnh cần cập nhật!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					loaibenh lb = new loaibenh();
					ArrayList<loaibenh> allb = LoaiBenhModel.listLB;
					for (int i = 0; i < allb.size(); i++) {
						if (index == allb.get(i).getID()) {
							lb.setID(allb.get(i).getID());
							lb.setMaLoaiBenh(txtMaLoaiBenh.getText());
							lb.setTenLoaiBenh(txtTenLoaiBenh.getText());
							lb.setTrieuChung(taTrieuChungLoaiBenh.getText());
						}
					}
					try {
						if (loaibenhDAO.suaLoaiBenh(lb) == true) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDLoaiBenh.setText(null);
							txtMaLoaiBenh.setText(null);
							txtTenLoaiBenh.setText(null);
							taTrieuChungLoaiBenh.setText(null);
							LoaiBenhModel mdLoaiBenh = new LoaiBenhModel();
							tableLoaiBenh.setModel(mdLoaiBenh);
						} else {
							JOptionPane.showMessageDialog(null,
									"Cập nhật thất bại, click bảng chọn nhân viên cần cập nhật!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatLoaiBenh.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatLoaiBenh.setForeground(Color.RED);
		btnCapNhatLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatLoaiBenh.setBounds(433, 281, 140, 41);
		pnLoaiBenh.add(btnCapNhatLoaiBenh);

		JButton btnLoadLoaiBenh = new JButton("Load");
		btnLoadLoaiBenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDLoaiBenh.setText(null);
				txtMaLoaiBenh.setText(null);
				txtTenLoaiBenh.setText(null);
				taTrieuChungLoaiBenh.setText(null);
				LoaiBenhModel mdLoaiBenh = new LoaiBenhModel();
				tableLoaiBenh.setModel(mdLoaiBenh);
			}
		});
		btnLoadLoaiBenh.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadLoaiBenh.setForeground(Color.RED);
		btnLoadLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadLoaiBenh.setBounds(629, 281, 109, 41);
		pnLoaiBenh.add(btnLoadLoaiBenh);

		tableLoaiBenh = new JTable();
		LoaiBenhModel modelLB = new LoaiBenhModel();
		tableLoaiBenh.setModel(modelLB);
		JScrollPane scrollPanelb = new JScrollPane(tableLoaiBenh);// dan table vao khung jsp
		scrollPanelb.setBounds(252, 354, 486, 169);
		pnLoaiBenh.add(scrollPanelb);

		JButton btnDangXuatLB = new JButton("");
		btnDangXuatLB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuatLB.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatLB.setToolTipText("Đăng xuất");
		btnDangXuatLB.setForeground(Color.RED);
		btnDangXuatLB.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatLB.setBounds(908, 0, 42, 42);
		pnLoaiBenh.add(btnDangXuatLB);

		tableLoaiBenh.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableLoaiBenh.getSelectedRow() >= 0) {
					lblIDLoaiBenh.setText(tableLoaiBenh.getValueAt(tableLoaiBenh.getSelectedRow(), 0).toString());
					txtMaLoaiBenh.setText(tableLoaiBenh.getValueAt(tableLoaiBenh.getSelectedRow(), 1).toString());
					txtTenLoaiBenh.setText(tableLoaiBenh.getValueAt(tableLoaiBenh.getSelectedRow(), 2).toString());
					taTrieuChungLoaiBenh
							.setText(tableLoaiBenh.getValueAt(tableLoaiBenh.getSelectedRow(), 3).toString());
					index = Integer.parseInt(lblIDLoaiBenh.getText());
				}
			}
		});

		// ql Thuoc
		JPanel pnThuoc = new JPanel();
		tabbedPane.addTab("Thuốc", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\thuoc.jpg"),
				pnThuoc, null);
		tabbedPane.setBackgroundAt(3, new Color(255, 255, 255));
		pnThuoc.setLayout(null);

		JLabel lblQunLthuc = new JLabel("QUẢN LÝ THUỐC");
		lblQunLthuc.setForeground(Color.RED);
		lblQunLthuc.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLthuc.setBounds(376, 7, 170, 35);
		pnThuoc.add(lblQunLthuc);

		JLabel lblidThuoc = new JLabel("ID thuốc");
		lblidThuoc.setForeground(Color.BLUE);
		lblidThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblidThuoc.setBounds(103, 69, 103, 27);
		pnThuoc.add(lblidThuoc);

		JLabel lblIDThuoc = new JLabel("ID thuoc");
		lblIDThuoc.setForeground(Color.BLUE);
		lblIDThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDThuoc.setBounds(226, 69, 103, 27);
		pnThuoc.add(lblIDThuoc);

		JLabel lblMaThuoc = new JLabel("Mã thuốc");
		lblMaThuoc.setForeground(Color.BLUE);
		lblMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaThuoc.setBounds(103, 107, 103, 27);
		pnThuoc.add(lblMaThuoc);

		txtMaThuoc = new JTextField();
		txtMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setBounds(226, 107, 170, 25);
		pnThuoc.add(txtMaThuoc);

		JLabel llbTenThuoc = new JLabel("Tên thuốc");
		llbTenThuoc.setForeground(Color.BLUE);
		llbTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		llbTenThuoc.setBounds(103, 145, 103, 27);
		pnThuoc.add(llbTenThuoc);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(226, 145, 170, 25);
		pnThuoc.add(txtTenThuoc);

		JLabel lblDonGia = new JLabel("Đơn giá");
		lblDonGia.setForeground(Color.BLUE);
		lblDonGia.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDonGia.setBounds(505, 107, 103, 27);
		pnThuoc.add(lblDonGia);

		txtDonGiaThuoc = new JTextField();
		txtDonGiaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDonGiaThuoc.setColumns(10);
		txtDonGiaThuoc.setBounds(663, 107, 170, 25);
		pnThuoc.add(txtDonGiaThuoc);

		JLabel lblnVTnh = new JLabel("Đơn vị thuốc");
		lblnVTnh.setForeground(Color.BLUE);
		lblnVTnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblnVTnh.setBounds(505, 145, 103, 27);
		pnThuoc.add(lblnVTnh);

		JComboBox cmbDonViTinhThuoc = new JComboBox();
		cmbDonViTinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbDonViTinhThuoc.setBounds(663, 146, 170, 25);
		cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
		pnThuoc.add(cmbDonViTinhThuoc);

		JComboBox cmbCachDung = new JComboBox();
		cmbCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbCachDung.setBounds(663, 184, 170, 25);
		cmbCachDung.setModel(new CachDungComboModel(DAO.cachdungDAO.LayDanhSachCachDung()));
		pnThuoc.add(cmbCachDung);

		JButton btnThemThuoc = new JButton("Thêm");
		btnThemThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (DAO.thuocDAO.laySoDong() == DAO.quydinh2DAO.laySoLoaiThuoc(1)) {
					JOptionPane.showMessageDialog(null,
							"Vượt quá " + DAO.quydinh2DAO.laySoLoaiThuoc(1) + " loại thuốc. Không thêm được!");
				} else if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("") || txtSoLuongThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else if (validate.isWord(txtDonGiaThuoc.getText()) == true
						|| validate.isNumber(txtSoLuongThuoc.getText()) == false ) {
					JOptionPane.showMessageDialog(null, "Đơn giá, số lượng chỉ được nhập số!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else if (thuocDAO.timMaThuoc(txtMaThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Mã thuốc đã tồn tại!");
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					cachdung cd = new cachdung();
					t.setMaThuoc(txtMaThuoc.getText());
					t.setTenThuoc(txtTenThuoc.getText());
					t.setSoLuong(Integer.parseInt(txtSoLuongThuoc.getText()));
					t.setDonGia(Double.parseDouble(txtDonGiaThuoc.getText()));
					t.setTinhTrang(1);
					dv = donvithuocDAO.timDonViTheoTenDonVi(cmbDonViTinhThuoc.getSelectedItem().toString());
					cd = cachdungDAO.timCachDungTheoTenCachDung(cmbCachDung.getSelectedItem().toString());
					t.setDv(dv);
					t.setCd(cd);
					try {
						if (DAO.thuocDAO.themThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "Đã thêm thuốc: " + txtMaThuoc.getText());
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtSoLuongThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc
									.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							cmbCachDung.setModel(new CachDungComboModel(DAO.cachdungDAO.LayDanhSachCachDung()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnThemThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemThuoc.setForeground(Color.RED);
		btnThemThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemThuoc.setBounds(164, 267, 115, 41);
		pnThuoc.add(btnThemThuoc);

		JButton btnCapNhatThuoc = new JButton("Cập nhật");
		btnCapNhatThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("") || txtSoLuongThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn thuốc cần cập nhật!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else if (validate.isWord(txtDonGiaThuoc.getText()) == true
						|| validate.isNumber(txtSoLuongThuoc.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Đơn giá, sô lượng chỉ được nhập số!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					cachdung cd = new cachdung();
					ArrayList<thuoc> allT = ThuocModel.listT;
					for (int i = 0; i < allT.size(); i++) {
						if (index == allT.get(i).getID()) {
							t.setID(allT.get(i).getID());
							t.setMaThuoc(txtMaThuoc.getText());
							t.setTenThuoc(txtTenThuoc.getText());
							t.setSoLuong(Integer.parseInt(txtSoLuongThuoc.getText()));
							t.setDonGia(Double.parseDouble(txtDonGiaThuoc.getText()));
							t.setTinhTrang(1);
							dv = donvithuocDAO.timDonViTheoTenDonVi(cmbDonViTinhThuoc.getSelectedItem().toString());
							cd = cachdungDAO.timCachDungTheoTenCachDung(cmbCachDung.getSelectedItem().toString());
							t.setDv(dv);
							t.setCd(cd);
						}
					}
					try {
						if (thuocDAO.suaThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtSoLuongThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc
									.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							cmbCachDung.setModel(new CachDungComboModel(DAO.cachdungDAO.LayDanhSachCachDung()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null,
									"Cập nhật thất bại, vui lòng click bảng chọn thuốc cần cập nhật!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatThuoc.setForeground(Color.RED);
		btnCapNhatThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatThuoc.setBounds(335, 267, 140, 41);
		pnThuoc.add(btnCapNhatThuoc);

		JButton btnXoaThuoc = new JButton("Xóa");
		btnXoaThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn thuốc cần xóa!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					cachdung cd = new cachdung();
					ArrayList<thuoc> allT = ThuocModel.listT;
					for (int i = 0; i < allT.size(); i++) {
						if (index == allT.get(i).getID()) {
							t.setID(allT.get(i).getID());
							t.setMaThuoc(allT.get(i).getMaThuoc());
							t.setTenThuoc(allT.get(i).getTenThuoc());
							t.setSoLuong(allT.get(i).getSoLuong());
							t.setDonGia(allT.get(i).getDonGia());
							t.setTinhTrang(0);
							t.setDv(allT.get(i).getDv());
							t.setCd(allT.get(i).getCd());
						}
					}
					try {
						if (thuocDAO.suaThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "Xóa thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtSoLuongThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc
									.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							cmbCachDung.setModel(new CachDungComboModel(DAO.cachdungDAO.LayDanhSachCachDung()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null, "Xóa thất bại!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnXoaThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
		btnXoaThuoc.setForeground(Color.RED);
		btnXoaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoaThuoc.setBounds(518, 267, 103, 41);
		pnThuoc.add(btnXoaThuoc);

		JButton btnLoadThuoc = new JButton("Load");
		btnLoadThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDThuoc.setText(null);
				txtMaThuoc.setText(null);
				txtTenThuoc.setText(null);
				txtSoLuongThuoc.setText(null);
				txtDonGiaThuoc.setText(null);
				cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
				cmbCachDung.setModel(new CachDungComboModel(DAO.cachdungDAO.LayDanhSachCachDung()));
				ThuocModel mdT = new ThuocModel();
				tableThuoc.setModel(mdT);
			}
		});
		btnLoadThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadThuoc.setForeground(Color.RED);
		btnLoadThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadThuoc.setBounds(676, 267, 109, 41);
		pnThuoc.add(btnLoadThuoc);

		tableThuoc = new JTable();
		ThuocModel modelT = new ThuocModel();
		tableThuoc.setModel(modelT);
		JScrollPane scrollPaneT = new JScrollPane(tableThuoc);// dan table vao khung jsp
		scrollPaneT.setBounds(103, 352, 739, 179);
		pnThuoc.add(scrollPaneT);

		JButton btnDangXuatT = new JButton("");
		btnDangXuatT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuatT.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatT.setToolTipText("Đăng xuất");
		btnDangXuatT.setForeground(Color.RED);
		btnDangXuatT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatT.setBounds(908, 0, 42, 42);
		pnThuoc.add(btnDangXuatT);

		JLabel lblCchDng = new JLabel("Cách dùng\r\n");
		lblCchDng.setForeground(Color.BLUE);
		lblCchDng.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCchDng.setBounds(505, 183, 103, 27);
		pnThuoc.add(lblCchDng);

		JLabel lblSLng = new JLabel("Số lượng");
		lblSLng.setForeground(Color.BLUE);
		lblSLng.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSLng.setBounds(103, 183, 103, 27);
		pnThuoc.add(lblSLng);

		txtSoLuongThuoc = new JTextField();
		txtSoLuongThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSoLuongThuoc.setColumns(10);
		txtSoLuongThuoc.setBounds(226, 183, 170, 25);
		pnThuoc.add(txtSoLuongThuoc);

		tableThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableThuoc.getSelectedRow() >= 0) {
					lblIDThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 0).toString());
					txtMaThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 1).toString());
					txtTenThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 2).toString());
					txtSoLuongThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 3).toString());
					txtDonGiaThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 4).toString());
					cmbDonViTinhThuoc.setSelectedItem(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 5).toString());
					cmbCachDung.setSelectedItem(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 6).toString());
					index = Integer.parseInt(lblIDThuoc.getText());
				}
			}
		});

		// ql Don vi thuoc
		JPanel pnDonViThuoc = new JPanel();
		tabbedPane.addTab("Đơn Vị Thuốc", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\donvithuoc.jpg"),
				pnDonViThuoc, null);
		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
		pnDonViThuoc.setLayout(null);

		JLabel lblQunLn = new JLabel("QUẢN LÝ ĐƠN VỊ THUỐC");
		lblQunLn.setForeground(Color.RED);
		lblQunLn.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLn.setBounds(365, 11, 244, 35);
		pnDonViThuoc.add(lblQunLn);

		JLabel lblIdnV = new JLabel("ID đơn vị");
		lblIdnV.setForeground(Color.BLUE);
		lblIdnV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdnV.setBounds(304, 78, 103, 27);
		pnDonViThuoc.add(lblIdnV);

		JLabel lblIDDonViThuoc = new JLabel("ID Don vi");
		lblIDDonViThuoc.setForeground(Color.BLUE);
		lblIDDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDDonViThuoc.setBounds(470, 78, 103, 27);
		pnDonViThuoc.add(lblIDDonViThuoc);

		JLabel lblMaDonViThuoc = new JLabel("Mã đơn vị");
		lblMaDonViThuoc.setForeground(Color.BLUE);
		lblMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaDonViThuoc.setBounds(304, 116, 123, 27);
		pnDonViThuoc.add(lblMaDonViThuoc);

		txtMaDonViThuoc = new JTextField();
		txtMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaDonViThuoc.setColumns(10);
		txtMaDonViThuoc.setBounds(470, 116, 170, 25);
		pnDonViThuoc.add(txtMaDonViThuoc);

		JLabel lblTenDonViThuoc = new JLabel("Tên đơn vị");
		lblTenDonViThuoc.setForeground(Color.BLUE);
		lblTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenDonViThuoc.setBounds(304, 154, 123, 27);
		pnDonViThuoc.add(lblTenDonViThuoc);

		txtTenDonViThuoc = new JTextField();
		txtTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDonViThuoc.setColumns(10);
		txtTenDonViThuoc.setBounds(470, 154, 170, 25);
		pnDonViThuoc.add(txtTenDonViThuoc);

		JButton tbnThemDonViThuoc = new JButton("Thêm");
		tbnThemDonViThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DAO.donvithuocDAO.laySoDong() == DAO.quydinh2DAO.laySoDonVi(1)) {
					JOptionPane.showMessageDialog(null,
							"Vượt quá " + DAO.quydinh2DAO.laySoDonVi(1) + " đơn vị.Không thêm được!");
				} else if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else if (donvithuocDAO.timMaDonVi(txtMaDonViThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Mã đơn vị thuốc đã tồn tại!");
				} else {
					donvi dv = new donvi();
					dv.setMaDonVi(txtMaDonViThuoc.getText());
					dv.setTenDonVi(txtTenDonViThuoc.getText());
					try {
						if (DAO.donvithuocDAO.themDonViThuoc(dv) == true) {
							JOptionPane.showMessageDialog(null, "Đã thêm đơn vị thuốc: " + txtMaDonViThuoc.getText());
							lblIDDonViThuoc.setText(null);
							txtMaDonViThuoc.setText(null);
							txtTenDonViThuoc.setText(null);
							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
							tableDonViThuoc.setModel(mdDonVi);
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		tbnThemDonViThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		tbnThemDonViThuoc.setForeground(Color.RED);
		tbnThemDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		tbnThemDonViThuoc.setBounds(237, 233, 115, 41);
		pnDonViThuoc.add(tbnThemDonViThuoc);

		JButton btnCapNhatDonViThuoc = new JButton("Cập nhật");
		btnCapNhatDonViThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn đơn vị thuốc cần cập nhật!",
							"WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					donvi dv = new donvi();
					ArrayList<donvi> aldv = DonViTinhThuocModelqlt.listDV;
					for (int i = 0; i < aldv.size(); i++) {
						if (index == aldv.get(i).getID()) {
							dv.setID(aldv.get(i).getID());
							dv.setMaDonVi(txtMaDonViThuoc.getText());
							dv.setTenDonVi(txtTenDonViThuoc.getText());
						}
					}
					try {
						if (donvithuocDAO.suaDonViThuoc(dv) == true) {
							JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDDonViThuoc.setText(null);
							txtMaDonViThuoc.setText(null);
							txtTenDonViThuoc.setText(null);
							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
							tableDonViThuoc.setModel(mdDonVi);
						} else {
							JOptionPane.showMessageDialog(null,
									"Cập nhật thất bại, Click bảng chọn đơn vị thuốc cần cập nhật!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Loi nhap sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatDonViThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatDonViThuoc.setForeground(Color.RED);
		btnCapNhatDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatDonViThuoc.setBounds(417, 233, 140, 41);
		pnDonViThuoc.add(btnCapNhatDonViThuoc);

		JButton btnLoadDonViThuoc = new JButton("Load");
		btnLoadDonViThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDDonViThuoc.setText(null);
				txtMaDonViThuoc.setText(null);
				txtTenDonViThuoc.setText(null);
				DonViTinhThuocModelqlt modelDonViThuoc = new DonViTinhThuocModelqlt();
				tableDonViThuoc.setModel(modelDonViThuoc);
			}
		});
		btnLoadDonViThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadDonViThuoc.setForeground(Color.RED);
		btnLoadDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadDonViThuoc.setBounds(614, 233, 109, 41);
		pnDonViThuoc.add(btnLoadDonViThuoc);

		// táº¡o table
		tableDonViThuoc = new JTable();
		DonViTinhThuocModelqlt modelDonViThuoc = new DonViTinhThuocModelqlt();
		tableDonViThuoc.setModel(modelDonViThuoc);
		JScrollPane scrollPane1 = new JScrollPane(tableDonViThuoc);// dan table vao khung jsp
		scrollPane1.setBounds(237, 325, 486, 169);
		// tableDonViThuoc.setBounds(163, 325, 486, 169);
		pnDonViThuoc.add(scrollPane1);

		JButton btnDangXuatDVT = new JButton("");
		btnDangXuatDVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuatDVT.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatDVT.setToolTipText("Đăng xuất");
		btnDangXuatDVT.setForeground(Color.RED);
		btnDangXuatDVT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatDVT.setBounds(908, 0, 42, 42);
		pnDonViThuoc.add(btnDangXuatDVT);
		// pnDonViThuoc.add(tableDonViThuoc);
		tableDonViThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableDonViThuoc.getSelectedRow() >= 0) {
					lblIDDonViThuoc.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 0).toString());
					txtMaDonViThuoc.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 1).toString());
					txtTenDonViThuoc
							.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 2).toString());
					index = Integer.parseInt(lblIDDonViThuoc.getText());
				}
			}
		});

		// ql cach dung
		JPanel pnCachDung = new JPanel();
		tabbedPane.addTab("Cách Dùng", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\huongdan.png"),
				pnCachDung, null);
		tabbedPane.setBackgroundAt(5, new Color(255, 255, 255));
		pnCachDung.setLayout(null);

		JLabel lblQunLCch = new JLabel("QUẢN LÝ CÁCH DÙNG");
		lblQunLCch.setForeground(Color.RED);
		lblQunLCch.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLCch.setBounds(357, 11, 220, 35);
		pnCachDung.add(lblQunLCch);

		JLabel lblIdCD = new JLabel("ID cách dùng");
		lblIdCD.setForeground(Color.BLUE);
		lblIdCD.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdCD.setBounds(303, 78, 103, 27);
		pnCachDung.add(lblIdCD);

		JLabel lblIDCachDung = new JLabel("ID cach dung");
		lblIDCachDung.setForeground(Color.BLUE);
		lblIDCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDCachDung.setBounds(483, 80, 103, 27);
		pnCachDung.add(lblIDCachDung);

		JLabel lblMaCachDungThuoc = new JLabel("Mã cách dùng thuốc");
		lblMaCachDungThuoc.setForeground(Color.BLUE);
		lblMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaCachDungThuoc.setBounds(303, 116, 170, 27);
		pnCachDung.add(lblMaCachDungThuoc);

		txtMaCachDungThuoc = new JTextField();
		txtMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaCachDungThuoc.setColumns(10);
		txtMaCachDungThuoc.setBounds(483, 118, 170, 25);
		pnCachDung.add(txtMaCachDungThuoc);

		txtTenCachDungThuoc = new JTextField();
		txtTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenCachDungThuoc.setColumns(10);
		txtTenCachDungThuoc.setBounds(483, 156, 170, 25);
		pnCachDung.add(txtTenCachDungThuoc);

		JButton btnThemCachDung = new JButton("Thêm");
		btnThemCachDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (DAO.cachdungDAO.laySoDong() == DAO.quydinh2DAO.laySoCachDung(1)) {
					JOptionPane.showMessageDialog(null,
							"Vượt quá " + DAO.quydinh2DAO.laySoCachDung(1) + " cách dùng. Không thêm được!");
				} else if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
				} else if (cachdungDAO.timMaCachDung(txtMaCachDungThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "Mã cách dùng đã tồn tại!");
				} else {
					cachdung cd = new cachdung();
					cd.setMaCachDung(txtMaCachDungThuoc.getText());
					cd.setTenCachDung(txtTenCachDungThuoc.getText());
					try {
						if (DAO.cachdungDAO.themCachDung(cd) == true) {
							JOptionPane.showMessageDialog(null,
									"Đã thêm cách dùng thuốc: " + txtMaCachDungThuoc.getText());
							lblIDCachDung.setText(null);
							txtMaCachDungThuoc.setText(null);
							txtTenCachDungThuoc.setText(null);
							CachDungModel mdCachDung = new CachDungModel();
							tableCachDungThuoc.setModel(mdCachDung);
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnThemCachDung.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemCachDung.setForeground(Color.RED);
		btnThemCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemCachDung.setBounds(235, 233, 115, 41);
		pnCachDung.add(btnThemCachDung);

		JButton btnCapNhatCachDung = new JButton("Cập nhật");
		btnCapNhatCachDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn cách dùng cần cập nhật!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					cachdung cd = new cachdung();
					ArrayList<cachdung> alcd = CachDungModel.listCD;
					for (int i = 0; i < alcd.size(); i++) {
						if (index == i) {
							cd.setID(alcd.get(i).getID());
							cd.setMaCachDung(txtMaCachDungThuoc.getText());
							cd.setTenCachDung(txtTenCachDungThuoc.getText());
						}
					}
					try {
						if (cachdungDAO.suaCachDung(cd) == true) {
							JOptionPane.showMessageDialog(null, "Sửa thành công!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDCachDung.setText(null);
							txtMaCachDungThuoc.setText(null);
							txtTenCachDungThuoc.setText(null);
							CachDungModel mdCachDung = new CachDungModel();
							tableCachDungThuoc.setModel(mdCachDung);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sửa thất bại, vui lòng click bảng chọn cách dùng cần sửa!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatCachDung.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatCachDung.setForeground(Color.RED);
		btnCapNhatCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatCachDung.setBounds(415, 233, 140, 41);
		pnCachDung.add(btnCapNhatCachDung);

		JButton btnLoadCachDung = new JButton("Load");
		btnLoadCachDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDCachDung.setText(null);
				txtMaCachDungThuoc.setText(null);
				txtTenCachDungThuoc.setText(null);
				CachDungModel modelCachDung = new CachDungModel();
				tableCachDungThuoc.setModel(modelCachDung);
			}
		});
		btnLoadCachDung.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadCachDung.setForeground(Color.RED);
		btnLoadCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadCachDung.setBounds(612, 233, 109, 41);
		pnCachDung.add(btnLoadCachDung);

		tableCachDungThuoc = new JTable();
		CachDungModel modelCD = new CachDungModel();
		tableCachDungThuoc.setModel(modelCD);
		JScrollPane scrollPaneCD = new JScrollPane(tableCachDungThuoc);// dan table vao khung jsp
		scrollPaneCD.setBounds(232, 325, 486, 169);
		pnCachDung.add(scrollPaneCD);
		tableCachDungThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableCachDungThuoc.getSelectedRow() >= 0) {
					lblIDCachDung
							.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 0).toString());
					txtMaCachDungThuoc
							.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 1).toString());
					txtTenCachDungThuoc
							.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 2).toString());
					index = Integer.parseInt(lblIDCachDung.getText());
				}
			}
		});

		JLabel lblTenCachDungThuoc = new JLabel("Tên cách dùng thuốc");
		lblTenCachDungThuoc.setForeground(Color.BLUE);
		lblTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenCachDungThuoc.setBounds(303, 154, 170, 27);
		pnCachDung.add(lblTenCachDungThuoc);

		JButton btnDangXuatCD = new JButton("");
		btnDangXuatCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuatCD.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatCD.setToolTipText("Đăng xuất");
		btnDangXuatCD.setForeground(Color.RED);
		btnDangXuatCD.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatCD.setBounds(908, 0, 42, 42);
		pnCachDung.add(btnDangXuatCD);
		// Load mac dinh table khi khoi dong
		QuyDinh1Model modelQuyDinh = new QuyDinh1Model();

		// ql quy dinh
		JPanel pnQuyDinh = new JPanel();
		tabbedPane.addTab("Quy Định\r\n", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\quidinh.png"),
				pnQuyDinh, null);
		tabbedPane.setBackgroundAt(6, new Color(255, 255, 255));
		pnQuyDinh.setLayout(null);

		JLabel lblQunLQuy = new JLabel("QUẢN LÝ QUY ĐỊNH");
		lblQunLQuy.setForeground(Color.RED);
		lblQunLQuy.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLQuy.setBounds(357, 11, 201, 35);
		pnQuyDinh.add(lblQunLQuy);

		JLabel lblIdQuynh = new JLabel("ID quy định");
		lblIdQuynh.setForeground(Color.BLUE);
		lblIdQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdQuynh.setBounds(316, 103, 103, 27);
		pnQuyDinh.add(lblIdQuynh);

		JLabel lblIDQuyDinh = new JLabel("ID quy định");
		lblIDQuyDinh.setForeground(Color.BLUE);
		lblIDQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDQuyDinh.setBounds(447, 105, 103, 27);
		pnQuyDinh.add(lblIDQuyDinh);

		JLabel lblMQuynh = new JLabel("Mã quy định");
		lblMQuynh.setForeground(Color.BLUE);
		lblMQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMQuynh.setBounds(316, 141, 170, 27);
		pnQuyDinh.add(lblMQuynh);

		txtMaQuyDinh = new JTextField();
		txtMaQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaQuyDinh.setColumns(10);
		txtMaQuyDinh.setBounds(447, 143, 170, 25);
		pnQuyDinh.add(txtMaQuyDinh);

		JLabel lblTenQuyDinh = new JLabel("Tên quy định");
		lblTenQuyDinh.setForeground(Color.BLUE);
		lblTenQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenQuyDinh.setBounds(316, 179, 170, 27);
		pnQuyDinh.add(lblTenQuyDinh);

		txtTenQuyDinh = new JTextField();
		txtTenQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenQuyDinh.setColumns(10);
		txtTenQuyDinh.setBounds(447, 181, 170, 25);
		pnQuyDinh.add(txtTenQuyDinh);

		JLabel lblGiaTri = new JLabel("Giá trị");
		lblGiaTri.setForeground(Color.BLUE);
		lblGiaTri.setFont(new Font("Arial", Font.PLAIN, 17));
		lblGiaTri.setBounds(316, 217, 170, 27);
		pnQuyDinh.add(lblGiaTri);

		txtGiaTri = new JTextField();
		txtGiaTri.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGiaTri.setColumns(10);
		txtGiaTri.setBounds(447, 219, 170, 25);
		pnQuyDinh.add(txtGiaTri);

		txtSoDonVi = new JTextField();
		txtSoDonVi.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSoDonVi.setColumns(10);
		txtSoDonVi.setBounds(447, 257, 170, 25);
		pnQuyDinh.add(txtSoDonVi);
		txtSoDonVi.setVisible(false);

		lblSoDonVi = new JLabel("Số đơn vị");
		lblSoDonVi.setForeground(Color.BLUE);
		lblSoDonVi.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSoDonVi.setBounds(316, 255, 170, 27);
		pnQuyDinh.add(lblSoDonVi);
		lblSoDonVi.setVisible(false);

		lblSoCachDung = new JLabel("Số cách dùng");
		lblSoCachDung.setForeground(Color.BLUE);
		lblSoCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSoCachDung.setBounds(316, 293, 170, 27);
		pnQuyDinh.add(lblSoCachDung);
		lblSoCachDung.setVisible(false);

		txtSoCachDung = new JTextField();
		txtSoCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSoCachDung.setColumns(10);
		txtSoCachDung.setBounds(447, 295, 170, 25);
		pnQuyDinh.add(txtSoCachDung);
		txtSoCachDung.setVisible(false);

		JButton btnThemQuyDinhThuoc = new JButton("Thêm");
		btnThemQuyDinhThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cmbQuyDinh.getSelectedIndex() == 0) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
							|| txtGiaTri.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else if (validate.isNumber(txtGiaTri.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Giá trị chỉ được nhập số!", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else if (quydinh1DAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null) {
						JOptionPane.showMessageDialog(null, "Mã quy định đã tồn tại!");
					} else {
						quydinh1 qd = new quydinh1();
						qd.setMaQuyDinh(txtMaQuyDinh.getText());
						qd.setTenQuyDinh(txtTenQuyDinh.getText());
						qd.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
						try {
							if (DAO.quydinh1DAO.themQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Đã thêm quy định: " + txtMaQuyDinh.getText());
								lblIDQuyDinh.setText(null);
								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(0);
								QuyDinh1Model mdQuyDinh = new QuyDinh1Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} else if (cmbQuyDinh.getSelectedIndex() == 1) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
							|| txtGiaTri.getText().equals("") || txtSoDonVi.getText().equals("")
							|| txtSoCachDung.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else if (validate.isNumber(txtTenQuyDinh.getText()) == false
							|| validate.isNumber(txtGiaTri.getText()) == false
							|| validate.isNumber(txtSoDonVi.getText()) == false
							|| validate.isNumber(txtSoCachDung.getText()) == false) {
						JOptionPane.showMessageDialog(null,
								"Số loại bệnh, số loại thuốc, số đơn vị, số cách dùng chỉ được nhập số!", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else if (quydinh2DAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null) {
						JOptionPane.showMessageDialog(null, "Mã quy định đã tồn tại!");
					} else {
						quydinh2 qd = new quydinh2();
						qd.setMaQuyDinh(txtMaQuyDinh.getText());
						qd.setSoLoaiBenh(Integer.parseInt(txtTenQuyDinh.getText()));
						qd.setSoLoaiThuoc(Integer.parseInt(txtGiaTri.getText()));
						qd.setSoDonVi(Integer.parseInt(txtSoDonVi.getText()));
						qd.setSoCachDung(Integer.parseInt(txtSoCachDung.getText()));
						try {
							if (DAO.quydinh2DAO.themQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Đã thêm quy định: " + txtMaQuyDinh.getText());
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Số loại bệnh");
								lblGiaTri.setText("Số loại thuốc");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);
								txtGiaTri.setVisible(true);

								lblSoDonVi.setVisible(true);
								txtSoDonVi.setVisible(true);
								txtSoDonVi.setText(null);

								lblGiaTri.setVisible(true);
								lblSoCachDung.setVisible(true);
								txtSoCachDung.setVisible(true);
								txtSoCachDung.setText(null);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(1);
								QuyDinh2Model mdQuyDinh = new QuyDinh2Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} else if (cmbQuyDinh.getSelectedIndex() == 2) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
							|| txtGiaTri.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else if (quydinh2DAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null) {
						JOptionPane.showMessageDialog(null, "Mã quy định đã tồn tại!");
					} else {
						quydinh4 qd = new quydinh4();
						qd.setMaQuyDinh(txtMaQuyDinh.getText());
						qd.setTenQuyDinh(txtTenQuyDinh.getText());
						qd.setGiaTri(Double.parseDouble(txtGiaTri.getText()));
						try {
							if (DAO.quydinh4DAO.themQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Đã thêm quy định: " + txtMaQuyDinh.getText());
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Tên quy định");
								lblGiaTri.setText("Giá trị");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);

//								lblGiaTri.setVisible(false);
//								txtGiaTri.setVisible(false);
								lblSoDonVi.setVisible(false);
								txtSoDonVi.setVisible(false);
								lblSoCachDung.setVisible(false);
								txtSoCachDung.setVisible(false);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(2);
								QuyDinh4Model mdQuyDinh = new QuyDinh4Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				} else if (cmbQuyDinh.getSelectedIndex() == 3) {

					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin!");
					} else if (quydinh2DAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null) {
						JOptionPane.showMessageDialog(null, "Mã quy định đã tồn tại!");
					} else {
						quydinh6 qd = new quydinh6();
						qd.setMaQuyDinh(txtMaQuyDinh.getText());
						qd.setTenQuyDinh(txtTenQuyDinh.getText());
						try {
							if (DAO.quydinh6DAO.themQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Đã thêm quy định: " + txtMaQuyDinh.getText());
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Tên quy định");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);

								lblGiaTri.setVisible(false);
								txtGiaTri.setVisible(false);
								lblSoDonVi.setVisible(false);
								txtSoDonVi.setVisible(false);
								lblSoCachDung.setVisible(false);
								txtSoCachDung.setVisible(false);

								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(3);
								QuyDinh6Model mdQuyDinh = new QuyDinh6Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}

					}
				}

			}
		});
		btnThemQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemQuyDinhThuoc.setForeground(Color.RED);
		btnThemQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemQuyDinhThuoc.setBounds(226, 331, 115, 41);
		pnQuyDinh.add(btnThemQuyDinhThuoc);

		JButton btnCapNhatQuyDinhThuoc = new JButton("Cập nhật");
		btnCapNhatQuyDinhThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbQuyDinh.getSelectedIndex() == 0) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
							|| txtGiaTri.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn quy định cần cập nhật!",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else if (validate.isNumber(txtGiaTri.getText()) == false) {
						JOptionPane.showMessageDialog(null, "Giá trị chỉ được nhập số!", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else {
						quydinh1 qd = new quydinh1();
						ArrayList<quydinh1> alqd = QuyDinh1Model.listQD;
						for (int i = 0; i < alqd.size(); i++) {
							if (index == alqd.get(i).getID()) {
								qd.setID(alqd.get(i).getID());
								qd.setMaQuyDinh(txtMaQuyDinh.getText());
								qd.setTenQuyDinh(txtTenQuyDinh.getText());
								qd.setGiaTri(Integer.parseInt(txtGiaTri.getText()));
							}
						}
						try {
							if (quydinh1DAO.suaQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
								lblIDQuyDinh.setText(null);
								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(0);
								QuyDinh1Model mdQuyDinh = new QuyDinh1Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null,
										"Cập nhật thất bại, click bảng chọn quy định cần cập nhật!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (cmbQuyDinh.getSelectedIndex() == 1) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
							|| txtGiaTri.getText().equals("") || txtSoDonVi.getText().equals("")
							|| txtSoCachDung.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn quy định cần cập nhật!",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else if (validate.isNumber(txtTenQuyDinh.getText()) == false
							|| validate.isNumber(txtGiaTri.getText()) == false
							|| validate.isNumber(txtSoDonVi.getText()) == false
							|| validate.isNumber(txtSoCachDung.getText()) == false) {
						JOptionPane.showMessageDialog(null,
								"Số loại bệnh, số loại thuốc, số đơn vị, số cách dùng chỉ được nhập số!", "WARNING",
								JOptionPane.WARNING_MESSAGE);
					} else {
						quydinh2 qd = new quydinh2();
						ArrayList<quydinh2> alqd = QuyDinh2Model.listQD;
						for (int i = 0; i < alqd.size(); i++) {
							if (index == alqd.get(i).getID()) {
								qd.setID(alqd.get(i).getID());
								qd.setMaQuyDinh(txtMaQuyDinh.getText());
								qd.setSoLoaiBenh(Integer.parseInt(txtTenQuyDinh.getText()));
								qd.setSoLoaiThuoc(Integer.parseInt(txtGiaTri.getText()));
								qd.setSoDonVi(Integer.parseInt(txtSoDonVi.getText()));
								qd.setSoCachDung(Integer.parseInt(txtSoCachDung.getText()));
							}
						}
						try {
							if (quydinh2DAO.suaQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Số loại bệnh");
								lblGiaTri.setText("Số loại thuốc");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);
								txtGiaTri.setVisible(true);

								lblSoDonVi.setVisible(true);
								txtSoDonVi.setVisible(true);
								txtSoDonVi.setText(null);

								lblGiaTri.setVisible(true);
								lblSoCachDung.setVisible(true);
								txtSoCachDung.setVisible(true);
								txtSoCachDung.setText(null);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(1);
								QuyDinh2Model mdQuyDinh = new QuyDinh2Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null,
										"Cập nhật thất bại, click bảng chọn quy định cần cập nhật!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (cmbQuyDinh.getSelectedIndex() == 2) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn quy định cần cập nhật!",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else {
						quydinh4 qd = new quydinh4();
						ArrayList<quydinh4> alqd = QuyDinh4Model.listQD;
						for (int i = 0; i < alqd.size(); i++) {
							if (index == alqd.get(i).getID()) {
								qd.setID(alqd.get(i).getID());
								qd.setMaQuyDinh(txtMaQuyDinh.getText());
								qd.setTenQuyDinh(txtTenQuyDinh.getText());
								qd.setGiaTri(Double.parseDouble(txtGiaTri.getText()));
							}
						}
						try {
							if (quydinh4DAO.suaQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Tên quy định");
								lblGiaTri.setText("Giá trị");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);
								txtGiaTri.setText(null);

//								lblGiaTri.setVisible(false);
//								txtGiaTri.setVisible(false);
								lblSoDonVi.setVisible(false);
								txtSoDonVi.setVisible(false);
								lblSoCachDung.setVisible(false);
								txtSoCachDung.setVisible(false);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(2);
								QuyDinh4Model mdQuyDinh = new QuyDinh4Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null,
										"Cập nhật thất bại, click bảng chọn quy định cần cập nhật!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
				} else if (cmbQuyDinh.getSelectedIndex() == 3) {
					if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng click bảng chọn quy định cần cập nhật!",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					} else {
						quydinh6 qd = new quydinh6();
						ArrayList<quydinh6> alqd = QuyDinh6Model.listQD;
						for (int i = 0; i < alqd.size(); i++) {
							if (index == alqd.get(i).getID()) {
								qd.setID(alqd.get(i).getID());
								qd.setMaQuyDinh(txtMaQuyDinh.getText());
								qd.setTenQuyDinh(txtTenQuyDinh.getText());
							}
						}
						try {
							if (quydinh6DAO.suaQuyDinh(qd) == true) {
								JOptionPane.showMessageDialog(null, "Cập nhật thành công!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
								lblIDQuyDinh.setText("ID quy định");
								lblTenQuyDinh.setText("Tên quy định");

								txtMaQuyDinh.setText(null);
								txtTenQuyDinh.setText(null);

								lblGiaTri.setVisible(false);
								txtGiaTri.setVisible(false);
								lblSoDonVi.setVisible(false);
								txtSoDonVi.setVisible(false);
								lblSoCachDung.setVisible(false);
								txtSoCachDung.setVisible(false);
								cmbQuyDinh.setModel(new DefaultComboBoxModel(
										new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
								cmbQuyDinh.setSelectedIndex(2);
								QuyDinh6Model mdQuyDinh = new QuyDinh6Model();
								tableQuyDinhThuoc.setModel(mdQuyDinh);
							} else {
								JOptionPane.showMessageDialog(null,
										"Cập nhật thất bại, click bảng chọn quy định cần cập nhật!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
					// ----------------------------------
				}
			}
		});
		btnCapNhatQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatQuyDinhThuoc.setForeground(Color.RED);
		btnCapNhatQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatQuyDinhThuoc.setBounds(406, 331, 140, 41);
		pnQuyDinh.add(btnCapNhatQuyDinhThuoc);

		JButton btnLoadQuyDinhThuoc = new JButton("Load");
		btnLoadQuyDinhThuoc.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				lblIDQuyDinh.setText("ID quy định");
				lblTenQuyDinh.setText("Tên quy định");
				lblGiaTri.setText("Giá trị");
				txtMaQuyDinh.setText(null);
				txtTenQuyDinh.setText(null);
				txtGiaTri.setText(null);

				lblGiaTri.setText("Giá trị");
				lblGiaTri.setVisible(true);
				txtGiaTri.setText(null);
				txtGiaTri.setVisible(true);

				lblSoDonVi.setVisible(false);
				txtSoDonVi.setVisible(false);
				lblSoCachDung.setVisible(false);
				txtSoCachDung.setVisible(false);
				cmbQuyDinh.setModel(new DefaultComboBoxModel(
						new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
				QuyDinh1Model modelQuyDinh = new QuyDinh1Model();
				tableQuyDinhThuoc.setModel(modelQuyDinh);
			}
		});
		btnLoadQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadQuyDinhThuoc.setForeground(Color.RED);
		btnLoadQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadQuyDinhThuoc.setBounds(603, 331, 109, 41);
		pnQuyDinh.add(btnLoadQuyDinhThuoc);

		tableQuyDinhThuoc = new JTable();
		tableQuyDinhThuoc.setModel(modelQuyDinh);
		JScrollPane scrollPaneQD = new JScrollPane(tableQuyDinhThuoc);// dan table vao khung jsp
		scrollPaneQD.setBounds(159, 384, 610, 169);
		pnQuyDinh.add(scrollPaneQD);

		JButton btnDangXuatQD = new JButton("");
		btnDangXuatQD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
//				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
					dangnhap dn = new dangnhap();
					dn.setVisible(true);
					dn.setLocationRelativeTo(null); // canh giữa màn hình
				}
			}
		});
		btnDangXuatQD.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatQD.setToolTipText("Đăng xuất");
		btnDangXuatQD.setForeground(Color.RED);
		btnDangXuatQD.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatQD.setBounds(908, 0, 42, 42);
		pnQuyDinh.add(btnDangXuatQD);

		JLabel lblLoiQuynh = new JLabel("Loại quy định");
		lblLoiQuynh.setForeground(Color.BLUE);
		lblLoiQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblLoiQuynh.setBounds(316, 70, 103, 27);
		pnQuyDinh.add(lblLoiQuynh);

		cmbQuyDinh = new JComboBox();
		cmbQuyDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (cmbQuyDinh.getSelectedIndex() == 0) {
					lblIDQuyDinh.setText("ID quy định");
					lblTenQuyDinh.setText("Tên quy định");
					lblGiaTri.setText("Giá trị");
					txtMaQuyDinh.setText(null);
					txtTenQuyDinh.setText(null);
					txtGiaTri.setText(null);

					lblGiaTri.setText("Giá trị");
					lblGiaTri.setVisible(true);
					txtGiaTri.setText(null);
					txtGiaTri.setVisible(true);

					lblSoDonVi.setVisible(false);
					txtSoDonVi.setVisible(false);
					lblSoCachDung.setVisible(false);
					txtSoCachDung.setVisible(false);

					QuyDinh1Model mdQuyDinh = new QuyDinh1Model();
					tableQuyDinhThuoc.setModel(mdQuyDinh);
				} else if (cmbQuyDinh.getSelectedIndex() == 1) {

					lblIDQuyDinh.setText("ID quy định");
					lblTenQuyDinh.setText("Số loại bệnh");
					lblGiaTri.setText("Số loại thuốc");

					txtMaQuyDinh.setText(null);
					txtTenQuyDinh.setText(null);
					txtGiaTri.setText(null);
					txtGiaTri.setVisible(true);

					lblSoDonVi.setVisible(true);
					txtSoDonVi.setVisible(true);
					txtSoDonVi.setText(null);

					lblGiaTri.setVisible(true);
					lblSoCachDung.setVisible(true);
					txtSoCachDung.setVisible(true);
					txtSoCachDung.setText(null);

					QuyDinh2Model mdQuyDinh = new QuyDinh2Model();
					tableQuyDinhThuoc.setModel(mdQuyDinh);
				} else if (cmbQuyDinh.getSelectedIndex() == 2) {
					lblIDQuyDinh.setText("ID quy định");
					lblTenQuyDinh.setText("Tên quy định");
					lblGiaTri.setText("Giá trị");

					txtMaQuyDinh.setText(null);
					txtTenQuyDinh.setText(null);
					txtGiaTri.setText(null);

					lblGiaTri.setVisible(true);
					txtGiaTri.setVisible(true);
					lblSoDonVi.setVisible(false);
					txtSoDonVi.setVisible(false);
					lblSoCachDung.setVisible(false);
					txtSoCachDung.setVisible(false);

					QuyDinh4Model mdQuyDinh = new QuyDinh4Model();
					tableQuyDinhThuoc.setModel(mdQuyDinh);

				} else if (cmbQuyDinh.getSelectedIndex() == 3) {
					lblIDQuyDinh.setText("ID quy định");
					lblTenQuyDinh.setText("Tên quy định");

					txtMaQuyDinh.setText(null);
					txtTenQuyDinh.setText(null);

					lblGiaTri.setVisible(false);
					txtGiaTri.setVisible(false);
					lblSoDonVi.setVisible(false);
					txtSoDonVi.setVisible(false);
					lblSoCachDung.setVisible(false);
					txtSoCachDung.setVisible(false);

					QuyDinh6Model mdQuyDinh = new QuyDinh6Model();
					tableQuyDinhThuoc.setModel(mdQuyDinh);
				}
			}

		});
		cmbQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbQuyDinh.setModel(
				new DefaultComboBoxModel(new String[] { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" }));
		cmbQuyDinh.setBounds(447, 71, 170, 25);
		pnQuyDinh.add(cmbQuyDinh);

		tableQuyDinhThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				if (cmbQuyDinh.getSelectedIndex() == 0 && tableQuyDinhThuoc.getSelectedRow() >= 0) {
					lblIDQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
					txtMaQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
					txtTenQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
					txtGiaTri.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 3).toString());
					index = Integer.parseInt(lblIDQuyDinh.getText());
				} else if (cmbQuyDinh.getSelectedIndex() == 1 && tableQuyDinhThuoc.getSelectedRow() >= 0) {
					lblIDQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
					txtMaQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
					txtTenQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
					txtGiaTri.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 3).toString());
					txtSoDonVi.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 4).toString());
					txtSoCachDung
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 5).toString());
					index = Integer.parseInt(lblIDQuyDinh.getText());
				} else if (cmbQuyDinh.getSelectedIndex() == 2 && tableQuyDinhThuoc.getSelectedRow() >= 0) {
					lblIDQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
					txtMaQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
					txtTenQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
					txtGiaTri.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 3).toString());
					index = Integer.parseInt(lblIDQuyDinh.getText());
				} else if (cmbQuyDinh.getSelectedIndex() == 3 && tableQuyDinhThuoc.getSelectedRow() >= 0) {
					lblIDQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
					txtMaQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
					txtTenQuyDinh
							.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
					index = Integer.parseInt(lblIDQuyDinh.getText());
				}
			}
		});
	}
}
