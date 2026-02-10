package ex0205.array;

class ArrayValue {
	// 정수형 10개 저장하는 배열선언(선언과 동시에 임의값 지정)
	int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

	/*
	 * printArrayvalue 메소드작성 => 메소드 안에서 위에 선언된 배열방의 값을 출력한다.
	 * 
	 */
	public void printArrayValue() {
		int n = arr.length;
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
		System.out.println();
		System.out.println("---향상된 for문---");
		for (int a : arr) {
			System.out.println(a);
		}
	}
}

/////////////////////////////////////////////////
class ArrayValueExam {
	public static void main(String args[]) {
		// ArrayValue에 있는 printArrayvalue메소드 호출
		ArrayValue a = new ArrayValue();
		a.printArrayValue();
//		new ArrayValue().printArrayValue();
	}
}