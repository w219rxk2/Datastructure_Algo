package com.leetcode.algo;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ArrayPartition_561 {

	public int arrayPartition(int[] givenArray) {
		int[] sortedArray = this.insertionSort(givenArray);
		int sum = 0;
		
		for(int i=0;i<sortedArray.length-1;i = i+2) {
			sum = sum + Math.min(sortedArray[i], sortedArray[i+1]);
		}
		
		return sum;
	}
	
	public int[] insertionSort(int[] givenArray) {
		for(int i=1; i<givenArray.length;i++){
			int j = i-1;
			int temp = givenArray[i];
			while(j >= 0 && givenArray[j] > temp) {
				givenArray[j+1] = givenArray[j];
				j--;
			}
			givenArray[j+1] = temp;
		}
		return givenArray;
	}
	
	@Test
	public void testArrayPartition() {
		int[] givenArray = new int[10];
		givenArray[0] = 10;
		givenArray[1] = 1;
		givenArray[2] = 3;
		givenArray[3] = 2;
		givenArray[4] = 7;
		givenArray[5] = 4;
		givenArray[6] = 5;
		givenArray[7] = 6;
		givenArray[8] = 8;
		givenArray[9] = 9;
		
		int actual = this.arrayPartition(givenArray);
		
		assertEquals(25, actual);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
