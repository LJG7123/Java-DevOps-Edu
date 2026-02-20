package ex0220.set;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
	Set<Member> set = new HashSet<Member>();
	
	public MemberSetExam() {
		set.add(new Member("희정", 10, "서울"));
		set.add(new Member("희정1", 20, "대구"));
		
		set.add(new Member("희정", 20, "서울"));
		
		System.out.println("저장된 개수 = " + set.size());
	}

	public static void main(String[] args) {
		new MemberSetExam();
	}

}
