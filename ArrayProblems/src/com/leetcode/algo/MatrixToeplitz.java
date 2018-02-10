package com.leetcode.algo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class MatrixToeplitz {
	/**766. Toeplitz Matrix
	 *
	 * A matrix is Toeplitz if every diagonal from top-left to bottom-right has the same element.
	 Now given an M x N matrix, return True if and only if the matrix is Toeplitz.
	 Example 1:
	 Input: matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
	 Output: True
	 Explanation:
	 1234
	 5123
	 9512
	 In the above grid, the diagonals are "[9]", "[5, 5]", "[1, 1, 1]", "[2, 2, 2]", "[3, 3]", "[4]",
	 and in each diagonal all elements are the same, so the answer is True.
	 Example 2:
	 Input: matrix = [[1,2],[2,2]]
	 Output: False
	 Explanation:
	 The diagonal "[1, 2]" has different elements.
	 Note:
	 matrix will be a 2D array of integers.
	 matrix will have a number of rows and columns in range [1, 20].
	 matrix[i][j] will be integers in range [0, 99].
	 */
	
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
