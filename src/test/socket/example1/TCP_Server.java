package test.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_Server {

	public static final int TEST_PORT = 50002;
	
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		Socket socket = null;
		
		try {
			
			serverSocket = new ServerSocket(TEST_PORT);
			System.out.println("TCP Server: Start(port=" + TEST_PORT + ")");
			
			socket = serverSocket.accept();
			System.out.println("TCP Server: Connection OK!" + socket.getRemoteSocketAddress());
			
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(socket.getOutputStream(), true);
			
			String line;
			while((line = streamIn.readLine()) != null) {
				System.out.println("TCP Server: Receive Client Request " + line);
				streamOut.println(line);
				System.out.println("TCP Server: Send Server Response " + line);
			}
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch (IOException ioe1) {}
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch (IOException ioe2) {}
		}
	}
}
