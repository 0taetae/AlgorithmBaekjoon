import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int K = Integer.parseInt(input[0]);
        int N = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        
        int totalCost = K * N;
        int result = Math.max(0, totalCost - M);
        
        System.out.print(result);
    }
}
