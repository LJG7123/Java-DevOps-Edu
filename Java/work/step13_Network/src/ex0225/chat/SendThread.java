package ex0225.chat;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 상대측에게 데이터를 전송하는 스레드
 */
public class SendThread extends Thread {
	private Socket socket;
	String name;
	
	public SendThread(Socket socket, String name) {
		super(name);
		this.name = name;
		this.socket = socket;
	}
	
	@Override
	public void run() {
		Scanner sc = new Scanner(System.in);
		
		// 상대측에 데이터 전송
		try {
			PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
			
			while (true) {
				String input = sc.nextLine();
				
				if (input.equals("exit")) {
					pw.println(input);
					break;
				}
				
				pw.println(name + ": " + input);
			}
			System.out.println(name + "의 SendThread 종료");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println(name + "의 SendThread에 예외 발생");
		} finally {
			sc.close();
			System.out.println("----프로그램 종료----");
			System.exit(0);
		}
	}
}
