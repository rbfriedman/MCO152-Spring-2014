package friedman.threads;

import java.math.BigInteger;

public class FactorialThreads {
	public static BigInteger compute(long a){
		BigInteger answer=new BigInteger(String.valueOf(a));
		while(a>1){
			answer = answer.multiply(BigInteger.valueOf(a-=1));
		}
		return answer;
	}
	public static void main(String[] args){
		Thread t1 = new Factorial(3);
		Thread t2 = new Factorial(4);
		
		t1.start();
		t2.start();
	
	}

}
