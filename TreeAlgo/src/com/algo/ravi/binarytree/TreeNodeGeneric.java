package com.algo.ravi.binarytree;

public class TreeNodeGeneric<T> {
	
	private T data;
	private TreeNodeGeneric<T> leftChild;
	private TreeNodeGeneric<T> rightChild;
	
	public TreeNodeGeneric(T data) {
		this.data = data;
	}

	/**
	 * @return the leftChild
	 */
	public TreeNodeGeneric<T> getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNodeGeneric<T> leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the rightChild
	 */
	public TreeNodeGeneric<T> getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNodeGeneric<T> rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * @return the data
	 */
	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "TreeNodeGeneric [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}
