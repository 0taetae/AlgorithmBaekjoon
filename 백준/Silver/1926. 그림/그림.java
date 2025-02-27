import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x, y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도화지 세로 크기
		M = Integer.parseInt(st.nextToken()); // 도화지 가로 크기
		
		map = new int[N][M];
		visited =new boolean[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0; // 그림의 개수
		int maxSize = 0; // 가장 넓은 그림의 넓이
		
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				if(map[r][c]==1 && !visited[r][c]) {
					maxSize = Math.max(maxSize, bfs(r,c));
					cnt++;
				}
			}
		}
		System.out.println(cnt);
		System.out.println(maxSize);
		

	}
	public static int bfs(int r, int c) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(r,c));
		visited[r][c] = true;
		int size = 1;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || map[nx][ny]==0) continue;
				
				q.add(new Info(nx,ny));
				visited[nx][ny] = true;
				size++;
			}
		}
		return size;
	}

}
