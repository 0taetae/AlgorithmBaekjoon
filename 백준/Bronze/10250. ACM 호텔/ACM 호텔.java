import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine()); 
        
        StringBuilder sb = new StringBuilder(); 
        
        for (int i = 0; i < T; i++) {
            String[] input = br.readLine().split(" ");
            int H = Integer.parseInt(input[0]); 
            int W = Integer.parseInt(input[1]);
            int N = Integer.parseInt(input[2]); 
            
            int floor = N % H; 
            int roomNumber = N / H + 1; 
            
            if (floor == 0) { 
                floor = H;
                roomNumber -= 1;
            }
            
            sb.append(floor * 100 + roomNumber).append("\n");
        }
        
        System.out.print(sb.toString()); 
    }
}
