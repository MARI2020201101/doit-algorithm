package graph.bellmanford;

import java.util.Arrays;

class TimeMachine {
    static int N = 4;
    static int[][] arr ={
            {0,0,0,0},
            {0,0,4,3},
            {0,0,0,-4},
            {0,-2,0,0}
    };

    static int[] answer = new int[N];
    static boolean[] visited = new boolean[N];
    static {
        Arrays.setAll(answer, a->Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        visited[1]=true;
        bellmanFord(1, 0);
        System.out.println(Arrays.toString(answer));
    }
    static void bellmanFord(int i, int val){
        for (int j = 1; j < N; j++) {
            if(arr[i][j]!=0 && ! visited[j]) {
                visited[j] = true;
                answer[j] = Math.min(answer[j],val+arr[i][j]);
                bellmanFord(j, val+arr[i][j]);
                visited[j] = false;
            }
        }
    }
}
