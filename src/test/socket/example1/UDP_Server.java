package test.socket.example1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDP_Server {

	public static final int SERVER_PORT = 50003;
	public static final int PACKET_SIZE = 1024;
	
	public static void main(String[] args) {
		
		DatagramSocket socket = null;
		byte[] buf = new byte[PACKET_SIZE];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);

		try {
			socket = new DatagramSocket(SERVER_PORT);
			System.out.println("Datagram Receive Start(port=" + socket.getLocalPort() + ")");
			
			while(true) {
				socket.receive(packet);
				String message = new String(buf, 0, packet.getLength());
				System.out.println(packet.getSocketAddress() + " Receive: " + message);
			}
			
		} catch (IOException ie) {
			ie.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
