import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int sum = 0;
        int sumOfCubes = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
            sumOfCubes += i * i * i;
        }

        System.out.println(sum);
        System.out.println(sum * sum);
        System.out.println(sumOfCubes);
    }
}
