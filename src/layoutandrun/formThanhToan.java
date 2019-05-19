package layoutandrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.hoadonDAO;
import DAO.loaibenhDAO;
import DAO.phieukhamDAO;
import DAO.thuocDAO;
import entity.hoadon;
import entity.phieukhambenh;
import entity.thamSoReport;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class formThanhToan extends JFrame implements ActionListener {

	private JPanel jp;
	private JTable jtb;
	private JLabel lblMaPhieuKham;
	private JLabel lblNgayKham;
	private JLabel lblMaBenhNhan;
	private JLabel lblTinhTrang;
	private JLabel lblTenBenhNhan;
	private JLabel lblTienThuoc;
	private JLabel lblTienKham;
	private JLabel lblTongTien;
	private JLabel lblsttBenh1;
	private JLabel lblsttBenh2;
	private JLabel lblsttBenh3;
	private JLabel lblTenBenh1;
	private JLabel lblTenBenh2;
	private JLabel lblTenBenh3;
	private JLabel lblTrieuChung1;
	private JLabel lblTrieuChung2;
	private JLabel lblTrieuChung3;
	String mahoadon;
	static ArrayList<hoadon> alhd = hoadonDAO.hoadon();

	public formThanhToan(DefaultTableModel modelPhieuKham, String MaPhieuKham, String NgayKham, String TinhTrang, String MaBenhNhan, String TenBenhNhan, double TienThuoc, double TienKham, double TongTien) {
		// setSize(1000,600);
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\sourcetree\\Source\\images\\ABC77.png"));
		setSize(getMaximumSize());
		setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// đóng form
		jp = new JPanel();
		jp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(jp);
		jp.setLayout(null);
		this.setTitle("Phiếu khám " + MaPhieuKham);

		JLabel lblNewLabel = new JLabel("Thanh Toán Phiếu Khám Bệnh");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(512, 11, 401, 38);
		jp.add(lblNewLabel);

		JLabel lblMPhiuKhm = new JLabel("Mã Phiếu Khám");
		lblMPhiuKhm.setForeground(Color.BLUE);
		lblMPhiuKhm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMPhiuKhm.setBounds(31, 72, 134, 21);
		jp.add(lblMPhiuKhm);

		JLabel lblMBnhNhn = new JLabel("Mã Bệnh Nhân");
		lblMBnhNhn.setForeground(Color.BLUE);
		lblMBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblMBnhNhn.setBounds(31, 126, 134, 21);
		jp.add(lblMBnhNhn);

		JLabel lblNgyKhm = new JLabel("Ngày Khám");
		lblNgyKhm.setForeground(Color.BLUE);
		lblNgyKhm.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNgyKhm.setBounds(415, 72, 109, 21);
		jp.add(lblNgyKhm);

		JLabel lblTnhTrng = new JLabel("Tình Trạng");
		lblTnhTrng.setForeground(Color.BLUE);
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnhTrng.setBounds(767, 72, 103, 21);
		jp.add(lblTnhTrng);

		JLabel lblTnBnhNhn = new JLabel("Tên Bệnh Nhân");
		lblTnBnhNhn.setForeground(Color.BLUE);
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnBnhNhn.setBounds(415, 126, 134, 21);
		jp.add(lblTnBnhNhn);

		JLabel lblNewLabel_1 = new JLabel("Bệnh:");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(33, 178, 71, 21);
		jp.add(lblNewLabel_1);

		JLabel lblThuc = new JLabel("Thuốc:");
		lblThuc.setForeground(Color.BLUE);
		lblThuc.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThuc.setBounds(31, 318, 60, 21);
		jp.add(lblThuc);

		JLabel lblNewLabel_2 = new JLabel("Tên Loại Bệnh");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(173, 178, 120, 21);
		jp.add(lblNewLabel_2);

		JLabel lblTriuChng = new JLabel("Triệu Chứng");
		lblTriuChng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTriuChng.setBounds(416, 180, 108, 19);
		jp.add(lblTriuChng);

		JLabel lblTngTin = new JLabel("Tiền Thuốc:");
		lblTngTin.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTngTin.setBounds(1059, 72, 120, 30);
		jp.add(lblTngTin);

		JLabel lblStt = new JLabel("STT");
		lblStt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStt.setBounds(114, 178, 478, 21);
		jp.add(lblStt);

		lblsttBenh1 = new JLabel("");
		lblsttBenh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh1.setBounds(114, 210, 27, 21);
		jp.add(lblsttBenh1);

		lblTenBenh1 = new JLabel("");
		lblTenBenh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh1.setBounds(173, 210, 177, 21);
		jp.add(lblTenBenh1);

		lblTrieuChung1 = new JLabel("");
		lblTrieuChung1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung1.setBounds(415, 210, 508, 21);
		jp.add(lblTrieuChung1);

		lblTrieuChung2 = new JLabel("");
		lblTrieuChung2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung2.setBounds(415, 242, 508, 21);
		jp.add(lblTrieuChung2);

		lblTenBenh2 = new JLabel("");
		lblTenBenh2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh2.setBounds(173, 242, 177, 21);
		jp.add(lblTenBenh2);

		lblsttBenh2 = new JLabel("");
		lblsttBenh2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh2.setBounds(114, 242, 27, 21);
		jp.add(lblsttBenh2);

		lblTrieuChung3 = new JLabel("");
		lblTrieuChung3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung3.setBounds(415, 274, 508, 21);
		jp.add(lblTrieuChung3);

		lblTenBenh3 = new JLabel("");
		lblTenBenh3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh3.setBounds(173, 274, 177, 21);
		jp.add(lblTenBenh3);

		lblsttBenh3 = new JLabel("");
		lblsttBenh3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh3.setBounds(114, 274, 27, 21);
		jp.add(lblsttBenh3);

		lblMaPhieuKham = new JLabel(MaPhieuKham);
		lblMaPhieuKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaPhieuKham.setBounds(175, 72, 177, 19);
		jp.add(lblMaPhieuKham);

		lblMaBenhNhan = new JLabel(MaBenhNhan);
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaBenhNhan.setBounds(175, 126, 177, 19);
		jp.add(lblMaBenhNhan);

		lblNgayKham = new JLabel(NgayKham);
		lblNgayKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayKham.setBounds(559, 72, 177, 21);
		jp.add(lblNgayKham);

		lblTenBenhNhan = new JLabel(TenBenhNhan);
		lblTenBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenhNhan.setBounds(559, 126, 177, 21);
		jp.add(lblTenBenhNhan);

		lblTinhTrang = new JLabel(TinhTrang);
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinhTrang.setBounds(880, 72, 134, 21);
		jp.add(lblTinhTrang);

		lblTienThuoc = new JLabel(String.valueOf(TienThuoc));
		lblTienThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienThuoc.setBounds(1173, 76, 134, 26);
		jp.add(lblTienThuoc);

		lblTienKham = new JLabel(String.valueOf(TienKham));
		lblTienKham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienKham.setBounds(1174, 126, 133, 26);
		jp.add(lblTienKham);

		JLabel lblTienKham1= new JLabel("Tiền Khám:");
		lblTienKham1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienKham1.setBounds(1060, 122, 120, 30);
		jp.add(lblTienKham1);

		lblTongTien = new JLabel(String.valueOf(TongTien));
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTien.setBounds(1173, 179, 133, 26);
		jp.add(lblTongTien);

		JLabel lblTongTien1 = new JLabel("Tổng Tiền:");
		lblTongTien1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien1.setBounds(1060, 175, 120, 30);
		jp.add(lblTongTien1);

		JButton btnIn = new JButton("In Hóa Đơn");
		btnIn.setIcon(new ImageIcon(
				"E:\\sourcetree\\Source\\images\\in2.png"));
		btnIn.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnIn.setBounds(1059, 231, 193, 61);
		jp.add(btnIn);


		int stt = 1;
		List<Object[]> o = loaibenhDAO.layLoaiBenhTheoMaPhieuKhamBenh(MaPhieuKham);
		for (Object[] countResult : o) {
			if (stt == 1) {
				lblsttBenh1.setText(String.valueOf(stt));
				String tenloaibenh = countResult[0].toString();
				String trieuchung = countResult[1].toString();
				lblTenBenh1.setText(tenloaibenh);
				lblTrieuChung1.setText(trieuchung);
			} else if (stt == 2) {
				lblsttBenh2.setText(String.valueOf(stt));
				String tenloaibenh = countResult[0].toString();
				String trieuchung = countResult[1].toString();
				lblTenBenh2.setText(tenloaibenh);
				lblTrieuChung2.setText(trieuchung);
			} else {
				lblsttBenh3.setText(String.valueOf(stt));
				String tenloaibenh = countResult[0].toString();
				String trieuchung = countResult[1].toString();
				lblTenBenh3.setText(tenloaibenh);
				lblTrieuChung3.setText(trieuchung);
			}
			stt++;
		}

		lblTienKham.setText(String.valueOf(TienKham));

		// Add model truyền qua tu subtabPhieuKhamBenh
		jtb = new JTable(modelPhieuKham);
		jtb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtb.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(100, 316, 1130, 375);
		jp.add(scrollPane);

		// bat su kien thanh toan
		btnIn.addActionListener(this);
		btnIn.setActionCommand("In");
	}

	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		if (command.equals("In")) {
			Date ngay;
			try {
				// sua tinh trang phieu kham Da Thanh Toan
				int id = 0;
				ngay = new SimpleDateFormat("dd-MM-yyyy").parse(lblNgayKham.getText());
				phieukhambenh pkb = new phieukhambenh();
				id = phieukhamDAO.layidTheoMaPhieuKhamBenh(lblMaPhieuKham.getText());
				pkb.setID(id);
				pkb.setMaPhieuKhamBenh(lblMaPhieuKham.getText());
				pkb.setNgayKham(ngay);
				pkb.setTongTienThuoc(Double.parseDouble(lblTienThuoc.getText()));
				pkb.setTinhTrang(1);
				phieukhamDAO.suaPhieuKham(pkb);

				// them vao hoa don
				// tu tao ma hoa don ban dau la HD1, sau đó tự tăng
				if (alhd.size() == 0) {
					mahoadon = "HD1";
				} else {
					// neu da co roi thi tao chuoi mahoadon moi tu mahoadon cu + 1
					mahoadon = alhd.get(alhd.size() - 1).getMaHoaDon();// lay ma hoa don "HD1"
					int sothutu = Integer.parseInt(mahoadon.replace("HD", ""));// bien "HD1" thanh "1", truyen
																					// vao so thu tu
					mahoadon = "HD" + (sothutu + 1);
				}
				hoadon hd = new hoadon();
				hd.setMaHoaDon(mahoadon);
				hd.setNgayThanhToan(new Date());// lay ngay thuc tai
				hd.setTienKham(Double.parseDouble(lblTienKham.getText()));
				hd.setTongTien(Double.parseDouble(lblTongTien.getText()));
				hd.setID_PhieuKhamBenh(id);
				hoadonDAO.themHoaDon(hd);
				thamSoReport t = new thamSoReport();
				t.setMaPhieuKham(lblMaPhieuKham.getText());
				t.setNgayKham(lblNgayKham.getText());
				t.setMaBenhNhan(lblMaBenhNhan.getText());
				t.setTenBenhNhan(lblTenBenhNhan.getText());
				t.setTienThuoc(lblTienThuoc.getText());
				t.setTienKham(lblTienKham.getText());
				t.setTongTien(lblTongTien.getText());
				t.setSTT1(lblsttBenh1.getText());
				t.setSTT2(lblsttBenh2.getText());
				t.setSTT3(lblsttBenh3.getText());
				t.setTenLoaiBenh1(lblTenBenh1.getText());
				t.setTenLoaiBenh2(lblTenBenh2.getText());
				t.setTenLoaiBenh3(lblTenBenh3.getText());
				t.setTrieuChung1(lblTrieuChung1.getText());
				t.setTrieuChung2(lblTrieuChung2.getText());
				t.setTrieuChung3(lblTrieuChung3.getText());
				inhoadon.thucHienInHoaDon(t);
				clientthread ct = new clientthread();
				this.dispose();
				//pull request
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
