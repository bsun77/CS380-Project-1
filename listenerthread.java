import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;


public class listenerthread implements Runnable {

	private Socket socket;

	public listenerthread(Socket socket){
		this.socket = socket;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader br = new BufferedReader(isr);
			
			while(true){
					System.out.println(br.readLine());
			}
		} catch (Exception e) {
			System.out.println("Error.");
			e.printStackTrace();
		}
	}

}
