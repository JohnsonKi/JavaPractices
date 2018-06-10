package com.test.socket;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {
	public static int count = 0;
	public static void main(String[] args) throws IOException, InterruptedException {

		Socket socket = new Socket("127.0.0.1", 5000);

		while(true) {
			new OutputClient(socket).start();
			new InputClient(socket).start();
		}
	}
}

class InputClient extends Thread {
	private Socket sc = null;
	public InputClient(Socket isc) {
		sc = isc;
	}

	@Override
	public void run() {
		InputStream in;
		try {
			in = sc.getInputStream();

			byte[] br = new byte[200];
			int length = 0;
			while(-1 != (length = (in.read(br, 0, br.length)))) {
				System.out.println(new String(br, 0, length));
			}

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

class OutputClient extends Thread {
	private Socket sc = null;
	public OutputClient(Socket osc) {
		sc = osc;
	}

	@Override
	public void run() {
		try {
			OutputStream out = sc.getOutputStream();
			byte[] outbuffer = ("hello world." + TCPClient.count++).getBytes();
			out.write(outbuffer);

		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}