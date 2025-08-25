class Solution {
    public int solution(int n) {
        int answer = 0;
        int num = n;
        while(true){
            if(num<=0) break;
            
            answer+=num%10;
            num/=10;
        }
        return answer;
    }
}