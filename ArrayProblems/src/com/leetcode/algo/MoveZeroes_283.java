package com.leetcode.algo;

import org.junit.Test;

public class MoveZeroes_283 {
	
	public void moveZeroes(int[] nums) {
		
		if(nums.length == 0 || nums.length == 1) {
			return;
		}
		
		for(int i = 0; i < nums.length ; i++) {
			if(nums[i] == 0) {
				for(int j =i+1; j < nums.length; j++) {
					if(nums[j] != 0) {
						nums[i] = nums[j];
						nums[j] = 0;
						break;
					}
				}
			}
		}
	}
	
	public void moveZaeroesEasy(int[] nums) {

		
		int index = 0;
		
		for(int i =0; i < nums.length; i++) {
			if(nums[i] != 0) {
				nums[index] = nums[i];
				index++;
			}
		}
		
		while(index < nums.length) {
			nums[index] = 0;
			index++;
		}
	
	}
	
	@Test
	 public void testMoveZeroes() {
		 int[] nums = {2,1};
		 moveZeroes(nums);
		 //assertEquals(720, maximumProduct);
		 
		 for(int i =0 ; i < nums.length ; i++) {
			 System.out.print(nums[i] + "->");
		 }
	 }
}
