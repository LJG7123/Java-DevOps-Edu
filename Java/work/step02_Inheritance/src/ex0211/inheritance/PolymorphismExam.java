package ex0211.inheritance;

class CarCenter {
	public void engineer(Car cd) {
		System.out.print(cd.carname + " 수리완료!\t");
		System.out.println("청구비용" + cd.cost + " 원");
		
		switch (cd) {
		case EfSonata ef -> {
			System.out.println(ef.getClass());
		}
		case Carnival ca -> {}
		case Excel ex -> {}
		default -> {}
		}
	}
}

public class PolymorphismExam {
	public static void main(String[] args) {

		CarCenter cc = new CarCenter();

		EfSonata ef = new EfSonata();
		Carnival ca = new Carnival();
		Excel ex = new Excel();
		Car c = new Car();

		cc.engineer(c);//
		cc.engineer(ef);//
		cc.engineer(ca);//
		cc.engineer(ex);//
	}
}
