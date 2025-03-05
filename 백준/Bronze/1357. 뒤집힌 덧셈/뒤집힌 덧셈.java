import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int X = reverse(Integer.parseInt(input[0]));
        int Y = reverse(Integer.parseInt(input[1]));
        
        int result = reverse(X + Y);
        
        System.out.print(result);
    }
    
    private static int reverse(int num) {
        StringBuilder sb = new StringBuilder(String.valueOf(num));
        return Integer.parseInt(sb.reverse().toString());
    }
}
