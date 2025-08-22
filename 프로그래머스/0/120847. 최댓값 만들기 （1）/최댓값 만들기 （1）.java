class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        for(int i=0;i<numbers.length-1;i++){
            for(int j=i+1;j<numbers.length;j++){
                int res = numbers[i]*numbers[j];
                if(res>answer){
                    answer = res;
                }
            }
        }
        return answer;
    }
}