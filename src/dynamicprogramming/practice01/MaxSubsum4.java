package dynamicprogramming.practice01;

import java.util.Arrays;

class MaxSubsum4 {
    static int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
    static int N = arr.length;
    static int[] leftSubsum = new int[N];
    static int[] rightSubsum = new int[N];

    public static void main(String[] args) {
        calculate();
    }

    static void calculate(){
        leftSubsum[0] = arr[0];
        int currMax = 0;
        for (int i = 1; i < N; i++) {
            leftSubsum[i] = Math.max(arr[i], leftSubsum[i-1] + arr[i]);
            currMax = Math.max(currMax, leftSubsum[i]);
        }
        rightSubsum[N-1] = arr[N-1];
        for (int i = N-2; i >= 0; i--) {
            rightSubsum[i] = Math.max(arr[i], rightSubsum[i+1] + arr[i]);
        }
        System.out.println(Arrays.toString(leftSubsum));
        System.out.println(Arrays.toString(rightSubsum));
        for (int i = 1; i < N-1; i++) {
            currMax = Math.max(currMax , leftSubsum[i-1] + rightSubsum[i+1]);
        }
        System.out.println("currMAx = "+currMax);
    }
}
