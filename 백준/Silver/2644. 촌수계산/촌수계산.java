import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int person; // 사람 번호
        int depth;  // 촌수

        Node(int person, int depth) {
            this.person = person;
            this.depth = depth;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken()); 
        int end = Integer.parseInt(st.nextToken());   
        
        int m = Integer.parseInt(br.readLine()); 
        
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }
        
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }
        
        int result = bfs(list, start, end, n);
        System.out.println(result);
    }

    private static int bfs(List<List<Integer>> list, int start, int end, int n) {
        boolean[] visited = new boolean[n + 1];
        Queue<Node> q = new LinkedList<>();
        
        q.offer(new Node(start, 0));
        visited[start] = true;
        
        while (!q.isEmpty()) {
            Node cur = q.poll();
            
            if (cur.person == end) {
                return cur.depth;
            }
            
            for (int next : list.get(cur.person)) {
                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(new Node(next, cur.depth + 1));
                }
            }
        }
        
        return -1;
    }
}

