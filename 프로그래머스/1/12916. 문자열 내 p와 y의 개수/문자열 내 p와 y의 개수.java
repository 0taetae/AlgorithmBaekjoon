class Solution {
    boolean solution(String s) {
        boolean answer = true;
        String str = s.toLowerCase();
        int pCnt = 0;
        int yCnt = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='p'){
                pCnt++;
            }else if(str.charAt(i)=='y'){
                yCnt++;
            }
        }
        
        if(pCnt!=yCnt){
            answer = false;
        }

        return answer;
    }
}