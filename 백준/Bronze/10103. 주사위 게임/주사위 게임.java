import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int rounds = sc.nextInt();
        int cScore = 100;
        int sScore = 100;

        for (int i = 0; i < rounds; i++) {
            int cRoll = sc.nextInt();
            int sRoll = sc.nextInt();

            if (cRoll > sRoll) {
                sScore -= cRoll;
            } else if (cRoll < sRoll) {
                cScore -= sRoll;
            }
        }

        System.out.println(cScore);
        System.out.println(sScore);

    }
}
