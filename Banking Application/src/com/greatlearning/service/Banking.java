package com.greatlearning.service;
import java.util.Scanner;

public class Banking {
	
	private int balance = 10000;
	private static Scanner sc = new Scanner(System.in);
	
	public void deposit(int amount) {
		if(amount>0) {
			// balance = balance + amount;
			balance += amount;
			System.out.println("Successfully added Rs. " + amount + "Your balance is now Rs. "+ balance);
		}
	}
	
	public void withdraw(int amount) {
		if(amount>balance) {
			System.out.println("Insufficient Funds");
			return;
		}
		// balance = balance - amount;
		balance -= amount;
		System.out.println("Successfully withdrawn Rs. " + amount + "Your balance is now Rs. "+ balance);
	}
	
	public void transfer(int amount,String recipientbankAccountNo) {
		// Authenticate using OTP
		int generatedOtp = OtpGenerator.generateOtp();
		System.out.println("Otp generated is "+generatedOtp);
		System.out.println("Please enter OTP");
		int enteredOtp = sc.nextInt();
		
		if(generatedOtp!=enteredOtp) {
			System.out.println("Authentication Failure");
			return;
		}
		if(amount > balance) {
			System.out.println("Insifficient balance");
			return;
		}
		balance -= amount;
		System.out.println("Successfully transferred Rs. " + amount + "Your balance is now Rs. "+ balance);	
	}
}
