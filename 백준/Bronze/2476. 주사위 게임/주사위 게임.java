import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        
        int maxPrize = 0;
        
        for (int i = 0; i < N; i++) {
            String[] dice = br.readLine().split(" ");
            int a = Integer.parseInt(dice[0]);
            int b = Integer.parseInt(dice[1]);
            int c = Integer.parseInt(dice[2]);

            int prize = 0;

            if (a == b && b == c) {
                prize = 10000 + a * 1000;
            }
            else if (a == b || b == c || a == c) {
                if (a == b || a == c) {
                    prize = 1000 + a * 100;
                } else {
                    prize = 1000 + b * 100;
                }
            }
            else {
                int max = Math.max(a, Math.max(b, c));
                prize = max * 100;
            }

            maxPrize = Math.max(maxPrize, prize);
        }

        System.out.println(maxPrize);
    }
}
