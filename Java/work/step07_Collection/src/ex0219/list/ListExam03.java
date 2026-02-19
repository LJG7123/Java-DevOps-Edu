package ex0219.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListExam03 extends ArrayList<Emp> {
	
	// 초기 사원정보 5명 추가
	public ListExam03() {
		// 저장
		super.add(new Emp(20, "희정", 28, "서울"));
		super.add(new Emp(50, "나영", 35, "대구"));
		super.add(new Emp(10, "미미", 22, "제주"));
		super.add(new Emp(30, "삼식", 27, "서울"));
		super.add(new Emp(40, "삼순", 30, "대구"));
	}
	
	/**
	 * 저장된 모든 사원정보 리턴
	 */
	public List<Emp> selectAll() {
		return this;
	}
	
	/**
	 * 사원번호에 해당하는 사원정보 리턴
	 */
	public Emp selectByEmpNo(int empNo) {
		for (Emp e : this) {
			if (e.getEmpNo() == empNo) {
				return e;
			}
		}
		
		return null;
	}
	
	/**
	 * 주소를 인수로 전달받아 동일한 주소인 모든 사원정보 리턴
	 */
	public List<Emp> selectByAddr(String addr) {
		List<Emp> findList = new ArrayList<>();
		
		for (Emp e : this) {
			if (addr.equals(e.getAddr())) {
				findList.add(e);
			}
		}
		
		return findList;
	}
	
	/**
	 * 사원번호를 기준으로 정렬한 정보 리턴
	 */
	public List<Emp> sortWithEmpNo() {
		List<Emp> sorted = new ArrayList<>(this);
		
		Collections.sort(sorted);
//		Collections.sort(sorted, (a, b) -> a.getEmpNo() - b.getEmpNo());
		
		return sorted;
	}
	
	/**
	 * 나이를 기준으로 정렬한 정보를 리턴
	 */
	public List<Emp> sortWithAge() {
		List<Emp> sorted = new ArrayList<>(this);
		
//		Collections.sort(sorted, new Test());
//		Collections.sort(sorted, new Comparator<Emp>() {
//			@Override
//			public int compare(Emp o1, Emp o2) {
//				return o1.getAge() - o2.getAge();
//			}
//		});
		Collections.sort(sorted, (a, b) -> a.getAge() - b.getAge());
		
		return sorted;
	}
	
	public static void main(String[] args) {
		ListExam03 e = new ListExam03();
		
		System.out.println("1. 전체 검색");
		List<Emp> list = e.selectAll();
		for (Emp iter : list) {
			System.out.println(iter);
		}
		
		System.out.println("\n2. 사원번호 검색");
		Emp emp = e.selectByEmpNo(50);
		System.out.println(emp);
		
		System.out.println("\n3. 주소 검색");
		list = e.selectByAddr("제주");
		if (list.size() == 0) {
			System.out.println("주소에 해당하는 사원이 없습니다.");
		} else {
			System.out.println(list);
		}
		
		System.out.println("\n4. 사원번호를 기준으로 정렬");
		System.out.println(e.sortWithEmpNo());
		
		System.out.println("\n5. 나이를 기준으로 정렬");
		System.out.println(e.sortWithAge());
	}
}

class Test implements Comparator<Emp> {

	@Override
	public int compare(Emp o1, Emp o2) {
		return o1.getAge() - o2.getAge();
	}
	
}
