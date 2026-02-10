package ex0205.overloading;

class Test {
	public void aa(int... i) {
		System.out.print("i: ");
		for (int a : i)
			System.out.print(a + " ");
		System.out.println();
	}

	public void bb(int i, String... name) {
		System.out.print(i + ": ");
		for (String s : name)
			System.out.println(s + " ");
		System.out.println();
	}

}

public class MethodVariableArgsExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Test t = new Test();
		t.aa(0);
		t.aa(1, 2, 3, 4);
		t.aa();

		t.bb(0, "asd");

		System.out.printf("%d %s", 1, "name");
	}

}
