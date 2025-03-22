import java.io.*;
import java.util.*;

class Shortcut {
    int start, end, length;
    public Shortcut(int start, int end, int length) {
        this.start = start;
        this.end = end;
        this.length = length;
    }
}

public class Main {
    static int N, D;
    static List<Shortcut> shortcuts;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        shortcuts = new ArrayList<>();
        dist = new int[D + 1];

        for (int i = 0; i <= D; i++) {
            dist[i] = i;
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());

            if (end <= D && end - start > length) {
                shortcuts.add(new Shortcut(start, end, length));
            }
        }

        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                dist[i] = Math.min(dist[i], dist[i - 1] + 1); 
            }
            for (Shortcut s : shortcuts) {
                if (s.start == i && dist[s.end] > dist[i] + s.length) {
                    dist[s.end] = dist[i] + s.length;
                }
            }
        }

        System.out.print(dist[D]);
    }
}
