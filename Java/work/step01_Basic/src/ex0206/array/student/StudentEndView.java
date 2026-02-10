package ex0206.array.student;
/**
 * 사용자 요청의 결과를 모니터에 출력하는 클래스
 * */
public class StudentEndView {
	/**
	 * 전체 검색 결과 출력
	 */
	public static void printSelectAll(Student[] students) {
		System.out.println("****학생 정보 (" + StudentService.count + "명)****");
		for (int i = 0 ; i < StudentService.count; i++) {
			System.out.printf("이름: %s, 나이: %d세, 주소: %s\n", students[i].getName(), students[i].getAge(), students[i].getAddr());
		}
	}
	
	/**
	 * 이름에 해당하는 학생정보 출력
	 */
	public static void printSelectByName(Student s) {
		if (s == null) {
			System.out.println("찾는 정보가 없습니다.");
			return;
		}
		System.out.printf("이름: %s, 나이: %d세, 주소: %s\n", s.getName(), s.getAge(), s.getAddr());
	}
	
	/**
	 * 요청결과의 성공여부 메시지 출력
	 */
	public static void printMessage(String message) {
		System.out.println(message);
	}
}
