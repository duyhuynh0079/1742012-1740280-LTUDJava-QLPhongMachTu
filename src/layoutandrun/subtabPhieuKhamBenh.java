package layoutandrun;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import DAO.phieukhamDAO;

public class subtabPhieuKhamBenh implements ActionListener {
	private JLabel lblMaPhieuKham;
	private JLabel lblMaBenhNhan;
	private JLabel lblTenBenhNhan;
	private JLabel lblNgayKham;
	private JLabel lblTinhTrang;
	private JTable jtb;
	private JTextField jtTimPhieu;
	private JButton btnChiTiet;
	private JButton btnSuaPhieu;
	private JButton btnXemDanhSach;
	private JButton btnThanhToan;
	private JButton btnTimKiem;
	private JComboBox jcbb;
	private JLabel lblNewLabel_2;
	int index;

	public void controlPhieuKhamBenh(JPanel jpn) {
		JLabel lblNewLabel = new JLabel("QUẢN LÝ PHIẾU KHÁM BỆNH");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(460, 11, 377, 50);
		jpn.add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		jpn.add(label);
		
		JLabel lblNewLabel_5 = new JLabel("Tìm kiếm");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_5.setBounds(36, 74, 72, 23);
		jpn.add(lblNewLabel_5);
		
		btnXemDanhSach = new JButton("Danh Sách");
		btnXemDanhSach.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\load.png"));
		btnXemDanhSach.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnXemDanhSach.setBounds(643, 95, 174, 50);
		jpn.add(btnXemDanhSach);
		
		btnSuaPhieu = new JButton("Sửa Phiếu");
		btnSuaPhieu.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\edit2.png"));
		btnSuaPhieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnSuaPhieu.setBounds(959, 610, 174, 61);
		jpn.add(btnSuaPhieu);
		
		btnThanhToan = new JButton("Thanh \r\nToán");
		btnThanhToan.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\hoadon.png"));
		btnThanhToan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnThanhToan.setBounds(1164, 610, 174, 61);
		jpn.add(btnThanhToan);
		
		JLabel lblNewLabel_1 = new JLabel("*Có thể nhập tìm theo tên bệnh nhân, mã phiếu khám, ngày khám...\r\n");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_1.setBounds(34, 153, 425, 23);
		jpn.add(lblNewLabel_1);
		
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
		btnChiTiet.setIcon(new ImageIcon("C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\Phieukham.png"));
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
		int i = 1;
		List<Object[]> o = phieukhamDAO.layDanhSanhPhieuKham();
		for (Object[] countResult : o) {
			//chinh sua hien thi ngay mat gio giay
			Date ngay = (Date)countResult[3];//chuyen object vi tri do sang ngay
			DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //format kieu mong muon
			String ngaykham = dateFormat.format(ngay);//chuyen ngay sang chuoi
			int sotinhtrang = (Integer)countResult[4];//chuyen object sang so
			String tinhtrang = "";
			if(sotinhtrang == 0)
			{
				tinhtrang = "Chưa thanh toán";
			}
			else tinhtrang = "Đã thanh toán";
			modelPhieuKham.addRow(
					new Object[] { countResult[0], countResult[1], countResult[2], ngaykham, tinhtrang });
		}
		jtb = new JTable(modelPhieuKham);
		jtb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtb.setDefaultEditor(Object.class, null);
		JScrollPane scrollPane = new JScrollPane(jtb);
		JScrollBar scb = new JScrollBar();
		scrollPane.add(scb);
		scrollPane.setBounds(34, 199, 854, 472);
		jpn.add(scrollPane);
		
		
		jtTimPhieu = textfieldSearch.createRowFilter(jtb);
		jtTimPhieu.setToolTipText("Nhập đối tượng tìm kiếm ");
		jtTimPhieu.setFont(new Font("Tahoma", Font.PLAIN, 14));
		jtTimPhieu.setBounds(34, 102, 347, 37);
		jpn.add(jtTimPhieu);
		jtTimPhieu.setColumns(10);
		
		jtb.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent event) {
				// dat if tranh loi
				if (jtb.getSelectedRow() >= 0) {
					lblMaPhieuKham.setText(jtb.getValueAt(jtb.getSelectedRow(), 0).toString());
					lblMaBenhNhan.setText(jtb.getValueAt(jtb.getSelectedRow(), 1).toString());
					lblTenBenhNhan.setText(jtb.getValueAt(jtb.getSelectedRow(), 2).toString());
					lblNgayKham.setText(jtb.getValueAt(jtb.getSelectedRow(), 3).toString());
					lblTinhTrang.setText(jtb.getValueAt(jtb.getSelectedRow(), 4).toString());
					index = jtb.getSelectedRow();
				}
			}
		});
		
		btnChiTiet.addActionListener(this);
		btnChiTiet.setActionCommand("ChiTiet");
		btnSuaPhieu.addActionListener(this);
		btnSuaPhieu.setActionCommand("Sua");
		btnThanhToan.addActionListener(this);
		btnThanhToan.setActionCommand("ChiTiet");
		btnXemDanhSach.addActionListener(this);
		btnXemDanhSach.setActionCommand("Xem");
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String command = ae.getActionCommand();
		String maphieukham = lblMaPhieuKham.getText();
		String mabenhnhan = lblMaBenhNhan.getText();
		String tenbenhnhan = lblTenBenhNhan.getText();
		String ngaykham = lblNgayKham.getText();
		String tinhtrang = lblTinhTrang.getText();
		if(command.equals("ChiTiet"))
		{
			if(maphieukham=="")
			{
				JOptionPane.showMessageDialog(null,
						"Xem thất bại, vui lòng click bảng chọn phiếu khám !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
			else {
				try {
					formChiTietPhieu ctp = new formChiTietPhieu(maphieukham,mabenhnhan,tenbenhnhan,ngaykham,tinhtrang);
					ctp.setVisible(true);
					ctp.setLocationRelativeTo(null);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
		
		if(command.equals("Sua"))
		{
			if(maphieukham=="")
			{
				JOptionPane.showMessageDialog(null,
						"Sửa phiếu thất bại, vui lòng click bảng chọn phiếu khám !", "WARNING",
						JOptionPane.WARNING_MESSAGE);
			}
			else {
				try {
					formSuaPhieu sp = new formSuaPhieu(maphieukham,mabenhnhan,tenbenhnhan,ngaykham);
					sp.setVisible(true);
					sp.setLocationRelativeTo(null);
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		}
	}
}
