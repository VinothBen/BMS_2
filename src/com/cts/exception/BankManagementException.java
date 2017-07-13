package com.cts.exception;

@SuppressWarnings("serial")
public class BankManagementException extends Exception {

	private String msg;

	public BankManagementException(String valueOf) {
		this.msg = valueOf;

	}

	public String getmsg() {
		return msg;
	}
}
