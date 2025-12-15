class Solution {
    public int[] solution(int[] num_list, int n) {
        int num_len = num_list.length;
        int[] answer = new int[num_len-n+1];
        int num = 0;
        for(int i=n-1;i<num_len;i++){
            
            answer[num] = num_list[i];
            num++;
        }
        return answer;
    }
}