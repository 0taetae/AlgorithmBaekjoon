import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean[] isNot = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            int dn = get(i);
            if (dn <= 10000) {
                isNot[dn] = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10000; i++) {
            if (!isNot[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int get(int n) {
        int sum = n;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
}
