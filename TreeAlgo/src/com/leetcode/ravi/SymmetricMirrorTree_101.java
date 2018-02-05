package com.leetcode.ravi;

import com.algo.ravi.binarytree.TreeNodeGeneric;

public class SymmetricMirrorTree_101 {

	/*
	 static ArrayList<Integer> al = new ArrayList<>();

	public static boolean isSymmetric(Node<Integer> treeNode) {
		inOrderRecursive(treeNode);
		ArrayList<Integer> cloneAl = new ArrayList<>(al);
		Collections.reverse(al);
		if (al.equals(cloneAl)) {
			return true;
		}
		return false;
	}
	public static void inOrderRecursive(Node<Integer> root) {
		if (root == null)
			return;
		inOrderRecursive(root.getLeftChild());
		al.add(root.getData());
		inOrderRecursive(root.getRightChild());
	}*/
	
	
	public static boolean isSymmetric(TreeNodeGeneric<Integer> leftChild, TreeNodeGeneric<Integer> rightChild) {
		
		boolean isSymmetric = true;
		if(leftChild != null && rightChild != null) {
			if(leftChild.getData() != rightChild.getData()) {
				isSymmetric = false;
			}
			
			isSymmetric = isSymmetric(leftChild.getLeftChild(), rightChild.getRightChild());
			if(isSymmetric) {
				isSymmetric = isSymmetric(leftChild.getRightChild(), rightChild.getLeftChild());
			}
		
		} else if(leftChild == null && rightChild != null) {
			isSymmetric = false;
		} else if(leftChild != null && rightChild == null) {
			isSymmetric = false;
		} else {
			isSymmetric = true;
		}
		
		return isSymmetric;
	}
	
	public static boolean isSymmetric(TreeNodeGeneric<Integer> root) {
		
		if(root == null) {
			// throw exception cannot be compared.
		}
		
		return isSymmetric(root.getLeftChild(),root.getRightChild());
	}
	
	public static TreeNodeGeneric<Integer> prepareBinaryTree2() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(1);
		root.setLeftChild(new TreeNodeGeneric<Integer>(2));
		root.setRightChild(new TreeNodeGeneric<Integer>(2));
		root.getLeftChild().setRightChild(new TreeNodeGeneric<Integer>(3));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(3));
		return root;
	}
	
	public static TreeNodeGeneric<Integer> prepareBinaryTree3() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(1);
		root.setLeftChild(new TreeNodeGeneric<Integer>(2));
		root.setRightChild(new TreeNodeGeneric<Integer>(2));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(3));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(3));
		return root;
	}
	
	public static TreeNodeGeneric<Integer> prepareBinaryTree1() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(1);
		root.setLeftChild(new TreeNodeGeneric<Integer>(2));
		root.setRightChild(new TreeNodeGeneric<Integer>(2));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(3));
		root.getLeftChild().setRightChild(new TreeNodeGeneric<Integer>(4));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(4));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(3));
		return root;
	}
	
	public static TreeNodeGeneric<Integer> prepareBinaryTree4() {
		TreeNodeGeneric<Integer> root = new TreeNodeGeneric<Integer>(1);
		root.setLeftChild(new TreeNodeGeneric<Integer>(2));
		root.setRightChild(new TreeNodeGeneric<Integer>(2));
		root.getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(3));
		root.getLeftChild().setRightChild(new TreeNodeGeneric<Integer>(4));
		root.getLeftChild().getLeftChild().setLeftChild(new TreeNodeGeneric<Integer>(3));
		root.getRightChild().setLeftChild(new TreeNodeGeneric<Integer>(4));
		root.getRightChild().setRightChild(new TreeNodeGeneric<Integer>(3));
		root.getRightChild().getRightChild().setRightChild(new TreeNodeGeneric<Integer>(3));
		return root;
	}
	
	public static void main(String[] args) {
		TreeNodeGeneric<Integer> root = SymmetricMirrorTree_101.prepareBinaryTree1();
		System.out.println("root.getLeftChild():: " + root.getLeftChild());
		System.out.println("root.getRightChild():: " + root.getRightChild());
		
		System.out.println("Scenario1 output : " + isSymmetric(root.getLeftChild(),root.getRightChild()));
		
		root = SymmetricMirrorTree_101.prepareBinaryTree2();
		
		System.out.println("Scenario1 output : " + isSymmetric(root.getLeftChild(),root.getRightChild()));
		
		root = SymmetricMirrorTree_101.prepareBinaryTree3();
		
		System.out.println("Scenario1 output : " + isSymmetric(root.getLeftChild(),root.getRightChild()));
		
		root = SymmetricMirrorTree_101.prepareBinaryTree4();
		
		System.out.println("Scenario1 output : " + isSymmetric(root.getLeftChild(),root.getRightChild()));
		
		root = new TreeNodeGeneric<Integer>(1);
		root.setLeftChild(new TreeNodeGeneric<Integer>(4));
		root.setRightChild(new TreeNodeGeneric<Integer>(4));
		
		System.out.println("Scenario1 output : " + isSymmetric(root.getLeftChild(),root.getRightChild()));
	}

}
