class Solution {
    public int solution(int[] num_list) {
        int answer = 0;
        boolean isOk = false;
        for(int i=0;i<num_list.length;i++){
            if(num_list[i]<0){
                answer = i;
                isOk = true;
                break;
            }
        }
        if(!isOk){
            answer = -1;
        }
        return answer;
    }
}