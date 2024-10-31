import java.io.*;
import java.util.*;

public class Main {
	
	static int r,c,k;
	static int[][] arr = new int[100][100];
	static int rCnt, cCnt;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		r = Integer.parseInt(st.nextToken())-1;
		c = Integer.parseInt(st.nextToken())-1;
		k = Integer.parseInt(st.nextToken());
		for(int r=0;r<3;r++) {
			st = new StringTokenizer(br.readLine());
			for(int c=0;c<3;c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		rCnt = 3;
		cCnt = 3;
		int time=0;
		boolean isFail = false;
		while(true) {
			if(time>100) {
				System.out.println(-1);
				break;
			}
			if(arr[r][c]==k) {
				System.out.println(time);
				break;
			}
			
			
			// R 연산
			if(rCnt>=cCnt) {
				rOp();
			}
			// C 연산 
			else {
				cOp();
			}
			time++;
		}
		
	}
	
	// 해시 맵 key의 value를 증가시킴 
	// getOrDefault()
	public static void rOp() {
		int res = 0;
		for(int r=0;r<rCnt;r++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int c=0;c<cCnt;c++) {
				if(arr[r][c]==0) continue;
				hm.put(arr[r][c], hm.getOrDefault(arr[r][c], 0)+1);
			}
			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
			list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			    @Override
			    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			        if (o1.getValue() == o2.getValue()) {
			            return o1.getKey() - o2.getKey();
			        }
			        return o1.getValue() - o2.getValue();
			    }
			});
			for(int i=0;i<cCnt;i++) {
				if(arr[r][i]==0) continue;
				arr[r][i] = 0;
			}
			for(int i=0;i<list.size();i++) {
				arr[r][2*i] = list.get(i).getKey();
				arr[r][2*i+1] = list.get(i).getValue();
			}
			res = Math.max(res, list.size()*2);
			
		}
		cCnt = res;
	}
	
	public static void cOp() {
		int res = 0;
		for(int c=0;c<cCnt;c++) {
			HashMap<Integer, Integer> hm = new HashMap<>();
			for(int r=0;r<rCnt;r++) {
				if(arr[r][c]==0) continue;
				hm.put(arr[r][c], hm.getOrDefault(arr[r][c], 0)+1);
			}
			List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hm.entrySet());
			list.sort(new Comparator<Map.Entry<Integer, Integer>>() {
			    @Override
			    public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
			        if (o1.getValue() == o2.getValue()) {
			            return o1.getKey() - o2.getKey();
			        }
			        return o1.getValue() - o2.getValue();
			    }
			});
			for(int i=0;i<rCnt;i++) {
				if(arr[i][c]==0) continue;
				arr[i][c] = 0;
			}
			for(int i=0;i<list.size();i++) {
				arr[2*i][c] = list.get(i).getKey();
				arr[2*i+1][c] = list.get(i).getValue();
			}
			res = Math.max(res, list.size()*2);
		}
		rCnt = res;
	}

}
