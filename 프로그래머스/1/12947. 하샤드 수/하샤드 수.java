class Solution {
    public boolean solution(int x) {
        int num = x;
        int sum = 0;
        while(true){
            
            sum+=num%10;
            if(num<10){
                break;
            }
            num/=10;
        }
        boolean answer = true;
        if(x%sum==0){
            return answer;
        }
        answer = false;
        return answer;
    }
}