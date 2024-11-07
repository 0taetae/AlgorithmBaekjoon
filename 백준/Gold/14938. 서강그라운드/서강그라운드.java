import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer( br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 지역의 개수
		int M = Integer.parseInt(st.nextToken()); // 수색범위
		int R = Integer.parseInt(st.nextToken());  // 길의 개수
		int[][] dist = new int[N+1][N+1];
		st = new StringTokenizer(br.readLine());
		int[] item = new int[N+1];
		for(int i=1;i<=N;i++) {
			item[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				dist[i][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=0;i<R;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int L = Integer.parseInt(st.nextToken());
			dist[a][b] = L;
			dist[b][a] = L;
		}
		for(int i=1;i<=N;i++) {
			dist[i][i] = 0;
		}
		for(int k=1;k<=N;k++) {
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N;j++) {
					if(i==j) continue;
					if(dist[i][k]!=Integer.MAX_VALUE && dist[k][j]!=Integer.MAX_VALUE) {
						dist[i][j] = Math.min(dist[i][j], dist[i][k]+dist[k][j]);
					}
					
					
				}
			}
		}
		
		int res = 0;
		for(int i=1;i<=N;i++) {
			int ans=0;
			for(int j=1;j<=N;j++) {
				if(dist[i][j]!=0 &&dist[i][j]<=M) {
					ans+=item[j];
				}
			}
			ans+=item[i];
			res = Math.max(res, ans);
		}
		System.out.println(res);
		
	}

}