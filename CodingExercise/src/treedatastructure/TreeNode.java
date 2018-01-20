package treedatastructure;

public class TreeNode {

	private Integer data;
	private TreeNode leftChild;
	private TreeNode rightChild;
	
	public TreeNode(Integer data) {
		this.data = data;
	}
	
	public TreeNode find(Integer data) {
		TreeNode dataNode = null;
		if(this.data == data) {
			return this;
		}
		
		if(data < this.data && leftChild != null) {
			dataNode = leftChild.find(data);
		}
		
		if(data > this.data && rightChild != null) {
			dataNode = rightChild.find(data);
		}
		
		return dataNode;
	}
	
	public void insert(Integer data) {
		if(data < this.data) {
			if(leftChild == null) {
				leftChild = new TreeNode(data);
			}else {
				leftChild.insert(data);
			}
		}
		
		if(data > this.data) {
			if(rightChild == null) {
				rightChild = new TreeNode(data);
			}else {
				rightChild.insert(data);
			}
		}

	}
	
	public void delete(Integer data) {
		
	}
	public TreeNode getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNode leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNode getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNode rightChild) {
		this.rightChild = rightChild;
	}

	public Integer getData() {
		return data;
	}
	
}
