import java.io.*;
import java.util.*;

public class Main {
	
	static class Info{
		int x, y;
		Info(int x, int y){
			this.x =x ;
			this.y = y;
		}
	}
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static boolean[][] visited;
	static boolean[][] arr;
	
	static int N,M;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1;tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			arr =new boolean[N][M];
			visited = new boolean[N][M];
			int K = Integer.parseInt(st.nextToken());
			for(int i=0;i<K;i++) {
				st = new StringTokenizer(br.readLine());
				int X = Integer.parseInt(st.nextToken());
				int Y = Integer.parseInt(st.nextToken());
				arr[Y][X] = true;
			}
			int cnt=0;
			for(int i=0;i<N;i++) {
				for(int j=0;j<M;j++) {
					if(arr[i][j] && !visited[i][j]) {
						bfs(i,j);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
		}
		

	}
	public static void bfs(int x,int y) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x,y));
		visited[x][y] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || !arr[nx][ny] ||visited[nx][ny]) continue;
				
				q.add(new Info(nx,ny));
				visited[nx][ny] = true;
			}
		}
	}

}
