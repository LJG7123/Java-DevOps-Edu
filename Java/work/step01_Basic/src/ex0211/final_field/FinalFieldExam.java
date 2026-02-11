package ex0211.final_field;

public class FinalFieldExam {
	int i; // 인스턴스 필드
	// final 필드는 명시적 초기화 필수 (자동 초기화 안됨)
	// 사용자가 객체를 생성할 때 초기화 가능
	final int j; // 인스턴스 필드
	static final int k; // static 필드, 생성자 초기화 불가
	
	static {
		k = 30;
	}
	
	public FinalFieldExam() {
		j = 10;
	}
	
	public FinalFieldExam(int j) {
		this.j = j;
	}
	
	public static void main(String[] args) {
		System.out.println(FinalFieldExam.k);
		FinalFieldExam ff = new FinalFieldExam(50);
		
		System.out.println(ff.i);
		System.out.println(ff.j);
		
		// final은 고정값으로, 한번 초기화 된 이후 값 변경 불가
		ff.i = 20;
//		ff.j = 100;
//		ff.k = 200;
	}

}
