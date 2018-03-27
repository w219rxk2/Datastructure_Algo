package com.leetcode.ravi;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class MirrorBST {
	public void mirror(TreeNodeGeneric<Integer> root){
		
		if(root == null) {
			return;
		}
		
		if(root.getLeftChild() == null && root.getRightChild() == null) {
			return;
		}
		
		mirror(root.getLeftChild());
		
		mirror(root.getRightChild());
		
		TreeNodeGeneric<Integer> tempNode = root.getLeftChild();
		root.setLeftChild(root.getRightChild());
		root.setRightChild(tempNode);
	}
	
	@Test
	public void testMirror() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(3);
		root.setLeftChild(new TreeNodeGeneric<Integer>(9));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(16));
		root.setRightChild(new TreeNodeGeneric<Integer>(20));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(15));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(7));
		root.getRightChild().getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(17));
		System.out.println(root);
		mirror(root);
		System.out.println(root);
	}
}
