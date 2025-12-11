class Solution {
    public String solution(String my_string, String letter) {
        String answer = "";
        for (int i = 0; i < my_string.length(); i++) {
            char cur = my_string.charAt(i); 
            if (cur == letter.charAt(0)) {
                continue;
            } else {
                answer += cur;
            }
        }
        return answer;
    }
}