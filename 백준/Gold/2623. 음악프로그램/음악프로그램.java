import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static ArrayList<Integer> res = new ArrayList<>();
	static int[] deg;
	static ArrayList<Integer>[] list;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());// 가수의 수
		M = Integer.parseInt(st.nextToken());// 보조 PD의 수 
		
		list = new ArrayList[N+1];
		deg = new int[N+1];
		
		for(int i=1;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());  // 담당한 가수의 수 
			int[] order = new int[cnt];
			for(int j=0;j<cnt;j++) {
				order[j] = Integer.parseInt(st.nextToken());  // 담당한 가수
			}
			for(int j=0;j<cnt-1;j++) {
				int from = order[j];
				int to = order[j+1];
				
				list[from].add(to);
				deg[to]++;
			}
		}
		check();
		if(res.size()==N) {
			StringBuilder sb = new StringBuilder();
			for(int cur:res) {
				sb.append(cur).append("\n");
			}
			System.out.println(sb);
		}else {
			System.out.println(0);
		}

	}
	public static void check() {
		Queue<Integer> q = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			if(deg[i]==0) {  // 진입 차수가 0인 경우 
				q.add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);
			
			for(int next : list[cur]) {
				deg[next]--;  // 진입 차수 감소 
				if(deg[next]==0) {  // 진입 차수가 0이 된 경우 
					q.add(next);
				}
			}
		}
	}

}
