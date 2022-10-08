package greedy;

class MinCoins {
    static int[] coins = {50000, 10000,5000,1000,500,100,50,10,5,1};
    static int money=4200;

    public static void main(String[] args) {
        count();
    }
    static int count(){
        int m = money;
        int count = 0;
        int i = 0;
        while(m!=0 && i<coins.length){
            count += m / coins[i];
            m %= coins[i++];
        }
        System.out.println(count);
        return count;
    }
}
