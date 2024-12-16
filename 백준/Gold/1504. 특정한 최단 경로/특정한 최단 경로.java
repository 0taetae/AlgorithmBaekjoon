import java.io.*;
import java.util.*;

public class Main {
    static int N, E;

    static class Info implements Comparable<Info> {
        int end, cost;

        Info(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Info o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static ArrayList<Info>[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        list = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Info(v, w));
            list[v].add(new Info(u, w));
        }

        st = new StringTokenizer(br.readLine());
        int target1 = Integer.parseInt(st.nextToken());
        int target2 = Integer.parseInt(st.nextToken());

        long dist1 = find(1, target1) + find(target1, target2) + find(target2, N);
        long dist2 = find(1, target2) + find(target2, target1) + find(target1, N);

        long result = Math.min(dist1, dist2);
        System.out.println(result >= 200000000 ? -1 : result);
    }

    public static int find(int a, int b) {
        PriorityQueue<Info> pq = new PriorityQueue<>();
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 200000000);
        dist[a] = 0;

        pq.add(new Info(a, 0));

        while (!pq.isEmpty()) {
            Info cur = pq.poll();
            if (cur.cost > dist[cur.end]) continue;

            for (Info edge : list[cur.end]) {
                if (dist[edge.end] > dist[cur.end] + edge.cost) {
                    dist[edge.end] = dist[cur.end] + edge.cost;
                    pq.add(new Info(edge.end, dist[edge.end]));
                }
            }
        }

        return dist[b];
    }
}
