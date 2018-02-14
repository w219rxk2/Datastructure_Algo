package com.algo.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class UniquePaths_62 {
	
	//m - rows
	//n - columns
	public int findUniquePaths(int m, int n) {
		
		int matrix[][] = new int[m][n];
		int i = 0,j = 0;
		
		for(int z=0;z<m*n;z++) {
			if(j == n) {
				i++;
				j = 0;
			}
			
			if(i == 0 && j==0) {
				matrix[i][j] = 1;
				j++;
			} else {
				if(j > 0 && i >0 ) {
					for(int r=1;r<j+1;r++) {
						matrix[i][j] = matrix[i][j-1] + matrix[i-1][r];
					}
				}else {
					matrix[i][j] = 1;
				}
				j++;
			}
		}
		
		return matrix[m-1][n-1];
	}
	
	@Test
	public void testFindUniquePaths() {
		int uniqueWays = findUniquePaths(3, 3);
		
		assertEquals(6, uniqueWays);
	}
}
