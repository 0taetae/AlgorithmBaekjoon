import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken()); 

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            deque.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int[] targets = new int[m];

        for (int i = 0; i < m; i++) {
            targets[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        for (int target : targets) {
            int index = 0;

            for (int num : deque) {
                if (num == target) break;
                index++;
            }

            if (index <= deque.size() / 2) {
                for (int i = 0; i < index; i++) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                for (int i = 0; i < deque.size() - index; i++) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }

            deque.pollFirst();
        }

        System.out.println(cnt);
    }
}