class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        int drink10 = n/10;
        answer = n*12000 + (k-drink10)*2000;
        return answer;
    }
}