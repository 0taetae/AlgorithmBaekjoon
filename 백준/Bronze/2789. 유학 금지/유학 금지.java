import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        
        String target = "CAMBRIDGE";
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            boolean isOk = false;
            
            for (int j = 0; j < target.length(); j++) {
                if (c == target.charAt(j)) {
                    isOk = true;
                    break;
                }
            }
            
            if (!isOk) {
                sb.append(c);
            }
        }
        
        System.out.println(sb.toString());
    }
}
