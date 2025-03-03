import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 0; t < T; t++) {
            int N = Integer.parseInt(br.readLine()); 
            int totalCredits = 0;
            double totalGradePoints = 0.0;
            
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int credits = Integer.parseInt(st.nextToken());
                double grade = Double.parseDouble(st.nextToken());
                
                totalCredits += credits;
                totalGradePoints += credits * grade;
            }
            
            double gpa = totalGradePoints / totalCredits;
            sb.append(totalCredits).append(" ").append(String.format("%.1f", gpa)).append("\n");
        }
        
        System.out.print(sb);
        br.close();
    }
}