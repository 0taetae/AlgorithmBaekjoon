import java.io.*;
import java.util.*;

public class Main {

    public static class Info {
        String str;
        int cnt;

        Info(String str, int cnt) {
            this.str = str;
            this.cnt = cnt;
        }
    }

    public static int N, K;
    public static int[] arr;
    public static Set<String> set = new HashSet<>();
    public static String str, ans;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }

        str = "";
        for(int i=0;i<N;i++) {
        	str+=arr[i];
        }

        Arrays.sort(arr);
        ans = "";
        for(int i=0;i<N;i++) {
        	ans+=arr[i];
        }

        System.out.println(bfs(str));
    }

    public static int bfs(String str) {
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(str, 0));
        set.add(str);

        while (!q.isEmpty()) {
            Info cur = q.poll();

            if (cur.str.equals(ans)) {
            	return cur.cnt;
            }

            for (int i = 0; i <= N - K; i++) {
                String newStr = reverse(cur.str, i, i + K);

                if (!set.contains(newStr)) {
                	set.add(newStr);
                    q.add(new Info(newStr, cur.cnt + 1));
                }
            }
        }

        return -1;
    }

    // 문자열 뒤집기 
    public static String reverse(String str, int start, int end) {
        char[] charArr = str.toCharArray();
        while (start < end - 1) {
            char temp = charArr[start];
            charArr[start] = charArr[end - 1];
            charArr[end - 1] = temp;
            start++;
            end--;
        }
        return new String(charArr);
    }
}
