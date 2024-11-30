import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine()); // 의상의 개수
            HashMap<String, Integer> clothingMap = new HashMap<>();

            // 의상 정보 입력
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상 이름은 무시
                String category = st.nextToken(); // 의상 종류

                // 종류별 의상 수 카운트
                clothingMap.put(category, clothingMap.getOrDefault(category, 0) + 1);
            }

            // 조합 계산
            int result = 1;
            for (int count : clothingMap.values()) {
                result *= (count + 1); // 입지 않는 경우 포함
            }

            sb.append(result - 1).append('\n'); // 아무것도 입지 않는 경우 제외
        }

        System.out.println(sb);
    }
}
