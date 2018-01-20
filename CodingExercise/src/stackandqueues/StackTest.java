package stackandqueues;

public class StackTest {

	public static void main(String[] args) {
		int size = 9;
		StackExample s = new StackExample(size);
		s.push(2);
		s.push(3);
		s.push(4);
		s.push(5);
		s.push(5);
		s.push(6);
		s.push(4);
		s.push(100);
		s.push(120);
		s.push(140);
		System.out.println("s value -> " + s);
		
		int pop = s.pop();
		
		System.out.println("popped element " + pop);
		s.push(140);
		System.out.println("s value -> " + s);
		pop = s.peek();
		System.out.println("peeked element " + pop);
		System.out.println("s value -> " + s);
	}

}
