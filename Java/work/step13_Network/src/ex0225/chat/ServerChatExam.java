package ex0225.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 클라이언트와 1대1 채팅을 위한 server
 */
public class ServerChatExam {

	public ServerChatExam() {
		try {
			ServerSocket ss = new ServerSocket(8001);
			System.out.println("클라이언트 접속 대기..");
			Socket s = ss.accept();
			System.out.println(s.getInetAddress().toString() + "님과 대화를 시작합니다.");
			
			// Read
			new Thread(new Runnable() {
				@Override
				public void run() {
					try {
						BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
						
						while (true) {
							String data = br.readLine();
							if (data.equals("exit")) break;
							
							System.out.println(data);
						}
						
						System.out.println("서버의 받는 스레드 종료");
					} catch (IOException e) {
						e.printStackTrace();
						System.out.println("서버의 받는 스레드에서 예외 발생");
					}
				}
			}).start();
			
			// Write
			new SendThread(s, "[SERVER]").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ServerChatExam();

	}

}
