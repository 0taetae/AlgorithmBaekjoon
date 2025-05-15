import java.util.*;
class Solution {
    static class Info{
        int num, idx;
        Info(int num, int idx){
            this.num = num;
            this.idx = idx;
        }
    }
    
    public int solution(int[] numbers, int target) {
        int answer = 0;
        
        Queue<Info> q = new LinkedList<>();
        q.add(new Info(numbers[0],0));
        q.add(new Info(numbers[0]*-1,0));
        
        while(!q.isEmpty()){
            Info cur = q.poll();
            int curNum = cur.num;
            int curIdx = cur.idx;
            if(curIdx == numbers.length-1){
                if(curNum==target){
                    answer++;
                }
                continue;
            }
            q.add(new Info(curNum+numbers[curIdx+1],curIdx+1));
            q.add(new Info(curNum-numbers[curIdx+1],curIdx+1));
            
        }
        
        return answer;
    }
}