import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int A = scanner.nextInt();
            int B = scanner.nextInt();

            int ratio = A / B;
            int count = ratio * ratio;

            System.out.println(count);
        }

        scanner.close();
    }
}
