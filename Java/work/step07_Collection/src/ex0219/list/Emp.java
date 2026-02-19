package ex0219.list;

/**
 * 사원정보
 */
public class Emp implements Comparable<Emp> {
	private int empNo;
	private String name;
	private int age;
	private String addr;
	
	public Emp() {}

	public Emp(int empNo, String name, int age, String addr) {
		super();
		this.empNo = empNo;
		this.name = name;
		this.age = age;
		this.addr = addr;
	}
	
	int getEmpNo() {
		return empNo;
	}

	void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getAge() {
		return age;
	}

	void setAge(int age) {
		this.age = age;
	}

	String getAddr() {
		return addr;
	}

	void setAddr(String addr) {
		this.addr = addr;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Emp [empNo=");
		builder.append(empNo);
		builder.append(", name=");
		builder.append(name);
		builder.append(", age=");
		builder.append(age);
		builder.append(", addr=");
		builder.append(addr);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int compareTo(Emp o) {
		return this.empNo - o.empNo;
	}
	
}
