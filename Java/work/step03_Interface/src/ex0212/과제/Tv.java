package ex0212.과제;

public class Tv extends Elec implements ElecFunction {
	private int channel;
	
	public Tv() {}
	
	public Tv(int channel) {
		this.channel = channel;
	}
	
	public Tv(String code, int cost, int channel) {
		super(code, cost);
		this.channel = channel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.append(", channel=");
		builder.append(channel);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public void start() {
		System.out.println(getCode() + "제품 TV를 " + channel + "을 본다.");
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
