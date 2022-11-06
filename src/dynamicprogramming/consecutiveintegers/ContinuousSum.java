package dynamicprogramming.consecutiveintegers;

class ContinuousSum {
    static int[] arr = {10,-4,3,1,5,6,-35,12,21,-1};
    static int[] leftMaxSum = new int[arr.length];
    static int[] rightMaxSum = new int[arr.length];

    static void calculate(){
        int idx = 0;
        for (int i = 0; i < arr.length; i++) {
            leftMaxSum[idx] = Math.max(leftMaxSum[i],leftMaxSum[i]+arr[i]);
        }
    }
}
