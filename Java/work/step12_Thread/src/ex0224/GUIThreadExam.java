package ex0224;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class GUIThreadExam extends JFrame{
	JTextField text1 = new JTextField(5);
	JTextField text2 = new JTextField(5);
	JButton btn = new JButton("눌려봐");
	
    public GUIThreadExam() {
    	super();
    	
    	
    	//JFrame 의 레이아웃 변경
    	super.setLayout(new FlowLayout());
    	
    	//Container위에 Component 추가 
         Container con = super.getContentPane();
         con.add(text1);
         con.add(text2);
         con.add(btn);
    	
    	//옵션 설정
    	//창크기
    	super.setSize(500, 400);
    	super.setLocationRelativeTo(null);//정중앙에 놓기
    	
    	//창보여줘.
    	super.setVisible(true);//보여줘
    	
    	//x를 클릭했을때 창 닫기 
    	super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//시계 스레드 시작
    	new NowTimeThread().start();
    	
    	new Thread(() -> {
    		for (int i = 1; i <= 1000; i++) {
    			text1.setText(i + "");
    			try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    	}).start();
    	
    	btn.addActionListener(e -> {
    		new Thread(() -> {
    			for (char c = 'A'; c <= 'z'; c++) {
    				text2.setText(c + "");
    				try {
    					Thread.sleep(100);
    				} catch (InterruptedException e1) {
    					e1.printStackTrace();
    				}
    			}
    		}).start();
    	});
    	
    }//생성자 끝
    
/////////////////////////////////////////////////////
	/**
	 * 현재 날짜와 시간 title에 출력하는 스레드
	 */
	
    /////////////////////////////////////////////////////////
      
	public static void main(String[] args) {
		new GUIThreadExam();
	}
	
	class NowTimeThread extends Thread {
		
		@Override
		public void run() {
			// 현재시간을 가져오기
			while (true) {
				Calendar now = Calendar.getInstance();

				StringBuilder sb = new StringBuilder();

				int y = now.get(Calendar.YEAR);
				int m = now.get(Calendar.MONTH) + 1;
				int d = now.get(Calendar.DATE);

				int h = now.get(Calendar.HOUR_OF_DAY);
				int min = now.get(Calendar.MINUTE);
				int sec = now.get(Calendar.SECOND);
				sb.append(y);
				sb.append("년 ");
				sb.append(m);
				sb.append("월 ");
				sb.append(d);
				sb.append("일 ");
				sb.append(h);
				sb.append(":");
				sb.append(min);
				sb.append(":");
				sb.append(sec);

				GUIThreadExam.this.setTitle(sb.toString());
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	} // Inner class 끝


}//클래스 끝

/**
 * 1초마다 동작하는 시계 Thread
 */













