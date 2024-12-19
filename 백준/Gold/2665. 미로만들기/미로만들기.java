import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	static int[][][] visited;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info implements Comparator<Info>{
		int x, y, len, cnt;
		Info(int x, int y, int len, int cnt){
			this.x = x;
			this.y = y;
			this.len = len;
			this.cnt = cnt;
		}
		@Override
		public int compare(Info o1, Info o2) {
			if(o1.cnt == o2.cnt) {
				return o1.len - o2.len;
			}
			return o1.cnt - o2.cnt;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new int[N][N][2];
		for(int r=0;r<N;r++) {
			String str = br.readLine();
			for(int c=0;c<N;c++) {
				arr[r][c] = str.charAt(c) - '0';
			}
		}
		check(0,0);
		System.out.println(visited[N-1][N-1][1]);

	}
	
	public static void check(int a, int b) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(a,b,0,0));
		for(int r=0;r<N;r++) {
			for(int c=0;c<N;c++) {
				visited[r][c][0] = Integer.MAX_VALUE;
				visited[r][c][1] = Integer.MAX_VALUE;
			}
		}
		visited[a][b][0] =0;  // 거리
		visited[a][b][1] = 0;  // 방 바꾸기 횟수
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				int nc = cur.cnt;
				//범위 벗어나는 경우 
				if(nx<0 || ny<0 || nx>=N || ny>=N) continue;
				
				// 검은 방인 경우
				if(arr[nx][ny]==0) {
					nc++;
				}
				
				if(nc<visited[nx][ny][1]) {
					visited[nx][ny][0] = cur.len+1;
					visited[nx][ny][1] = nc;
					q.add(new Info(nx,ny, cur.len+1, nc));
				}else if( nc == visited[nx][ny][1]) {
					if(cur.len+1 <visited[nx][ny][0]) {
						visited[nx][ny][0] = cur.len+1;
						visited[nx][ny][1] = nc;
						q.add(new Info(nx,ny, cur.len+1, nc));
					}
				}
			}
			
		}
	}

}
