import java.io.*;
import java.util.*;

public class Main {

	static int[] dx = { -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dy = { 0, 1, 1, 1, 0, -1, -1, -1 };

	static int N, M, K;
	static int[][] map;

	static int[][] fireBallMove;
	static int[][][] moveRes; // 질량 , 속력, 방향

	static class Info {
		int r, c, m, s, d;

		Info(int r, int c, int m, int s, int d) {
			this.r = r; // 파이어볼 위치
			this.c = c; // 파이어볼 위치
			this.m = m; // 질량
			this.s = s; // 속력 (이동 칸)
			this.d = d; // 방향
		}
	}

	static ArrayList<Info> fireBalls = new ArrayList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 맵 크기
		M = Integer.parseInt(st.nextToken()); // 파이어볼 개수
		K = Integer.parseInt(st.nextToken()); // 이동 횟수

		map = new int[N + 1][N + 1];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			fireBalls.add(new Info(r, c, m, s, d));
		}

		// 마법사 상어가 이동을 K번 명령
		for (int i = 0; i < K; i++) {

			move();
			makeList(); // 파이어볼의 새로운 리스트
			// 파이어볼 모두 이동
			// 이동했을 때 파이어볼이 해당 칸에 몇개 있는지 체크하는 배열
			// 파이어볼 이동할 때 질량, 속력 다 더하기

		}
		System.out.println(check());

	}

	public static void move() {
	    fireBallMove = new int[N + 1][N + 1]; // 해당 칸에 파이어볼이 몇개 있는지
	    moveRes = new int[N + 1][N + 1][5]; // 움직인 결과
	    for (int i = 0; i < fireBalls.size(); i++) {
	        Info cur = fireBalls.get(i);
	        
	        // 1번 행은 N번과 연결, 1번 열은 N번 열과 연결  
	        int nx = (cur.r + dx[cur.d] * cur.s) % N;
	        int ny = (cur.c + dy[cur.d] * cur.s) % N;

	        if (nx <= 0) nx += N;
	        if (ny <= 0) ny += N;

	        fireBallMove[nx][ny]++;
	        moveRes[nx][ny][0] += cur.m;
	        moveRes[nx][ny][1] += cur.s;
	        moveRes[nx][ny][2] += cur.d;
	        if (cur.d % 2 == 0) {  // 방향이 짝수인 경우
	            moveRes[nx][ny][3]++;
	        } else {  // 방향이 홀수인 경우
	            moveRes[nx][ny][4]++;
	        }
	    }
	}

	public static void makeList() {
		fireBalls.clear();
		
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				
				// 같은 칸에 있는 파이어볼이 1개인 경우 
				if(fireBallMove[i][j]==1) {
					fireBalls.add(new Info(i,j,moveRes[i][j][0], moveRes[i][j][1], moveRes[i][j][2]));
				}
				// 같은 칸에 있는 파이어볼이 2개 이상인 경우
				else if(fireBallMove[i][j]>=2) {
					int newM = moveRes[i][j][0]/5;
					
					// 질량이 0인 파이어볼은 소멸되어 없어짐 
					if(newM==0) continue;
					
					int newS = moveRes[i][j][1]/fireBallMove[i][j];
					
					// 합쳐지는 파이어볼의 방향이 모두 홀수이거나 모두 짝수인 경우 
					if(moveRes[i][j][3]==fireBallMove[i][j] || moveRes[i][j][4]==fireBallMove[i][j]) {
						for(int dir=0;dir<=6;dir+=2) {
							fireBalls.add(new Info(i,j,newM, newS,dir));
						}
					}else { // 그렇지 않은 경우 
						for(int dir=1;dir<=7;dir+=2) {
							fireBalls.add(new Info(i,j,newM, newS,dir));
						}
					}
				}
			}
		}
		
	}
	public static int check() {
		int sum = 0;
		for(int i=0;i<fireBalls.size();i++) {
			sum+=fireBalls.get(i).m;
		}
		return sum; 
	}
	

}
