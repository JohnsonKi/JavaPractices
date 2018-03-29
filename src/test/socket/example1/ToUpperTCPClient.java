package test.socket.example1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ToUpperTCPClient {

	public Socket clientSocket;
	public static final String SERVER_IP = "127.0.0.1";
	public static final int SERVER_PORT = 10005;
	public static final char REQUEST_END_CHAR = '#';
	
	public String toUpperRemote(String serverIp, int serverPort, String str) {
		
		StringBuilder recvStrBuilder = new StringBuilder();
		try {
			clientSocket = new Socket(serverIp, serverPort);
			OutputStream out = clientSocket.getOutputStream();
			out.write(str.getBytes());

			InputStream in = clientSocket.getInputStream();
			for (int c = in.read(); c != '#'; c = in.read()) {
				recvStrBuilder.append((char)c);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (clientSocket != null) {
					clientSocket.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return recvStrBuilder.toString();
	}
	
	public static void main(String[] args){
		ToUpperTCPClient client = new ToUpperTCPClient();
		String recvStr = client.toUpperRemote(SERVER_IP,SERVER_PORT,"aaaAAAbbbBBBcccCCC"+REQUEST_END_CHAR);
		System.out.println("Over:"+recvStr);
	}
}
