package ex0210.과제;
/**
 * 주제: 크기가 100인 Account 배열을 관리하는 계좌관리 프로그램 작성 (Exer20)
 * 작성일: 260210
 * 작성자: 이정건
 * */
public class BankApplication {
	private Account[] accounts = new Account[100];
	private int count = 0;
	
	public int getCount() { 
		return this.count; 
	}
	
	public boolean createAccount(String number, String owner, int balance) {
		if (count >= 100) return false;
		if (findIndexWithNumber(number) > -1) return false;
		
		accounts[count++] = new Account(number, owner, balance);
		return true;
	}
	
	public Account[] selectAll() {
		return this.accounts;
	}
	
	public int findIndexWithNumber(String number) {
		for (int i = 0; i < count; i++) {
			if (accounts[i].getNumber().equals(number)) return i;
		}
		
		return -1;
	}
	
	public int deposit(String number, int value) {
		int index = findIndexWithNumber(number);
		if (index == -1) return -1;
		if (value <= 0) return -1;
		
		Account ac = accounts[index];
		ac.setBalance(ac.getBalance() + value);
		return ac.getBalance();
	}
	
	public int withdraw(String number, int value) {
		int index = findIndexWithNumber(number);
		if (index == -1) return -1;
		if (value <= 0 || value > accounts[index].getBalance()) return -1;
		
		Account ac = accounts[index];
		ac.setBalance(ac.getBalance() - value);
		return ac.getBalance();
	}
}
