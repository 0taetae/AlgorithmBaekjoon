import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(br.readLine());
        
        List<Integer> horizontalCuts = new ArrayList<>();
        List<Integer> verticalCuts = new ArrayList<>();
        
        horizontalCuts.add(0);
        horizontalCuts.add(height);
        verticalCuts.add(0);
        verticalCuts.add(width);
        
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            
            if (type == 0) {
                horizontalCuts.add(position);
            } else {
                verticalCuts.add(position);
            }
        }
        
        Collections.sort(horizontalCuts);
        Collections.sort(verticalCuts);
        
        int maxH = 0;
        for (int i = 1; i < horizontalCuts.size(); i++) {
            maxH = Math.max(maxH, horizontalCuts.get(i) - horizontalCuts.get(i - 1));
        }
        
        int maxW = 0;
        for (int i = 1; i < verticalCuts.size(); i++) {
            maxW = Math.max(maxW, verticalCuts.get(i) - verticalCuts.get(i - 1));
        }
        
        System.out.print(maxH * maxW);
    }
}