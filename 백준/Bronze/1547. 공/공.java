import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] cup = new int[4];
        cup[1] = 1; 

        int m = sc.nextInt(); 

        for (int i = 0; i < m; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            int temp = cup[x];
            cup[x] = cup[y];
            cup[y] = temp;
        }

        for (int i = 1; i <= 3; i++) {
            if (cup[i] == 1) {
                System.out.println(i);
                break;
            }
        }

    }
}
