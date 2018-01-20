package recursion;

public class FactorialTest {

	public static int factorial(int n, int result){
		if(n == 0){
			return result;
		}
		return factorial(n-1,result*n);
	}
	public static void main(String[] args) {
		int factorial = FactorialTest.factorial(3,1);
		
		System.out.println("factorial : " + factorial);

	}

}
