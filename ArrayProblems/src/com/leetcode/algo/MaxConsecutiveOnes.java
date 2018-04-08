package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MaxConsecutiveOnes {
	public int findMaxConsecutiveOnes(int[] nums) {
		
		if(nums.length == 1) {
			if(nums[0] == 1) {
				return 1;
			}
			return 0;
		}
		
        int max = 0;
        int preMax = 0;
        
        for(int i = 0; i< nums.length; i++) {
        	if(1 == nums[i]) {
        		max = max +1;
        	}else {
        		if(preMax <=  max) {
        			preMax = max;
        		}
        		max = 0;
        	}
        }
        
        return Math.max(preMax, max);
    }
	
	@Test
	public void testFindPairs() {
		int[] nums = {3, 1, 4, 1, 5};
		
		int findPairs = findMaxConsecutiveOnes(nums);
		
		assertEquals(1, findPairs);
	}
}
