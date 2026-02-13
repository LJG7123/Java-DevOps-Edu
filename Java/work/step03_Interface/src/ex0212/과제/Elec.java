package ex0212.과제;

public class Elec {
	private String code;
	private int cost;
	
	public Elec() {}
	
	public Elec(String code, int cost) {
		this.code = code;
		this.cost = cost;
	}

	String getCode() {
		return code;
	}

	void setCode(String code) {
		this.code = code;
	}

	int getCost() {
		return cost;
	}

	void setCost(int cost) {
		this.cost = cost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getClass().getSimpleName());
		builder.append(" [code=");
		builder.append(code);
		builder.append(", cost=");
		builder.append(cost);
		return builder.toString();
	}
	
	
}
