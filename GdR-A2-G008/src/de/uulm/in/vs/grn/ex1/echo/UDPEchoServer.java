package de.uulm.in.vs.grn.ex1.echo;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.lang.StringBuffer;

public class UDPEchoServer extends Thread implements Runnable {
	public int port;

	public UDPEchoServer(int a) {
		this.port = a;
	}

	@Override
	public void run() {
		boolean derp = true;
		byte[] receive = new byte[1024];

		try {
			DatagramSocket serverSocket = new DatagramSocket(port);
			while (derp) {
				DatagramPacket recPacket = new DatagramPacket(receive,receive.length);
				serverSocket.receive(recPacket);
				String data = new String(recPacket.getData());
				data = new StringBuffer(data).reverse().toString();
				System.out.println(data);
			}
			serverSocket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
