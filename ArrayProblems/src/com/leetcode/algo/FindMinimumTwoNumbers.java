package com.leetcode.algo;

import org.junit.Test;

public class FindMinimumTwoNumbers {
	
	public int[] minimumNumber(int[] given) {
		if(given.length == 1) {
			return given;
		}
		
		int[] ar = new int[2];
		int firstMin = given[0];
		
		// for second minimum
		int secondMin = given[0];
		
		for(int i = 1; i < given.length; i++) {
			if(given[i] < firstMin) {
				secondMin = firstMin;
				firstMin  = given[i];
			}
		}
		ar[0] = firstMin;
		ar[1] = secondMin;
		return ar;
	}
	
	@Test
	public void testLongestPalindrome() {
		int given[] = {1,3,5,0,8,-1,7,100,-100};
		int[] minAr = minimumNumber(given);
		
		for(int i: minAr) {
			System.out.print(i + ",");
		}
	}
}
