package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class KDiffPairsInArray {
	public int findPairs(int[] nums, int k) {
		int size = nums.length;
		
		if(k >= size) {
			// throw error
		}
		
		if(size == 0 ) {
			return 0;
		}
		
		Arrays.sort(nums);
		int pairs = 0;
		for(int i=0; i< size-1; i++) {
			for(int j = i+1;j < size; j++) {
				
				if(Math.abs(nums[i] - nums[j]) == k) {
					pairs = 1 + pairs;
					break;
				}
			}
			while(i < size-1 && nums[i] == nums[i+1]) {
				i++;
			}
		}
		return pairs;
	}
	
	@Test
	public void testFindPairs() {
		
		int[] nums2 = {1,1,3,4,5};
		
		int findPairs = findPairs(nums2, 2);
		
		assertEquals(2, findPairs);
		
		int[] nums = {1,2,3,4,5};
		
		findPairs = findPairs(nums, 1);
		
		assertEquals(4, findPairs);
		
		int[] nums1 = {1,1,1,1,1};
		
		findPairs = findPairs(nums1, 0);
		
		assertEquals(1, findPairs);
	}
}
