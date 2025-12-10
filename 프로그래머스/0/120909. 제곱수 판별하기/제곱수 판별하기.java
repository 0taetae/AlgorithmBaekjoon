class Solution {
    public int solution(int n) {
        int answer = 0;
        if(Math.sqrt(n)- Math.floor(Math.sqrt(n))>0){
            answer = 2;
            System.out.println("제곱수가 아님");
        }else{
            System.out.println("제곱수 ");
            answer = 1;
        }
        return answer;
    }
}