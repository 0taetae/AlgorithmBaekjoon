/////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
class Solution
{
	static int D, W, K;
	static int result;
	static int[][] film;
	static int[][] filmCopy;
    public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */

		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			D = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			film = new int[D][W];
			filmCopy = new int[D][W];
			
			for (int r = 0; r < D; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < W; c++) {
					film[r][c] = filmCopy[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			result = Integer.MAX_VALUE;
			
			/*if(K == 1) {
				result = 0;
				sb.append("#").append(i).append(" ").append(0).append("\n");
				continue;
			}*/
			test(0, 0);
			sb.append("#").append(i).append(" ").append(result).append("\n");
			
		}
		System.out.println(sb);
	}
	
	// 약품 A, 약품 B 투입했을 때 확인 
	static void test(int r, int count) {
		if(check()) {
			// 투입횟수 최솟값 구하기 
			result = Math.min(result, count);
			return;
		}
		
		
		for (int i = r; i < D; i++) {
			
			// 약품 A를 투입했을 때
			Arrays.fill(film[i], 0);
			test(i+1, count+1);
			
			// 약품 B를 투입했을 때 
			Arrays.fill(film[i], 1);
			test(i+1, count+1);
			
			// 배열 되돌리기 
			film[i] = Arrays.copyOf(filmCopy[i], W);
		}
	}
	
	// 성능 검사 
	static boolean check() {
		for (int c = 0; c < W; c++) {
			int count = 1;
			boolean success = false;
			for (int r = 0; r < D-1; r++) {
				if(film[r][c] == film[r+1][c]) count++;
				else count = 1;//연속적이지 않은 경우 1로 세팅해 다시 카운트 시작하게 함
				
				if(count == K) {//성능 검사 통과
					success = true;
					break;
				}
			}
			if(!success) return false;
		}
		
		return true;
	}
}