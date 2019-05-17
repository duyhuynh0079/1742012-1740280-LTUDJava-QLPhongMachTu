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

public class subtabQuyDinh extends JFrame  {

	private JPanel jpn;
	private JTable jtb;
	private JComboBox cbbQuyDinh;
	private JScrollPane jsp;	

	public void controlQuyDinh(JPanel jpn) {

//	public subtabQuyDinh() {
//		jpn = new JPanel();
//		getContentPane().add(jpn);
//		setSize(getMaximumSize());
//		setLocationRelativeTo(null);
//		setVisible(true);
//		jpn.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Quy Định");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setBounds(585, 11, 136, 50);
		jpn.add(lblNewLabel);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(
				"C:\\Users\\Mr.F\\Documents\\GitHub\\1742012-1740280-LTUDJava-QLPhongMachTu\\Source\\images\\ABC.png"));
		label.setBounds(1026, 28, 115, 84);
		jpn.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Quy định :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(94, 159, 89, 26);
		jpn.add(lblNewLabel_1);
		
		String [] quydinh = {"QD1","QD2","QD4","QD6"};
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
		
		JLabel lblNewLabel_2 = new JLabel("*Những quy định trên của phòng mạch chỉ những chức vụ quản lý mới được thay đổi\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 14));
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(94, 508, 581, 26);
		jpn.add(lblNewLabel_2);
		
//		JButton btnNewButton = new JButton("Đổi mật khẩu");
//		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
//		btnNewButton.setForeground(Color.BLUE);
//		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton.setBounds(1238, 79, 122, 33);
//		jpn.add(btnNewButton);
//		
//		JButton btnNewButton_1 = new JButton("Đăng xuất");
//		btnNewButton_1.setForeground(Color.BLUE);
//		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
//		btnNewButton_1.setBounds(1255, 35, 105, 33);
//		jpn.add(btnNewButton_1);
		
		//su kien thay doi combobox
		cbbQuyDinh.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	if(cbbQuyDinh.getSelectedItem().equals("QD1"))
				{
					QuyDinh1Model model = new QuyDinh1Model();
					jtb.setModel(model);
				}
				if(cbbQuyDinh.getSelectedItem().equals("QD2"))
				{
					QuyDinh2Model model = new QuyDinh2Model();
					jtb.setModel(model);
					System.out.println("Quy định 2");
				}
				if(cbbQuyDinh.getSelectedItem().equals("QD4"))
				{
					QuyDinh4Model model = new QuyDinh4Model();
					jtb.setModel(model);
					System.out.println("Quy định 4");
				}
				if(cbbQuyDinh.getSelectedItem().equals("QD6"))
				{
					QuyDinh6Model model = new QuyDinh6Model();
					jtb.setModel(model);
					System.out.println("Quy định 6");
				}
		    }
		});
	}
}
