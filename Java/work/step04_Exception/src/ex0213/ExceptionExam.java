package ex0213;

public class ExceptionExam {
	
	public static void main(String[] args) {
		System.out.println("****메인 시작****");
		System.out.println("args = " + args);
		
		try {
			System.out.println("args[0] = " + args[0]);
			
			int convertNo = Integer.parseInt(args[0]);
			System.out.println("변환 값 = " + convertNo);
			
			int result = 100 / convertNo;
			System.out.println("나눈 결과 = " + result);
			
		//catch 블럭을 여러 개 작성할 때 반드시 서브클래스부터 작성한다.	
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e + " 예외 발생");
		} catch (NumberFormatException e) {
			System.out.println("숫자만 입력해 주세요 ->" + e.getMessage());
		} catch (Exception e) {
			System.out.println("예상치 못한 예외가 발생했습니다.");
			
			//개발자가 개발할 때 예외에 대한 정보를 추적할 때 사용한다
			//반드시 배포환경에서는 제거해야한다.
			e.printStackTrace();
		} finally {
			System.out.println("finally 영역은 예외 상관없이 항상 실행돼요.");
		}
		
		System.out.println("****메인 종료****");
	}
}
