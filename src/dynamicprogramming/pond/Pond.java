package dynamicprogramming.pond;

import java.util.ArrayList;
import java.util.List;

class Pond {
    static int[][] land = {
            {0,2,1,0},
            {0,1,0,1},
            {1,1,0,1},
            {0,1,0,1},
    };
    static int N = land.length;
    static int M = land[0].length;

    public static void main(String[] args) {
        List<Integer> pondSizes = pondSizes(land);
        pondSizes.forEach(System.out::println);
    }
    static List<Integer> pondSizes(int[][] land) {
        List<Integer> pondSizes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int size = computePondSize(land, i,j,pondSizes);
                if(size != 0) pondSizes.add(size);

            }
        }

        return pondSizes;
    }
    static int computePondSize(int[][] land, int x, int y, List<Integer> results){
        if(x < 0 || x >= N || y < 0 || y >= M || land[x][y]!=0){
            return 0;
        }
        land[x][y] = -1;
        int size = 1;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int nextX = x+i;
                int nextY = y+j;
                size += computePondSize(land, nextX, nextY, results);
            }
        }
        return size;
    }
}
