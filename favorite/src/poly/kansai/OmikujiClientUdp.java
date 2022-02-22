package poly.kansai;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class OmikujiClientUdp {
	private static final int SERVER_PORT = 30000;

	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("使用法：java poly.ex.EchoClientUdp <サーバIPアドレス> <名前>");
			System.exit(0);
		}
		try (DatagramSocket dSocket = new DatagramSocket();
				Scanner scan = new Scanner(System.in)) {
			System.out.println("おみくじを引く場合はaを、やめる場合はquitを入力して下さい");
			while (true) {
				System.out.print("---->");
				String action = scan.next();
				if(action.equals("a")) {
				String name = args[1];
				byte[] sendData = name.getBytes("UTF-8");

				InetAddress serverIp = InetAddress.getByName(args[0]);

				DatagramPacket sdp = new DatagramPacket(sendData, sendData.length, serverIp, SERVER_PORT);

				dSocket.send(sdp);

				byte[] receiveData = new byte[1024];

				DatagramPacket rdp = new DatagramPacket(receiveData, 1024);

				dSocket.setSoTimeout(500);

				dSocket.receive(rdp);

				String fortune = new String(receiveData, 0, rdp.getLength(), "UTF-8");
				System.out.println(name + "さんのおみくじの結果：" + fortune);
				}else if(action.equals("quit")) {
					byte[] quit = action.getBytes("UTF-8");
					InetAddress serverIp = InetAddress.getByName(args[0]);
					DatagramPacket sdp = new DatagramPacket(quit, quit.length, serverIp, SERVER_PORT);
					dSocket.send(sdp);
					break;
				} else {
					System.out.println(action + "は誤った入力です");
				}
			}
		} catch (Exception e) {
			System.out.print(e);
		}
	}
}
