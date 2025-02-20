import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(2 * (n - i)));
            sb.append("*".repeat(i)).append("\n");
        }

        for (int i = n - 1; i >= 1; i--) {
            sb.append("*".repeat(i));
            sb.append(" ".repeat(2 * (n - i)));
            sb.append("*".repeat(i)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }
}
