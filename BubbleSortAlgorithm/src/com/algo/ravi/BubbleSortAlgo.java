package com.algo.ravi;

public class BubbleSortAlgo {

	public int[] bubbleSortAlgorithm(int[] ar) {
		if(ar == null) {
			return null;
		}
		int temp;
		for(int i = ar.length-1; i > 0 ; i--) {
			for(int j = 0;j < i; j++) {
				if(ar[j] > ar[j+1]) {
					temp = ar[j];
					ar[j] = ar[j+1];
					ar[j+1] = temp;
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
		
		for(int i=0; i<ar.length-1;i++) {
			System.out.print(ar[i] + " ");
		}
		
		BubbleSortAlgo bs = new BubbleSortAlgo();
		int[] sortedArray = bs.bubbleSortAlgorithm(ar);
		System.out.println();
		for(int i=0; i<sortedArray.length-1;i++) {
			System.out.print(sortedArray[i] + " ");
		}
	}

}
