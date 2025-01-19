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
		
		for(int i=1;i<N;i++) {
			for(int j=0;j+i<N;j++) {
				for(int k=j;k<i+j;k++) {
					dp[j][i+j] = Math.min(dp[j][i+j],dp[j][k]+dp[k+1][i+j]+size[j][0] * size[k][1]*size[i+j][1]);
				}
			}
		}
		System.out.println(dp[0][N-1]);

	}

}
