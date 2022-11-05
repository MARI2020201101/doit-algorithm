package recurwithdp.makechange;

class MakeChange {
    public static void main(String[] args) {
        System.out.println(makeChange(100,0,0));
    }
    static int[] coins = {25,10,5,1};
    static int count = 0;
    static int makeChange(int n, int value ,int k){
        if(k >= coins.length) {
            System.out.println("value ="+value);
            return 1;
        }
        int result = 0;
        for (int i = 0; i < coins.length && value < n; i++) {
            result+=makeChange(n, value + coins[i],k+1);
        }
        return result;
    }

}
