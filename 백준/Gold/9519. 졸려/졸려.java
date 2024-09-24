import java.io.*;
import java.util.*;

public class Main {
	
	static int X;
	static ArrayList<String> lst = new ArrayList<String>();
	static String str;
	//static ArrayList<Character> lst = new ArrayList<Character>();
	static ArrayList<String> changelst = new ArrayList<String>();

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		X = Integer.parseInt(br.readLine());
		str = br.readLine();
		for(int i=0;i<str.length();i++) {
			lst.add(str.substring(i,i+1));
		}
		changelst.add(String.join("", lst));
		int moveCnt=0;  // 옮겨야할 문자 개수
		if(str.length()%2==0) {  // 문자열 개수가 짝수인 경우
			moveCnt = str.length()/2-1;
		}else {  // 문자열 개수가 홀수인 경우 
			moveCnt = str.length()/2;
		}
		int cnt=0;
		boolean cal=false;
		while(cnt<X) {
			
			for(int i=2*moveCnt-1;i>=0;i-=2) {
				String move = lst.get(i);
				lst.remove(i);
				lst.add(move);
			}
			cnt++;
			//System.out.println(cnt);
			if(check()) {
				//System.out.println("같아");
				cal=true;
				break;
			}
			changelst.add(String.join("", lst));
		}
		if(cal) {
			System.out.println(changelst.get(X%cnt));
		}else {
			System.out.println(changelst.get(changelst.size()-1));
		}

	}
	// 처음의 문자열과 같은지 확인
	static boolean check() {
		//System.out.println("확인");
		for(int i=0;i<str.length();i++) {
			if(!str.substring(i,i+1).equals(lst.get(i))) {
				//System.out.println(str.substring(i,i+1)+"앞");
				//System.out.println(lst.get(i)+" 뒤");
				//System.out.println("달라");
				return false;
			}
		}
		return true;
	}

}
