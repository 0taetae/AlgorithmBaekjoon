import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] map;

	// 상 하 좌 우
	static int[] dx = { -1, 1, 0, 0 };
	static int[] dy = { 0, 0, -1, 1 };
	static int maxBlock = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(map, 0);
		System.out.println(maxBlock);
	}

	// 최대 5번 이동 
	private static void dfs(int[][] map, int moveCount) {
		if (moveCount == 5) {
			findMaxBlock(map);
			return;
		}

		for (int dir = 0; dir < 4; dir++) {
			int[][] newMap = move(map, dir);
			dfs(newMap, moveCount + 1);
		}
	}

	private static int[][] move(int[][] map, int dir) {
		int[][] newMap = new int[N][N];
		boolean[][] merged = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				newMap[i][j] = map[i][j];
			}
		}

		if (dir == 0) { // 상
			for (int c = 0; c < N; c++) {
				for (int r = 1; r < N; r++) {
					if (newMap[r][c] == 0)
						continue;
					int nr = r;
					while (nr > 0 && newMap[nr - 1][c] == 0) {
						newMap[nr - 1][c] = newMap[nr][c];
						newMap[nr][c] = 0;
						nr--;
					}
					if (nr > 0 && newMap[nr - 1][c] == newMap[nr][c] && !merged[nr - 1][c]) {
						newMap[nr - 1][c] *= 2;
						newMap[nr][c] = 0;
						merged[nr - 1][c] = true;
					}
				}
			}
		} else if (dir == 1) { // 하
			for (int c = 0; c < N; c++) {
				for (int r = N - 2; r >= 0; r--) {
					if (newMap[r][c] == 0)
						continue;
					int nr = r;
					while (nr < N - 1 && newMap[nr + 1][c] == 0) {
						newMap[nr + 1][c] = newMap[nr][c];
						newMap[nr][c] = 0;
						nr++;
					}
					if (nr < N - 1 && newMap[nr + 1][c] == newMap[nr][c] && !merged[nr + 1][c]) {
						newMap[nr + 1][c] *= 2;
						newMap[nr][c] = 0;
						merged[nr + 1][c] = true;
					}
				}
			}
		} else if (dir == 2) { // 좌
			for (int r = 0; r < N; r++) {
				for (int c = 1; c < N; c++) {
					if (newMap[r][c] == 0)
						continue;
					int nc = c;
					while (nc > 0 && newMap[r][nc - 1] == 0) {
						newMap[r][nc - 1] = newMap[r][nc];
						newMap[r][nc] = 0;
						nc--;
					}
					if (nc > 0 && newMap[r][nc - 1] == newMap[r][nc] && !merged[r][nc - 1]) {
						newMap[r][nc - 1] *= 2;
						newMap[r][nc] = 0;
						merged[r][nc - 1] = true;
					}
				}
			}
		} else if (dir == 3) { // 우
			for (int r = 0; r < N; r++) {
				for (int c = N - 2; c >= 0; c--) {
					if (newMap[r][c] == 0)
						continue;
					int nc = c;
					while (nc < N - 1 && newMap[r][nc + 1] == 0) {
						newMap[r][nc + 1] = newMap[r][nc];
						newMap[r][nc] = 0;
						nc++;
					}
					if (nc < N - 1 && newMap[r][nc + 1] == newMap[r][nc] && !merged[r][nc + 1]) {
						newMap[r][nc + 1] *= 2;
						newMap[r][nc] = 0;
						merged[r][nc + 1] = true;
					}
				}
			}
		}

		return newMap;
	}

	private static void findMaxBlock(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				maxBlock = Math.max(maxBlock, map[i][j]);
			}
		}
	}
}
