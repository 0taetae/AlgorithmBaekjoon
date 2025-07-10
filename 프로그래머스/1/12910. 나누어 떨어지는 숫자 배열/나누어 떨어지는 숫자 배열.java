import java.util.*;
class Solution {
    public int[] solution(int[] arr, int divisor) {
        
        int len = arr.length;
        int cnt=0;
        boolean[] check = new boolean[len];
        //System.out.println(len);
        for(int i=0;i<len;i++){
            if(arr[i]%divisor==0){
                check[i] = true;
                cnt++;
            }
        }
        if(cnt==0){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[cnt];
        int idx=0;
        for(int i=0;i<len;i++){
            if(check[i]){
                answer[idx] = arr[i];
                idx++;
            }
        }
        System.out.println(idx);
        Arrays.sort(answer);
        return answer;
    }
}