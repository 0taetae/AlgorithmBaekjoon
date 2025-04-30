import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;

        while (true) {
            int input = sc.nextInt();
            if (input == -1) {
                break;
            }
            sum += input;
        }

        System.out.println(sum);
    }
}
