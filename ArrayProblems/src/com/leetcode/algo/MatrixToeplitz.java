package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MatrixToeplitz {
	
	public boolean matrixToeplitz(int[][] ar) {
		int rowLength = ar.length;
		int[] firstRow = ar[0];
		int columnLenth = firstRow.length; 
		int index = 0;
		while(index < rowLength) {
			
			for(int i = index; i<columnLenth;i++) {
				
				if(i+1 < columnLenth && ar[1][i+1] != ar[0][i]) {
					return false;
				}
			}
			
			index++;
		}
		return true;
		
	}
	
	@Test
	public void testToeplitzMatrix() {
		int[][] matrix1 = {{1,2,3,4},{5,1,2,3},{9,5,1,2}};
		boolean ismatrixToeplitz = matrixToeplitz(matrix1);
		assertEquals(true, ismatrixToeplitz);
		
		int[][] matrix2 = {{1,2},{2,2}};
		ismatrixToeplitz = matrixToeplitz(matrix2);
		assertEquals(false, ismatrixToeplitz);
	}

}
