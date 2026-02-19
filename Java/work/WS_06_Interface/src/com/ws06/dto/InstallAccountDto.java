package com.ws06.dto;

public class InstallAccountDto extends AccountDto {
	private int period;
	private int amount;
	
	public InstallAccountDto() {}

	public InstallAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int period, int amount) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.setPeriod(period);
		this.setAmount(amount);
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.deleteCharAt(builder.length() - 1);
		builder.append(", period=");
		builder.append(period);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
