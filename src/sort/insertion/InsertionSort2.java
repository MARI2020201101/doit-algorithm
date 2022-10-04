package sort.insertion;

import java.util.Arrays;

class InsertionSort2 {
    static int[] arr = {42,32,28,60,15};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >0 ; j--) {
                if(arr[j-1] > arr[j]) swap(arr, j-1, j);
            }
        }
        System.out.println(Arrays.toString(arr));
    }
    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
