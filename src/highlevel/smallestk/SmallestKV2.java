package highlevel.smallestk;

import java.util.Arrays;

class SmallestKV2 {

    static int[] arr = {17,10,3,18,4,11,5,12,8,20,9,16,2,15,0,19,1,14,6,7,13};

    public static void main(String[] args) throws InterruptedException {
        System.out.println(smallestK(arr,10));
    }
    static int smallestK(int[] arr, int k) throws InterruptedException {
        int left = 0;
        int right = arr.length -1;
        int pivot = arr[left+right/2];
        int leftIdx = partition(arr, left, right, pivot);
        int leftSize = leftIdx + 1;

        if(leftSize == k){
            return max(arr, leftSize);
        }else if(leftSize > k){
            return partition(arr, left, leftIdx, arr[(left+leftIdx)/2]);
        }else{
            return partition(arr,leftSize, right, arr[(right-leftIdx)/2]);
        }

    }

    private static int max(int[] arr, int leftSize) {
        return arr[leftSize];

    }

    private static int partition(int[] arr, int left, int right, int pivot) throws InterruptedException {
        while(left < right){
            System.out.println(String.format("left=%d, right=%d, pivot=%d", left,right,pivot));
            Thread.sleep(100);
            while(arr[left] >= pivot){
                swap(arr, left, right);
                right--;
            }
            while(arr[right] < pivot){
                swap(arr, left, right);
                left++;
            }
            left++;
            right--;
        }
        System.out.println("left-1= "+(left-1));
        return left-1;
    }

    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
        System.out.println(Arrays.toString(arr));
    }
}
