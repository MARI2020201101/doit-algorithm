package sort.heap;

import java.util.Arrays;

class Heapify {

    static int[] arr = {3,7,5,4,2,8};

    public static void main(String[] args) {
        maxHeap();
    }
    static void maxHeap(){
        int heapSize = arr.length;
        int parent = (heapSize-1)/2;

        for (int i = parent ; i>=0; i--) {
            heapify(i, heapSize);
        }
        System.out.println(Arrays.toString(arr));
    }
    static void heapify(int parent, int heapSize){
        int lChild = parent*2+1;
        int rChild = parent*2+2;
        int largest = parent;

        if(lChild < heapSize && arr[lChild] > arr[parent]){
            largest = lChild;
        }
        if(rChild < heapSize && arr[rChild] > arr[largest]){
            largest = rChild;
        }
        if(largest!=parent){
            swap(arr, largest, parent);
            heapify(largest, heapSize);
        }
    }

    private static void swap(int[] arr, int largest, int parent) {
        int tmp = arr[parent];
        arr[parent] = arr[largest];
        arr[largest] = tmp;
    }
}
