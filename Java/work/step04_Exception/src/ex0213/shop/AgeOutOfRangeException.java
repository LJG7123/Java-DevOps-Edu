package ex0213.shop;

public class AgeOutOfRangeException extends Exception {
	public static int count = 0;

	public AgeOutOfRangeException() {
		this("애들은 가라");
	}
	
	public AgeOutOfRangeException(String message) {
		super(message);
		count++;
	}
	
}
