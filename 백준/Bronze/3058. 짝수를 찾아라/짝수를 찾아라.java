import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;
            int minEven = Integer.MAX_VALUE;
            
            for (int i = 0; i < 7; i++) {
                int num = Integer.parseInt(st.nextToken());
                if (num % 2 == 0) {
                    sum += num;
                    minEven = Math.min(minEven, num);
                }
            }
            sb.append(sum).append(" ").append(minEven).append("\n");
        }
        
        System.out.print(sb);
    }
}