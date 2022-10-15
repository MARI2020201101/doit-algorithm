package graph.topology;

import java.util.Arrays;

class CriticalPath {
    static int[] min = new int[8];
    static int max = 0;
    static int[][] arr = {
            {0,0,0,0,0,0,0,0},
            {0,0,4,2,3,0,0,0},
            {0,0,0,0,0,0,3,5},
            {0,0,0,0,0,1,0,0},
            {0,0,0,0,0,0,4,0},
            {0,0,0,0,0,0,2,0},
            {0,0,0,0,0,0,0,5},
            {0,0,0,0,0,0,0,0}
    };
    static {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if(arr[i][j]==0) arr[i][j]=Integer.MAX_VALUE;
            }
        }
        Arrays.fill(min, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 7; i++) {
            minLen(i);
        }
        System.out.println(Arrays.toString(min));
    }
    static void minLen(int start){
        for (int k = start+1; k <= 6; k++) {
            if(arr[start][k]!=Integer.MAX_VALUE){
                move(start, k , arr[1][k]);
            }
        }
    }

    private static void move(int from, int k, int value) {
        if(k==7){
            min[from]=Math.min(min[from], value);
            return;
        }
        for(int i = k+1; i <= 7 ; i++){
            if(arr[k][i]!=Integer.MAX_VALUE){
                move(from, i, value+ arr[k][i]);
            }
        }
    }
}
