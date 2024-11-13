import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] input = br.readLine().split(" ");
        int[] notes = new int[8];
        
        // 8개의 음계를 정수로 변환하여 배열에 저장
        for (int i = 0; i < 8; i++) {
            notes[i] = Integer.parseInt(input[i]);
        }
        
        String result = "";
        boolean asc = true;
        boolean desc = true;
        
        for (int i = 0; i < 7; i++) {
            if (notes[i] < notes[i+1]) {
                desc = false;
            } else if (notes[i] > notes[i+1]) {
                asc = false;
            }
        }
        
        if (asc) {
            result = "ascending";
        } else if (desc) {
            result = "descending";
        } else {
            result = "mixed";
        }
        
        System.out.println(result);
        br.close();
    }
}