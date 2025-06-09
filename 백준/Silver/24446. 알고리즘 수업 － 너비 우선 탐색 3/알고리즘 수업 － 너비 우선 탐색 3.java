import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] adj;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); // 정점 수
        M = Integer.parseInt(st.nextToken()); // 간선 수
        R = Integer.parseInt(st.nextToken()); // 시작 정점

        adj = new ArrayList[N + 1];
        depth = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            adj[i] = new ArrayList<>();
            depth[i] = -1; 
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            adj[u].add(v);
            adj[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(adj[i]);
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            System.out.println(depth[i]);
        }
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        visited[start] = true;
        depth[start] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : adj[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
