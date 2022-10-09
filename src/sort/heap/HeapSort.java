package sort.heap;

import java.util.Arrays;

class HeapSort {
    static int[] arr = {3,7,5,4,2,8};
    static int N = arr.length;
    static int[] answer = new int[N];

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        for(int i = arr.length; i > 0 ; i--){
            maxHeap(i);
            answer[i-1] = arr[0];
            swap(arr, 0, i-1);
        }
        System.out.println(Arrays.toString(answer));
    }
    static void maxHeap(int heapSize){
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
