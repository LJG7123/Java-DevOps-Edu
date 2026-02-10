package ex0203.과제;

public class Exercise06 {

	public static void main(String[] args) {
		while(true) {
			int value1 = (int) (Math.random() * 6) + 1;
			int value2 = (int) (Math.random() * 6) + 1;
			System.out.println("(" + value1 + ", " + value2 + ")");
			if (value1 + value2 == 5) break;
		}

	}

}
