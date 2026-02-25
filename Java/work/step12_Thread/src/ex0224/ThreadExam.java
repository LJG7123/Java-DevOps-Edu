package ex0224;


/**
 * 숫자를 100번 출력하는 스레드
 */
class NumberThread extends Thread {
	int sum;
	
	public NumberThread(String name) {
		super(name);
	}
	
	@Override
	public void run() {
		for(int i = 1; i <= 100; i++) {
			System.out.println(super.getName() + "=>" + i);
			sum += i;
			
//			Thread.yield(); // 스레드 양보
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 1초 정지 -> 이후 Runnable 상태
		}
		System.out.println(super.getName() + " end");
	}
}

/**
 * 알파벳을 출력하는 스레드
 */
class AlphabetThread implements Runnable {

	@Override
	public void run() {
		Thread th = Thread.currentThread();
		
		for (char c = 'A'; c <= 'z'; c++) {
			System.out.println(th.getName() + "=>" + c);
			
			try {
				Thread.sleep((int) (Math.random() * 100));
			} catch (InterruptedException e) {
				e.printStackTrace();
			} // 1초 정지 -> 이후 Runnable 상태
		}
		System.out.println(th.getName() + " end");
	}
	
}
public class ThreadExam {
	
	public static void main(String[] args) {
		System.out.println("------메인 시작------");
		
		Thread th1 = new NumberThread("First");
		Thread th2 = new NumberThread("Second");
		Thread th3 = new Thread(new AlphabetThread(), "Third");
		
		// 멀티스레드로 동작하기 위해서는 run()을 직접 호출하지 않는다
//		th1.run();
//		th2.run();
//		th3.run();
		
		th1.start();
		th2.start();
		th3.start();
		
		/*try {
			th1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}*/
		
		System.out.println("총합 = " + ((NumberThread) th1).sum);
		
		System.out.println("------메인 종료------");
	}
}
