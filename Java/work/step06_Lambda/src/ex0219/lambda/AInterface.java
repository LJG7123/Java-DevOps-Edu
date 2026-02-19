package ex0219.lambda;

//메소드가 단 한개
@FunctionalInterface
public interface AInterface {
	void aa();
	default void bb() {}
}
