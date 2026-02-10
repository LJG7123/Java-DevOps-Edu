package ex0205.array;

class MultiArray {
//정수형 2차원 배열 8*9
	int[][] arr = new int[8][9];

//메소드이름 :array99

	// for loop 를 사용하여
	// 배열에 곱한 (구구단)결과저장
	// 배열에 결과를 꺼내출력
	public void array99() {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int m = arr[i].length;

			for (int j = 0; j < m; j++) {
				arr[i][j] = (i + 2) * (j + 1);
				System.out.printf("%2d ", arr[i][j]);
			}
			System.out.println();
		}

		for (int[] line : arr) {
			for (int num : line) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}

public class MemoryApart {
//main메소드에서
//MultiArray객체의 array99메소드호출
	public static void main(String[] args) {
		MultiArray m = new MultiArray();
		m.array99();
	}
}
