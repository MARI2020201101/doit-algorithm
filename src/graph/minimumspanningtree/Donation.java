package graph.minimumspanningtree;

import java.util.PriorityQueue;
import java.util.Queue;

class Donation {
    static int N = 3;
    static int[][] arr = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
    };
    static int[] parent = {0,1,2};
    static Queue<Edge> queue = new PriorityQueue<>();
    static boolean added[] = new boolean[N];
    static int minCost = 0;
    static int totalCost = 0;

    public static void main(String[] args) {
        link();
        System.out.println("cost = "+minCost);
        System.out.println("donation max = " + (totalCost - minCost));
    }

    static void link(){
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                totalCost += arr[i][j];
                if(i==j){continue;}
                queue.add(new Edge(i,j,arr[i][j]));
            }
        }
        while(! queue.isEmpty()){
            Edge edge = queue.poll();
            if(added[edge.to]) continue;
            else if(find(edge.from) != find(edge.to)){
                minCost += edge.cost;
                union(edge.from, edge.to);
                added[edge.from] = true;
                added[edge.to] = true;

            }
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

