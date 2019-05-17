package layoutandrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import entity.thamSoReport;

import javax.swing.JComboBox;
import javax.swing.JButton;

public class subtabBaoCao extends JFrame implements ActionListener {

	private JPanel jpn;
	private JComboBox cbbThang2;
	private JComboBox cbbThang3;
	private JComboBox cbbThang1;
	private JComboBox cbbNam2;
	private JComboBox cbbNam3;
	private JComboBox cbbNam1;
	private JButton btnBCDoanhThu;
	private JButton btnBCThuoc;
	private JButton btnBCLoaiBenh;

	public void controlBaoCao(JPanel jpn) {
//		 public subtabBaoCao() {
//		
//		 setBounds(100, 100, 450, 300);
//		 jpn = new JPanel();
//		 getContentPane().add(jpn);
//		 setSize(getMaximumSize());
//		 setLocationRelativeTo(null);
//		 setVisible(true);
//		 jpn.setLayout(null);

		JLabel lblNewLabel = new JLabel("Báo Cáo");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(585, 11, 108, 50);
		jpn.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		jpn.add(label);

		JLabel lblNewLabel_1 = new JLabel("Báo cáo doanh thu theo ngày:\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(45, 144, 225, 24);
		jpn.add(lblNewLabel_1);

		JLabel lblBoCoS = new JLabel("Báo cáo sử dụng thuốc theo tháng:\r\n");
		lblBoCoS.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoCoS.setBounds(45, 295, 259, 24);
		jpn.add(lblBoCoS);

		JLabel lblBoCoLoi = new JLabel("Báo cáo loại bệnh theo tháng:\r\n");
		lblBoCoLoi.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblBoCoLoi.setBounds(45, 470, 225, 24);
		jpn.add(lblBoCoLoi);

		JLabel lblNhpThng = new JLabel("Chọn tháng:\r\n");
		lblNhpThng.setForeground(Color.BLUE);
		lblNhpThng.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhpThng.setBounds(315, 375, 79, 24);
		jpn.add(lblNhpThng);

		JLabel lblNhpThng_1 = new JLabel("Chon tháng:");
		lblNhpThng_1.setForeground(Color.BLUE);
		lblNhpThng_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhpThng_1.setBounds(315, 551, 79, 24);
		jpn.add(lblNhpThng_1);

		// tao jdate picker chon ngay
		Calendar today = Calendar.getInstance();
		UtilDateModel model = new UtilDateModel(today.getTime());
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		JDatePanelImpl datePanel = new JDatePanelImpl(model, p);

		JLabel lblNhpNm = new JLabel("Năm:\r\n");
		lblNhpNm.setForeground(Color.BLUE);
		lblNhpNm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNhpNm.setBounds(526, 375, 41, 24);
		jpn.add(lblNhpNm);

		JLabel lblNm = new JLabel("Năm:\r\n");
		lblNm.setForeground(Color.BLUE);
		lblNm.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNm.setBounds(527, 551, 41, 24);
		jpn.add(lblNm);

		JLabel label_1 = new JLabel("Chọn tháng:\r\n");
		label_1.setForeground(Color.BLUE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(315, 209, 79, 24);
		jpn.add(label_1);

		JLabel label_2 = new JLabel("Năm:\r\n");
		label_2.setForeground(Color.BLUE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(526, 209, 41, 24);
		jpn.add(label_2);

		String[] thang = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" };
		cbbThang1 = new JComboBox(thang);
		cbbThang1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang1.setBounds(404, 209, 54, 23);
		jpn.add(cbbThang1);

		cbbThang2 = new JComboBox(thang);
		cbbThang2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang2.setBounds(404, 375, 54, 23);
		jpn.add(cbbThang2);

		cbbThang3 = new JComboBox(thang);
		cbbThang3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbThang3.setBounds(404, 551, 54, 23);
		jpn.add(cbbThang3);

		cbbNam1 = new JComboBox();
		cbbNam1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam1.setBounds(565, 209, 79, 23);
		jpn.add(cbbNam1);

		cbbNam2 = new JComboBox();
		cbbNam2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam2.setBounds(565, 375, 79, 23);
		jpn.add(cbbNam2);

		cbbNam3 = new JComboBox();
		cbbNam3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cbbNam3.setBounds(565, 551, 79, 23);
		jpn.add(cbbNam3);

		// do du lieu vao combobox nam
		List<String> ls = new ArrayList<String>();
		// do du lieu vao nam
		for (int i = 2019; i <= 2050; i++) {
			ls.add(String.valueOf(i));
		}
		cbbNam2.setModel(new DefaultComboBoxModel(ls.toArray()));
		cbbNam3.setModel(new DefaultComboBoxModel(ls.toArray()));
		cbbNam1.setModel(new DefaultComboBoxModel(ls.toArray()));

		btnBCDoanhThu = new JButton("In");
		btnBCDoanhThu.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\report2.png"));
		btnBCDoanhThu.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBCDoanhThu.setBounds(812, 191, 121, 67);
		jpn.add(btnBCDoanhThu);

		btnBCThuoc = new JButton("In");
		btnBCThuoc.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\report1.png"));
		btnBCThuoc.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBCThuoc.setBounds(812, 350, 121, 73);
		jpn.add(btnBCThuoc);

		btnBCLoaiBenh = new JButton("In");
		btnBCLoaiBenh.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\report3.png"));
		btnBCLoaiBenh.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnBCLoaiBenh.setBounds(812, 520, 121, 67);
		jpn.add(btnBCLoaiBenh);

		btnBCDoanhThu.addActionListener(this);
		btnBCThuoc.addActionListener(this);
		btnBCLoaiBenh.addActionListener(this);
		btnBCDoanhThu.setActionCommand("DoanhThu");
		btnBCThuoc.setActionCommand("Thuoc");
		btnBCLoaiBenh.setActionCommand("LoaiBenh");

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if (command.equals("DoanhThu")) {
			String Thang = cbbThang1.getSelectedItem().toString();
			String Nam = cbbNam1.getSelectedItem().toString();
			List<Object[]> o = baocaoDoanhThu.laydanhsachKiemTraRong(Integer.parseInt(Thang), Integer.parseInt(Nam));
			if (o.size() > 0) {
				baocaoDoanhThu.thuchienInBaoCaoDoanhThu(Integer.parseInt(Thang), Integer.parseInt(Nam));
			} else
				JOptionPane.showMessageDialog(null, "Tháng này phòng khám không hoạt động!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
		}
		
		if (command.equals("Thuoc")) {
			String Thang = cbbThang2.getSelectedItem().toString();
			String Nam = cbbNam2.getSelectedItem().toString();
			List<Object[]> o = baocaoThuoc.laydanhsachKiemTraRong(Integer.parseInt(Thang), Integer.parseInt(Nam));
			if (o.size() > 0) {
				baocaoThuoc.thuchienInBaoCaoThuoc(Integer.parseInt(Thang), Integer.parseInt(Nam));
			} else
				JOptionPane.showMessageDialog(null, "Tháng này phòng khám không hoạt động!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
		}
		
		if (command.equals("LoaiBenh")) {
			String Thang = cbbThang3.getSelectedItem().toString();
			String Nam = cbbNam3.getSelectedItem().toString();
			List<Object[]> o = baocaoLoaiBenh.laydanhsachKiemTraRong(Integer.parseInt(Thang), Integer.parseInt(Nam));
			if (o.size() > 0) {
				baocaoLoaiBenh.thuchienInBaoCaoBenh(Integer.parseInt(Thang), Integer.parseInt(Nam));
			} else
				JOptionPane.showMessageDialog(null, "Tháng này phòng khám không hoạt động!", "WARNING",
						JOptionPane.WARNING_MESSAGE);
		}
	}
}
