package com.greatlearning.dsa;

public class MergeSort {

	void merge(int arr[], int left, int mid, int right) {
		
		// Find the sizes of the two sub arrays (left and right)
		int n1 = mid - left + 1;     
		int n2 = right - mid;
		
		// Create temporary arrays
		int leftArray[] = new int[n1];
		int rightArray[] = new int[n2];
		
		
		// Copy data to these temporary arrays
		for(int i = 0;i<n1; i++) {
			leftArray[i] = arr[left+i];
		}
		for(int j = 0;j < n2; j++) {
			rightArray[j] = arr[mid + 1 + j];
		}
		
		// Merge the temporary arrays
		int i = 0; int j = 0;
		int k = left;
		
		
		while(i < n1 && j < n2) {
			if(leftArray[i] < rightArray[j]) {
				arr[k] = leftArray[i];
				i++;
			}
			else 
			{
				arr[k] = rightArray[j];
				j++;
			}
			k++;
		}
		
		
		while(i < n1) {
			arr[k] = leftArray[i];
			i++;
			k++;
			
		}
		
		while(j < n2) {
			arr[k] = rightArray[j];
			j++;
			k++;
			
		}
		
	}
	
	
	
	void sort(int arr[],int left, int right) {
		
		if(left<right) {
			
			// Find the middle index 
			int mid = (left+right)/2;
			
			// Sort the first and the second halves (left and right)
			sort(arr,left,mid); // Left side of the array
			sort(arr,mid+1,right); // Right side of the array
			
			// merge the sorted halves
			merge(arr,left,mid,right);
		}
		
		
	}
}
