package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class MaximumDepth_BST_104 {
	public int maximumDepth(TreeNodeGeneric<Integer> root) {
		
		if(root == null || (root.getLeftChild() == null && root.getRightChild() == null)) {
			return 0;
		}
		
		int leftMax  = 1 + maximumDepth(root.getLeftChild());
		int rightMax = 1 + maximumDepth(root.getRightChild());
		return Math.max(leftMax, rightMax);
	}
	
	@Test
	public void testMaximumDepth() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(3);
		root.setLeftChild(new TreeNodeGeneric<Integer>(9));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(16));
		root.setRightChild(new TreeNodeGeneric<Integer>(20));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(15));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(7));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(17));
		int maximumDepth = maximumDepth(root);
		assertEquals(3, maximumDepth);
	}
}
