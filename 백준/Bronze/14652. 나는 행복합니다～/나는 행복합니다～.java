import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken()); // 행 개수
        int M = Integer.parseInt(st.nextToken()); // 열 개수
        int K = Integer.parseInt(st.nextToken()); // 좌석 번호
        
        int row = K / M; // 행 번호
        int col = K % M; // 열 번호
        
        System.out.print(row + " " + col);
    }
}