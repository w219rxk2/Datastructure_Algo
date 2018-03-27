package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class MinumumDepthOfBST {
	public int findMinimumDepth(TreeNodeGeneric<Integer> root) {
		if(root == null) {
			return 0;
		}
		int left = 0;
		int right = 0;
		
		if(root.getLeftChild() != null) {
			left = 1 + findMinimumDepth(root.getLeftChild());
		}
		
		if(root.getRightChild() != null) {
			right = 1 + findMinimumDepth(root.getRightChild());
		}
		
		if(left == 0) {
			return right;
		}else if(right == ) {
			
		}
		return Math.min(left, right);
	}
	
	@Test
	public void testLongestPalindrome() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(52);
		root.setLeftChild(new TreeNodeGeneric<Integer>(33));
		root.setRightChild(new TreeNodeGeneric<Integer>(65));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(25));
		root.getLeftChild().setRightChild(new TreeNodeGeneric<Integer>(39));
		root.getLeftChild().getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(12));
		root.getLeftChild().getLeftChild().setRightChild(new TreeNodeGeneric<Integer>(27));
		root.getLeftChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(34));
		root.getLeftChild().getRightChild().setRightChild(new TreeNodeGeneric<Integer>(48));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(60));
		root.getRightChild().getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(89));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(78));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(72));
		root.getRightChild().getRightChild().setRightChild(new TreeNodeGeneric<Integer>(90));
		
		int minDepth = findMinimumDepth(root);
		
		assertEquals(3, minDepth);
	}
}
