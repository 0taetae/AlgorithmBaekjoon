class Solution {
    public String solution(String s) {
        int len = s.length();
        String answer = "";
        if(len%2==0){ // 짝수인 경우
            answer+=s.charAt(len/2-1);
            answer+=s.charAt(len/2);
            return answer;
        }
        answer+=s.charAt(len/2);
        return answer;
    }
}