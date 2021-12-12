package com.greatlearning.dsa;
import java.util.Scanner;

public class Main {
	
	public static void main(String args[]) {
		System.out.println("Enter the size of an array");
		Scanner sc = new Scanner(System.in);
		int size  = sc.nextInt();
		
		System.out.println("Enter the "+size+"elements");
		
		int array[] = new int[size];
		
		for(int i=0;i<size;i++) {
			array[i] = sc.nextInt();
		}
		
		MergeSort mergeSort = new MergeSort();
		
		// we will call the merge sort functionality
		mergeSort.sort(array,0,array.length - 1);
		
		System.out.println("Array after sorting is ");
		for(int i = 0;i< size;i++) {
			System.out.print(array[i] + " ");
		}
		
		int midElement = (array.length/2) + 1;
		// Call ArrayRotation
		ArrayRotation arrayRotation = new ArrayRotation();
		// Call the method to left rotate
		arrayRotation.leftRotate(array,midElement,array.length);
		
		System.out.println("Array after rotation is ");
		for(int i = 0;i< size;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		
		System.out.println("Enter the key or element to search");
		int key = sc.nextInt();
		ModifiedBinarySearch pivotedBinarySearch = new ModifiedBinarySearch();
		int index = pivotedBinarySearch.pivotedBinarySearch(array, array.length, key);
		System.out.println("Key is found at position "+ (index+1));
		sc.close();
		
	}

}
