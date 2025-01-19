import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()); // 행렬의 개수
		
		int[][] size = new int[N][2]; // 행렬의 크기
		for(int i=0;i<N;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			size[i][0] = Integer.parseInt(st.nextToken());
			size[i][1] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[N][N];
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				
				if(i==j) {
					dp[i][j]=0;
				}else {
					dp[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		for (int len = 1; len < N; len++) {
            		for (int i = 0; i + len < N; i++) {
                		int j = i + len;
                		for (int k = i; k < j; k++) {
        	    			/* (행렬 i부터 행렬 k까지 곱하는데 드는 최소 비용) + (행렬 k+1부터 행렬 j까지 곱하는데 드는 최소 비용) 
                         		       + 곱셈 비용(행렬 i ~ 행렬 k와 행렬 k+1 ~ 행렬 j를 곱할 때 비용)
                       			    곱셈 비용 = 행렬 i의 행 개수 * 행렬 k의 열 개수 * 행렬 j의 열 개수 
                    			*/
                    			int cost = dp[i][k] + dp[k + 1][j] + size[i][0] * size[k][1] * size[j][1]; 
                    			dp[i][j] = Math.min(dp[i][j], cost);
                		}
            		}
        	}
		System.out.println(dp[0][N-1]);

	}

}
