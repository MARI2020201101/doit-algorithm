package datastructure.stackandqueue;

import java.util.*;

class CardGame2 {
    public static void main(String[] args) {
        game();
    }
    static int[] cards = {1,2,3,4};
    static void game(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i <cards.length; i++) {
            queue.add(cards[i]);
        }

        while(queue.size()!=1){
            queue.poll();
            queue.add(queue.poll());
            System.out.println(Arrays.toString(queue.toArray()));
        }
        System.out.println(queue.poll());
    }
}
