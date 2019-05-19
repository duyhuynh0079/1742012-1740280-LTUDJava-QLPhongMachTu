package layoutandrun;

public class mythread extends Thread {
	 public void run(){
			dangnhap dn = new dangnhap();
			dn.setVisible(true);
			dn.setLocationRelativeTo(null); // canh giữa màn hình
	    }
}
