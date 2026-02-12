package ex0212.board;

/**
 * 자유게시판 속성 관리 객체
 */
public class FreeBoard extends Board {
	
	public FreeBoard() {}
	
	public FreeBoard(int no, String subject, String writer, String content) {
		super(no, subject, writer, content);
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("]");
		return builder.toString();
	}
	
}
