package dynamicprogramming.practice01;

import java.util.Arrays;

class MaxSubsum {
    static int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
    static int[] subsum = new int[arr.length];
    static int maxSubsum = 0;

    public static void main(String[] args) {
        calculate();
    }
    static void calculate(){
        subsum[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            subsum[i] = Math.max(arr[i], subsum[i-1] + arr[i]);
        }
        System.out.println(Arrays.toString(subsum));
    }
}
