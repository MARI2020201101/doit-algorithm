package graph.topology;

import java.util.Arrays;

class CriticalPath2 {
    static int min = Integer.MAX_VALUE;
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

    }

    public static void main(String[] args) {
        minLen();
        System.out.println("min = "+min);
        System.out.println("max = "+max);
    }
    static void minLen(){
        for (int k = 2; k <= 6; k++) {
            if(arr[1][k]!=Integer.MAX_VALUE){
                move(k , arr[1][k]);
            }
        }
    }

    private static void move(int k, int value) {
        if(k==7){
            min = Math.min(min, value);
            max = Math.max(max, value);
            return;
        }
        for(int i = k+1; i <= 7 ; i++){
            if(arr[k][i]!=Integer.MAX_VALUE){
                move(i, value+ arr[k][i]);
            }
        }
    }
}
