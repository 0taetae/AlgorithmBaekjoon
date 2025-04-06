import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tripNumber = 0;
        final double PI = 3.1415927;
        final double INCHES_PER_MILE = 63360;
        final double SECONDS_PER_HOUR = 3600;

        while (true) {
            double diameter = scanner.nextDouble();
            int revolutions = scanner.nextInt();
            double time = scanner.nextDouble();

            if (revolutions == 0) {
                break;
            }

            tripNumber++;
            double distanceInMiles = (diameter * PI * revolutions) / INCHES_PER_MILE;
            double speedInMph = distanceInMiles / (time / SECONDS_PER_HOUR);

            System.out.printf("Trip #%d: %.2f %.2f%n", tripNumber, distanceInMiles, speedInMph);
        }
        scanner.close();
    }
}
