import java.io.*;
import java.util.*;

public class Main {
	static int INF = 1000000000;
    static int V, E;
    static int[][] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());  // 마을 개수
        E = Integer.parseInt(st.nextToken());  // 도로 개수 
        dist = new int[V + 1][V + 1];

        for (int i = 1; i <= V; i++) {
            Arrays.fill(dist[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());  // 거리 
            dist[a][b] = c;
        }

        for (int k = 1; k <= V; k++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
        
        // 최소 사이클의 도로 길이의 합 구하기 
        int minCycle = INF;
        for (int i = 1; i <= V; i++) {
            if (dist[i][i] < minCycle) {
                minCycle = dist[i][i];
            }
        }

        System.out.println(minCycle == INF ? -1 : minCycle);
    }
}