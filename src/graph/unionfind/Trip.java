package graph.unionfind;

import java.util.LinkedList;
import java.util.Queue;

class Trip {
    static int N = 3;
    static int[][] city = {
            {0,1,0},
            {1,0,1},
            {0,1,0}
    };
    static int[] trip = {0,1,2};
    static int available = 0;

    static void trip(){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        while(! queue.isEmpty()){
            if(available == N) break;

            Integer c = queue.poll();
            int idx = 0;
            for (int i = 0; i < city[c].length; i++) {
                if(city[c][i] == 1){
                    if(i == trip[idx]){
                        available++;
                        idx++;
                    }
                    queue.add(i);
                }
            }
        }
    }
}
