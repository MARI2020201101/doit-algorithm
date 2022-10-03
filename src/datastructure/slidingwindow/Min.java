package datastructure.slidingwindow;

import java.util.Deque;
import java.util.LinkedList;

class Min {
    public static void main(String[] args) {
        print();
    }
    static int[] arr = {1,5,2,3,6,2,3,7,3,5,2,6};
    static int CAPACITY = 3;
    static void print(){
        Deque<Pair> deque = new LinkedList<>();
        int idx = 0;
        deque.addLast(new Pair(idx,arr[idx]));
        for (int i = 0; i < arr.length; i++) {
            while(deque.peekFirst()!=null && i-deque.peekFirst().idx>=CAPACITY){
                deque.removeFirst();
            }
            while(deque.peekLast()!= null && deque.getLast().value > arr[i]){
                deque.removeLast();
            }
            deque.addLast(new Pair(i, arr[i]));

            System.out.print(deque.getFirst().value+", ");
        }
    }
}
class Pair{
    int idx;
    int value;
    Pair(int idx, int value){
        this.idx = idx;
        this.value = value;
    }
}
