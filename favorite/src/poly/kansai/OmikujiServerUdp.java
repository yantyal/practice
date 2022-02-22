package poly.kansai;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Random;

public class OmikujiServerUdp {
private static final int SERVER_PORT = 30000;
	
	public static void main(String[] args) {
		byte[] data = new byte[1024];
		
		try(DatagramSocket dSocket = new DatagramSocket(SERVER_PORT);) {
			DatagramPacket rdp = new DatagramPacket(data,1024);
			
			while(true) {
				System.out.println("接続待機中...");
				dSocket.receive(rdp);
				
				String name = new String(data, 0, rdp.getLength());
				
				System.out.println("名前：" + name + "さん");
				
				String msg = Omikuji();
				byte[] result = msg.getBytes("UTF-8");
				System.out.println("おみくじの結果(" + msg + ")を返しました");
				
				DatagramPacket sdp = new DatagramPacket(result, result.length, rdp.getAddress(),rdp.getPort());
				
				dSocket.send(sdp);
				if(name.equals("quit")) {
					break;
				}
			}
			
		}catch(Exception e) {
			System.out.print(e);
		}
	}
	public static String Omikuji() {
		Random rand = new Random();
		int num = rand.nextInt(4);
		String[] results = {"大吉","中吉","末吉","凶"};
		return results[num];
	}
}
