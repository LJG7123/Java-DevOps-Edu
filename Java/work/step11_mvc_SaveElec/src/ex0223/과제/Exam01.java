package ex0223.과제;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Exam01 {
	String path = System.getProperty("user.dir") + "/";
	
	public static void main(String[] args) {
		Exam01 ex = new Exam01();
		
		Scanner sc = new Scanner(System.in);
		int menu;

		while (true) {
			System.out.println("1. 프로필 저장   2. 프로필 불러오기   3. 종료");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				ex.saveProfile(sc);
				break;
			case 2:
				ex.loadProfile(sc);
				break;
			case 3:
				sc.close();
				System.exit(0);
			default:
				System.out.println("1~3 사이의 숫자를 입력해 주세요.");
				break;

			}
		}

	}

	void saveProfile(Scanner sc) {
		System.out.print("이름> ");
		String name = sc.next();
		
		System.out.print("몸무게> ");
		String weight = sc.next();
		
		System.out.print("비밀번호> ");
		String pw = sc.next();
		
		File file = new File(path + name);
		if (file.exists()) {
			System.out.println("이미 존재하므로 다시 입력하세요.");
			return;
		}
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
			bw.append(weight);
			bw.append(":");
			bw.append(pw);
			
			System.out.println("저장이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void loadProfile(Scanner sc) {
		System.out.print("이름> ");
		String name = sc.next();
		
		File file = new File(path + name);
		if (!file.exists()) {
			System.out.println(name + "에 해당하는 정보는 없습니다.");
			return;
		}
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = br.readLine();
			String[] split = str.split(":");
			System.out.println(name + "님 몸무게는 " + split[0] + "이고 비번은 " + split[1] + " 입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
