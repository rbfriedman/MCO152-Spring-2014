package friedman.pi;

public class PI {
private double pi;
private int iterations;
	
	public double computePI(int iterations){
		double num;
		int denom;
		for(int i= 1; i < iterations; i++){
			num =Math.pow(-1,i+1);
			denom = 2*i -1;
			pi +=num/denom;
		}
		return pi = 4 *pi;
	}
	public double getPi() {
		return pi;
	}
	public void setPi(double pi) {
		this.pi = pi;
	}
	public static void main(String[] args){
		PI a = new PI();
		a.computePI(1000);
		System.out.println(a.getPi());
	}
}
