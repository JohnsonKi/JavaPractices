package test.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class UDP_Client {

	public static final int SERVER_PORT = 50003;
	public static final int PACKET_SIZE = 1024;
	
	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		InetSocketAddress remoteAddress = new InetSocketAddress(args[0], SERVER_PORT);

		try {
			BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
			socket = new DatagramSocket();
			
			String message;
			while((message = keyIn.readLine()).length() > 0) {
				byte[] buf = message.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, remoteAddress);
				socket.send(packet);
			}
			
		} catch(IOException io) {
			io.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
