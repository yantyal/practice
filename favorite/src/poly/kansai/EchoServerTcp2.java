package poly.kansai;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerTcp2 {
	private static final int SERVER_PORT = 30000;

	public static void main(String[] args) {
		try (ServerSocket svSocket = new ServerSocket(SERVER_PORT);) {

			while (true) {
				System.out.println("接続受付中...");

				try (Socket cSocket = svSocket.accept();

						BufferedInputStream bis = new BufferedInputStream(cSocket.getInputStream());

						DataInputStream dis = new DataInputStream(bis);

						BufferedOutputStream bos = new BufferedOutputStream(cSocket.getOutputStream());

						DataOutputStream dos = new DataOutputStream(bos);) {

					String str = dis.readUTF();
					System.out.println("受信文字列:" + str);

					dos.writeUTF(str);
					dos.flush();
					if (str.equals("quit")) {
						break;
					}
				} catch (Exception e) {
					System.out.println(e);
				}

			}
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
