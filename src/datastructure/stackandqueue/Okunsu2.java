package datastructure.stackandqueue;

import java.util.Arrays;
import java.util.Stack;

class Okunsu2 {
    static int[] arr = {3,5,2,7};

    public static void main(String[] args) {
        find();
    }
    static void find(){
        Stack<Integer> stack = new Stack<>();
        int idx = 0;
        stack.push(idx);
        int[] result = new int[4];
        for (int i = 1; i < arr.length; i++) {
            if(arr[stack.pop()] < arr[i]){
                while(idx < i){
                    result[idx++] = arr[i];
                }
            }
            stack.push(idx);
            if(i == arr.length-1){
                result[i] = -1;
            }
        }
        System.out.println(Arrays.toString(result));
    }

}
