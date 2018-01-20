package stackandqueues;

import java.util.Arrays;

public class StackExample {
	private int size;
    private int[] stackAr;
    private int count; // top of stack
    
    public StackExample(int size) {
    	this.size = size;
    	this.stackAr = new int[this.size]; // Creation of Stack array
    	this.count = -1;					   // initialize Stack to with -1
    }
    
    //push method
    public void push(int data) {
    	if(this.count == this.size-1)
    	{
    		System.out.println("Stack is full");
    		return;
    	}
    	
    	count++;
    	stackAr[count] = data;
    }
    
    //pop method
    public int pop(){
    	int poppedElement = -1;
    	if(count == -1)
    	{
    		System.out.println("There are no elements to pop");
    	}else if(count >= 0) {
    		poppedElement = stackAr[count--];
    	}
    	return poppedElement;
    }
    
    // peek operation
    public int peek() {
    	int elementOnTop = -1;
    	if(count==-1) {
    		System.out.println("No elements in stack..");
    	}else {
    		elementOnTop = stackAr[count];
    	}
    	return elementOnTop;
    }
	@Override
	public String toString() {
		return "StackExample [stackAr=" + Arrays.toString(stackAr) + "]";
	}
}
