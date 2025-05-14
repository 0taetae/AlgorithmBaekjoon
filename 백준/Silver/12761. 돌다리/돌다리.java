import java.util.*;

public class Main {
    static final int MAX = 100000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] visited = new int[MAX + 1];
        Arrays.fill(visited, -1);

        Queue<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == M) {
                System.out.println(visited[cur]);
                return;
            }

            int[] nextMoves = {
                cur - 1, cur + 1,
                cur - A, cur + A,
                cur - B, cur + B,
                cur * A, cur * B
            };

            for (int next : nextMoves) {
                if (next >= 0 && next <= MAX && visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    q.offer(next);
                }
            }
        }
    }
}
