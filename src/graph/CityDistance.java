package graph;

import java.util.Arrays;

class CityDistance {
    static int[][] arr = {
            {0,0,0,0,0},
            {0,0,1,1,0},
            {0,0,0,1,1},
            {0,0,0,0,0},
            {0,0,0,0,0}
    };
    static int K = 2;
    static int start = 1;
    static int[] distance = new int[5];
    static boolean[] visited = new boolean[5];

    public static void main(String[] args) {
        distance(start,0);
        calculate(distance);
    }
    static void calculate(int[] distance){
        for (int i = 1; i < distance.length; i++) {
            if(distance[i]==K){
                System.out.print(i+" ");
            }
        }
    }
    static void distance(int node, int d){
        for (int i = 1; i < arr[0].length; i++) {
            if(arr[node][i] != 0 && !visited[i]) {
                visited[i] = true;
                distance[i] = d+1;
                distance(i, distance[i]);
            }
        }
    }
}
