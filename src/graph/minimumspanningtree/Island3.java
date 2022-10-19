package graph.minimumspanningtree;

import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

class Island3 {
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
    static Queue<Bridge> queue = new PriorityQueue<>();
    static int[] parent = new int[N*M];
    static int totalCost = 0;
    static boolean[] added = new boolean[N*M];


    public static void main(String[] args) {
        island();
        print();
        bridge();
        mst();
    }

    static void mst(){
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        while(! queue.isEmpty()){
            Bridge edge = queue.poll();
            if(added[edge.to]) continue;
            if(find(edge.from) != find(edge.to)){
                added[edge.from] = true;
                added[edge.to] = true;
                union(edge.from, edge.to);
                totalCost += edge.len;
            }
        }
        System.out.println("totalCost = "+totalCost);
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

    static void bridge(){
        for (int i = 0; i < N; i++) {
            if(map[i][0]!=0){
                linkRow(i,0);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(map[i][j] != 0){
                    linkCol(i,j);
                }
            }
        }
    }

    private static void linkCol(int i, int j) {
        int fromIsland = map[i][j];
        int toIsland = 0;
        int len = 0;
        int next = i;
        while(next < N && map[next][j] == fromIsland){
            next++;
        }
        int fromIdx = next;
        while(next < N){
            if(map[next][j]!=0 && map[next][j]!= fromIsland){
                toIsland = map[next][j];
                len = next - fromIdx;
                break;
            }
            next++;
        }
        if(len > 1 && toIsland!=0){
            queue.offer(new Bridge(fromIsland, toIsland, len));
        }
    }

    private static void linkRow(int i, int j) {
        int fromIsland = map[i][j];//섬의 값 2

        int toIsland = 0;
        int len = 0;
        int next = j;

        while(next < M && map[i][next] == fromIsland){
            next++;
        }
        int fromIdx = next;
        while (next < M){
            if(map[i][next] != 0 && map[i][next] != fromIsland) {
                toIsland = map[i][next];
                len = next - fromIdx;
                break;
            }
            next++;
        }

        if(len > 1 && toIsland!=0){
            queue.offer(new Bridge(fromIsland, toIsland, len));
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
    static void union(int a, int b){
        int A = find(a);
        int B = find(b);
        if(A != B){
            parent[b] = A;
        }
    }
    static int find(int a){
        if(parent[a] == a) return a;
        else return parent[a] = find(parent[a]);
    }
}
