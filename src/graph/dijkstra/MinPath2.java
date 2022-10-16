package graph.dijkstra;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class MinPath2 {
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

    static void dijkstra(int i){
        for (Node node : nodes.get(i)){

        }
    }
}
