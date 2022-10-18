package graph.floydwarshall;

import java.util.Arrays;

class KevinBacon {
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
    static int[] answer = new int[N];

    public static void main(String[] args) {
        solve();
        System.out.println(Arrays.toString(answer));
    }
    static void solve(){
        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {

                    answer[i] += Math.min(arr[i][j], arr[i][k]+arr[k][j]);

                }
            }
        }
    }

}
