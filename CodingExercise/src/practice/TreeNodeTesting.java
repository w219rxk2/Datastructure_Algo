package practice;

import org.junit.Test;

public class TreeNodeTesting {
	
/*	@Test
	public void deleteElementRecursiveTest() {
		TreeNodeTest<Integer> rootNode = populateBinarySearchTree();
		BinarySearchTreeOperations<Integer> deleteElement = new BinarySearchTreeOperations<Integer>();
		rootNode = deleteElement.delete(34);
		deleteElement.inOrderRecursive(rootNode);
	}*/
	
	private static TreeNodeTest<Integer> populateBinarySearchTree( BinarySearchTreeOperations<Integer> binarySearchTree) {
		TreeNodeTest<Integer> rootNode = null;
		rootNode = binarySearchTree.insert(52);
		binarySearchTree.insert(33);
		binarySearchTree.insert(65);
		binarySearchTree.insert(25);
		binarySearchTree.insert(39);
		binarySearchTree.insert(60);
		binarySearchTree.insert(78);
		binarySearchTree.insert(72);
		binarySearchTree.insert(90);
		binarySearchTree.insert(12);
		binarySearchTree.insert(27);
		binarySearchTree.insert(34);
		binarySearchTree.insert(48);
		binarySearchTree.insert(49);
		// binarySearchTree.insertionIterative(rootNode, 47);
		return rootNode;
	}
	
	public static void main(String[] args) {
		BinarySearchTreeOperations<Integer> binarySearchTree = new BinarySearchTreeOperations<Integer>();
		TreeNodeTest<Integer> rootNode = populateBinarySearchTree(binarySearchTree);
		binarySearchTree.inOrderRecursive(rootNode);
		System.out.println(" ");
		rootNode = binarySearchTree.delete(34);
		binarySearchTree.inOrderRecursive(rootNode);
		System.out.println(" ");
		rootNode = binarySearchTree.delete(48);
		binarySearchTree.inOrderRecursive(rootNode);
		System.out.println(" ");
		rootNode = binarySearchTree.delete(33);
		binarySearchTree.inOrderRecursive(rootNode);
		/*
		BinarySearchTreeOperations<Integer> binarySearchTree = new BinarySearchTreeOperations<Integer>();
		TreeNodeTest<Integer> rootNode = null;
		
		binarySearchTree.insert(12);
		
		binarySearchTree.insert(33);
		binarySearchTree.insert(65);
		binarySearchTree.insert(25);
		binarySearchTree.insert(39);
		binarySearchTree.insert(60);
		binarySearchTree.insert(78);
		binarySearchTree.insert(72);
		binarySearchTree.insert(90);
		binarySearchTree.insert(12);
		binarySearchTree.insert(27);
		binarySearchTree.insert(34);
		rootNode = binarySearchTree.insert(48);
		
		binarySearchTree.insert(50);
		binarySearchTree.insert(30);
		binarySearchTree.insert(20);
		binarySearchTree.insert(40);
		binarySearchTree.insert(70);
		binarySearchTree.insert(60);
		rootNode = binarySearchTree.insert(80);
		
		System.out.println("rootNode " + rootNode);
		
		//TreeNodeTest<Integer> findWithIteration = binarySearchTree.find(78);
		
//		System.out.println("rootNode " + findWithIteration);
//		binarySearchTree.inOrderRecursive(rootNode);
		//System.out.println("rootNode " + rootNode);
		//12 25 27 33 34 39 48 60 65 72 78 90 
		//12 25 27 33 34 39 48 60 65 72 78 90
		//12 25 27 33 34 39 48 60 65 72 78 90 
		//rootNode TreeNodeTest [data=78, leftChild=TreeNodeTest [data=72, leftChild=null, rightChild=null], rightChild=TreeNodeTest [data=90, leftChild=null, rightChild=null]]


	*/}

}
