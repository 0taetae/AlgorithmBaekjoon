import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        long result = (long) A * B * C;

        int[] count = new int[10];

        String str = Long.toString(result);
        for (int i = 0; i < str.length(); i++) {
            int digit = str.charAt(i) - '0'; 
            count[digit]++;
        }

        for (int i = 0; i < 10; i++) {
            System.out.println(count[i]);
        }

        sc.close();
    }
}
