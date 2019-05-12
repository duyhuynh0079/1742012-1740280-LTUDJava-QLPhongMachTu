//package layoutandrun;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//import javax.swing.event.ListSelectionEvent;
//import javax.swing.event.ListSelectionListener;
//
//import com.sun.org.apache.xerces.internal.impl.dv.xs.ListDV;
//
//import DAO.cachdungDAO;
//import DAO.donvithuocDAO;
//import DAO.quidinhDAO;
//import entity.cachdung;
//import entity.donvi;
//import entity.quidinh;
//import show.CachDungModel;
//import show.DonViTinhThuocComboModel;
//import show.DonViTinhThuocModelqlt;
//import show.QuiDinhModel;
//import show.showBenhNhan;
//
//import javax.swing.JMenuBar;
//import javax.swing.JMenu;
//import javax.swing.JMenuItem;
//import javax.swing.JOptionPane;
//
//import java.awt.event.ActionListener;
//import java.util.ArrayList;
//import java.awt.event.ActionEvent;
//import javax.swing.JTabbedPane;
//import javax.swing.JLabel;
//import javax.swing.JTextField;
//import javax.swing.JButton;
//import java.awt.Font;
//import java.awt.Toolkit;
//import javax.swing.ImageIcon;
//import java.awt.Color;
//import javax.swing.JComboBox;
//import javax.swing.JPasswordField;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JTable;
//
//public class nhanvien extends JFrame {
//
//	private JPanel contentPane;
//	private JTextField txtHoTenNV;
//	private JTextField txtNgaySinhNV;
//	private JTextField txtDiaChiNV;
//	private JTextField txtSDTNV;
//	private JTextField txtTenDangNhapNV;
//	private JPasswordField jpfMatKhauNV;
//	private JPasswordField jpfNhapLaiMatKhauNV;
//	private JTable tableNV;
//	private JTextField txtMaThuoc;
//	private JTextField txtTenThuoc;
//	private JTextField txtDonGiaThuoc;
//	private JTable tableThuoc;
//	private JTextField txtMaDonViThuoc;
//	private JTextField txtTenDonViThuoc;
//	private JTable tableDonViThuoc;
//	private JTextField txtMaCachDungThuoc;
//	private JTextField txtTenCachDungThuoc;
//	private JTable tableCachDungThuoc;
//	private JTextField txtMaQuyDinh;
//	private JTextField txtTenQuyDinh;
//	private JTable tableQuyDinhThuoc;
//	static int index; // bat vi tri duyet al de sua
//	private JTextField txtGiaTri;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					nhanvien frame = new nhanvien();
//					frame.setLocationRelativeTo(null); // canh giữa màn hình
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public nhanvien() {
//		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 869, 661);
//		
//		JMenuBar menuBar = new JMenuBar();
//		menuBar.setFont(new Font("Arial", Font.PLAIN, 17));
//		setJMenuBar(menuBar);
//		
//		JMenu mnNhanVien = new JMenu("LogOut");
//		mnNhanVien.setFont(new Font("Arial", Font.PLAIN, 13));
//		mnNhanVien.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				//setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
//				//int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
//				//if(kq==0)
//				//{
//				//	System.exit(0);
//				//}
//			
//			}
//		});
//		menuBar.add(mnNhanVien);
//		contentPane = new JPanel();
//		contentPane.setBackground(new Color(255, 255, 255));
//		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(contentPane);
//		contentPane.setLayout(new BorderLayout(0, 0));
//		
//		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
//		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 15));
//		tabbedPane.setBackground(new Color(255, 255, 255));
//		contentPane.add(tabbedPane);
//		
//		JPanel pnNhanVien = new JPanel();
//		tabbedPane.addTab("Nhân Viên", new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\index.jpg"), pnNhanVien, null);
//		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
//		pnNhanVien.setLayout(null);
//		
//		JLabel lblnhanvien = new JLabel("QUẢN LÝ NHÂN VIÊN");
//		lblnhanvien.setForeground(Color.RED);
//		lblnhanvien.setFont(new Font("Arial", Font.PLAIN, 20));
//		lblnhanvien.setBounds(319, 11, 205, 35);
//		pnNhanVien.add(lblnhanvien);
//		
//		JLabel lblIDNhanVien = new JLabel("ID nhân viên");
//		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDNhanVien.setForeground(Color.BLUE);
//		lblIDNhanVien.setBounds(46, 80, 103, 27);
//		pnNhanVien.add(lblIDNhanVien);
//		
//		JLabel lblHoTen = new JLabel("Họ tên");
//		lblHoTen.setForeground(Color.BLUE);
//		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblHoTen.setBounds(46, 118, 103, 27);
//		pnNhanVien.add(lblHoTen);
//		
//		JLabel lblNgaySinh = new JLabel("Ngày sinh");
//		lblNgaySinh.setForeground(Color.BLUE);
//		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblNgaySinh.setBounds(46, 156, 103, 27);
//		pnNhanVien.add(lblNgaySinh);
//		
//		JLabel lblDiaChi = new JLabel("Địa chỉ");
//		lblDiaChi.setForeground(Color.BLUE);
//		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblDiaChi.setBounds(46, 194, 103, 27);
//		pnNhanVien.add(lblDiaChi);
//		
//		txtHoTenNV = new JTextField();
//		txtHoTenNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtHoTenNV.setBounds(169, 118, 170, 25);
//		pnNhanVien.add(txtHoTenNV);
//		txtHoTenNV.setColumns(10);
//		
//		JLabel lblIDNV = new JLabel("ID nhân viên");
//		lblIDNV.setForeground(Color.BLUE);
//		lblIDNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDNV.setBounds(169, 80, 103, 27);
//		pnNhanVien.add(lblIDNV);
//		
//		txtNgaySinhNV = new JTextField();
//		txtNgaySinhNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtNgaySinhNV.setColumns(10);
//		txtNgaySinhNV.setBounds(169, 156, 170, 25);
//		pnNhanVien.add(txtNgaySinhNV);
//		
//		txtDiaChiNV = new JTextField();
//		txtDiaChiNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtDiaChiNV.setColumns(10);
//		txtDiaChiNV.setBounds(169, 194, 170, 25);
//		pnNhanVien.add(txtDiaChiNV);
//		
//		JLabel lblSDT = new JLabel("Số điện thoại");
//		lblSDT.setForeground(Color.BLUE);
//		lblSDT.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblSDT.setBounds(45, 233, 103, 27);
//		pnNhanVien.add(lblSDT);
//		
//		txtSDTNV = new JTextField();
//		txtSDTNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtSDTNV.setColumns(10);
//		txtSDTNV.setBounds(170, 233, 170, 25);
//		pnNhanVien.add(txtSDTNV);
//		
//		JLabel lblChcV = new JLabel("Chức vụ");
//		lblChcV.setForeground(Color.BLUE);
//		lblChcV.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblChcV.setBounds(457, 118, 103, 27);
//		pnNhanVien.add(lblChcV);
//		
//		JComboBox cmbChucVuNV = new JComboBox();
//		cmbChucVuNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		cmbChucVuNV.setBounds(615, 119, 170, 25);
//		pnNhanVien.add(cmbChucVuNV);
//		
//		JLabel lblTnngNhp = new JLabel("Tên đăng nhập");
//		lblTnngNhp.setForeground(Color.BLUE);
//		lblTnngNhp.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblTnngNhp.setBounds(457, 156, 124, 27);
//		pnNhanVien.add(lblTnngNhp);
//		
//		txtTenDangNhapNV = new JTextField();
//		txtTenDangNhapNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtTenDangNhapNV.setColumns(10);
//		txtTenDangNhapNV.setBounds(615, 156, 170, 25);
//		pnNhanVien.add(txtTenDangNhapNV);
//		
//		JLabel lblMtKhu = new JLabel("Mật khẩu");
//		lblMtKhu.setForeground(Color.BLUE);
//		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblMtKhu.setBounds(457, 194, 124, 27);
//		pnNhanVien.add(lblMtKhu);
//		
//		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
//		lblNhpLiMt.setForeground(Color.BLUE);
//		lblNhpLiMt.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblNhpLiMt.setBounds(457, 233, 140, 27);
//		pnNhanVien.add(lblNhpLiMt);
//		
//		jpfMatKhauNV = new JPasswordField();
//		jpfMatKhauNV.setBounds(615, 194, 170, 25);
//		pnNhanVien.add(jpfMatKhauNV);
//		
//		jpfNhapLaiMatKhauNV = new JPasswordField();
//		jpfNhapLaiMatKhauNV.setBounds(615, 233, 170, 25);
//		pnNhanVien.add(jpfNhapLaiMatKhauNV);
//		
//		JButton btnThemNV = new JButton("Thêm");
//		btnThemNV.setForeground(Color.RED);
//		btnThemNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnThemNV.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-add.png"));
//		btnThemNV.setBounds(46, 294, 115, 41);
//		pnNhanVien.add(btnThemNV);
//		
//		JButton btnCapNhatNV = new JButton("Cập nhật");
//		btnCapNhatNV.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-edit.png"));
//		btnCapNhatNV.setForeground(Color.RED);
//		btnCapNhatNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnCapNhatNV.setBounds(200, 294, 140, 41);
//		pnNhanVien.add(btnCapNhatNV);
//		
//		JButton btnXoaNV = new JButton("Xóa");
//		btnXoaNV.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//			}
//		});
//		btnXoaNV.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-delete.png"));
//		btnXoaNV.setForeground(Color.RED);
//		btnXoaNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnXoaNV.setBounds(383, 294, 103, 41);
//		pnNhanVien.add(btnXoaNV);
//		
//		JButton btnLoadNV = new JButton("Load");
//		btnLoadNV.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
//		btnLoadNV.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//			}
//		});
//		btnLoadNV.setForeground(Color.RED);
//		btnLoadNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnLoadNV.setBounds(676, 294, 109, 41);
//		pnNhanVien.add(btnLoadNV);
//		
//		tableNV = new JTable();
//		tableNV.setBounds(46, 364, 739, 148);
//		pnNhanVien.add(tableNV);
//		
//		JButton btnTimNV = new JButton("Tìm");
//		btnTimNV.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
//		btnTimNV.setForeground(Color.RED);
//		btnTimNV.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnTimNV.setBounds(527, 294, 109, 41);
//		pnNhanVien.add(btnTimNV);
//		
//		//ql Thuoc
//		JPanel pnThuoc = new JPanel();
//		tabbedPane.addTab("Thuốc", new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\thuoc.jpg"), pnThuoc, null);
//		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
//		pnThuoc.setLayout(null);
//		
//		JLabel lblQunLthuc = new JLabel("QUẢN LÝ THUỐC");
//		lblQunLthuc.setForeground(Color.RED);
//		lblQunLthuc.setFont(new Font("Arial", Font.PLAIN, 20));
//		lblQunLthuc.setBounds(326, 11, 205, 35);
//		pnThuoc.add(lblQunLthuc);
//		
//		JLabel lblidThuoc = new JLabel("ID thuốc");
//		lblidThuoc.setForeground(Color.BLUE);
//		lblidThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblidThuoc.setBounds(53, 80, 103, 27);
//		pnThuoc.add(lblidThuoc);
//		
//		JLabel lblIDThuoc = new JLabel("ID thuốc\r\n");
//		lblIDThuoc.setForeground(Color.BLUE);
//		lblIDThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDThuoc.setBounds(176, 80, 103, 27);
//		pnThuoc.add(lblIDThuoc);
//		
//		JLabel lblMaThuoc = new JLabel("Mã thuốc");
//		lblMaThuoc.setForeground(Color.BLUE);
//		lblMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblMaThuoc.setBounds(53, 118, 103, 27);
//		pnThuoc.add(lblMaThuoc);
//		
//		txtMaThuoc = new JTextField();
//		txtMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtMaThuoc.setColumns(10);
//		txtMaThuoc.setBounds(176, 118, 170, 25);
//		pnThuoc.add(txtMaThuoc);
//		
//		JLabel llbTenThuoc = new JLabel("Tên thuốc");
//		llbTenThuoc.setForeground(Color.BLUE);
//		llbTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		llbTenThuoc.setBounds(53, 156, 103, 27);
//		pnThuoc.add(llbTenThuoc);
//		
//		txtTenThuoc = new JTextField();
//		txtTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtTenThuoc.setColumns(10);
//		txtTenThuoc.setBounds(176, 156, 170, 25);
//		pnThuoc.add(txtTenThuoc);
//		
//		JLabel lblDonGia = new JLabel("Đơn giá");
//		lblDonGia.setForeground(Color.BLUE);
//		lblDonGia.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblDonGia.setBounds(464, 118, 103, 27);
//		pnThuoc.add(lblDonGia);
//		
//		txtDonGiaThuoc = new JTextField();
//		txtDonGiaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtDonGiaThuoc.setColumns(10);
//		txtDonGiaThuoc.setBounds(622, 118, 170, 25);
//		pnThuoc.add(txtDonGiaThuoc);
//		
//		JLabel lblnVTnh = new JLabel("Đơn vị tính");
//		lblnVTnh.setForeground(Color.BLUE);
//		lblnVTnh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblnVTnh.setBounds(464, 156, 103, 27);
//		pnThuoc.add(lblnVTnh);
//		
//		JComboBox cmbDonViTinhThuoc = new JComboBox();
//		cmbDonViTinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		cmbDonViTinhThuoc.setBounds(622, 157, 170, 25);
//		cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
//		pnThuoc.add(cmbDonViTinhThuoc);
//		
//		JButton btnThemThuoc = new JButton("Thêm");
//		btnThemThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
//		btnThemThuoc.setForeground(Color.RED);
//		btnThemThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnThemThuoc.setBounds(114, 230, 115, 41);
//		pnThuoc.add(btnThemThuoc);
//		
//		JButton btnCapNhatThuoc = new JButton("Cập nhật");
//		btnCapNhatThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
//		btnCapNhatThuoc.setForeground(Color.RED);
//		btnCapNhatThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnCapNhatThuoc.setBounds(278, 230, 140, 41);
//		pnThuoc.add(btnCapNhatThuoc);
//		
//		JButton btnXoaThuoc = new JButton("Xóa");
//		btnXoaThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
//		btnXoaThuoc.setForeground(Color.RED);
//		btnXoaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnXoaThuoc.setBounds(468, 230, 103, 41);
//		pnThuoc.add(btnXoaThuoc);
//		
//		JButton btnLoadThuoc = new JButton("Load");
//		btnLoadThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
//		btnLoadThuoc.setForeground(Color.RED);
//		btnLoadThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnLoadThuoc.setBounds(626, 230, 109, 41);
//		pnThuoc.add(btnLoadThuoc);
//		
//		tableThuoc = new JTable();
//		tableThuoc.setBounds(53, 315, 739, 179);
//		pnThuoc.add(tableThuoc);
//		
//		//ql Don vi thuoc
//		JPanel pnDonViThuoc = new JPanel();
//		tabbedPane.addTab("Đơn Vị Thuốc", new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\donvithuoc.jpg"), pnDonViThuoc, null);
//		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
//		pnDonViThuoc.setLayout(null);
//		
//		JLabel lblQunLn = new JLabel("QUẢN LÝ ĐƠN VỊ THUỐC\r\n");
//		lblQunLn.setForeground(Color.RED);
//		lblQunLn.setFont(new Font("Arial", Font.PLAIN, 20));
//		lblQunLn.setBounds(307, 11, 244, 35);
//		pnDonViThuoc.add(lblQunLn);
//		
//		JLabel lblIdnV = new JLabel("ID đơn vị ");
//		lblIdnV.setForeground(Color.BLUE);
//		lblIdnV.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIdnV.setBounds(215, 78, 103, 27);
//		pnDonViThuoc.add(lblIdnV);
//		
//		JLabel lblIDDonViThuoc = new JLabel("ID đơn vị");
//		lblIDDonViThuoc.setForeground(Color.BLUE);
//		lblIDDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDDonViThuoc.setBounds(381, 78, 103, 27);
//		pnDonViThuoc.add(lblIDDonViThuoc);
//		
//		JLabel lblMaDonViThuoc = new JLabel("Mã đơn vị thuốc");
//		lblMaDonViThuoc.setForeground(Color.BLUE);
//		lblMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblMaDonViThuoc.setBounds(215, 116, 123, 27);
//		pnDonViThuoc.add(lblMaDonViThuoc);
//		
//		txtMaDonViThuoc = new JTextField();
//		txtMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtMaDonViThuoc.setColumns(10);
//		txtMaDonViThuoc.setBounds(381, 116, 170, 25);
//		pnDonViThuoc.add(txtMaDonViThuoc);
//		
//		JLabel lblTenDonViThuoc = new JLabel("Tên đơn vị thuốc");
//		lblTenDonViThuoc.setForeground(Color.BLUE);
//		lblTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblTenDonViThuoc.setBounds(215, 154, 123, 27);
//		pnDonViThuoc.add(lblTenDonViThuoc);
//		
//		txtTenDonViThuoc = new JTextField();
//		txtTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtTenDonViThuoc.setColumns(10);
//		txtTenDonViThuoc.setBounds(381, 154, 170, 25);
//		pnDonViThuoc.add(txtTenDonViThuoc);
//		
//		JButton tbnThemDonViThuoc = new JButton("Thêm");
//		tbnThemDonViThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
//				} else if (donvithuocDAO.timMaDonVi(txtMaDonViThuoc.getText()) != null){
//					JOptionPane.showMessageDialog(null, "Mã đơn vị đã tồn tại!");
//				}else{
//					donvi dv = new donvi();
//					dv.setMaDonVi(txtMaDonViThuoc.getText());
//					dv.setTenDonVi(txtTenDonViThuoc.getText());
//					try {
//						if (DAO.donvithuocDAO.themDonViThuoc(dv) == true) {
//							JOptionPane.showMessageDialog(null, "Đã thêm đơn vị thuốc: " + txtMaDonViThuoc.getText());
//							lblIDDonViThuoc.setText(null);
//							txtMaDonViThuoc.setText(null);
//							txtTenDonViThuoc.setText(null);
//							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
//							tableDonViThuoc.setModel(mdDonVi);
//						} else {
//							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//						
//					}catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}
//			}
//		});
//		
//		tbnThemDonViThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
//		tbnThemDonViThuoc.setForeground(Color.RED);
//		tbnThemDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		tbnThemDonViThuoc.setBounds(163, 233, 115, 41);
//		pnDonViThuoc.add(tbnThemDonViThuoc);
//		
//		JButton btnCapNhatDonViThuoc = new JButton("Cập nhật");
//		btnCapNhatDonViThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng click bảng!", "WARNING",
//							JOptionPane.WARNING_MESSAGE);
//				} else {
//					donvi dv = new donvi();
//					ArrayList<donvi> aldv = DonViTinhThuocModelqlt.listDV; 
//					for(int i = 0; i<aldv.size(); i++ )
//					{
//						if(index == i)
//						{
//							dv.setID(aldv.get(i).getID());
//							dv.setMaDonVi(txtMaDonViThuoc.getText());
//							dv.setTenDonVi(txtTenDonViThuoc.getText());
//						}
//					}
//					try {
//						if (donvithuocDAO.suaDonViThuoc(dv) == true) {
//							JOptionPane.showMessageDialog(null, "Sửa thành công !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//							lblIDDonViThuoc.setText(null);
//							txtMaDonViThuoc.setText(null);
//							txtTenDonViThuoc.setText(null);
//							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
//							tableDonViThuoc.setModel(mdDonVi);
//						} else {
//							JOptionPane.showMessageDialog(null, "Sửa thất bại, vui lòng click bảng chọn đơn vị sữa !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		btnCapNhatDonViThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
//		btnCapNhatDonViThuoc.setForeground(Color.RED);
//		btnCapNhatDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnCapNhatDonViThuoc.setBounds(343, 233, 140, 41);
//		pnDonViThuoc.add(btnCapNhatDonViThuoc);
//		
//		JButton btnLoadDonViThuoc = new JButton("Load");
//		btnLoadDonViThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblIDDonViThuoc.setText(null);
//				txtMaDonViThuoc.setText(null);
//				txtTenDonViThuoc.setText(null);
//				DonViTinhThuocModelqlt modelDonViThuoc = new DonViTinhThuocModelqlt();
//				tableDonViThuoc.setModel(modelDonViThuoc);
//			}
//		});
//		btnLoadDonViThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
//		btnLoadDonViThuoc.setForeground(Color.RED);
//		btnLoadDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnLoadDonViThuoc.setBounds(540, 233, 109, 41);
//		pnDonViThuoc.add(btnLoadDonViThuoc);
//		
//		//tạo table
//		tableDonViThuoc = new JTable();
//		DonViTinhThuocModelqlt modelDonViThuoc = new DonViTinhThuocModelqlt();
//		tableDonViThuoc.setModel(modelDonViThuoc);
//		JScrollPane scrollPane = new JScrollPane(tableDonViThuoc);// dan table vao khung jsp
//		scrollPane.setBounds(163, 325, 486, 169);
//		//tableDonViThuoc.setBounds(163, 325, 486, 169);
//		pnDonViThuoc.add(scrollPane);
//		//pnDonViThuoc.add(tableDonViThuoc);
//		tableDonViThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent event) {
//				// dat if tranh loi
//				if (tableDonViThuoc.getSelectedRow() >= 0) {
//					lblIDDonViThuoc.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 0).toString());
//					txtMaDonViThuoc.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 1).toString());
//					txtTenDonViThuoc.setText(tableDonViThuoc.getValueAt(tableDonViThuoc.getSelectedRow(), 2).toString());
//					index = tableDonViThuoc.getSelectedRow();
//				}
//			}
//		});
//		
//		
//		//ql cach dung
//		JPanel pnCachDung = new JPanel();
//		tabbedPane.addTab("Cách Dùng", new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\huongdan.png"), pnCachDung, null);
//		tabbedPane.setBackgroundAt(3, new Color(255, 255, 255));
//		pnCachDung.setLayout(null);
//		
//		JLabel lblQunLCch = new JLabel("QUẢN LÝ CÁCH DÙNG\r\n THUỐC");
//		lblQunLCch.setForeground(Color.RED);
//		lblQunLCch.setFont(new Font("Arial", Font.PLAIN, 20));
//		lblQunLCch.setBounds(266, 11, 289, 35);
//		pnCachDung.add(lblQunLCch);
//		
//		JLabel lblIdCD = new JLabel("ID cách dùng");
//		lblIdCD.setForeground(Color.BLUE);
//		lblIdCD.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIdCD.setBounds(234, 78, 103, 27);
//		pnCachDung.add(lblIdCD);
//		
//		JLabel lblIDCachDung = new JLabel("ID cách dùng");
//		lblIDCachDung.setForeground(Color.BLUE);
//		lblIDCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDCachDung.setBounds(414, 80, 103, 27);
//		pnCachDung.add(lblIDCachDung);
//		
//		JLabel lblMaCachDungThuoc = new JLabel("Mã cách dùng thuốc");
//		lblMaCachDungThuoc.setForeground(Color.BLUE);
//		lblMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblMaCachDungThuoc.setBounds(234, 116, 170, 27);
//		pnCachDung.add(lblMaCachDungThuoc);
//		
//		txtMaCachDungThuoc = new JTextField();
//		txtMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtMaCachDungThuoc.setColumns(10);
//		txtMaCachDungThuoc.setBounds(414, 118, 170, 25);
//		pnCachDung.add(txtMaCachDungThuoc);
//		
//		txtTenCachDungThuoc = new JTextField();
//		txtTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtTenCachDungThuoc.setColumns(10);
//		txtTenCachDungThuoc.setBounds(414, 156, 170, 25);
//		pnCachDung.add(txtTenCachDungThuoc);
//		
//		JButton btnThemCachDung = new JButton("Thêm");
//		btnThemCachDung.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
//				} else if (cachdungDAO.timMaCachDung(txtMaCachDungThuoc.getText()) != null){
//					JOptionPane.showMessageDialog(null, "Mã cách dùng đã tồn tại!");
//				}else{
//					cachdung cd = new cachdung();
//					cd.setMaCachDung(txtMaCachDungThuoc.getText());
//					cd.setTenCachDung(txtTenCachDungThuoc.getText());
//					try {
//						if (DAO.cachdungDAO.themCachDung(cd) == true) {
//							JOptionPane.showMessageDialog(null, "Đã thêm cách dùng thuốc: " + txtMaCachDungThuoc.getText());
//							lblIDCachDung.setText(null);
//							txtMaCachDungThuoc.setText(null);
//							txtTenCachDungThuoc.setText(null);
//							CachDungModel mdCachDung = new CachDungModel();
//							tableCachDungThuoc.setModel(mdCachDung);
//						} else {
//							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//						
//					}catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}
//				
//			}
//		});
//		btnThemCachDung.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
//		btnThemCachDung.setForeground(Color.RED);
//		btnThemCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnThemCachDung.setBounds(166, 233, 115, 41);
//		pnCachDung.add(btnThemCachDung);
//		
//		JButton btnCapNhatCachDung = new JButton("Cập nhật");
//		btnCapNhatCachDung.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng click bảng!", "WARNING",
//							JOptionPane.WARNING_MESSAGE);
//				} else {
//					cachdung cd = new cachdung();
//					ArrayList<cachdung> alcd = CachDungModel.listCD; 
//					for(int i = 0; i<alcd.size(); i++ )
//					{
//						if(index == i)
//						{
//							cd.setID(alcd.get(i).getID());
//							cd.setMaCachDung(txtMaCachDungThuoc.getText());
//							cd.setTenCachDung(txtTenCachDungThuoc.getText());
//						}
//					}
//					try {
//						if (cachdungDAO.suaCachDung(cd) == true) {
//							JOptionPane.showMessageDialog(null, "Sửa thành công !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//							lblIDCachDung.setText(null);
//							txtMaCachDungThuoc.setText(null);
//							txtTenCachDungThuoc.setText(null);
//							CachDungModel mdCachDung = new CachDungModel();
//							tableCachDungThuoc.setModel(mdCachDung);
//						} else {
//							JOptionPane.showMessageDialog(null, "Sửa thất bại, vui lòng click bảng chọn cách dùng sữa !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		btnCapNhatCachDung.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
//		btnCapNhatCachDung.setForeground(Color.RED);
//		btnCapNhatCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnCapNhatCachDung.setBounds(346, 233, 140, 41);
//		pnCachDung.add(btnCapNhatCachDung);
//		
//		JButton btnLoadCachDung = new JButton("Load");
//		btnLoadCachDung.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblIDCachDung.setText(null);
//				txtMaCachDungThuoc.setText(null);
//				txtTenCachDungThuoc.setText(null);
//				CachDungModel modelCachDung = new CachDungModel();
//				tableCachDungThuoc.setModel(modelCachDung);
//			}
//		});
//		btnLoadCachDung.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
//		btnLoadCachDung.setForeground(Color.RED);
//		btnLoadCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnLoadCachDung.setBounds(543, 233, 109, 41);
//		pnCachDung.add(btnLoadCachDung);
//		
//		tableCachDungThuoc = new JTable();
//		CachDungModel modelCD = new CachDungModel();
//		tableCachDungThuoc.setModel(modelCD);
//		JScrollPane scrollPaneCD = new JScrollPane(tableCachDungThuoc);// dan table vao khung jsp
//		scrollPaneCD.setBounds(163, 325, 486, 169);
//		pnCachDung.add(scrollPaneCD);
//		tableCachDungThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent event) {
//				// dat if tranh loi
//				if (tableCachDungThuoc.getSelectedRow() >= 0) {
//					lblIDCachDung.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 0).toString());
//					txtMaCachDungThuoc.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 1).toString());
//					txtTenCachDungThuoc.setText(tableCachDungThuoc.getValueAt(tableCachDungThuoc.getSelectedRow(), 2).toString());
//					index = tableCachDungThuoc.getSelectedRow();
//				}
//			}
//		});
//		
//		
//		JLabel lblTenCachDungThuoc = new JLabel("Tên cách dùng thuốc");
//		lblTenCachDungThuoc.setForeground(Color.BLUE);
//		lblTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblTenCachDungThuoc.setBounds(234, 154, 170, 27);
//		pnCachDung.add(lblTenCachDungThuoc);
//		
//		//ql quy dinh
//		JPanel pnQuyDinh = new JPanel();
//		tabbedPane.addTab("Quy Định", new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\quidinh.png"), pnQuyDinh, null);
//		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
//		pnQuyDinh.setLayout(null);
//		
//		JLabel lblQunLQuy = new JLabel("QUẢN LÝ QUY ĐỊNH");
//		lblQunLQuy.setForeground(Color.RED);
//		lblQunLQuy.setFont(new Font("Arial", Font.PLAIN, 20));
//		lblQunLQuy.setBounds(313, 11, 201, 35);
//		pnQuyDinh.add(lblQunLQuy);
//		
//		JLabel lblIdQuynh = new JLabel("ID quy định");
//		lblIdQuynh.setForeground(Color.BLUE);
//		lblIdQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIdQuynh.setBounds(268, 64, 103, 27);
//		pnQuyDinh.add(lblIdQuynh);
//		
//		JLabel lblIDQuyDinh = new JLabel("ID quy định");
//		lblIDQuyDinh.setForeground(Color.BLUE);
//		lblIDQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblIDQuyDinh.setBounds(399, 66, 103, 27);
//		pnQuyDinh.add(lblIDQuyDinh);
//		
//		JLabel lblMQuynh = new JLabel("Mã quy định");
//		lblMQuynh.setForeground(Color.BLUE);
//		lblMQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblMQuynh.setBounds(268, 102, 170, 27);
//		pnQuyDinh.add(lblMQuynh);
//		
//		txtMaQuyDinh = new JTextField();
//		txtMaQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtMaQuyDinh.setColumns(10);
//		txtMaQuyDinh.setBounds(399, 104, 170, 25);
//		pnQuyDinh.add(txtMaQuyDinh);
//		
//		JLabel lblTnQuynh = new JLabel("Tên quy định");
//		lblTnQuynh.setForeground(Color.BLUE);
//		lblTnQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblTnQuynh.setBounds(268, 140, 170, 27);
//		pnQuyDinh.add(lblTnQuynh);
//		
//		txtTenQuyDinh = new JTextField();
//		txtTenQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtTenQuyDinh.setColumns(10);
//		txtTenQuyDinh.setBounds(399, 142, 170, 25);
//		pnQuyDinh.add(txtTenQuyDinh);
//		
//		JButton btnThemQuyDinhThuoc = new JButton("Thêm");
//		btnThemQuyDinhThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("") || txtGiaTri.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
//				} else if (quidinhDAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null){
//					JOptionPane.showMessageDialog(null, "Mã quy định đã tồn tại!");
//				}else{
//					quidinh qd = new quidinh();
//					qd.setMaQuiDinh(txtMaQuyDinh.getText());
//					qd.setTenQuiDinh(txtTenQuyDinh.getText());
//					qd.setGiaTri(Float.parseFloat(txtGiaTri.getText()));
//					try {
//						if (DAO.quidinhDAO.themQuyDinh(qd) == true) {
//							JOptionPane.showMessageDialog(null, "Đã thêm quy định: " + txtMaQuyDinh.getText());
//							lblIDQuyDinh.setText(null);
//							txtMaQuyDinh.setText(null);
//							txtTenQuyDinh.setText(null);
//							txtGiaTri.setText(null);
//							QuiDinhModel mdQuyDinh = new QuiDinhModel();
//							tableQuyDinhThuoc.setModel(mdQuyDinh);
//						} else {
//							JOptionPane.showMessageDialog(null, "Thêm thất bại!", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//						
//					}catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//					
//				}
//			}
//		});
//		btnThemQuyDinhThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
//		btnThemQuyDinhThuoc.setForeground(Color.RED);
//		btnThemQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnThemQuyDinhThuoc.setBounds(181, 238, 115, 41);
//		pnQuyDinh.add(btnThemQuyDinhThuoc);
//		
//		JButton btnCapNhatQuyDinhThuoc = new JButton("Cập nhật");
//		btnCapNhatQuyDinhThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("") || txtGiaTri.getText().equals("")) {
//					JOptionPane.showMessageDialog(null, "Vui lòng click bảng!", "WARNING",
//							JOptionPane.WARNING_MESSAGE);
//				} else {
//					quidinh qd = new quidinh();
//					ArrayList<quidinh> alqd = QuiDinhModel.listQD; 
//					for(int i = 0; i<alqd.size(); i++ )
//					{
//						if(index == i)
//						{
//							qd.setID(alqd.get(i).getID());
//							qd.setMaQuiDinh(txtMaQuyDinh.getText());
//							qd.setTenQuiDinh(txtTenQuyDinh.getText());
//							qd.setGiaTri(Float.parseFloat(txtGiaTri.getText()));
//						}
//					}
//					try {
//						if (quidinhDAO.suaQuyDinh(qd) == true) {
//							JOptionPane.showMessageDialog(null, "Sửa thành công !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//							lblIDQuyDinh.setText(null);
//							txtMaQuyDinh.setText(null);
//							txtTenQuyDinh.setText(null);
//							txtGiaTri.setText(null);
//							QuiDinhModel mdQuyDinh = new QuiDinhModel();
//							tableQuyDinhThuoc.setModel(mdQuyDinh);
//						} else {
//							JOptionPane.showMessageDialog(null, "Sửa thất bại, vui lòng click bảng chọn quy định sữa !", "WARNING",
//									JOptionPane.WARNING_MESSAGE);
//						}
//					} catch (Exception e1) {
//						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
//						// TODO Auto-generated catch block
//						e1.printStackTrace();
//					}
//				}
//			}
//		});
//		btnCapNhatQuyDinhThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
//		btnCapNhatQuyDinhThuoc.setForeground(Color.RED);
//		btnCapNhatQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnCapNhatQuyDinhThuoc.setBounds(361, 238, 140, 41);
//		pnQuyDinh.add(btnCapNhatQuyDinhThuoc);
//		
//		JButton btnLoadQuyDinhThuoc = new JButton("Load");
//		btnLoadQuyDinhThuoc.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				lblIDQuyDinh.setText(null);
//				txtMaQuyDinh.setText(null);
//				txtTenQuyDinh.setText(null);
//				txtGiaTri.setText(null);
//				QuiDinhModel modelQuyDinh = new QuiDinhModel();
//				tableQuyDinhThuoc.setModel(modelQuyDinh);
//			}
//		});
//		btnLoadQuyDinhThuoc.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
//		btnLoadQuyDinhThuoc.setForeground(Color.RED);
//		btnLoadQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
//		btnLoadQuyDinhThuoc.setBounds(558, 238, 109, 41);
//		pnQuyDinh.add(btnLoadQuyDinhThuoc);
//		
//		tableQuyDinhThuoc = new JTable();
//		QuiDinhModel modelQD = new QuiDinhModel();
//		tableQuyDinhThuoc.setModel(modelQD);
//		JScrollPane scrollPaneQD = new JScrollPane(tableQuyDinhThuoc);// dan table vao khung jsp
//		scrollPaneQD.setBounds(181, 330, 486, 169);
//		pnQuyDinh.add(scrollPaneQD);
//		
//		JLabel lblGiTr = new JLabel("Giá trị");
//		lblGiTr.setForeground(Color.BLUE);
//		lblGiTr.setFont(new Font("Arial", Font.PLAIN, 17));
//		lblGiTr.setBounds(268, 178, 170, 27);
//		pnQuyDinh.add(lblGiTr);
//		
//		txtGiaTri = new JTextField();
//		txtGiaTri.setFont(new Font("Arial", Font.PLAIN, 17));
//		txtGiaTri.setColumns(10);
//		txtGiaTri.setBounds(399, 180, 170, 25);
//		pnQuyDinh.add(txtGiaTri);
//		tableQuyDinhThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
//			public void valueChanged(ListSelectionEvent event) {
//				// dat if tranh loi
//				if (tableQuyDinhThuoc.getSelectedRow() >= 0) {
//					lblIDQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
//					txtMaQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
//					txtTenQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
//					txtGiaTri.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(),  3).toString());
//					index = tableQuyDinhThuoc.getSelectedRow();
//				}
//			}
//		});
//	}
//}
