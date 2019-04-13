package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import layoutandrun.subtabBenhNhan;

public class tabNhanVien extends JFrame {

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		tabNhanVien tnv = new tabNhanVien();
		tnv.setLocationRelativeTo(null);
		tnv.setVisible(true);
		tnv.setResizable(false);
	}

	public tabNhanVien() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(getMaximumSize());

		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		addComponentToTab(jtp);// goi ham tao cac tab con
	}

	public void addComponentToTab(JTabbedPane jtp) {
		//tao tab BenhNhan
		JPanel pnlBenhNhan = new JPanel();
		subtabBenhNhan stbn = new subtabBenhNhan();
		stbn.controlBenhNhan(pnlBenhNhan);
		jtp.addTab("Bệnh Nhân", pnlBenhNhan);
		pnlBenhNhan.setLayout(null);
		//tao tab 
		
	}
	
	public void controlBenhNhan(JPanel jpn) {
		
	}
}
