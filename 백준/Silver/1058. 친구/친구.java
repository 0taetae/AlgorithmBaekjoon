import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		char[][] friend = new char[N][N];
		
		boolean[][] check = new boolean[N][N];  // 2-친구인지 
		
		for(int i=0;i<N;i++) {
			String str = br.readLine();
			for(int j=0;j<N;j++) {
				friend[i][j] = str.charAt(j);
			}
		}
		int max = 0;
		int twofriend ;  // 2-친구의 수 
		
		for(int i=0;i<N;i++) {
			twofriend=0;
			for(int j=0;j<N;j++) {
				if(friend[i][j]=='Y') {  // A와 B가 친구인 경우
					check[i][j]=true;  // 2-친구
					for(int k=0;k<N;k++) {
						if(friend[j][k]=='Y') {  // B와 C가 친구인 경우
							check[i][k] = true;  // A와 C가 친구 -> 2-친구
						}
					}
				}
				
			}
			for(int j=0;j<N;j++) {
				if(i==j) {  // A와 A는 친구가 아님 
					continue;
				}else if(check[i][j]) {
					twofriend++;
				}
			}
			max = Math.max(max, twofriend);
		}
		System.out.println(max);
	}

}