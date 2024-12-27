import java.io.*;
import java.util.*;

public class Main {
	
	static int N,I;
	static int startR,startC, endR, endC;
	static int[][] arr;
	static int[] dx = {-2,-2,-1,-1,1,1,2,2};
	static int[] dy = {-1,1,-2,2,-2,2,-1,1};

	static class Info implements Comparable<Info> {
	    int x,y,cost;
	    Info(int x, int y, int cost){
	        this.x = x;
	        this.y = y;
	        this.cost = cost;
	    }
	    @Override
	    public int compareTo(Info o) {
	        return this.cost - o.cost;
	    }
	}

	static ArrayList<Info> list = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st ;
		for(int tc=1;tc<=T;tc++) {
			I = Integer.parseInt(br.readLine());
			arr = new int[I][I];
			for(int i=0;i<I;i++) {
				for(int j=0;j<I;j++) {
					arr[i][j] = Integer.MAX_VALUE;
				}
			}
			st = new StringTokenizer(br.readLine());
			startR = Integer.parseInt(st.nextToken());
			startC = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			endR = Integer.parseInt(st.nextToken());
			endC = Integer.parseInt(st.nextToken());
			bfs(startR,startC);
			System.out.println(arr[endR][endC]);
		}
		
	}
	public static void bfs(int a, int b) {
		PriorityQueue<Info> pq = new PriorityQueue<>();
		pq.add(new Info(a,b,0));
		arr[a][b] =0;
		
		while(!pq.isEmpty()) {
			Info cur = pq.poll();
			
			if(cur.x == endR && cur.y == endC) return;
			
			for(int dir=0;dir<8;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=I || ny>=I) continue;
				if(arr[nx][ny] > arr[cur.x][cur.y] + 1) {
					arr[nx][ny] = arr[cur.x][cur.y] + 1;
					pq.add(new Info(nx,ny,arr[nx][ny]));
				}
			}
			
		}
		
	}

}
