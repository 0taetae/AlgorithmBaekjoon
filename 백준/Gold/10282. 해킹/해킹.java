import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<ArrayList<Node>> graph;
	static int[] dist;
	static class Node implements Comparable<Node>{
		int vertex, time;

	    Node(int vertex, int time) {
	        this.vertex = vertex;
	        this.time = time;
	    }

	    @Override
	    public int compareTo(Node other) {
	        return this.time - other.time;
	    }
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine()); // 테케 수
		
		for(int tc=0;tc<T;tc++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
			int d = Integer.parseInt(st.nextToken()); // 의존성 개수 
			int c = Integer.parseInt(st.nextToken()); // 컴퓨터의 번호 
			
			graph = new ArrayList<>();
			dist = new int[n+1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			
			for(int i=0;i<=n;i++) {
				graph.add(new ArrayList<>());
			}
			
			for(int i=0;i<d;i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				int s = Integer.parseInt(st.nextToken()); // 컴퓨터 b가 감염되면 s초 후 컴퓨터 a도 감염
				graph.get(b).add(new Node(a,s));
			}
			
			dijkstra(c);
			
			int cnt = 0;
			int maxTime = 0;
			
			for(int i=1;i<=n;i++) {
				if(dist[i]!= Integer.MAX_VALUE) { // 감염된 컴퓨터 수 
					cnt++;
					maxTime = Math.max(maxTime, dist[i]); // 마지막 컴퓨터가 감염되기까지 걸리는 시간 
				}
			}
			System.out.println(cnt+" "+maxTime);
			
		}
	}
	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start,0));
		dist[start] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			int curNode = cur.vertex;
			int curTime = cur.time;
			
			if(curTime > dist[curNode]) continue;
			
			for(Node next:graph.get(curNode)) {
				int cost = dist[curNode] + next.time;
				if(cost < dist[next.vertex]) {
					dist[next.vertex] = cost;
					pq.offer(new Node(next.vertex,cost));
				}
			}
		}
	}

}
