class Solution {
    public int[] solution(int[] answers) {
        int[] first = {1,2,3,4,5};//5개 
        int[] second = { 2, 1, 2, 3, 2, 4, 2, 5};//8개 
        int[] third = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};// 10개 
        int[] score = new int[3];
        
        for(int i=0;i<answers.length;i++){
            if(answers[i]==first[i%5]){
                score[0]++;
            }
            if(answers[i]==second[i%8]){
                score[1]++;
            }
            if(answers[i]==third[i%10]){
                score[2]++;
            }
        }
        int maxScore = score[0];
        for(int i=1;i<3;i++){
            if(maxScore < score[i]){
                maxScore = score[i];
            }
        }
        int cnt = 0;
        for(int i=0;i<3;i++){
            if(maxScore == score[i]){
                cnt++;
            }
        }
        int[] answer = new int[cnt];
        int idx = 0;
        for(int i=0;i<3;i++){
            if(maxScore == score[i]){
                answer[idx] = i+1;
                idx++;
            }
        }
        
        return answer;
    }
}