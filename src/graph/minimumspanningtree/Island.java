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
    static int[][] islandMap = new int[N][M];
    static int islandCount = 0;
    static int[] X = {1,0,-1,0};
    static int[] Y = {0,-1,0,1};

    public static void main(String[] args) {
        island();
        print();
    }
    //1. 각각의 섬을 구분한다.
    static void island(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j]!=0){
                    islandMap[i][j] = ++islandCount;
                    move(i,j);
                }
            }
        }
    }

    private static void move(int i, int j) {
        for (int k = 0; k < X.length; k++) {
            int nextX = i + X[k];
            int nextY = j + Y[k];
            if(nextX >=0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY]==1){
                islandMap[nextX][nextY] = islandCount;
            }
        }
    }
    private static void print() {
        for (int i = 0; i < islandMap.length; i++) {
            for (int j = 0; j < islandMap[0].length; j++) {
                System.out.print(islandMap[i][j] +" ");
            }
            System.out.println();
        }
    }

}
