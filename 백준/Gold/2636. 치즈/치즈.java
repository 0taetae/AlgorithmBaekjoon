import java.util.*;
import java.io.*;

public class Main {
	
	static int N,M;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1}; 
	static class Info{
		int x,y;
		Info(int x,int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1) cnt++;
			}
		}
		
		int time=0; // 치즈가 모두 녹아서 없어지는데 걸리는 시간 
		int res = cnt;
		while(cnt >0 ) {
			res = cnt;
			cnt = bfs(); // 남아 있는 치즈 
			time++;
		}
		
		System.out.println(time);
		System.out.println(res); // 모두 녹기 한시간 전에 남아있는 치즈 개수 

	}
	
	public static int bfs() {
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[N][M];
		q.offer(new Info(0,0));
		visited[0][0] = true;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) continue;
				
				if(map[nx][ny] == 0) {
					q.offer(new Info(nx,ny));
					visited[nx][ny] = true;
				}else if(map[nx][ny]==1) {
					map[nx][ny] =0;
					visited[nx][ny] = true;
				}
			}
		}
		int remainCnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1) remainCnt++;
			}
		}	
		return remainCnt;
	}
}