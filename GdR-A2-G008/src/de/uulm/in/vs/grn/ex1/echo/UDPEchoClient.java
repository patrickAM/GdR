package de.uulm.in.vs.grn.ex1.echo;

import java.io.IOException;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class UDPEchoClient extends Thread implements Runnable {
	InetAddress hostname;
	String sendMsg;
	int port;

	public UDPEchoClient(InetAddress hostname, int port, String sendMsg) {
		this.hostname = hostname;
		this.port = port;
		this.sendMsg = sendMsg;
	}

	@Override
	public void run() {
		try {
			DatagramSocket clientSocket = new DatagramSocket();
			byte[] toSend = sendMsg.getBytes();
			byte[] recData = new byte[2048];

			InetAddress ipAdress = hostname;

			DatagramPacket sendPacket = new DatagramPacket(toSend,
					toSend.length, ipAdress, port);

			clientSocket.send(sendPacket);

			DatagramPacket recPacket = new DatagramPacket(recData,
					recData.length);
			clientSocket.receive(recPacket);

			String sentence = new String(recPacket.getData());
			System.out.println(sentence);

			clientSocket.close();
		} catch (SocketException e) {
			// who needs exceptions anyways lulz
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// who needs exceptions anyways lulz
			e.printStackTrace();
		} catch (IOException e) {
			// who needs exceptions anyways lulz
			e.printStackTrace();
		}
	}
}
