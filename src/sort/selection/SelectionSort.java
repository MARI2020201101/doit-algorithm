package sort.selection;

import java.util.Arrays;

class SelectionSort {
    static int[] arr = {42,32,24,60,15};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            int j;
            for (j = i+1; j < arr.length; j++) {
                if(arr[j] < arr[i]) min = j;
            }
            swap(arr, i , min);
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
