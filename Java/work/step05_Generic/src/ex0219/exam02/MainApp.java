package ex0219.exam02;

public class MainApp {

	public static void main(String[] args) {
		Product<Tv, String> p1 = new Product<>();
		p1.setKind(new Tv());
		p1.setModel("삼성tv");
		
		Tv t = p1.getKind();
		////////////////////////////////////////////////////
		//제네릭타입은 원시타입은 안된다
		Product<Video, Integer> p2 = new Product<>();
		p2.setKind(new Video());
		p2.setModel(1000);
		
		Video v = p2.getKind();
		int i = p2.getModel();
	}

}
