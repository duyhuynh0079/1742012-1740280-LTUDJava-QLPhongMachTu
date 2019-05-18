package layoutandrun;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DAO.phieukhamDAO;

public class serverthread extends Thread implements Runnable {
	static JTable jt;
	static JTextField jtf;
	public serverthread(JTable jtpk, JTextField jtf) {
		this.jt = jtpk ;
		this.jtf = jtf ;
		start();
	}
	
	public void run() {
		try {
			ServerSocket ss = new ServerSocket(6789);// server socket port 2k
			while (true) {
				System.out.println("Đang lắng nghe kết nối-------");
				Socket s = ss.accept();// khi co 1 socket con ket noi
				System.out.println("có kênh kết nối");
				
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
					jt.setModel(modelPhieuKham);
					jtf = textfieldSearch.createRowFilter(jt);
				s.close();
			}
		} catch (IOException e) {
			System.out.println("Loi tao serversocket port 6789");
		}
	}
}
