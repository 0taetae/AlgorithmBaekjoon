import java.io.*;
import java.util.*;

public class Main {
    
    static int N, M, res;
    static int[][] paper;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paper = new int[N][M];

        for(int r = 0; r < N; r++) {
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < M; c++) {
                paper[r][c] = Integer.parseInt(st.nextToken());
            }
        }
        res = 0;
        visited = new boolean[N][M];
        for(int r = 0; r < N; r++) {
            for(int c = 0; c < M; c++) {
                visited[r][c] = true;
                dfs(r, c, 1, paper[r][c]);
                visited[r][c] = false;
                check(r, c);
            }
        }
        System.out.println(res);
    }

    static void dfs(int r, int c, int cnt, int val) {
        if (cnt == 4) {
            res = Math.max(res, val);
            return;
        }

        for (int i = 0; i < 4; i++) {
            int x = r + dx[i];
            int y = c + dy[i];
            if (x < 0 || y < 0 || x >= N || y >= M || visited[x][y]) continue;

            visited[x][y] = true;
            dfs(x, y, cnt + 1, val + paper[x][y]);
            visited[x][y] = false;
        }
    }

    static void check(int r, int c) {
        // 'ㅗ' 모양 
        if (r >= 1 && c >= 1 && c < M - 1) {
            int sum = paper[r][c] + paper[r-1][c] + paper[r][c-1] + paper[r][c+1];
            res = Math.max(res, sum);
        }
        // 'ㅜ' 모양
        if (r < N - 1 && c >= 1 && c < M - 1) {
            int sum = paper[r][c] + paper[r+1][c] + paper[r][c-1] + paper[r][c+1];
            res = Math.max(res, sum);
        }
        // 'ㅓ' 모양
        if (r >= 1 && r < N - 1 && c >= 1) {
            int sum = paper[r][c] + paper[r-1][c] + paper[r+1][c] + paper[r][c-1];
            res = Math.max(res, sum);
        }
        // 'ㅏ' 모양
        if (r >= 1 && r < N - 1 && c < M - 1) {
            int sum = paper[r][c] + paper[r-1][c] + paper[r+1][c] + paper[r][c+1];
            res = Math.max(res, sum);
        }
    }
}
