import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	//static int[][] adj;
	static int res;
	static ArrayList<ArrayList<Info>> adj = new ArrayList<>();
	static boolean[] visited;
	static int nextStart;
	static int maxWeight;
	static class Info{
		int node;
		int weight;
		Info(int node, int weight){
			this.node = node;
			this.weight = weight;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		//adj = new int[N+1][N+1];
		StringTokenizer st;
		for(int i=0;i<=N;i++) {
			adj.add(new ArrayList<Info>());
		}
		
		for(int i=1;i<=N-1;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			adj.get(a).add(new Info(b,w));
			adj.get(b).add(new Info(a,w));
		}
		visited = new boolean[N+1];
		visited[1] = true;
		nextStart=0;
		maxWeight=0;
		dfs(1,0);
		
		visited = new boolean[N+1];
		visited[nextStart] = true;
		maxWeight=0;
		dfs(nextStart,0);
		System.out.println(maxWeight);
		
		
		
		
	}
	public static void dfs(int start,int weight) {
		for(int i=0;i<adj.get(start).size();i++) {
			Info target = adj.get(start).get(i);
			if(!visited[target.node]) {
				visited[target.node] = true;
				dfs(target.node, weight+target.weight);
				if(maxWeight < weight+target.weight) {
					nextStart = target.node;
					maxWeight = weight+target.weight;
				}
			}
		}
	}

}
