package graph.floydwarshall;

import java.util.Arrays;

class KevinBacon2 {
    static int N = 6;
    static int M = 5;
    static int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,0,1,1,0},
            {0,0,0,1,0,0},
            {0,1,1,0,1,0},
            {0,1,0,1,0,1},
            {0,0,0,0,1,0}
    };
    static int[][] answer = new int[N][N];
    static boolean[] visited = new boolean[N];

    public static void main(String[] args) {
        for (int i = 1; i < N; i++) {

            dfs(i);

        }
        print();
    }
    static void dfs(int i){
        for (int j = i+1; j < N; j++) {
            if(arr[i][j]!=0 && ! visited[j]){
                visited[j] = true;
                answer[i][j]++;
                dfs(j);
                visited[j] = false;
            }
        }
    }
    private static void print() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                System.out.print(answer[i][j] +" ");
            }
            System.out.println();
        }
    }
}
