package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.nhanvienDAO;
import entity.nhanvien;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTabbedPane;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.awt.event.ActionEvent;

public class dangnhap extends JFrame {

	private JPanel contentPane;
	private JTextField txtTenDangNhap;
	private JPasswordField pfMatKhau;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dangnhap frame = new dangnhap();
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
	public dangnhap() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		setTitle("ĐĂNG NHẬP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblngNhp = new JLabel("ĐĂNG NHẬP");
		lblngNhp.setForeground(Color.RED);
		lblngNhp.setFont(new Font("Arial", Font.PLAIN, 20));
		lblngNhp.setBounds(162, 11, 119, 35);
		contentPane.add(lblngNhp);
		
		JLabel lblTenDangNhap = new JLabel("Tên đăng nhập");
		lblTenDangNhap.setForeground(Color.BLUE);
		lblTenDangNhap.setFont(new Font("Arial", Font.PLAIN, 17));
		lblTenDangNhap.setBounds(59, 63, 124, 27);
		contentPane.add(lblTenDangNhap);
		
		txtTenDangNhap = new JTextField();
		txtTenDangNhap.setFont(new Font("Arial", Font.PLAIN, 17));
		txtTenDangNhap.setColumns(10);
		txtTenDangNhap.setBounds(217, 63, 170, 25);
		contentPane.add(txtTenDangNhap);
		
		JLabel lblMatKhau = new JLabel("Mật khẩu");
		lblMatKhau.setForeground(Color.BLUE);
		lblMatKhau.setFont(new Font("Arial", Font.PLAIN, 17));
		lblMatKhau.setBounds(59, 101, 124, 27);
		contentPane.add(lblMatKhau);
		
		pfMatKhau = new JPasswordField();
		pfMatKhau.setBounds(217, 101, 170, 25);
		contentPane.add(pfMatKhau);
		
		JButton btnDangNhap = new JButton("Đăng nhập");
		btnDangNhap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (txtTenDangNhap.getText().equals("") ||pfMatKhau.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đủ thông tin!");
				} else {
					nhanvien test = new nhanvien();
					test.setTenDangNhap(txtTenDangNhap.getText());
					try {
						test.setMatKhau(DAO.nhanvienDAO.GetPasswordHashText(pfMatKhau.getText()));
					} catch (NoSuchAlgorithmException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (UnsupportedEncodingException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					nhanvien tk  = DAO.nhanvienDAO.KiemTraTrung(test);
					if (tk != null) {
						if(tk.getMaCV() == 0){
							nhanvienlayout admin = new nhanvienlayout(tk.getTenDangNhap(),tk.getID());
							admin.setVisible(true);
							admin.setLocationRelativeTo(null); // canh giua man hinh
							dangnhap.this.setVisible(false);
						}else{
							tabNhanVien nv = new tabNhanVien(tk.getTenDangNhap(),tk.getID());
							nv.setVisible(true);
							nv.setSize(1000, 600);
							nv.setLocationRelativeTo(null);
							nv.setExtendedState(JFrame.MAXIMIZED_BOTH);
							dangnhap.this.setVisible(false);
						}
						
					} else {
						JOptionPane.showMessageDialog(null, "Tên đăng nhập hoặc tài khoản không khớp!");
						txtTenDangNhap.setText(null);
						pfMatKhau.setText(null);
					}
				}
			}
		});
		btnDangNhap.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\check.png"));
		btnDangNhap.setForeground(Color.RED);
		btnDangNhap.setFont(new Font("Arial", Font.PLAIN, 17));
		btnDangNhap.setBounds(59, 151, 158, 41);
		contentPane.add(btnDangNhap);
		
		JButton btnThoat = new JButton("Thoát");
		btnThoat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setDefaultCloseOperation(DO_NOTHING_ON_CLOSE );
				int kq=JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?","Thông báo",JOptionPane.YES_NO_OPTION);
				if(kq==0)
				{
					dispose();
				}
			}
		});
		btnThoat.setIcon(new ImageIcon("E:\\LienThong\\HocKy_IV\\Java\\DA1\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\delete.png"));
		btnThoat.setForeground(Color.RED);
		btnThoat.setFont(new Font("Arial", Font.PLAIN, 17));
		btnThoat.setBounds(257, 151, 130, 41);
		contentPane.add(btnThoat);
	}
}
