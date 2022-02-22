package poly.kansai;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class EchoServerUdp {
	private static final int SERVER_PORT = 30000;
	
	public static void main(String[] args) {
		byte[] data = new byte[1024];
		
		try(DatagramSocket dSocket = new DatagramSocket(SERVER_PORT);) {
			DatagramPacket rdp = new DatagramPacket(data,1024);
			
			while(true) {
				System.out.println("接続待機中...");
				dSocket.receive(rdp);
				
				String str = new String(data, 0, rdp.getLength());
				
				System.out.println("受信文字列：" + str);
				
				DatagramPacket sdp = new DatagramPacket(data, rdp.getLength(), rdp.getAddress(),rdp.getPort());
				
				dSocket.send(sdp);
				
				if(str.equals("quit")) {
					System.out.print("終了");
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
}
