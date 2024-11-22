import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 사람 수 입력
        int n = Integer.parseInt(br.readLine());
        
        // 키와 몸무게 배열
        int[][] people = new int[n][2];
        
        // 입력받기
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            people[i][0] = Integer.parseInt(st.nextToken()); // 몸무게
            people[i][1] = Integer.parseInt(st.nextToken()); // 키
        }
        
        // 결과 배열
        int[] rank = new int[n];
        
        // 순위 계산
        for (int i = 0; i < n; i++) {
            rank[i] = 1; // 기본 순위는 1
            for (int j = 0; j < n; j++) {
                if (i != j && people[i][0] < people[j][0] && people[i][1] < people[j][1]) {
                    rank[i]++;
                }
            }
        }
        
        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int r : rank) {
            sb.append(r).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}
