import java.io.*;
import java.util.*;

public class Main {

    static int INF = 50;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] dist = new int[N + 1][N + 1];

        for (int i = 1; i <= N; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            dist[a][b] = 1;
            dist[b][a] = 1;
        }

        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        int[] scores = new int[N + 1];
        int minScore = INF;
        for (int i = 1; i <= N; i++) {
            int maxDist = 0;
            for (int j = 1; j <= N; j++) {
                if (i != j) {
                    maxDist = Math.max(maxDist, dist[i][j]);
                }
            }
            scores[i] = maxDist;
            minScore = Math.min(minScore, maxDist);
        }

        ArrayList<Integer> res = new ArrayList<>();  // 회장 후보 
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) {
                res.add(i);
            }
        }
        Collections.sort(res);

        System.out.println(minScore + " " + res.size());
        for (int cur : res) {
            System.out.print(cur + " ");
        }
    }
}

