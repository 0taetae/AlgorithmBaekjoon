import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine()); 
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < C; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); 
            int[] scores = new int[N];
            int sum = 0;

            for (int j = 0; j < N; j++) {
                scores[j] = Integer.parseInt(st.nextToken());
                sum += scores[j];
            }

            double average = (double) sum / N; 
            int count = 0;

            for (int score : scores) {
                if (score > average) {
                    count++;
                }
            }

            double percentage = (double) count / N * 100; 
            sb.append(String.format("%.3f", percentage)).append("%\n");
        }
        
        System.out.print(sb);
    }
}
