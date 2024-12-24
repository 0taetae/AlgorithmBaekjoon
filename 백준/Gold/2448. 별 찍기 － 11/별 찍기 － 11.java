import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new char[N][2 * N - 1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                map[i][j] = ' ';
            }
        }

        star(0, N - 1, N);
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < N; i++) {
        	for(int j=0;j<2*N-1;j++) {
        		sb.append(map[i][j]);
        	}
        	sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    static void star(int x, int y, int size) {
        if (size == 3) {
            map[x][y] = '*';
            map[x + 1][y - 1] = '*';
            map[x + 1][y + 1] = '*';
            for (int i = 0; i < 5; i++) {
                map[x + 2][y - 2 + i] = '*';
            }
            return;
        }

        int newSize = size / 2;
        star(x, y, newSize);
        star(x + newSize, y - newSize, newSize);
        star(x + newSize, y + newSize, newSize);
    }
}

