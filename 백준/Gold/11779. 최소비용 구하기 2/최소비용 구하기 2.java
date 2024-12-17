import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static class Info implements Comparable<Info> {
		int end, cost;
		Info(int end, int cost){
			this.end = end;
			this.cost = cost;
		}
		@Override
        public int compareTo(Info o) {
            return Integer.compare(this.cost, o.cost);
        }
	}
	static ArrayList<Info>[] list;
	static int[] pre;
	static int[] dist;
	static ArrayList<Integer> city = new ArrayList<>();
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  // 정점
		M = Integer.parseInt(br.readLine());  // 간선
		
		// 인접리스트 
		list = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		dist = new int[N+1];
		pre = new int[N+1];
		Arrays.fill(dist, Integer.MAX_VALUE);
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			list[u].add(new Info(v,w));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		check(start);
		System.out.println(dist[end]);
		find(start,end);
		System.out.println(city.size());
		for(int i=city.size()-1;i>=0;i--) {
			System.out.print(city.get(i)+" ");
		}
	}
	public static void check(int start) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			
			if(cur.cost >dist[cur.end]) continue;
			
			for (Info edge : list[cur.end]) {
                if (dist[edge.end] > dist[cur.end] + edge.cost) {
                    dist[edge.end] = dist[cur.end] + edge.cost;
                    pq.add(new Info(edge.end, dist[edge.end]));
                    pre[edge.end] = cur.end;
                }
            }
		}
	}
	public static void find(int start, int end) {
		Queue<Integer> q = new LinkedList<>();
		q.add(end);
		while(!q.isEmpty()) {
			int cur = q.poll();
			
			city.add(cur);
			if(cur==start) return;
			q.add(pre[cur]);
			
			
		}
	}

}
