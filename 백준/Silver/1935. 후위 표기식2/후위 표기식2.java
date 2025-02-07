import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); 
        String expression = br.readLine(); 
        double[] values = new double[n]; 

        for (int i = 0; i < n; i++) {
            values[i] = Double.parseDouble(br.readLine());
        }

        Stack<Double> stack = new Stack<>();

        for (char ch : expression.toCharArray()) {
            if (Character.isLetter(ch)) {
                stack.push(values[ch - 'A']);
            } else { 
                double b = stack.pop();
                double a = stack.pop();
                switch (ch) {
                    case '+': stack.push(a + b); break;
                    case '-': stack.push(a - b); break;
                    case '*': stack.push(a * b); break;
                    case '/': stack.push(a / b); break;
                }
            }
        }

        System.out.printf("%.2f\n", stack.pop()); 
    }
}
