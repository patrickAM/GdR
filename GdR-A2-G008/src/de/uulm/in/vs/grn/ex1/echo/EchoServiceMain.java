package de.uulm.in.vs.grn.ex1.echo;

import java.net.InetAddress;
import java.net.UnknownHostException;


public class EchoServiceMain extends Thread{
	public static void main(String[] args) throws UnknownHostException, InterruptedException{
		
		InetAddress local = InetAddress.getLocalHost();
		UDPEchoServer server = new UDPEchoServer(8888);
		UDPEchoClient client = new UDPEchoClient(local, 8888, "Hello World");	
		
		server.start();
		Thread.sleep(2000);
		client.start();
		
	}
}
