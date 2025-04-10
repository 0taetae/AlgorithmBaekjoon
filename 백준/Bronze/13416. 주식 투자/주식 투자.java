import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); 

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt(); 
            int totalProfit = 0;

            for (int i = 0; i < N; i++) {
                int profitA = scanner.nextInt();
                int profitB = scanner.nextInt();
                int profitC = scanner.nextInt();

                int maxProfit = Math.max(profitA, Math.max(profitB, profitC));

                if (maxProfit > 0) {
                    totalProfit += maxProfit;
                }
            }

            System.out.println(totalProfit);
        }

    }
}
