package ex0220.lotto;

import java.util.Collections;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Lotto {
	
	public static void main(String[] args) {
		Set<Integer> lotto = new TreeSet<>(Collections.reverseOrder());
		Random r = new Random();
		
		while (lotto.size() < 6) {
			int num = r.nextInt(1, 46);
			lotto.add(num);
		}
		
		System.out.println(lotto);
	}
}
