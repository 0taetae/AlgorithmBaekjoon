import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] div = new int[N];
        
        for (int i = 0; i < N; i++) {
            div[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(div);
        
        int num = div[0] * div[N - 1];
        
        System.out.println(num);
    }
}
