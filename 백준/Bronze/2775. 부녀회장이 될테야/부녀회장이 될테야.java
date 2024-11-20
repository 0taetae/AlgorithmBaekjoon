import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++) {
			int K = Integer.parseInt(br.readLine());
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N+1];
			int[] pre = new int[N+1];
			for(int i=1;i<=N;i++) {
				pre[i] = i;
			}
			for(int i=1;i<=K;i++) {
				for(int j=1;j<=N;j++) {
					int sum=0;
					for(int s=1;s<=j;s++) {
						sum+=pre[s];
					}
					dp[j] = sum;
				}
				for(int j=1;j<=N;j++) {
					pre[j] = dp[j];
				}
			}
			System.out.println(dp[N]);
			
		}

	}

}
