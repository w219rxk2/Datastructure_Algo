package practice;

public class BinarySearchTreeOperations<T> {
	private TreeNodeTest<T> root;
	
	public TreeNodeTest<T> findWithIteration(T data) {
		TreeNodeTest<T> nodeFound = null;
		TreeNodeTest<T> current = root;
		Integer givenData = (Integer) data;
		
		if(root == null) {
			return nodeFound;
		}
		
		while(current != null && current.getData() != givenData) {
			if(givenData < (Integer)current.getData()) {
				current = current.getLeftChild();
			}
			
			if(givenData > (Integer)current.getData()) {
				current = current.getRightChild();
			}
		}
		
		if(current == null) {
			return nodeFound;
		}
		
		return current;
	}
	
	@SuppressWarnings("unchecked")
	public TreeNodeTest<T> insertWithIteration(T data) {
		
		Integer givenData = (Integer) data;
		TreeNodeTest<Integer> current = (TreeNodeTest<Integer>)root;
		
		if(root == null) {
			root = new TreeNodeTest<T>(data);
		}
		
		while(current != null && current.getData() != givenData) {
			if(givenData < current.getData()) {
				if(current.getLeftChild() == null) {
					current.setLeftChild(new TreeNodeTest<Integer>(givenData));
					current = current.getLeftChild().getLeftChild();
				} else {
					current = current.getLeftChild();
				}
			} else if(givenData > current.getData()){
				if(current.getRightChild() == null) {
					current.setRightChild(new TreeNodeTest<Integer>(givenData));
					current = current.getRightChild().getRightChild();
				} else {
					current = current.getRightChild();
				}
			}
			
		}
		return root;
	}
	
	public TreeNodeTest<T> insert(T data) {
		
		if(root == null) {
			root = new TreeNodeTest<T>(data);
		} else {
			root.insert(data);
		}
		return root;
	}
	
	/**
	 * This method find whether the given data is present in tree 
	 * if exists returns that node.
	 * @param data
	 * @return {@link TreeNodeTest}
	 */
	public TreeNodeTest<T> find(T data) {
		
		TreeNodeTest<T> nodeFound = null;
		
		if(root.getData() == data) {
			nodeFound = root;
		} else {
			nodeFound = root.find(data);
		}
		return nodeFound;
	}
	
	public TreeNodeTest<T> delete(T data) {
		Integer dataToBeDeleted = (Integer) data;
		TreeNodeTest<T> current = root;
		TreeNodeTest<T> parent 	= root;
		boolean isLeftChild = false;
		
		if(root == null){
			return root;
		}
		
		while(current != null && current.getData() != data) {
			parent = current;
			if(dataToBeDeleted < (Integer)current.getData()) {
				isLeftChild = true;
				current = current.getLeftChild();
			}
			
			if(dataToBeDeleted > (Integer)current.getData()) {
				current = current.getRightChild();
			}
		}
		
		if(current == null) {
			return root;
		}
		
		if(current.getLeftChild() == null && current.getRightChild() == null) {
			if(current == root) {
				root = null;
			} else if (isLeftChild) {
				parent.setLeftChild(null);
			} else {
				parent.setRightChild(null);
			}
		} else if (current.getLeftChild() != null && current.getRightChild() == null) {
			if(current == root) {
				root = root.getLeftChild();
			} else {
				parent.setLeftChild(current.getLeftChild());
			}
		} else if (current.getRightChild() != null && current.getLeftChild() == null) {
			if(current == root) {
				root = root.getRightChild();
			} else {
				parent.setRightChild(current.getRightChild());
			}
		} else if(current.getLeftChild() != null  && current.getRightChild() != null) {
			TreeNodeTest<T> replaceNode = current.getRightChild();
			TreeNodeTest<T> previousNode = current.getRightChild();
			while(replaceNode.getLeftChild() != null) {
				previousNode = replaceNode;
				replaceNode = replaceNode.getLeftChild();
			}
			
			if(current == root) {
				replaceNode.setLeftChild(root.getLeftChild());
				replaceNode.setRightChild(root.getRightChild());
				previousNode.setLeftChild(null);
				root = replaceNode;
			} else {
				replaceNode.setLeftChild(current.getLeftChild());
				replaceNode.setRightChild(current.getRightChild());
				previousNode.setLeftChild(null);
				if (isLeftChild) {
					parent.setLeftChild(replaceNode);
				} else {
					parent.setRightChild(replaceNode);
				}
			}
		}
		return this.root;
	}
	
	
	@SuppressWarnings("unchecked")
	public void deleteNode(Integer data) {
		TreeNodeTest<Integer> current = (TreeNodeTest<Integer>) this.root;
		TreeNodeTest<Integer> parent = (TreeNodeTest<Integer>) this.root;
		boolean isLeftChild = false;
		
		if(root == null) {
			return;
		}
		
		while(current != null && current.getData() != data) {
			if(data < current.getData()) {
				parent = current;
				current = current.getLeftChild();
				isLeftChild = true;
			} 
			
			if(data > current.getData()) {
				parent = current;
				current = current.getRightChild();
			}
		}
		
		if(current == null) {
			return;
		}
		
		if(current.getLeftChild() == null && current.getRightChild() == null) {
			if(current == root) {
				root = null;
			}else {
				if(isLeftChild) {
					parent.setLeftChild(null);
				}else {
					parent.setRightChild(null);
				}
			}
		}else if( current.getRightChild() == null) {
			if(current == root) {
				root = (TreeNodeTest<T>) current.getLeftChild();
			}else if (isLeftChild) {
				parent.setLeftChild(current.getLeftChild());
			} else {
				parent.setRightChild(current.getLeftChild());
			}
		}else if (current.getLeftChild() == null) {
			if(current == root) {
				root = (TreeNodeTest<T>) current.getRightChild();
			} else if (isLeftChild) {
				parent.setLeftChild(current.getRightChild());
			} else {
				parent.setRightChild(current.getRightChild());
			}
		}else {
			TreeNodeTest<Integer> successor = getSuccessor(current);
			if (current == root)
				root = (TreeNodeTest<T>) successor;
			else if (isLeftChild) {
				parent.setLeftChild(successor);
			} else {
				parent.setRightChild(successor);
			}
			successor.setLeftChild(current.getLeftChild());
		}
	}
	
	private TreeNodeTest<Integer> getSuccessor(TreeNodeTest<Integer> node) {
		
		TreeNodeTest<Integer> successor 	   = node;
		TreeNodeTest<Integer> parentOfSuccessor   = node;
		TreeNodeTest<Integer> current  = node.getRightChild();
		
		while(current != null) {
			parentOfSuccessor = current;
			successor = current;
			current = current.getLeftChild();
		}
		
		if(successor != node.getRightChild()) {
			parentOfSuccessor.setLeftChild(successor.getRightChild());
			successor.setRightChild(node.getRightChild());
		}
		
		return successor;
	}

	@Override
	public String toString() {
		return "BinarySearchTreeOperations [root=" + root + "]";
	}
}
