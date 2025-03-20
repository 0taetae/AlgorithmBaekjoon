import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int[] numbers = new int[3];
        for (int i = 0; i < 3; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(numbers);
        
        String order = br.readLine();
        
        StringBuilder sb = new StringBuilder();
        for (char c : order.toCharArray()) {
            if (c == 'A') sb.append(numbers[0]).append(" ");
            else if (c == 'B') sb.append(numbers[1]).append(" ");
            else sb.append(numbers[2]).append(" ");
        }
        
        System.out.print(sb.toString().trim());
    }
}
