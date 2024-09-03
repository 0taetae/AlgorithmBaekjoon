import java.io.*;
import java.util.*;

public class Solution {
	
	static int[] num;
	static int res, K, temp;
	static boolean[] visited;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st ;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int i=1;i<=T;i++) {
			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			num = new int[str.length()];  // 숫자판 정보 
			for(int j=0;j<str.length();j++) {
				num[j] = str.charAt(j)-'0';
			}
			K = Integer.parseInt(st.nextToken());  // 교환 횟수
			K= Math.min(K, str.length());  // 최대 문자열 길이 6, 교환 횟수가 5이상이면 의미가 없음 
			visited = new boolean[(int) Math.pow(10,str.length())];
			res = 0;
			change(0);
			sb.append("#").append(i).append(" ").append(res).append("\n");
		}
		System.out.println(sb);
	}
	public static void change(int cnt) {
		
		if(cnt==K) {
			int sum=0;
			for(int i=0;i<num.length;i++) {
				sum += num[i]*Math.pow(10, num.length-i-1);
			}
			if(!visited[sum]) {
				res = Math.max(res, sum);
			}
			visited[sum]=true;
			return;
		}
		for(int i=0;i<num.length;i++) {
			for(int j=i+1;j<num.length;j++) {
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
				
				change(cnt+1);
				
				temp = num[i];
				num[i] = num[j];
				num[j] = temp;
			}
		}
	}
}
