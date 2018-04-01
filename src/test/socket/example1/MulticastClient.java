package test.socket.example1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastClient {

	public static final int TEST_PORT = 50004;
	public static final int PACKET_SIZE = 1024;
	public static final String MCAST_ADDRESS = "224.0.1.1";
	
	public static void main(String[] args) {
		MulticastSocket socket = null;
		
		try {
			InetAddress mcastAddress = InetAddress.getByName(MCAST_ADDRESS);
			BufferedReader keyIn = new BufferedReader(new InputStreamReader(System.in));
			socket = new MulticastSocket();
			
			String message;
			while((message = keyIn.readLine()).length() > 0) {
				byte[] buf = message.getBytes();
				DatagramPacket packet = new DatagramPacket(buf, buf.length, mcastAddress, TEST_PORT);
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
