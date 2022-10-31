package combination.present;

import java.util.Arrays;

class Present {
    static int N = 5;
    static int[] dp = new int[N+1];

    public static void main(String[] args) {
        init();
        System.out.println(Arrays.toString(dp));
    }
    static void init(){
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = (i-1) * (dp[i-1] + dp[i-2]);
        }
    }
}
