package friedman.threads;

public class Factorial extends Thread{
	private int n;
	public Factorial(int n){
		this.n = n;
	}

	/*
	 * Everything you want thread to do, you put in the run method
	 * 
	 * Do not execute thread by calling run directly. You have to tell the JVM
	 * that you want the OS to run your thread, via, start()
	 */
	@Override
	public void run(){
		super.run();
		System.out.println(compute(n));
	}
	public long compute(int a){
		long answer=a;
		while(a>1){
			answer *= --a;
		}
		return answer;
	}
}
