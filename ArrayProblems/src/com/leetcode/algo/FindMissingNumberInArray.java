package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class FindMissingNumberInArray {
	public int findMissingNumber(int[] ar) {
		int size = ar.length;
		
		if(ar.length == 1) {
			return ar[0];
		}
		
		for(int i=0; i< size; i++) {
			if((i^ar[i]) != 0) {
				return i;
			}
		}
		
		return -1;
	}
	
	@Test
	public void testFindMissingNumber() {
		int[] ar = {0,1,2,3,4,5,6,7,8};
		
		int missingNumber = findMissingNumber(ar);
		
		assertEquals(-1, missingNumber);
	}
}
