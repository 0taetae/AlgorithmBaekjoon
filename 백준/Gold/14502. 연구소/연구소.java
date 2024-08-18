import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Main {
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0, 0, -1, 1};
	static int[][] lab;
	static int result;
	static int N;
	static int M;
	 
	public static class Idx {
		int r;
		int c;
		public Idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		lab = new int[N][M];
		
		for(int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0; c<M; c++) {
				lab[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dfs(0);
		System.out.println(result);
		

	}
	// 벽 세우기 
	public static void dfs(int count) {
		// 벽 3개 세웠을 때 안전 영역 구하기 
		if(count == 3) {
			virus();
			return;
		}
		for(int r=0; r<N; r++) {
			for(int c=0; c<M ; c++) {
				if(lab[r][c] == 0) {
					lab[r][c] = 1;
					dfs(count+1);
					lab[r][c] = 0;
				}
			}
		}
	}
	
	public static void virus() {
		Queue<Idx> q = new LinkedList<>();
		
		int[][] copylab = new int[N][M];
		int count=0;
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				copylab[r][c] = lab[r][c];
				
				// 바이러스가 있는 곳은 큐에 넣기 
				if(copylab[r][c]==2) {
					q.offer(new Idx(r,c));
				}
				// 빈칸 개수 
				if(copylab[r][c]==0) {
					count++;
				}
			}
		}
		
		while(!q.isEmpty()) {
			Idx temp = q.poll();
			
			int r = temp.r;
			int c = temp.c;
			
			for(int i=0;i<4;i++) {
				
				int x = r + dx[i];
				int y = c + dy[i];
				
				if (x < 0 || y < 0 || x >= N || y >= M ) continue;
				
				// 바이러스 퍼뜨리기 
				if(copylab[x][y]==0) {
					copylab[x][y] = 2;
					q.offer(new Idx(x,y));
					count--;
				}
				
			}
		}
		result = Math.max(result, count);
		
	}
	

}