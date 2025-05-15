class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ");
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<str.length;i++){
            int cur = Integer.parseInt(str[i]);
            if(max<=cur){
                max = cur;
            }
            if(min>=cur){
                min = cur;
            }
        }
        answer += min+" "+max;
        
        return answer;
    }
}