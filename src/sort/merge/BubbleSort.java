package sort.merge;

import java.util.Arrays;

class BubbleSort {
    static int[] arr = {3,2,8,1,7,4,5,6};
    static int[] tmp = new int[arr.length];
    static int swaped = 0;
    public static void main(String[] args) {
        sort(0, arr.length-1);
    }
    static void sort(int start, int end){
        if(start == end) return;
        int mid = (start+end)/2;

        sort(start, mid);
        sort(mid+1, end);

        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        int i = start;
        int idx1 = start;
        int idx2 = mid+1;
        while(idx1 <= mid && idx2 <= end){
            if(tmp[idx1] < tmp[idx2]){
                arr[i++] = tmp[idx1++];
            }else{
                swaped = swaped + idx2-i;
                arr[i++] = tmp[idx2++];
            }
        }
        while(idx1 <= mid){
            arr[i++] = tmp[idx1++];
        }
        while(idx2 <= end){
            arr[i++] = tmp[idx2++];
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("swaped = " + swaped);
    }
}
