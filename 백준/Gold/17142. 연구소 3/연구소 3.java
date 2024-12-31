import java.io.*;
import java.util.*;

public class Main {
	
	static int N, M;
	static int[][] map;
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static class timeInfo{
		int x,y,time;
		timeInfo(int x, int y, int time){
			this.x = x;
			this.y = y;
			this.time = time;
		}
	}
	static ArrayList<Info> virus = new ArrayList<>();  // 바이러스 리스트 
	static int[] selected;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static int res = Integer.MAX_VALUE; // 모든 빈 칸에 바이러스를 퍼뜨리는 최소 시간 
	static int total=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		selected = new int[M];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c]==2) {  // 바이러스인 경우 
					virus.add(new Info(r,c));
				}else if(map[r][c]==0) {
					total++;
				}
			}
		}
		
		comb(0,0);
		if(res == Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(res);
		}

	}
	// 조합으로 활성 바이러스 택하기 
	public static void comb(int start, int cnt) {
		if(cnt==M) {
			bfs();
			return;
		}
		for(int i=start; i <virus.size();i++) {
			selected[cnt] = i;
			comb(i+1, cnt+1);
		}
	}
	public static void bfs() {
		Queue<timeInfo> q = new LinkedList<>();
		boolean[][] visited = new boolean[N][N];
		
		// 활성 바이러스를 모두 큐에 담기 
		for(int i=0;i<M;i++) {
			Info cur = virus.get(selected[i]);
			q.add(new timeInfo(cur.x, cur.y,0));
			visited[cur.x][cur.y] = true;  // 활성 바이러스 방문 처리 
		}
		
		int maxTime = 0;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			timeInfo cur = q.poll();
			for(int dir=0;dir<4;dir++) {
				int nx = cur.x + dx[dir];
				int ny = cur.y + dy[dir];
				
				if(nx<0 || ny<0 || nx>=N || ny>=N || visited[nx][ny] || map[nx][ny] ==1) continue;
				
				visited[nx][ny] = true;
				q.add(new timeInfo(nx, ny, cur.time + 1));
				
				// 빈칸인 경우 바이러스 퍼뜨리기
				// 모든 빈칸에 바이러스 퍼뜨리도록 최대 시간 구하기 
				if(map[nx][ny] ==0) {
					maxTime = Math.max(maxTime, cur.time + 1);
					cnt++;
				}
				
			}
		}
		// 모든 빈칸에 바이러스가 있게 되는 최소 시간 
		if(cnt== total) {
			res = Math.min(maxTime, res);
		}
	}

}
