package greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class CardSort3 {
    static int[] cards = {10,20,40};

    public static void main(String[] args) {
        System.out.println(count());
    }
    static int count(){
        Arrays.sort(cards);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < cards.length; i++) {
            queue.add(cards[i]);
        }
        int count = 0;
        while(queue.size()!=1){
            Integer p1 = queue.poll();
            Integer p2 = queue.poll();
            int card =  p1+p2;
            System.out.println(String.format("poll 1 = %d, poll 2 = %d", p1,p2));
            System.out.println("card="+card);
            count+=card;
            queue.add(card);
        }
        return count;
    }
}
