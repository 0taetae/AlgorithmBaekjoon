import java.io.*;
import java.util.*;

public class Main {
	
	static int N;
	static int[][] arr;
	static boolean[][] visited;
	static ArrayList<Integer> list = new ArrayList<>();
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				arr[i][j] = str.charAt(j)-'0';
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j]==1 && !visited[i][j]) {
					bfs(i,j);
				}
			}
		}
		Collections.sort(list);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
		
	}
	public static void bfs(int x,int y) {
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(x,y));
		visited[x][y] = true;
		int cnt = 1;
		
		while(!q.isEmpty()) {
			Info cur = q.poll();
			
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] || arr[nx][ny]==0) continue;
				q.add(new Info(nx,ny));
				visited[nx][ny] = true;
				cnt++;
			}
		}
		
		list.add(cnt);
	}

}
