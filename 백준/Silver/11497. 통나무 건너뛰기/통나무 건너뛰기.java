import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int i=0;i<T;i++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			ArrayList<Integer> log = new ArrayList<Integer>();
			ArrayList<Integer> result = new ArrayList<Integer>();
			
			for(int j=0;j<N;j++) {
				log.add(Integer.parseInt(st.nextToken()));
			}
			Collections.sort(log);
			
			for(int j=0;j<N;j+=2) {
				result.add(log.get(j));
			}
			if(N%2==0) {
				for(int j=N-1;j>0;j-=2) {
					result.add(log.get(j));
				}
			}else {
				for(int j=N-2;j>0;j-=2) {
					result.add(log.get(j));
				}
			}
			int max = 0;
			for(int j=0;j<N-1;j++) {
				max = Math.max(max, Math.abs(result.get(j+1)-result.get(j)));
			}
			System.out.println(max);
			
		}
	}

}
