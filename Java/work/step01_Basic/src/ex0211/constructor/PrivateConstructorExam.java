package ex0211.constructor;

class Test {
	private static Test t;
	public static Test instance = getInstance();
	
	private Test() {}
	
	private static Test getInstance() {
		if (t == null) t = new Test();
		return t;
	}
}

public class PrivateConstructorExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(Test.instance);
	}
	
}
