import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            
            if (a == 0 && b == 0 && c == 0 && d == 0) {
                break;
            }
            
            int minDiff = c - b;
            int maxDiff = d - a;
            
            sb.append(minDiff).append(" ").append(maxDiff).append("\n");
        }
        
        System.out.print(sb);
    }
}
