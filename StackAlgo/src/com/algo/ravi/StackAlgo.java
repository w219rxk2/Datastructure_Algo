package com.algo.ravi;

public class StackAlgo<T> {
	
	private int size = 0; 
	private int MAX_SIZE = 40;
	private NodeAlgo<T> top;
	
	public void push(T data) {
		if(size == MAX_SIZE) {
			// throw stack overflow exception
		}
		
		NodeAlgo<T> currentTop = top;
		top = new NodeAlgo<T>(data);;
		top.setNextNode(currentTop);
		
		size++;
	}
	
	public T pop() {
		if(size == 0) {
			// throw stackUnderflowException
		}
		
		T data = top.getData();
		
		top = top.getNextNode();
		
		size--;
		return data;
	}
	
	public T peek() {
		if(size == 0) {
			// throw stackUnderflowException
		}
		
		return top.getData();
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == MAX_SIZE;
	}
	
	public int getSize() {
		return size;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
