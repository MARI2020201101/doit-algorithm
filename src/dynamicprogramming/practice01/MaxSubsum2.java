package dynamicprogramming.practice01;

import java.util.Arrays;

class MaxSubsum2 {
    static int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
    static int N = arr.length;
    static int[] leftSubsum = new int[N];
    static int[] rightSubsum = new int[N];

    public static void main(String[] args) {
        calculate();
    }

    static void calculate(){
        leftSubsum[0] = arr[0];
        for (int i = 1; i < N; i++) {
            leftSubsum[i] = Math.max(arr[i], leftSubsum[i-1] + arr[i]);
        }
        rightSubsum[0] = arr[N-1];
        for (int i = 1; i < N; i++) {
            rightSubsum[i] = Math.max(arr[N-i-1], rightSubsum[i-1] + arr[N-i-1]);
        }
        System.out.println(Arrays.toString(leftSubsum));
        System.out.println(Arrays.toString(rightSubsum));
    }
}
