package com.algo.ravi;

public class SelectionSortAlgo {

	public int[] selectionSort(int[] ar) {
		if(ar == null) {
			return null;
		}
		int temp;
		for(int i =0;i<ar.length-1;i++) {
			for(int j=i+1;j<ar.length-1;j++) {
				if(ar[i] > ar[j]) {
					temp = ar[i];
					ar[i] = ar[j];
					ar[j] = temp;
				}
			}
		}
		return ar;
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
		
		// iterate over the array elements
		for(int i=0; i<ar.length-1;i++) {
			System.out.print(ar[i] + " ");
		}
		
		SelectionSortAlgo bs = new SelectionSortAlgo();
		int[] sortedArray = bs.selectionSort(ar);
		
		// iterate over the sorted array elements.
		System.out.println();
		for(int i=0; i<sortedArray.length-1;i++) {
			System.out.print(sortedArray[i] + " ");
		}

	}

}
