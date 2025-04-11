import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String A = sc.next();
        String B = sc.next();

        StringBuilder result = new StringBuilder();

        int lenA = A.length();
        int lenB = B.length();

        int i = lenA - 1;
        int j = lenB - 1;

        while (i >= 0 && j >= 0) {
            int sum = (A.charAt(i) - '0') + (B.charAt(j) - '0');
            result.insert(0, sum);
            i--;
            j--;
        }

        while (i >= 0) {
            result.insert(0, A.charAt(i));
            i--;
        }

        while (j >= 0) {
            result.insert(0, B.charAt(j));
            j--;
        }

        System.out.println(result.toString());
    }
}
