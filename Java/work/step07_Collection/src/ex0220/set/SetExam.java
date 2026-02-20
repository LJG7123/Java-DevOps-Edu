package ex0220.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SetExam {
	Set<String> set = new HashSet<>();
//	Set<String> set = new TreeSet<String>(Collections.reverseOrder());
	
	public SetExam(String[] args) {
		set.addAll(List.of(args));
		System.out.println(set);
		
		Iterator<String> iter = set.iterator();
		while (iter.hasNext()) {
			String s = iter.next();
			System.out.println(s);
		}
		
		System.out.println("\n---요소 제거---");
		set.remove("3");
		System.out.println(set);
		
		System.out.println("\n---존재 여부---");
		boolean re = set.contains("1");
		System.out.println(re);
	}
	
	public static void main(String[] args) {
		new SetExam(args);
	}
}
