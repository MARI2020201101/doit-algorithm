package graph.topology;

import java.util.*;

class TopologySort2 {
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
                queue.offer(i);
            }
        }
        while(! queue.isEmpty()){
            Integer node = queue.poll();
            System.out.print(node+ " ");
            for(Integer next : arr[node]){
                topology[next]--;
                if(topology[next]==0){
                    queue.offer(next);
                }
            }
        }

    }

}
