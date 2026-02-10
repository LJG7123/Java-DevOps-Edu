package ex0205.과제;
/**
 * 주제: 주어진 2차원 배열의 전체 합과 평균을 구해 출력
 * 작성일: 260205
 * 작성자: 이정건
 *  
 * */
public class Exercise08 {

	public static void main(String[] args) {
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };

		int sum = 0;
		int count = 0;
		for (int[] row : array) {
			for (int n : row) {
				sum += n;
				count++;
			}
		}

		System.out.println("총합: " + sum);
		System.out.println("평균: " + (double) sum / count);
	}

}
