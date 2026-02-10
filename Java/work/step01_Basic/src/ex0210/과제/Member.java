package ex0210.과제;
/**
 * 주제: 다음 필드를 가지는 Member 클래스를 선언 (Exer13~14)
 * 		 name (String)
 * 		 id (String)
 * 		 password (String)
 * 		 age (int)
 * 작성일: 260210
 * 작성자: 이정건
 * */
public class Member {
	
	private String name;
	private String id;
	private String password;
	private int age;
	
	public Member(String name, String id) {
		this.name = name;
		this.id = id;
	}
	
	public String getName() { 
		return this.name; 
	}
	
	public String getId() { 
		return this.id; 
	}
}
