package search.binary;

import java.util.Arrays;

class BinarySearch {
    static int[] arr = {4,1,5,2,3};
    static int[] target = {1,3,7,9,5};

    public static void main(String[] args) {
        search();
    }

    static void search() {
        Arrays.sort(arr);

        for(int i=0; i< target.length; i++){
            int start = 0;
            int end = target.length-1;
            int contain = 0;
            while(start<=end){
                int mid = (start + end)/2;
                if(target[i] == arr[mid]) {
                    contain = 1;
                    break;
                }
                else if(target[i] < arr[mid]){
                    end = mid-1;
                }
                else{
                    start = mid+1;
                }
            }
            System.out.println(contain==1? 1 : 0);
        }
    }
}
