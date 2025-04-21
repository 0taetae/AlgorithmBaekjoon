import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static class Info{
		int x,y,dist;
		Info(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		for(int i=0;i<N;i++) {
			String line = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = line.charAt(j);
			}
		}
		int maxDist = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]=='L') {
					int dist = bfs(i,j);
					maxDist = Math.max(maxDist, dist);
				}
			}
		}
		System.out.println(maxDist);
	}
	static int bfs(int x,int y) {
		visited = new boolean[N][M];
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x,y,0));
		visited[x][y] = true;
		
		int max = 0;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			max = Math.max(max, cur.dist);
			
			for(int i=0;i<4;i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y+dy[i];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M) continue;
				if(!visited[nx][ny] && map[nx][ny]=='L') {
					visited[nx][ny] = true;
					q.add(new Info(nx,ny,cur.dist+1));
				}
			}
			
		}
		return max;
	}

}