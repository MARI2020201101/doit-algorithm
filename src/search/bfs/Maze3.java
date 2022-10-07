package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Maze3 {
    static int[][] arr = {
            {1,1,0,1,1,0},
            {1,1,0,1,1,0},
            {1,1,1,1,1,1},
            {1,1,1,1,0,1},
    };
    static int P = 3;
    static int Q = 5;
    static boolean[][] visited = new boolean[P+1][Q+1];
    static int[] X = {1,0,-1,0};
    static int[] Y = {0,-1,0,1};

    public static void main(String[] args) {
        maze();
        print(arr);
    }

    static void maze(){
        Queue<Point3> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new Point3(0,0));
        while (! queue.isEmpty()){
            Point3 point = queue.poll();
            if(point.x==P && point.y==Q) {
                System.out.println("cnt="+arr[P][Q]);
                break;
            }
            for (int i = 0; i < X.length; i++) {
                int x = point.x + X[i];
                int y = point.y + Y[i];
                if(canMove(x,y)){
                    arr[x][y] = arr[point.x][point.y] + 1;
                    visited[x][y] = true;
                    queue.add(new Point3(x, y));
                }
            }
        }

    }

    private static boolean canMove(int x, int y) {
        return x>=0 && y>=0 && x<=P && y<=Q && arr[x][y]!=0 && !visited[x][y];
    }
    static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] +" ");
            }
            System.out.println();
        }
    }
}

class Point3{
    int x;
    int y;

    public Point3(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
