package sort.merge;

import java.util.Arrays;

class MergeSort2 {
    static int[] arr = {42,32,24,60,15,5,90,45};

    public static void main(String[] args) {
        sort(0, arr.length-1);
    }
    static void sort(int start, int end){
        int len = end - start +1;
        if(len <= 2){
            if(arr[start] > arr[end]) swap(arr, start, end);
            return;
        }
        int mid = (start+end)/2;
        sort(start, mid);
        sort(mid+1, end);
        merge(new int[8], start, mid);
    }
    static void merge(int[] tmp, int left, int right){
        int mid = right;
        int len = (right-left) + mid;
        int idx = 0;
        while(left< mid && right < len){
            if(arr[left] < arr[right]){
                tmp[idx++]=arr[left++];
            }else{
                tmp[idx++]=arr[right++];
            }
        }
        while(left<mid){
            tmp[idx++]=arr[left++];
        }
        while(right < len){
            tmp[idx++]=arr[right++];
        }
        System.out.println(Arrays.toString(tmp));
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
