import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] rope = new int[n];
        for (int i = 0; i < n; i++) {
            rope[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(rope);

        int maxWeight = 0;
        for (int i = 0; i < n; i++) {
            int currentWeight = rope[i] * (n - i);
            maxWeight = Math.max(maxWeight, currentWeight);
        }
        
        System.out.println(maxWeight);
    }
}
