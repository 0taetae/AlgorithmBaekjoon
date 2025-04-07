import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String input = br.readLine();
            if (input.equals("0")) break;

            int length = input.length();
            int result = 0;

            for (int i = 0; i < length; i++) {
                int digit = input.charAt(i) - '0';
                result += digit * factorial(length - i);
            }

            System.out.println(result);
        }
    }

    public static int factorial(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
