package dynamicprogramming.travelingsalesman;

import java.util.Arrays;

class TravelingSalesman {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[] min = new int[N];
    static boolean visited[] = new boolean[N];
    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            min[i] = Integer.MAX_VALUE;
        }
        for (int i = 0; i < N; i++) {
            if(! visited[i]) {
                visited[i] = true;
                dfs(i, 0,0);
                visited[i] = false;
            }
        }
        System.out.println(Arrays.toString(min));
    }
    static void dfs(int i, int k, int value){
        if(k >= N-1){
            min[i]=Math.min(min[i], value);
        }
        for (int j = 0; j < N; j++) {
            if(i==j) continue;
            if(arr[i][j]!=0 && ! visited[j]){
                visited[j]=true;
                dfs(j,k+1 ,value+arr[i][j]);
                visited[j]=false;
            }
        }
    }
}
