package test.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TCP_Client {

	public static final int TEST_PORT = 50002;
	
	public static void main(String[] args) {
	
		TCP_Method1(args[0]);
//		TCP_Method2("ntp.nict.jp");
	}
	
	public static void TCP_Method2(String hostname) {
		
		Socket socket = null;
		
		try {
			socket = new Socket(hostname, 13);
			System.out.println("TCP Client: Start " + socket.getRemoteSocketAddress());
			
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = streamIn.readLine();
			
			int i = 0;
			while (i < 5) {
				if (line != null) {
					System.out.println("Server Response:" + line);
				} else {
					break;
				}
				
				i++;
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException ie) {
				System.out.println("TCP Client: Close " + socket.getRemoteSocketAddress());
			}
		}
	}
	
	public static void TCP_Method1(String hostname) {
		Socket socket = null;
		
		try {
			socket = new Socket(hostname, TEST_PORT);
			System.out.println("TCP Client: Start " + socket.getRemoteSocketAddress());
			
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(socket.getOutputStream(), true);
			
			BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
			String inputStr;
			while((inputStr = keyIn.readLine()).length() > 0) {
				// Send key input to Server
				streamOut.println(inputStr);
				
				// get Response From Server
				String line = streamIn.readLine();
				if (line != null) {
					System.out.println("Server Response:" + line);
				} else {
					break;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException ie) {
				System.out.println("TCP Client: Close " + socket.getRemoteSocketAddress());
			}
		}
	}
}
