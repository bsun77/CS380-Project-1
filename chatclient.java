import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class chatclient {

	public chatclient(){

	}

	public static void main(String[]args) throws Exception{
		try (Socket socket = new Socket("18.221.102.182", 38001)) {
			while(true){
				@SuppressWarnings("resource")
				Scanner s = new Scanner(System.in);

				OutputStream os = socket.getOutputStream();
				PrintStream out = new PrintStream(os, true, "UTF-8");

				Thread t = new Thread(new listenerthread(socket));
				t.start();

				String a;
				do{
					a = s.nextLine();
					out.println(a);
				}
				while(!a.equals("exit"));
				System.exit(0);
			}
		}
	}

}