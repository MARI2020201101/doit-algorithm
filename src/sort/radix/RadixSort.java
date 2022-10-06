package sort.radix;

import java.util.*;

class RadixSort {
    static int[] arr ={16,80,18,77,03,24,88,23};
    static List<Queue<Integer>> queues = new ArrayList<>();
    static{
        queues.addAll(List.of(new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
                ,new LinkedList<>()
        ));
    }

    public static void main(String[] args) {
        sort();
    }
    static void sort(){
        int[] tmp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            int remain = tmp[i] % 10;
            queues.get(remain).add(i);
            tmp[i] = tmp[i]/10;
        }

        for (int i = 0; i < queues.size(); i++) {
            Integer j = queues.get(i).poll();
            if(j==null) continue;
            queues.get(tmp[j] % 10).add(j);
            tmp[j] = tmp[j]/10;
        }


        for (int i = 0; i < queues.size(); i++) {
            while(! queues.get(i).isEmpty()){
                Integer j = queues.get(i).poll();
                System.out.print(arr[j] + ",");
            }
        }
    }
}
