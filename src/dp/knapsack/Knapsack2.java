package dp.knapsack;

class Knapsack2 {
    public static void main(String[] args) {
        knapsack();
    }
    static int[] weight = {2,3,4,5};
    static int[] value = {3,4,5,6};
    static int BAG = 5;
    static int knapsack(){
        int[][] dp = new int[weight.length + 1][BAG + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                int x = weight[i-1];
                if(x<=j) dp[i][j] = Math.max(dp[i-1][j-x] + value[i-1], dp[i-1][j]);
                else dp[i][j] = dp[i-1][j];
            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j] +" ");
            }
            System.out.println();
        }
        return 1;

    }
}
