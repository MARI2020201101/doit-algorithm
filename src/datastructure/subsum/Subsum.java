package datastructure.subsum;

import java.util.Arrays;

class Subsum {
    public static void main(String[] args) {
        subsum(new int[]{5,4,3,2,1});
    }
    static void subsum(int[] arr){
        int[] sums = new int[arr.length];
        sums[0] = arr[0];
        for(int i=1; i< arr.length; i++){
            sums[i]=arr[i]+sums[i-1];
        }
        System.out.println(Arrays.toString(sums));
    }
}
