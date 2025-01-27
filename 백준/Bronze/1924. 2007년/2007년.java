import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int month = Integer.parseInt(st.nextToken());
        int day = Integer.parseInt(st.nextToken());

        int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
        
        String[] daysOfWeek = { "SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT" };

        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total += daysInMonth[i];
        }
        total += day;

        String res = daysOfWeek[total % 7];
        System.out.println(res);
    }
}
