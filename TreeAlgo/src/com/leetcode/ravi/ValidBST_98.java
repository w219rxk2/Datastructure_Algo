package com.leetcode.ravi;

import org.junit.Test;

import com.algo.ravi.TreeNodeAlgo;

public class ValidBST_98 {
	public boolean validBST(TreeNodeAlgo root) {
		
		if(root != null) {
			if(root.getLeftChild() != null && root.getLeftChild().getData() > root.getData()) {
				return false;
			}
			
			if(root.getRightChild() != null &&root.getRightChild().getData() < root.getData() ) {
				return false;
			}
		}
		
		if(root == null) {
			return true;	
		}
		
		return (validBST(root.getLeftChild()) && validBST(root.getRightChild()));
	}
	
	@Test
	public void testValidateBstPositiveCase() {
		TreeNodeAlgo root = populateBinaryTree();
		System.out.println(validBST(root));
	}

	@Test
	public void testValidateBstNegativeCase() {
		TreeNodeAlgo root = populateBinaryTreeManual();
		System.out.println(validBST(root));
	}
	
	/**
	 * Api method to populate Binary Tree
	 * 
	 * @return
	 */
	private static TreeNodeAlgo populateBinaryTree() {
		TreeNodeAlgo root = new TreeNodeAlgo(52);
		root.setLeftChild(new TreeNodeAlgo(33));
		root.setRightChild(new TreeNodeAlgo(65));
		root.getLeftChild().setLeftChild(new TreeNodeAlgo(25));
		root.getLeftChild().setRightChild(new TreeNodeAlgo(39));
		root.getLeftChild().getLeftChild().setLeftChild(new TreeNodeAlgo(12));
		root.getLeftChild().getLeftChild().setRightChild(new TreeNodeAlgo(27));
		root.getLeftChild().getRightChild().setLeftChild(new TreeNodeAlgo(34));
		root.getLeftChild().getRightChild().setRightChild(new TreeNodeAlgo(48));
		root.getRightChild().setLeftChild(new TreeNodeAlgo(60));
		root.getRightChild().setRightChild(new TreeNodeAlgo(78));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeAlgo(72));
		root.getRightChild().getRightChild().setRightChild(new TreeNodeAlgo(90));
		return root;
	}

	/**
	 * Api method to populate Binary Tree
	 * 
	 * @return
	 */
	private static TreeNodeAlgo populateBinaryTreeManual() {
		TreeNodeAlgo root = new TreeNodeAlgo(52);
		root.setLeftChild(new TreeNodeAlgo(33));
		root.setRightChild(new TreeNodeAlgo(65));
		root.getLeftChild().setLeftChild(new TreeNodeAlgo(55));
		root.getLeftChild().setRightChild(new TreeNodeAlgo(100));
		root.getRightChild().setLeftChild(new TreeNodeAlgo(6));
		root.getRightChild().setRightChild(new TreeNodeAlgo(7));
		return root;
	}
}
