package dynamicprogramming.travelingsalesman;

import java.util.Arrays;

public class TSP3 {
    static int N = 4;
    static int[][] arr = {
            {0,10,15,20},
            {5,0,9,10},
            {6,13,0,12},
            {8,8,9,0},
    };
    static int[] answer = new int[N];
    static boolean[] visited = new boolean[N];
    public static void main(String[] args) {
        Arrays.setAll(answer,a->Integer.MAX_VALUE);
        for (int i = 0; i < N; i++) {
            dfs(1,i,0,arr[i][i]);
        }
        System.out.println(Arrays.toString(answer));
    }

    static void dfs(int idx, int root, int next, int value){
        if(idx > N){
            answer[root] = Math.min(answer[root], value);
        }
        for (int i = 0; i < arr[next].length; i++) {
            if(! visited[i] && arr[next][i]!=0){
                visited[i] = true;
                System.out.println(String.format("[%d]: %d, value=%d, nextValue=%d",idx,i,value,value + arr[next][i]));
                dfs(idx+1, root, i,  value + arr[next][i]);
                visited[i] = false;
            }
        }
    }

    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}
