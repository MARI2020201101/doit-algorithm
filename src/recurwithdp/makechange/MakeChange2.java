package recurwithdp.makechange;

class MakeChange2 {
    public static void main(String[] args) {
        System.out.println(makeChange(100,0));
    }
    static int[] coins = {25,10,5,1};
    static int makeChange(int value, int k){
        int result = 0;
        if(value == 0) return 1;
        if(value < 0) return 0;
        int curr = value;
        for(int i = 0; i < coins.length ; i++){
            System.out.println(String.format("value=%d, k=%d",value,k));
            value -= coins[i];
            result += makeChange(value, k+1);

        }
        return result;
    }
}
