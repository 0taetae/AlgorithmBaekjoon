import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	static boolean visit[];
	static ArrayList[] list;
	static int result[];
	static int target;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		visit =new boolean[N+1];
		result = new int[N+1];
		
		// 2차원 ArrayList 생성
		list = new ArrayList[N+1];
		for(int i=1;i<N+1;i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=N-1;i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}
		
		// 1부터 시작, visit로 true 인 것은 패스
		DFS(1);
		for(int i=2;i<=N;i++) {
			System.out.println(result[i]);
		}

	}
	public static void DFS(int start) {
		
		for(int i=0;i<list[start].size();i++) {
			target = (int) list[start].get(i);
			if(!visit[target]) {
				visit[start] = true;
				visit[target]=true;
				result[target] = start;
				DFS(target);
			}
			
		}
	}

}