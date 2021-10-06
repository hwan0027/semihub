package movie;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public static void main(String[] args) {
       
		Socket socket = null;
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {

			System.out.println("***서버 소켓 생성***");
			
			ServerSocket serverSocket = new ServerSocket(7777);
			
			
			System.out.println("접속 요청 대기중...");
			 socket = serverSocket.accept();
			System.out.println("접속 성공"+socket.getPort());
			
			br = new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(), "utf-8"));
			System.out.println("인풋, 아웃풋 스트림 가져옴");
          
			bw.write("안녕 \n");
			bw.flush(); 
			
			System.out.println("클라이언트에게 메시지를 보냄!!");
			
			String msg = br.readLine(); 
			System.out.println(msg);
			
			System.out.println("서버 종료");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(br != null) {br.close();}
				if(br != null) {bw.close();}
				if(socket != null) {socket.close();}
			}catch (IOException e) {}
		}
	}

}

