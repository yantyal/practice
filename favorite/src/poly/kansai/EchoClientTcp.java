package poly.kansai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientTcp {
	private static final int SERVER_PORT = 30000;
	
	public static void main(String[] args) {
		if(args.length != 1) {
			System.out.println("使用法: java poly.ex.EchoClientTcp<サーバーIPアドレス>");
			System.exit(0);
		}
		
		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		
		Scanner stdin = null;
		
		try {
			socket = new Socket(args[0], SERVER_PORT);
			
			BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());
		
			dis = new DataInputStream(bis);
			
			BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());
		
			dos = new DataOutputStream(bos);
			
			stdin = new Scanner(System.in);
			System.out.println("文字列入力: ");
			String msg = stdin.next();
			
			dos.writeUTF(msg);
			dos.flush();
			
			msg = dis.readUTF();
			System.out.println("エコー文字列: " + msg);
			
			
		}catch(IOException e) {
			System.out.println(e);
			
		}finally {
			try {
				if(dis != null) {
					dis.close();
				}
				if(dos != null) {
					dos.close();
				}
				if(socket != null) {
					socket.close();
				}
			}catch(IOException e) {
				System.out.println(e);
			}
			
			if(stdin != null) {
				stdin.close();
			}
		}
	}

}
