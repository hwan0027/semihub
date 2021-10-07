package movieTicketing;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class ServerClient {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		try (Socket socket = new Socket("192.168.200.158", 7777); // 테스트용 집 아이피
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

			while (true) {

				String msg = null;
				String send = null;

				msg = br.readLine();
				System.out.println(msg);
				msg = br.readLine();
				System.out.println(msg);
				
				send = scan.nextLine();
				bw.write(send);
				bw.newLine();
				bw.flush();

				System.out.println(">>>" + send);

			}

		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
