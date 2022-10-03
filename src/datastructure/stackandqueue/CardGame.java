package datastructure.stackandqueue;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

class CardGame {
    public static void main(String[] args) {
        game();
    }
    static int[] cards = {1,2,3,4};
    static void game(){
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = cards.length-1; i >=0 ; i--) {
            stack.push(cards[i]);
        }
        while(stack.size()!=1){
            System.out.println(Arrays.toString(stack.toArray()));
            stack.pop();
            Integer card = stack.pop();
            System.out.println("card = "+card);
            stack.addLast(card);
        }
        System.out.println(stack.peek());
    }
}
