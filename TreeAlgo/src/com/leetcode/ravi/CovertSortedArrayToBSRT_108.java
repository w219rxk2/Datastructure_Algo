package com.leetcode.ravi;

import java.util.Arrays;

import org.junit.Test;

import com.algo.ravi.BinarySearchTreeAlgo;
import com.algo.ravi.TreeNodeAlgo;

public class CovertSortedArrayToBSRT_108 {

	public TreeNodeAlgo convert(int[] sortedArray) {
		
		if(sortedArray == null) {
			// throw exception
		}
		
		TreeNodeAlgo root = null;
				
		if(sortedArray.length == 1) {
			root = new TreeNodeAlgo(sortedArray[0]);
		}else {
			int middle = sortedArray.length/2;
			//root = new TreeNodeAlgo(sortedArray[middle]);
			BinarySearchTreeAlgo bs = new BinarySearchTreeAlgo();
			root =  bs.insert(sortedArray[middle]);
			int i = 0;
			while(i <= sortedArray.length-1) {
				if(i != middle) {
					root.insert(sortedArray[i]);
				}
				i++;
			}
		}
		
		return root;
	}
	
	public TreeNodeAlgo convertRecursive(int[] sortedArray) {
		
		TreeNodeAlgo root = null; 
		
		if(sortedArray.length == 0) {
			return root;
		}
		
		int middle = sortedArray.length/2;
		
		int[] firstArray = Arrays.copyOfRange(sortedArray , 0, middle);
		
		int[] secondArray =  Arrays.copyOfRange(sortedArray , middle+1, sortedArray.length);
		
		root = new TreeNodeAlgo(sortedArray[middle]);
		
		root.setLeftChild(convertRecursive(firstArray));
		
		root.setRightChild(convertRecursive(secondArray));
		
		return root;
		

	}
	
	@Test
	public void testConvert() {
		int[] sortedArray = new int[10];
		sortedArray[0] = 0;
		sortedArray[1] = 1;
		sortedArray[2] = 2;
		sortedArray[3] = 3;
		sortedArray[4] = 4;
		sortedArray[5] = 5;
		sortedArray[6] = 6;
		sortedArray[7] = 7;
		sortedArray[8] = 8;
		sortedArray[9] = 9;
		TreeNodeAlgo root = this.convert(sortedArray);
		BinarySearchTreeAlgo bs = new BinarySearchTreeAlgo();
		bs.preOrderTraversal(root);
	}
	
	public static void main(String[] args) {
		CovertSortedArrayToBSRT_108 covertSortedArrayToBSRT_108 = new CovertSortedArrayToBSRT_108();
		int[] sortedArray = new int[10];
		sortedArray[0] = 0;
		sortedArray[1] = 1;
		sortedArray[2] = 2;
		sortedArray[3] = 3;
		sortedArray[4] = 4;
		sortedArray[5] = 5;
		sortedArray[6] = 6;
		sortedArray[7] = 7;
		sortedArray[8] = 8;
		sortedArray[9] = 9;
		TreeNodeAlgo root = covertSortedArrayToBSRT_108.convertRecursive(sortedArray);
		BinarySearchTreeAlgo bs = new BinarySearchTreeAlgo();
		System.out.println(root);
		bs.inOrderTraversal(root);
	}

}
