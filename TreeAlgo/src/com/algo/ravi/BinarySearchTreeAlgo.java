package com.algo.ravi;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeAlgo {

	public TreeNodeAlgo root;
	
	/**
	 * BinarySearchTree containes three basic operations
	 * 1. insert
	 * 2. find
	 * 3. delete
	 */
	
	/**
	 * Insert method
	 */
	public TreeNodeAlgo insert(int data) {
		
		if(root == null) {
			root = new TreeNodeAlgo(data);
		}else {
			root.insert(data);
		}
		return root;
	}
	
	/**
	 * Insert Iterative
	 */
	public TreeNodeAlgo insertIterative(int data) {
		if(root == null) {
			root = new TreeNodeAlgo(data);
		}else {
			TreeNodeAlgo current = root;
			
			 while(current != null) {
				 if(data > current.getData() ) {
					 if(current.getRightChild() != null) {
						 current = current.getRightChild();
					 }else {
						 current.setRightChild(new TreeNodeAlgo(data));
						 current = current.getRightChild().getRightChild();
					 }
				 } else if(data < current.getData()) {
					 if(current.getLeftChild() != null) {
						 current = current.getLeftChild();
					 }else {
						 current.setLeftChild(new TreeNodeAlgo(data));
						 current = current.getLeftChild().getLeftChild();
					 }
				 }
			 }
		}
		System.out.println(root);
		return root;
	}
	/**
	 * Find method.
	 */
	public TreeNodeAlgo find(int data) {

		if(root == null) {
			return null;
		}
		return root.find(data);
		
	}
	
	/**
	 * find iterative.	
	 */
	public TreeNodeAlgo findIterative(int data) {
		if(root == null) {
			return null;
		}
		
		TreeNodeAlgo current = root;
		
		while(current != null && current.getData() != data) {
			if(current.getData() < data) {
				current = current.getRightChild();
			}else {
				current = current.getLeftChild();
			}
		}
		
		if(current == null) {
			return null;
		}
		return current;
	}
	
	public TreeNodeAlgo deleteIterative(int data) {
		
		TreeNodeAlgo current = root;
		TreeNodeAlgo parent = root;
		boolean isLeftChild = false;
		
		if(root == null) {
			return null;
		}
		
		while(current != null && current.getData() != data) {
			if(data < current.getData()) {
				parent = current;
				current = current.getLeftChild();
				isLeftChild = true;
			} else {
				parent = current;
				current = current.getRightChild();
				isLeftChild = false;
			}
		}
		
		if(current == null) {
			return null;
		}
		
		/**
		 * Deleting a node has three important parts in it.
		 * 1. if node found has no children (leaf Node).
		 * 2. if node found has one child node(either left or right child).
		 * 3. if node found has two child node (left child and right child).		
		 */
		
		// first part
		if(current.getLeftChild() == null && current.getRightChild() == null) {
			if(root == current) {
				root = null;
			} else {
				if(isLeftChild) {
					parent.setLeftChild(null);
				}else {
					parent.setRightChild(null);
				}
			}
		} else if(current.getLeftChild() != null  && current.getRightChild() == null) { // second part
			if(root == current) {
				root = current.getLeftChild();
			}else {
				if(isLeftChild) {
					parent.setLeftChild(current.getLeftChild());
				}else {
					parent.setRightChild(current.getLeftChild());
				}
			}
		} else if(current.getRightChild() != null  && current.getLeftChild() == null) { // second part
			if(root == current) {
				root = current.getRightChild();
			}else {
				if(isLeftChild) {
					parent.setLeftChild(current.getRightChild());
				}else {
					parent.setRightChild(current.getRightChild());
				}
			}
		} else { // third part
			TreeNodeAlgo successor = findSuccessor(current);
			successor.setLeftChild(current.getLeftChild());
			
			if(root == current) {
				root = successor;
			}else {
				if(isLeftChild) {
					parent.setLeftChild(successor);
				}else {
					parent.setRightChild(successor);
				}
			}
		}
		
		return root;
	}
	
	private TreeNodeAlgo findSuccessor(TreeNodeAlgo current) {
		TreeNodeAlgo replaceNode = current;
		TreeNodeAlgo successor = current.getRightChild();
		TreeNodeAlgo parentOfSuccessor = current;
		 
		while(successor.getLeftChild() != null) {
			parentOfSuccessor = successor;
			successor = successor.getLeftChild();
		}
		
		if(successor != current.getRightChild()) {
			successor.setLeftChild(replaceNode.getLeftChild());
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(replaceNode.getRightChild());
		}
		
		return successor;
	}

	public static void main(String[] args) {
		

	}
	
	@Test
	public void testInsertMethod() {
		BinarySearchTreeAlgo bs = new BinarySearchTreeAlgo();
		bs.insertIterative(1);
		bs.insertIterative(3);
		bs.insertIterative(5);
		
		TreeNodeAlgo nodeFound = bs.find(2);
		assertEquals("node with current data doesn't exist",null,nodeFound);
		
		nodeFound = bs.find(5);
		assertEquals("node with current data exist",5,nodeFound.getData());
		
		nodeFound = bs.findIterative(5);
		assertEquals("node with current data exist",5,nodeFound.getData());
		
		nodeFound = bs.findIterative(2);
		assertEquals("node with current data doesn't exist",null,nodeFound);
	}

}
