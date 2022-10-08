package search.bfs;

import java.util.Arrays;

class Diameter {
    static int[][] arr = {
            {0,0,0,0,0,0},
            {0,0,0,2,0,0},
            {0,0,0,0,4,0},
            {0,2,0,0,3,0},
            {0,0,4,3,0,6},
            {0,0,0,0,6,0}
    };
    static int N = 6;
    static int[] distance = new int[N];
    static boolean[] visitied = new boolean[N];
    static {
        for (int i = 1; i < arr.length; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                if(arr[i][j]==0) arr[i][j] = Integer.MAX_VALUE;
            }
        }
    }

    public static void main(String[] args) {
        diameter(2);
        System.out.println(Arrays.toString(distance));

        int max = 0;
        for (int i = 1; i < N; i++) {
            diameter(i);
            max = Math.max(max, Arrays.stream(distance).max().getAsInt());
            Arrays.fill(distance, 0);
            Arrays.fill(visitied, false);
        }
        System.out.println("max = "+max);
    }
    static void diameter(int start){
        visitied[start] = true;
        distance[start] = 0;
        _dfs(start, 0, 0);
    }

    private static void _dfs(int i, int value, int depth) {
        if(depth >= N) return;
        for(int j = 1; j < N ; j++){
            if(arr[i][j] != Integer.MAX_VALUE && ! visitied[j]){
                visitied[j]= true;
                distance[j] = value + arr[i][j];
                _dfs(j,distance[j],depth+1);
            }
        }
    }
}
