package ex0205.staticex;

class Test {
	int a;			// 전역변수 - 0
	static int b;	// static 전역변수 - 0
	
	public void aa() {
		System.out.println(a);
		System.out.println(this.a);
		
		System.out.println(b);
		System.out.println(this.b);
		System.out.println(Test.b);
	}
	
	public void bb() {
		aa();
		
		cc();
	}
	
	// static 메소드에서는 static 만 접근, this 사용불가
	public static void cc() {
		System.out.println(b);
	}
	
	public static void dd() {
		cc();
	}
	
}

public class StaticVariableExam {
	static {
		System.out.println("static 블럭");
	}

	public static void main(String[] args) {
		System.out.println("----메인 시작----");
		// 객체를 생성
		Test t1 = new Test();
		Test t2 = new Test();
		Test t3 = new Test();
		
		System.out.println("t1 = " + t1);
		System.out.println("t2 = " + t2);
		System.out.println("t3 = " + t3);
		
		System.out.println("----non-static 변수----");
		System.out.println("t1.a = " + t1.a);
		System.out.println("t2.a = " + t2.a);
		System.out.println("t3.a = " + t3.a);
		System.out.println("----a 값 변경----");
		t2.a = 1;
		t3.a = 10;
		System.out.println("t1.a = " + t1.a);
		System.out.println("t2.a = " + t2.a);
		System.out.println("t3.a = " + t3.a);
		
		System.out.println("----static 변수----");
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
		System.out.println("----b 값 변경----");
		t2.b = 5;
		t3.b = 50;
		Test.b = 100;
		System.out.println("t1.b = " + t1.b);
		System.out.println("t2.b = " + t2.b);
		System.out.println("t3.b = " + t3.b);
	}

}
