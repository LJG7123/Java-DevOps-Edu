package ex0225.net;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {

	public ServerExam() {
		try (ServerSocket ss = new ServerSocket(8000)) {
			while (true) {
				System.out.println("클라이언트 접속 대기중..");
				
				Socket s = ss.accept(); // 클라이언트 접속 대기
				String ip = s.getInetAddress().toString();
				
				System.out.println(ip + "가 접속했습니다.");
				
				// 클라이언트가 보내온 데이터 읽기
				BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
				String data = br.readLine();
				System.out.println("클라이언트가 보내온 내용: " + data);
				
				// 클라이언트에게 데이터 보내기 (전송)
				PrintWriter pw = new PrintWriter(s.getOutputStream(), true);
				pw.println("자바 서버에서 보내는 메세지입니다.");
				
				System.out.println();
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerExam();
	}

}
