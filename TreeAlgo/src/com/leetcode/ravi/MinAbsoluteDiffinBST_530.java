package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.BinarySearchTreeAlgo;
import com.algo.ravi.TreeNodeAlgo;

public class MinAbsoluteDiffinBST_530 {
	
	 // Definition for a binary tree node.
	 public class TreeNode {
		 int val;
	     TreeNode left;
	     TreeNode right;
	     TreeNode(int x) { val = x; }
	     
	     public void inOrderTraversal(TreeNode root) {
	    	 if(root == null) {
	    		 return;
	    	 }
	    	 
	    	 inOrderTraversal(root.left);
	    	 
	    	 System.out.print(root.val + "->");
	    	 
	    	 inOrderTraversal(root.right);
	    	 
	     }
	 }
	 
	 TreeNode prevNode;
	 int min;
	 
	 public int getMinimumDifference(TreeNode root) {
		
		if(root.left != null) {
			prevNode= root;
			min = getMinimumDifference(root.left);
		}else {
			prevNode= root;
		}
		
		min = Math.min(min, Math.abs(prevNode.val - root.val));
		
		if(root.right != null) {
			prevNode = root;
			min = Math.min(min, getMinimumDifference(root.right));
		}else {
			prevNode= root;
		}
		
		int v = Math.min(min, Math.abs(prevNode.val - root.val));
		
		if(min > v ) {
			min = v;
		}
		
		return min; 
	 }
	 
	 @Test
	 public void testGetMinimumDifference() {
		MinAbsoluteDiffinBST_530 m =  new MinAbsoluteDiffinBST_530();
		 
		MinAbsoluteDiffinBST_530.TreeNode fl = m.new TreeNode(1);
		
		//bs.insert(1);
		fl.right = m.new TreeNode(3);
		fl.right.left = m.new TreeNode(2);
		
		fl.inOrderTraversal(fl);
		
		int min = getMinimumDifference(fl);
		
		assertEquals(1, min);
	 }
}
