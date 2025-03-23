import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {
            int startHour = sc.nextInt();
            int startMinute = sc.nextInt();
            int startSecond = sc.nextInt();

            int endHour = sc.nextInt();
            int endMinute = sc.nextInt();
            int endSecond = sc.nextInt();

            int startTotalSeconds = startHour * 3600 + startMinute * 60 + startSecond;
            int endTotalSeconds = endHour * 3600 + endMinute * 60 + endSecond;

            int workSeconds = endTotalSeconds - startTotalSeconds;

            int workHours = workSeconds / 3600;
            int workMinutes = (workSeconds % 3600) / 60;
            int workSecondsRemaining = workSeconds % 60;

            System.out.println(workHours + " " + workMinutes + " " + workSecondsRemaining);
        }

        sc.close();
    }
}
