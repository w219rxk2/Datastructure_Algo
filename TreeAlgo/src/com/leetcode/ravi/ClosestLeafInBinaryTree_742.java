package com.leetcode.ravi;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class ClosestLeafInBinaryTree_742 {

	public int ClosestLeaf(TreeNodeGeneric<Character> root) {
		int sum = 0;
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {
			return sum;
		}else {
			sum++;
			sum = sum + Math.min(ClosestLeaf(root.getLeftChild()), ClosestLeaf(root.getRightChild()));
		}
		
		return sum;
		
	}
	
	
	
	public static void main(String[] args) {
		
		ClosestLeafInBinaryTree_742 clIB = new ClosestLeafInBinaryTree_742();
		
		TreeNodeGeneric<Character> tng = new TreeNodeGeneric<Character>('a');
		
		tng.setLeftChild(new TreeNodeGeneric<Character>('b'));
		tng.setRightChild(new TreeNodeGeneric<Character>('c'));
		
		tng.getRightChild().setLeftChild(new TreeNodeGeneric<Character>('e'));
		
		tng.getRightChild().getLeftChild().setLeftChild(new TreeNodeGeneric<Character>('g'));
		
		tng.getRightChild().getLeftChild().getLeftChild().setLeftChild(new TreeNodeGeneric<Character>('i'));
		
		tng.getRightChild().getLeftChild().getLeftChild().setRightChild(new TreeNodeGeneric<Character>('j'));
		
		tng.getRightChild().setRightChild(new TreeNodeGeneric<Character>('f'));
		
		tng.getRightChild().getRightChild().setRightChild(new TreeNodeGeneric<Character>('h'));
		
		tng.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Character>('k'));
		
		int closest = clIB.ClosestLeaf(tng);
		
		System.out.println(closest);
		
	}

}
