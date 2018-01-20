package practice;

public class TreeNodeTest<T> {
	
	private T data;
	private TreeNodeTest<T> leftChild;
	private TreeNodeTest<T> rightChild;
	
	public TreeNodeTest(T data) {
		this.data = data;
	}

	public void insert(T data) {
		
		Integer givenData = (Integer) data;
		
		if(givenData < (Integer)this.data) {
			if(leftChild == null) {
				leftChild = new TreeNodeTest<T>(data);
			} else {
				leftChild.insert(data);
			}
		}
		
		if(givenData > (Integer)this.data) {
			if(rightChild == null) {
				rightChild = new TreeNodeTest<T>(data);
			} else {
				rightChild.insert(data);
			}
		}
	}
	
	public TreeNodeTest<T> find(T data) {
		
		TreeNodeTest<T> node = null;
		if(!(data instanceof Integer)) {
			return node;
		}
		
		Integer dataValue = (Integer) data;
		
		if(dataValue < (Integer) this.data && leftChild != null) {
			if(leftChild.getData() == dataValue) {
				node = leftChild;
			}else {
				node = leftChild.find(data);
			}
		}
		
		if(dataValue > (Integer)this.data && rightChild != null) {
			if(rightChild.getData() == dataValue) {
				node = rightChild;
			}else {
				node = rightChild.find(data);
			}
		}
		return node;
	}
	
	public TreeNodeTest<T> getLeftChild() {
		return leftChild;
	}

	public void setLeftChild(TreeNodeTest<T> leftChild) {
		this.leftChild = leftChild;
	}

	public TreeNodeTest<T> getRightChild() {
		return rightChild;
	}

	public void setRightChild(TreeNodeTest<T> rightChild) {
		this.rightChild = rightChild;
	}

	public T getData() {
		return data;
	}

	@Override
	public String toString() {
		return "TreeNodeTest [data=" + data + ", leftChild=" + leftChild + ", rightChild=" + rightChild + "]";
	}
}
