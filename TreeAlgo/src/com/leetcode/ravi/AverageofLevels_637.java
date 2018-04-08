package com.leetcode.ravi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class AverageofLevels_637 {
	
	// Definition for a binary tree node.
	public class TreeNode {
		int val;
	    TreeNode left;
	    TreeNode right;
	    TreeNode(int x) { val = x; }
	}
	
	private int calculateLevels(TreeNode root) {
		if(root == null) {
			return 0;
		}
		
		int level = 1;
		
		if(root.left != null) {
			level = 1 + calculateLevels(root.left);
		}
		
		if(root.right != null) {
			level = 1 + calculateLevels(root.right);
		}
		
		return level;
		
	}
	
	public List<Double> averageOfLevels(TreeNode root) {
        
		if(root == null) {
			return null;
		}
		List<Double> l = new ArrayList<>(calculateLevels(root));
		
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		
		q1.add(root);
		
		while(q1.size() != 0 || q2.size() != 0) {
			Double d;
			
			if(q1.size() != 0) {
				d = 0.0;
				
				for(TreeNode t : q1){
					d = d + t.val;
				}
				
				d = d/q1.size();
				l.add(d);
			}
			
			while(q1.size() != 0) {
				TreeNode poll = q1.poll();
				
				if(poll != null) {
					if(poll.left != null) {
						q2.add(poll.left);
					}
					
					if(poll.right != null) {
						q2.add(poll.right);
					}
				}
			}
			
			if(q2.size() != 0) {
				d = 0.0;
				
				for(TreeNode t : q2){
					d = d + t.val;
				}
				
				d = d/q2.size();
				l.add(d);
			}
			
			while(q2.size() != 0) {
				TreeNode poll = q2.poll();
				
				if(poll != null) {
					if(poll.left != null) {
						q1.add(poll.left);
					}
					
					if(poll.right != null) {
						q1.add(poll.right);
					}
				}
			}
		}
		return l;
    }
	
	 @Test
	 public void testGetMinimumDifference() {
		AverageofLevels_637 m =  new AverageofLevels_637();
		 
		AverageofLevels_637.TreeNode fl = m.new TreeNode(3);
		
		fl.left = m.new TreeNode(9);
		fl.right = m.new TreeNode(20);
		fl.right.left = m.new TreeNode(15);
		fl.right.right = m.new TreeNode(7);
		
		@SuppressWarnings("unused")
		List<Double> averageOfLevels = averageOfLevels(fl);
		
	 }
}
