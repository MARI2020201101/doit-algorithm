package search.bfs;

import java.util.*;

class DiameterDfs {
    static List<List<Node>> tree = new ArrayList<>();
    static int N = 6;
    static int[] distance = new int[N];
    static boolean[] visitied = new boolean[N];
    static{
        tree.add(Collections.emptyList());
        tree.add(List.of(new Node(3,2)));
        tree.add(List.of(new Node(4,4)));
        tree.add(List.of(new Node(1,2), new Node(4,3)));
        tree.add(List.of(new Node(2,4),new Node(3,3), new Node(5,6)));
        tree.add(List.of(new Node(4,6)));
    }

    public static void main(String[] args) {
        int max = 0;
        for (int i = 1; i < N; i++) {
            diameter(i);
            max = Math.max(max, Arrays.stream(distance).max().getAsInt());
            Arrays.fill(distance, 0);
        }
        System.out.println("max="+max);
    }
    static void diameter(int start){
        for(Node node : tree.get(start)){
            if(! visitied[node.idx]){
                visitied[node.idx] = true;
                distance[node.idx] = distance[start] + node.value;
                diameter(node.idx);
            }

        }
    }
}
class Node{
    int idx;
    int value;

    public Node(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}