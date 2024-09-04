import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[][] arr;
	static int[][] turnInfo;
	static int[] isSelected;
	static boolean[] visit;
	static int N, M, K;
	static int res;
	static int[][] copyarr;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 배열의 행 크기
		M = Integer.parseInt(st.nextToken());  // 배열의 열 크기
		K = Integer.parseInt(st.nextToken());  // 회전 연산의 개수
		
		arr = new int[N+1][M+1];
		copyarr = new int[N+1][M+1];
		turnInfo = new int[K+1][4];
		isSelected = new int[K];
		visit = new boolean[K+1];
		
		for(int r=1; r<=N;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=M;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				copyarr[r][c] = arr[r][c];
			}
		}
		
		for(int r=1;r<=K;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=1;c<=3;c++) {
				turnInfo[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		res = Integer.MAX_VALUE;
		perm(0,isSelected,visit);
		
		System.out.println(res);
		
		
	}
	
	// 회전정보를 행할 순서를 정하는 순열
	public static void perm(int cnt, int[] isSelected, boolean[] visit ) {
		if(cnt == K) {
			
			//System.out.println("****해당 경우 시작****");
			reset();
			for(int i=0;i<K;i++) {
				//System.out.println("몇번째 회전정보 사용"+isSelected[i]);
				turn(turnInfo[isSelected[i]][1], turnInfo[isSelected[i]][2],turnInfo[isSelected[i]][3]);
			}
			int value = check();
			//System.out.println("해당 경우 배열의 값*******"+value);
			res = Math.min(res, value);
			//reset();
			return;
		}
		for(int i=1;i<=K;i++) {
			if(!visit[i]) {
				visit[i] = true;
				isSelected[cnt] = i;
				perm(cnt+1, isSelected, visit);
				visit[i] = false;
			}
		}
	}
	
	// 배열을 돌림
	public static void turn(int r, int c, int s) {
		
		while(true) {
			//System.out.println("회전시작");
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=M;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			//System.out.println("회전정보"+r+" "+c+" "+s+" ");
			if((r-s == r+s) &&(c-s==c+s)) {
				//System.out.println("회전끝");
				break;
			}
			int temp = arr[r-s][c-s];
			//System.out.println("temp:"+temp);
			// 위로 옮기기
			//System.out.println("위로 옮기기");
			for(int i=r-s;i<r+s;i++) {
				arr[i][c-s] = arr[i+1][c-s];
				//System.out.println(i+" "+(c-s)+" "+arr[i][c-s]);
			}
			//System.out.println("왼쪽으로 옮기기");
			// 왼쪽으로 옮기기
			for(int i=c-s;i<c+s;i++) {
				arr[r+s][i] = arr[r+s][i+1];
				//System.out.println((r+s)+" "+i+" "+arr[r+s][i]);
			}

			// 아래로 옮기기
			//System.out.println("아래로 옮기기");
			for(int i=r+s;i>r-s;i--) {
				arr[i][c+s] = arr[i-1][c+s];
				//System.out.println(i+" "+(c+s)+" "+arr[i][c+s]);
			}
			// 오른쪽으로 옮기기
			//System.out.println("오른쪽으로 옮기기");
			for(int i=c+s;i>=c-s+2;i--) {
				arr[r-s][i] = arr[r-s][i-1];
				//System.out.println((r-s)+" "+i+" "+arr[r-s][i]);
			}
			arr[r-s][c-s+1] = temp;
			
			//System.out.println(arr[r-s][c-s+1]);
			//System.out.println(arr[r-s][c-s+1]);
//			for(int i=1;i<=N;i++) {
//				for(int j=1;j<=M;j++) {
//					System.out.print(arr[i][j]+" ");
//				}
//				System.out.println();
//			}
			s--;
		}
		
	}
	
	// 배열을 돌린 결과에서 행의 합 -> 최솟값
	public static int check() {
		int result = Integer.MAX_VALUE;
		for(int r=1;r<=N;r++) {
			int sum=0;
			for(int c=1;c<=M;c++) {
				sum += arr[r][c];
			}
			result = Math.min(result, sum);
		}
		return result;
	}
	public static void reset() {
		for(int r=0;r<=N;r++) {
			for(int c=0;c<=M;c++) {
				arr[r][c] = copyarr[r][c];
			}
		}
	}
}
