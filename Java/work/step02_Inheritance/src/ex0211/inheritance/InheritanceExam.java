package ex0211.inheritance;

class Car {
	public String carname;
	public int cost;

	protected void printAttributes() {
		System.out.println("carname=" + carname + "\tcost=" + cost);
	}
}

//Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성	
// 각 클래스에 인수를 받지않는 생성자 작성
// 각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
class EfSonata extends Car {
	int i = 100;
	EfSonata() {
		carname = "소나타";
		cost = 100000;
	}
}

class Excel extends Car {
	Excel() {
		carname = "엑셀";
		cost = 200000;
	}
}

class Carnival extends Car {
	Carnival() {
		carname = "카니발";
		cost = 300000;
	}
}

public class InheritanceExam {
	// 메인메소드에서
	// Car, EfSonata, Excel, Carnival 네개의 객체를 생성
	// 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.
	public static void main(String[] args) {
		Car c1 = new Car();
		EfSonata c2 = new EfSonata();
		Excel c3 = new Excel();
		Carnival c4 = new Carnival();
		
		c1.printAttributes();
		c2.printAttributes();
		c3.printAttributes();
		c4.printAttributes();
	}
	
}
