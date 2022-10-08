package search.binary;

import java.util.Arrays;

class BlueRay2 {
    static int[] arr = {1,2,3,4,5,6,7,8,9};
    static int N = 3;
    static int LEN = arr.length;
    static int[] blueray = new int[N];

    public static void main(String[] args) {
        blueray();
    }
    static void blueray(){
        int start = arr[LEN-1];
        int end = Arrays.stream(arr).sum();
        int min = Integer.MAX_VALUE;
        while(start<=end){
            int optimal = (start+end)/2;
            int idx = 0;
            for (int i = 0; i < blueray.length; i++) {
                while(blueray[i]<=optimal && idx<LEN) blueray[i]+=arr[idx++];
            }
            if(idx==LEN) {
                end=optimal-1;
            }else if(idx<LEN){
                start=optimal+1;
            }
            min = Math.min(min, optimal);
        }
        System.out.println("min="+min);
    }
}
