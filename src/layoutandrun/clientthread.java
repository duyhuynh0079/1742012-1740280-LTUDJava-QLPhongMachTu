package layoutandrun;

import java.io.IOException;
import java.net.Socket;

public class clientthread {
	public clientthread() {
		Socket s = null;
		try {
			s = new Socket("localhost", 6789);
			s.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
