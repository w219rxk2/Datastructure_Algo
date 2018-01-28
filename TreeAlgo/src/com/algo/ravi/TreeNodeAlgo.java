package com.algo.ravi;

public class TreeNodeAlgo {
	private int data;
	private TreeNodeAlgo rightChild;
	private TreeNodeAlgo leftChild;
	
	/**
	 * Default Constructor
	 * 
	 * @param data
	 */
	public TreeNodeAlgo(int data) {
		this.data = data;
	}

	/**
	 * @return the rightChild
	 */
	public TreeNodeAlgo getRightChild() {
		return rightChild;
	}

	/**
	 * @param rightChild the rightChild to set
	 */
	public void setRightChild(TreeNodeAlgo rightChild) {
		this.rightChild = rightChild;
	}

	/**
	 * @return the leftChild
	 */
	public TreeNodeAlgo getLeftChild() {
		return leftChild;
	}

	/**
	 * @param leftChild the leftChild to set
	 */
	public void setLeftChild(TreeNodeAlgo leftChild) {
		this.leftChild = leftChild;
	}

	/**
	 * @return the data
	 */
	public int getData() {
		return data;
	}
	
	protected void insert(int data) {
		if(data < this.data) {
			if(leftChild != null) {
				leftChild.insert(data);
			}else {
				leftChild = new TreeNodeAlgo(data);
			}
		}
		
		if(data > this.data) {
			if(rightChild != null) {
				rightChild.insert(data);
			}else {
				rightChild = new TreeNodeAlgo(data);
			}
		}
	}

	protected TreeNodeAlgo find(int data) {
		
		TreeNodeAlgo nodeFound = null;
		
		if(this.data == data) {
			return this;
		}
		
		if(data < this.data && this.leftChild != null) {
			nodeFound =  leftChild.find(data);
		}
		
		if(data > this.data && rightChild != null) {
			nodeFound =  rightChild.find(data);
		}
		
		return nodeFound;
	}
	
	@Override
	public String toString() {
		return "TreeAlgo [data=" + data + ", rightChild=" + rightChild + ", leftChild=" + leftChild + "]";
	}

}
