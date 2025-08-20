class Solution {
    public String solution(String my_string) {
        String answer = "";
        char[] text = new char[my_string.length()];
        for(int i=0;i<my_string.length();i++){
            text[i] = my_string.charAt(i);
        }
        for(int i=my_string.length()-1;i>=0;i--){
            answer+=text[i];
        }
        return answer;
    }
}