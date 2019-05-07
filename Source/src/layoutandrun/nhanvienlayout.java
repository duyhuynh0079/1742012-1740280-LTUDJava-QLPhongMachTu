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
import DAO.quidinhDAO;
import DAO.thuocDAO;
import entity.cachdung;
import entity.donvi;
import entity.loaibenh;
import entity.nhanvien;
import entity.quidinh;
import entity.thuoc;
import show.CachDungModel;
import show.DonViTinhThuocComboModel;
import show.DonViTinhThuocModelqlt;
import show.LoaiBenhModel;
import show.NhanVienModel;
import show.NhanVienTimKiemModel;
import show.QuiDinhModel;
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
	static int index; // bat vi tri duyet al de sua
	private JTextField txtGiaTri;
	private JTextField txtMaLoaiBenh;
	private JTextField txtTenLoaiBenh;
	private JTable tableLoaiBenh;
	static String manv = "";
	static String tennv = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					nhanvienlayout frame = new nhanvienlayout(tennv);
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
	public nhanvienlayout(String tennhanvien) {
		//manv = manhanvien;
		tennv = tennhanvien;
		setTitle(tennv);
		setIconImage(Toolkit.getDefaultToolkit().getImage(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 869, 661);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Arial", Font.PLAIN, 15));
		tabbedPane.setBackground(new Color(255, 255, 255));
		contentPane.add(tabbedPane);

		JPanel pnNhanVien = new JPanel();
		tabbedPane.addTab("Nhan Vien\r\n", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Pharmacist_Male_Light.png"),
				pnNhanVien, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		pnNhanVien.setLayout(null);

		JLabel lblnhanvien = new JLabel("QUAN LY NHAN VIEN");
		lblnhanvien.setForeground(Color.RED);
		lblnhanvien.setFont(new Font("Arial", Font.PLAIN, 20));
		lblnhanvien.setBounds(319, 11, 205, 35);
		pnNhanVien.add(lblnhanvien);

		JLabel lblIDNhanVien = new JLabel("ID Nhan vien");
		lblIDNhanVien.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDNhanVien.setForeground(Color.BLUE);
		lblIDNhanVien.setBounds(46, 80, 103, 27);
		pnNhanVien.add(lblIDNhanVien);

		JLabel lblHoTen = new JLabel("Ho ten");
		lblHoTen.setForeground(Color.BLUE);
		lblHoTen.setFont(new Font("Arial", Font.PLAIN, 17));
		lblHoTen.setBounds(46, 118, 103, 27);
		pnNhanVien.add(lblHoTen);

		JLabel lblNgaySinh = new JLabel("Ngay sinh");
		lblNgaySinh.setForeground(Color.BLUE);
		lblNgaySinh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNgaySinh.setBounds(46, 156, 103, 27);
		pnNhanVien.add(lblNgaySinh);

		JLabel lblDiaChi = new JLabel("Dia chi");
		lblDiaChi.setForeground(Color.BLUE);
		lblDiaChi.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDiaChi.setBounds(46, 194, 103, 27);
		pnNhanVien.add(lblDiaChi);

		txtHoTenNV = new JTextField();
		txtHoTenNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtHoTenNV.setBounds(169, 118, 170, 25);
		pnNhanVien.add(txtHoTenNV);
		txtHoTenNV.setColumns(10);

		JLabel lblIDNV = new JLabel("ID Nhanvien");
		lblIDNV.setForeground(Color.BLUE);
		lblIDNV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDNV.setBounds(169, 80, 103, 27);
		pnNhanVien.add(lblIDNV);

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
		JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.getJFormattedTextField().setFont(new Font("Tahoma", Font.PLAIN, 16));
		datePicker.setBounds(169, 156, 170, 25);
		pnNhanVien.add(datePicker);

		JLabel lblSDT = new JLabel("So dien thoai");
		lblSDT.setForeground(Color.BLUE);
		lblSDT.setFont(new Font("Arial", Font.PLAIN, 17));
		lblSDT.setBounds(454, 118, 103, 27);
		pnNhanVien.add(lblSDT);

		txtSDTNV = new JTextField();
		txtSDTNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtSDTNV.setColumns(10);
		txtSDTNV.setBounds(615, 118, 170, 25);
		pnNhanVien.add(txtSDTNV);

		JLabel lblTnngNhp = new JLabel("Ten dang nhap");
		lblTnngNhp.setForeground(Color.BLUE);
		lblTnngNhp.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTnngNhp.setBounds(457, 156, 124, 27);
		pnNhanVien.add(lblTnngNhp);

		txtTenDangNhapNV = new JTextField();
		txtTenDangNhapNV.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDangNhapNV.setColumns(10);
		txtTenDangNhapNV.setBounds(615, 156, 170, 25);
		pnNhanVien.add(txtTenDangNhapNV);

		JLabel lblMtKhu = new JLabel("Mat khau");
		lblMtKhu.setForeground(Color.BLUE);
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMtKhu.setBounds(457, 194, 124, 27);
		pnNhanVien.add(lblMtKhu);

		JLabel lblNhpLiMt = new JLabel("Nhap lai mat khau");
		lblNhpLiMt.setForeground(Color.BLUE);
		lblNhpLiMt.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNhpLiMt.setBounds(457, 233, 140, 27);
		pnNhanVien.add(lblNhpLiMt);

		jpMatKhauNV = new JPasswordField();
		jpMatKhauNV.setBounds(615, 194, 170, 25);
		pnNhanVien.add(jpMatKhauNV);

		jpNhapLaiMatKhauNV = new JPasswordField();
		jpNhapLaiMatKhauNV.setBounds(615, 233, 170, 25);
		pnNhanVien.add(jpNhapLaiMatKhauNV);

		JTextArea taDiaChiNV = new JTextArea();
		taDiaChiNV.setFont(new Font("Arial", Font.PLAIN, 17));
		taDiaChiNV.setBounds(169, 197, 170, 61);
		pnNhanVien.add(taDiaChiNV);
		
		JLabel lblChcV = new JLabel("Chuc vu");
		lblChcV.setForeground(Color.BLUE);
		lblChcV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblChcV.setBounds(454, 80, 103, 27);
		pnNhanVien.add(lblChcV);
		
		JComboBox cmbChucVuNV = new JComboBox();
		cmbChucVuNV.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] {"Bac si", "Y ta"}));
		cmbChucVuNV.setBounds(615, 83, 170, 25);
		pnNhanVien.add(cmbChucVuNV);

		JButton btnThemNV = new JButton("Them");
		btnThemNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("") || jpMatKhauNV.getText().equals("")
						|| jpNhapLaiMatKhauNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				} else if (jpMatKhauNV.getText().equals(jpNhapLaiMatKhauNV.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Máº­t kháº©u khÃ´ng khá»›p nháº­p láº¡i máº­t kháº©u!");
					jpMatKhauNV.setText(null);
					jpNhapLaiMatKhauNV.setText(null);
				} else if(nhanvienDAO.timTenDangNhapTrung(txtTenDangNhapNV.getText()) != null){
						JOptionPane.showMessageDialog(null, "TÃªn Ä‘Äƒng nháº­p Ä‘Ã£ tá»“n táº¡i! Ä�áº·t láº¡i tÃªn Ä‘Äƒng nháº­p!");
						txtTenDangNhapNV.setText(null);
					
				}else {
				
					Date ngaysinh;
					nhanvien nv = new nhanvien();
					
					//format ngay sinh
					try {
						nv.setTenDangNhap(txtTenDangNhapNV.getText());
						String matkhaudahash;
						
							try {
								matkhaudahash = nhanvienDAO.GetPasswordHashText(jpNhapLaiMatKhauNV.getText());
								nv.setMatKhau(matkhaudahash);
							} catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
						nv.setHoTenNV(txtHoTenNV.getText());
						ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(datePicker.getJFormattedTextField().getText());
						nv.setNgaySinh(ngaysinh);
						nv.setDiaChi(taDiaChiNV.getText());
						nv.setSDT(txtSDTNV.getText());
						nv.setTinhTrang(0);
						//nv.setMaCV(inter);
						nv.setMaCV(cmbChucVuNV.getSelectedIndex()+1);
						try {
							if (DAO.nhanvienDAO.themNhanVien(nv) == true) {
								JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm nhÃ¢n viÃªn: " + txtHoTenNV.getText());
								lblIDNV.setText(null);
								txtHoTenNV.setText(null);
								datePicker.getJFormattedTextField().setText(null);
								txtSDTNV.setText(null);
								taDiaChiNV.setText(null);
								txtTenDangNhapNV.setText(null);
								jpMatKhauNV.setText(null);
								jpNhapLaiMatKhauNV.setText(null);
								cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] {"BÃ¡c sÄ©", "Y tÃ¡"}));
								NhanVienModel mdNhanVien = new NhanVienModel();
								tableNV.setModel(mdNhanVien);
							} else {
								JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
										JOptionPane.WARNING_MESSAGE);
							}

						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
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
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-add.png"));
		btnThemNV.setBounds(46, 294, 115, 41);
		pnNhanVien.add(btnThemNV);

		JButton btnCapNhatNV = new JButton("Cap nhat");
		btnCapNhatNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("") || jpMatKhauNV.getText().equals("")
						|| jpNhapLaiMatKhauNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng chá»�n nhÃ¢n viÃªn cáº§n cáº­p nháº­t!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else if (jpMatKhauNV.getText().equals(jpNhapLaiMatKhauNV.getText()) == false) {
					JOptionPane.showMessageDialog(null, "Máº­t kháº©u khÃ´ng khá»›p nháº­p láº¡i máº­t kháº©u!");
					jpMatKhauNV.setText(null);
					jpNhapLaiMatKhauNV.setText(null);
				} 
				else {
					Date ngaysinh;
					nhanvien nv = new nhanvien();
					ArrayList<nhanvien> alnv = NhanVienModel.listNV;
					for (int i = 0; i < alnv.size(); i++) {
						if (index == i) {
							nv.setID(alnv.get(i).getID());
							nv.setTenDangNhap(txtTenDangNhapNV.getText());
							String matkhaudahash;
							
							try {
								matkhaudahash = nhanvienDAO.GetPasswordHashText(jpNhapLaiMatKhauNV.getText());
								 //matkhaudahash = nhanvienDAO.encrypt(jpNhapLaiMatKhauNV.getText());
								nv.setMatKhau(matkhaudahash);

							} catch (NoSuchAlgorithmException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} catch (UnsupportedEncodingException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}

							nv.setHoTenNV(txtHoTenNV.getText());
							try {
								ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(datePicker.getJFormattedTextField().getText());
								nv.setNgaySinh(ngaysinh);
							} catch (ParseException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							
							nv.setDiaChi(taDiaChiNV.getText());
							nv.setSDT(txtSDTNV.getText());
							nv.setTinhTrang(0);
							nv.setMaCV(cmbChucVuNV.getSelectedIndex()+1);
						}
					}
					try {
						if (nhanvienDAO.suaNhanVien(nv) == true) {
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDNV.setText(null);
							txtHoTenNV.setText(null);
							datePicker.getJFormattedTextField().setText(null);
							txtSDTNV.setText(null);
							taDiaChiNV.setText(null);
							txtTenDangNhapNV.setText(null);
							jpMatKhauNV.setText(null);
							jpNhapLaiMatKhauNV.setText(null);
							cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] {"BÃ¡c sÄ©", "Y tÃ¡"}));
							NhanVienModel mdNhanVien = new NhanVienModel();
							tableNV.setModel(mdNhanVien);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n nhÃ¢n viÃªn sá»­a !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-edit.png"));
		btnCapNhatNV.setForeground(Color.RED);
		btnCapNhatNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatNV.setBounds(200, 294, 140, 41);
		pnNhanVien.add(btnCapNhatNV);

		JButton btnXoaNV = new JButton("Xoa");
		btnXoaNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("") || datePicker.getJFormattedTextField().getText().equals("")
						|| txtSDTNV.getText().equals("") || taDiaChiNV.getText().equals("")
						|| txtTenDangNhapNV.getText().equals("") || jpMatKhauNV.getText().equals("")
						|| jpNhapLaiMatKhauNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng chá»�n nhÃ¢n viÃªn cáº§n xÃ³a!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					nhanvien nv = new nhanvien();
					ArrayList<nhanvien> alnv = NhanVienModel.listNV;
					for (int i = 0; i < alnv.size(); i++) {
						if (index == i) {
							nv.setID(alnv.get(i).getID());
							nv.setTenDangNhap(alnv.get(i).getTenDangNhap());
							nv.setMatKhau(alnv.get(i).getMatKhau());
							nv.setHoTenNV(alnv.get(i).getHoTenNV());
							nv.setNgaySinh(alnv.get(i).getNgaySinh());
							nv.setDiaChi(alnv.get(i).getDiaChi());
							nv.setSDT(alnv.get(i).getSDT());
							nv.setTinhTrang(1);
							nv.setMaCV(alnv.get(i).getMaCV());
						}
					}
					try {
						if (nhanvienDAO.suaNhanVien(nv) == true) {
							JOptionPane.showMessageDialog(null, "XÃ³a thÃ nh cÃ´ng !", "WARNING",
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
							JOptionPane.showMessageDialog(null,
									"XÃ³a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n nhÃ¢n viÃªn xÃ³a!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		});
		btnXoaNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\user-blue-delete.png"));
		btnXoaNV.setForeground(Color.RED);
		btnXoaNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoaNV.setBounds(383, 294, 103, 41);
		pnNhanVien.add(btnXoaNV);

		JButton btnLoadNV = new JButton("Load");
		btnLoadNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
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
				cmbChucVuNV.setModel(new DefaultComboBoxModel(new String[] {"BÃ¡c sÄ©", "Y tÃ¡"}));
				NhanVienModel mdNhanVien = new NhanVienModel();
				tableNV.setModel(mdNhanVien);
			}
		});
		btnLoadNV.setForeground(Color.RED);
		btnLoadNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadNV.setBounds(676, 294, 109, 41);
		pnNhanVien.add(btnLoadNV);

		tableNV = new JTable();
		NhanVienModel modelNV = new NhanVienModel();
		tableNV.setModel(modelNV);
		JScrollPane scrollPaneNV = new JScrollPane(tableNV);// dan table vao khung jsp
		scrollPaneNV.setBounds(46, 354, 735, 169);
		pnNhanVien.add(scrollPaneNV);

		tableNV.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableNV.getSelectedRow() >= 0) {
					lblIDNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 0).toString());
					txtTenDangNhapNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 1).toString());
					jpMatKhauNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 2).toString());
					txtHoTenNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 3).toString());
					datePicker.getJFormattedTextField().setText(tableNV.getValueAt(tableNV.getSelectedRow(), 4).toString());
					taDiaChiNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 5).toString());
					txtSDTNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 6).toString());
					cmbChucVuNV.setSelectedItem(tableNV.getValueAt(tableNV.getSelectedRow(), 7).toString());
					jpNhapLaiMatKhauNV.setText(tableNV.getValueAt(tableNV.getSelectedRow(), 2).toString());
					index = tableNV.getSelectedRow();
//					try {
//						System.out.println(nhanvienDAO.unHash(jpMatKhauNV.getText().toString()));
//					} catch (NoSuchAlgorithmException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					} catch (UnsupportedEncodingException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
				}
			}
		});

		JButton btnTimNV = new JButton("Tim");
		btnTimNV.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtHoTenNV.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui nháº­p tÃªn nhÃ¢n viÃªn cáº§n tÃ¬m!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					NhanVienTimKiemModel modelNV = new NhanVienTimKiemModel(txtHoTenNV.getText());
					tableNV.setModel(modelNV);
				}
			}
		});
		btnTimNV.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
		btnTimNV.setForeground(Color.RED);
		btnTimNV.setFont(new Font("Arial", Font.PLAIN, 17));
		btnTimNV.setBounds(527, 294, 109, 41);
		pnNhanVien.add(btnTimNV);
		
		JButton btnDangXuat = new JButton("");
		btnDangXuat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuat.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuat.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuat.setForeground(Color.RED);
		btnDangXuat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuat.setBounds(806, 0, 42, 42);
		pnNhanVien.add(btnDangXuat);
		
		

		JPanel pnLoaiBenh = new JPanel();
		tabbedPane.addTab("Loai Benh", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\loaibenh.png"),
				pnLoaiBenh, null);
		pnLoaiBenh.setLayout(null);

		JLabel lblQunLLoi = new JLabel("QUAN LY LOAI BENH");
		lblQunLLoi.setForeground(Color.RED);
		lblQunLLoi.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLLoi.setBounds(320, 11, 201, 35);
		pnLoaiBenh.add(lblQunLLoi);

		JLabel lblIdMaloaibenh = new JLabel("ID LoaiBenh");
		lblIdMaloaibenh.setForeground(Color.BLUE);
		lblIdMaloaibenh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdMaloaibenh.setBounds(234, 64, 103, 27);
		pnLoaiBenh.add(lblIdMaloaibenh);

		JLabel lblIDLoaiBenh = new JLabel("ID LoaiBenh");
		lblIDLoaiBenh.setForeground(Color.BLUE);
		lblIDLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDLoaiBenh.setBounds(365, 66, 103, 27);
		pnLoaiBenh.add(lblIDLoaiBenh);

		JLabel lblMLoiBnh = new JLabel("Ma loai benh");
		lblMLoiBnh.setForeground(Color.BLUE);
		lblMLoiBnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMLoiBnh.setBounds(234, 102, 103, 27);
		pnLoaiBenh.add(lblMLoiBnh);

		txtMaLoaiBenh = new JTextField();
		txtMaLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaLoaiBenh.setColumns(10);
		txtMaLoaiBenh.setBounds(365, 104, 217, 25);
		pnLoaiBenh.add(txtMaLoaiBenh);

		JLabel lblTnLoiBnh = new JLabel("Ten loai benh");
		lblTnLoiBnh.setForeground(Color.BLUE);
		lblTnLoiBnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTnLoiBnh.setBounds(234, 140, 103, 27);
		pnLoaiBenh.add(lblTnLoiBnh);

		txtTenLoaiBenh = new JTextField();
		txtTenLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenLoaiBenh.setColumns(10);
		txtTenLoaiBenh.setBounds(365, 142, 217, 25);
		pnLoaiBenh.add(txtTenLoaiBenh);

		JLabel lblTriuChng = new JLabel("Trieu chung");
		lblTriuChng.setForeground(Color.BLUE);
		lblTriuChng.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTriuChng.setBounds(234, 178, 125, 27);
		pnLoaiBenh.add(lblTriuChng);

		JTextArea taTrieuChungLoaiBenh = new JTextArea();
		taTrieuChungLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		taTrieuChungLoaiBenh.setBounds(365, 178, 217, 74);
		pnLoaiBenh.add(taTrieuChungLoaiBenh);

		JButton btnThemLoaiBenh = new JButton("Them");
		btnThemLoaiBenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaLoaiBenh.getText().equals("") || txtTenLoaiBenh.getText().equals("")
						|| taTrieuChungLoaiBenh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				} else if (loaibenhDAO.timMaLoaiBenh(txtMaLoaiBenh.getText()) != null) {
					JOptionPane.showMessageDialog(null, "MÃ£ loáº¡i bá»‡nh Ä‘Ã£ tá»“n táº¡i!");
				} else {
					loaibenh lb = new loaibenh();
					lb.setMaLoaiBenh(txtMaLoaiBenh.getText());
					lb.setTenLoaiBenh(txtTenLoaiBenh.getText());
					lb.setTrieuChung(taTrieuChungLoaiBenh.getText());
					try {
						if (DAO.loaibenhDAO.themLoaiBenh(lb) == true) {
							JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm loáº¡i bá»‡nh: " + txtMaLoaiBenh.getText());
							lblIDLoaiBenh.setText(null);
							txtMaLoaiBenh.setText(null);
							txtTenLoaiBenh.setText(null);
							taTrieuChungLoaiBenh.setText(null);
							LoaiBenhModel mdLoaiBenh = new LoaiBenhModel();
							tableLoaiBenh.setModel(mdLoaiBenh);
						} else {
							JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnThemLoaiBenh.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemLoaiBenh.setForeground(Color.RED);
		btnThemLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemLoaiBenh.setBounds(188, 281, 115, 41);
		pnLoaiBenh.add(btnThemLoaiBenh);

		JButton btnCapNhatLoaiBenh = new JButton("Cap nhat");
		btnCapNhatLoaiBenh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaLoaiBenh.getText().equals("") || txtTenLoaiBenh.getText().equals("")
						|| taTrieuChungLoaiBenh.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					loaibenh lb = new loaibenh();
					ArrayList<loaibenh> allb = LoaiBenhModel.listLB;
					for (int i = 0; i < allb.size(); i++) {
						if (index == i) {
							lb.setID(allb.get(i).getID());
							lb.setMaLoaiBenh(txtMaLoaiBenh.getText());
							lb.setTenLoaiBenh(txtTenLoaiBenh.getText());
							lb.setTrieuChung(taTrieuChungLoaiBenh.getText());
						}
					}
					try {
						if (loaibenhDAO.suaLoaiBenh(lb) == true) {
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDLoaiBenh.setText(null);
							txtMaLoaiBenh.setText(null);
							txtTenLoaiBenh.setText(null);
							taTrieuChungLoaiBenh.setText(null);
							LoaiBenhModel mdLoaiBenh = new LoaiBenhModel();
							tableLoaiBenh.setModel(mdLoaiBenh);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n loáº¡i bá»‡nh sá»­a !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatLoaiBenh.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatLoaiBenh.setForeground(Color.RED);
		btnCapNhatLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatLoaiBenh.setBounds(369, 281, 140, 41);
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
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadLoaiBenh.setForeground(Color.RED);
		btnLoadLoaiBenh.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadLoaiBenh.setBounds(565, 281, 109, 41);
		pnLoaiBenh.add(btnLoadLoaiBenh);

		tableLoaiBenh = new JTable();
		LoaiBenhModel modelLB = new LoaiBenhModel();
		tableLoaiBenh.setModel(modelLB);
		JScrollPane scrollPanelb = new JScrollPane(tableLoaiBenh);// dan table vao khung jsp
		scrollPanelb.setBounds(188, 354, 486, 169);
		pnLoaiBenh.add(scrollPanelb);
		
		JButton btnDangXuatLB = new JButton("");
		btnDangXuatLB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuatLB.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatLB.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuatLB.setForeground(Color.RED);
		btnDangXuatLB.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatLB.setBounds(806, 0, 42, 42);
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
					index = tableLoaiBenh.getSelectedRow();
				}
			}
		});

		// ql Thuoc
		JPanel pnThuoc = new JPanel();
		tabbedPane.addTab("Thuoc", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\thuoc.jpg"),
				pnThuoc, null);
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		pnThuoc.setLayout(null);

		JLabel lblQunLthuc = new JLabel("QUAN LY THUOC");
		lblQunLthuc.setForeground(Color.RED);
		lblQunLthuc.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLthuc.setBounds(326, 11, 205, 35);
		pnThuoc.add(lblQunLthuc);

		JLabel lblidThuoc = new JLabel("ID thuoc");
		lblidThuoc.setForeground(Color.BLUE);
		lblidThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblidThuoc.setBounds(53, 80, 103, 27);
		pnThuoc.add(lblidThuoc);

		JLabel lblIDThuoc = new JLabel("ID thuoc");
		lblIDThuoc.setForeground(Color.BLUE);
		lblIDThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDThuoc.setBounds(176, 80, 103, 27);
		pnThuoc.add(lblIDThuoc);

		JLabel lblMaThuoc = new JLabel("Ma thuoc");
		lblMaThuoc.setForeground(Color.BLUE);
		lblMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaThuoc.setBounds(53, 118, 103, 27);
		pnThuoc.add(lblMaThuoc);

		txtMaThuoc = new JTextField();
		txtMaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaThuoc.setColumns(10);
		txtMaThuoc.setBounds(176, 118, 170, 25);
		pnThuoc.add(txtMaThuoc);

		JLabel llbTenThuoc = new JLabel("Ten thuoc");
		llbTenThuoc.setForeground(Color.BLUE);
		llbTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		llbTenThuoc.setBounds(53, 156, 103, 27);
		pnThuoc.add(llbTenThuoc);

		txtTenThuoc = new JTextField();
		txtTenThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenThuoc.setColumns(10);
		txtTenThuoc.setBounds(176, 156, 170, 25);
		pnThuoc.add(txtTenThuoc);

		JLabel lblDonGia = new JLabel("Don gia");
		lblDonGia.setForeground(Color.BLUE);
		lblDonGia.setFont(new Font("Arial", Font.PLAIN, 17));
		lblDonGia.setBounds(464, 118, 103, 27);
		pnThuoc.add(lblDonGia);

		txtDonGiaThuoc = new JTextField();
		txtDonGiaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtDonGiaThuoc.setColumns(10);
		txtDonGiaThuoc.setBounds(622, 118, 170, 25);
		pnThuoc.add(txtDonGiaThuoc);

		JLabel lblnVTnh = new JLabel("Don vi thuoc");
		lblnVTnh.setForeground(Color.BLUE);
		lblnVTnh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblnVTnh.setBounds(464, 156, 103, 27);
		pnThuoc.add(lblnVTnh);

		JComboBox cmbDonViTinhThuoc = new JComboBox();
		cmbDonViTinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		cmbDonViTinhThuoc.setBounds(622, 157, 170, 25);
		cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
		pnThuoc.add(cmbDonViTinhThuoc);

		JButton btnThemThuoc = new JButton("Them");
		btnThemThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				}else if (thuocDAO.timMaThuoc(txtMaThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "MÃ£ Ä‘Æ¡n vá»‹ Ä‘Ã£ tá»“n táº¡i!");
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					t.setMaThuoc(txtMaThuoc.getText());
					t.setTenThuoc(txtTenThuoc.getText());
					t.setDonGia(Float.parseFloat(txtDonGiaThuoc.getText()));
					t.setTinhTrang(0);
					dv = donvithuocDAO.timDonViTheoTenDonVi(cmbDonViTinhThuoc.getSelectedItem().toString());
					t.setDv(dv);
					try {
						if (DAO.thuocDAO.themThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm thuá»‘c: " + txtMaThuoc.getText());
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnThemThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemThuoc.setForeground(Color.RED);
		btnThemThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemThuoc.setBounds(114, 230, 115, 41);
		pnThuoc.add(btnThemThuoc);

		JButton btnCapNhatThuoc = new JButton("Cap nhat");
		btnCapNhatThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng chá»�n thuá»‘c sá»­a!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					ArrayList<thuoc> allT = ThuocModel.listT;
					for (int i = 0; i < allT.size(); i++) {
						if (index == i) {
							t.setID(allT.get(i).getID());
							t.setMaThuoc(txtMaThuoc.getText());
							t.setTenThuoc(txtTenThuoc.getText());
							t.setDonGia(Float.parseFloat(txtDonGiaThuoc.getText()));
							t.setTinhTrang(0);
							dv = donvithuocDAO.timDonViTheoTenDonVi(cmbDonViTinhThuoc.getSelectedItem().toString());
							t.setDv(dv);
						}
					}
					try {
						if (thuocDAO.suaThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n thuá»‘c sá»­a !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatThuoc.setForeground(Color.RED);
		btnCapNhatThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatThuoc.setBounds(285, 230, 140, 41);
		pnThuoc.add(btnCapNhatThuoc);

		JButton btnXoaThuoc = new JButton("Xoa");
		btnXoaThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaThuoc.getText().equals("") || txtTenThuoc.getText().equals("")
						|| txtDonGiaThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng chá»�n thuá»‘c xÃ³a!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					thuoc t = new thuoc();
					donvi dv = new donvi();
					ArrayList<thuoc> allT = ThuocModel.listT;
					for (int i = 0; i < allT.size(); i++) {
						if (index == i) {
							t.setID(allT.get(i).getID());
							t.setMaThuoc(allT.get(i).getMaThuoc());
							t.setTenThuoc(allT.get(i).getTenThuoc());
							t.setDonGia(allT.get(i).getDonGia());
							t.setTinhTrang(1);
							t.setDv(allT.get(i).getDv());
						}
					}
					try {
						if (thuocDAO.suaThuoc(t) == true) {
							JOptionPane.showMessageDialog(null, "XÃ³a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDThuoc.setText(null);
							txtMaThuoc.setText(null);
							txtTenThuoc.setText(null);
							txtDonGiaThuoc.setText(null);
							cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
							ThuocModel mdT = new ThuocModel();
							tableThuoc.setModel(mdT);
						} else {
							JOptionPane.showMessageDialog(null,
									"XÃ³a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n thuá»‘c xÃ³a!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnXoaThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
		btnXoaThuoc.setForeground(Color.RED);
		btnXoaThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnXoaThuoc.setBounds(468, 230, 103, 41);
		pnThuoc.add(btnXoaThuoc);

		JButton btnLoadThuoc = new JButton("Load");
		btnLoadThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDThuoc.setText(null);
				txtMaThuoc.setText(null);
				txtTenThuoc.setText(null);
				txtDonGiaThuoc.setText(null);
				cmbDonViTinhThuoc.setModel(new DonViTinhThuocComboModel(DAO.donvithuocDAO.LayDanhSachDonVi()));
				ThuocModel mdT = new ThuocModel();
				tableThuoc.setModel(mdT);
			}
		});
		btnLoadThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadThuoc.setForeground(Color.RED);
		btnLoadThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadThuoc.setBounds(626, 230, 109, 41);
		pnThuoc.add(btnLoadThuoc);

		tableThuoc = new JTable();
		ThuocModel modelT = new ThuocModel();
		tableThuoc.setModel(modelT);
		JScrollPane scrollPaneT = new JScrollPane(tableThuoc);// dan table vao khung jsp
		scrollPaneT.setBounds(53, 315, 739, 179);
		pnThuoc.add(scrollPaneT);
		
		JButton btnDangXuatT = new JButton("");
		btnDangXuatT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuatT.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatT.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuatT.setForeground(Color.RED);
		btnDangXuatT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatT.setBounds(806, 0, 42, 42);
		pnThuoc.add(btnDangXuatT);

		tableThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableThuoc.getSelectedRow() >= 0) {
					lblIDThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 0).toString());
					txtMaThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 1).toString());
					txtTenThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 2).toString());
					txtDonGiaThuoc.setText(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 3).toString());
					cmbDonViTinhThuoc.setSelectedItem(tableThuoc.getValueAt(tableThuoc.getSelectedRow(), 4).toString());
					index = tableThuoc.getSelectedRow();
				}
			}
		});

		// ql Don vi thuoc
		JPanel pnDonViThuoc = new JPanel();
		tabbedPane.addTab("Don Vi Thuoc", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\donvithuoc.jpg"),
				pnDonViThuoc, null);
		tabbedPane.setBackgroundAt(3, new Color(255, 255, 255));
		pnDonViThuoc.setLayout(null);

		JLabel lblQunLn = new JLabel("QUAN LY DON VI THUOC");
		lblQunLn.setForeground(Color.RED);
		lblQunLn.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLn.setBounds(307, 11, 244, 35);
		pnDonViThuoc.add(lblQunLn);

		JLabel lblIdnV = new JLabel("ID Don vi");
		lblIdnV.setForeground(Color.BLUE);
		lblIdnV.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdnV.setBounds(215, 78, 103, 27);
		pnDonViThuoc.add(lblIdnV);

		JLabel lblIDDonViThuoc = new JLabel("ID Don vi");
		lblIDDonViThuoc.setForeground(Color.BLUE);
		lblIDDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDDonViThuoc.setBounds(381, 78, 103, 27);
		pnDonViThuoc.add(lblIDDonViThuoc);

		JLabel lblMaDonViThuoc = new JLabel("Ma don vi");
		lblMaDonViThuoc.setForeground(Color.BLUE);
		lblMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaDonViThuoc.setBounds(215, 116, 123, 27);
		pnDonViThuoc.add(lblMaDonViThuoc);

		txtMaDonViThuoc = new JTextField();
		txtMaDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaDonViThuoc.setColumns(10);
		txtMaDonViThuoc.setBounds(381, 116, 170, 25);
		pnDonViThuoc.add(txtMaDonViThuoc);

		JLabel lblTenDonViThuoc = new JLabel("Ten don vi");
		lblTenDonViThuoc.setForeground(Color.BLUE);
		lblTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenDonViThuoc.setBounds(215, 154, 123, 27);
		pnDonViThuoc.add(lblTenDonViThuoc);

		txtTenDonViThuoc = new JTextField();
		txtTenDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDonViThuoc.setColumns(10);
		txtTenDonViThuoc.setBounds(381, 154, 170, 25);
		pnDonViThuoc.add(txtTenDonViThuoc);

		JButton tbnThemDonViThuoc = new JButton("Them");
		tbnThemDonViThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				} else if (donvithuocDAO.timMaDonVi(txtMaDonViThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "MÃ£ Ä‘Æ¡n vá»‹ Ä‘Ã£ tá»“n táº¡i!");
				} else {
					donvi dv = new donvi();
					dv.setMaDonVi(txtMaDonViThuoc.getText());
					dv.setTenDonVi(txtTenDonViThuoc.getText());
					try {
						if (DAO.donvithuocDAO.themDonViThuoc(dv) == true) {
							JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm Ä‘Æ¡n vá»‹ thuá»‘c: " + txtMaDonViThuoc.getText());
							lblIDDonViThuoc.setText(null);
							txtMaDonViThuoc.setText(null);
							txtTenDonViThuoc.setText(null);
							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
							tableDonViThuoc.setModel(mdDonVi);
						} else {
							JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});

		tbnThemDonViThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		tbnThemDonViThuoc.setForeground(Color.RED);
		tbnThemDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		tbnThemDonViThuoc.setBounds(163, 233, 115, 41);
		pnDonViThuoc.add(tbnThemDonViThuoc);

		JButton btnCapNhatDonViThuoc = new JButton("Cap nhat");
		btnCapNhatDonViThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaDonViThuoc.getText().equals("") || txtTenDonViThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					donvi dv = new donvi();
					ArrayList<donvi> aldv = DonViTinhThuocModelqlt.listDV;
					for (int i = 0; i < aldv.size(); i++) {
						if (index == i) {
							dv.setID(aldv.get(i).getID());
							dv.setMaDonVi(txtMaDonViThuoc.getText());
							dv.setTenDonVi(txtTenDonViThuoc.getText());
						}
					}
					try {
						if (donvithuocDAO.suaDonViThuoc(dv) == true) {
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDDonViThuoc.setText(null);
							txtMaDonViThuoc.setText(null);
							txtTenDonViThuoc.setText(null);
							DonViTinhThuocModelqlt mdDonVi = new DonViTinhThuocModelqlt();
							tableDonViThuoc.setModel(mdDonVi);
						} else {
							JOptionPane.showMessageDialog(null, "Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n Ä‘Æ¡n vá»‹ sá»¯a !",
									"WARNING", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatDonViThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatDonViThuoc.setForeground(Color.RED);
		btnCapNhatDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatDonViThuoc.setBounds(343, 233, 140, 41);
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
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadDonViThuoc.setForeground(Color.RED);
		btnLoadDonViThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadDonViThuoc.setBounds(540, 233, 109, 41);
		pnDonViThuoc.add(btnLoadDonViThuoc);

		// táº¡o table
		tableDonViThuoc = new JTable();
		DonViTinhThuocModelqlt modelDonViThuoc = new DonViTinhThuocModelqlt();
		tableDonViThuoc.setModel(modelDonViThuoc);
		JScrollPane scrollPane1 = new JScrollPane(tableDonViThuoc);// dan table vao khung jsp
		scrollPane1.setBounds(163, 325, 486, 169);
		// tableDonViThuoc.setBounds(163, 325, 486, 169);
		pnDonViThuoc.add(scrollPane1);
		
		JButton btnDangXuatDVT = new JButton("");
		btnDangXuatDVT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuatDVT.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatDVT.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuatDVT.setForeground(Color.RED);
		btnDangXuatDVT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatDVT.setBounds(806, 0, 42, 42);
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
					index = tableDonViThuoc.getSelectedRow();
				}
			}
		});

		// ql cach dung
		JPanel pnCachDung = new JPanel();
		tabbedPane.addTab("Cach Dung", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\huongdan.png"),
				pnCachDung, null);
		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
		pnCachDung.setLayout(null);

		JLabel lblQunLCch = new JLabel("QUAN LY CACH DUNG");
		lblQunLCch.setForeground(Color.RED);
		lblQunLCch.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLCch.setBounds(266, 11, 289, 35);
		pnCachDung.add(lblQunLCch);

		JLabel lblIdCD = new JLabel("ID cach dung");
		lblIdCD.setForeground(Color.BLUE);
		lblIdCD.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdCD.setBounds(234, 78, 103, 27);
		pnCachDung.add(lblIdCD);

		JLabel lblIDCachDung = new JLabel("ID cach dung");
		lblIDCachDung.setForeground(Color.BLUE);
		lblIDCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDCachDung.setBounds(414, 80, 103, 27);
		pnCachDung.add(lblIDCachDung);

		JLabel lblMaCachDungThuoc = new JLabel("Ma cach dung thuoc");
		lblMaCachDungThuoc.setForeground(Color.BLUE);
		lblMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMaCachDungThuoc.setBounds(234, 116, 170, 27);
		pnCachDung.add(lblMaCachDungThuoc);

		txtMaCachDungThuoc = new JTextField();
		txtMaCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaCachDungThuoc.setColumns(10);
		txtMaCachDungThuoc.setBounds(414, 118, 170, 25);
		pnCachDung.add(txtMaCachDungThuoc);

		txtTenCachDungThuoc = new JTextField();
		txtTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenCachDungThuoc.setColumns(10);
		txtTenCachDungThuoc.setBounds(414, 156, 170, 25);
		pnCachDung.add(txtTenCachDungThuoc);

		JButton btnThemCachDung = new JButton("Them");
		btnThemCachDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				} else if (cachdungDAO.timMaCachDung(txtMaCachDungThuoc.getText()) != null) {
					JOptionPane.showMessageDialog(null, "MÃ£ cÃ¡ch dÃ¹ng Ä‘Ã£ tá»“n táº¡i!");
				} else {
					cachdung cd = new cachdung();
					cd.setMaCachDung(txtMaCachDungThuoc.getText());
					cd.setTenCachDung(txtTenCachDungThuoc.getText());
					try {
						if (DAO.cachdungDAO.themCachDung(cd) == true) {
							JOptionPane.showMessageDialog(null,
									"Ä�Ã£ thÃªm cÃ¡ch dÃ¹ng thuá»‘c: " + txtMaCachDungThuoc.getText());
							lblIDCachDung.setText(null);
							txtMaCachDungThuoc.setText(null);
							txtTenCachDungThuoc.setText(null);
							CachDungModel mdCachDung = new CachDungModel();
							tableCachDungThuoc.setModel(mdCachDung);
						} else {
							JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}

			}
		});
		btnThemCachDung.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemCachDung.setForeground(Color.RED);
		btnThemCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemCachDung.setBounds(166, 233, 115, 41);
		pnCachDung.add(btnThemCachDung);

		JButton btnCapNhatCachDung = new JButton("Cap nhat");
		btnCapNhatCachDung.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaCachDungThuoc.getText().equals("") || txtTenCachDungThuoc.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng!", "WARNING", JOptionPane.WARNING_MESSAGE);
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
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDCachDung.setText(null);
							txtMaCachDungThuoc.setText(null);
							txtTenCachDungThuoc.setText(null);
							CachDungModel mdCachDung = new CachDungModel();
							tableCachDungThuoc.setModel(mdCachDung);
						} else {
							JOptionPane.showMessageDialog(null,
									"Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n cÃ¡ch dÃ¹ng sá»¯a !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatCachDung.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatCachDung.setForeground(Color.RED);
		btnCapNhatCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatCachDung.setBounds(346, 233, 140, 41);
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
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadCachDung.setForeground(Color.RED);
		btnLoadCachDung.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadCachDung.setBounds(543, 233, 109, 41);
		pnCachDung.add(btnLoadCachDung);

		tableCachDungThuoc = new JTable();
		CachDungModel modelCD = new CachDungModel();
		tableCachDungThuoc.setModel(modelCD);
		JScrollPane scrollPaneCD = new JScrollPane(tableCachDungThuoc);// dan table vao khung jsp
		scrollPaneCD.setBounds(163, 325, 486, 169);
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
					index = tableCachDungThuoc.getSelectedRow();
				}
			}
		});

		JLabel lblTenCachDungThuoc = new JLabel("Ten cach dung thuoc");
		lblTenCachDungThuoc.setForeground(Color.BLUE);
		lblTenCachDungThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenCachDungThuoc.setBounds(234, 154, 170, 27);
		pnCachDung.add(lblTenCachDungThuoc);
		
		JButton btnDangXuatCD = new JButton("");
		btnDangXuatCD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuatCD.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatCD.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuatCD.setForeground(Color.RED);
		btnDangXuatCD.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatCD.setBounds(806, 0, 42, 42);
		pnCachDung.add(btnDangXuatCD);

		// ql quy dinh
		JPanel pnQuyDinh = new JPanel();
		tabbedPane.addTab("Quy Dinh", new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\quidinh.png"),
				pnQuyDinh, null);
		tabbedPane.setBackgroundAt(5, new Color(255, 255, 255));
		pnQuyDinh.setLayout(null);

		JLabel lblQunLQuy = new JLabel("QUAN LY QUY DINH");
		lblQunLQuy.setForeground(Color.RED);
		lblQunLQuy.setFont(new Font("Arial", Font.PLAIN, 20));
		lblQunLQuy.setBounds(313, 11, 201, 35);
		pnQuyDinh.add(lblQunLQuy);

		JLabel lblIdQuynh = new JLabel("ID Quy Dinh");
		lblIdQuynh.setForeground(Color.BLUE);
		lblIdQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIdQuynh.setBounds(268, 64, 103, 27);
		pnQuyDinh.add(lblIdQuynh);

		JLabel lblIDQuyDinh = new JLabel("ID quy dinh");
		lblIDQuyDinh.setForeground(Color.BLUE);
		lblIDQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblIDQuyDinh.setBounds(399, 66, 103, 27);
		pnQuyDinh.add(lblIDQuyDinh);

		JLabel lblMQuynh = new JLabel("Ma quy dinh\r\n");
		lblMQuynh.setForeground(Color.BLUE);
		lblMQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMQuynh.setBounds(268, 102, 170, 27);
		pnQuyDinh.add(lblMQuynh);

		txtMaQuyDinh = new JTextField();
		txtMaQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtMaQuyDinh.setColumns(10);
		txtMaQuyDinh.setBounds(399, 104, 170, 25);
		pnQuyDinh.add(txtMaQuyDinh);

		JLabel lblTnQuynh = new JLabel("Ten quy dinh");
		lblTnQuynh.setForeground(Color.BLUE);
		lblTnQuynh.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTnQuynh.setBounds(268, 140, 170, 27);
		pnQuyDinh.add(lblTnQuynh);

		txtTenQuyDinh = new JTextField();
		txtTenQuyDinh.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenQuyDinh.setColumns(10);
		txtTenQuyDinh.setBounds(399, 142, 170, 25);
		pnQuyDinh.add(txtTenQuyDinh);

		JButton btnThemQuyDinhThuoc = new JButton("Them");
		btnThemQuyDinhThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
						|| txtGiaTri.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng nháº­p Ä‘á»§ thÃ´ng tin!");
				} else if (quidinhDAO.timMaQuyDinh(txtMaQuyDinh.getText()) != null) {
					JOptionPane.showMessageDialog(null, "MÃ£ quy Ä‘á»‹nh Ä‘Ã£ tá»“n táº¡i!");
				} else {
					quidinh qd = new quidinh();
					qd.setMaQuiDinh(txtMaQuyDinh.getText());
					qd.setTenQuiDinh(txtTenQuyDinh.getText());
					qd.setGiaTri(Float.parseFloat(txtGiaTri.getText()));
					try {
						if (DAO.quidinhDAO.themQuyDinh(qd) == true) {
							JOptionPane.showMessageDialog(null, "Ä�Ã£ thÃªm quy Ä‘á»‹nh: " + txtMaQuyDinh.getText());
							lblIDQuyDinh.setText(null);
							txtMaQuyDinh.setText(null);
							txtTenQuyDinh.setText(null);
							txtGiaTri.setText(null);
							QuiDinhModel mdQuyDinh = new QuiDinhModel();
							tableQuyDinhThuoc.setModel(mdQuyDinh);
						} else {
							JOptionPane.showMessageDialog(null, "ThÃªm tháº¥t báº¡i!", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}

					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				}
			}
		});
		btnThemQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add-icon.png"));
		btnThemQuyDinhThuoc.setForeground(Color.RED);
		btnThemQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThemQuyDinhThuoc.setBounds(181, 238, 115, 41);
		pnQuyDinh.add(btnThemQuyDinhThuoc);

		JButton btnCapNhatQuyDinhThuoc = new JButton("Cap nhat");
		btnCapNhatQuyDinhThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (txtMaQuyDinh.getText().equals("") || txtTenQuyDinh.getText().equals("")
						|| txtGiaTri.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lÃ²ng click báº£ng!", "WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					quidinh qd = new quidinh();
					ArrayList<quidinh> alqd = QuiDinhModel.listQD;
					for (int i = 0; i < alqd.size(); i++) {
						if (index == i) {
							qd.setID(alqd.get(i).getID());
							qd.setMaQuiDinh(txtMaQuyDinh.getText());
							qd.setTenQuiDinh(txtTenQuyDinh.getText());
							qd.setGiaTri(Float.parseFloat(txtGiaTri.getText()));
						}
					}
					try {
						if (quidinhDAO.suaQuyDinh(qd) == true) {
							JOptionPane.showMessageDialog(null, "Sá»­a thÃ nh cÃ´ng !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							lblIDQuyDinh.setText(null);
							txtMaQuyDinh.setText(null);
							txtTenQuyDinh.setText(null);
							txtGiaTri.setText(null);
							QuiDinhModel mdQuyDinh = new QuiDinhModel();
							tableQuyDinhThuoc.setModel(mdQuyDinh);
						} else {
							JOptionPane.showMessageDialog(null, "Sá»­a tháº¥t báº¡i, vui lÃ²ng click báº£ng chá»�n quy Ä‘á»‹nh sá»¯a !",
									"WARNING", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lá»—i Nháº­p Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnCapNhatQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnCapNhatQuyDinhThuoc.setForeground(Color.RED);
		btnCapNhatQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnCapNhatQuyDinhThuoc.setBounds(361, 238, 140, 41);
		pnQuyDinh.add(btnCapNhatQuyDinhThuoc);

		JButton btnLoadQuyDinhThuoc = new JButton("Load");
		btnLoadQuyDinhThuoc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblIDQuyDinh.setText(null);
				txtMaQuyDinh.setText(null);
				txtTenQuyDinh.setText(null);
				txtGiaTri.setText(null);
				QuiDinhModel modelQuyDinh = new QuiDinhModel();
				tableQuyDinhThuoc.setModel(modelQuyDinh);
			}
		});
		btnLoadQuyDinhThuoc.setIcon(new ImageIcon(
				"E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Refresh.png"));
		btnLoadQuyDinhThuoc.setForeground(Color.RED);
		btnLoadQuyDinhThuoc.setFont(new Font("Arial", Font.PLAIN, 17));
		btnLoadQuyDinhThuoc.setBounds(558, 238, 109, 41);
		pnQuyDinh.add(btnLoadQuyDinhThuoc);

		tableQuyDinhThuoc = new JTable();
		QuiDinhModel modelQD = new QuiDinhModel();
		tableQuyDinhThuoc.setModel(modelQD);
		JScrollPane scrollPaneQD = new JScrollPane(tableQuyDinhThuoc);// dan table vao khung jsp
		scrollPaneQD.setBounds(115, 330, 610, 169);
		pnQuyDinh.add(scrollPaneQD);

		JLabel lblGiTr = new JLabel("Gia tri");
		lblGiTr.setForeground(Color.BLUE);
		lblGiTr.setFont(new Font("Arial", Font.PLAIN, 17));
		lblGiTr.setBounds(268, 178, 170, 27);
		pnQuyDinh.add(lblGiTr);

		txtGiaTri = new JTextField();
		txtGiaTri.setFont(new Font("Arial", Font.PLAIN, 17));
		txtGiaTri.setColumns(10);
		txtGiaTri.setBounds(399, 180, 170, 25);
		pnQuyDinh.add(txtGiaTri);
		
		JButton btnDangXuatQD = new JButton("");
		btnDangXuatQD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dangnhap dn = new dangnhap();
				dn.setVisible(true);
				dn.setLocationRelativeTo(null); // canh giá»¯a mÃ n hÃ¬nh
				nhanvienlayout.this.setVisible(false);
			}
		});
		btnDangXuatQD.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\logout.png"));
		btnDangXuatQD.setToolTipText("Ä�Äƒng xuáº¥t");
		btnDangXuatQD.setForeground(Color.RED);
		btnDangXuatQD.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangXuatQD.setBounds(806, 0, 42, 42);
		pnQuyDinh.add(btnDangXuatQD);
		tableQuyDinhThuoc.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (tableQuyDinhThuoc.getSelectedRow() >= 0) {
					lblIDQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 0).toString());
					txtMaQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 1).toString());
					txtTenQuyDinh.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 2).toString());
					txtGiaTri.setText(tableQuyDinhThuoc.getValueAt(tableQuyDinhThuoc.getSelectedRow(), 3).toString());
					index = tableQuyDinhThuoc.getSelectedRow();
				}
			}
		});
	}
}
