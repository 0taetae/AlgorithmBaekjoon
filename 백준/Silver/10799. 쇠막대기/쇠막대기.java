import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        Stack<Character> stack = new Stack<>();
        int res = 0;

        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if (cur == '(') {
                stack.push(cur);
            } else { 
                stack.pop();
                if (input.charAt(i - 1) == '(') {
                    res += stack.size();
                } else {
                    res++;
                }
            }
        }

        System.out.println(res);
    }
}
