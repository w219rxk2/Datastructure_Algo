package com.algo.ravi;

public class InsertionSortAlgo {

	public int[] insertionSort(int[] ar) {
		if(ar == null)
			return null;
		
		int outer,inner,temp;
		
		for(outer = 1;outer < ar.length-1;outer++) {
			
			temp = ar[outer];
			inner = outer-1;
			
				while(inner >= 0 && temp < ar[inner]) {
					ar[inner+1] = ar[inner];
					inner--;
				}
				
			ar[inner+1] = temp;
		}
		return ar;
	}
	
	public int[] insert(int[] actualArray) {
		if(actualArray == null) {
			//throw error
		}
		
		for(int outer = 1 ; outer < actualArray.length; outer++) {
			int compareValue = actualArray[outer];
			int inner = outer-1;
			
			while(inner > 0 && actualArray[inner] > compareValue) {
				actualArray[inner+1] = actualArray[inner];
				inner--;
			}
			actualArray[inner+1] = compareValue;
		}
		return actualArray;
	}
	
	public static void main(String[] args) {
		int[] ar = new int[10];
		
		ar[0] = 1;
		ar[1] = 3;
		ar[2] = 67;
		ar[3] = 7;
		ar[4] = 100;
		ar[5] = 64;
		ar[6] = 5;
		ar[7] = 56;
		ar[8] = 20;
		ar[9] = 2;
		
		for(int i=0; i<ar.length-1;i++) {
			System.out.print(ar[i] + " ");
		}
		
		InsertionSortAlgo bs = new InsertionSortAlgo();
		int[] sortedArray = bs.insertionSort(ar);
		System.out.println();
		for(int i=0; i<sortedArray.length-1;i++) {
			System.out.print(sortedArray[i] + " ");
		}

	}

}
