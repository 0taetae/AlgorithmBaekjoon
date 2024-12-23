import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] up = new int[N];  // 증가
		int[] down = new int[N];  // 감소
		
		// 증가하는지 확인 
		for(int i=0;i<N;i++) {
			up[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j]<arr[i]) {  // 증가하는 경우 
					up[i] = Math.max(up[i], up[j]+1);
				}
			}
		}
		// 감소하는지 확인
		for(int i=N-1;i>=0;i--) {
			down[i] = 1;
			for(int j=N-1;j>i;j--) {
				if(arr[j]<arr[i]) {  // 증가하는 경우 
					down[i] = Math.max(down[i], down[j]+1);
				}
			}
		}
		
		// 가장 긴 바이토닉 수열의 길이 구하기 
		int res = 0;
		for(int i=0;i<N;i++) {
			res = Math.max(res, up[i]+down[i]-1);
		}
		
		System.out.println(res);
	}

}
