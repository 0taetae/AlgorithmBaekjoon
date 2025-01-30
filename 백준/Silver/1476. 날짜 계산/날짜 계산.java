import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        
        int year = 1;
        int e = 1, s = 1, m = 1;
        
        while (e != E || s != S || m != M) {
            e++;
            s++;
            m++;
            
            if (e > 15) e = 1;
            if (s > 28) s = 1;
            if (m > 19) m = 1;
            
            year++;
        }
        
        System.out.println(year);
    }
}
