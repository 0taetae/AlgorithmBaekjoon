import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int caseNum = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) break;
            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            
            double diameter = 2 * r;
            double diagonal = Math.sqrt(w * w + l * l);
            
            if (diagonal <= diameter) {
                sb.append("Pizza ").append(caseNum).append(" fits on the table.\n");
            } else {
                sb.append("Pizza ").append(caseNum).append(" does not fit on the table.\n");
            }
            caseNum++;
        }
        
        System.out.print(sb);
    }
}
