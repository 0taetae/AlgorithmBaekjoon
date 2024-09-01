import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[] parents;
	static class Edge{
		int start, end, weight;
		Edge(int start, int end, int weight){
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
	}
	static void make() {
		parents = new int[N+1];
		Arrays.fill(parents, -1);
	}
	static int findSet(int a) {
		if(parents[a]<0) return a;
		
		return parents[a] = findSet(parents[a]);
	}
	static boolean union(int a, int b) {
		int aRoot = findSet(a);
		int bRoot = findSet(b);
		// 대표자가 같으면 false
		if(aRoot == bRoot) return false;
		// 대표자가 다르면 union 
		parents[aRoot] += parents[bRoot];
		parents[bRoot] = aRoot;
		return true;
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());  // 컴퓨터(정점)의 수
		M = Integer.parseInt(br.readLine()); // 연결선(간선)의 수
		
		Edge[] edges = new Edge[M];
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(start, end, weight);
		}
		// 가중치를 기준으로 오름차순 정렬
		Arrays.sort(edges, new Comparator<Edge>() {
			public int compare(Edge o1, Edge o2) {
				return o1.weight - o2.weight;
			}
		});
		make();
		
		int cnt = 0;
		int cost = 0;
		for(int i=0;i<M;i++) {
			Edge target = edges[i];
			if(union(target.start, target.end)) {
				cnt++;
				cost += target.weight;
				if(cnt == N-1) break;
			}
		}
		System.out.println(cost);
	}
}
