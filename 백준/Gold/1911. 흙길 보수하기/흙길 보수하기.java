import java.io.*;
import java.util.*;

public class Main {
	
	static int N,L;
	//static int start,end;
	//static boolean[] load;
	static class Info{
		int left,right;
		Info(int left, int right){
			this.left = left;
			this.right = right;
		}
	}
	static ArrayList<Info> list = new ArrayList<>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		//start = Integer.MAX_VALUE;
		//end = Integer.MIN_VALUE;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());  // 물웅덩이 수
		L = Integer.parseInt(st.nextToken());  // 널빤지 길이 
		//load = new boolean[1000000001];
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken())-1;
			list.add(new Info(a,b));
			//start = Math.min(start, a);
			//end = Math.max(end, b);
		}
		Collections.sort(list, (o1,o2)->(o1.left - o2.left));
		int res = 0;
		int len = 0;
		for(int i=0;i<N;i++) {
			if(len<=list.get(i).left) {
				len = list.get(i).left;
			}
			
			while(true) {
				if(len >list.get(i).right) {
					break;
				}
				len+=L;
				res++;
			}
		}
		System.out.println(res);
		

	}

}
