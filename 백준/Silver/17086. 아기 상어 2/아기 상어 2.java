import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visited;
    static int[] dx = {-1, -1, -1, 0, 1, 1, 1, 0};
    static int[] dy = {-1, 0, 1, 1, 1, 0, -1, -1};

    static class Point {
        int x, y;
        Point(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        map = new int[N][M];
        dist = new int[N][M];
        visited = new boolean[N][M];
        Queue<Point> sharkPositions = new LinkedList<>();

        // 입력 및 아기 상어 위치 저장
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                map[i][j] = sc.nextInt();
                if (map[i][j] == 1) {
                    sharkPositions.add(new Point(i, j));
                    visited[i][j] = true;
                }
            }
        }

        bfs(sharkPositions);

        // 최대 안전 거리 출력
        int maxDist = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                maxDist = Math.max(maxDist, dist[i][j]);
            }
        }
        System.out.println(maxDist);
    }

    static void bfs(Queue<Point> q) {
        while (!q.isEmpty()) {
            Point p = q.poll();
            for (int dir = 0; dir < 8; dir++) {
                int ny = p.y + dy[dir];
                int nx = p.x + dx[dir];
                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    dist[ny][nx] = dist[p.y][p.x] + 1;
                    q.add(new Point(ny, nx));
                }
            }
        }
    }
}
