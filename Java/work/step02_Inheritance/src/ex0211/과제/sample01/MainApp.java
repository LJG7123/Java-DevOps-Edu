package ex0211.과제.sample01;

/**
 * FullTime과 PartTime에 공통된 속성이 있음에도 클래스마다 따로 정의해야 해서 보일러 플레이트 코드가 너무 많고,
 * 인스턴스도 따로 관리해야해서 코드의 양이 많아집니다.
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		FullTime [] full = new FullTime[3];
		PartTime [] part = new PartTime[2];
		
		full[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		full[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		full[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		
		part[0] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		part[1] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		//출력화면을 보고 코딩...

		System.out.println("**********FullTime 정보**********");
		for (FullTime f : full) {
			System.out.println(f);
		}
		System.out.println();
		
		System.out.println("**********PartTime 정보**********");
		for (PartTime p : part) {
			System.out.println(p);
		}
		System.out.println();
		
		System.out.println("********** Message **********");
		for (FullTime f : full) {
			f.message();
		}
		for (PartTime p : part) {
			p.message();
		}
		
	}

}

class FullTime {
	int empNo;
	String eName;
	String job;
	int mgr;
	String hiredate;
	String deptName;
	int salary;
	int bonus;
	
	FullTime() {}

	public FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary,
			int bonus) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.salary = salary;
		this.bonus = bonus;
	}

	int getEmpNo() {
		return empNo;
	}

	void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	String geteName() {
		return eName;
	}

	void seteName(String eName) {
		this.eName = eName;
	}

	String getJob() {
		return job;
	}

	void setJob(String job) {
		this.job = job;
	}

	int getMgr() {
		return mgr;
	}

	void setMgr(int mgr) {
		this.mgr = mgr;
	}

	String getHiredate() {
		return hiredate;
	}

	void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	String getDeptName() {
		return deptName;
	}

	void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	int getSalary() {
		return salary;
	}

	void setSalary(int salary) {
		this.salary = salary;
	}

	int getBonus() {
		return bonus;
	}

	void setBonus(int bonus) {
		this.bonus = bonus;
	}
	
	void message() {
		System.out.println(eName + "사원은 정규직입니다.");
	}
	
	@Override
	public String toString() {
		return String.format("%d | %s | %s | %d | %s | %s | %d | %d", 
				empNo, eName, job, mgr, hiredate, deptName, salary, bonus);
	}
}

class PartTime {
	int empNo;
	String eName;
	String job;
	int mgr;
	String hiredate;
	String deptName;
	int timePay;
	
	PartTime() {}

	public PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
		this.timePay = timePay;
	}

	int getEmpNo() {
		return empNo;
	}

	void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	String geteName() {
		return eName;
	}

	void seteName(String eName) {
		this.eName = eName;
	}

	String getJob() {
		return job;
	}

	void setJob(String job) {
		this.job = job;
	}

	int getMgr() {
		return mgr;
	}

	void setMgr(int mgr) {
		this.mgr = mgr;
	}

	String getHiredate() {
		return hiredate;
	}

	void setHiredate(String hiredate) {
		this.hiredate = hiredate;
	}

	String getDeptName() {
		return deptName;
	}

	void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	int getTimePay() {
		return timePay;
	}

	void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	void message() {
		System.out.println(eName + "사원은 비정규직입니다.");
	}
	
	@Override
	public String toString() {
		return String.format("%d | %s | %s | %d | %d", empNo, eName, job, mgr, timePay);
	}
}