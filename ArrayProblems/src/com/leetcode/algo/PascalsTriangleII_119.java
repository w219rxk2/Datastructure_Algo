package com.leetcode.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class PascalsTriangleII_119 {
	
	 public List<Integer> getRow(int rowIndex) {
	       
		 int[][] matrix  = new int[rowIndex][rowIndex];
		 
		 for(int i = 0; i <= rowIndex ; i++) {
			 for(int j =0; j <= i; j++) {
				 if(j == 0) {
					 matrix[i][j] = 1;
				 }else if(i == j) {
					 matrix[i][j] = 1;
				 }else {
					 matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
				 }
			 }
		 }
		 int[] rowAr = matrix[rowIndex];
		 
		 List<Integer> rowList = new ArrayList<>();
		 
		 for(int i =0; i< rowAr.length ; i++) {
			 rowList.add(rowAr[i]);
		 }
		 
		 return rowList;
	 }
	 
	 public List<Integer> getRowDiff(int rowIndex) {
			
			int[][] matrix  = new int[rowIndex+1][rowIndex+1];
			
			for(int i = 0; i <= rowIndex; i++) {
				matrix[i][i] = 1;
				matrix[i][0] = 1;
			}
			
			for(int i =2; i <=rowIndex; i++ ) {
				for(int j =1;j < i; j++) {
					matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
				}
			}
			int[] rowAr = matrix[rowIndex];
			 
			List<Integer> rowList = new ArrayList<>();
			 
			for(int i =0; i< rowAr.length ; i++) {
				rowList.add(rowAr[i]);
			}
			 
			return rowList;
	}
	 
	public List<Integer> getRowO_K(int rowIndex) {
	 
		Integer[] ar  = new Integer[rowIndex+1];
		Arrays.fill(ar, 0);
		ar[0] = 1;
		
		for(int i =1 ; i <= rowIndex; i++) {
			 for(int j = i; j > 0; j--) {
				 ar[j] = ar[j] + ar[j-1]; 
			 }
		}
		return Arrays.asList(ar);
	}
	
	@Test
	public void testGetRow() {
		getRowO_K(1);
	}
}
