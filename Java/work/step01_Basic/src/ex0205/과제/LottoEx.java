package ex0205.과제;

/**
 * 주제: 중복되지 않는 6개의 로또 번호를 생성하여 내림차순으로 정렬하여 출력
 * 조건: 중복 체크하는 메소드
 * 		 숫자 6개를 배열방에 저장하는 메소드
 * 	 	 배열방의 값을 내림차순으로 정렬하는 메소드
 * 	  	 배열의 값을 화면에 출력하는 메소드
 * 작성일: 260205
 * 작성자: 이정건
 *  
 * */
public class LottoEx {

	public static void main(String[] args) {
		Lotto lotto = new Lotto();
		lotto.generateLotto();
		lotto.printLotto();
	}
}

class Lotto {
	int[] lotto = new int[6];
	int cnt;

	/**
	 * 생성한 숫자 6개를 배열방에 저장하고, 내림차순으로 정렬
	 * */
	public void generateLotto() {
		for (int i = 0; i < 6; i++) {
			int lottoNumber;
			do {
				lottoNumber = generateNumber();
			} while (isDuplicate(lottoNumber));
			lotto[i] = lottoNumber;
			cnt++;
		}
		sortByDesc();
	}

	public void printLotto() {
		for (int n : lotto) {
			System.out.print(n + " ");
		}
	}

	/**
	 * 1~45 사이의 난수 생성
	 * @return: 로또 번호 1개
	 * */
	private int generateNumber() {
		return (int) (Math.random() * 45) + 1;
	}

	/**
	 * num 이 현재 배열에 이미 존재하는 값인지 확인
	 * @param: 로또 번호
	 * @return: 중복 여부
	 * */
	private boolean isDuplicate(int num) {
		if (cnt == 0) return false;
		for (int i = 0 ; i < cnt; i++) {
			if (lotto[i] == num) return true;
		}

		return false;
	}

	/**
	 * lotto 배열을 내림차순으로 정렬
	 * */
	private void sortByDesc() {
		int n = lotto.length;

		for (int i = 1; i < n; i++) {
			int num = lotto[i];
			int j;

			for (j = i - 1; j >= 0; j--) {
				if (lotto[j] < num) {
					lotto[j + 1] = lotto[j];
				} else {
					break;
				}
			}
			lotto[j + 1] = num;
		}
	}

}
