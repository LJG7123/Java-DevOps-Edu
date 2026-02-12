package ex0212.superkeyword;

class Parent {
	/*Parent() {
		System.out.println(1);
	}*/
	Parent(int i) {
		System.out.println(2);
	}
	Parent(String s) {
		System.out.println(3);
	}
}

class Child extends Parent {
	Child() {
		this(100);
		System.out.println(4);
	}
	Child(int i) {
		super(i);
		System.out.println(5);
	}
	Child(boolean b) {
		super("안녕");
		System.out.println(6);
	}
}

public class SuperConstructorExam {

	public static void main(String[] args) {
//		new Child();
//		new Child(1);
//		new Child(true);
//		모든 자식 생성자 구현부 첫번째 줄에 super()가 생략되어있다.
		
//		만약, 부모 생성자가 하나도 없다면
//		new Child(); // 4
//		new Child(10); // 5
//		생성자를 하나도 작성하지 않으면 기본 생성자가 자동으로 삽입됨
		
//		만약, 부모의 기본 생성자가 없고, 다른 생성자를 추가했다면
		new Child(); // 2 5 4
	}

}
