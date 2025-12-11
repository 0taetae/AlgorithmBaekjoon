class Solution {
    public int solution(int[] num_list) {
        int num_len = num_list.length;
        int[] odd_list = new int[num_len];
        int[] even_list = new int[num_len];
        int odd_cnt = 0;
        int even_cnt = 0;

        // 홀수, 짝수 분리
        for (int i = 0; i < num_len; i++) {
            if (num_list[i] % 2 == 0) { // 짝수
                even_list[even_cnt] = num_list[i];
                even_cnt++;
            } else { // 홀수
                odd_list[odd_cnt] = num_list[i];
                odd_cnt++;
            }
        }

        // 짝수 이어붙이기
        int even = 0;
        for (int j = 0; j < even_cnt; j++) {
            even = even * 10 + even_list[j];
        }

        // 홀수 이어붙이기
        int odd = 0;
        for (int k = 0; k < odd_cnt; k++) {
            odd = odd * 10 + odd_list[k];
        }

        return even + odd;
    }
}
