package layoutandrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.loaibenhDAO;
import DAO.thuocDAO;
import entity.loaibenh;
import entity.thuoc1;
import show.QuyDinh1Model;
import show.QuyDinh2Model;
import show.QuyDinh4Model;
import show.QuyDinh6Model;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class subtabQuyDinh extends JFrame implements ActionListener {
	public subtabQuyDinh() {
	}

	private JPanel jpn;
	private JTable jtb;
	private JComboBox cbbQuyDinh;
	private JScrollPane jsp;
	private JButton btnDoiMatKhau;
	private JButton btnDangXuat;
	static int manv;
	static String tennv;
	static JFrame jfr;

	public void controlQuyDinh(JPanel jpn,int manv,String tennv,JFrame jfr) {
		// public static void main(String[] args) {
		// subtabQuyDinh frame = new subtabQuyDinh();
		// frame.setVisible(true);
		// }
		// public subtabQuyDinh() {
		// jpn = new JPanel();
		// getContentPane().add(jpn);
		// setSize(getMaximumSize());
		// setLocationRelativeTo(null);
		// jpn.setLayout(null);
		this.manv = manv;
		this.tennv = tennv;
		this.jfr = jfr;
		
		JLabel lblNewLabel = new JLabel("QUY ĐỊNH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(585, 11, 136, 50);
		jpn.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		jpn.add(label);

		JLabel lblNewLabel_1 = new JLabel("Quy định :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 159, 89, 26);
		jpn.add(lblNewLabel_1);

		String[] quydinh = { "Quy định 1", "Quy định 2", "Quy định 4", "Quy định 6" };
		cbbQuyDinh = new JComboBox(quydinh);
		cbbQuyDinh.setBounds(193, 158, 105, 26);
		jpn.add(cbbQuyDinh);

		jtb = new JTable();
		QuyDinh1Model model = new QuyDinh1Model();
		jtb.setModel(model);
		jtb.setFont(new Font("Arial", Font.PLAIN, 14));
		jsp = new JScrollPane(jtb);
		jsp.setBounds(94, 232, 1170, 214);
		jpn.add(jsp);

		JLabel lblNewLabel_2 = new JLabel(
				"*Những  trên của phòng mạch chỉ những chức vụ quản lý mới được thay đổi\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(94, 508, 581, 26);
		jpn.add(lblNewLabel_2);

		btnDoiMatKhau = new JButton("Đổi mật khẩu");
		btnDoiMatKhau.setHorizontalAlignment(SwingConstants.LEFT);
		btnDoiMatKhau.setForeground(Color.BLUE);
		btnDoiMatKhau.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDoiMatKhau.setBounds(1167, 28, 131, 33);
		jpn.add(btnDoiMatKhau);

		btnDangXuat = new JButton("");
		btnDangXuat.setIcon(new ImageIcon("E:\\sourcetree\\Source\\images\\logout.png"));
		btnDangXuat.setForeground(Color.BLUE);
		btnDangXuat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnDangXuat.setBounds(1308, 28, 32, 33);
		jpn.add(btnDangXuat);

		// su kien thay doi combobox
		cbbQuyDinh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cbbQuyDinh.getSelectedItem().equals("Quy định 1")) {
					QuyDinh1Model model = new QuyDinh1Model();
					jtb.setModel(model);
				}
				if (cbbQuyDinh.getSelectedItem().equals("Quy định 2")) {
					QuyDinh2Model model = new QuyDinh2Model();
					jtb.setModel(model);
				}
				if (cbbQuyDinh.getSelectedItem().equals("Quy định 4")) {
					QuyDinh4Model model = new QuyDinh4Model();
					jtb.setModel(model);
				}
				if (cbbQuyDinh.getSelectedItem().equals("Quy định 6")) {
					QuyDinh6Model model = new QuyDinh6Model();
					jtb.setModel(model);
				}
			}
		});
		btnDangXuat.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		btnDangXuat.setActionCommand("DangXuat");
		btnDoiMatKhau.setActionCommand("DoiMatKhau");
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		String command = arg0.getActionCommand();
		if (command.equals("DangXuat")) {
			int kq = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát chương trình?", "Thông báo",
					JOptionPane.YES_NO_OPTION);
			if (kq == 0) {
				mythread mt = new mythread();
				mt.start();
				this.dispose();
			}
		}
		
		if (command.equals("DoiMatKhau")) {
			doimatkhau dmk = new doimatkhau(tennv, manv);
			dmk.setVisible(true);
			dmk.setLocationRelativeTo(null);// canh giua man hinh
		}
	}
}
