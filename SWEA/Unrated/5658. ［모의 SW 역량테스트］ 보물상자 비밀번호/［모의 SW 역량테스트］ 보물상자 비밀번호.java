import java.io.*;
import java.util.*;

public class Solution {
	
	static int N,K;
	static char[] box, copyBox;
	static HashSet<String> set;
	static ArrayList<Integer> lst;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T;tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());  // 숫자의 개수
			K = Integer.parseInt(st.nextToken());  // 크기 순서 (K번째로 큰 수) 
			String str = br.readLine();
			box = new char[N];
			copyBox = new char[N];  // 처음 상태와 비교할 배열 
			set = new HashSet<String>();
			lst = new ArrayList<Integer>();
			for(int i=0;i<N;i++) {
				box[i] = str.charAt(i);
				copyBox[i] = str.charAt(i);
			}
			turn();
			change();
			Collections.sort(lst, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return o2-o1;
				}
			});
			sb.append("#").append(tc).append(" ").append(lst.get(K-1)).append("\n");
		}
		System.out.println(sb);
	}
	static void turn() {
		while(true) {
			
			createNum();
			char temp = box[N-1];
			for(int i=N-1;i>=1;i--) {
				box[i] = box[i-1];
			}
			box[0] = temp;
			
			if(Arrays.equals(box, copyBox)) {
				break;
			}
		}
	}
	static void createNum() {
        for (int i = 0; i < N; i += N/4) {
            String num = "";
            for (int j = 0; j < N/4; j++) {
                num += box[i + j];
            }
            set.add(num);
        }
	}
	static void change() {
		for(String num : set) {
			lst.add(Integer.parseInt(num,16));
		}
	}

}
