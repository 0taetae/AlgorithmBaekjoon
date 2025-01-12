import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] map;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int maxH = 0;
	static class Info{
		int x, y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int r=0;r<N;r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				maxH = Math.max(maxH, map[r][c]);
			}
		}
		
		int res = 0;  // 안전 영역 최대 개수 
		for(int h=0;h<=maxH;h++) {
			visited = new boolean[N][N];
			int cnt = 0; // 안전 영역 개수
			
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visited[i][j] && map[i][j] > h) {
						bfs(i,j,h);
						cnt++;
					}
				}
			}
			res = Math.max(res, cnt);
		}
		System.out.println(res);
	}
	
	public static void bfs(int x, int y, int h) {
		Queue<Info> q = new LinkedList<>();
		q.offer(new Info(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] || map[nx][ny] <= h) continue;
				
				visited[nx][ny] = true;
				q.offer(new Info(nx,ny));
			}
		}
	}

}
