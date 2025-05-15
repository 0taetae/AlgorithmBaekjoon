class Solution {
    public long solution(int a, int b) {
        long answer = 0;
        if(a<=b){
            for(int i=0;i<b-a+1;i++){
                answer+=(a+i);
            }
        }
        if(a>b){
            for(int i=0;i<a-b+1;i++){
                answer+=(b+i);
            }
        }
        
        return answer;
    }
}