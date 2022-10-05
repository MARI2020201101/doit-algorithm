package sort.merge;

import java.util.Arrays;

class MergeSort {
    static int[] arr = {42,32,24,60,15,5,90,45};

    public static void main(String[] args) {
        sort(0, arr.length-1);
    }
    static void merge(int start, int end){
        int len = end-start+1;
        int[] tmp = new int[len];
        for (int i = 0, j = start; i < len/2+1 ; i++, j+=len/2) {
            System.out.println(String.format("arr[%d], arr[%d]",j,j+len/2 ));
            tmp[i]=Math.min(arr[j], arr[j+len/2]);
        }

        System.out.println("merge : "+Arrays.toString(tmp));
    }
    static void sort(int start, int end){
        int len = end - start + 1;
        if(len==2) {
            if (arr[start] > arr[end]) {
                swap(arr, start, end);
            }
            return;
        }
        int mid = (start + end) / 2;
        sort(start, mid);
        merge(start,mid);
        sort(mid+1, end);
        merge(mid+1,end);
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
