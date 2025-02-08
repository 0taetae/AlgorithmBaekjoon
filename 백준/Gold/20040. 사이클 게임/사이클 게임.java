import java.io.*;
import java.util.*;

public class Main {
	
	static int[] parent;

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken()); // n개의 점
		int m = Integer.parseInt(st.nextToken()); // m번의 게임
		
		parent = new int[n];
		for(int i=0;i<n;i++) {
			parent[i] = i;
			
		}
		
		int res = 0; // 처음으로 사이클이 완성되는 게임 회차
		
		// 해당 플레이어가 선택한 두 점의 번호 
		for(int i=1;i<=m;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) == find(b)) { // 사이클 발생 
				res = i;
				break;
			}
			union(a,b);
			
		}
		System.out.println(res);

	}
	
	public static int find(int x) {
		if(parent[x] == x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int a, int b) {
		int rootA = find(a);
		int rootB = find(b);
		
		if(rootA != rootB) {
			parent[rootB] = rootA;
		}
	}
}