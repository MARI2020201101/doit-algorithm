package highlevel.smallestk;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class SmallestK {
    static int[] arr = {17,10,3,18,4,11,5,12,8,20,9,16,2,15,0,19,1,14,6,7,13};

    public static void main(String[] args) {
        int[] smallestK = smallestK(10);
        System.out.println(Arrays.toString(smallestK));
    }
    static int[] smallestK(int k){
        PriorityQueue<Integer> queue = new PriorityQueue<>(k,Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            if(queue.size() <= k){
                queue.add(arr[i]);
            }else{
                if(arr[i] < queue.peek()){
                    queue.poll();
                    queue.add(arr[i]);
                }
            }
        }
        int[] smallestK = new int[queue.size()];

        while(! queue.isEmpty()){
            smallestK[queue.size()-1] = queue.poll();
        }
        return smallestK;
    }
}
