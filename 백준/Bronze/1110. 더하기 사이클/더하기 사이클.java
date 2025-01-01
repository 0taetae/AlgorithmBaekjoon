import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int start = N;
        int cnt = 0;
        
        while(true) {
	    	int ten = N / 10;
	        int one = N % 10;
	        int sum = ten + one;
	        N = (one * 10) + (sum % 10);
	        cnt++;
	        if(N==start) break;
        }
        System.out.println(cnt);

	}

}
