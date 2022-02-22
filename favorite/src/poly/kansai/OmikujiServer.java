package poly.kansai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class OmikujiServer {
private static final int SERVER_PORT = 30000;
	
	public static void main(String[] args) throws IOException{
		ServerSocket svSocket = new ServerSocket(SERVER_PORT);
		
		while(true) {
			System.out.println("接続受付中...");
			
			Socket cSocket = svSocket.accept();
			
			BufferedInputStream bis = new BufferedInputStream(cSocket.getInputStream());
		
			DataInputStream dis = new DataInputStream(bis);
			
			BufferedOutputStream bos = new BufferedOutputStream(cSocket.getOutputStream());
			
			DataOutputStream dos = new DataOutputStream(bos);
			
			String str = dis.readUTF();
			
			if(str.equals("a")) {
				str = Omikuji();
				System.out.println("おみくじの結果:" + str +"を返しました");
			}
			dos.writeUTF(str);
			dos.flush();
			
			dis.close();
			dos.close();
			cSocket.close();
			
			if(str.equals("quit")) {
				System.out.print("終了");
				break;
			}
		}
		
		svSocket.close();
	}
	public static String Omikuji() {
		Random rand = new Random();
		int num = rand.nextInt(4);
		String[] results = {"大吉","中吉","末吉","凶"};
		return results[num];
	}

}
