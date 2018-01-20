package treedatastructure;

public class BinarySearchTree {
	
	private TreeNode rootNode;
	
	public void insert(Integer data) {
		if(rootNode == null) {
			rootNode =  new TreeNode(data);
		} else {
			rootNode.insert(data);
		}
		
	}
	
	public TreeNode find(Integer data) {
		
		TreeNode tempNode = null;
		if(this.rootNode != null) {
			tempNode = rootNode.find(data);
		}
		return tempNode;
		
	}
	
	public void delete(Integer data) {
		TreeNode current = this.rootNode;
		TreeNode parent  = this.rootNode;
		boolean isLeftChild = false;
		if(current == null) {
			return;
		}
		
		while(current != null && current.getData() != data) {
			parent = current;
			
			if(data < current.getData()) {
				isLeftChild = true;
				current = current.getLeftChild();
			}
			
			if(data > current.getData()) {
				current = current.getRightChild();
			}
		}
		
		if(current == null) {
			return;
		}
		
		if(current.getLeftChild() == null && current.getRightChild() == null) {
			
			if(current == rootNode)
			{
				rootNode = null;
			}else {
				if(isLeftChild) {
					parent.setLeftChild(null);
				}else {
					parent.setRightChild(null);
				}
			}
		} else if(current.getLeftChild() != null && current.getRightChild() == null) {
			if(current == rootNode) {
				rootNode = current.getLeftChild();
			}else{
				parent.setLeftChild(current.getLeftChild());
			}
		} else if(current.getRightChild() != null && current.getLeftChild() == null) {
			if(current == rootNode) {
				rootNode = current.getRightChild();
			}else{
				parent.setRightChild(current.getRightChild());
			}
		} 
		
	}
}
