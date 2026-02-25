package ex0225.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * 접속한 클라이언트들을 관리하기 위한 서버
 */
public class ServerGUIChatExam {
	Socket s;
	List<ClientSocketThread> list = new ArrayList<>();
	
	public ServerGUIChatExam() {
		try (ServerSocket ss = new ServerSocket(8002)) {
			while (true) {
				System.out.println("클라이언트 접속 대기중..");
				
				s = ss.accept();
				System.out.println(s.getInetAddress() + "님이 접속하셨습니다.");
				
				ClientSocketThread th = new ClientSocketThread();
				th.start();
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // 생성자 끝
	
	/**
	 * 접속한 모든 클라이언트에게 메세지 전송하는 메소드
	 */
	public void sendMessage(String message) {
		for (ClientSocketThread th : list) {
			th.pw.println(message);
		}
	}
	
	public boolean containsNickname(String nickname) {
		for (ClientSocketThread th : list) {
			if (th.nickname.equals(nickname)) return true;
		}
		
		return false;
	}
	
	class ClientSocketThread extends Thread {
		PrintWriter pw;
		BufferedReader br;
		String nickname;
		
		ClientSocketThread() {
			try {
				pw = new PrintWriter(s.getOutputStream(), true);
				br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		@Override
		public void run() {
			// 클라이언트가 보내온 내용을 읽어서 접속한 모든 클라이언트에게 전송
			try {
				nickname = br.readLine();
				while (containsNickname(nickname)) {
					pw.println(-1);
					nickname = br.readLine();
				}
				pw.println(nickname + "으로 접속 성공");
				
				list.add(this);
				System.out.println("현재 접속 인원: " + list.size() + "명\n");
				
				sendMessage("[" + nickname + "]님이 입장했습니다.");
				
				while (true) {
					String input = br.readLine();
					sendMessage(nickname + ": " + input);
				}
			} catch (Exception e) {
				// 현재 스레드에 문제발생
				//e.printStackTrace();
				
				// 현재 스레드를 list에서 제거
				list.remove(this);
				
				// 남은 클라이언트에게 알린다
				sendMessage("[" + nickname + "]님이 퇴장하셨습니다.");
				
				// 서버 콘솔에 인언수 출력
				System.out.println("[" + nickname + "]님 퇴장 | 현재 접속 인원: " + list.size() + "명\n");
			}
		}
	}
	
	public static void main(String[] args) {
		new ServerGUIChatExam();
	}

}
