package dynamicprogramming.travelingsalesman;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class TSP {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[] min = new int[N];
    static boolean[] visited = new boolean[N];
    static {
        Arrays.setAll(min, a->Integer.MAX_VALUE);
    }
    static void __tsp(Queue<Route> queue){
        Route first = queue.poll();
        for (int j = 0; j < arr.length; j++) {
            if(! visited[j]){
                visited[j] = true;
                queue.add(new Route(j, first.value + arr[first.idx][j]));
                __tsp(queue);


            }

            visited[j] = false;
        }
    }
    static void tsp(){
        Queue<Route> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            visited[i] = true;

            queue.add(new Route(i, arr[i][i]));


            visited[i] = false;
        }
    }

}
class Route{
    int idx;
    int value;

    public Route(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}