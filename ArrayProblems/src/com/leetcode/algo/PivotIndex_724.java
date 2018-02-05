package com.leetcode.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PivotIndex_724 {
	
	public int pivotIndexActual(int[] nums) {
		int pivot = -1;
		
		for(int i=0; i< nums.length-1;i++) {
			int leftSum = 0;
			int rightSum = 0;
			int leftIndex =0;
			int rightIndex = i+1;
			while(leftIndex<i) {
				leftSum = leftSum+nums[leftIndex];
				leftIndex++;
			}
			
			while(rightIndex<nums.length) {
				rightSum = rightSum+nums[rightIndex];
				rightIndex++;
			}
			
			if(leftSum == rightSum) {
				pivot = i;
			}
		}
		return pivot;
	}
	
	@Test
	public void testPivotIndex() {
		int[] pivotArray = {1, 7, 3, 6, 5, 6};
		int pivot = this.pivotIndexActual(pivotArray);
		assertEquals(3,pivot);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
