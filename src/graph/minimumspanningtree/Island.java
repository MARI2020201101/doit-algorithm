package graph.minimumspanningtree;

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
    static int islandCount = 0;
    static int[] X = {1,0,-1,0};
    static int[] Y = {0,-1,0,1};

    public static void main(String[] args) {
        island();
        print();
    }

    static void island(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!=0 && !visited[i][j]){
                    visited[i][j] = true;
                    map[i][j] = ++islandCount;
                    move(i,j);
                }
                visited[i][j] = true;
            }
        }
    }

    private static void move(int i, int j) {
        for (int k = 0; k < X.length; k++) {
            int nextX = i + X[k];
            int nextY = j + Y[k];
            if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY]!=0 && !visited[nextX][nextY]){
                visited[nextX][nextY] = true;
                map[nextX][nextY] = islandCount;
                move(nextX, nextY);
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
