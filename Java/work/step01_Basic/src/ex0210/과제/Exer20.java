package ex0210.과제;

import java.util.Scanner;

public class Exer20 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankApplication bankApp = new BankApplication();
		boolean run = true;
		
		while(run) {
			System.out.println("--------------------------------------------------");
			System.out.println("1.계좌생성 | 2.계좌목록 | 3.예금 | 4.출금 | 5.종료");
			System.out.println("--------------------------------------------------");
			int menu = sc.nextInt();
			
			switch(menu) {
			case 1 -> {
				printMenu("계좌생성");
				
				System.out.print("계좌번호: ");
				String number = sc.next();
				System.out.print("계좌주: ");
				String owner = sc.next();
				System.out.print("초기입금액: ");
				int balance = sc.nextInt();
				
				boolean result = bankApp.createAccount(number, owner, balance);
				if (result) {
					System.out.println("계좌가 생성되었습니다.");
				} else {
					System.out.println("계좌 생성에 실패했습니다.");
				}
			}
			case 2 -> {
				printMenu("계좌목록");
				
				Account[] accounts = bankApp.selectAll();
				
				for (int i = 0; i < bankApp.getCount(); i++) {
					Account now = accounts[i];
					System.out.printf("%s   %s   %d\n", now.getNumber(), now.getOwner(), now.getBalance());
				}
			}
			case 3 -> {
				printMenu("예금");
				
				System.out.print("계좌번호: ");
				String number = sc.next();
				System.out.print("예금액: ");
				int value = sc.nextInt();
				
				int result = bankApp.deposit(number, value);
				
				if (result == -1) {
					System.out.println("예금에 실패했습니다.");
				} else {
					System.out.println("예금이 성공되었습니다.");
				}
			}
			case 4 -> {
				printMenu("출금");
				
				System.out.print("계좌번호: ");
				String number = sc.next();
				System.out.print("출금액: ");
				int value = sc.nextInt();
				
				int result = bankApp.withdraw(number, value);
				
				if (result == -1) {
					System.out.println("출금에 실패했습니다.");
				} else {
					System.out.println("출금이 성공되었습니다.");
				}
			}
			case 5 -> run = false;
			default -> System.out.println("1~5 사이의 숫자를 입력해 주세요.");
			}
		}
		System.out.println("프로그램 종료");
		sc.close();
	}
	
	public static void printMenu(String menu) {
		System.out.println("------------");
		System.out.println(menu);
		System.out.println("------------");
	}
}
