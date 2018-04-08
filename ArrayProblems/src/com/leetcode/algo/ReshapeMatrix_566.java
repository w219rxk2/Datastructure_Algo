package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.RecursiveAction;

import org.junit.Test;

public class ReshapeMatrix_566 {
	 public int[][] matrixReshape(int[][] nums, int r, int c) {
		 
		 if (nums.length == 0 || r * c != nums.length * nums[0].length)
	            return nums;
		 
		 int[][] resizeAr = new int[r][c];
		 Queue<Integer> q = new LinkedList<Integer>();
		 
		 for(int i = 0; i < nums.length ; i++) {
			 for(int j =0 ; j < nums[i].length; j++) {
				 q.add(nums[i][j]);
			 }
		 }
		 
		 for(int i = 0; i< resizeAr.length; i++) {
			 for(int j=0; j<resizeAr[i].length ; j++) {
				 resizeAr[i][j] = q.poll();
			 }
		 }
		 return resizeAr;
	 }
	 
	 @Test
	 public void testReshapeMatrix() {
		 int[][] nums = {{1,2},{3,4}};
		 int[][] matrixReshape = matrixReshape(nums, 1, 4);
		 int[][] resize = {{1,2,3,4}};
		 
		 for(int i =0; i<resize.length ; i++) {
			 for(int j =0; j<resize[i].length ; j++) {
				 assertEquals(matrixReshape[i][j], resize[i][j]);;
			 }
		 }
	 }
}
