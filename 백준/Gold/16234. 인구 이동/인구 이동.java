import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N ;  // N개 줄에 각 나라의 인구수가 주어짐 
	static int[][] A;  // 각 나라 인구수 
	static int L;  // 나이 차이가 L명 이상
	static int R;  // 나이 차이가 R명 이하 
	// 인구수 4방향 비교를 위한 방향벡터 dr, dc 
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, 1, 0, -1};
	static boolean[][] visit ;
	
	static ArrayList<Idx> list;  
	public static class Idx {
		int r;
		int c;
		public Idx(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		
		A = new int[N][N];
		for(int r=0;r<N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<N;c++) {
				A[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(move());

	}
	public static int bfs(int r, int c) {
		Queue<Idx> q = new LinkedList<>();
		list = new ArrayList<Idx>(); 
		// offer - 큐가 꽉찬 경우 false 반환, add - 큐가 꽉찬 경우 에러 발생
		q.offer(new Idx(r,c));
		list.add(new Idx(r,c));
		visit[r][c] = true;
		
		int sum = A[r][c]; 
		while(!q.isEmpty()) {
			Idx temp = q.poll();
			for(int i=0;i<4;i++) {
				int x = temp.r + dr[i];
				int y = temp.c + dc[i];
				if(x>=0 && y >=0 && x<N && y<N && !visit[x][y]) {
					int dif = Math.abs(A[temp.r][temp.c]-A[x][y]);
					if(dif>=L && dif <=R) {
						q.offer(new Idx(x,y));
						list.add(new Idx(x,y));
						sum+=A[x][y];
						visit[x][y] = true;
						
					}
				}
				
			}
		}
		return sum;
		
	}
	public static int move() {
		int count = 0;
		while(true) {
			boolean isMove = false;
			visit = new boolean[N][N];
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(!visit[i][j]) {
						int sum = bfs(i,j);
						if(list.size() >1) {
							changePopulation(sum);
							isMove = true;
						}
					}
				}
			}
			if(!isMove) {
				return count;
			}
			count++;
		}
	}
	public static void changePopulation(int sum) {
		int changeValue = sum/list.size();
		for(int i=0;i<list.size();i++) {
			A[list.get(i).r][list.get(i).c] = changeValue;
		}
		
	}

}