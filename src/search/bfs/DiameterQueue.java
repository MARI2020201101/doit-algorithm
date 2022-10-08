package search.bfs;

import java.util.*;

class DiameterQueue {
    static List<List<Node2>> tree = new ArrayList<>();
    static int N = 6;
    static int[] distance = new int[N];
    static boolean[] visitied = new boolean[N];
    static{
        tree.add(Collections.emptyList());
        tree.add(List.of(new Node2(3,2)));
        tree.add(List.of(new Node2(4,4)));
        tree.add(List.of(new Node2(1,2), new Node2(4,3)));
        tree.add(List.of(new Node2(2,4),new Node2(3,3), new Node2(5,6)));
        tree.add(List.of(new Node2(4,6)));
    }

    public static void main(String[] args) {
        diameter(2);
    }
    static void diameter(int start){
        Queue<Node2> queue = new LinkedList<>();
        visitied[start] = true;
        distance[start] = 0;
        for(Node2 nextNode : tree.get(start)){
            queue.add(nextNode);
        }
        while(! queue.isEmpty()){
            Node2 node = queue.poll();
            for(Node2 nextNode : tree.get(node.idx)){
                if(! visitied[nextNode.idx]){
                    visitied[nextNode.idx] = true;
                }
            }

        }
    }

}
class Node2{
    int idx;
    int value;

    public Node2(int idx, int value) {
        this.idx = idx;
        this.value = value;
    }
}