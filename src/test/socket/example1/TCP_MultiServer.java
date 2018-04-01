package test.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCP_MultiServer {

	public static final int TEST_PORT = 50002;
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket = null;
		
		try {
			serverSocket = new ServerSocket(TEST_PORT);
			System.out.println("Server Start:" + serverSocket.getLocalPort());
			
			while(true) {
				Socket socket = serverSocket.accept();
				new SocketThread(socket).start();
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (serverSocket != null) {
					serverSocket.close();
				}
			} catch(IOException ie1) {}
		}
	}
}

class SocketThread extends Thread {
	
	private Socket socket = null;
	
	public SocketThread(Socket socket) {
		this.socket = socket;
		System.out.println("Socket Thread Start : " + socket.getRemoteSocketAddress());
	}
	
	public void run() {
		try {
			BufferedReader streamIn = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter streamOut = new PrintWriter(socket.getOutputStream(), true);
			
			String line;
			while((line = streamIn.readLine()) != null) {
				// Receive Request
				System.out.println(socket.getRemoteSocketAddress() + " Receive: " + line);
				
				// Send Response
				streamOut.println(line);
				System.out.println(socket.getRemoteSocketAddress() + " Send: " + line);
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			try {
				if (socket != null) {
					socket.close();
				}
			} catch(IOException io) {
				System.out.println("Server Close:" + socket.getRemoteSocketAddress());
			}
		}
	}
}
