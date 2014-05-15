package friedman.prime;

import java.util.ArrayList;
import java.util.List;

public class Prime {
private List<Integer> primeNums;
	public Prime() {
		// TODO Auto-generated constructor stub
	}
	public boolean isPrime(int num){
		for( int i =1; i <num;i++){
			if(num%i==0){
				return false;
			}
		}
		return true;
	}
	public List<Integer> computePrime(int num){
		List<Integer> primes = new ArrayList<>();

		for (int i = 1; i < num; i++) {
			if (isPrime(i)) {
				primes.add(i);

			}
		}
		return primes;

	}

}
