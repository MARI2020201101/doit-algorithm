package sort.insertion;

import java.lang.reflect.Array;
import java.util.Arrays;

class InsertionSort {
    static int[] arr = {42,32,28,60,15};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for (int i = 1; i < arr.length; i++) {
            int idx = i;
            int j;
            for (j = 0; j < i; j++) {
                System.out.println(String.format("j=%d, idx=%d",j, idx));
                if(arr[j] > arr[i]) {
                    idx--;
                }
            }
            swap(arr, idx , i);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
