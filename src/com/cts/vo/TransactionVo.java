package com.cts.vo;

import org.springframework.stereotype.Component;

@Component
public class TransactionVo {

	private Long accountNumber;

	private String Description;

	private String transactionType;

	private Long transactionAmount;

	private Long TransactionId;
	
	private Long Balance; 

	public TransactionVo() {
		super();
	}

	public TransactionVo(Long accountNumber, String description,
			String transactionType, Long transactionAmount) {
		super();
		this.accountNumber = accountNumber;
		Description = description;
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
	}


	public Long getBalance() {
		return Balance;
	}

	public void setBalance(Long balance) {
		Balance = balance;
	}

	public Long getTransactionId() {
		return TransactionId;
	}

	public void setTransactionId(Long transactionId) {
		TransactionId = transactionId;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
}
