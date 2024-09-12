import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 물품의 수
		int K = Integer.parseInt(st.nextToken());  // 버틸 수 있는 무게
		
		int[][] dp = new int[N+1][K+1];
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken()); // 각 물건의 무게
			int V = Integer.parseInt(st.nextToken());  // 해당 물건의 가치
			
			if(W<=K) {
				for(int j=0;j<W;j++) {
					dp[i][j] = dp[i-1][j];
				}
				for(int j=W;j<=K;j++) {
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-W]+V);
				}
			}else {  // 물건의 무게가 버틸 수 있는 무게보다 큰 경우
				for(int j=0;j<=K;j++) {
					dp[i][j] = dp[i-1][j];
				}
			}
			
		}
		System.out.println(dp[N][K]);

	}

}