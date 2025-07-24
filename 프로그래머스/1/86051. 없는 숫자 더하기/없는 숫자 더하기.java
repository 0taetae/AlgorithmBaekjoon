class Solution {
    public int solution(int[] numbers) {
        boolean[] isFind = new boolean[10];
        int answer = -1;
        for(int i=0;i<numbers.length;i++){
            isFind[numbers[i]] = true;
        }
        for(int i=0;i<10;i++){
            if(!isFind[i]){
                if(answer==-1){
                    answer = 0;
                }
                answer+=i;
            }
        }
        return answer;
    }
}