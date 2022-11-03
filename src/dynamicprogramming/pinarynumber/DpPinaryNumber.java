package dynamicprogramming.pinarynumber;

import java.util.Arrays;

class DpPinaryNumber {
    static int N = 6;
    static int[][] dp = new int[N][2];

    public static void main(String[] args) {
        solve();
        print(dp);
        System.out.println("answer = "+ (dp[N-1][0] + dp[N-1][1]));
    }
    static void solve(){
        dp[0][0] = 0;
        dp[0][1] = 1;
        for (int i = 0; i < dp.length-1; i++) {
            dp[i+1][0] = dp[i][0] + dp[i][1];
            dp[i+1][1] = dp[i][0];
        }
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
