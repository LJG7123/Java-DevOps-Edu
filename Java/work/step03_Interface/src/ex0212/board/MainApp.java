package ex0212.board;

public class MainApp {
	BoardService service;
	Board board;
	
	public MainApp() {
		service = new FreeBoardServiceImpl();
		board = new FreeBoard(10, "제목", "작성자", "내용");
		test();
		
		service = new QaBoardServiceImpl();
		board = new QaBoard(20, "QA", "QA작성자", "QA내용", false);
		test();
		
		service = new UploadBoardServiceImpl();
		board = new UploadBoard(30, "Upload", "Upload작성자", "Upload내용", "file이름");
		test();
	}
	
	public void test() {
		service.insert(board);
		service.update(board);
		service.selectByNo(10);
		
		service.delete(5);
		
		BoardService.selectAll();
		
		System.out.println("==========================");
	}

	public static void main(String[] args) {
		new MainApp();
	}

}
