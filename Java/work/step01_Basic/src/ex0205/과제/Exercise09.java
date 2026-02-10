package ex0205.과제;

import java.util.Scanner;
/**
 * 주제: 학생 수와 각 학생의 점수를 입력받아 최고 점수와 평균 점수를 출력하는 프로그램을 작성
 * 작성일: 260205
 * 작성자: 이정건
 *  
 * */
public class Exercise09 {

	public static void main(String[] args) {
		ScoreAnalyzeService service = new ScoreAnalyzeService();
		Scanner sc = new Scanner(System.in);

		boolean run = true;

		while (run) {
			System.out.println("------------------------------------------------------");
			System.out.println("1.학생수 | 2.점수입력 | 3.점수리스트 | 4.분석 | 5.종료");
			System.out.println("------------------------------------------------------");
			System.out.print("선택> ");

			int menu = sc.nextInt();

			switch (menu) {
			case 1 -> {
				System.out.print("학생수> ");
				int count = sc.nextInt();
				service.setCount(count);
			}
			case 2 -> {
				if (!service.isCountInitialized()) {
					System.out.println("학생수를 먼저 입력해주세요.");
					break;
				}
				
				int len = service.scores.length;
			
				for (int i = 0; i < len; i++) {
					System.out.print("scores[" + i + "]> ");
					int score = sc.nextInt();
					service.setScore(i, score);
				}
			}
			case 3 -> {
				if (!service.isCountInitialized()) {
					System.out.println("학생수를 먼저 입력해주세요.");
					break;
				}
				
				int len = service.scores.length;

				for (int i = 0; i < len; i++) {
					System.out.println("scores[" + i + "]: " + service.scores[i]);
				}
			}
			case 4 -> {
				if (!service.isCountInitialized()) {
					System.out.println("학생수를 먼저 입력해주세요.");
					break;
				}
				
				System.out.println("최고 점수: " + service.getMaxScore());
				System.out.println("평균 점수: " + service.getAvgScore());
			}
			case 5 -> run = false;
			default -> System.out.println("1~5 사이의 숫자만 입력할 수 있습니다.");
			}
		}

		System.out.println("프로그램 종료");
		sc.close();
	}

}

class ScoreAnalyzeService {
	int[] scores;

	/**
	 * scores 를 n 길이의 배열로 초기화
	 * @param: 학생 수
	 * */
	public void setCount(int n) {
		scores = new int[n];
	}

	/**
	 * scores[index]값을 score 로 초기화 
	 * @param: 인덱스, 점수
	 * */
	public void setScore(int index, int score) {
		scores[index] = score;
	}

	/**
	 * scores 배열을 순회하며 최대값을 찾아 반환
	 * @return: 최고 점수
	 * */
	public int getMaxScore() {
		int max = 0;

		for (int score : scores) {
			if (score > max)
				max = score;
		}

		return max;
	}

	/**
	 * scores 배열에 저장된 값의 평균을 계산하여 반환
	 * @return: 평균 점수
	 * */
	public double getAvgScore() {
		int sum = 0;

		for (int score : scores) {
			sum += score;
		}

		return (double) sum / scores.length;
	}
	
	public boolean isCountInitialized() {
		return scores != null;
	}
}
