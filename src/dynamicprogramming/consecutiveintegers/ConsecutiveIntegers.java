package dynamicprogramming.consecutiveintegers;

class ConsecutiveIntegers {
    static int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
    static int max = 0;

    public static void main(String[] args) {
        recur(0,0);
    }
    static void recur(int k, int sum){
        if(max <  sum){
            max = sum;
            System.out.println("max = "+ sum);
        }
        for (int i = k; i < arr.length; i++) {
            System.out.println(String.format("i=%d sum=%d, arr[k]=%d",i,sum,arr[k]));
            recur(i + 1, sum + arr[k]);
        }

    }
}
