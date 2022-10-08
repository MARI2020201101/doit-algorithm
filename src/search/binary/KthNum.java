package search.binary;

import java.util.Arrays;

class KthNum {
    public static void main(String[] args) {
        System.out.println(kthNum(3, 7));
    }
    static int kthNum(int n, int k){
        int[] arr = new int[n * n];
        int idx = 0;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <=n ; j++) {
                arr[idx++] = i*j;
            }
        }
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        return arr[k];
    }
}
