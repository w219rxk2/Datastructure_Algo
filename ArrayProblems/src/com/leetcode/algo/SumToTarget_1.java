package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class SumToTarget_1 {
	public int[] matchTarget(int[] ar, int target) {
		int[] output = new int[2];
		
		for(int i=0; i< ar.length-1; i++) {
			for(int j=i+1 ; j < ar.length-1; j++ ) {
				if(ar[i] + ar[j] == target) {
					output[0] = ar[i];
					output[1] = ar[j];
				}
			}
		}
		return output;
	}
	
	@Test
	public void testMatchTarget() {
		int[] ar = {2, 7, 11, 15};
		int[] matchArray = matchTarget(ar, 9);
		assertEquals(2, matchArray[0]);
	}
}
