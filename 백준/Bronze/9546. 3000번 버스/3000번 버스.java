import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < T; i++) {
            int K = Integer.parseInt(br.readLine());
            sb.append(getPassengers(K)).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static int getPassengers(int K) {
        int passengers = 1;
        for (int i = 1; i < K; i++) {
            passengers = passengers * 2 + 1;
        }
        return passengers;
    }
}
