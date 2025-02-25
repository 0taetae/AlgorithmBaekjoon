import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static boolean[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Info {
        int x, y;

        Info(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 통로의 세로 길이
        M = Integer.parseInt(st.nextToken()); // 통로의 가로 길이
        K = Integer.parseInt(st.nextToken()); // 음식물 쓰레기의 개수
        map = new boolean[N + 1][M + 1];

        for (int i = 1; i <= K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            map[r][c] = true;
        }

        System.out.print(bfs());
    }

    public static int bfs() {
        Queue<Info> q = new LinkedList<>();
        boolean[][] visited = new boolean[N + 1][M + 1];
        int maxSize = 0;

        // 모든 음식물 쓰레기 위치에서
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (map[i][j] && !visited[i][j]) {
                    // 음식물이 떨어져 있는 곳
                    visited[i][j] = true;
                    q.add(new Info(i, j));
                    int size = 1; // 음식물 하나를 이미 카운트함

                    while (!q.isEmpty()) {
                        Info cur = q.poll();

                        for (int dir = 0; dir < 4; dir++) {
                            int nx = cur.x + dx[dir];
                            int ny = cur.y + dy[dir];

                            // map의 범위를 벗어나거나, 이미 방문한 곳은 지나침
                            if (nx <= 0 || ny <= 0 || nx > N || ny > M || visited[nx][ny]) continue;

                            // 음식물이 떨어져 있는 위치
                            if (map[nx][ny]) {
                                visited[nx][ny] = true;
                                q.add(new Info(nx, ny));
                                size++;
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        return maxSize;
    }
}
