import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static ArrayList<Integer>[] list;
	static ArrayList<Integer> res = new ArrayList<>();
	static int[] degree;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		degree = new int[N+1];
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			degree[b]++;
		}
		check();
		
		for(int cur:res) {
			System.out.print(cur+" ");
		}

	}
	public static void check() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(degree[i]==0) {
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);
			
			for(int temp:list[cur]) {
				degree[temp]--;
				if(degree[temp]==0) {
					q.add(temp);
				}
			}
		}
	}

}
