package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class RemoveSameElement_27 {
	public int removeSameElement(int[] ar) {
		if(ar.length == 1) {
			return 1;
		}
		
		for(int i =0; i<ar.length;i++) {
			
			if(ar[i] == 'z') {
				break;
			}
			
			for(int j=i+1; j<ar.length;j++) {
				
				if(ar[i] == ar[j]) {
					for(int z = j;z< ar.length-1;z++) {
						ar[z] = ar[z+1];
						
						if(z == ar.length-2) {
							ar[z+1] = 'z';
						}
					}
				}
			}
		}
		
		int length = 0;
		for(int i=0; i<ar.length;i++) {
			if(ar[i] == 'z') {
				break;
			}
			length++;
		}
		
		return length;
	}
	
	@Test
	public void testRemoveSameElement() {
		int ar[] = {0,1,2,2,3,4,4,5,6,7,7,8,9,9};
		
		int length = removeSameElement(ar);
		assertEquals(10, length);
	}
}
