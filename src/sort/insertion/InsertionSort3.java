package sort.insertion;

import java.util.Arrays;

class InsertionSort3 {
    static int[] arr = {42,32,28,60,15};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j = i-1;
            while(j>=0 && tmp < arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = tmp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
