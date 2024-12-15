import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			int k = Integer.parseInt(br.readLine());
			// treeMap : 이진 탐색 트리 형태로 데이터를 저장 
			TreeMap<Integer, Integer> map = new TreeMap<>();
			
			for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String com = st.nextToken();
                int value = Integer.parseInt(st.nextToken());

                if (com.equals("I")) {
                    map.put(value, map.getOrDefault(value, 0) + 1);
                } else if (com.equals("D")) {
                    if (map.isEmpty()) continue;

                    if (value == 1) {
                        int maxKey = map.lastKey();
                        if (map.get(maxKey) == 1) {
                            map.remove(maxKey);
                        } else {
                            map.put(maxKey, map.get(maxKey) - 1);
                        }
                    } else if (value == -1) {
                        int minKey = map.firstKey();
                        if (map.get(minKey) == 1) {
                            map.remove(minKey);
                        } else {
                            map.put(minKey, map.get(minKey) - 1);
                        }
                    }
                }
            }
			if (map.isEmpty()) {
                sb.append("EMPTY\n");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
            }
		}
		
		System.out.println(sb);
	}

}
