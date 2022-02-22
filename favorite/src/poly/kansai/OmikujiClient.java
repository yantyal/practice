package poly.kansai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class OmikujiClient {
	private static final int SERVER_PORT = 30000;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("使用法: java poly.ex.EchoClientTcp<サーバーIPアドレス>");
			System.exit(0);
		}

		Socket socket = null;
		DataInputStream dis = null;
		DataOutputStream dos = null;
		Scanner stdin = null;
		String str = "none";

		System.out.println("おみくじを引く場合はaを、やめる場合はquitを入力して下さい");

		try {
			while (true) {
				socket = new Socket(args[0], SERVER_PORT);

				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

				dis = new DataInputStream(bis);

				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

				dos = new DataOutputStream(bos);

				stdin = new Scanner(System.in);

				System.out.print("--->");
				String msg = stdin.next();
				while (true) {

					if (msg.equals("quit")) {
						str = msg;
						dos.writeUTF(msg);
						dos.flush();
						break;
					} else if (msg.equals("a")) {
						dos.writeUTF(msg);
						dos.flush();
						break;
					} else {
						System.out.println(msg + "は誤った入力です");
						System.out.print("--->");
						msg = stdin.next();
					}
				}
				if (str.equals("quit")) {
					break;
				}

				msg = dis.readUTF();
				System.out.println("結果: " + msg);
			}

		} catch (IOException e) {
			System.out.println(e);

		} finally {
			try {
				if (dis != null) {
					dis.close();
				}
				if (dos != null) {
					dos.close();
				}
				if (socket != null) {
					socket.close();
				}
			} catch (IOException e) {
				System.out.println(e);
			}

		}

	}

}
