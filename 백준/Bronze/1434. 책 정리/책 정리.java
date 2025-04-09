import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int N = scanner.nextInt();
        int M = scanner.nextInt();

        int[] box = new int[N];
        int[] book = new int[M];

        for (int i = 0; i < N; i++) {
            box[i] = scanner.nextInt();
        }

        for (int i = 0; i < M; i++) {
            book[i] = scanner.nextInt();
        }

        int currentBox = 0;

        for (int i = 0; i < M; i++) {
            while (currentBox < N) {
                if (box[currentBox] >= book[i]) {
                    box[currentBox] -= book[i];
                    break;
                } else {
                    currentBox++;
                }
            }
        }

        int remainingCapacity = 0;

        for (int i = 0; i < N; i++) {
            remainingCapacity += box[i];
        }

        System.out.println(remainingCapacity);

    }
}
