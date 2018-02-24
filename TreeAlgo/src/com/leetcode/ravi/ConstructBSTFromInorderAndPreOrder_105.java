package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class ConstructBSTFromInorderAndPreOrder_105 {
	public TreeNodeGeneric<Integer> constructBinaryTree(int[] preOrder, int[] inOrder) {
		
		if(preOrder.length != inOrder.length) {
			//throw illegalArguments exception
		}
		
		TreeNodeGeneric<Integer> root = findRootIndexRecursive(inOrder, preOrder, 0);
		
		return root;
	}
	
	private TreeNodeGeneric<Integer> findRootIndexRecursive(int[] inOrderArray, int[] preOrder, int l) {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(preOrder[l]);
		
		if(inOrderArray.length == 1) {
			return root;
		}
		
		int i = -1;
		for(i=0; i< inOrderArray.length-1; i++) {
			if(preOrder[l] == inOrderArray[i]) {
				break;
			}
		}
		
		if(i == -1) {
			//throw given array are not ordering of same trees
		}
		
		int[] leftTree = new int[i];
		int[] rightTree = new int[inOrderArray.length-i-1];
		
		int z;
		for(z = 0; z<leftTree.length; z++) {
			leftTree[z] = inOrderArray[z];
		}
		z = z+1;
		for(int r =0; r < rightTree.length;r++, z++) {
			rightTree[r] = inOrderArray[z];
		}
		
		root.setLeftChild(findRootIndexRecursive(leftTree, preOrder, ++l));
		root.setRightChild(findRootIndexRecursive(rightTree, preOrder, ++l));
		return root;
	}
	
	@Test
	public void testMaximumDepth() {
		int[] inOrder = {9,3,15,20,7};
		int[] preOrder = {3,9,20,15,7};
		
		TreeNodeGeneric<Integer> root = constructBinaryTree(preOrder, inOrder);
		System.out.println(root);
	}
}
