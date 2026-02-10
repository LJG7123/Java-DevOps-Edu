package ex0205.과제;
/**
 * 주제: 주어진 배열의 최대값을 출력
 * 작성일: 260205
 * 작성자: 이정건
 *  
 * */
public class Exercise07 {

	public static void main(String[] args) {
		int[] array = { 1, 5, 3, 8, 2 };

		int max = array[0];
		for (int n : array) {
			if (n > max)
				max = n;
		}

		System.out.println("최댓값: " + max);
	}

}
