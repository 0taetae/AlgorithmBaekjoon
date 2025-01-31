import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        StringBuilder word = new StringBuilder();
        boolean inTag = false;

        for (char c : input.toCharArray()) {
            if (c == '<') {
                sb.append(word.reverse()); 
                word.setLength(0); 
                inTag = true;
                sb.append(c);
            } else if (c == '>') {
                inTag = false;
                sb.append(c);
            } else if (inTag) {
                sb.append(c);
            } else {
                if (c == ' ') {
                    sb.append(word.reverse()).append(' ');
                    word.setLength(0); 
                } else {
                    word.append(c);
                }
            }
        }

        sb.append(word.reverse()); 
        System.out.println(sb);
    }
}
