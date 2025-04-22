import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M,S,T;
	
	static class Edge implements Comparable<Edge> {
        int node, cost;

        Edge(int node, int cost) {
            this.node = node;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
	
	static List<Edge>[] graph;
	static int[] dist;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Edge(v, w));
            graph[v].add(new Edge(u, w));
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[S] = 0;
        
        dijkstra();
        System.out.println(dist[T]);

	}
	
	static void dijkstra() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(S, 0));

        while (!pq.isEmpty()) {
            Edge cur = pq.poll();

            if (cur.cost > dist[cur.node]) continue;

            for (Edge next : graph[cur.node]) {
                if (dist[next.node] > dist[cur.node] + next.cost) {
                    dist[next.node] = dist[cur.node] + next.cost;
                    pq.add(new Edge(next.node, dist[next.node]));
                }
            }
        }
	}

}
