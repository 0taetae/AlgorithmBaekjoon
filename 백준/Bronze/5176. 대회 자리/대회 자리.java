import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int t = 0; t < K; t++) {
            int P = sc.nextInt(); 
            int M = sc.nextInt();

            boolean[] seats = new boolean[M + 1]; 
            int rejected = 0;

            for (int i = 0; i < P; i++) {
                int preferredSeat = sc.nextInt();
                if (!seats[preferredSeat]) {
                    seats[preferredSeat] = true;
                } else {
                    rejected++;
                }
            }

            System.out.println(rejected);
        }
    }
}