class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;
        int t = sizes.length;
        int aMax = 0;
        int bMax = 0;
        
        for(int i=0;i<t;i++){
            if(sizes[i][0]<sizes[i][1]){
                if(aMax<sizes[i][1]){
                    aMax = sizes[i][1];
                }
                if(bMax<sizes[i][0]){
                    bMax = sizes[i][0];
                }
            }
            else if(sizes[i][0]>sizes[i][1]){
                if(aMax<sizes[i][0]){
                    aMax = sizes[i][0];
                }
                if(bMax<sizes[i][1]){
                    bMax = sizes[i][1];
                }
            }else{
                if(aMax<sizes[i][0]){
                    aMax = sizes[i][0];
                }
                if(bMax<sizes[i][1]){
                    bMax = sizes[i][1];
                }
            }
        }
        answer = bMax * aMax;
        return answer;
    }
}