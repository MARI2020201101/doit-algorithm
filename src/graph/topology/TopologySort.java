package graph.topology;

import java.util.*;

class TopologySort {
    static int N = 4;
    static int[] topology = new int[N];
    static List<Integer>[] arr = new ArrayList[N];
    static {
        Arrays.setAll(arr, a->new ArrayList<>());
        arr[1].add(3);
        topology[3]++;
        arr[2].add(3);
        topology[3]++;
    }

    public static void main(String[] args) {
        sort();
    }

    static void sort(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N; i++) {
            if(topology[i] == 0){
                queue.add(i);
                for(Integer node : arr[i]){
                    topology[node]--;
                }
            }
        }
        while(! queue.isEmpty()){
            System.out.print(queue.poll() + " ");
        }
    }

}
