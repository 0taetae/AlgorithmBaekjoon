class Solution {
    public int solution(int num) {
        int answer = 0;
        
        if(num==1){
            //System.out.println("입력값은 1");
            return 0;
        }
        
        while(true){
            
            if(num%2==0){
                //System.out.println();
                num/=2;
            }
            else if(num%2==1){
                num*=3;
                num++;
            }
            
            answer++;
            //System.out.println("num "+num);
            //System.out.println("answer "+answer);
            
            if(num==1){
                return answer;
            }
            
            if(answer>500&& num!=1){
                return -1;
            }
        }
        
    }
}