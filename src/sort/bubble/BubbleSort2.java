package sort.bubble;

import java.util.Arrays;

class BubbleSort2 {
//    static int[] arr = {42,32,24,60,15};
    static int[] arr = {15, 24, 32, 42, 60};
    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        int cnt = 0;
        for (int i = 0; i < arr.length-1; i++) {
            boolean changed = false;
            for (int j = 0; j < arr.length-i-1; j++) {
                cnt++;
                if(arr[j]>arr[j+1]) {
                    swap(arr, j, j+1);
                    changed = true;
                }
            }
            if(! changed) break;
        }
        System.out.println(Arrays.toString(arr));
        System.out.println("cnt = "+ cnt);
    }

    private static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
