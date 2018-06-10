package com.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	public static int count = 0;

	public static void main(String[] args) throws IOException, InterruptedException {

		ServerSocket sc = new ServerSocket(5000);
		Socket socket = null;

		while(true) {
			socket = sc.accept();
			new InputThread(socket).start();
			new OutputThread(socket).start();
		}
	}

}

class InputThread extends Thread {

	Socket sc = null;

	public InputThread(Socket isc) {
		sc = isc;
	}

	@Override
	public void run() {
		try {

//			while(true) {
				InputStream is = sc.getInputStream();
				byte[] br = new byte[200];
				int length = 0;
				while(-1 != (length = is.read(br, 0, br.length))) {
					System.out.println(new String(br, 0, length));
				}
//			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}

class OutputThread extends Thread {

	Socket sc = null;

	public OutputThread(Socket osc) {
		sc = osc;
	}

	@Override
	public void run() {
		try {
//			while(true) {
				OutputStream out = sc.getOutputStream();
				out.write("feed Back.".getBytes());
//			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
