package graph.minimumspanningtree;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

class MinimumSpanningTree {
    static int N = 4;
    static int INF = 98765;
    static int answer = 0;
    static int[] parent = {0,1,2,3};

    public static void main(String[] args) {
        minimumSpanningTree();
    }
    static void minimumSpanningTree(){
        Queue<Edge> queue = new PriorityQueue<>();
        queue.offer(new Edge(1,2,1));
        queue.offer(new Edge(2,3,2));
        queue.offer(new Edge(1,3,3));
        while(! queue.isEmpty()){
            Edge edge = queue.poll();
            if(find(edge.from) != find(edge.to)){
                union(edge.from, edge.to);
                System.out.println(Arrays.toString(parent));
                answer += Math.max(answer, edge.cost);
            }
        }
        System.out.println("answer = " + answer);
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
class Edge implements Comparable<Edge>{
    int from;
    int to;
    int cost;

    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }

    @Override
    public int compareTo(Edge o) {
        return this.cost - o.cost;
    }
}