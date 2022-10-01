package dp.knapsack;

class Knapsack {
    static int[] weight = {2,3,4,5};
    static int[] value = {3,4,5,6};
    static int BAG = 5;

    public static void main(String[] args) {
        System.out.println(knapsack(BAG, 0));
    }
    static int knapsack(int capacity, int n){
        if(n == weight.length || capacity <= 0) return 0;
        int max = 0;
//        for (int i = n; i < weight.length; i++) {
//            max= Math.max(knapsack(capacity - weight[i], n + 1) + value[i], knapsack(capacity, n + 1));
//
//        }
        return Math.max(knapsack(capacity - weight[n], n + 1) + value[n], knapsack(capacity, n + 1));
    }
}
