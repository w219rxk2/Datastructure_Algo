package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class LargestNumberTwiceOthers_747 {
	
	public int findLargest(int[] ar) {
		int[] mirror = new int[ar.length];
		
		for(int i=0;i<ar.length-1;i++) {
			mirror[i] = ar[i];
		}
		
		mirror = this.insertionSort(mirror);
		if(mirror[mirror.length-1] >= 2*mirror[mirror.length-2]) {
			for(int j=0;j<ar.length-1;j++) {
				if(mirror[mirror.length-1] == ar[j]) {
					return j;
				}
			}
		}
		
		return -1;
	}
	
	public int[] insertionSort(int[] mirror) {
		
		for(int i=0;i<mirror.length-1;i++) {
			int j = i+1;
			int value = mirror[j];
			while(j > 0 && mirror[j-1] > value) {
				mirror[j] = mirror[j-1];
				j--;
			}
			mirror[j] = value;
		}
		return mirror;
	}
	
	@Test
	public void testFindLaregest() {
		int[] ar = {3, 6, 1, 0};
		LargestNumberTwiceOthers_747 largestNumberTwiceOthers_747 =  new LargestNumberTwiceOthers_747();
		int index = largestNumberTwiceOthers_747.findLargest(ar);
		
		assertEquals(1, index);
	}
}
