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
		int cnt = 0;
		try (Socket socket = new Socket("192.168.200.158", 7777); // 테스트용 집 아이피
				BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()))) {

			cnt++;

			String msg = null;
			String send = null;

			// 기능 선택
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);

			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();

			System.out.println(">>>" + send);

			// 예매 선택후 영화관 선택
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);

			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();

			System.out.println(">>>" + send);

			// 영화명 선택
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);

			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();

			System.out.println(">>>" + send);

			// 상영관 선택
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);

			send = scan.nextLine();
			int theater = Integer.valueOf(send); // 상영관 번호 저장
			bw.write(send);
			bw.newLine();
			bw.flush();

			System.out.println(">>>" + send);

			// 시간 선택
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);

			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();

			System.out.println(">>>" + send);

			if (theater == 1) {// business
				for (int i = 0; i < 6; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 2) {// premium
				for (int i = 0; i < 2; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 3) {// goldclass
				for (int i = 0; i < 4; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 4) {// 4dx
				for (int i = 0; i < 9; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 5) {// imax
				for (int i = 0; i < 8; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			}
			
			msg = br.readLine();
			System.out.println(msg);
			
			//좌석 행 선택
			msg = br.readLine();
			System.out.println(msg);
			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();
			
			//좌석 열 선택
			msg = br.readLine();
			System.out.println(msg);
			send = scan.nextLine();
			bw.write(send);
			bw.newLine();
			bw.flush();
			
		

			//예매된 좌석 확인
			if (theater == 1) {// business
				for (int i = 0; i < 6; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 2) {// premium
				for (int i = 0; i < 2; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 3) {// goldclass
				for (int i = 0; i < 4; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 4) {// 4dx
				for (int i = 0; i < 9; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			} else if (theater == 5) {// imax
				for (int i = 0; i < 8; i++) {
					msg = br.readLine();
					System.out.println(msg);
				}
			}
			//좌석 확인
			msg = br.readLine();
			System.out.println(msg);
			msg = br.readLine();
			System.out.println(msg);
			
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
