package layoutandrun;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.hoadonDAO;
import DAO.phieukhamDAO;
import DAO.quydinh4DAO;
import DAO.thuocDAO;
import entity.quydinh4;
import show.showBenhNhan;

public class subtabPhieuKhamBenh extends JFrame implements ActionListener {
	private JLabel lblMaPhieuKham;
	private JLabel lblMaBenhNhan;
	private JLabel lblTenBenhNhan;
	private JLabel lblNgayKham;
	private JLabel lblTinhTrang;
	private JTable jtb;
	private JTextField jtTimPhieu;
	private JButton btnChiTiet;
	private JButton btnSuaPhieu;
	private JButton btnTimKiem;
	private JButton btnXemDanhSach;
	private JButton btnThanhToan;
	private JComboBox jcbb;
	private JLabel lblNewLabel_2;
	private JButton btnDoiMatKhau;
	private JButton btnDangXuat;
	static int manv;
	static String tennv;
	static JFrame jfr;
	private JRadioButton rdbTenBenhNhan;
	private JRadioButton rdbMaBenhNhan;
	private JRadioButton rdbMaPhieuKham;

	public void controlPhieuKhamBenh(JPanel jpn, int manv, String tennv, JFrame jfr) {
		this.manv = manv;
		this.tennv = tennv;
		this.jfr = jfr;

		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHIẾU KHÁM BỆNH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(460, 11, 377, 50);
		jpn.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		jpn.add(label);

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

		btnSuaPhieu = new JButton("Sửa Phiếu");
		btnSuaPhieu.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\edit2.png"));
		btnSuaPhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaPhieu.setBounds(959, 610, 174, 61);
		jpn.add(btnSuaPhieu);

		btnThanhToan = new JButton("Thanh \r\nToán");
		btnThanhToan.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\hoadon.png"));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhToan.setBounds(1164, 610, 174, 61);
		jpn.add(btnThanhToan);

		JLabel lblNewLabel_3 = new JLabel("Mã Phiếu Khám");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_3.setBounds(959, 266, 115, 23);
		jpn.add(lblNewLabel_3);

		JLabel lblTnBnhNhn = new JLabel("Mã Bệnh Nhân");
		lblTnBnhNhn.setForeground(Color.BLUE);
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnBnhNhn.setBounds(959, 321, 115, 23);
		jpn.add(lblTnBnhNhn);

		JLabel lblMPhiuKhm = new JLabel("Tên Bệnh Nhân");
		lblMPhiuKhm.setForeground(Color.BLUE);
		lblMPhiuKhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblMPhiuKhm.setBounds(959, 373, 115, 23);
		jpn.add(lblMPhiuKhm);

		JLabel lblNgyKhm = new JLabel("Ngày Khám");
		lblNgyKhm.setForeground(Color.BLUE);
		lblNgyKhm.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNgyKhm.setBounds(959, 425, 88, 29);
		jpn.add(lblNgyKhm);

		lblMaPhieuKham = new JLabel("");
		lblMaPhieuKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaPhieuKham.setBounds(1108, 262, 230, 27);
		jpn.add(lblMaPhieuKham);

		lblMaBenhNhan = new JLabel("");
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaBenhNhan.setBounds(1108, 315, 230, 29);
		jpn.add(lblMaBenhNhan);

		lblTenBenhNhan = new JLabel("");
		lblTenBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenhNhan.setBounds(1108, 367, 230, 29);
		jpn.add(lblTenBenhNhan);

		lblNgayKham = new JLabel("");
		lblNgayKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayKham.setBounds(1108, 425, 230, 29);
		jpn.add(lblNgayKham);

		JLabel lblNewLabel_4 = new JLabel("THÔNG TIN PHIẾU KHÁM BỆNH");
		lblNewLabel_4.setForeground(Color.BLACK);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_4.setBounds(959, 199, 304, 29);
		jpn.add(lblNewLabel_4);

		btnChiTiet = new JButton("Chi Tiết");
		btnChiTiet.setHorizontalAlignment(SwingConstants.LEFT);
		btnChiTiet.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\Phieukham.png"));
		btnChiTiet.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnChiTiet.setBounds(959, 534, 174, 61);
		jpn.add(btnChiTiet);

		JLabel lblTnhTrng = new JLabel("Tình Trạng");
		lblTnhTrng.setForeground(Color.BLUE);
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTnhTrng.setBounds(959, 481, 88, 29);
		jpn.add(lblTnhTrng);

		lblTinhTrang = new JLabel("");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinhTrang.setBounds(1108, 481, 230, 29);
		jpn.add(lblTinhTrang);

		// Tao default model
		DefaultTableModel modelPhieuKham = new DefaultTableModel(
				new String[] { "Mã Phiếu Khám", "Mã Bệnh Nhân", "Tên Bệnh Nhân", "Ngày Khám", "Tình Trạng" }, 0);
		List<Object[]> o = phieukhamDAO.layDanhSanhPhieuKham();
		for (Object[] countResult : o) {
			// chinh sua hien thi ngay mat gio giay
			Date ngay = (Date) countResult[3];// chuyen object vi tri do sang ngay
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // format kieu mong muon
			String ngaykham = dateFormat.format(ngay);// chuyen ngay sang chuoi
			int sotinhtrang = (Integer) countResult[4];// chuyen object sang so
			String tinhtrang = "";
			if (sotinhtrang == 0) {
				tinhtrang = "Chưa thanh toán";
			} else
				tinhtrang = "Đã thanh toán";
			modelPhieuKham.addRow(new Object[] { countResult[0], countResult[1], countResult[2], ngaykham, tinhtrang });
		}
		jtb = new JTable(modelPhieuKham);
		jtb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtb.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(jtb);
		JScrollBar scb = new JScrollBar();
		scrollPane.add(scb);
		scrollPane.setBounds(34, 199, 854, 472);
		jpn.add(scrollPane);

		jtTimPhieu = new JTextField();
		jtTimPhieu.setToolTipText("Nhập đối tượng tìm kiếm ");
		jtTimPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtTimPhieu.setBounds(34, 107, 204, 37);
		jpn.add(jtTimPhieu);
		jtTimPhieu.setColumns(10);

		rdbTenBenhNhan = new JRadioButton("Tên Bệnh Nhân");
		rdbTenBenhNhan.setFont(new Font("Arial", Font.BOLD, 12));
		rdbTenBenhNhan.setBounds(556, 129, 120, 15);
		jpn.add(rdbTenBenhNhan);

		rdbMaBenhNhan = new JRadioButton("Mã Bệnh Nhân");
		rdbMaBenhNhan.setFont(new Font("Arial", Font.BOLD, 12));
		rdbMaBenhNhan.setBounds(424, 129, 120, 15);
		jpn.add(rdbMaBenhNhan);

		rdbMaPhieuKham = new JRadioButton("Mã Phiếu Khám\r\n");
		rdbMaPhieuKham.setFont(new Font("Arial", Font.BOLD, 12));
		rdbMaPhieuKham.setBounds(283, 129, 120, 15);
		jpn.add(rdbMaPhieuKham);

		ButtonGroup group = new ButtonGroup();
		group.add(rdbTenBenhNhan);
		group.add(rdbMaBenhNhan);
		group.add(rdbMaPhieuKham);

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\search.png"));
		btnTimKiem.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnTimKiem.setAlignmentY(Component.TOP_ALIGNMENT);
		btnTimKiem.setBounds(741, 136, 147, 37);
		jpn.add(btnTimKiem);

		btnXemDanhSach = new JButton("Danh Sách");
		btnXemDanhSach.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\load.png"));
		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemDanhSach.setBounds(741, 84, 147, 37);
		jpn.add(btnXemDanhSach);

		jtb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (jtb.getSelectedRow() >= 0) {
					lblMaPhieuKham.setText(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
					lblMaBenhNhan.setText(jtb.getValueAt(jtb.getSelectedRow(), 1).toString());
					lblTenBenhNhan.setText(jtb.getValueAt(jtb.getSelectedRow(), 2).toString());
					lblNgayKham.setText(jtb.getValueAt(jtb.getSelectedRow(), 3).toString());
					lblTinhTrang.setText(jtb.getValueAt(jtb.getSelectedRow(), 4).toString());
				}
			}
		});

		btnChiTiet.addActionListener(this);
		btnChiTiet.setActionCommand("ChiTiet");
		btnSuaPhieu.addActionListener(this);
		btnSuaPhieu.setActionCommand("Sua");
		btnThanhToan.addActionListener(this);
		btnThanhToan.setActionCommand("ThanhToan");
		btnDangXuat.addActionListener(this);
		btnDoiMatKhau.addActionListener(this);
		btnDangXuat.setActionCommand("DangXuat");
		btnDoiMatKhau.setActionCommand("DoiMatKhau");
		btnTimKiem.addActionListener(this);
		btnXemDanhSach.addActionListener(this);
		btnTimKiem.setActionCommand("Tim");
		btnXemDanhSach.setActionCommand("Xem");
		serverthread st = new serverthread(jtb);
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		String maphieukham = lblMaPhieuKham.getText();
		String mabenhnhan = lblMaBenhNhan.getText();
		String tenbenhnhan = lblTenBenhNhan.getText();
		String ngaykham = lblNgayKham.getText();
		String tinhtrang = lblTinhTrang.getText();
		if (command.equals("ChiTiet")) {
			if (maphieukham.equals("")) {
				JOptionPane.showMessageDialog(null, "Xem thất bại, vui lòng click bảng chọn phiếu khám !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			} else {
				try {
					// tryen cac lable o tren
					double tienthuoc = phieukhamDAO.laytongtientuMaPhieuKham(maphieukham);
					double tienkham = quydinh4DAO.laytienkhamTuBanQuyDinh4();
					double tongtien = tienthuoc + tienkham;
					// truyen model thuoc
					System.out.println("Nhan chi tiet");
					// Tao default model
					DefaultTableModel MD = new DefaultTableModel(
							new String[] { "Tên Thuốc", "Số Lượng", "Đơn Giá", "Đơn Vị", "Cách Dùng" }, 0);
					int i = 1;

					List<Object[]> ob = thuocDAO.laydanhsachTheoMaPhieuKhamBenh(maphieukham);

					for (Object[] countResult : ob) {
						MD.addRow(new Object[] { countResult[0], countResult[1], countResult[2], countResult[3],
								countResult[4] });
					}

					SwingUtilities.invokeLater(new Runnable() {
						public void run() {
							chitiet t = new chitiet(MD, maphieukham, ngaykham, tinhtrang, mabenhnhan, tenbenhnhan,
									tienthuoc, tienkham, tongtien);
							t.setVisible(true);
						}
					});

				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}

		if (command.equals("Sua")) {
			if (maphieukham.equals("")) {
				JOptionPane.showMessageDialog(null, "Sửa phiếu thất bại, vui lòng click bảng chọn phiếu khám !",
						"WARNING", JOptionPane.WARNING_MESSAGE);
			} else {
				if (tinhtrang.equals("Đã thanh toán")) {
					JOptionPane.showMessageDialog(null, "Sửa phiếu thất bại, phiếu khám này đã thanh toán !", "WARNING",
							JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						formSuaPhieu sp = new formSuaPhieu(maphieukham, mabenhnhan, tenbenhnhan, ngaykham);
						sp.setVisible(true);
						sp.setLocationRelativeTo(null);
					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}

		if (command.equals("ThanhToan")) {
			if (maphieukham.equals("")) {
				JOptionPane.showMessageDialog(null, "Thanh toán thất bại, vui lòng click bảng chọn phiếu khám !",
						"WARNING", JOptionPane.WARNING_MESSAGE);
			} else {
				if (tinhtrang.equals("Đã thanh toán")) {
					JOptionPane.showMessageDialog(null, "Thanh toán thất bại, phiếu khám này đã thanh toán !",
							"WARNING", JOptionPane.WARNING_MESSAGE);
				} else {
					try {
						// tryen cac lable o tren
						double tienthuoc = phieukhamDAO.laytongtientuMaPhieuKham(maphieukham);
						double tienkham = quydinh4DAO.laytienkhamTuBanQuyDinh4();
						double tongtien = tienthuoc + tienkham;
						// truyen model thuoc
						System.out.println("Nhan thanh toan");
						// Tao default model
						DefaultTableModel MD = new DefaultTableModel(
								new String[] { "Tên Thuốc", "Số Lượng", "Đơn Giá", "Đơn Vị", "Cách Dùng" }, 0);
						int i = 1;

						List<Object[]> ob = thuocDAO.laydanhsachTheoMaPhieuKhamBenh(maphieukham);

						for (Object[] countResult : ob) {
							MD.addRow(new Object[] { countResult[0], countResult[1], countResult[2], countResult[3],
									countResult[4] });
						}

						SwingUtilities.invokeLater(new Runnable() {
							public void run() {
								formThanhToan ftt = new formThanhToan(MD, maphieukham, ngaykham, tinhtrang, mabenhnhan,
										tenbenhnhan, tienthuoc, tienkham, tongtien);
								ftt.setVisible(true);
							}
						});

					} catch (Exception e) {
						// TODO: handle exception
					}
				}
			}
		}

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

		if (command.equals("Xem")) {
			DefaultTableModel modelPhieuKham2 = new DefaultTableModel(
					new String[] { "Mã Phiếu Khám", "Mã Bệnh Nhân", "Tên Bệnh Nhân", "Ngày Khám", "Tình Trạng" }, 0);
			List<Object[]> o = phieukhamDAO.layDanhSanhPhieuKham();
			for (Object[] countResult : o) {
				// chinh sua hien thi ngay mat gio giay
				Date ngay = (Date) countResult[3];// chuyen object vi tri do sang ngay
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // format kieu mong muon
				String ngaykham2 = dateFormat.format(ngay);// chuyen ngay sang chuoi
				int sotinhtrang = (Integer) countResult[4];// chuyen object sang so
				String tinhtrang2 = "";
				if (sotinhtrang == 0) {
					tinhtrang2 = "Chưa thanh toán";
				} else
					tinhtrang2 = "Đã thanh toán";
				modelPhieuKham2
						.addRow(new Object[] { countResult[0], countResult[1], countResult[2], ngaykham2, tinhtrang2 });
			}
			jtb.setModel(modelPhieuKham2);
		}
		if (command.equals("Tim")) {
			System.out.println("nhan nut tim");
			int loai = 0;
			if (rdbMaPhieuKham.isSelected()) {
				loai = 1;
			} else {
				if (rdbMaBenhNhan.isSelected()) {
					loai = 2;
				} else {
					if (rdbTenBenhNhan.isSelected()) {
						loai = 3;
					} else {
						JOptionPane.showMessageDialog(null,
								"Tìm kiếm thất bại, click chọn loại, nhập từ khóa vào khung rồi click Tìm Kiếm !",
								"WARNING", JOptionPane.WARNING_MESSAGE);
					}
				}
			}

			System.out.println("loai: " + loai);
			String timkiem = jtTimPhieu.getText();
			// Tao default model
			DefaultTableModel modelPhieuKham1 = new DefaultTableModel(
					new String[] { "Mã Phiếu Khám", "Mã Bệnh Nhân", "Tên Bệnh Nhân", "Ngày Khám", "Tình Trạng" }, 0);
			List<Object[]> o = phieukhamDAO.layDanhSanhPhieuKham(timkiem, loai);
			for (Object[] countResult : o) {
				// chinh sua hien thi ngay mat gio giay
				Date ngay = (Date) countResult[3];// chuyen object vi tri do sang ngay
				DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); // format kieu mong muon
				String ngaykham1 = dateFormat.format(ngay);// chuyen ngay sang chuoi
				int sotinhtrang = (Integer) countResult[4];// chuyen object sang so
				String tinhtrang1 = "";
				if (sotinhtrang == 0) {
					tinhtrang1 = "Chưa thanh toán";
				} else
					tinhtrang1 = "Đã thanh toán";
				modelPhieuKham1
						.addRow(new Object[] { countResult[0], countResult[1], countResult[2], ngaykham1, tinhtrang1 });
			}
			jtb.setModel(modelPhieuKham1);
		}
	}
}
