package datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Deque;

class Ascending {
    static int[] arr={4,3,6,8,7,5,2,1};

    public static void main(String[] args) {
        ascending();
    }
    static void ascending(){
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = arr.length-1; i >=0 ; i--) {
            if(stack.isEmpty()) {
                stack.addLast(arr[i]);
                continue;
            }
            if(stack.peekLast()!=null && stack.peekLast() < arr[i]) {
                stack.addLast(arr[i]);
                continue;
            }
            while(stack.peekLast()!=null && stack.peekLast() >= arr[i]){
                Integer last = stack.removeLast();
                System.out.print(last+",");
            }
            stack.addLast(arr[i]);
        }

        while(! stack.isEmpty()){
            Integer last = stack.removeLast();
            System.out.print(last+",");
        }
    }
}
