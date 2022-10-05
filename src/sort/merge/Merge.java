package sort.merge;

import java.util.Arrays;

class Merge {
    static int[] arr = {42,32,24,60,15,5,90,45};

    public static void main(String[] args) {
        merge(new int[8], 0,4);
    }
    static void merge(int[] tmp, int left, int right){
        int mid = right;
        int len = (right-left) + mid;
        int idx = 0;
        while(left< mid && right < len){

            if(arr[left] < arr[right]){
                tmp[idx++]=arr[left++];
            }else{
                tmp[idx++]=arr[right++];
            }
            System.out.println(Arrays.toString(tmp));
        }
        while(left<mid){
            tmp[idx++]=arr[left++];
        }
        while(right < len){
            tmp[idx++]=arr[right++];
        }
        System.out.println("--");
        System.out.println(Arrays.toString(tmp));
    }
}
