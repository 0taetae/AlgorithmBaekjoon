import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        for (int i = 1; i <= 5; i++) {
            String agent = br.readLine();
            if (agent.contains("FBI")) {
                sb.append(i).append(" ");
            }
        }
        
        if (sb.length() == 0) {
            System.out.print("HE GOT AWAY!");
        } else {
            System.out.print(sb.toString().trim());
        }
    }
}
