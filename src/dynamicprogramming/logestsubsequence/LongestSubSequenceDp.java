package dynamicprogramming.logestsubsequence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LongestSubSequenceDp {
    static int[] arr ={11,5,10,12,7,14,3,8,24,2};
    static int N = arr.length;
    static int[] longestLength = new int[N];
    static int maxLength = 0;
    static List<Integer> answer = new ArrayList<>();

    public static void main(String[] args) {
        solve();
        System.out.println(Arrays.toString(longestLength));
        System.out.println(maxLength);
        answer.forEach((e)-> System.out.print(e + " "));
    }
    static void solve(){
        longestLength[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            int count = 1;
            for (int j = i-1; j >= 0 ; j--) {
                if(arr[j] < arr[i]){
                    count = Math.max(count, longestLength[j]+1);
                }
            }
            longestLength[i] = count;
            maxLength = Math.max(maxLength, count);
        }
        int index = maxLength;
        for(int i = longestLength.length-1 ; i >= 0 && index > 0 ; i--){
            if(longestLength[i] == index){
                answer.add(arr[i]);
                --index;
            }
        }
        Collections.reverse(answer);
    }
}
