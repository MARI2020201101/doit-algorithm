package sort.quick;

import java.util.Arrays;

class QuickSort {
    static int[] arr = {42,32,24,60,15,5,90,45};

    public static void main(String[] args) {
//        sort();
        for(int i = arr.length-1 ; i > 1 ; i--){
            quickSort(0, i-1, i);
        }
    }
    static void quickSort(int start, int end, int pivot){
        int target = arr[pivot];
        while (start < end){
            while(arr[start] < target) start++;
            while(arr[end] > target) end--;
            System.out.println(String.format("start =%d, end =%d", start,end));
            if(start<=end) swap(arr, start, end);

        }
        int idx = Math.max(start, end);
        for (int i = pivot; i > idx; i--) {
            arr[i] = arr[i-1];
        }
        arr[idx] = target;
        System.out.println(Arrays.toString(arr));
    }
    static void sort(){
        int start = 0;
        int pivot = arr.length-1;
        int end = pivot-1;
        int target = arr[pivot];
        while (start < end){
            while(arr[start] < target) start++;
            while(arr[end] > target) end--;
            System.out.println(String.format("start =%d, end =%d", start,end));
            if(start<=end) swap(arr, start, end);

        }
        int idx = Math.max(start, end);
        for (int i = pivot; i > idx; i--) {
            arr[i] = arr[i-1];
        }
        arr[idx] = target;
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
