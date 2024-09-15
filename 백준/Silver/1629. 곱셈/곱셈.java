import java.util.*;
 
public class Main {
 
	static long C;
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
		long A = in.nextLong();
		long B = in.nextLong();
		C = in.nextLong();
		
		System.out.println(pow(A, B));
	}
	public static long pow(long A, long exp) {
		if(exp == 1) {
			return A % C;
		}
		long temp = pow(A, exp / 2);
		if(exp % 2 == 1) {
			return (temp * temp % C) * A % C;
		}
		return temp * temp % C;
		
	}
	
}