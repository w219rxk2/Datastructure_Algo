package com.leetcode.ravi;

import org.junit.Test;

import com.algo.ravi.NodeAlgo;

public class AddNumberUsingLinkedList {
	
	public NodeAlgo<Integer> addNumbers(NodeAlgo<Integer> first, NodeAlgo<Integer> second) {
		NodeAlgo<Integer> newList = null;
		NodeAlgo<Integer> res = null;
		int carry = 0;
		int sum;
		
		while(first != null && second != null) {
			
			sum = carry + (first == null? 0:first.getData()) + (second == null? 0:second.getData());
			carry = (sum >= 10) ? 1:0;
			
			sum = sum % 10;
			
			NodeAlgo<Integer> temp = new NodeAlgo<Integer>(sum);
			
			if(newList == null) {
				newList = temp;
			}else {
				temp.setNextNode(newList);
				newList = temp;
			}
			
			if(first != null) {
				first = first.getNextNode();
			}
			
			if(second != null) {
				second = second.getNextNode();
			}
		}
		
		if(carry == 1) {
			res = new NodeAlgo<Integer>(carry);
			res.setNextNode(newList);
		}else {
			res = newList;
		}
		
		return newList;
	}
	
	public NodeAlgo<Integer> reverseRecursive(NodeAlgo<Integer> head) {
		
		if(head == null) {
			return null;
		}
		
		NodeAlgo<Integer> current = head;
		NodeAlgo<Integer> next    = head.getNextNode();
		
		if(next == null) {
			return head;
		}
		
		NodeAlgo<Integer> newHead = reverseRecursive(next);
		current.setNextNode(null);
		next.setNextNode(current);
		return newHead;
	}
	
	public NodeAlgo<Integer> reverseIterative(NodeAlgo<Integer> head) {
		if(head == null) {
			return null;
		}
		
		NodeAlgo<Integer> current = head;
		NodeAlgo<Integer> previous = null;
		NodeAlgo<Integer> forward = null;
		
		while(current.getNextNode() != null) {
			forward = current.getNextNode();
			current.setNextNode(previous);
			
			previous = current;
			
			current = forward;
		}
		current.setNextNode(previous);
		return current;
	}
	
	public int size(NodeAlgo<Integer> head) {
		
		if(head == null) {
			return 0;
		}
		if(head.getNextNode() == null) {
			return 1;
		}
		
		NodeAlgo<Integer> current = head.getNextNode();
		
		int size = 1;
		while(current != null){
			size = size +1;
			
			current = current.getNextNode();
		}
		return size;
	}

	@Test
	public void testAddNumbers() {
		NodeAlgo<Integer> first = new NodeAlgo<Integer>(2);
		first.setNextNode(new NodeAlgo<Integer>(4));
		first.getNextNode().setNextNode(new NodeAlgo<Integer>(3));
		NodeAlgo<Integer> second = new NodeAlgo<Integer>(5);
		second.setNextNode(new NodeAlgo<Integer>(6));
		second.getNextNode().setNextNode(new NodeAlgo<Integer>(4));
		System.out.println(first);
		System.out.println(second);
		NodeAlgo<Integer> addNumbers = addNumbers(first, second);
		System.out.println(addNumbers);
		NodeAlgo<Integer> reversedList = reverseRecursive(addNumbers);
		System.out.println(reversedList);
		NodeAlgo<Integer> reReversedList = reverseIterative(reversedList);
		System.out.println(reReversedList);
	}
}
