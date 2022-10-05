package sort.quick;


import java.util.Arrays;

class KthNumber {
    static int[] arr = {4,1,2,3,5};

    public static void main(String[] args) {
        System.out.println(quickSort(0,arr.length-1, 2));
    }
    static int quickSort(int start, int end, int k){
        int pivot = pivot(start, end);
        if(pivot == k) return arr[pivot];
        else if(pivot > k) return quickSort(start, pivot-1, k);
        else return quickSort(pivot+1, end, k);
    }
    static int pivot(int start, int end){
        int mid = (end - start) / 2;
        int pivot = arr[mid];
        swap(arr, start, mid);
        start++;
        while(start<end){
            while(start < pivot) start++;
            while(end > pivot) end--;
            if(start<=end) swap(arr, start++, end--);
        }
        int min = Math.min(start, end);
        swap(arr, min, pivot);
        return min;
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
