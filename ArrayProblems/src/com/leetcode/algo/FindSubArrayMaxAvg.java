package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class FindSubArrayMaxAvg {
	public double findMaxAverage(int[] nums, int k) {
        
        if(k == 0 || k > nums.length) {
        	// throw error
        }
        
        double avgValue = Double.MIN_VALUE;
        int size = nums.length;
        double[][] matrixAr = new double[size][size];
        
        // for k == 1
        for(int i =0; i < size; i++) {
        	matrixAr[i][i] = nums[i];
        	if(avgValue < matrixAr[i][i]) {
        		avgValue = matrixAr[i][i];
        	}
        }
        if(k == 1) {
        	return avgValue;
        }
        
        avgValue = Double.MIN_VALUE;
        // for k == 2
        for(int i =0; i < size-1; i++) {
        	matrixAr[i][i+1] = Double.valueOf((nums[i] + nums[i+1])/2);
        	if(avgValue < matrixAr[i][i+1]) {
        		avgValue = matrixAr[i][i+1];
        	}
        }
        if(k == 2) {
        	return avgValue;
        }
        
        // for k > 2
        for(int curr_length = 3; curr_length <= size; curr_length++) {
        	avgValue = Double.MIN_VALUE;
        	for(int i=0; i < size-curr_length +1 ; i++) {
        		int j = curr_length+i-1;
        		matrixAr[i][j] = Double.valueOf((matrixAr[i][j-1] + nums[j])/curr_length);
        		if(avgValue < matrixAr[i][j]) {
            		avgValue = matrixAr[i][j];
            	}
        	}
        	if(k == curr_length) {
        		return avgValue;
        	}
        }
        return avgValue;
    }
	
	
	@Test
	public void testFindMaxAverage() {
		int[] nums = {1,12,-5,-6,50,3};
		
		double findMaxAverage = findMaxAverage(nums, 4);
		
		assertEquals(12.75, findMaxAverage);
	}
}
