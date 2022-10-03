package datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class Ascending2 {
    static int[] arr={4,3,6,8,7,5,2,1};
    static int N = 8;

    public static void main(String[] args) {
        ascending();
    }
    static void ascending(){
        Deque<Integer> stack = new ArrayDeque<>();
        int idx=N;
        for (int i = arr.length-1; i >=0 ; i--) {
            if(arr[i] < idx){
                stack.addLast(arr[i]);
                continue;
            }
            if(arr[i]==idx){
                stack.addLast(arr[i]);
                continue;
            }
            while(stack.peekLast()!= null && stack.peekLast()>=idx){
                Integer last = stack.removeLast();
                System.out.print(last+",");
                idx--;
            }

        }
        while(! stack.isEmpty()){
            Integer last = stack.removeLast();
            System.out.print(last+",");
        }
    }
}
