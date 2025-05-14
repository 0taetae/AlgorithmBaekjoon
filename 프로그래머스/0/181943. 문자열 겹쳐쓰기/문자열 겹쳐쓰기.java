class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        for(int i=0;i<s;i++){
            answer += my_string.charAt(i);
        }
        answer+=overwrite_string;
        if(s+overwrite_string.length()<my_string.length()){
            for(int i=s+overwrite_string.length();i<my_string.length();i++){
                answer+=my_string.charAt(i);
            }
        }
        return answer;
    }
}