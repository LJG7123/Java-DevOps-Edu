package ex0219.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class ListExam01 extends ArrayList<Integer> {
	
	public ListExam01() {
		super(5);
		
		// 추가
		super.add(10);
		this.add(5);
		add(20);
		super.add(10);
		super.add(7);
		super.add(5);
		
		// list에 저장된 객체의 개수 출력
		System.out.println("저장된 개수 = " + super.size());
		
		// 저장된 정보 출력
//		for (int i = 0; i < size(); i++) {
//			int no = super.get(i);
//			System.out.println("no = " + no);
//		}
		
		for (int no : this) {
			System.out.println("no = " + no);
		}
		
		// 제거
//		int i = this.remove(2);
//		System.out.println("제거됨 = " + i);
		
//		boolean b = this.remove((Integer) 20);
//		System.out.println(b);

//		System.out.println("-----------제거 후 개선된 for-----------");
//		for (int no : this) {
//			System.out.println("no = " + no);
//		}
		
		System.out.println("--------------정렬하기----------------");
		System.out.println("정렬 전 : " + this);
		
		// 오름차순 정렬
//		Collections.sort(this);
		
		// 내림차순 정렬
		Collections.sort(this, Collections.reverseOrder());
		
		System.out.println("정렬 후 : " + this);
	}
	
	public static void main(String[] args) {
		new ListExam01();
	}
}
