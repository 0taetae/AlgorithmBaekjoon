import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N;
	static int[][] score;
	static boolean[] visited;
	
	static int Min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
		N = Integer.parseInt(br.readLine());
 
		score = new int[N][N];
		visited = new boolean[N];
 
 
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				score[i][j] = Integer.parseInt(st.nextToken());
			}
		}
 
		comb(0, 0);
		System.out.println(Min);
 
	}
 

	static void comb(int idx, int count) {

		if(count == N / 2) {

			int start_team = 0;
			int link_team = 0;
	 
			for (int i = 0; i < N - 1; i++) {
				for (int j = i + 1; j < N; j++) {
					if (visited[i] == true && visited[j] == true) {
						start_team += score[i][j] + score[j][i];
					}
					else if (visited[i] == false && visited[j] == false) {
						link_team += score[i][j] + score[j][i];
					}
				}
			}
			Min = Math.min(Min, Math.abs(start_team - link_team));
			return;
		}
 
		for(int i = idx; i < N; i++) {

			if(!visited[i]) {
				visited[i] = true;	
				comb(i + 1, count + 1);	
				visited[i] = false;	
			}
		}
	}
 
}