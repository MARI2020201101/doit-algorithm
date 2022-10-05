package sort.merge;

import java.util.Arrays;

class MergeSort3 {
    static int[] arr = {42,32,24,60,15,5,90,45};
    static int[] tmp = new int[arr.length];

    public static void main(String[] args) {
        mergeSort(0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int start, int end){
        int mid = (start+end)/2;
        int len = end-start+1;
        if(len <= 1) return;
        mergeSort(start, mid);
        mergeSort(mid+1, end);
        for(int i = 0; i< arr.length; i++){
            tmp[i] = arr[i];
        }
        System.out.println("tmp = "+Arrays.toString(tmp));
        int i = start;
        int idx1 = start;
        int idx2 = mid+1;
        System.out.println(String.format("idx1=%d, idx2=%d",idx1,idx2));
        while(idx1 <=mid && idx2 <= end){
            if(tmp[idx1] < tmp[idx2]){
                arr[i++]=tmp[idx1++];
            }else{
                arr[i++]=tmp[idx2++];
            }
        }
        while(idx1 <=mid){
            arr[i++]=tmp[idx1++];
        }
        while(idx2 <= end){
            arr[i++]=tmp[idx2++];
        }


    }
}
