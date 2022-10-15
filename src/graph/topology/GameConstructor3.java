package graph.topology;

import java.util.*;
import java.util.stream.IntStream;

class GameConstructor3 {
    static int N = 6;
    static int[] indegree = new int[N];
    static int[] result = new int[N];
    static int[] time = {0,10,10,4,4,3};
    static List<List<Integer>> arr = new ArrayList<>();
    static {
        IntStream.range(0, N).forEach(i -> arr.add(new ArrayList<>()));
        arr.get(1).add(2);
        arr.get(1).add(3);
        arr.get(3).add(4);
        arr.get(3).add(5);
        indegree[1]=2;
        indegree[3]=2;
    }

    public static void main(String[] args) {
        calculate();
    }
    static void calculate(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < indegree.length; i++) {
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        while(! queue.isEmpty()){

            Integer curr = queue.poll();
            result[curr] += time[curr];
            for(Integer next : arr.get(curr)){
                result[next] = Math.max(result[next], result[curr] + time[curr] + time[next]);
                indegree[curr]--;
                if(indegree[next]==0){
                    queue.add(next);
                }
            }

            System.out.println(result[curr]);

        }
    }
}
