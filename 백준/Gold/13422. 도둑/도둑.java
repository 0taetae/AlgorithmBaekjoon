import java.io.*;
import java.util.*;

public class Main {
    
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());  // 마을에 있는 집의 개수
			int M = Integer.parseInt(st.nextToken());  // 도둑이 돈을 훔칠 연속된 집의 개수 
			int K = Integer.parseInt(st.nextToken());  // 자동 방범 장치가 작동하는 최소 돈의 양 
			
			int[] money = new int[N];  // 돈의 양
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				money[i] = Integer.parseInt(st.nextToken());
			}
			
			int cnt=0;
			int preSum=0;
			int sum=0;
			if(N==M) {
				for(int i=0;i<M;i++) {
					preSum+=money[i];
				}
				if(preSum<K) {
					cnt++;
				}
			}
			else {
				for(int i=0;i<M;i++) {
					preSum+=money[i];
				}
				if(preSum<K) {
					cnt++;
				}
				for(int i=1;i<N;i++) { // 시작 지점
					sum=preSum;
					sum-=money[i-1];
					sum+=money[(i+M-1)%N];
					if(sum<K) {
						cnt++;
					}
					preSum=sum;
				}
			}
			System.out.println(cnt);
		}
	}

}
