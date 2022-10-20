package graph.minimumspanningtree.island;

import java.util.*;

class Island2 {
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
    static Queue<Bridge> bridges = new PriorityQueue<>();

    public static void main(String[] args) {
        island();
        print();
        bridge();
        while(! bridges.isEmpty()){
            System.out.println(bridges.poll());
        }
    }
    static void bridge(){
        for (int i = 0; i < islands.size(); i++) {
            List<int[]> islandsList = islands.get(i);
            for (int j = 0; j < islandsList.size(); j++) {
                int[] oneIsLand = islandsList.get(j);
                int x = oneIsLand[0];
                int y = oneIsLand[1];
                int islandIdx = map[x][y];

                for (int k = 0; k < X.length; k++) {
                    int nextX = x + X[k];
                    int nextY = y + Y[k];
                    int nextL = 0;
                    while (x+nextX >=0 && x+nextX < N && y+nextY >=0 && y+nextY < M){
                        if(map[x+nextX][y+nextY] == islandIdx) break;
                        else if(map[x+nextX][y+nextY] != 0 && nextL > 1){
                            bridges.add(new Bridge(islandIdx , map[x+nextX][y+nextY],nextL));
                            break;
                        }
                        else nextL++;

                        if(nextX > 0) nextX++;
                        else if(nextX < 0)nextX--;
                        else if(nextY > 0) nextY++;
                        else if(nextY < 0) nextY--;
                    }
                }
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
class Bridge implements Comparable<Bridge>{
    int from;
    int to;
    int len;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bridge bridge = (Bridge) o;
        return from == bridge.from && to == bridge.to && len == bridge.len;
    }

    @Override
    public int hashCode() {
        return Objects.hash(from, to, len);
    }

    public Bridge(int from, int to, int len) {
        this.from = from;
        this.to = to;
        this.len = len;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "from=" + from +
                ", to=" + to +
                ", len=" + len +
                '}';
    }

    @Override
    public int compareTo(Bridge o) {
        return this.len - o.len;
    }
}