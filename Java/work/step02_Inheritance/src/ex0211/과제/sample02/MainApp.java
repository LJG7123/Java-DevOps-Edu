package ex0211.과제.sample02;

/**
 * 부모 클래스에 공통된 속성을 정의했기 때문에, 자식 클래스에서 추가되는 부분만 추가로 구현하면 되서 편하고,
 * 배열도 부모 클래스 타입으로 선언해서 한번에 관리할 수 있기 때문에 코드의 양이 적어집니다.
 * 추가로 message()라는 이름이 같은 메소드도 부모 클래스에 있기 때문에 따로 호출할 필요가 없습니다.
 */
public class MainApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Employee[] emp = new Employee[5];
		
		emp[0] = new FullTime(10, "유재석", "개그우먼", 0 , "2013-05-01", "무한도전",8500,200);
		emp[1] = new FullTime(20, "박명수", "가수",10, "2013-06-20", "무한도전",7500,100);
		emp[2] = new FullTime(30, "정준하", "예능인",10 , "2013-06-22", "무한도전",6000,0);
		emp[3] = new PartTime(40, "노홍철", "예능인",20 , "2014-05-01", "무한도전",20000);
		emp[4] = new PartTime(50, "하하", "가수",30 , "2014-05-02", "무한도전",25000);
		
		//출력화면을 보고 코딩...

		System.out.println("**********Emp 정보**********");
		for (Employee e : emp) {
			System.out.println(e);
		}
		
		System.out.println("**********Emp Message**********");
		for (Employee e : emp) {
			e.message();
		}
	}

}

class Employee {
	int empNo;
	String eName;
	String job;
	int mgr;
	String hiredate;
	String deptName;
	
	Employee() {}

	public Employee(int empNo, String eName, String job, int mgr, String hiredate, String deptName) {
		this.empNo = empNo;
		this.eName = eName;
		this.job = job;
		this.mgr = mgr;
		this.hiredate = hiredate;
		this.deptName = deptName;
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
	
	void message() {
		
	}
	
	@Override
	public String toString() {
		return String.format("%d | %s | %s | %d | %s | %s", empNo, eName, job, mgr, hiredate, deptName);
	}
}

class FullTime extends Employee {
	int salary;
	int bonus;
	
	FullTime() {}
	
	FullTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.salary = salary;
		this.bonus = bonus;
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
	
	@Override
	public String toString() {
		return super.toString() + String.format(" | %d | %d",salary, bonus);
	}
	
	@Override
	void message() {
		System.out.println(eName + "사원은 정규직입니다.");
	}
}

class PartTime extends Employee {
	int timePay;
	
	PartTime() {}
	
	PartTime(int empNo, String eName, String job, int mgr, String hiredate, String deptName, int timePay) {
		super(empNo, eName, job, mgr, hiredate, deptName);
		this.timePay = timePay;
	}

	int getTimePay() {
		return timePay;
	}

	void setTimePay(int timePay) {
		this.timePay = timePay;
	}
	
	@Override
	public String toString() {
		return super.toString() + String.format(" | %d", timePay);
	}
	
	@Override
	void message() {
		System.out.println(eName + "사원은 비정규직입니다.");
	}
}