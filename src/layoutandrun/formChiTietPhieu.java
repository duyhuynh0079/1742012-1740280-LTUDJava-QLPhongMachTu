package layoutandrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.hoadonDAO;
import DAO.loaibenhDAO;
import DAO.phieukhamDAO;
import DAO.thuocDAO;
import entity.loaibenh;
import entity.phieukhambenh;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class formChiTietPhieu extends JFrame {
	private JPanel jp;
	String maphieukham = "";
	String mabenhnhan = "";
	String tenbenhnhan = "";
	String ngaykham = "";
	String tinhtrang = "";
	private static JLabel lblTongTien ;
	private static JLabel lblTienKham ;
	private static JTable jtb;

	public formChiTietPhieu(String MaPhieuKham, String MaBenhNhan, String TenBenhNhan, String NgayKham,
			String TinhTrang, DefaultTableModel modelPhieuKham) {
		
		setSize(1000, 600);
		setSize(getMaximumSize());
		//setLocationRelativeTo(null);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		//setVisible(true);
		this.maphieukham = MaPhieuKham;
		System.out.println("Mã Phiếu Khám: "+ maphieukham);
		this.mabenhnhan = MaBenhNhan;
		this.tenbenhnhan = TenBenhNhan;
		this.ngaykham = NgayKham;
		this.tinhtrang = TinhTrang;
		// setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);// đóng form
		jp = new JPanel();
		jp.setFont(new Font("Tahoma", Font.PLAIN, 14));
		getContentPane().add(jp);
		jp.setLayout(null);
		this.setTitle("Chi tiết phiếu khám " + maphieukham);

		JLabel lblNewLabel = new JLabel("Chi Tiết Phiếu Khám Bệnh");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(571, 11, 339, 38);
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
		lblNgyKhm.setBounds(483, 72, 109, 21);
		jp.add(lblNgyKhm);

		JLabel lblTnhTrng = new JLabel("Tình Trạng");
		lblTnhTrng.setForeground(Color.BLUE);
		lblTnhTrng.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnhTrng.setBounds(922, 72, 103, 21);
		jp.add(lblTnhTrng);

		JLabel lblTnBnhNhn = new JLabel("Tên Bệnh Nhân");
		lblTnBnhNhn.setForeground(Color.BLUE);
		lblTnBnhNhn.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTnBnhNhn.setBounds(483, 126, 134, 21);
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
		lblNewLabel_2.setBounds(173, 178, 419, 21);
		jp.add(lblNewLabel_2);

		JLabel lblTriuChng = new JLabel("Triệu Chứng");
		lblTriuChng.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTriuChng.setBounds(484, 180, 108, 19);
		jp.add(lblTriuChng);

		JLabel lblTienthuoc = new JLabel("Tiền Thuốc:");
		lblTienthuoc.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienthuoc.setBounds(922, 126, 109, 30);
		jp.add(lblTienthuoc);

		JLabel lblStt = new JLabel("STT");
		lblStt.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblStt.setBounds(114, 178, 478, 21);
		jp.add(lblStt);

		JLabel lblsttBenh1 = new JLabel("");
		lblsttBenh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh1.setBounds(114, 210, 27, 21);
		jp.add(lblsttBenh1);

		JLabel lblTenBenh1 = new JLabel("");
		lblTenBenh1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh1.setBounds(173, 210, 177, 21);
		jp.add(lblTenBenh1);

		JLabel lblTrieuChung1 = new JLabel("");
		lblTrieuChung1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung1.setBounds(483, 210, 391, 21);
		jp.add(lblTrieuChung1);

		JLabel lblTrieuChung2 = new JLabel("");
		lblTrieuChung2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung2.setBounds(483, 242, 391, 21);
		jp.add(lblTrieuChung2);

		JLabel lblTenBenh2 = new JLabel("");
		lblTenBenh2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh2.setBounds(173, 242, 177, 21);
		jp.add(lblTenBenh2);

		JLabel lblsttBenh2 = new JLabel("");
		lblsttBenh2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh2.setBounds(114, 242, 27, 21);
		jp.add(lblsttBenh2);

		JLabel lblTrieuChung3 = new JLabel("");
		lblTrieuChung3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTrieuChung3.setBounds(483, 274, 391, 21);
		jp.add(lblTrieuChung3);

		JLabel lblTenBenh3 = new JLabel("");
		lblTenBenh3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenh3.setBounds(173, 274, 177, 21);
		jp.add(lblTenBenh3);

		JLabel lblsttBenh3 = new JLabel("");
		lblsttBenh3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsttBenh3.setBounds(114, 274, 27, 21);
		jp.add(lblsttBenh3);

		JLabel lblMaPhieuKham = new JLabel("");
		lblMaPhieuKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaPhieuKham.setBounds(175, 72, 177, 19);
		jp.add(lblMaPhieuKham);

		JLabel lblMaBenhNhan = new JLabel("");
		lblMaBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMaBenhNhan.setBounds(175, 126, 177, 19);
		jp.add(lblMaBenhNhan);

		JLabel lblNgayKham = new JLabel("");
		lblNgayKham.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNgayKham.setBounds(627, 72, 177, 21);
		jp.add(lblNgayKham);

		JLabel lblTenBenhNhan = new JLabel("");
		lblTenBenhNhan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTenBenhNhan.setBounds(627, 126, 177, 21);
		jp.add(lblTenBenhNhan);

		JLabel lblTinhTrang = new JLabel("");
		lblTinhTrang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTinhTrang.setBounds(1034, 75, 177, 14);
		jp.add(lblTinhTrang);

		JLabel lblTienThuoc = new JLabel("");
		lblTienThuoc.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienThuoc.setBounds(1045, 130, 133, 26);
		jp.add(lblTienThuoc);
		
		lblTienKham = new JLabel("");
		lblTienKham.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTienKham.setBounds(1045, 184, 133, 26);
		jp.add(lblTienKham);

		JLabel lblTienKham1 = new JLabel("Tiền Khám:");
		lblTienKham1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTienKham1.setBounds(922, 180, 109, 30);
		jp.add(lblTienKham1);

		lblTongTien = new JLabel("");
		lblTongTien.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblTongTien.setBounds(1045, 237, 133, 26);
		jp.add(lblTongTien);


		JLabel lblTongTien1 = new JLabel("Tổng Tiền:");
		lblTongTien1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTongTien1.setBounds(922, 233, 103, 30);
		jp.add(lblTongTien1);

		lblMaPhieuKham.setText(maphieukham);
		lblMaBenhNhan.setText(mabenhnhan);
		lblTenBenhNhan.setText(tenbenhnhan);
		lblNgayKham.setText(ngaykham);
		lblTinhTrang.setText(tinhtrang);
		
		System.out.println("==========================================================");
		
		
		
		
		int stt = 1;
		loaibenhDAO dao = new loaibenhDAO();
		List<Object[]> o = dao.layLoaiBenhTheoMPKB(maphieukham);
		System.out.println("countResult:loaibenhDAO " + o.size());
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
//		lblTienThuoc.setText(phieukhamDAO.laytongtientuMaPhieuKham(maphieukham));
		
		System.out.println("lblTinhTrang.getText()" + lblTinhTrang.getText());
		//set hien ra tien kham va tong tien voi phieu da thanh toan
		if(lblTinhTrang.getText().equals("Chưa thanh toán"))
		{
			lblTienKham1.setText("");
			lblTienKham.setText("");
			lblTongTien1.setText("");
			lblTongTien.setText("");
		}
		else
		{
			int TienKham = 30000;
			lblTienKham1.setText("Tiền Khám:");
			lblTienKham.setText(String.valueOf(TienKham));
			lblTongTien1.setText("Tổng Tiền:");
//			lblTongTien.setText(hoadonDAO.laytongtientuMaPhieuKham(maphieukham));
		}
		
		jtb = new JTable();
		jtb.setModel(modelPhieuKham);
		
		
		
		jtb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtb.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(jtb);
		scrollPane.setBounds(100, 316, 1130, 375);
		jp.add(scrollPane);
		
	}
}
