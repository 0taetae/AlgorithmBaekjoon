import java.io.*;
import java.util.*;

public class Main {
	
	static ArrayList<Integer>[] tree;
    static int[] subtree;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());  // 정점의 수
        int R = Integer.parseInt(st.nextToken());  // 루트의 번호 
        int Q = Integer.parseInt(st.nextToken());  // 쿼리의 수

        tree = new ArrayList[N + 1];
        subtree = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int target = Integer.parseInt(br.readLine());
            sb.append(subtree[target]).append("\n");
        }
        
        System.out.print(sb);
    }

    static int dfs(int node) {
        visited[node] = true;
        subtree[node] = 1;  // 자기 자신 포함

        for (int child : tree[node]) {
            if (!visited[child]) {
            	subtree[node] += dfs(child);
            }
        }
        
        return subtree[node];
    }
}