package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

class BFS2 {
    static int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,1,1,0,0},
            {0,1,0,0,0,1},
            {0,1,0,0,1,0},
            {0,0,0,1,0,1},
            {0,0,1,0,1,0}
    };
    static int N = 6;
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        bfs(3);
    }
    static void bfs(int start){
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(start);
        while(! queue.isEmpty()){
            Integer i = queue.poll();
            System.out.print(i+" ");
            for (int j = 1; j < N; j++) {
                if(arr[i][j]==1 && ! visited[j]){
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
    }
}
