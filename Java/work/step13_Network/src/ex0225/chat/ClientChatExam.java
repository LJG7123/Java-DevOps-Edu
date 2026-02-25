package ex0225.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 서버와 1대1 채팅을 위한 클라이언트
 */
public class ClientChatExam {

	public ClientChatExam() {
		try {
			Socket s = new Socket("192.168.0.", 8001);
			
			// Read
			new Thread(() -> {
				try {
					BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
					
					while (true) {
						String data = br.readLine();
						
						if (data.equals("exit")) break;
						
						System.out.println(data);
					}
					
					System.out.println("클라이언트의 받는 스레드 종료");
				} catch (IOException e) {
					e.printStackTrace();
					System.out.println("클라이언트의 받는 스레드에서 예외 발생");
				} finally {
					System.out.println("---모든 프로그램을 종료합니다---");
					System.exit(0);
				}
			}).start();
			
			// Write
			new SendThread(s, "[CLIENT]").start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new ClientChatExam();
	}

}
