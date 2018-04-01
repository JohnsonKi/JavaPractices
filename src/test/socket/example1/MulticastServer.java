package test.socket.example1;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastServer {
	
	public static final int TEST_PORT = 50004;
	public static final int PACKET_SIZE = 1024;
	public static final String MCAST_ADDRESS = "224.0.1.1";
	
	public static void main(String[] args) {
		MulticastSocket socket = null;
		byte[] buf = new byte[PACKET_SIZE];
		DatagramPacket packet = new DatagramPacket(buf, buf.length);

		try {
			socket = new MulticastSocket(TEST_PORT);
			InetAddress mcastAddress = InetAddress.getByName(MCAST_ADDRESS);
			socket.joinGroup(mcastAddress);
			System.out.println("MulticastReceiver Start: address=" + mcastAddress + ",port=" + socket.getLocalPort());
			
			while(true) {
				socket.receive(packet);
				String message = new String(buf, 0, packet.getLength());
				System.out.println(packet.getSocketAddress() + " : " + message);
			}
		} catch(IOException ie) {
			ie.printStackTrace();
		} finally {
			if (socket != null) {
				socket.close();
			}
		}
	}

}
