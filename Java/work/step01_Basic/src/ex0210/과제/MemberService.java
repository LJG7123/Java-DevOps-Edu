package ex0210.과제;
/**
 * 주제: 다음 메소드를 가지는 MemberService 클래스를 선언 (Exer15)
 * 		 boolean login(String id, String password)
 * 		 void logout(String id)
 * 작성일: 260210
 * 작성자: 이정건
 * */
public class MemberService {
	public boolean login(String id, String password) {
		return (id.equals("hong") && password.equals("12345"));
	}
	
	public void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다");
	}
}