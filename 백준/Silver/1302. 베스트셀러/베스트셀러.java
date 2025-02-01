import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 책의 개수 

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String title = br.readLine();
            map.put(title, map.getOrDefault(title, 0) + 1);
        }

        int maxCnt = 0;
        String bestSeller = "";
        
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String title = entry.getKey();
            int cnt = entry.getValue();
            
            if (cnt > maxCnt || (cnt == maxCnt && title.compareTo(bestSeller) < 0)) {
                maxCnt = cnt;
                bestSeller = title;
            }
        }

        System.out.println(bestSeller);
    }
}
