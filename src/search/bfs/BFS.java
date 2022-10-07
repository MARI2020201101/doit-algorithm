package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

class BFS {
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
        bfs();
    }
    static void bfs(){
        Queue<Integer> queue = new LinkedList<>();
        visited[1]=true;
        queue.add(1);
        for (int i = 1; i < N; i++) {
            for (int j = 1; j < N; j++) {
                if(arr[i][j]==1 && ! visited[j]){
                    visited[j] = true;
                    queue.add(j);
                }
            }
        }
        while(! queue.isEmpty()){
            System.out.print(queue.poll()+" ");
        }
    }
}
