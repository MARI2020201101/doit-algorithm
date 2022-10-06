package sort.radix;

import java.util.Arrays;

class RadixSort2 {
    static int[] arr = {215,15,344,372,294,100,8,145,24,198,831};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        int[] bucket = new int[10];
        int[] tmp = new int[arr.length];
        int maxLen = 5;
        int count = 1;
        int jarisu = 1;
        while(count!=maxLen){
            for (int i = 0; i < arr.length; i++) {
                bucket[(arr[i]/jarisu) % 10]++;
            }
            for (int i = 1; i < bucket.length; i++) {
                bucket[i] += bucket[i-1];
            }
            for (int i = arr.length-1; i >= 0; i--) {
                tmp[bucket[(arr[i]/jarisu) % 10]-1] = arr[i];
                --bucket[(arr[i]/jarisu) % 10];
            }
            for(int i = 0; i< arr.length; i++){
                arr[i] = tmp[i];
            }

            Arrays.fill(bucket, 0);
            jarisu*=10;
            count++;
        }

        System.out.println(Arrays.toString(arr));
    }
}
