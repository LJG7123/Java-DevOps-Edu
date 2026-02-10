package ex0203.제어문;

public class SwitchExam01 {

	public static void main(String[] args) {
		// 1 ~ 12 사이의 난수를 발생한다.
		// 그 난수는 월이라고 생각하고 월에 해당하는 마지막 일수를 출력한다.
		
		double rand = Math.random() * 12 + 1;
		System.out.println("난수 = " + rand);
		
		int month = (int) rand;
		System.out.println("변환 = " + month);
		
		int lastDay;
		if (month == 2) lastDay = 28;
		else if (month == 4 || month == 6 || month == 9 || month == 11) lastDay = 30;
		else lastDay = 31;
		
		int lastDay2 = switch (month) {
			case 2 -> 28;
			case 4, 6, 9, 11 -> {
				System.out.println("안녕");
				yield 30;
			}
			default -> 31;
		};
		
		System.out.println(month + "월은 " + lastDay + "일까지 있습니다.");
		System.out.println(month + "월은 " + lastDay2 + "일까지 있습니다.");
	}

}
