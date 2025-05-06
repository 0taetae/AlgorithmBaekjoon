import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static List<List<Integer>> graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        dist = new int[N + 1];
        Arrays.fill(dist, -1);
        bfs(1);

        int maxDist = 0;
        int minIndex = 0;
        int count = 0;

        for (int i = 1; i <= N; i++) {
            if (dist[i] > maxDist) {
                maxDist = dist[i];
                minIndex = i;
                count = 1;
            } else if (dist[i] == maxDist) {
                count++;
                if (i < minIndex) {
                    minIndex = i;
                }
            }
        }

        System.out.println(minIndex + " " + maxDist + " " + count);
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        dist[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : graph.get(current)) {
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue.add(next);
                }
            }
        }
    }
}
