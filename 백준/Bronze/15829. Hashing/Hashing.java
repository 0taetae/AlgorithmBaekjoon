import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 문자열 길이 N
        int N = sc.nextInt();
        
        // 문자열 입력
        String str = sc.next();
        
        // 해시 값 초기화
        long hash = 0;
        long powerOf31 = 1;  // 31^i 값을 저장
        
        // 모듈러 값
        long mod = 1234567891;
        
        // 문자열을 순차적으로 처리
        for (int i = 0; i < N; i++) {
            // 현재 문자의 알파벳을 숫자 값으로 변환 (a=1, b=2, ..., z=26)
            int value = str.charAt(i) - 'a' + 1;
            
            // 해시 값에 더함 (문자의 숫자 값 * 31^i)
            hash = (hash + value * powerOf31) % mod;
            
            // 31^i+1 값을 계산 (31^i -> 31^(i+1))
            powerOf31 = (powerOf31 * 31) % mod;
        }
        
        // 결과 출력
        System.out.println(hash);
    }
}
