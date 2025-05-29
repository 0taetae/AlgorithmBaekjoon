import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t1 = sc.nextInt();
        int t2 = sc.nextInt();
        int t3 = sc.nextInt();
        int t4 = sc.nextInt();

        int totalSeconds = t1 + t2 + t3 + t4;

        int minutes = totalSeconds / 60;
        int seconds = totalSeconds % 60;

        System.out.println(minutes);
        System.out.println(seconds);

    }
}
