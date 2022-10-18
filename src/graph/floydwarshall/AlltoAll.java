package graph.floydwarshall;

import java.util.ArrayList;
import java.util.List;

class AlltoAll {
    static int N = 6;
    static int M = 14;
    static int INF = 98765;
    static int[][] answer = new int[N][N];

    static Edge[] edges = {
            new Edge(1,2,2),
            new Edge(1,3,3),
            new Edge(1,4,1),
            new Edge(1,5,10),
            new Edge(2,4,2),
            new Edge(3,4,1),
            new Edge(3,5,1),
            new Edge(4,5,3),
            new Edge(3,5,10),
            new Edge(3,1,8),
            new Edge(1,4,2),
            new Edge(5,1,7),
            new Edge(3,4,2),
            new Edge(5,2,4)
    };
    static {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if(i==j) answer[i][j] = 0;
                else answer[i][j] = INF;
            }
        }
    }

    public static void main(String[] args) {
        init();
        solve();
        print();
    }
    static void init(){
        for (Edge edge : edges){
            if(answer[edge.from][edge.to] > edge.cost){
                answer[edge.from][edge.to] = edge.cost;
            }
        }
    }

    private static void print() {
        for (int i = 0; i < answer.length; i++) {
            for (int j = 0; j < answer[0].length; j++) {
                if(answer[i][j]==INF){
                    System.out.print("N ");
                }
                else System.out.print(answer[i][j] +" ");
            }
            System.out.println();
        }
    }

    static void solve(){
        for (int k = 1; k < N; k++) {
            for (int i = 1; i < N; i++) {
                for (int j = 1; j < N; j++) {
                    answer[i][j] = Math.min(answer[i][j], answer[i][k]+answer[k][j]);
                }
            }
        }
    }
}
class Edge{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
}
