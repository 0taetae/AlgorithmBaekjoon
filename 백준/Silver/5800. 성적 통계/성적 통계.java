import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int K = Integer.parseInt(br.readLine());
        
        for (int i = 1; i <= K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[] scores = new int[N];
            
            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
            }
            
            Arrays.sort(scores);
            
            int maxScore = scores[N - 1];
            int minScore = scores[0];
            int largestGap = 0;
            
            for (int j = 1; j < N; j++) {
                largestGap = Math.max(largestGap, scores[j] - scores[j - 1]);
            }
            
            sb.append("Class ").append(i).append("\n");
            sb.append("Max ").append(maxScore).append(", Min ").append(minScore).append(", Largest gap ").append(largestGap).append("\n");
        }
        
        System.out.print(sb);
    }
}
