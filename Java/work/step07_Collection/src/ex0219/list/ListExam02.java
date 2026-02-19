package ex0219.list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListExam02 {
	// 의존성 역전 원칙
//	List<Integer> list = new ArrayList<>(5);
	List<Integer> list = new LinkedList<>();
	
	public ListExam02() {
		// 추가
		list.add(10);
		list.add(5);
		list.add(20);
		list.add(10);
		list.add(7);
		list.add(5);
		
		// list에 저장된 객체의 개수 출력
		System.out.println("저장된 개수 = " + list.size());
		
		// 저장된 정보 출력
//		for (int i = 0; i < size(); i++) {
//			int no = super.get(i);
//			System.out.println("no = " + no);
//		}
		
		for (int no : list) {
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
		System.out.println("정렬 전 : " + list);
		
		// 오름차순 정렬
//		Collections.sort(this);
		
		// 내림차순 정렬
		Collections.sort(list, Collections.reverseOrder());
		
		System.out.println("정렬 후 : " + list);
	}
	
	public static void main(String[] args) {
		new ListExam02();
	}
}
