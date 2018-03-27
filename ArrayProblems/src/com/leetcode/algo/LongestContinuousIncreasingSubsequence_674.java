package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LongestContinuousIncreasingSubsequence_674 {
	public int[] findLongestIncreasingSubsequence(int[] nums) {
		int size = nums.length;
		if(size == 1) {
			return nums;
		}
		
		if(size == 2) {
			if(nums[0] < nums[1]) {
				return nums;
			}else {
				return null;
			}
		}
		
		boolean subsequenceMatrix[][] = new boolean[size][size];
		int max_size = 0;
		int startsAt = 0;
		
		// for diagonal
		for(int i =0; i < size; i++) {
			subsequenceMatrix[i][i] = true;
			max_size = 1;
			startsAt = 0;
		}
		
		// for 2 elements
		for(int i = 0;i< size-1;i++) {
			if(nums[i] < nums[i+1]) {
				subsequenceMatrix[i][i+1] = true;
				max_size = 2;
				startsAt = i;
			}
		}
		
		// for >2 elements
		for(int curr_length =3; curr_length <= size;curr_length++) {
			for(int i=0; i <= size-curr_length; i++) {
				int j = curr_length+i-1;
				if(subsequenceMatrix[i][j-1] && nums[j] > nums[j-1]) {
					subsequenceMatrix[i][j] = true;
					max_size = curr_length;
					startsAt = i;
				}
			}
		}
		
		int[] longestSubsequenceArr = new int[max_size];
		
		for(int i =startsAt, j=0; i < max_size; i++,j++) {
			longestSubsequenceArr[j] = nums[i];
		}
		
		return longestSubsequenceArr;
	}
	
	@Test
	public void testLongestPalindrome() {
		int given[] = {1,3,5,4,7};
		
		int[] findLongestIncreasingSubsequence = findLongestIncreasingSubsequence(given);
		
		assertEquals(findLongestIncreasingSubsequence.length, 3);
		
		int given2[] = {2,2,2,2,2};
		
		findLongestIncreasingSubsequence = findLongestIncreasingSubsequence(given2);
		
		assertEquals(findLongestIncreasingSubsequence.length, 1);
	}
}
