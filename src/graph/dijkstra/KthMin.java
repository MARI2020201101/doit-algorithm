package graph.dijkstra;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

class KthMin {
    static int N = 6;
    static int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,2,7,5,6},
            {0,0,0,4,2,0},
            {0,0,0,0,6,8},
            {0,0,0,0,0,0},
            {0,0,4,0,1,0}
    };
    static boolean[] visited = new boolean[N];
    static Set<Integer>[] answer = new TreeSet[N];
    static {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if(arr[i][j]==0)arr[i][j]=Integer.MAX_VALUE;
            }
        }
        for (int i = 0; i < N; i++) {
            answer[i] = new TreeSet<>();
        }
    }
    public static void main(String[] args) {
        dfs(1,0);
        System.out.println(Arrays.toString(answer));
    }
    static void dfs(int i, int value){
        for (int j = 1; j < N; j++) {
            if(! visited[j] && arr[i][j]!=Integer.MAX_VALUE){
                visited[j] = true;
                answer[j].add(value + arr[i][j]);
                dfs(j, value + arr[i][j]);
                visited[j] = false;
            }
        }
    }
}
