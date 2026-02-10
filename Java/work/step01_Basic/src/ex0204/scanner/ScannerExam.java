package ex0204.scanner;

import java.util.Scanner;

public class ScannerExam {

	public static void main(String[] args) {
		// 키보드 입력
		Scanner sc = new Scanner(System.in);
		
		// 키보드 입력은 숫자, 문자열, 공백 있는 문자열
		int num = sc.nextInt();
		String word = sc.next();
		String str = sc.nextLine();
		
		System.out.println(String.format("%d %s %s", num, word, str.trim()));
		
		sc.close();
	}

}
