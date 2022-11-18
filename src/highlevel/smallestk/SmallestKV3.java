package highlevel.smallestk;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

class SmallestKV3 {
    //중복이 있는 경우
    static int[] generateRandomIntArr(int bound, int size){
        return IntStream.generate(() -> new Random().nextInt(bound)).limit(size).toArray();
    }

    public static void main(String[] args) {
        int[] arr = generateRandomIntArr(8,24);
        int rank = 5;
        int rankK = rank(arr, rank);
        int[] smallestK = smallestK(arr, rank, rankK);

    }
    static int rank(int[] arr, int rank){
        LeftMiddleSize leftMiddleSize = rank(arr, 0, arr.length - 1, rank);
        return 0;
    }

    private static LeftMiddleSize rank(int[] arr, int start, int end, int rank) {
        int pivot = arr[(start+end)/2];
        int left = start;
        int middle = start;
        int right = end;
        while(middle < right){
            if(arr[middle] < pivot){
                swap(arr, left, middle);
                left++;
                middle++;
            }else if(arr[middle] > pivot){
                swap(arr, right, middle);
                right--;
            }else if(arr[middle] == pivot){
                middle++;
            }
        }
        System.out.println(Arrays.toString(arr));
        int leftSize = left-start;
        int middleSize = middle-left;

        if(leftSize > rank){
            return rank(arr, start, left-1, rank);
        }else if(leftSize + middleSize > rank){
            return new LeftMiddleSize(leftSize, middleSize);
        }else{
            return rank(arr, middle, end, rank-middle);
        }

    }

    private static int[] smallestK(int[] arr, int rank, int rankK) {
        int[] smallestK = new int[rank +1];
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] < rankK){
                smallestK[i] = arr[i];
            }
        }
        return smallestK;
    }
    private static void swap(int[] arr, int left, int right) {
        int tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
    }
}
class LeftMiddleSize{
    int leftSize;
    int middleSize;

    public LeftMiddleSize(int leftSize, int middleSize) {
        this.leftSize = leftSize;
        this.middleSize = middleSize;
    }
}