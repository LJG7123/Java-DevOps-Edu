package ex0219.lambda;

public class MainApp {

	public static void main(String[] args) {
		// 1. 기존 방식
//		AInterface test = new Test();
//		test.aa();
		
		// 2. AnonymousInnerType으로 작성(익명타입 선언)
//		AInterface ai = new AInterface() {
//			@Override
//			public void aa() {
//				System.out.println("AnonymousInner aa 호출됨");
//			}
//		};
//		
//		ai.aa();
		
		// 3. 람다식
//		AInterface ai = () -> {
//			System.out.println("인수와 리턴 없는 람다식");
//		};
//		
//		ai.aa();
		
		AInterface ai = () -> System.out.println("인수와 리턴 없는 람다식");
		ai.aa();
		
		BInterface bi = (i) -> System.out.println("전달된 값 = " + i);
		bi.bb(10);
		
		CInterface ci = (a, b) -> {
			return a * b;
		};
		int re = ci.cc(5, 3);
		System.out.println("re = " + re);
	}

}

class Test implements AInterface {

	@Override
	public void aa() {
		System.out.println("Test의 aa 구현메소드");
	}
	
}