import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
class Solution
{
	static int N, res;
	static int[] weight,sorted;
	static boolean[] isSelected;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		for(int T = 1 ; T<=tc ; T++) {
			N = Integer.parseInt(br.readLine());
			weight = new int[N];
			sorted = new int[N];
			isSelected = new boolean[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i =0 ; i < N ; i++) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			res = 0;
			perm(0);
			
			sb.append("#").append(T).append(" ").append(res).append("\n");
		}
		System.out.println(sb.toString());
		br.close();
	}
	
	// 무게를 올려놓는 순서 정하기 
	private static void perm(int cnt) {
		if(cnt == N) {
			scale(0,0,0);
		}
		for(int i = 0 ; i < N ; i++) {
			if(isSelected[i]) continue;
			sorted[cnt] = weight[i];
			isSelected[i] = true;
			perm(cnt+1);	
			isSelected[i] = false;
		}
	}
	
	// 양팔저울에 올릴 경우의 수를 계산
	private static void scale(int cnt, int left, int right) {
		// 왼쪽의 무게보다 오른쪽의 무게가 많을 때
		if(left<right) return;
		if(cnt == N) {
			res++;
			return;
		}
		scale(cnt+1, left, right+sorted[cnt]);		//오른쪽에 올렸을 때
		scale(cnt+1, left+sorted[cnt], right);		//왼쪽에 올렸을 때
	}
}