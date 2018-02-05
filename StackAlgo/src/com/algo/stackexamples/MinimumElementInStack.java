package com.algo.stackexamples;

import com.algo.ravi.StackAlgo;

public class MinimumElementInStack {

	public static int findMinimum(int data,StackAlgo<Integer> stack,StackAlgo<Integer> minStack) {
		
		if(stack.getSize() == 0) {
			stack.push(data);
			minStack.push(data);
		}else {
			if(minStack.peek() > data) {
				minStack.pop();
				minStack.push(data);
			}
			stack.push(data);
		}
		
		return minStack.peek();
		
	}
	public static void main(String[] args) {
		StackAlgo<Integer> minStack = new StackAlgo<Integer>();
		StackAlgo<Integer> stack = new StackAlgo<Integer>();
		findMinimum(10,stack,minStack);
		findMinimum(2,stack,minStack);
		findMinimum(3,stack,minStack);
		findMinimum(4,stack,minStack);
		findMinimum(1,stack,minStack);
		findMinimum(0,stack,minStack);
		findMinimum(6,stack,minStack);
		findMinimum(7,stack,minStack);
		int min = findMinimum(8,stack,minStack);
		System.out.println(min);
	}

}
