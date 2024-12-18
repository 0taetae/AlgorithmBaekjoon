import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,X;
	static class Info implements Comparable<Info>{
		int end, T;
		Info(int end, int T){
			this.end = end;
			this.T = T;
		}
		@Override
        public int compareTo(Info o) {
            return Integer.compare(this.T, o.T);
        }
	}
	static ArrayList<Info>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 마을 번호 
		M = Integer.parseInt(st.nextToken());  // 도로 개수
		X = Integer.parseInt(st.nextToken());   // 참석 마을 
		
		// 인접리스트
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Info(v,w));  // 단방향 
		}
		
		int res=0;
		for(int i=1;i<=N;i++) {
			// 가장 오래 걸리는 학생의 소요시간 
			res=Math.max(dijkstra(i,X)+dijkstra(X,i),res);
		}
		System.out.println(res);
		

	}
	public static int dijkstra(int a, int b) {
		int[] dist = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[a] = 0;
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(a,0));
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			
			if(cur.T > dist[cur.end]) continue;
			
			for(Info edge:list[cur.end]) {
				if(dist[edge.end] > dist[cur.end] + edge.T) {
					dist[edge.end] = dist[cur.end] + edge.T;
					pq.add(new Info(edge.end, dist[edge.end]));
				}
			}
		}
		
		
		return dist[b];
	}

}
