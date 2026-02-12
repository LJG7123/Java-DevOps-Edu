package ex0212.board;
/**
 * 모든 게시판이 공통으로 갖는 속성을 관리하는 객체
 * 글번호, 제목, 작성자, 내용
 */
public class Board {
	private int no;
	private String subject;
	private String writer;
	private String content;
	
	public Board() {}
	public Board(int no, String subject, String writer, String content) {
		this.no = no;
		this.subject = subject;
		this.writer = writer;
		this.content = content;
	}

	int getNo() {
		return no;
	}

	void setNo(int no) {
		this.no = no;
	}

	String getSubject() {
		return subject;
	}

	void setSubject(String subject) {
		this.subject = subject;
	}

	String getWriter() {
		return writer;
	}

	void setWriter(String writer) {
		this.writer = writer;
	}

	String getContent() {
		return content;
	}

	void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Board [no=");
		builder.append(no);
		builder.append(", subject=");
		builder.append(subject);
		builder.append(", writer=");
		builder.append(writer);
		builder.append(", content=");
		builder.append(content);
		builder.append(", ");
		return builder.toString();
	}
	
}
