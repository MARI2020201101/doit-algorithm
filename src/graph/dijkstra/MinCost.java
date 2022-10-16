package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinCost {
    static int N = 6;
    static List<List<Node>> nodes = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;
    static boolean[] visited = new boolean[N];
    static {
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }
        nodes.get(1).add(new Node(2,2));
        nodes.get(1).add(new Node(3,3));
        nodes.get(1).add(new Node(4,1));
        nodes.get(1).add(new Node(5,10));
        nodes.get(2).add(new Node(4,2));
        nodes.get(3).add(new Node(4,1));
        nodes.get(3).add(new Node(5,1));
        nodes.get(4).add(new Node(5,3));
    }
    public static void main(String[] args) {
        visited[1] = true;
        dijkstra(1, 0);
        System.out.println("answer = "+ answer);
    }
    static void dijkstra(int i, int distance) {
        if(i == 5) {
            answer = Math.min(answer, distance);
            return;
        }
        for(Node node : nodes.get(i)){
            if(! visited[node.idx]){
                visited[node.idx]=true;
                dijkstra(node.idx , distance + node.distance);
                visited[node.idx] = false;
            }
        }
    }
}
