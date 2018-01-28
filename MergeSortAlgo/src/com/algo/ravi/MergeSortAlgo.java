package com.algo.ravi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

/**
 * Merge sort has two utility methods 
 * 1. split method (to split the given array to arrays containing only single element).
 * 2. Merge method (which takes in two sorted list and merge them to single sorted list).
 * 
 * @author chandu
 *
 */
public class MergeSortAlgo {
	
	public void mergeSort(int[] arrayToSort) {
		
		if(arrayToSort.length != 1) {
			int middle = arrayToSort.length/2;
			int[] firstHalfArray = new int[middle];
			int[] secondHalfArray = new int[arrayToSort.length-middle];
			split(arrayToSort,firstHalfArray, secondHalfArray);
			
			mergeSort(firstHalfArray);
			mergeSort(secondHalfArray);
			
			merge(arrayToSort, firstHalfArray, secondHalfArray);
			System.out.println();
			printArray(arrayToSort);
			
		} else {
			return;
		}
	}
	
	public void split(int[] actualArray, int[] firstHalfArray, int[] secondHalfArray) {
		int firstHalfIndex = firstHalfArray.length-1;
		int index = 0;
		for(int element : actualArray) {
			if(index <= firstHalfIndex) {
				firstHalfArray[firstHalfIndex] = element;
				firstHalfIndex--;
			}else {
				secondHalfArray[index] = element;
				index++;
			}
		}
		
		this.printArray(actualArray);
		System.out.println();
		this.printArray(firstHalfArray);
		System.out.println();
		this.printArray(secondHalfArray);
		System.out.println();
		System.out.println("--------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------");
		
	}
	
	public void merge(int[] listToSort,int[] firstHalfArray, int[] secondHalfArray ) {
		
		int secondArrayIndex = 0;
		int listToSortIndex = 0;
		int firstArrayIndex = 0;
		
		while(listToSortIndex != firstHalfArray.length +secondHalfArray.length) {
			if(secondArrayIndex != secondHalfArray.length && firstArrayIndex != firstHalfArray.length && firstHalfArray[firstArrayIndex] > secondHalfArray[secondArrayIndex]) {
				listToSort[listToSortIndex] = secondHalfArray[secondArrayIndex];
				listToSortIndex++;
				secondArrayIndex++;
			}else if(firstArrayIndex != firstHalfArray.length && secondArrayIndex != secondHalfArray.length && firstHalfArray[firstArrayIndex] < secondHalfArray[secondArrayIndex]) {
				listToSort[listToSortIndex] = firstHalfArray[firstArrayIndex];
				listToSortIndex++;
				firstArrayIndex++;
			}else {
				if(secondArrayIndex != secondHalfArray.length) {
					while(listToSortIndex != firstHalfArray.length +secondHalfArray.length) {
						listToSort[listToSortIndex] = secondHalfArray[secondArrayIndex];
						secondArrayIndex++;
						listToSortIndex++;
					}
				}
				
				if(firstArrayIndex != firstHalfArray.length) {
					while(listToSortIndex != firstHalfArray.length +secondHalfArray.length) {
						listToSort[listToSortIndex] = firstHalfArray[firstArrayIndex];
						firstArrayIndex++;
						listToSortIndex++;
					}
				}
			}
		}
		
	}
	
	public void printArray(int[] ar) {
		for(int i : ar) {
			System.out.print(i + ",");
		}
		
	}

	@Test
	public void testSplit() {
		MergeSortAlgo ms = new MergeSortAlgo();
		int[] ar = { 54, 13, 24, 19, 11, 3, 71, 8, 34 };
		
		int middle = ar.length/2;
		int[] firstHalfArray  = new int[middle];
		int[] secondHalfArray = new int[ar.length - middle];
		ms.split(ar, firstHalfArray, secondHalfArray);
		
		assertEquals("lengths are equal",4, firstHalfArray.length);
		assertEquals("lengths are equal",5, secondHalfArray.length);
		assertEquals("lengths are equal",ar.length, firstHalfArray.length+secondHalfArray.length);
	}
	
	public static void main(String[] args) {
		
		MergeSortAlgo ms = new MergeSortAlgo();
		int[] ar = { 54, 13, 24, 19, 11, 3, 71, 8, 34 };
		
		ms.mergeSort(ar);
		System.out.println();
		ms.printArray(ar);
	}

}
