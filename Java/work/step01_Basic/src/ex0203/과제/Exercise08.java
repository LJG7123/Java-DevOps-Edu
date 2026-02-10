package ex0203.과제;

import java.util.Scanner;

public class Exercise08 {

	public static void main(String[] args) {
		boolean run = true;
		
		int balance = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while (run) {
			System.out.println("---------------------------------");
			System.out.println("1.예금 | 2.출금 | 3.잔고 | 4.종료");
			System.out.println("---------------------------------");
			System.out.print("선택> ");
			
			int menu = scanner.nextInt();
			switch(menu) {
				case 1 -> {
					System.out.print("예금액>");
					int amount = scanner.nextInt();
					balance += amount;
				}
				case 2 -> {
					System.out.print("출금액>");
					int amount = scanner.nextInt();
					if (amount > balance) {
						System.out.println("잔고를 초과하여 출금할 수 없습니다.");
						break;
					}
					balance -= amount;
				}
				case 3 -> System.out.println("잔고>" + balance);
				case 4 -> run = false;
				default -> System.out.println("1~4 사이의 숫자만 입력 가능합니다.");
			}
		}
		
		System.out.println("프로그램 종료");
		scanner.close();
	}

}
