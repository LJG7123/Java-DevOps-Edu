package ex0219.exam05;

/**
 * 신청
 */
public class Applicant<T> {
	private T kind;
	
	public Applicant(T kind) {
		this.kind = kind;
	}
	
	public T getKind() {
		return kind;
	}
	
	public void setKind(T kind) {
		this.kind = kind;
	}
}
