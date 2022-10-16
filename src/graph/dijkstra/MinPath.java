package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinPath {
    static int N = 6;
    static List<List<Node>> nodes = new ArrayList<>();
    static int[] answer = new int[N];
    static boolean[] visited = new boolean[N];
    static {
        for (int i = 0; i < N; i++) {
            nodes.add(new ArrayList<>());
        }
        Arrays.setAll(answer, a -> Integer.MAX_VALUE);
        nodes.get(5).add(new Node(1,1));
        nodes.get(1).add(new Node(2,2));
        nodes.get(1).add(new Node(3,3));
        nodes.get(2).add(new Node(3,4));
        nodes.get(2).add(new Node(4,5));
        nodes.get(3).add(new Node(4,6));

    }

    public static void main(String[] args) {
        answer[1] = 0;
        visited[1] = true;
        dijkstra(1,0);
        System.out.println(Arrays.toString(answer));
    }
    static void dijkstra(int i, int distance) {
        for(Node node : nodes.get(i)){
            if(! visited[node.idx]){
                visited[node.idx]=true;
                answer[node.idx] = Math.min(answer[node.idx], distance + node.distance);
                dijkstra(node.idx , answer[node.idx]);
                visited[node.idx]=false;

            }
        }
    }
}
class Node{
    int idx;
    int distance;

    public Node(int idx, int distance) {
        this.idx = idx;
        this.distance = distance;
    }
}