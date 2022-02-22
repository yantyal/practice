package poly.kansai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientTcp2 {
	private static final int SERVER_PORT = 30000;

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("使用法: java poly.ex.EchoClientTcp<サーバーIPアドレス>");
			System.exit(0);
		}

		try (Socket socket = new Socket(args[0], SERVER_PORT);

				BufferedInputStream bis = new BufferedInputStream(socket.getInputStream());

				DataInputStream dis = new DataInputStream(bis);

				BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream());

				DataOutputStream dos = new DataOutputStream(bos);

				Scanner stdin = new Scanner(System.in);) {

			System.out.println("文字列入力: ");
			String msg = stdin.next();

			dos.writeUTF(msg);
			dos.flush();

			msg = dis.readUTF();
			System.out.println("エコー文字列: " + msg);

		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
