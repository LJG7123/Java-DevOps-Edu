package ex0213.shop;

import java.util.Random;

public class MainApp {

	public static void main(String[] args) {
		ShoppingMall sm = new ShoppingMall();
		
		Random r = new Random();
		for (int i = 0; i < 10; i++) {
//			int age = (int) (Math.random() * 55) + 1;
			int age = r.nextInt(55) + 1;
			
			try {
				System.out.print(age + " - ");
				sm.inputUserAge(age);
			} catch (AgeOutOfRangeException e) {
				System.out.println(e.getMessage());
			}
		}
		
		System.out.println("발생한 예외 - " + AgeOutOfRangeException.count);
	}

}
