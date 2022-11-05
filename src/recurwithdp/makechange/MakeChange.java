package recurwithdp.makechange;

class MakeChange {
    public static void main(String[] args) {
        System.out.println(makeChange(100,0));
    }
    static int[] coins = {25,10,5,1};
    static int count = 0;
    static int makeChange(int n, int value){
        if(n == value) return 1;

        int result = 0;
        for (int i = 0; i < coins.length && coins[i]+value < n; i++) {
            count+=makeChange(n, value + coins[i]);
        }
        return count;
    }

}
