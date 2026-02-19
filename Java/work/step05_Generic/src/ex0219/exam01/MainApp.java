package ex0219.exam01;

public class MainApp {

	public static void main(String[] args) {
		// 제네릭을 사용하지 않은 경우
//		Box box = new Box();
//		box.setContent("상품1");
//		
//		if (box.getContent() instanceof String str) {
//			System.out.println(str);
//		}
//		
//		box.setContent(new Board());
//		Board board = (Board) box.getContent();
		
		// Box에 제네릭을 사용한 경우
		Box<String> box = new Box<>();
		box.setContent("상품1");
		
		String str = box.getContent();
		
		Box<Board> box2 = new Box<>();
		box2.setContent(new Board());
		
		Board b = box2.getContent();
	}

}
