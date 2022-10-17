package graph.bellmanford;

import java.util.*;

class Ominsik2 {
    static int N = 5;
    static int M = 5;
    static int START = 0;
    static int END = 4;
    static int[] answer = new int[N];
    static int[] value = {0,10,10,110,10};
    static Edge[] edges = {
            new Edge(0,1,10),
            new Edge(1,2,10),
            new Edge(2,3,10),
            new Edge(3,1,10),
            new Edge(2,4,10)
        };
    static {
        Arrays.setAll(answer, a->Integer.MIN_VALUE);
    }

    public static void main(String[] args) {
        solve();
        print();
    }
    static void solve(){
        answer[0] = value[0];
        for (int i = 0; i < N+100; i++) {
            for (int j = 0; j < M; j++) {
                Edge edge = edges[j];
                if(answer[edge.from] == Integer.MIN_VALUE) continue;
                else if(answer[edge.from] == Integer.MAX_VALUE){
                    answer[edge.to] = Integer.MAX_VALUE;
                }
                else if(answer[edge.to] < answer[edge.from] + value[edge.to] - edge.cost){
                    answer[edge.to] = answer[edge.from] + value[edge.to] - edge.cost;
                    if(i >= N-1){
                        answer[edge.to] = Integer.MAX_VALUE;
                    }
                }
            }
        }
    }
    static void print(){
        if(answer[END] == Integer.MIN_VALUE) {
            System.out.println("gg");
            return;
        }
        else if(answer[END] == Integer.MAX_VALUE){
            System.out.println("GEE");
            return;
        }else {
            for (int i = 0; i < answer.length; i++) {
                if(answer[i]==Integer.MIN_VALUE) System.out.print("MIN ");
                else if(answer[i]==Integer.MAX_VALUE) System.out.print("MAX ");
                else System.out.print(answer[i]+" ");
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