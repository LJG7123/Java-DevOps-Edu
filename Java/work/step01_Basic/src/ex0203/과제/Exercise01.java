package ex0203.과제;

public class Exercise01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String name = "정건";
		int koreanScore = generateScore();
		int englishScore = generateScore();
		int mathScore = generateScore();
		int totalScore = koreanScore + englishScore + mathScore;
		double averageScore = totalScore / 3.0;
		char gradeIf;
		
		// if문
		if (averageScore >= 90) gradeIf = 'A';
		else if (averageScore >= 80) gradeIf = 'B';
		else if (averageScore >= 70) gradeIf = 'C';
		else if (averageScore >= 60) gradeIf = 'D';
		else gradeIf = 'F';
		
		// switch문
		char gradeSwitch = switch ((int)averageScore / 10) {
			case 10, 9 -> 'A';
			case 8 -> 'B';
			case 7 -> 'C';
			case 6 -> 'D';
			default -> 'F';
		};
		
		System.out.println(name + "님 성적표");
		System.out.println("국어: " + koreanScore);
		System.out.println("영어: " + englishScore);
		System.out.println("수학: " + mathScore);
		System.out.println("총점: " + totalScore);
		System.out.println("평균: " + (int) (averageScore * 100) / 100.0);
		System.out.println("등급: " + gradeIf);
		System.out.println("등급: " + gradeSwitch);
	}
	
	public static int generateScore() {
		return (int) (Math.random() * 56) + 45;
	}
	
}
