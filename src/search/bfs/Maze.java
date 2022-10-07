package search.bfs;

import java.util.LinkedList;
import java.util.Queue;

class Maze {
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

    public static void main(String[] args) {
        maze();
    }
    static void maze(){
        int min = Integer.MAX_VALUE;
        int cnt = 0;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0,0));
        while (! queue.isEmpty()){
            Point point = queue.poll();
            if(point.x==P && point.y==Q) {
                min=Math.min(min, cnt);
                cnt=0;
                break;
            }
            for (int i = 0; i < X.length; i++) {
                int x = point.x + X[i];
                int y = point.y + Y[i];
                if(canMove(x,y)){
                    cnt++;
                    queue.add(new Point(x, y));
                }
            }
        }
        System.out.println("min="+min);

    }

    private static boolean canMove(int x, int y) {
        return x>=0 && y>=0 && x<=P && y<=Q && arr[x][y]==1;
    }
}
class Point{
    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
