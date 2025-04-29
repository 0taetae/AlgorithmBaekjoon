import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1};
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine()); // 현수막의 크기 
		// 글자인 부분 1, 글자가 아닌 부분 0 
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		for(int r=0;r<M;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int r=0;r<M;r++) {
			for(int c=0;c<N;c++) {
				if(map[r][c]==1 & !visited[r][c]) { // 글자인 부분이면서, 방문하지 않은 노드 
					bfs(r,c);
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
	public static void bfs(int x,int y) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<8;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=M || ny>=N) continue;
				
				if(map[nx][ny]==1 && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.add(new Info(nx,ny));
				}
			}
		}
	}

}
