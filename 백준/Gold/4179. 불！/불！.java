import java.io.*;
import java.util.*;

public class Main {
	
	static int R,C;
	static int startR,startC;
	static char[][] map;
	static int[][] fireMap, personMap;
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	static class Info{
		int x,y;
		Info(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static ArrayList<Info> fireList = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		map = new char[R][C];
		fireMap = new int[R][C];
		personMap = new int[R][C];
		for(int r=0;r<R;r++) {
			String str = br.readLine();
			for(int c=0;c<C;c++) {
				map[r][c] = str.charAt(c);
				if(map[r][c]=='J') {
					startR = r;
					startC = c;
				}else if(map[r][c]=='F') {
					fireList.add(new Info(r,c));
				}
			}
		}
		spread();
		int res = move();
		if(res==-1) {
			System.out.println("IMPOSSIBLE");
		}else {
			System.out.println(res);
		}
		

	}
	// 불 퍼뜨리기
	public static void spread() {
		Queue<Info> q = new LinkedList<>();
        for (int i=0;i<fireList.size();i++) {
            q.offer(fireList.get(i));
        }

        while (!q.isEmpty()) {
            Info cur = q.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C) {
                    if (map[nx][ny] != '#' && fireMap[nx][ny] == 0) {
                        fireMap[nx][ny] = fireMap[cur.x][cur.y] + 1;
                        q.offer(new Info(nx, ny));
                    }
                }
            }
        }
	}
	// 지훈이 이동
	public static int move() {
		Queue<Info> queue = new LinkedList<>();
        queue.offer(new Info(startR, startC));

        while (!queue.isEmpty()) {
            Info cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];
                
                if (nx < 0 || ny < 0 || nx >= R || ny >= C) {
                    return personMap[cur.x][cur.y] + 1;
                }
                
                if (map[nx][ny] == '.' && personMap[nx][ny] == 0) {
                    if (fireMap[nx][ny] == 0 || personMap[cur.x][cur.y] + 1 < fireMap[nx][ny]) {
                        personMap[nx][ny] = personMap[cur.x][cur.y] + 1;
                        queue.offer(new Info(nx, ny));
                    }
                }
            }
        }
        return -1;
	}

}
