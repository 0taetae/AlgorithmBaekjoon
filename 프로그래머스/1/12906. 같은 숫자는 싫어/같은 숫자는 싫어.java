import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> list = new ArrayList<>();
        
        int pre = -1;
        for(int i=0;i<arr.length;i++){
            if(pre == arr[i]){ // 연속적으로 나타나는 숫자인 경우
                continue;
            }else{ 
                list.add(arr[i]);
                pre = arr[i];
            }
        }
        int[] answer = new int[list.size()];
        for(int i=0;i<list.size();i++){
            answer[i] = list.get(i);
        }

        return answer;
    }
}