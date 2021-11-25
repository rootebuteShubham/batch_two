package com.greatlearning.main;
import java.util.Scanner;
import com.greatlearning.model.*;
import com.greatlearning.service.*;

public class Driver {
	
	// Create Object
	private static Scanner sc = new Scanner(System.in);
	private static Customer customer = new Customer("GL00001234","password123");
	private static Banking banking = new Banking();
	
	public static void main(String[] args) {
		int amount;
		String recipientbankAccountNo;
		int choice;
		// welcome message
		displayWelcomeMessage();
		
		// Authenticate the credentials
		if(isCredentialsOk()) {
			System.out.println("Successfully Authenticated");
			
			// display menu
			do {
				displayMenu();
				System.out.println("Enter your choice");
				choice = sc.nextInt();
				
				switch(choice) {
					case 1:
						System.out.println("Enter the amount to deposit");
						amount = sc.nextInt();
						// deposit money to the account
						banking.deposit(amount);
						break;
						
					case 2:
						System.out.println("Enter the amount to withdraw");
						amount = sc.nextInt();
						// withdraw money from the account
						banking.withdraw(amount);
						break;
					case 3:
						System.out.println("Enter the amount to transfer");
						amount = sc.nextInt();
						System.out.println("Enter the recipient account number");
						recipientbankAccountNo = sc.next();
						// transfer the money
						banking.transfer(amount, recipientbankAccountNo);
						break;
				}
			
		} while(choice!=4);
			} else {
			System.out.println("Authentication failure");
		}
		
	}
	
	private static void displayWelcomeMessage() {
		System.out.println("Welcome to the Greatlearning Bank");
	}
	
	
	private static boolean isCredentialsOk() {
		System.out.println("Enter your account number");
		String accountNo = sc.next();
		System.out.println(accountNo);
		
		System.out.println("Enter your password");
		String password = sc.next();
		System.out.println(password);
		
		return customer.getBankAccountNo().equals(accountNo) && customer.getPassword().equals(password);
		
	}
	
	
	private static void displayMenu() {
		System.out.println("--------------------------------------");
		System.out.println("1.Deposit");
		System.out.println("2.Withdraw");
		System.out.println("3.Transfer");
		System.out.println("4.Logout");
		System.out.println("--------------------------------------");
	}
}



