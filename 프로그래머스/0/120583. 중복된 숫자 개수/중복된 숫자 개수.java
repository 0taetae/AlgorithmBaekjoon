class Solution {
    public int solution(int[] array, int n) {
        int answer = 0;
        int[] check = new int[1000];
        for(int i=0;i<array.length;i++){
            check[array[i]]++;
            
        }
        answer = check[n];
        return answer;
    }
}