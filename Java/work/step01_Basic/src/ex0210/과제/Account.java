package ex0210.과제;
/**
 * 주제: 외부에서 balance 필드를 마음대로 변경하지 못하고, 일정 범위 내의 값만 가질 수 있도록 Account 클래스를 작성 
 *       (Exer19~20)
 * 작성일: 260210
 * 작성자: 이정건
 * */
public class Account {
	private String number;
	private String owner;
	private int balance;
	
	public static int MIN_BALANCE = 0;
	public static int MAX_BALANCE = 1_000_000;
	
	public Account() {}
	
	public Account(String number, String owner, int balance) {
		this.number = number;
		this.owner = owner;
		this.balance = balance;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public void setBalance(int value) {
		if (value < MIN_BALANCE || value > MAX_BALANCE) return;
		this.balance = value;
	}
	
	public int getBalance() {
		return this.balance;
	}
}
