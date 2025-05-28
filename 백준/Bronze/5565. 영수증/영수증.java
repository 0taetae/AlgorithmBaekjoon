import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int total = Integer.parseInt(br.readLine()); 
        for (int i = 0; i < 9; i++) {
            int price = Integer.parseInt(br.readLine()); 
            total -= price; 
        }
        
        System.out.println(total); 
    }
}
