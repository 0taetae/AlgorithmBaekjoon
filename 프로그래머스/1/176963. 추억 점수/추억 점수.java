class Solution {
    public int[] solution(String[] name, int[] yearning, String[][] photo) {
        
        int row = photo.length;
        int cnt = name.length; // 그러워하는 사람 수
        
        int[] answer = new int[row];
        for(int r=0;r<row;r++){
            int sum=0;
            for(int c=0;c<photo[r].length;c++){
                for(int i=0;i<cnt;i++){
                    if(photo[r][c].equals(name[i])){
                        sum+=yearning[i];
                        break;
                    }
                }
            }
            answer[r] = sum;
        }
        return answer;
    }
}