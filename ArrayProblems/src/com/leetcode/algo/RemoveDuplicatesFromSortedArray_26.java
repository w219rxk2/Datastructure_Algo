package com.leetcode.algo;

import org.junit.Test;

public class RemoveDuplicatesFromSortedArray_26 {
	public int[] removeduplicates(int[] ar) {
		
		if(ar.length == 1) {
			return ar;
		}
		
		for(int i =0; i<= ar.length-1 ; i++) {
			if(ar[i] == 'z') {
				break;
			}
			if(i+1 <= ar.length-1 && ar[i] == ar[i+1]) {
				for(int j = i+2;j<ar.length; j++) {
					ar[j-1] = ar[j];
					if(j == ar.length-1) {
						ar[j] = 'z';
					}
				}
			}
		}
		return ar;
	}
	
	@Test
	public void testRemoveDuplicates() {
		int ar[] = {0,1,2,2,3,4,4,5,6,7,7,8,9,9};
		
		int[] removeduplicates = removeduplicates(ar);
		
		for(int i=0; i<= removeduplicates.length-1; i++) {
			System.out.print(removeduplicates[i] + " ");
		}
		
	}
}
