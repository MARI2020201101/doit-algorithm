package dynamicprogramming.ntoone;

import java.util.Arrays;

class NToOne {
    static int N = 10;
    static int[] dp = new int[N+1];

    public static void main(String[] args) {
        init();
        System.out.println(Arrays.toString(dp));
        System.out.println("answer = " + dp[N]);
    }
    static void init(){
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 2; i < dp.length; i++) {

            if(i % 3 == 0){
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1 ;
            }else if(i % 2 == 0){
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1 ;
            }else{
                dp[i] = dp[i-1] + 1 ;
            }
        }
    }
}
