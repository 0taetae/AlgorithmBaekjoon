import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        int cnt = count(N);
        
        System.out.println(cnt);
    }

    private static boolean isOk(int num) {
        if (num < 100) {
            return true;
        }
        
        int hundred = num / 100;
        int ten = (num / 10) % 10;
        int one = num % 10;
        
        return (hundred - ten) == (ten - one);
    }

    private static int count(int N) {
        int cnt = 0;
        for (int i = 1; i <= N; i++) {
            if (isOk(i)) {
                cnt++;
            }
        }
        return cnt;
    }
}
