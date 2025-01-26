import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.println(fib(N));
    }

    private static int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0; // F(0)
        int b = 1; // F(1)
        int res = 0;

        for (int i = 2; i <= n; i++) {
            res = a + b;
            a = b;
            b = res;
        }

        return res;
    }
}
