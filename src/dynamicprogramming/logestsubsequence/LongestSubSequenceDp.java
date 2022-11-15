package dynamicprogramming.logestsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubSequenceDp {
    static int[] arr ={11,5,10,12,7,14,3,8,24,2};
    static int N = arr.length;
    static int[] longestLength = new int[N];

    public static void main(String[] args) {
        solve();
        System.out.println(Arrays.toString(longestLength));
    }
    static void solve(){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[i] > arr[j]){
                    ++count;
                }
            }
            longestLength[i] = count;
        }
    }
}
