import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] visited;
    static class Info{
    	int num,cnt;
    	Info(int num, int cnt){
    		this.num = num;
    		this.cnt = cnt;
    	}
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        
        list = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        System.out.println(getCnt());
    }

    static int getCnt() {
        Queue<Info> q = new LinkedList<>();
        visited = new boolean[N + 1];
        
        q.offer(new Info(1,0));
        visited[1] = true;
        int cnt = 0;

        while (!q.isEmpty()) {
            Info cur = q.poll();
            int person = cur.num;
            int depth = cur.cnt;

            if (depth >= 2) continue;

            for (int friend : list.get(person)) {
                if (!visited[friend]) {
                    visited[friend] = true;
                    q.offer(new Info(friend,depth+1));
                    cnt++;
                }
            }
        }

        return cnt;
    }
}