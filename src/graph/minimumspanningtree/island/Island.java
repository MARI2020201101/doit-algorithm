package graph.minimumspanningtree.island;

import java.util.*;

class Island {
    static int N = 7;
    static int M = 8;
    static int[][] map = {
            {0,0,0,0,0,0,1,1},
            {1,1,0,0,0,0,1,1},
            {1,1,0,0,0,0,0,0},
            {1,1,0,0,0,1,1,0},
            {0,0,0,0,0,1,1,0},
            {0,0,0,0,0,0,0,0},
            {1,1,1,1,1,1,1,1}
    };
    static boolean[][] visited = new boolean[N][M];
    static List<List<int[]>> islands = new ArrayList<>();
    static List<int[]> island = new ArrayList<>();
    static int islandCount = 0;
    static int[] X = {1,0,-1,0};
    static int[] Y = {0,-1,0,1};

    public static void main(String[] args) {
        island();
        print();
        for (int i = 0; i < islands.size(); i++) {
            List<int[]> ints = islands.get(i);
            for (int j = 0; j < ints.size(); j++) {
                System.out.print(i+" : "+ints.get(j)[0]+ ","+ ints.get(j)[1]);

                System.out.println();
            }
        }
    }
    static void island(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!= 0 && ! visited[i][j]){
                    addIsland(i,j);
                    islands.add(island);
                }
                visited[i][j]=true;
            }
        }
    }

    private static void addIsland(int i, int j) {
        island = new ArrayList<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i,j});
        visited[i][j] = true;
        map[i][j] = ++islandCount;
        island.add(new int[]{i,j});
        while(! queue.isEmpty()){
            int[] node = queue.poll();
            int x = node[0];
            int y = node[1];
            for (int k = 0; k < X.length; k++) {
                int nextX = X[k];
                int nextY = Y[k];

                while(x+ nextX >=0 && x+nextX < N && y+nextY >=0 && y+nextY<M){
                    if(map[x+nextX][y+nextY]!=0 && ! visited[x+nextX][y+nextY]){
                        visited[x+nextX][y+nextY] = true;
                        map[x+nextX][y+nextY] = islandCount;
                        island.add(new int[]{x+nextX, y+nextY});
                        queue.add(new int[]{x+nextX, y+nextY});
                    }else break;

                    if(nextX > 0) nextX++;
                    else if(nextX < 0)nextX--;
                    else if(nextY > 0) nextY++;
                    else if(nextY < 0) nextY--;
                }
            }
        }

    }


    private static void print() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[0].length; j++) {
                System.out.print(map[i][j] +" ");
            }
            System.out.println();
        }
    }

}
