package ex0212.과제;

public class Audio extends Elec implements ElecFunction {
	private int volumn;
	
	public Audio() {}
	
	public Audio(int volumn) {
		this.volumn = volumn;
	}
	
	public Audio(String code, int cost, int volumn) {
		super(code, cost);
		this.volumn = volumn;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append(", volumn=");
		builder.append(volumn);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void start() {
		System.out.println(super.getCode() + "의 Audio를 " + volumn + "으로 듣는다.");
		
	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() {
		// TODO Auto-generated method stub
		
	}
	
}
