package test.socket.example1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class ToUpperTCPServer {

	public void startServer(String serverIP, int serverPort) {

        InetAddress serverAddr;
        try {
            serverAddr = InetAddress.getByName(serverIP);
        } catch (UnknownHostException e1) {
            e1.printStackTrace();
            return;
        }
        
        try (ServerSocket serverSocket = new ServerSocket(ToUpperTCPClient.SERVER_PORT, 5, serverAddr)) {
            while (true) {
                StringBuilder recvStrBuilder = new StringBuilder();

                try (Socket connection = serverSocket.accept()) {
                    InputStream in = connection.getInputStream();
                        
                    for (int c = in.read(); c != ToUpperTCPClient.REQUEST_END_CHAR; c = in.read()) {
                        recvStrBuilder.append((char)c);
                    }
                    recvStrBuilder.append('#');
                    
                    String recvStr = recvStrBuilder.toString();

                    OutputStream out = connection.getOutputStream();
                    out.write(recvStr.toUpperCase().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
    	ToUpperTCPServer server = new ToUpperTCPServer();
        server.startServer(ToUpperTCPClient.SERVER_IP, ToUpperTCPClient.SERVER_PORT);
    } 
}
