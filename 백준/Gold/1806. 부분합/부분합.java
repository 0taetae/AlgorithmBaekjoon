import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int start = 0;
        int end = 0;
        int sum = 0;
        int minCnt = Integer.MAX_VALUE;

        while (end < N) {
            sum += arr[end];

            while (sum >= S) {
                minCnt = Math.min(minCnt, end - start+1);
                sum -= arr[start];
                start++;
            }
            end++;
        }
        if(minCnt==Integer.MAX_VALUE) {
        	System.out.println(0);
        }else {
        	System.out.println(minCnt);
        }
    }
}

