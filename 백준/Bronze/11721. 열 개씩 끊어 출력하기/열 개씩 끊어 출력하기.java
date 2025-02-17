import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int length = s.length();
        int i = 0;
        while (i < length) {
            for (int j = 0; j < 10 && i < length; j++, i++) {
                System.out.print(s.charAt(i));
            }
            System.out.println();
        }
    }
}
