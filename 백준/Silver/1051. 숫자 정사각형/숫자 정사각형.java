import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] board = new int[N][M];
        
        for (int i = 0; i < N; i++) {
            String row = sc.next();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j) - '0';
            }
        }
        
        int maxSize = 1;
        
        for (int size = 1; size < Math.min(N, M); size++) {
            for (int i = 0; i + size < N; i++) {
                for (int j = 0; j + size < M; j++) {
                    if (board[i][j] == board[i][j + size] && 
                        board[i][j] == board[i + size][j] && 
                        board[i][j] == board[i + size][j + size]) {
                        maxSize = Math.max(maxSize, size + 1);
                    }
                }
            }
        }
        
        System.out.println(maxSize * maxSize);
        
    }
}
