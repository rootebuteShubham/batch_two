package com.greatlearning.dslabsession;

import java.util.Scanner;

public class Transaction {
	public static void main(String args[]) {
		
		Scanner s = new Scanner(System.in);
		
		//  Ask the user to enter the size of the transaction array
		
		System.out.println("enter the size of transaction array");

		int size = s.nextInt();

		int arr[] = new int[size];
		
		//  Ask the user to enter the values of the array
		
		System.out.println("enter the values of array");
		
		for (int i = 0; i < size; i++)

			arr[i] = s.nextInt();
		
		
		// Ask the user to enter the number of targets that needs to be achieved
		System.out.println("enter the total no of targets that needs to be achieved");
		int targetNo = s.nextInt();
		
		
		// Ask the user to enter the value of target
		
		// Loop over the transaction array that you have created earlier and find out whether the target can be achieved.
		// If the target cannot be achieved then print some message saying that given target cannot be achieved
		
		while (targetNo != 0) {

			int flag = 0;

			long target;

			System.out.println("enter the value of target");
			target = s.nextInt();

			long sum = 0;

			for (int i = 0; i < size; i++) { //linear iteration , linear searching

				sum += arr[i];

				if (sum >= target) {

					System.out.println("Target achieved after "+(i + 1) + " transactions ");

					flag = 1;

					break;

				}

			}

			if (flag == 0) {

				System.out.println(" Given target is not achieved ");

			}

		}
	}

}
