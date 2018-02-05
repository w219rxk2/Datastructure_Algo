package com.algo.ravi;

public class NodeAlgo<T> {
	private T data;
	private NodeAlgo<T> nextNode;
	
	public NodeAlgo(T data) {
		this.data = data;
	}
	
	public T getData() {
		return data;
	}

	public NodeAlgo<T> getNextNode() {
		return nextNode;
	}
	
	public void setNextNode(NodeAlgo<T> nextNode) {
		this.nextNode = nextNode;
	}
	
}
