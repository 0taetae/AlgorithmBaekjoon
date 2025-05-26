import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String num = sc.nextLine();

            if (num.equals("0")) break;

            int width = 2; 

            for (int i = 0; i < num.length(); i++) {
                char c = num.charAt(i);
                if (c == '1') {
                    width += 2;
                } else if (c == '0') {
                    width += 4;
                } else {
                    width += 3;
                }

                if (i != num.length() - 1) {
                    width += 1; 
                }
            }

            System.out.println(width);
        }

    }
}
