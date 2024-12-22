import java.io.*;
import java.util.*;

public class Main {
	
	static class Node {
        int to, weight;
        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }
	
	static ArrayList<Node>[] tree;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        tree = new ArrayList[V + 1];

        for (int i = 1; i <= V; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < V; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            while (true) {
                int next = Integer.parseInt(st.nextToken());
                if (next == -1) break;
                int dist = Integer.parseInt(st.nextToken());
                tree[node].add(new Node(next, dist));
            }
        }

        dist = new int[V + 1];
        bfs(1);

        int start = find();
        dist = new int[V + 1];
        bfs(start);
        
        System.out.println(Arrays.stream(dist).max().getAsInt());
    }

    static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[tree.length];
        q.add(start);
        visited[start] = true;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : tree[cur]) {
                if (!visited[next.to]) {
                    visited[next.to] = true;
                    q.add(next.to);
                    dist[next.to] = dist[cur] + next.weight;
                }
            }
        }
    }
    
    // 가장 먼 노드 찾기 
    static int find() {
        int maxIdx = 1;
        for (int i = 1; i < dist.length; i++) {
            if (dist[i] > dist[maxIdx]) {
                maxIdx = i;
            }
        }
        return maxIdx;
    }

    
}
