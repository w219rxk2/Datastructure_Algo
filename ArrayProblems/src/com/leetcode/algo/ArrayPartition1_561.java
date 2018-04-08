package com.leetcode.algo;

import java.util.Arrays;

import org.junit.Test;

public class ArrayPartition1_561 {
	public int arrayPairSum(int[] nums) {
		
		if(nums.length % 2 != 0) {
			// throw error
		}
		
		Arrays.sort(nums);
		int sum = 0;
		
		for(int i =0 ; i < nums.length; i =i+2) {
			sum = sum + nums[i];
		}
		return sum;
		
    }
	
	private void insertionSort(int[] ar) {
		
		for(int i =1; i< ar.length ; i++) {
			int value = ar[i];
			int j = i-1;
			
			while(j >= 0 && ar[j] >= value) {
				ar[j+1] = ar[j];
				j--;
			}
			
			ar[j+1] = value;
		}
	}
	
	@Test
	public void testArrayPairSum() {
		 int[] nums = {1,3,5,6,9,2,4,8,7,10};
		 
		 insertionSort(nums);
		 
		 for(int i =0; i<nums.length; i++) {
			 System.out.print(nums[i] + ", ");
		 }
	}
}
