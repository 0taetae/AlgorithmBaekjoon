import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            if (isGoodWord(word)) {
                cnt++;
            }
        }
        
        System.out.println(cnt);
    }

    private static boolean isGoodWord(String word) {
        Stack<Character> stack = new Stack<>();
        
        for (char cur : word.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == cur) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }
        
        return stack.isEmpty();
    }
}
