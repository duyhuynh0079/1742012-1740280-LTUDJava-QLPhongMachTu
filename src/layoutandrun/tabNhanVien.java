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
import java.util.Properties;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import layoutandrun.subtabBenhNhan;
import show.showBenhNhan;

import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;


public class tabNhanVien extends JFrame {
	static int idnv = 0;
	static String tennv = "";
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

	private static void createAndShowGUI() {
		tabNhanVien tnv = new tabNhanVien(tennv, idnv);
		tnv.setSize(1000, 600);
		tnv.setLocationRelativeTo(null);
		tnv.setExtendedState(JFrame.MAXIMIZED_BOTH);
		tnv.setVisible(true);
	}

	public tabNhanVien(String tennhanvien, int manhanvien) {
		tennv = tennhanvien;
		manv = manhanvien;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle(tennv);
		JTabbedPane jtp = new JTabbedPane();
		getContentPane().add(jtp);
		addComponentToTab(jtp);// goi ham tao cac tab con
	}

	public void addComponentToTab(JTabbedPane jtp) {
		// tao tab BenhNhan
		JPanel pnlBenhNhan = new JPanel();
		subtabBenhNhan stbn = new subtabBenhNhan();
		stbn.controlBenhNhan(pnlBenhNhan,manv,tennv);
		jtp.addTab("Bệnh Nhân", pnlBenhNhan);
		pnlBenhNhan.setLayout(null);

		// tao tab PhieuKhamBenh
		JPanel pnlPhieuKhamBenh = new JPanel();
		subtabPhieuKhamBenh stpkb = new subtabPhieuKhamBenh();
		stpkb.controlPhieuKhamBenh(pnlPhieuKhamBenh,manv,tennv);
		jtp.addTab("Phiếu Khám Bệnh", pnlPhieuKhamBenh);
		pnlPhieuKhamBenh.setLayout(null);

		// tao tab BaoCao
		JPanel pnlBaoCao = new JPanel();
		subtabBaoCao stbc = new subtabBaoCao();
		stbc.controlBaoCao(pnlBaoCao,manv,tennv);
		jtp.addTab("Báo Cáo", pnlBaoCao);
		pnlBaoCao.setLayout(null);

		// tao tab QuyDinh
		JPanel pnlQuyDinh = new JPanel();
		subtabQuyDinh stqd = new subtabQuyDinh();
		stqd.controlQuyDinh(pnlQuyDinh,manv,tennv);
		jtp.addTab("Quy Định", pnlQuyDinh);
		pnlQuyDinh.setLayout(null);

	}
}
