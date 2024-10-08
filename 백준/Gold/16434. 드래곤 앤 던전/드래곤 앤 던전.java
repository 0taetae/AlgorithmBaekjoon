import java.io.*;
import java.util.*;

public class Main {

	static int N, atk;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		atk = Integer.parseInt(st.nextToken());
		arr = new int[N][3];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		long start = 1;
		long end = Long.MAX_VALUE / 2;  // 너무 큰 범위를 줄여줌
		long result = end;

		// 이진 탐색
		while (start <= end) {
			long mid = (start + end) / 2;

			if (check(mid)) {  // 주어진 maxHp로 살아남을 수 있다면
				result = mid;  // 그 값이 최소일 가능성이 있으므로 저장
				end = mid - 1; // 더 작은 값이 가능한지 탐색
			} else {
				start = mid + 1; // 더 큰 값으로 탐색
			}
		}

		System.out.println(result);  // 살아남기 위한 최소의 최대 생명력 출력
	}

	private static boolean check(long maxHp) {
		long curHP = maxHp;  // 용사의 현재 생명력
		long curAtk = atk;   // 용사의 현재 공격력 

		for (int i = 0; i < N; i++) {
			long t = arr[i][0];  // 방의 종류 (1: 몬스터, 2: 포션)
			long a = arr[i][1];  // t=1, 몬스터의 공격력 or t=2, 포션의 공격력 증가량
			long h = arr[i][2];  // t=1, 몬스터의 생명력 or t=2, 포션의 회복량

			// 몬스터 방
			if (t == 1) {
				// 몬스터를 쓰러뜨리기 위한 용사의 공격 횟수
				long atkCount = (h + curAtk - 1) / curAtk;  // 몬스터를 쓰러뜨리는 데 필요한 공격 횟수
				long cnt = atkCount - 1;  // 몬스터가 공격하는 횟수
				curHP -= cnt * a;  // 몬스터가 공격한 만큼 용사의 체력 감소

				// 용사가 죽으면 false 반환
				if (curHP <= 0) {
					return false;
				}
			}
			// 포션 방
			else if (t == 2) {
				curAtk += a;  // 용사의 공격력을 a만큼 증가
				curHP = Math.min(curHP + h, maxHp);  // 용사의 생명력 회복 (최대 생명력을 넘지 않도록)
			}
		}

		return true;  // 끝까지 살아남으면 true 반환
	}
}
