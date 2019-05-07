package layoutandrun;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import DAO.benhnhanDAO;
import entity.benhnhan;
import javafx.scene.control.ComboBox;
import show.showBenhNhan;

public class subtabBenhNhan extends JFrame implements ActionListener {
	private JTextField jtTimKiem;
	private JTextField jtHoTen;
	private JTextField jtNamSinh;
	private JTextField jtDiaChi;
	private JButton btnThem;
	private JButton btnSua;
	private JButton btnXemDanhSach;
	private JButton btnTimKiem;
	private JComboBox jcbb;
	private JTable jtb;
	static int index; // bat vi tri duyet al de sua
	private JLabel label_1;
	private JLabel jlMaBenhNhan;
	private JRadioButton rdbTenBenhNhan;
	private JRadioButton rdbMaBenhNhan;
	private JButton btnThemPhieu;

	public void controlBenhNhan(JPanel jpn) {

		String[] displayCBB = { "Nam", "Nữ", "Khác" };
		jtTimKiem = new JTextField();
		jtTimKiem.setFont(new Font("Arial", Font.PLAIN, 14));
		jtTimKiem.setToolTipText("Nhập tên hoặc mã bệnh nhân\r\n");
		jtTimKiem.setBounds(35, 99, 202, 37);
		jpn.add(jtTimKiem);
		jtTimKiem.setColumns(10);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\search.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setAlignmentY(Component.TOP_ALIGNMENT);
		btnTimKiem.setBounds(429, 99, 137, 37);
		jpn.add(btnTimKiem);

		btnXemDanhSach = new JButton("Xem Danh Sách");
		btnXemDanhSach.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\load.png"));
		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemDanhSach.setBounds(594, 99, 184, 37);
		jpn.add(btnXemDanhSach);

		JLabel lblNewLabel = new JLabel("QUẢN LÝ BỆNH NHÂN");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(527, 11, 299, 38);
		jpn.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mã Bệnh Nhân");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(880, 188, 103, 25);
		jpn.add(lblNewLabel_1);

		JLabel lblaCh = new JLabel("Địa Chỉ");
		lblaCh.setForeground(Color.BLUE);
		lblaCh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblaCh.setBounds(880, 479, 61, 25);
		jpn.add(lblaCh);

		JLabel lblGiiTnh = new JLabel("Giới Tính");
		lblGiiTnh.setForeground(Color.BLUE);
		lblGiiTnh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblGiiTnh.setBounds(880, 336, 71, 25);
		jpn.add(lblGiiTnh);

		JLabel lblNmSinh = new JLabel("Năm Sinh");
		lblNmSinh.setForeground(Color.BLUE);
		lblNmSinh.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNmSinh.setBounds(880, 407, 71, 25);
		jpn.add(lblNmSinh);

		jtHoTen = new JTextField();
		jtHoTen.setFont(new Font("Arial", Font.PLAIN, 14));
		jtHoTen.setBounds(1035, 249, 241, 37);
		jtHoTen.setToolTipText("Nhập họ tên bệnh nhân\r\n");
		jpn.add(jtHoTen);
		jtHoTen.setColumns(10);

		jtNamSinh = new JTextField();
		jtNamSinh.setFont(new Font("Arial", Font.PLAIN, 14));
		jtNamSinh.setToolTipText("Nhập năm sinh(số)\r\n");
		jtNamSinh.setColumns(10);
		jtNamSinh.setBounds(1035, 395, 111, 37);
		jpn.add(jtNamSinh);

		jtDiaChi = new JTextField();
		jtDiaChi.setFont(new Font("Arial", Font.PLAIN, 14));
		jtDiaChi.setColumns(10);
		jtDiaChi.setToolTipText("Nhập địa chỉ bệnh nhân\r\n");
		jtDiaChi.setBounds(1035, 467, 241, 37);
		jpn.add(jtDiaChi);

		jcbb = new JComboBox(displayCBB);
		jcbb.setBounds(1035, 323, 111, 38);
		jpn.add(jcbb);

		btnThem = new JButton("Thêm");
		btnThem.setSelectedIcon(null);
		btnThem.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add.png"));
		btnThem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThem.setBounds(880, 548, 111, 38);
		jpn.add(btnThem);

		btnSua = new JButton("Sửa");
		btnSua.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\update.png"));
		btnSua.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSua.setBounds(1035, 548, 111, 38);
		jpn.add(btnSua);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		label.setBounds(1025, 11, 121, 120);
		jpn.add(label);

		jtb = new JTable();
		showBenhNhan modelBenhNhan = new showBenhNhan();
		jtb.setModel(modelBenhNhan);// fill modelStudent vao jtable
		jtb.setFont(new Font("Arial", Font.PLAIN, 14));
		JScrollPane scrollPane = new JScrollPane(jtb);// dan table vao khung jsp
		JScrollBar jsb = new JScrollBar();
		scrollPane.add(jsb);
		scrollPane.setBounds(35, 188, 744, 481);
		jpn.add(scrollPane);

		label_1 = new JLabel("Họ Tên");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		label_1.setBounds(880, 270, 61, 25);
		jpn.add(label_1);

		jlMaBenhNhan = new JLabel();
		jlMaBenhNhan.setToolTipText("Nhập họ tên bệnh nhân\r\n");
		jlMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jlMaBenhNhan.setBounds(1035, 176, 111, 37);
		jpn.add(jlMaBenhNhan);

		rdbTenBenhNhan = new JRadioButton("Tên Bệnh Nhân");
		rdbTenBenhNhan.setFont(new Font("Arial", Font.BOLD, 12));
		rdbTenBenhNhan.setBounds(267, 87, 120, 30);
		jpn.add(rdbTenBenhNhan);

		rdbMaBenhNhan = new JRadioButton("Mã Bệnh Nhân");
		rdbMaBenhNhan.setFont(new Font("Arial", Font.BOLD, 12));
		rdbMaBenhNhan.setBounds(267, 125, 120, 15);
		jpn.add(rdbMaBenhNhan);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbTenBenhNhan);
		group.add(rdbMaBenhNhan);

		btnThemPhieu = new JButton("Thêm Phiếu Khám Bệnh");
		btnThemPhieu.setSelectedIcon(null);
		btnThemPhieu.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\add3.png"));
		btnThemPhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThemPhieu.setBounds(880, 608, 264, 61);
		jpn.add(btnThemPhieu);

		btnThem.setActionCommand("Them");
		btnThem.addActionListener(this);
		btnSua.setActionCommand("Sua");
		btnSua.addActionListener(this);
		btnXemDanhSach.setActionCommand("Xem");
		btnXemDanhSach.addActionListener(this);
		btnTimKiem.setActionCommand("Tim");
		btnTimKiem.addActionListener(this);
		btnThemPhieu.setActionCommand("ThemPhieu");
		btnThemPhieu.addActionListener(this);

		jtb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (jtb.getSelectedRow() >= 0) {
					jlMaBenhNhan.setText(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
					jtHoTen.setText(jtb.getValueAt(jtb.getSelectedRow(), 1).toString());
					jcbb.setSelectedItem(jtb.getValueAt(jtb.getSelectedRow(), 2).toString());
					jtNamSinh.setText(jtb.getValueAt(jtb.getSelectedRow(), 3).toString());
					jtDiaChi.setText(jtb.getValueAt(jtb.getSelectedRow(), 4).toString());
					index = jtb.getSelectedRow();
				}
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		System.out.println(command);
		if (command.equals("Them")) {
			String mabenhnhanthem = "";
			String hoten = jtHoTen.getText();
			String gioitinh = jcbb.getSelectedItem().toString();
			String namsinh = jtNamSinh.getText();
			String diachi = jtDiaChi.getText();
			ArrayList<benhnhan> alBN = showBenhNhan.albn;
			if (hoten.equals("") || namsinh.equals("") || diachi.equals("")) {
				JOptionPane.showMessageDialog(null, "Xuất hiện rỗng, Vui lòng nhập đầy đủ !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}else {
				if (validate.isNumber(namsinh) == false) {
					JOptionPane.showMessageDialog(null, "Nhập số cho năm sinh!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} 
				else {
					benhnhan bn = new benhnhan();
					if(alBN.size()==0)
					{
						mabenhnhanthem = "BN1";
					}
					else {
						String mabenhnhan;
						mabenhnhan = alBN.get(alBN.size()-1).getMaBenhNhan();
						int sothutu = Integer.parseInt(mabenhnhan.replace("BN",""));
						mabenhnhanthem ="BN" + (sothutu + 1); 
					}
					bn.setMaBenhNhan(mabenhnhanthem);
					bn.setTenBenhNhan(hoten);
					bn.setGioiTinh(gioitinh);
					bn.setNamSinh(Integer.parseInt(namsinh));
					bn.setDiaChi(diachi);
					try {
						if (benhnhanDAO.themBenhNhan(bn) == true) {
							JOptionPane.showMessageDialog(null, "Thêm thành công !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							showBenhNhan modelBenhNhan = new showBenhNhan();
							jtb.setModel(modelBenhNhan);
							jtHoTen.setText("");
							jtNamSinh.setText("");
							jtDiaChi.setText("");
							jlMaBenhNhan.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Thêm thất bại !", "WARNING", JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		if (command.equals("Sua")) {
			String mabenhnhan = jlMaBenhNhan.getText();
			String hoten = jtHoTen.getText();
			String gioitinh = jcbb.getSelectedItem().toString();
			String namsinh = jtNamSinh.getText();
			String diachi = jtDiaChi.getText();
			if (hoten.equals("") || namsinh.equals("") || diachi.equals("")) {
				JOptionPane.showMessageDialog(null, "Xuất hiện rỗng, Vui lòng nhập đầy đủ !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			} else {
				if (validate.isNumber(namsinh) == false) {
					JOptionPane.showMessageDialog(null, "Nhập số cho năm sinh!", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					ArrayList<benhnhan> alBN = showBenhNhan.albn;
					benhnhan bn = new benhnhan();
					for (int i = 0; i < alBN.size(); i++) {
						if (index == i) {
							bn.setID(alBN.get(i).getID());
							bn.setMaBenhNhan(mabenhnhan);
							bn.setTenBenhNhan(hoten);
							bn.setGioiTinh(gioitinh);
							bn.setNamSinh(Integer.parseInt(namsinh));
							bn.setDiaChi(diachi);
						}
					}
					try {
						if (benhnhanDAO.suaBenhNhan(bn) == true) {
							JOptionPane.showMessageDialog(null, "Sửa thành công !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
							showBenhNhan modelBenhNhan = new showBenhNhan();
							jtb.setModel(modelBenhNhan);
							jlMaBenhNhan.setText("");
							jtHoTen.setText("");
							jtNamSinh.setText("");
							jtDiaChi.setText("");

						} else {
							JOptionPane.showMessageDialog(null,
									"Sửa thất bại, vui lòng click bảng chọn bệnh nhân sữa !", "WARNING",
									JOptionPane.WARNING_MESSAGE);
						}
					} catch (Exception e1) {
						JOptionPane.showMessageDialog(null, "Lỗi Nhập Sai !", "WARNING", JOptionPane.WARNING_MESSAGE);
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		if (command.equals("Xem")) {
			showBenhNhan modelBenhNhan = new showBenhNhan();
			jtb.setModel(modelBenhNhan);
		}
		if (command.equals("Tim")) {
			int loai = 0;
			if(rdbTenBenhNhan.isSelected())
			{
				loai = 1;
			}
			else{
				if(rdbMaBenhNhan.isSelected())
				{
					loai = 2;
				}
				else
				{
					JOptionPane.showMessageDialog(null,
							"Tìm kiếm thất bại, click chọn Tên hoặc Mã, nhập vào khung rồi click Tìm Kiếm !", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				}
			}
			String timkiem = jtTimKiem.getText();
			showBenhNhan modelBenhNhan = new showBenhNhan(timkiem,loai);
			jtb.setModel(modelBenhNhan);
		}

		if(command.equals("ThemPhieu"))
		{
			String mabenhnhan = jlMaBenhNhan.getText();
			String tenbenhnhan = jtHoTen.getText();
			if(mabenhnhan=="")
			{
				JOptionPane.showMessageDialog(null,
						"Thêm thất bại, vui lòng click bảng chọn bệnh nhân !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
			else {
				try {
					formThemPhieu ftp = new formThemPhieu(mabenhnhan,tenbenhnhan);
					ftp.setVisible(true);
					ftp.setLocationRelativeTo(null);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
