import java.io.*;
import java.util.*;

public class Solution {
	
	static int V,E;
	static int[] dep, cnt;
	static ArrayList<Integer>[] list;
	
	

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for(int tc=1;tc<=10;tc++) {
			st = new StringTokenizer(br.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			dep = new int[V+1];
			cnt = new int[V+1];
			list = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			
			st = new StringTokenizer(br.readLine());
			for(int i=0;i<E;i++) {
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				list[p].add(c);  // 부모 노드 넣기
				dep[c]++;
			}
			Queue<Integer> q = new LinkedList<>();
			for(int i=1;i<=V;i++) {
				// 선행 작업큐에 담기 
				if(dep[i]==0) {
					q.add(i);
					cnt[i] = 1;
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				for(int j=0;j<list[cur].size();j++) {
					int temp = list[cur].get(j);
					dep[temp] --;
					if(dep[temp]==0) {
						q.add(temp);
						cnt[temp] = cnt[cur]+1;
					}
				}
			}
			
			System.out.print("#"+tc+" ");
			for(int i=1;i<=V;i++) {
				for(int j=1;j<=V;j++) {
					if(cnt[j]==i) {
						System.out.print(j+" ");
					}
				}
			}
			System.out.println();
		}
		

	}

}
