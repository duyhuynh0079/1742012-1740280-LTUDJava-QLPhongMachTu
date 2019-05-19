package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.nhanvienDAO;
import entity.nhanvien;
import show.NhanVienModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class doimatkhau extends JFrame {

	private JPanel contentPane;
	private JPasswordField pwMatKhauMoi;
	private JPasswordField pwReMatKhau;
	private JPasswordField pwMatKhauCu;
	static int manv=0;
	static String tennv = "";
	private String matkhaunhapvao;
	private String matkhauCSDL;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					doimatkhau frame = new doimatkhau(tennv, manv);
					frame.setLocationRelativeTo(null);
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
	public doimatkhau(String tennhanvien, int MANV) {
		tennv = tennhanvien;
		manv = MANV;
		setTitle(tennv + " Đổi mật khẩu" );
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMtKhu = new JLabel("ĐỔI MẬT KHẨU");
		lblMtKhu.setForeground(Color.RED);
		lblMtKhu.setFont(new Font("Arial", Font.PLAIN, 20));
		lblMtKhu.setBounds(161, 11, 143, 35);
		contentPane.add(lblMtKhu);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ");
		lblMtKhuC.setForeground(Color.BLUE);
		lblMtKhuC.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMtKhuC.setBounds(58, 63, 124, 27);
		contentPane.add(lblMtKhuC);
		
		JLabel lblMtKhuMi = new JLabel("Mật khẩu mới");
		lblMtKhuMi.setForeground(Color.BLUE);
		lblMtKhuMi.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMtKhuMi.setBounds(58, 101, 124, 27);
		contentPane.add(lblMtKhuMi);
		
		pwMatKhauMoi = new JPasswordField();
		pwMatKhauMoi.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	pwReMatKhau.requestFocus();
	            }else if(e.getKeyCode() == KeyEvent.VK_UP){
	            	pwMatKhauCu.requestFocus();
	            }
			}
		});
		pwMatKhauMoi.setBounds(216, 101, 170, 25);
		contentPane.add(pwMatKhauMoi);
		
		JButton btnDoiMatKhauDMT = new JButton("Đổi mật khẩu");
		btnDoiMatKhauDMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					matkhaunhapvao = nhanvienDAO.GetPasswordHashText(pwMatKhauCu.getText());
					matkhauCSDL = DAO.nhanvienDAO.layMatKhauNV(manv);
				} catch (NoSuchAlgorithmException | UnsupportedEncodingException e2) {
					e2.printStackTrace();
				}
				if(pwMatKhauCu.getText().equals("") || pwMatKhauMoi.getText().equals("") || pwReMatKhau.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
				}else if(pwMatKhauMoi.getText().equals(pwReMatKhau.getText())== false) {
					JOptionPane.showMessageDialog(null, "Mật khẩu không khớp, nhập lại mật khẩu mới!");
					pwMatKhauMoi.setText(null);
					pwReMatKhau.setText(null);
					
				}else if(matkhaunhapvao.equals(matkhauCSDL) == false) {
					JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ, nhập lại mật khẩu cũ!");
					pwMatKhauCu.setText(null);
				}else {
					Date ngaysinh;
					nhanvien nv = new nhanvien();
					nv.setID(manv);
					nv.setTenDangNhap(DAO.nhanvienDAO.layTenDangNhapNV(manv));
					String matkhaudahash = "";
					try {
						matkhaudahash = nhanvienDAO.GetPasswordHashText(pwReMatKhau.getText());
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nv.setMatKhau(matkhaudahash);
					nv.setHoTenNV(DAO.nhanvienDAO.layHoTenNV(manv));
					try {
						ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(DAO.nhanvienDAO.layNgaySinhNV(manv));
						nv.setNgaySinh(ngaysinh);
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nv.setDiaChi(DAO.nhanvienDAO.layDiaChiNV(manv));
					nv.setSDT(DAO.nhanvienDAO.laySDTNV(manv));
					nv.setTinhTrang(1);
					nv.setMaCV(DAO.nhanvienDAO.layMaChucVu(manv));
					try {
						if (nhanvienDAO.suaNhanVien(nv) == true) {
							setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
							int kq=JOptionPane.showConfirmDialog(null, "Đã đổi mật khẩu","Thông báo",JOptionPane.YES_NO_OPTION);
							if(kq==0)
							{
								dispose();
							}
							
						} else {
							JOptionPane.showMessageDialog(null,"Lỗi!", "WARNING",JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		});
		btnDoiMatKhauDMT.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update1.png"));
		btnDoiMatKhauDMT.setForeground(Color.RED);
		btnDoiMatKhauDMT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDoiMatKhauDMT.setBounds(58, 198, 170, 41);
		contentPane.add(btnDoiMatKhauDMT);
		
		JButton btnThoatDMT = new JButton("Thoát");
		btnThoatDMT.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
		btnThoatDMT.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnThoatDMT.setForeground(Color.RED);
		btnThoatDMT.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoatDMT.setBounds(256, 198, 130, 41);
		contentPane.add(btnThoatDMT);
		
		JLabel lblNhpLiMt = new JLabel("Nhập lại mật khẩu");
		lblNhpLiMt.setForeground(Color.BLUE);
		lblNhpLiMt.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNhpLiMt.setBounds(58, 139, 137, 27);
		contentPane.add(lblNhpLiMt);
		
		pwReMatKhau = new JPasswordField();
		pwReMatKhau.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						matkhaunhapvao = nhanvienDAO.GetPasswordHashText(pwMatKhauCu.getText());
						matkhauCSDL = DAO.nhanvienDAO.layMatKhauNV(manv);
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e2) {
						e2.printStackTrace();
					}
					if(pwMatKhauCu.getText().equals("") || pwMatKhauMoi.getText().equals("") || pwReMatKhau.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
					}else if(pwMatKhauMoi.getText().equals(pwReMatKhau.getText())== false) {
						JOptionPane.showMessageDialog(null, "Mật khẩu không khớp, nhập lại mật khẩu mới!");
						pwMatKhauMoi.setText(null);
						pwReMatKhau.setText(null);
						
					}else if(matkhaunhapvao.equals(matkhauCSDL) == false) {
						JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ, nhập lại mật khẩu cũ!");
						pwMatKhauCu.setText(null);
					}else {
						Date ngaysinh;
						nhanvien nv = new nhanvien();
						nv.setID(manv);
						nv.setTenDangNhap(DAO.nhanvienDAO.layTenDangNhapNV(manv));
						String matkhaudahash = "";
						try {
							matkhaudahash = nhanvienDAO.GetPasswordHashText(pwReMatKhau.getText());
						} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nv.setMatKhau(matkhaudahash);
						nv.setHoTenNV(DAO.nhanvienDAO.layHoTenNV(manv));
						try {
							ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(DAO.nhanvienDAO.layNgaySinhNV(manv));
							nv.setNgaySinh(ngaysinh);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nv.setDiaChi(DAO.nhanvienDAO.layDiaChiNV(manv));
						nv.setSDT(DAO.nhanvienDAO.laySDTNV(manv));
						nv.setTinhTrang(1);
						nv.setMaCV(DAO.nhanvienDAO.layMaChucVu(manv));
						try {
							if (nhanvienDAO.suaNhanVien(nv) == true) {
								setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
								int kq=JOptionPane.showConfirmDialog(null, "Đã đổi mật khẩu","Thông báo",JOptionPane.YES_NO_OPTION);
								if(kq==0)
								{
									dispose();
								}
								
							} else {
								JOptionPane.showMessageDialog(null,"Lỗi!", "WARNING",JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	            }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	pwMatKhauCu.requestFocus();
	            }else if(e.getKeyCode() == KeyEvent.VK_UP){
	            	pwMatKhauMoi.requestFocus();
	            }
			}
		});
		pwReMatKhau.setBounds(216, 139, 170, 25);
		contentPane.add(pwReMatKhau);
		
		pwMatKhauCu = new JPasswordField();
		pwMatKhauCu.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER){
					try {
						matkhaunhapvao = nhanvienDAO.GetPasswordHashText(pwMatKhauCu.getText());
						matkhauCSDL = DAO.nhanvienDAO.layMatKhauNV(manv);
					} catch (NoSuchAlgorithmException | UnsupportedEncodingException e2) {
						e2.printStackTrace();
					}
					if(pwMatKhauCu.getText().equals("") || pwMatKhauMoi.getText().equals("") || pwReMatKhau.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
					}else if(pwMatKhauMoi.getText().equals(pwReMatKhau.getText())== false) {
						JOptionPane.showMessageDialog(null, "Mật khẩu không khớp, nhập lại mật khẩu mới!");
						pwMatKhauMoi.setText(null);
						pwReMatKhau.setText(null);
						
					}else if(matkhaunhapvao.equals(matkhauCSDL) == false) {
						JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ, nhập lại mật khẩu cũ!");
						pwMatKhauCu.setText(null);
					}else {
						Date ngaysinh;
						nhanvien nv = new nhanvien();
						nv.setID(manv);
						nv.setTenDangNhap(DAO.nhanvienDAO.layTenDangNhapNV(manv));
						String matkhaudahash = "";
						try {
							matkhaudahash = nhanvienDAO.GetPasswordHashText(pwReMatKhau.getText());
						} catch (NoSuchAlgorithmException | UnsupportedEncodingException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nv.setMatKhau(matkhaudahash);
						nv.setHoTenNV(DAO.nhanvienDAO.layHoTenNV(manv));
						try {
							ngaysinh = new SimpleDateFormat("yyyy-MM-dd").parse(DAO.nhanvienDAO.layNgaySinhNV(manv));
							nv.setNgaySinh(ngaysinh);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						nv.setDiaChi(DAO.nhanvienDAO.layDiaChiNV(manv));
						nv.setSDT(DAO.nhanvienDAO.laySDTNV(manv));
						nv.setTinhTrang(1);
						nv.setMaCV(DAO.nhanvienDAO.layMaChucVu(manv));
						try {
							if (nhanvienDAO.suaNhanVien(nv) == true) {
								setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
								int kq=JOptionPane.showConfirmDialog(null, "Đã đổi mật khẩu","Thông báo",JOptionPane.YES_NO_OPTION);
								if(kq==0)
								{
									dispose();
								}
								
							} else {
								JOptionPane.showMessageDialog(null,"Lỗi!", "WARNING",JOptionPane.WARNING_MESSAGE);
							}
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Lỗi nhập sai!", "WARNING", JOptionPane.WARNING_MESSAGE);
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
	            }else if(e.getKeyCode() == KeyEvent.VK_DOWN){
	            	pwMatKhauMoi.requestFocus();
	            }
				
			}
		});
		pwMatKhauCu.setBounds(216, 61, 170, 25);
		contentPane.add(pwMatKhauCu);
	}
}
