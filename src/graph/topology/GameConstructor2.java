package graph.topology;

import java.util.*;

class GameConstructor2 {
    static int N = 6;
    static int[] indegree = new int[N];
    static int[] time = {0,10,10,4,4,3};
    static List<Integer>[] arr = new ArrayList[N];
    static {
        Arrays.setAll(arr, a->new ArrayList<>());
        arr[1].add(2);
        arr[1].add(3);
        arr[3].add(4);
        arr[3].add(5);
        indegree[1]=2;
        indegree[3]=2;
    }

    public static void main(String[] args) {
        calculate();
    }
    static void calculate(){
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] > 0){
                for(Integer node : arr[i]){
                    time[node]+=time[i];
                }
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < time.length; i++) {
            queue.offer(time[i]);
        }
        while(! queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
