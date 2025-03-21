import java.io.*;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] W = new int[10];
        int[] K = new int[10];

        for (int i = 0; i < 10; i++) {
            W[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 10; i++) {
            K[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(W);
        Arrays.sort(K);

        int wSum = W[9] + W[8] + W[7];
        int kSum = K[9] + K[8] + K[7];

        System.out.print(wSum + " " + kSum);
    }
}
