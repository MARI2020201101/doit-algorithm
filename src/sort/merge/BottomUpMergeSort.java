package sort.merge;

import java.util.Arrays;

class BottomUpMergeSort {
    static int[] arr = {42,32,24,60,15,5,90,45};
    static int[] tmp = new int[arr.length];

    public static void main(String[] args) {
        mergeSort(0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void mergeSort(int start, int end){
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        for (int size = 1; size < end; size+=size) {
            for(int l = 0; l< end-size ; l++){
                merge(tmp, l, (l+size)/2,l+size);
            }
        }
    }
    static void merge(int[] tmp, int start, int mid, int end){
        int idx1 = start;
        int idx2 = mid+1;
        int i = 0;
        while(idx1<=mid && idx2<=end){
            if(tmp[idx1]<tmp[idx2]) {
                arr[i++] = tmp[idx1++];
            }else{
                arr[i++] = tmp[idx2++];
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
