package com.leetcode.algo;

import org.junit.Test;

public class RotateArray_189 {
	
	public void rotate(int[] nums, int k) {
		
		if(nums.length < 2) {
			return;
		}
		
		k = k % nums.length;
		
		reverseArray(nums, 0, nums.length - k -1);
		reverseArray(nums, nums.length-k, nums.length-1);
		reverseArray(nums, 0, nums.length-1);
	}
	
	private void reverseArray(int[] nums, int i, int j) {

		while(i < j) {
			int sum = nums[i] + nums[j];
			nums[i] = sum - nums[i];
			nums[j] = sum - nums[i];
			i++;
			j--;
		}
		
	}

	@Test
	 public void testRotate() {
		 int[] nums = {1,2,3,4,5,6,7};
		 rotate(nums, 3);
		 
		 for(int i =0 ; i < nums.length ; i++) {
			 System.out.print(nums[i] + "->");
		 }
	 }
}
