package recurwithdp.makechange;

class MakeChange3 {
    public static void main(String[] args) {
        System.out.println(makeChange(100, coins, 0));
    }
    static int[] coins = {25,10,5,1};
    static int makeChange(int amount, int[] coins, int index){
        if(index >= coins.length-1) return 1;
        int coinAmount = coins[index];
        int ways = 0;
        for (int i = 0; i*coinAmount <= amount; i++) {
            int remainAmount = amount - (i * coinAmount);
            ways += makeChange(remainAmount, coins, index + 1);
        }
        return ways;
    }
}
