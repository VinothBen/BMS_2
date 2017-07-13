package com.cts.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_details")
public class TransactionDetails {

	@Id
	@Column(name = "TRANSACTION_ID")
	private long transaction_id;

	@ManyToOne(cascade = CascadeType.ALL, targetEntity = UserDetails.class)
	@JoinColumn(name = "ACCOUNT_NUMBER")
	private UserDetails user;

	@Column(name = "TRANSACTION_DESCRIPTION")
	private String Description;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

	@Column(name = "TRANSACTION_AMOUNT")
	private long transactionAmount;

	public long getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(long transaction_id) {
		this.transaction_id = transaction_id;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
		this.user = user;
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

	public long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

}
