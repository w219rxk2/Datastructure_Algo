package com.leetcode.ravi;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class BTZigzagOrder_103 {
	
	public void zigzagOrder(TreeNodeGeneric<Integer> root) {
		
		if (root == null) {
			return;
		}
		Stack<TreeNodeGeneric<Integer>> stack1 = new Stack<TreeNodeGeneric<Integer>>();
		
		stack1.add(root);
		
		Stack<TreeNodeGeneric<Integer>> stack2 = new Stack<TreeNodeGeneric<Integer>>();
		
		while(!stack1.isEmpty() || !stack2.isEmpty()) {
			while(!stack1.isEmpty()) {
				TreeNodeGeneric<Integer> pop = stack1.pop();
				System.out.println(pop.getData());
				
				if(pop.getLeftChild() != null) {
					stack2.add(pop.getLeftChild());
				}
				
				if(pop.getRightChild() != null) {
					stack2.add(pop.getRightChild());
				}
			}
			
			while(!stack2.isEmpty()) {
				TreeNodeGeneric<Integer> pop = stack2.pop();
				System.out.println(pop.getData());
				
				if(pop.getRightChild() != null) {
					stack1.add(pop.getRightChild());
				}
				
				if(pop.getLeftChild() != null) {
					stack1.add(pop.getLeftChild());
				}
			}
		}
	}
	
	public int maxDepth(TreeNodeGeneric<Integer> root) {
		if(root == null) {
			return 0;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {
			return 0;
		}
		
		int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
		int rightMaxDepth = 1 + maxDepth(root.getRightChild());
		
		return Math.max(leftMaxDepth, rightMaxDepth);
	}
	
	@Test
	public void testZigzagOrder() {
		//[3,9,20,null,null,15,7,17]
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(3);
		root.setLeftChild(new TreeNodeGeneric<Integer>(9));
		root.setRightChild(new TreeNodeGeneric<Integer>(20));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(15));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(7));
		zigzagOrder(root);
	}
	
	@Test
	public void testFindLevels() {
		//[3,9,20,null,null,15,7,17]
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(3);
		root.setLeftChild(new TreeNodeGeneric<Integer>(9));
		root.setRightChild(new TreeNodeGeneric<Integer>(20));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(15));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(7));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(17));
		int levels = maxDepth(root);
		assertEquals(3, levels);
	}
	
}
