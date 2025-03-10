import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,K,X;
	static List<Integer>[] adj;
	static int[] dist;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호 
		
		adj = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<>();
		}
		dist = new int[N+1];
		Arrays.fill(dist, -1);
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			adj[start].add(end);
		}
		bfs(X);
		
		boolean isOk = false;
		for(int i=1;i<=N;i++) {
			if(dist[i]==K) {
				System.out.println(i);
				isOk = true;
			}
		}
		// 최단거리가 K인 도시가 존재하지 않는 경우 
		if(!isOk) {
			System.out.println("-1");
		}

	}
	public static void bfs(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			for(int next: adj[cur]) {
				if(dist[next] == -1) { // 방문하지 않은 경우 
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}
		
	}

}
