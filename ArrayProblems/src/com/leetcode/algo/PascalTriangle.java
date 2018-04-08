package com.leetcode.algo;

public class PascalTriangle {
	
	public void printPascalTriangle(int k) {
		
		int[][] matrix  = new int[k][k];
		
		
		for(int i = 0; i <= k ; i++) {
			for(int j = 0; j <= i ; j++) {
				if(j == 0) {
					matrix[i][j] = 1;
				}else if(j == i) {
					matrix[i][j] = 1;
				}else {
					matrix[i][j] = matrix[i-1][j] + matrix[i-1][j-1];
				}
			}
		}
	}
}
