package datastructure.subsum;

import java.util.Arrays;

class Subsum4 {
    static int[] arr = {1,2,3,1,2};
    static int D = 3;

    public static void main(String[] args) {
        System.out.println(subsum());
    }
    static int subsum(){
        int[] sum = new int[arr.length];
        int[] remain = new int[D];
        int cnt = 0;
        for (int i = 0; i < sum.length; i++) {
            if(i==0) sum[i] = arr[i] % D;
            else sum[i] = (arr[i] + sum[i-1]) % D;
        }
        for (int i = 0; i < sum.length; i++) {
            remain[sum[i]]++;
        }
        for (int i = 0; i < remain.length; i++) {
            if(i==0) cnt += remain[i];
            if(remain[i]!=0) cnt += remain[i]*(remain[i]-1) / 2;
        }
        return cnt;
    }
}
