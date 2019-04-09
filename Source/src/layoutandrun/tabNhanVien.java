package layoutandrun;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

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
		controlBenhNhan(pnlBenhNhan);
		jtp.addTab("Bệnh Nhân", pnlBenhNhan);
	}
	
	public void controlBenhNhan(JPanel jpn) {
		
	}
}
