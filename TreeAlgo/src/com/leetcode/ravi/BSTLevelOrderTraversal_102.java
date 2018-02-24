package com.leetcode.ravi;

import java.util.Stack;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class BSTLevelOrderTraversal_102 {
	public void levelOrderTraversal(TreeNodeGeneric<Integer> root) {
		Stack<TreeNodeGeneric<Integer>> leftTreeStack = new Stack<TreeNodeGeneric<Integer>>();
		Stack<TreeNodeGeneric<Integer>> rightTreeStack = new Stack<TreeNodeGeneric<Integer>>();
		TreeNodeGeneric<Integer> node = null;
		leftTreeStack.add(root);
		int index = 0;
		
		while(!leftTreeStack.isEmpty() || !rightTreeStack.isEmpty()) {
			while(!leftTreeStack.isEmpty()) {
				node = leftTreeStack.remove(index);
				
				System.out.println(node.getData());
				
				if(node.getRightChild() != null) {
					rightTreeStack.add(node.getRightChild());
				}
				
				if(node.getLeftChild() != null) {
					rightTreeStack.add(node.getLeftChild());
					
				}
			}
			
			while(!rightTreeStack.isEmpty()) {
				node = rightTreeStack.pop();
				System.out.println(node.getData());
				
				if(node.getLeftChild() != null) {
					leftTreeStack.add(node.getLeftChild());
				}
				if(node.getRightChild() != null) {
					leftTreeStack.add(node.getRightChild());
				}
				
			}
			
		}
		
	}
	
	@Test
	public void testLevelOrderTraversal() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(3);
		root.setLeftChild(new TreeNodeGeneric<Integer>(9));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(16));
		root.setRightChild(new TreeNodeGeneric<Integer>(20));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(15));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(7));
		
		levelOrderTraversal(root);
	}
}
