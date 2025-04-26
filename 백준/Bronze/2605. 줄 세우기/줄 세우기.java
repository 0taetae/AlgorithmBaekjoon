import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] moves = new int[n];
        for (int i = 0; i < n; i++) {
            moves[i] = sc.nextInt();
        }

        LinkedList<Integer> line = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            line.add(i - moves[i], i + 1);
        }

        for (int num : line) {
            System.out.print(num + " ");
        }
    }
}
