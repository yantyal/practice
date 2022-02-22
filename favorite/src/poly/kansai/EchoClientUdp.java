package poly.kansai;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class EchoClientUdp {
	private static final int SERVER_PORT = 30000;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("使用法：java poly.ex.EchoClientUdp <サーバIPアドレス>");
			System.exit(0);
		}
		try(DatagramSocket dSocket = new DatagramSocket();
				Scanner stdin = new Scanner(System.in)){
			System.out.println("文字列入力：");
			String msg = stdin.next();
			
			byte[] sendData = msg.getBytes();
			
			InetAddress serverIp = InetAddress.getByName(args[0]);
			
			DatagramPacket sdp = new DatagramPacket(sendData, sendData.length, serverIp, SERVER_PORT);
			
			dSocket.send(sdp);
			
			byte[] receiveData = new byte[1024];
			
			DatagramPacket rdp = new DatagramPacket(receiveData, 1024);
			
			dSocket.setSoTimeout(500);
			
			dSocket.receive(rdp);
			
			String str = new String(receiveData, 0, rdp.getLength());
			System.out.println("エコー文字列："+ str);
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}
