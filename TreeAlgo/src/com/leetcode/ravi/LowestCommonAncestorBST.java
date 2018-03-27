package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class LowestCommonAncestorBST {
	
	public TreeNodeGeneric<Integer> findLowestCommonAncestor(TreeNodeGeneric<Integer> root,
																		TreeNodeGeneric<Integer> n1,
																		TreeNodeGeneric<Integer> n2) {
		if(root == null) {
			return null;
		}
		
		if(root == n1 || root == n2) {
			return root;
		}
		
		TreeNodeGeneric<Integer> left = findLowestCommonAncestor(root.getLeftChild(), n1, n2);
		TreeNodeGeneric<Integer> right = findLowestCommonAncestor(root.getRightChild(), n1, n2);
		
		if(left != null && right != null) {
			return root;
		}
		
		if(left == null && right == null) {
			return null;
		}
		
		return (left != null)?left:right;
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
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(78));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(72));
		root.getRightChild().getRightChild().setRightChild(new TreeNodeGeneric<Integer>(90));
		
		TreeNodeGeneric<Integer> node = findLowestCommonAncestor(root,
																	root.getLeftChild().getLeftChild(), 
																	root.getLeftChild().getRightChild());
		
		assertEquals(new Integer(33), node.getData());
	}
}
