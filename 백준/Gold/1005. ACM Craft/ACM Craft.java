import java.io.*;
import java.util.*;

public class Main {
	
	static int N,K;
	static int[] time;
	static List<List<Integer>> list;
	static int[] deg;
	static int W;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 건물 개수
			K = Integer.parseInt(st.nextToken());  // 건물간의 건설순서 규칙의 개수 
			
			time = new int[N+1]; // 각 건물당 건설에 걸리는 시간 
			st = new StringTokenizer(br.readLine());
			for(int i=1;i<=N;i++) {
				time[i] = Integer.parseInt(st.nextToken());
			}
			
			list = new ArrayList<>();
			for(int i=0;i<=N;i++) {
				list.add(new ArrayList<>());
			}
			
			deg = new int[N+1];
			
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				list.get(X).add(Y);
				deg[Y]++;
			}
			
			W = Integer.parseInt(br.readLine()); // 건설해야할 건물의 번호 
			
			bfs();
		}

	}
	public static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		int[] dp = new int[N+1];  // 건물을 건설하는데 걸리는 최소 시간 
		
		for(int i=1;i<=N;i++) {
			dp[i] = time[i];
			if(deg[i]==0) { // 차수가 0인 경우 
				q.offer(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next:list.get(cur)) {
				dp[next] = Math.max(dp[next],dp[cur]+time[next]);
				deg[next]--;
				if(deg[next]==0) { // 차수가 0인 경우 
					q.offer(next);
				}
			}
		}
		
		System.out.println(dp[W]);
	}

}
