package com.greatlearning.model;

public class Customer {
	
	private String bankAccountNo;
	private String password;
	
	// Define a constructor
	public Customer(String bankAccountNo, String password) {
		this.bankAccountNo = bankAccountNo;
		this.password = password;
	}
	
	// Define getters and setters
	public String getBankAccountNo() {
		return bankAccountNo;
		
	}
	
	public void setBankAccountNo(String bankAccountNo) {
		this.bankAccountNo = bankAccountNo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

