import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();

        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}
