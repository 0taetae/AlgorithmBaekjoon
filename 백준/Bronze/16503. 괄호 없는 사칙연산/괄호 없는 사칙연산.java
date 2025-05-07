import java.io.*;
import java.util.*;

public class Main {
    static int calculate(int x, int y, String op) {
        switch (op) {
            case "+": return x + y;
            case "-": return x - y;
            case "*": return x * y;
            case "/": return x / y; 
            default: throw new IllegalArgumentException("Invalid operator");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        String op1 = st.nextToken();
        int b = Integer.parseInt(st.nextToken());
        String op2 = st.nextToken();
        int c = Integer.parseInt(st.nextToken());

        int result1 = calculate(calculate(a, b, op1), c, op2); // (a op1 b) op2 c
        int result2 = calculate(a, calculate(b, c, op2), op1); // a op1 (b op2 c)

        int[] results = {result1, result2};
        Arrays.sort(results);
        for (int res : results) {
            System.out.println(res);
        }
    }
}
