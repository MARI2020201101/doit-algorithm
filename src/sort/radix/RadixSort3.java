package sort.radix;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class RadixSort3 {
    static int[] arr = {215,15,344,372,294,100,8,145,24,198,831};

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        Queue<Integer>[] queues = new LinkedList[10];
        for (int i = 0; i < queues.length; i++) {
            queues[i] = new LinkedList<>();
        }
        int count =1;
        int maxLen = 5;
        int jarisu = 1;
        while(count!=maxLen){
            for (int i = 0; i < arr.length; i++) {
                queues[arr[i]/jarisu %10].add(arr[i]);
            }
            for (int i = 0,j=0; i < queues.length; i++) {
                while(! queues[i].isEmpty() && queues[i].peek()!= null){
                    arr[j++]=queues[i].poll();
                }
            }
            jarisu*=10;
            count++;
        }
        System.out.println(Arrays.toString(arr));

    }
}
