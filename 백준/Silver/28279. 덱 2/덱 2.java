import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int cmd = Integer.parseInt(st.nextToken());
            
            switch (cmd) {
                case 1:
                    deque.addFirst(Integer.parseInt(st.nextToken()));
                    break;
                case 2:
                    deque.addLast(Integer.parseInt(st.nextToken()));
                    break;
                case 3:
                    sb.append(deque.isEmpty() ? -1 : deque.removeFirst()).append('\n');
                    break;
                case 4:
                    sb.append(deque.isEmpty() ? -1 : deque.removeLast()).append('\n');
                    break;
                case 5:
                    sb.append(deque.size()).append('\n');
                    break;
                case 6:
                    sb.append(deque.isEmpty() ? 1 : 0).append('\n');
                    break;
                case 7:
                    sb.append(deque.isEmpty() ? -1 : deque.peekFirst()).append('\n');
                    break;
                case 8:
                    sb.append(deque.isEmpty() ? -1 : deque.peekLast()).append('\n');
                    break;
            }
        }
        
        System.out.print(sb);
    }
}
