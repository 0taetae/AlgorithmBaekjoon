class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        int len = s.length();
        if (len != 4 && len !=6){
            answer = false;
            return answer;
        }
        for(int i=0;i<s.length();i++){
            if (s.charAt(i) < '0' || s.charAt(i) > '9') {
                answer = false;
                return answer;
            }
            
        }
        
        return answer;
    }
}