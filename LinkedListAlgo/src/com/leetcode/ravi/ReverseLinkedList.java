package com.leetcode.ravi;

import org.junit.jupiter.api.Test;

import com.algo.ravi.NodeAlgo;

public class ReverseLinkedList {
	
	public NodeAlgo<String> reverseRecursive(NodeAlgo<String> head) {
		if(head == null) {
			return null;
		}
		
		if(head.getNextNode() == null) {
			return head;
		}
		
		NodeAlgo<String> current = head;
		NodeAlgo<String> next = head.getNextNode();
		current.setNextNode(null);
		NodeAlgo<String> reverse = reverseRecursive(next);
		next.setNextNode(current);
		
		return reverse;
	}
	
	public NodeAlgo<String> reverseIterative(NodeAlgo<String> head) {
		if(head == null) {
			return null;
		}
		
		NodeAlgo<String> current = head;
		NodeAlgo<String> forward = null;
		NodeAlgo<String> previous = null;
		
		while(current.getNextNode() !=null) {
			
			// Saving reference of next node, since we are changing current node
			forward = current.getNextNode();
			
			// Inserting node at start of new list
			current.setNextNode(null);
			previous = current;
			
			// Advancing to next node
			current = forward;
		}
		
		current.setNextNode(previous);
		
		return current;
	}
	
	@Test
	public void testReverseRecursiveAndIterative() {
		NodeAlgo<String> head = new NodeAlgo<String>("a");
		head.setNextNode(new NodeAlgo<String>("b"));
		head.getNextNode().setNextNode(new NodeAlgo<String>("c"));
		head.getNextNode().getNextNode().setNextNode(new NodeAlgo<String>("d"));
		head.getNextNode().getNextNode().getNextNode().setNextNode(new NodeAlgo<String>("e"));
		System.out.println(head);
		NodeAlgo<String> reverse = reverseRecursive(head);
		System.out.println(reverse);
		NodeAlgo<String> reReverse = reverseIterative(reverse);
		System.out.println(reReverse);
	}
}
