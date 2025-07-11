class Solution {
    public int[] solution(int[] arr) {
        int len = arr.length;
        System.out.println(len);
        if(len==1){
            int[] answer = {-1};
            return answer;
        }
        int minN = Integer.MAX_VALUE;
        for(int i=0;i<len;i++){
            if(arr[i]<minN){
                minN = arr[i];
            }
        }
        int[] answer = new int[len-1];
        int idx=0;
        for(int i=0;i<len;i++){
            if(arr[i]==minN){
                continue;
            }
            answer[idx]=arr[i];
            idx++;
        }
        
        return answer;
    }
}