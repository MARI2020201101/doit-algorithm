package graph.topology;

import java.util.*;

class GameConstructor {
    static int N = 6;
    static int[] indegree = new int[N];
    static int[] time = {0,10,10,4,4,3};
    static Map<Integer, List<Integer>> map = new HashMap<>();
    static {
        map.put(0, new ArrayList<>());
        map.put(1, new ArrayList<>());
        map.put(2, List.of(1));
        indegree[1]++;
        map.put(3, List.of(1));
        indegree[1]++;
        map.put(4, List.of(1,3));
        indegree[1]++;
        indegree[3]++;
        map.put(5, List.of(3));
        indegree[3]++;
    }

    public static void main(String[] args) {
        calculate();
    }
    static void calculate(){
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < map.size(); i++) {
            if(map.get(i).size()==0){
                queue.add(time[i]);
            }else{
                int totalTime = time[i];
                for(Integer prev : map.get(i)){
                    totalTime += time[prev];
                }
                queue.add(totalTime);
            }
        }
        while(! queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }
}
