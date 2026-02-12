package ex0212.board;

/**
 * QA게시판 속성 관리 객체
 */
public class QaBoard extends Board {
	private boolean replyState;
	
	public QaBoard() {}

	public QaBoard(int no, String subject, String writer, String content, boolean replyState) {
		super(no, subject, writer, content);
		this.replyState = replyState;
	}

	boolean isReplyState() {
		return replyState;
	}

	void setReplyState(boolean replyState) {
		this.replyState = replyState;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append("replyState=");
		builder.append(replyState);
		builder.append("]");
		return builder.toString();
	}
	
}
