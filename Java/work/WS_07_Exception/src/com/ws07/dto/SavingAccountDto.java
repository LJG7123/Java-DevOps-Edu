package com.ws07.dto;

public class SavingAccountDto extends AccountDto {
	private int transferFee;
	
	public SavingAccountDto() {}

	public SavingAccountDto(int accountSeq, String accountNumber, int balance, int userSeq, int transferFee) {
		super(accountSeq, accountNumber, balance, userSeq);
		this.setTransferFee(transferFee);
	}

	public int getTransferFee() {
		return transferFee;
	}

	public void setTransferFee(int transferFee) {
		this.transferFee = transferFee;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder(super.toString());
		builder.deleteCharAt(builder.length() - 1);
		builder.append(", transferFee=");
		builder.append(transferFee);
		builder.append("]");
		return builder.toString();
	}
	
}
