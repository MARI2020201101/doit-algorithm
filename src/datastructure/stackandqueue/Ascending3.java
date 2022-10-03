package datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

class Ascending3 {
    static int[] arr={4,3,6,8,7,5,2,1};

    public static void main(String[] args) {
        ascending();
    }
    static void ascending(){
        int num = 1;
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i<arr.length;i++){
            if(arr[i]>=num){
                while(arr[i]<num){
                    stack.push(num++);
                }

            }else{
                while(arr[i]<num){
                    Integer pop = stack.pop();
                    System.out.print(pop+",");
                }

            }


        }
    }
}
