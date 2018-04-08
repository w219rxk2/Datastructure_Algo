package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class HasPathSum_112 {
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	int totalSum = 0;
	boolean hasPathSum;
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
        	return false;
        }
        
        if(root.left == null && root.right == null && 0 == sum - root.val) {
        	hasPathSum = true;
        }
        
        //totalSum = totalSum + root.val;
        
        if(! hasPathSum && root.left != null) {
        	 hasPathSum = hasPathSum(root.left, sum- root.val);
    	}
        
        if(! hasPathSum && root.right != null) {
        	 hasPathSum = hasPathSum(root.right, sum-root.val);
        }
        
        return hasPathSum;

	}
	
	 @Test
	 public void testHasPathSum() {
		 HasPathSum_112 m =  new HasPathSum_112();
		 
		 HasPathSum_112.TreeNode fl = m.new TreeNode(5);
		
		//bs.insert(1);
		fl.right = m.new TreeNode(8);
		fl.right.left = m.new TreeNode(13);
		fl.right.right = m.new TreeNode(4);
		fl.right.right.right = m.new TreeNode(1);
		
		fl.left = m.new TreeNode(4);
		fl.left.left = m.new TreeNode(11);
		fl.left.left.left = m.new TreeNode(7);
		fl.left.left.right = m.new TreeNode(2);
		
		boolean hasPath = hasPathSum(fl,22);
		
		assertEquals(true, hasPath);
	 }
}
