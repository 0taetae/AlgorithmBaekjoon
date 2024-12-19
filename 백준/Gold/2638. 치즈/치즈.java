import java.io.*;
import java.util.*;

public class Main {
	
	static int N,M;
	static int[][] arr, copyArr;
	static int total;
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static class Info{
		int x,y;
		Info(int x, int y){
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
		
		total=0;
		arr = new int[N][M];
		copyArr = new int[N][M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				copyArr[r][c] = arr[r][c];
				if(arr[r][c]==1) {
					total++;
				}
			}
		}
		int time=0;
		while(total>0) {
			// 모눈종이의 맨 가장자리에는 치즈가 놓이지 않음 -> 실내온도의 공기 영역 확인
			check();
			// 실내온도의 공기 영역과 2변 이상 접하고, 치즈 내부에 있는 공간과 접촉하지 않은 경우
			melt();
			time++;
		}
		System.out.println(time);

	}
	public static void check() {
		Queue<Info> q = new LinkedList<>();
		visited = new boolean[N][M];
		
		q.add(new Info(0,0));
		visited[0][0] = true;
		arr[0][0] = -1;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=M || visited[nx][ny] || arr[nx][ny]==1) continue;
				
				visited[nx][ny] = true;
				q.add(new Info(nx,ny));
				arr[nx][ny] = -1;
				
			}
		}
		
		
	}
	
	public static void melt() {
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				// 치즈가 있는 경우 
				if(arr[r][c]==1) {
					boolean isPass = false;
					int cnt = 0;
					for(int dir=0;dir<4;dir++) {
						int nx = r + dx[dir];
						int ny = c + dy[dir];
						if(nx<0 || ny<0 ||nx>=N || ny>=M ) continue;
						
						// 실내 공기와 접촉 
						if(arr[nx][ny]==-1) {
							cnt++;
						}
						// 치즈 내부 공간과 접촉 
						else if(arr[nx][ny]==0) {
							isPass = true;
						}
					}
					
					if(cnt>=2) {
						copyArr[r][c] = -1;
						total--;
					}
				}
			}
		}
		for(int r=0;r<N;r++) {
			for(int c=0;c<M;c++) {
				arr[r][c] = copyArr[r][c];
			}
		}
		
		
	}

}