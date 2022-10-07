package search.bfs;

class MazeDfs {
    static int[][] arr = {
            {1,1,0,1,1,0},
            {1,1,0,1,1,0},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
    };
    static int P = 3;
    static int Q = 5;
    static int[] X = {1,0,-1,0};
    static int[] Y = {0,-1,0,1};
    static boolean[][] visited = new boolean[P+1][Q+1];
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) {
        visited[0][0] = true;
        maze(0,0,1);
        System.out.println("count="+count);
    }
    static void maze(int x, int y, int n){
        if(x==P && y==Q){
            count = Math.min(count, n);
            return;
        }
        if(count < n) return;
        for (int i = 0; i < X.length; i++) {
            int nextX = x+X[i];
            int nextY = y+Y[i];
            if(canMove(nextX, nextY)) {
                visited[x][y] = true;
                maze(nextX, nextY, n+1);
            }
        }
    }

    private static boolean canMove(int x, int y) {
        return x>=0 && y>=0 && x<=P && y<=Q && arr[x][y]!=0 && !visited[x][y];
    }

}
