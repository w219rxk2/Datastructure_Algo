package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class ShortestUnsortedContinuousSubArray_581 {
	
	 public int findUnsortedSubarray(int[] nums) { 
		 if(nums.length == 1) {
			 return 0;
		 }
		 
		 int i= 0;
		 int start = Integer.MIN_VALUE;
		 int end = Integer.MIN_VALUE;
		 int temp = Integer.MIN_VALUE;
		 
		 for(i = 0; i < nums.length-1; i++) {
			 if(nums[i] > nums[i+1]) {
				 start = i;
				 break;
			 }
		 }
		 
		 if(i == nums.length-1) {
			 return 0;
		 }
		 
		 for(i = nums.length-1; i > 0; i--) {
			 if(nums[i] < nums[i-1]) {
				 end = i;
				 break;
			 }
		 }
		 
		 //insertionSort(nums, start, end, i, temp);
		 
		 for(i = start+1; i <= end; i++) {
			 temp = nums[i];
			 int inner = i-1;
			 
			 while(inner >= start && temp < nums[inner] ) {
				 nums[inner+1] = nums[inner];
				 inner--;
			 }
			 nums[inner+1] = temp;
		 }
		 
		 while(start > 0 && nums[start-1] > nums[start] ) {
			 temp = nums[start-1];
			 nums[start-1] = nums[start];
			 nums[start] = temp;
			 start--;
		 }
		 
		 while(end < nums.length-1 && nums[end+1] < nums[end] ) {
			 temp = nums[end+1];
			 nums[end+1] = nums[end];
			 nums[end] = temp;
			 end++;
		 }
		 
		 return end+1-start;
    }
	
	public void insertionSort(int[] nums,int start,int end, int i, int temp) {
		
		for(i = start; i < end; i++) {
			 int y = i + 1;
			 temp = nums[y];
			 
			 while(y >= i && temp < nums[y-1] ) {
				 nums[y] = nums[y-1];
				 y--;
			 }
			 nums[y] = temp;
		 }
	}
	
	@Test
	public void testFindUnsortedSubarray() {
		int[] nums = {2, 6, 4, 8, 10, 9, 15};
		
		int subArrayLength = findUnsortedSubarray(nums);
		
		assertEquals(5, subArrayLength);
		
		int[] nums2 = {2,1};
		
		subArrayLength = findUnsortedSubarray(nums2);
		
		assertEquals(2, subArrayLength);
		
		int[] nums3 = {1,2,4,5,3};
		
		subArrayLength = findUnsortedSubarray(nums3);
		
		assertEquals(3, subArrayLength);
	}
}
