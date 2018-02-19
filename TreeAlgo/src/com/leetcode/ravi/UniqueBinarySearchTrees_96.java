package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class UniqueBinarySearchTrees_96 {
	public int findUniqueBinarySearchTrees(int[] ar) {
		int uniqueTrees = 0;
		
		if(ar.length == 1) {
			return 1;
		}else {
			int[] sortedArray = insertionSort(ar);
			
			for(int i=0; i< sortedArray.length; i++) {
				
				if(i != sortedArray.length/2) {
					int[] leftArray = new int[i];
					
					for(int j=0; j<leftArray.length;j++) {
						leftArray[j] = sortedArray[j];
					}
					
					if(leftArray.length != 0) {
						uniqueTrees += findUniqueBinarySearchTrees(leftArray);
					}
					
					int[] rightArray = new int[sortedArray.length-i-1];
					int r = i+1;
					for(int z=0; z<rightArray.length;z++) {
						rightArray[z] = sortedArray[r];
						r++;
					}
					if(rightArray.length != 0) {
						uniqueTrees += findUniqueBinarySearchTrees(rightArray);
					}
				} 
				else if(i == sortedArray.length/2) {
					if(sortedArray.length % 2 != 0) {
						uniqueTrees = uniqueTrees+1;
					}else{
						int[] leftArray = new int[i];
						
						for(int j=0; j<leftArray.length;j++) {
							leftArray[j] = sortedArray[j];
						}
						
						if(leftArray.length != 0) {
							uniqueTrees += findUniqueBinarySearchTrees(leftArray);
						}
						
						int[] rightArray = new int[sortedArray.length-i-1];
						int r = i+1;
						for(int z=0; z<rightArray.length;z++) {
							rightArray[z] = sortedArray[r];
							r++;
						}
						if(rightArray.length != 0) {
							uniqueTrees += findUniqueBinarySearchTrees(rightArray);
						}
					}
				}
			}
		}
		return uniqueTrees;
	}
	
	public int[] insertionSort(int[] ar) {
		
		for(int i =1; i< ar.length-1;i++) {
			int temp = ar[i];
			int j = i-1;
			
			while(j > 0 && ar[j] > temp ) {
				ar[j+1] = ar[j];
				j--;
			}
			ar[j+1] = temp;
		}
		return ar;
	}
	
	public int uniqueBST(int n) {
		int[] ar = new int[n+1];
		 ar[0] = 1;
		 ar[1] = 1;
		 
		 for(int i=2; i <= n;i++) {
			 for(int j=0;j<i;j++) {
				 ar[i] += ar[j] * ar[i-j-1];
			 }
		 }
		 return ar[n];
	}
	
	@Test
	public void testFindUniqueBinarySearchTrees() {
		
		int unqiue = uniqueBST(1);
		assertEquals(1, unqiue);
		
		unqiue = uniqueBST(2);
		assertEquals(2, unqiue);
		
		unqiue = uniqueBST(3);
		assertEquals(5, unqiue);
		
		unqiue = uniqueBST(4);
		assertEquals(14, unqiue);
		
		unqiue = uniqueBST(5);
		assertEquals(42, unqiue);
	}
}
