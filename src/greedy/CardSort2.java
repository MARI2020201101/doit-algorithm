package greedy;

import java.util.Arrays;

class CardSort2 {
    static int[] cards = {10,20,40};
    static int N = cards.length;
    static boolean[] selected = new boolean[N];
    static int[] value = new int[N];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        System.out.println(count(0,0));
    }
    static int count(int count, int n){
        if(n==N) return value[N-1] + value[N-2];
        for (int i = 0; i < N; i++) {
            if(! selected[i]){
                selected[i] = true;
                value[n] = count + cards[i];
                min=Math.min(min, count(value[n], n+1));
                selected[i] = false;
            }
        }
        System.out.println(Arrays.toString(value));
        return min;
    }

}
