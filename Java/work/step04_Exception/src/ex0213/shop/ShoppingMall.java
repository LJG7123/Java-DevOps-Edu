package ex0213.shop;

public class ShoppingMall {

	public void inputUserAge(int age) throws AgeOutOfRangeException {
		if (age < 18) throw new AgeOutOfRangeException();
		
		System.out.println("입장하신걸 환영합니다.");
	}
}
