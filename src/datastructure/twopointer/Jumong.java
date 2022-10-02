package datastructure.twopointer;

import java.util.Arrays;

class Jumong {
    public static void main(String[] args) {
        System.out.println(count(9));
    }
    static int[] arr = {2,7,4,1,5,3};
    static int count(int n){
        int start = 0;
        int end = arr.length-1;
        int cnt = 0;
        int[] sorted = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(sorted));
        while(start < end){
            int sum = sorted[start] + sorted[end];
            System.out.println(String.format("sum=%d, start=%d, end=%d",sum, start, end));
            if(sum == n) {
                cnt++;
                start+=1;
                end-=1;
            }else if(sum > n){
                end-=1;
            }else{
                start+=1;
            }
        }
        return cnt;
    }
}
