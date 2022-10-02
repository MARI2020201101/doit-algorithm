package datastructure;

import java.util.Arrays;

class Subsum3 {
    public static void main(String[] args) {
        System.out.println(subsum(new int[]{1,2,3,1,2}, 3));
    }
    static int subsum(int[] arr, int d){
        int[] tmpSums = new int[arr.length];
        tmpSums[0] = arr[0];
        for (int i = 1; i < tmpSums.length; i++) {
            tmpSums[i] = tmpSums[i-1] + arr[i];
        }
        int[] sums = Arrays.stream(tmpSums).map(a -> a % d).toArray();
        int cnt = 0;
        int n = 0;
        for (int j = 1; j < d; j++) {
            for (int i = 0; i < sums.length; i++) {
                if (sums[i] == 0){
                    cnt++;
                    continue;
                }
                if (sums[i] == j) n++;
                }
            cnt+=nCr(n, 2);
            n=0;
            }
        return cnt;
        }


    static int nCr(int n, int r){
        int result = 1;
        for (int i=n; i>=n-r+1; i--) {
            result*=i;
        }
        for(int i=r; i>=1; i--){
            result/=i;
        }
        return result;
    }
}
