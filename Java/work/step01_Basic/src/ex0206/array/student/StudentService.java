package ex0206.array.student;

/**
 * 학생의 정보를 관리 하는 서비스(등록, 수정, 검색,....)
 * */
public class StudentService {
	
	// 학생의 정보를 저장할 배열 선언
	Student stArr[] = new Student[10];	// 최대 10명
	public static int count;	// 배열에 저장된 객체의 개수를 체크하는 필드
	
	/**
	 * 초기치데이터 3명 정도 세팅하기 
	 * */
	public void init(String[][] data) {
		/*
		int n = data.length;
		
		for (int i = 0 ; i < n; i++) {
			stArr[i] = create(data[i]);
			count++;
		}
		*/
		
		for (String[] row : data) {
			stArr[count++] = create(row);
		}
		System.out.println("***초기화 완료***");
	}
	
	/**
	 *  Student객체를 생성해서 리턴해주는 메소드 작성
	 * */
	private Student create(String[] data) {
		Student s = new Student();
		s.setName(data[0]);
		s.setAge(Integer.parseInt(data[1]));
		s.setAddr(data[2]);
		
		return s;
	}
	
	

	 /**
	   학생의 정보 등록하기 
	    : 배열의 경계를 벗어나면 더이상 추가할수 없습니다. 메시지출력.
	      이름이 중복되면 등록 안됨.
	      추가가 성공하면 "등록되었습니다" 메시지를 출력
	      
	      @return: 1이면 성공, 0이면 중복, -1이면 배열의 경계를 벗어남
	  **/
	public int insert(Student s) {
		if (count >= stArr.length) return -1;
		
		Student st = selectByName(s.getName());
		if (st != null) return 0;
		
		stArr[count++] = s;
		return 1;
	}
	 
	 
	
	/**
	 * 전체 학생의 정보 조회하기
	 * */
	public Student[] selectAll() {
		return stArr;
	}
	 
	
	/**
	 * 이름에 해당하는 학생의 정보 검색하기
	 *  : 이름에 해당하는 학생이 있으면 학생의 이름, 나이, 주소를출력하고
	 *     없으면 "찾는정보가 없습니다." 출력한다.
	 * */
	public Student selectByName(String name) {
		for (int i = 0; i < count; i++) {
			Student s = stArr[i];
			
			if (s.getName().equals(name)) return s;
		}
		
		return null;
	}
	
	
	/**
	 * 이름에 해당하는 학생의 나이와 주소 변경하기 
	 *  : 이름에 해당하는 학생이 있는지 찾아서 없으면 "수정할수 없습니다." 출력
	 *   있으면  setAge() , setAddr() 이용해서 전달된 인수의 값으로 변경하고
	 *   "수정되었습니다" 출력
	 *   @param : Student
	 *   @return : boolean
	 * */
	public boolean update(Student newSt) {
		Student s = selectByName(newSt.getName());
		
		if (s == null) {
			return false;
		}
		
		s.setAge(newSt.getAge());
		s.setAddr(newSt.getAddr());
		return true;
	}
	 

}

